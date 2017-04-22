package com.wjs.weixin2d.common.constants;

public class Oauth2Constant {
    /**
     * 第一步:用户同意授权，获取code的微信url,在微信浏览器里面直接打开
     */
    public static final String OAUTH2_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appId}&redirect_uri=${redirectUri}&response_type=code&scope=${scope}&state=${state}#wechat_redirect";
    /**
     * 第二步:通过code换取网页授权access_token
     */
    public static final String OAUTH2_ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=${appId}&secret=${secret}&code=${code}&grant_type=authorization_code";
    /**
     * 第三步:刷新access_token（如果需要）
     */
    public static final String OAUTH2_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=${appId}&grant_type=refresh_token&refresh_token=${refreshToken}";
    /**
     * 第四步:拉取用户信息(需scope为 snsapi_userinfo)
     */
    public static final String OAUTH2_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=${accessToken}&openid=${openId}&lang=zh_CN";

}
