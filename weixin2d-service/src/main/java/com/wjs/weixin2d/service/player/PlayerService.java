package com.wjs.weixin2d.service.player;

import com.wjs.weixin2d.api.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {

    PlayerDTO createOrUpdate(Long activityId, PlayerDTO playerDTO);

    Integer counts(Long activityId);

    Integer rankByPhone(Long activityId, String phone);

    List<PlayerDTO> rank(Long activityId);
}
