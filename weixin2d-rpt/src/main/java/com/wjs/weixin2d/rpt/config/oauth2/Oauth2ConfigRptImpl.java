package com.wjs.weixin2d.rpt.config.oauth2;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.config.oauth2.Oauth2Config;
import com.wjs.weixin2d.domain.config.oauth2.Oauth2ConfigRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Oauth2ConfigRptImpl extends BaseRptImpl<Oauth2Config, Serializable> implements Oauth2ConfigRpt {
}
