package com.wjs.weixin2d.service.oauth2;

import com.alibaba.fastjson.JSONObject;
import com.wjs.mb.api.dto.MemberDTO;
import com.wjs.mb.api.facade.MbFacade;
import com.wjs.weixin2d.domain.config.oauth2.Oauth2Config;
import com.wjs.weixin2d.domain.config.oauth2.Oauth2ConfigRpt;
import com.wjs.weixin2d.domain.oauth2.Oauth2;
import com.wjs.weixin2d.domain.oauth2.Oauth2Rpt;
import com.wjs.weixin2d.domain.provider.ProviderRpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Oauth2ServiceImpl implements Oauth2Service {

    @Autowired
    private Oauth2Rpt oauth2Rpt;

    @Autowired
    private ProviderRpt providerRpt;

    @Autowired
    private Oauth2ConfigRpt oauth2ConfigRpt;

    @Autowired
    private MbFacade mbFacade;

    @Override
    public String obtainCodeUrl(Long oauth2ConfigId, Oauth2Service oauth2Service) {
        Oauth2 oauth2 = oauth2Service.create(oauth2ConfigId);
        String url = oauth2Service.obtainCodeUrl(oauth2.getId());
        return url;
    }

    @Override
    @Transactional
    public Oauth2 create(Long oauth2ConfigId) {
        Oauth2Config oauth2Config = oauth2ConfigRpt.getById(oauth2ConfigId);
        Oauth2 oauth2 = new Oauth2(oauth2Config);
        oauth2Rpt.save(oauth2);
        return oauth2;
    }

    @Override
    @Transactional
    public String obtainCodeUrl(Long id) {
        Oauth2 oauth2 = oauth2Rpt.getById(id);
        String url = oauth2.obtainCodeUrl();
        return url;
    }

    @Override
    @Transactional
    public String callback(Long oauthId, String code, String state) {
        Oauth2 oauth2 = oauth2Rpt.getById(oauthId);
        oauth2.setProperties(code, state);
        oauth2.obtainPageAccessToken();
        oauth2.obtainUserinfo();

        //推送数据
        String userinfoJson = oauth2.getUserinfoJson();
        MemberDTO memberDTO = JSONObject.parseObject(userinfoJson, MemberDTO.class);
        memberDTO.setProviderId(oauth2.getProviderId());
        mbFacade.createWechatMember(1L, memberDTO);

        String url = oauth2.getCallback();
        return url;
    }

}
