package com.wjs.weixin2d.common.constants;

import java.util.HashMap;
import java.util.Map;

public class JsapiTicketConstant {

    /**
     * 获取jsapi_ticket
     */
    public static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=${accessToken}&type=jsapi";

    /**
     * 签名串
     */
    public static final String JSAPI_SIGNATURE = "jsapi_ticket=${jsapiTicket}&noncestr=${noncestr}&timestamp=${timestamp}&url=${url}";

    /**
     * 暂时不用缓存和定时器来存储ticket值
     */
    public static Map<String, String> map = new HashMap<>(2);

    public static Map<String, String> getMap() {
        return map;
    }
}
