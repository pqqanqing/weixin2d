package com.wjs.weixin2d.service.player;

import cn.com.common.base.exception.BusinessExecption;
import com.wjs.weixin2d.api.dto.PlayerDTO;
import com.wjs.weixin2d.domain.activity.Activity;
import com.wjs.weixin2d.domain.activity.ActivityRpt;
import com.wjs.weixin2d.domain.player.Player;
import com.wjs.weixin2d.domain.player.PlayerRpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private ActivityRpt activityRpt;

    @Autowired
    private PlayerRpt playerRpt;

    @Override
    @Transactional
    public PlayerDTO createOrUpdate(Long activityId, PlayerDTO playerDTO) {
        Activity activity = activityRpt.getById(activityId);
        String phone = playerDTO.getPhone();
        if (isBlank(phone)) throw new BusinessExecption("weixin2d13");

        Player player = playerRpt.queryByPhone(phone);
        if (Objects.isNull(player)) {
            player = new Player(activity, playerDTO);
        } else {
            player.update(playerDTO);
        }

        playerRpt.saveOrUpdate(player);
        return player.makeDTO();
    }

    @Override
    @Transactional
    public Integer counts(Long activityId) {
        Integer counts = playerRpt.counts(activityId);
        return counts;
    }

    @Override
    @Transactional
    public Integer rankByPhone(Long activityId, String phone) {
        Integer rank = playerRpt.rankByPhone(activityId, phone);
        return rank;
    }

    @Override
    @Transactional
    public List<PlayerDTO> rank(Long activityId) {
        List<PlayerDTO> players = playerRpt.rank(activityId);
        return players;
    }
}
