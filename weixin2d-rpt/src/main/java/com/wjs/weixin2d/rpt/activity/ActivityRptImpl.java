package com.wjs.weixin2d.rpt.activity;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.activity.Activity;
import com.wjs.weixin2d.domain.activity.ActivityRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class ActivityRptImpl extends BaseRptImpl<Activity, Serializable> implements ActivityRpt {
}
