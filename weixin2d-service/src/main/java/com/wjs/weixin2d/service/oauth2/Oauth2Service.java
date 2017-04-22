package com.wjs.weixin2d.service.oauth2;

import com.wjs.weixin2d.domain.oauth2.Oauth2;

public interface Oauth2Service {

    String obtainCodeUrl(Long providerId, Oauth2Service oauth2Service);

    Oauth2 create(Long providerId);

    String obtainCodeUrl(Long id);

    String callback(Long oauthId, String code, String state);
}
