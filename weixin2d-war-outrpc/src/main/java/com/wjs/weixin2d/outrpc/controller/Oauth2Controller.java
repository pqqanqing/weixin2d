package com.wjs.weixin2d.outrpc.controller;


import com.wjs.weixin2d.service.oauth2.Oauth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@Controller
@RequestMapping("/oauth2")
public class Oauth2Controller {

    @Autowired
    private Oauth2Service oauth2Service;

    @RequestMapping(value = "/{oauth2ConfigId}", method = RequestMethod.GET)
    public RedirectView obtainCode(@PathVariable Long oauth2ConfigId) {
        String url = oauth2Service.obtainCodeUrl(oauth2ConfigId, oauth2Service);
        return new RedirectView(url);
    }

    @RequestMapping(value = "/{oauthId}/code", method = RequestMethod.GET)
    public RedirectView callback(@PathVariable Long oauthId, HttpServletRequest request) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String url = oauth2Service.callback(oauthId, code, state);
        return new RedirectView(url);
    }

}
