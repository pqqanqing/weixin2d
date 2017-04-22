package com.wjs.weixin2d.service.channel;

import cn.com.common.base.base.BasePageResults;
import cn.com.common.base.exception.BusinessExecption;
import cn.com.common.base.query.QueryService;
import com.wjs.weixin2d.api.dto.ChannelDTO;
import com.wjs.weixin2d.domain.channel.Channel;
import com.wjs.weixin2d.domain.channel.ChannelRpt;
import com.wjs.weixin2d.domain.provider.Provider;
import com.wjs.weixin2d.domain.provider.ProviderRpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ProviderRpt providerRpt;
    @Autowired
    private ChannelRpt channelRpt;
    @Autowired
    private QueryService queryService;

    @Override
    public ChannelDTO create(Long providerId, ChannelDTO channelDTO) {
        Provider provider = providerRpt.getById(providerId);
        Channel channel = new Channel(provider, channelDTO);
        channelRpt.save(channel);
        return (ChannelDTO) channel.makeDTO(ChannelDTO.class);
    }

    @Override
    public ChannelDTO generateQrCode(Long id) {
        Channel channel = channelRpt.getById(id);
        channel.createQrCode();
        return (ChannelDTO) channel.makeDTO(ChannelDTO.class);
    }

    @Override
    public BasePageResults<ChannelDTO> query(ChannelDTO channelDTO) {
        BasePageResults<ChannelDTO> channelDTOBasePageResults = queryService.queryDTO(channelDTO);
        return channelDTOBasePageResults;
    }

    @Override
    public ChannelDTO delete(Long id) {
        Channel channel = channelRpt.getById(id);
        if(isNull(channel)) throw new BusinessExecption("weixin2d8");
        channelRpt.delete(channel);
        return (ChannelDTO)channel.makeDTO(ChannelDTO.class);
    }
}
