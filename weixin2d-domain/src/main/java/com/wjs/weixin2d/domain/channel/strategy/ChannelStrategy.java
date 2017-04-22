package com.wjs.weixin2d.domain.channel.strategy;

import cn.com.common.base.base.BaseEntity;
import cn.com.common.base.exception.BusinessExecption;
import com.alibaba.fastjson.JSONObject;
import com.wjs.weixin2d.domain.qrcode.QrCode;

import java.util.Map;

import static cn.com.common.base.util.FreemarkerUtil.parseString4Map;
import static cn.com.common.base.util.HttpUtil2.doPost;
import static com.wjs.weixin2d.common.constants.QrCodeConstant.CREATE_QRCODE_TICKET;
import static java.util.Objects.nonNull;

public abstract class ChannelStrategy extends BaseEntity {

    public QrCode createQrCodeTicketTemplate(Map<String, Object> params) {
        // 1:post请求获取数据
        String createQrcodeTicketUrl = parseString4Map(CREATE_QRCODE_TICKET, params);
        String postJsonData = requestQrCodeTicketJson(params);

        String response = doPost(createQrcodeTicketUrl, postJsonData);
        // 2:check数据
        JSONObject jsonObject = JSONObject.parseObject(response);
        String errcode = jsonObject.getString("errcode");
        if (nonNull(errcode)) throw new BusinessExecption("weixin2d9", errcode);

        // 3:获取二维码地址
        QrCode qrCode = generateQrCode(jsonObject);
        return qrCode;
    }

    public abstract String requestQrCodeTicketJson(Map<String, Object> params);

    protected abstract QrCode generateQrCode(JSONObject ticketJson);
}
