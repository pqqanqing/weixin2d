package com.wjs.weixin2d.domain.message;

import cn.com.common.base.annotation.StatusAndClassNum;
import com.wjs.weixin2d.domain.config.message.MessageConfig;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static com.wjs.weixin2d.api.dto.MessageDTO.TYPE_EVENT_SCAN;

@Setter
@Getter
@StatusAndClassNum(superClass = Message.class, number = TYPE_EVENT_SCAN, describe = "二维码消息", parasitClass = Message.class)
public class Message4QrCode extends Message {

    private String eventKey;
    private String ticket;

    public Message4QrCode() {
    }

    public Message4QrCode(MessageConfig messageConfig, Map<String, Object> params) {
        super(messageConfig, params);
    }

    @Override
    protected void parseSpecialParams(Map<String, Object> params) {
        this.eventKey = (String) params.get("eventKey");
        this.ticket = (String) params.get("ticket");
    }
}
