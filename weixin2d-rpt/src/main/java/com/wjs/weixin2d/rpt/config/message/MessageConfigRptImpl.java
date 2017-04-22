package com.wjs.weixin2d.rpt.config.message;

import cn.com.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.config.message.MessageConfig;
import com.wjs.weixin2d.domain.config.message.MessageConfigRpt;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class MessageConfigRptImpl extends BaseRptImpl<MessageConfig, Serializable> implements MessageConfigRpt {

    @Override
    public MessageConfig queryByMsgTypeAndEventType(String msgType, String event) {
        Query query = getSession().createQuery("from MessageConfig mc where mc.msgType = :msgType and mc.eventType = :eventType");
        query.setParameter("msgType", msgType);
        query.setParameter("eventType", event);
        return (MessageConfig) query.uniqueResult();
    }
}
