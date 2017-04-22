package com.wjs.weixin2d.api.dto;

import com.wjs.common.base.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QrCodeDTO extends BaseDTO {
    private String ticket;
    private String url;
    private String qrCodeUrl;
}
