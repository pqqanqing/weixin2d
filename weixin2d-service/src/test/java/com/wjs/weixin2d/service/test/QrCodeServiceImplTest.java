package com.wjs.weixin2d.service.test;

import com.wjs.common.base.base.BasePageResults;
import com.wjs.common.base.query.QueryService;
import com.alibaba.fastjson.JSONObject;
import com.wjs.weixin2d.api.dto.ChannelDTO;
import com.wjs.weixin2d.domain.channel.Channel;
import com.wjs.weixin2d.service.channel.ChannelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class QrCodeServiceImplTest {
    @Autowired
    private ChannelService channelService;
    @Autowired
    private QueryService queryService;

    @Test
    public void create() {
        /*Long providerId = 1L;
        ChannelDTO channelDTO = new ChannelDTO();
        channelDTO.setSceneId(10);
        channelDTO.setSceneStr("sceneStr002");
//        ChannelStrategyDTO channelStrategyDTO = new ChannelStrategyDTO();
        //channelDTO.setChannelStrategyDTO(channelStrategyDTO);

        ChannelDTO channelDTO2 = channelService.create(providerId, channelDTO);*/
        System.out.println(1);
    }

    @Test
    public void generateQrCode() {
        Long providerId = 1L;

        ChannelDTO channelDTO = channelService.generateQrCode(providerId);
    }

    @Test
    public void deleteChannel() {
        Long channelId = 1L;

        ChannelDTO channelDTO = channelService.delete(channelId);
    }

    @Test
    public void testQuery(){
        ChannelDTO channelDTO = new ChannelDTO();

        BasePageResults<ChannelDTO> basePageResults = queryService.queryDTO(channelDTO);
        System.out.println(basePageResults);
    }
}
