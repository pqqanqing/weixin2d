package com.wjs.weixin2d.domain.config.oauth2;


import com.wjs.common.base.base.BaseEntity;
import com.wjs.weixin2d.domain.provider.Provider;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

import static com.wjs.common.base.util.FreemarkerUtil.parseString4Map;
import static com.wjs.weixin2d.common.constants.Oauth2Constant.OAUTH2_AUTHORIZE_URL;
import static com.wjs.weixin2d.common.help.UrlHelp.urlEncode;

@Setter
@Getter
public class Oauth2Config extends BaseEntity {

    private Provider provider;

    private String callback;
    private String scope;
    private String state;
    private String redirectUri;

    public Oauth2Config() {
    }

    public String obtainCodeUrl(Long id) {
        Map<String, Object> params = generateCode(id);
        String url = parseString4Map(OAUTH2_AUTHORIZE_URL, params);
        return url;
    }

    private Map<String, Object> generateCode(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("appId", provider.getAppId());
        map.put("redirectUri", generateRedirectUri(id));
        map.put("scope", scope);
        map.put("state", state);
        return map;
    }

    private String generateRedirectUri(Long id) {
        String url = this.redirectUri + "/" + id + "/code";
        String urlEncode = urlEncode(url);
        return urlEncode;
    }

    public boolean equalState(String state) {
        return this.state.equals(state);
    }
}
