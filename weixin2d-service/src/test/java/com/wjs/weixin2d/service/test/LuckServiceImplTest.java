package com.wjs.weixin2d.service.test;

import com.wjs.weixin2d.api.dto.LuckDTO;
import com.wjs.weixin2d.service.luck.LuckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class LuckServiceImplTest {
    @Autowired
    private LuckService luckService;

    @Test
    public void testLuckService() {
        LuckDTO luckDTO = new LuckDTO();
        luckDTO.setActivityName("开运活动");
        luckDTO.setName("张世海");
        luckDTO = luckService.save(luckDTO);
        System.out.println(luckDTO);
    }
}
