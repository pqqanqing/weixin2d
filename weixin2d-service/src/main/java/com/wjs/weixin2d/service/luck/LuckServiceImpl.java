package com.wjs.weixin2d.service.luck;

import cn.com.common.base.exception.BusinessExecption;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.wjs.weixin2d.api.dto.LuckDTO;
import com.wjs.weixin2d.domain.luck.Luck;
import com.wjs.weixin2d.domain.luck.LuckRpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LuckServiceImpl implements LuckService {
    @Autowired
    private LuckRpt luckRpt;

    @Override
    public LuckDTO save(LuckDTO luckDTO) {
        try{
            Luck luck = new Luck(luckDTO);
            luckRpt.save(luck);
            return luck.makeDTO();
        }catch (PinyinException pe){
            pe.printStackTrace();
            throw new BusinessExecption("weixin2d10");
        }
    }
}
