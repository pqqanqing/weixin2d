package com.wjs.weixin2d.rpt.oauth2;

import cn.com.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.oauth2.Oauth2;
import com.wjs.weixin2d.domain.oauth2.Oauth2Rpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Oauth2RptImpl extends BaseRptImpl<Oauth2, Serializable> implements Oauth2Rpt {
}
