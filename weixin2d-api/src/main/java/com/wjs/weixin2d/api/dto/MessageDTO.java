package com.wjs.weixin2d.api.dto;

import cn.com.common.base.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageDTO extends BaseDTO {

    /**
     * 二维码事件
     */
    public static final String TYPE_EVENT_SCAN = "event_SCAN";

    private String fromUserName;
    private String toUserName;
    private Long wxCreateTime;
    private String eventKey;
    private String ticket;

    public MessageDTO() {
    }
}
