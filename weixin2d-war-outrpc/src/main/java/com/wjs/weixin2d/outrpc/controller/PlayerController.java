package com.wjs.weixin2d.outrpc.controller;

import com.wjs.common.base.base.BasePageResults;
import com.wjs.common.base.query.QueryService;
import com.wjs.common.base.rpc.RpcResponse;
import com.wjs.weixin2d.api.dto.PlayerDTO;
import com.wjs.weixin2d.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/games", method = RequestMethod.POST)
    @ResponseBody
    public RpcResponse<PlayerDTO> createOrUpdate(@RequestBody PlayerDTO playerDTO) {
        try {
            return new RpcResponse<>(playerService.createOrUpdate(1L, playerDTO));
        } catch (Throwable throwable) {
            return new RpcResponse<>(throwable);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public RpcResponse<BasePageResults<PlayerDTO>> query(@RequestBody PlayerDTO playerDTO) {
        try {
            return new RpcResponse<>(queryService.queryDTO(playerDTO));
        } catch (Throwable throwable) {
            return new RpcResponse<>(throwable);
        }
    }

    @RequestMapping(value = "/counts", method = RequestMethod.GET)
    @ResponseBody
    public RpcResponse<Integer> counts() {
        try {
            return new RpcResponse(playerService.counts(1L));
        } catch (Throwable throwable) {
            return new RpcResponse<>(throwable);
        }
    }

    @RequestMapping(value = "/rank/{phone}", method = RequestMethod.GET)
    @ResponseBody
    public RpcResponse<Integer> rankByPhone(@PathVariable String phone) {
        try {
            return new RpcResponse(playerService.rankByPhone(1L, phone));
        } catch (Throwable throwable) {
            return new RpcResponse<>(throwable);
        }
    }

    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    @ResponseBody
    public RpcResponse<List<PlayerDTO>> rank() {
        try {
            return new RpcResponse(playerService.rank(1L));
        } catch (Throwable throwable) {
            return new RpcResponse<>(throwable);
        }
    }

}
