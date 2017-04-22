package com.wjs.weixin2d.api.dto;

import com.wjs.common.base.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ChannelDTO extends BaseDTO {

    /**
     * 永久策略
     */
    public static final String STRATEGY_EVERLAST = "1";

    private ProviderDTO provider;
    private QrCodeDTO qrCode;

    /**
     * 1:永久
     */
    private String channelStrategyVal = STRATEGY_EVERLAST;

    private Integer sceneId;
    /**
     * 场景值
     */
    private String sceneStr;
    /**
     * 场景1
     */
    private String scene1;
    /**
     * 场景2
     */
    private String scene2;
    /**
     * 场景3
     */
    private String scene3;
    /**
     * 场景4
     */
    private String scene4;
    /**
     * 场景5
     */
    private String scene5;

    public ChannelDTO() {
    }

}
