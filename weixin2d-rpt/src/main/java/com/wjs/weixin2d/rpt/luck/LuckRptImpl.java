package com.wjs.weixin2d.rpt.luck;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.luck.Luck;
import com.wjs.weixin2d.domain.luck.LuckRpt;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public class LuckRptImpl extends BaseRptImpl<Luck, Serializable> implements LuckRpt{
}
