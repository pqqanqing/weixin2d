package com.wjs.weixin2d.domain.provider;

import cn.com.common.base.base.BaseEntity;
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
