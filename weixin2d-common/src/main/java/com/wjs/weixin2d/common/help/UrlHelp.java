package com.wjs.weixin2d.common.help;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlHelp {

    public static String urlEncode(String url) {
        try {
            String urlEncode = URLEncoder.encode(url, "UTF-8");
            return urlEncode;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("对url:" + url + "进行urlEncode异常:" + e.getMessage(), e);
        }
    }
}
