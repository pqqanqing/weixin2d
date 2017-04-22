package com.wjs.weixin2d.outrpc.controller;

import cn.com.common.base.rpc.RpcResponse;
import com.wjs.weixin2d.service.jssdk.JsSdkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/jssdk")
public class JsSdkController {

    @Autowired
    private JsSdkService jsSdkService;

    @RequestMapping(value = "/{providerId}", method = RequestMethod.GET)
    @ResponseBody
    public RpcResponse<Map<String, Object>> config(@PathVariable Long providerId, @RequestParam String url) {
        try {
            return new RpcResponse<>(jsSdkService.config(providerId, url));
        } catch (Throwable t) {
            return new RpcResponse<>(t);
        }
    }
}
