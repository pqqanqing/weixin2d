package com.wjs.weixin2d.service.jssdk;

import com.wjs.common.base.execption.BusinessExecption;
import com.alibaba.fastjson.JSONObject;
import com.wjs.weixin2d.common.constants.JsapiTicketConstant;
import com.wjs.weixin2d.common.util.SignUtil;
import com.wjs.weixin2d.domain.provider.Provider;
import com.wjs.weixin2d.domain.provider.ProviderRpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.wjs.common.base.util.FreemarkerUtil.parseString4Map;
import static com.wjs.common.base.util.HttpUtil2.doGet2;
import static com.alibaba.fastjson.JSON.parseObject;
import static com.wjs.weixin2d.common.constants.JsapiTicketConstant.JSAPI_TICKET_URL;
import static com.wjs.weixin2d.common.constants.TokenConstant.ACCESS_TOKEN_URL_51;

@Service
public class JsSdkServiceImpl implements JsSdkService {

    @Autowired
    private ProviderRpt providerRpt;

    @Override
    @Transactional
    public Map<String, Object> config(Long providerId, String url) {
        Provider provider = providerRpt.getById(providerId);
        Map<String, Object> map = assembleJsSdkMap(url);
        map.put("appId", provider.getAppId());
        return map;
    }

    private Map<String, Object> assembleJsSdkMap(String url) {
        Map<String, Object> map = new HashMap<>();
        String noncestr = UUID.randomUUID().toString();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        String signature = getSignature(noncestr, timestamp, url);
        map.put("timestamp", timestamp);
        map.put("nonceStr", noncestr);
        map.put("signature", signature);
        return map;
    }

    private String getSignature(String noncestr, String timestamp, String url) {
        Map<String, Object> map = new HashMap<>();
        String ticket = getTicket();
        map.put("jsapiTicket", ticket);
        map.put("noncestr", noncestr);
        map.put("timestamp", timestamp);
        map.put("url", url);
        String original = parseString4Map(JsapiTicketConstant.JSAPI_SIGNATURE, map);
        String signature = SignUtil.getSignature(original);
        return signature;
    }

    private String getTicket() {
        String token = doGet2(ACCESS_TOKEN_URL_51);
        Map<String, String> jssdkMap = JsapiTicketConstant.getMap();
        return token.equals(jssdkMap.get("token")) ? jssdkMap.get("ticket") : obtainTicket(token);
    }

    private String obtainTicket(String token) {
        Map<String, Object> map = new HashMap<>();
        map.put("accessToken", token);
        JSONObject jsonObject = parseObject(doGet2(parseString4Map(JSAPI_TICKET_URL, map)));
        checkJson(jsonObject);
        String ticket = jsonObject.getString("ticket");
        JsapiTicketConstant.getMap().put("token", token);
        JsapiTicketConstant.getMap().put("ticket", ticket);
        return ticket;
    }

    private void checkJson(JSONObject jsonObject) {
        String errmsg = jsonObject.getString("errmsg");
        if (!"ok".equals(errmsg)) throw new BusinessExecption("weixin2d11", errmsg);
    }
}
