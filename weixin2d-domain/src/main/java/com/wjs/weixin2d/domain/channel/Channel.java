package com.wjs.weixin2d.domain.channel;

import com.wjs.common.base.annotation.StatusAndClassNum;
import com.wjs.common.base.base.BaseEntity;
import com.wjs.common.base.util.ScanClassUtil;
import com.wjs.weixin2d.api.dto.ChannelDTO;
import com.wjs.weixin2d.domain.channel.strategy.ChannelStrategy;
import com.wjs.weixin2d.domain.provider.Provider;
import com.wjs.weixin2d.domain.qrcode.QrCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

import static com.wjs.common.base.util.HttpUtil2.doGet2;
import static com.wjs.weixin2d.common.constants.QrCodeConstant.ACCESS_TOKEN_URL;

@Setter
@Getter
public class Channel extends BaseEntity {

    private Provider provider;
    private Integer sceneId;
    private String sceneStr;
    private ChannelStrategy channelStrategy;
    private QrCode qrCode;
    private String scene1;
    private String scene2;
    private String scene3;
    private String scene4;
    private String scene5;
    private String channelStrategyVal;

    public Channel() {

    }

    public Channel(Provider provider, ChannelDTO channelDTO) {
        this.provider = provider;
        this.channelStrategy = (ChannelStrategy) ScanClassUtil.getStatusMap().get(Channel.class + channelDTO.getChannelStrategyVal());
        setProperties(channelDTO);
    }

    private void setProperties(ChannelDTO channelDTO) {
        this.name = channelDTO.getName();
        this.memo = channelDTO.getMemo();
        this.scene1 = channelDTO.getScene1();
        this.scene2 = channelDTO.getScene2();
        this.scene3 = channelDTO.getScene3();
        this.scene4 = channelDTO.getScene4();
        this.scene5 = channelDTO.getScene5();
    }

    public void createQrCode() {
        this.sceneStr = id.toString();
        Map<String, Object> params = new HashMap<>(5);
        String accessToken = doGet2(ACCESS_TOKEN_URL);
        params.put("accessToken", accessToken);
        params.put("sceneStr", this.sceneStr);
        this.qrCode = channelStrategy.createQrCodeTicketTemplate(params);
    }

    public String getChannelStrategyVal() {
        StatusAndClassNum annotation = getStatusAndClassNumAnnotation(ChannelStrategy.class);
        return annotation == null ? null : annotation.number();
    }

}
