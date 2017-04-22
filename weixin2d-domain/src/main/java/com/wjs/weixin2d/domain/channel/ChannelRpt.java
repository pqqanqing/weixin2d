package com.wjs.weixin2d.domain.channel;

import cn.com.common.base.rpt.BaseRpt;
import java.io.Serializable;

public interface ChannelRpt extends BaseRpt<Channel, Serializable>{

    Channel queryBySceneStr(String sceneStr);
}
