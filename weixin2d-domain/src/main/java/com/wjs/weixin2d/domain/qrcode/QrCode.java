package com.wjs.weixin2d.domain.qrcode;

import com.wjs.common.base.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

import static com.wjs.common.base.util.FreemarkerUtil.parseString4Map;
import static com.wjs.weixin2d.common.constants.QrCodeConstant.TICKET_EXCHANGE_QRCODE;

@Setter
@Getter
@ToString
public abstract class QrCode extends BaseEntity {

    protected String ticket;
    protected String url;
    protected String qrCodeUrl;

    public QrCode() {
    }

    public QrCode(String ticket, String url) {
        this.ticket = ticket;
        this.url = url;
        Map<String, Object> urlMap = new HashMap<>(1);
        urlMap.put("ticket", ticket);
        this.qrCodeUrl = parseString4Map(TICKET_EXCHANGE_QRCODE, urlMap);
    }
}
