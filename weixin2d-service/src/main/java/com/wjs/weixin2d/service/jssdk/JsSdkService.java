package com.wjs.weixin2d.service.jssdk;

import java.util.Map;

public interface JsSdkService {

    Map<String, Object> config(Long providerId, String url);
}
