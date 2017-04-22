package com.wjs.weixin2d.rpt.provider;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.provider.Provider;
import com.wjs.weixin2d.domain.provider.ProviderRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class ProviderRptImpl extends BaseRptImpl<Provider, Serializable> implements ProviderRpt {
}
