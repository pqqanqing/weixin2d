package com.wjs.weixin2d.outrpc.controller;

import com.wjs.common.base.rpc.RpcResponse;
import com.wjs.weixin2d.api.dto.MessageDTO;
import com.wjs.weixin2d.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public RpcResponse receive(@RequestBody Map<String, Object> params) {
        messageService.receive(params);
        return new RpcResponse<>();
    }

    @RequestMapping(value = "/lists", method = RequestMethod.POST)
    @ResponseBody
    public RpcResponse<List<MessageDTO>> lists() {
        return new RpcResponse<>(messageService.lists());
    }



    /*@RequestMapping(value = "/receive", method = RequestMethod.GET)
    public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
    }

    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public void receiveMessage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        try {
            Map<String, Object> stringStringMap = MessageUtil.parseXml(request);
            messageService.receive(stringStringMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


}
