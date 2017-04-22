package com.wjs.weixin2d.api.dto;

import com.wjs.common.base.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProviderDTO extends BaseDTO {
    private String callback;
    private String appId;
    private String secret;
    private String scope;
    private String state;
    private String redirectUri;
}
