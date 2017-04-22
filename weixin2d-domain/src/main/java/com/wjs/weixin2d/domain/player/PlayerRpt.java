package com.wjs.weixin2d.domain.player;


import com.wjs.common.base.rpt.BaseRpt;
import com.wjs.weixin2d.api.dto.PlayerDTO;

import java.io.Serializable;
import java.util.List;

public interface PlayerRpt extends BaseRpt<Player, Serializable> {
    Player queryByPhone(String phone);

    Integer counts(Long activityId);

    Integer rankByPhone(Long activityId, String phone);

    List<PlayerDTO> rank(Long activityId);
}
