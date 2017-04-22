package com.wjs.weixin2d.rpt.qrCode;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.qrcode.QrCode;
import com.wjs.weixin2d.domain.qrcode.QrCodeRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class QrCodeRptImpl extends BaseRptImpl<QrCode, Serializable> implements QrCodeRpt {
}
