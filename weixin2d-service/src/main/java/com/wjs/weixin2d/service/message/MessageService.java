package com.wjs.weixin2d.service.message;

import com.wjs.weixin2d.api.dto.MessageDTO;

import java.util.List;
import java.util.Map;

public interface MessageService {
    void receive(Map<String, Object> params);

    List<MessageDTO> lists();
}
