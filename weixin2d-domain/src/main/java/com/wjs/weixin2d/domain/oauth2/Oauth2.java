package com.wjs.weixin2d.domain.oauth2;

import cn.com.common.base.base.BaseEntity;
import cn.com.common.base.exception.BusinessExecption;
import com.alibaba.fastjson.JSONObject;
import com.wjs.weixin2d.domain.config.oauth2.Oauth2Config;
import com.wjs.weixin2d.domain.provider.Provider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static cn.com.common.base.util.FreemarkerUtil.parseString4Map;
import static cn.com.common.base.util.HttpUtil2.doGet2;
import static com.wjs.weixin2d.common.constants.Oauth2Constant.OAUTH2_ACCESSTOKEN_URL;
import static com.wjs.weixin2d.common.constants.Oauth2Constant.OAUTH2_USERINFO_URL;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Setter
@Getter
@ToString
public class Oauth2 extends BaseEntity {

    private Provider provider;
    private Oauth2Config oauth2Config;
    private String codeUrl;
    private String code;
    private String state;
    private String accessTokenUrl;
    private String accessTokenJson;
    private String openId;
    private String accessToken;
    private String userinfoUrl;
    private String userinfoJson;

    public Oauth2() {
    }

    public Oauth2(Provider provider) {
        this.provider = provider;
    }

    public Oauth2(Oauth2Config oauth2Config) {
        this.oauth2Config = oauth2Config;
        this.provider = oauth2Config.getProvider();
    }

    public String obtainCodeUrl() {
        this.codeUrl = oauth2Config.obtainCodeUrl(id);
        return codeUrl;
    }

    public void setProperties(String code, String state) {
        check(code, state);
        this.code = code;
        this.state = state;
    }

    private void check(String code, String state) {
        if (isBlank(code)) {
            throw new BusinessExecption("weixin2d1");
        }
        if (!oauth2Config.equalState(state)) {
            throw new BusinessExecption("weixin2d2");
        }
    }

    public void obtainPageAccessToken() {
        Map<String, Object> params = generatePageAccessToken();
        this.accessTokenUrl = parseString4Map(OAUTH2_ACCESSTOKEN_URL, params);
        this.accessTokenJson = doGet2(accessTokenUrl);
        parseAccessTokenJson();
    }

    private void parseAccessTokenJson() {
        JSONObject jsonObject = JSONObject.parseObject(accessTokenJson);
        String accessToken = jsonObject.getString("access_token");
        String openId = jsonObject.getString("openid");
        if (isBlank(accessToken) || isBlank(openId)) {
            throw new BusinessExecption("weixin2d3");
        }
        this.accessToken = accessToken;
        this.openId = openId;
    }

    private Map<String, Object> generatePageAccessToken() {
        Map<String, Object> params = new HashMap<>(3);
        params.put("appId", provider.getAppId());
        params.put("secret", provider.getSecret());
        params.put("code", code);
        return params;
    }

    public void obtainUserinfo() {
        Map<String, Object> params = generateUserinfo();
        this.userinfoUrl = parseString4Map(OAUTH2_USERINFO_URL, params);
        String json = doGet2(userinfoUrl);
        //解决微信中文乱码
        try {
            this.userinfoJson = new String(json.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("微信中文乱码转换失败：" + e.getMessage(), e);
        }
    }

    private Map<String, Object> generateUserinfo() {
        Map<String, Object> params = new HashMap<>(2);
        params.put("accessToken", accessToken);
        params.put("openId", openId);
        return params;
    }


    public String getCallback() {
        return oauth2Config.getCallback() + "?openId=" + openId;
    }

    public Long getProviderId() {
        return provider.getId();
    }
}
