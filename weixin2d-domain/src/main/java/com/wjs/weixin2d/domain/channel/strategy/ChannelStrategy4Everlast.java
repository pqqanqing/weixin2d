package com.wjs.weixin2d.domain.channel.strategy;

import cn.com.common.base.annotation.StatusAndClassNum;
import com.alibaba.fastjson.JSONObject;
import com.wjs.weixin2d.api.dto.ChannelDTO;
import com.wjs.weixin2d.domain.channel.Channel;
import com.wjs.weixin2d.domain.qrcode.QrCode;
import com.wjs.weixin2d.domain.qrcode.QrCode4Everlast;

import java.util.Map;

import static cn.com.common.base.util.FreemarkerUtil.parseString4Map;
import static com.wjs.weixin2d.common.constants.QrCodeConstant.JSON_4_QRCODE_TICKET;

@StatusAndClassNum(superClass = ChannelStrategy.class, number = ChannelDTO.STRATEGY_EVERLAST, describe = "生成永久二维码", parasitClass = Channel.class)
public class ChannelStrategy4Everlast extends ChannelStrategy {

    @Override
    public String requestQrCodeTicketJson(Map<String, Object> params) {
        return parseString4Map(JSON_4_QRCODE_TICKET, params);
    }

    @Override
    protected QrCode generateQrCode(JSONObject jsonObject) {
        String ticket = jsonObject.getString("ticket");
        String url = jsonObject.getString("url");
        QrCode qrCode = new QrCode4Everlast(ticket, url);
        return qrCode;
    }
}
