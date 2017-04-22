package com.wjs.weixin2d.service.test;

import com.wjs.weixin2d.api.dto.PlayerDTO;
import com.wjs.weixin2d.service.player.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class PlayerServiceImplTest {

    @Autowired
    private PlayerService playerService;

    @Test
    public void testCreateOrUpdate() {
        Long activityId = 1L;
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setScore(40000);
        playerDTO.setPhone("15601870402");
        PlayerDTO player = playerService.createOrUpdate(activityId, playerDTO);
        System.out.println(player);
    }

    @Test
    public void testCounts() {
        Long activityId = 1L;
        Integer counts = playerService.counts(activityId);
        System.out.println(counts);
    }
}
