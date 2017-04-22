package com.wjs.weixin2d.service.message;

import cn.com.common.base.exception.BusinessExecption;
import com.wjs.weixin2d.api.dto.MessageDTO;
import com.wjs.weixin2d.domain.config.message.MessageConfig;
import com.wjs.weixin2d.domain.config.message.MessageConfigRpt;
import com.wjs.weixin2d.domain.message.Message;
import com.wjs.weixin2d.domain.message.MessageRpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageConfigRpt messageConfigRpt;

    @Autowired
    private MessageRpt messageRpt;

    @Override
    @Transactional
    public void receive(Map<String, Object> params) {
        String msgType = (String) params.get("msgType");
        String event = (String) params.get("event");
        if (isBlank(msgType)) throw new BusinessExecption("weixin2d4");
        MessageConfig messageConfig = messageConfigRpt.queryByMsgTypeAndEventType(msgType, event);
        if (isNull(messageConfig)) return;
        Message message = messageConfig.createMessage(params);
        if (Objects.nonNull(message)) messageRpt.save(message);
    }

    @Override
    @Transactional
    public List<MessageDTO> lists() {
        List<Message> messages = messageRpt.queryList();
        List<MessageDTO> messageDTOS = new ArrayList<>();
        messages.stream().forEach(message -> {
            messageDTOS.add((MessageDTO) message.makeDTO(MessageDTO.class));
        });
        return messageDTOS;
    }


}
