package com.wjs.weixin2d.domain.provider;

import com.wjs.common.base.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Provider extends BaseEntity {
    private String appId;
    private String secret;

    public Provider() {
    }
}
