package com.wjs.weixin2d.outrpc.controller;

import com.wjs.common.base.rpc.RpcResponse;
import com.wjs.weixin2d.api.dto.LuckDTO;
import com.wjs.weixin2d.service.luck.LuckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@Controller
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private LuckService luckService;

    @RequestMapping(value = "/luck", method = POST)
    @ResponseBody
    public RpcResponse<LuckDTO> luck(@RequestBody LuckDTO luckDTO) {
        return new RpcResponse<>(luckService.save(luckDTO));
    }
}
