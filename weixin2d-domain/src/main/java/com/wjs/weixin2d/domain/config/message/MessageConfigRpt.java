package com.wjs.weixin2d.domain.config.message;

import com.wjs.common.base.rpt.BaseRpt;

import java.io.Serializable;

public interface MessageConfigRpt extends BaseRpt<MessageConfig, Serializable> {
    MessageConfig queryByMsgTypeAndEventType(String msgType, String event);
}
