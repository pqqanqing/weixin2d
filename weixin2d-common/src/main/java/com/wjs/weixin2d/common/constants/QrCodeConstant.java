package com.wjs.weixin2d.common.constants;

public class QrCodeConstant {
    /**
     * 第一步:获取access_token
     */
    public static final String ACCESS_TOKEN_URL = "http://wechatfw-callback.crm.yinli99.com/fw/accesstoken";

    /**
     * 第二步:创建二维码ticket(post提交)
     */
    public static final String CREATE_QRCODE_TICKET = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=${accessToken}";

    /**
     * 创建三维码ticket请求数据
     */
    public static final String JSON_4_QRCODE_TICKET = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"${sceneStr}\"}}}";

    /**
     * 第四步:通过ticket换取二维码(get提交)
     */
    public static final String TICKET_EXCHANGE_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=${ticket}";

}
