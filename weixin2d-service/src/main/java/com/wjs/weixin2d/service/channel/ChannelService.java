package com.wjs.weixin2d.service.channel;

import cn.com.common.base.base.BasePageResults;
import com.wjs.weixin2d.api.dto.ChannelDTO;

public interface ChannelService {
   ChannelDTO create(Long providerId, ChannelDTO channelDTO);

   ChannelDTO generateQrCode(Long id);

   BasePageResults<ChannelDTO> query(ChannelDTO channelDTO);

   ChannelDTO delete(Long id);
}
