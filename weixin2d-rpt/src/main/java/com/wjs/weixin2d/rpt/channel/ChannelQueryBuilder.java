package com.wjs.weixin2d.rpt.channel;


import cn.com.common.base.base.BaseQueryBuilder;
import com.wjs.weixin2d.domain.channel.Channel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("channelQueryBuilder")
@Scope("prototype")
public class ChannelQueryBuilder extends BaseQueryBuilder<Channel> {
}
