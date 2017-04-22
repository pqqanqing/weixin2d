package com.wjs.weixin2d.domain.message;


import com.wjs.common.base.base.BaseEntity;
import com.wjs.weixin2d.domain.config.message.MessageConfig;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public abstract class Message extends BaseEntity {

    protected MessageConfig messageConfig;
    protected Map<String, Object> params = new HashMap<>();
    protected String fromUserName;
    protected String toUserName;
    protected Long wxCreateTime;

    public Message() {

    }

    public Message(MessageConfig messageConfig, Map<String, Object> params) {
        this.messageConfig = messageConfig;
        this.params = params;
        parseParams(params);
    }

    protected void parseParams(Map<String, Object> params) {
        this.fromUserName = (String) params.get("fromUserName");
        this.toUserName = (String) params.get("toUserName");
        this.wxCreateTime = (Long) params.get("createTime");
        parseSpecialParams(params);
    }

    protected abstract void parseSpecialParams(Map<String, Object> params);
}
