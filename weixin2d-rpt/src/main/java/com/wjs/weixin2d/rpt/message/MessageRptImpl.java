package com.wjs.weixin2d.rpt.message;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.message.Message;
import com.wjs.weixin2d.domain.message.MessageRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class MessageRptImpl extends BaseRptImpl<Message, Serializable> implements MessageRpt {
}
