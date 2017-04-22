package com.wjs.weixin2d.rpt.player;


import com.wjs.common.base.base.BaseQueryBuilder;
import com.wjs.weixin2d.domain.player.Player;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("playerQueryBuilder")
@Scope("prototype")
public class PlayerQueryBuilder extends BaseQueryBuilder<Player> {

    public void setOrderByScore(Boolean orderByScore) {
        if (orderByScore) orderByProperty(false, "score");
    }
}
