package com.wjs.weixin2d.outrpc.controller;

import com.wjs.common.base.base.BasePageResults;
import com.wjs.common.base.query.QueryService;
import com.wjs.common.base.rpc.RpcResponse;
import com.wjs.weixin2d.api.dto.ChannelDTO;
import com.wjs.weixin2d.service.channel.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@Controller
@RequestMapping("/qrCode")
public class QrCodeController {

    @Autowired
    private ChannelService channelService;

    @RequestMapping(value = "/channle/{providerId}", method = POST)
    @ResponseBody
    public RpcResponse<ChannelDTO> channle(@PathVariable Long providerId, @RequestBody ChannelDTO channelDTO) {
        return new RpcResponse(channelService.create(providerId, channelDTO));
    }

    @RequestMapping(value = "/{channelId}", method = POST)
    @ResponseBody
    public RpcResponse<ChannelDTO> generateQrCode(@PathVariable Long channelId) {
        return new RpcResponse(channelService.generateQrCode(channelId));
    }

    @RequestMapping(value = "/channles", method = POST)
    @ResponseBody
    public RpcResponse<BasePageResults<ChannelDTO>> queryTopics(@RequestBody ChannelDTO channelDTO) {
        return new RpcResponse<>(channelService.query(channelDTO));
    }
}
