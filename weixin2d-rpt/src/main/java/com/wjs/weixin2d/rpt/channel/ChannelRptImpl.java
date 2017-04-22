package com.wjs.weixin2d.rpt.channel;

import cn.com.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.domain.channel.Channel;
import com.wjs.weixin2d.domain.channel.ChannelRpt;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public class ChannelRptImpl extends BaseRptImpl<Channel, Serializable> implements ChannelRpt {
    @Override
    public Channel queryBySceneStr(String sceneStr) {
        Query query = getSession().createQuery("from Channel c where c.sceneStr = :sceneStr");
        query.setParameter("sceneStr", sceneStr);
        return (Channel) query.uniqueResult();
    }
}
;