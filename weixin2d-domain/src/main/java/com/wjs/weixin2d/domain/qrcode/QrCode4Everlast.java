package com.wjs.weixin2d.domain.qrcode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QrCode4Everlast extends QrCode {

    public QrCode4Everlast() {
    }

    public QrCode4Everlast(String ticket, String url) {
        super(ticket, url);
    }
}
