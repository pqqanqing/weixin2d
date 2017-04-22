package com.wjs.weixin2d.domain.config.message;

import cn.com.common.base.base.BaseEntity;
import cn.com.common.base.exception.BusinessExecption;
import cn.com.common.base.util.HttpUtil2;
import cn.com.common.base.util.ScanClassUtil;
import com.wjs.weixin2d.domain.message.Message;
import com.wjs.weixin2d.domain.message.Message4QrCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static cn.com.common.base.util.FreemarkerUtil.parseString4Map;
import static cn.com.common.base.util.HttpUtil2.doGet2;
import static com.wjs.weixin2d.common.constants.QrCodeConstant.ACCESS_TOKEN_URL;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;

@Setter
@Getter
public class MessageConfig extends BaseEntity {

    private String msgType;
    private String eventType;

    public MessageConfig() {
    }

    public Message createMessage(Map<String, Object> params) {
        String key = msgType;
        //比较特殊的情况
        String eventKey = (String) params.get("eventKey");
        if ("subscribe".equals(eventType) && isNoneBlank(eventKey)) {
            return new Message4QrCode(this, params);
        } else if ("subscribe".equals(eventType) && isBlank(eventKey)) {
            // TODO: 2017/4/19  这个地方先应急这么写,后面有时间再修改
            // 关注事件
            String fromUserName = (String) params.get("fromUserName");
            String accessToken = doGet2(ACCESS_TOKEN_URL);
            String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
            String requestParams = "{\n" +
                    "    \"touser\": \"${openId}\",\n" +
                    "    \"msgtype\": \"text\",\n" +
                    "    \"text\": {\n" +
                    "        \"content\": \"Hi，您终于来啦！\\n \\n'51钱币'将为您提供最新的行业资讯、最全的钱币知识、最深的专家解读，在这里，跟我们一起玩赚钱币！\\n \\n点击【微官网】 开户、查看行情、联系客服、下载APP等，您要的服务都在这里\\n \\n点击【互动交流】 进入钱吧和藏友一起交流钱币收藏、赚钱妙招，还可以获得最新专家资讯\\n \\n点击【最新活动】 查看您能参加的的福利活动\\n \\n玩钱，我们是专业的！\"\n" +
                    "    }\n" +
                    "}";
            Map<String, Object> map = new HashMap<>();
            map.put("openId", fromUserName);
            String s = parseString4Map(requestParams, map);
            HttpUtil2.doPost(url, s);
            return null;
        } else {
            key += "_" + eventType;
            Message message = (Message) ScanClassUtil.getClassMap().get(Message.class + key);
            try {
                Constructor<? extends Message> constructor = message.getClass().getDeclaredConstructor(MessageConfig.class, Map.class);
                return constructor.newInstance(this, params);
            } catch (Exception e) {
                throw new BusinessExecption("weixin2d5", msgType);
            }
        }
    }
}
