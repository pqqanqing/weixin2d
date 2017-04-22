package com.wjs.weixin2d.domain.player;

import cn.com.common.base.base.BaseEntity;
import cn.com.common.base.exception.BusinessExecption;
import cn.com.common.base.security.SecureNum;
import com.wjs.weixin2d.api.dto.PlayerDTO;
import com.wjs.weixin2d.domain.activity.Activity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static cn.com.common.base.security.SecurityKeyFactory.getSecurityKey;
import static cn.com.common.base.util.BeanPropertiesUtil.copyProperties;
import static cn.com.common.base.util.ValidatorUtil.REGEX_MOBILE;
import static cn.com.common.base.util.ValidatorUtil.isMatchRegex;

@Setter
@Getter
public class Player extends BaseEntity {

    private Activity activity;
    private Integer score;
    private SecureNum secureNum;
    private Integer totalNum = 3;
    private Integer playNum = 0;

    public Player() {
    }

    public Player(Activity activity, PlayerDTO playerDTO) {
        this.activity = activity;
        this.score = playerDTO.getScore();
        this.secureNum = new SecureNum(playerDTO.getPhone(), 3, 4, getSecurityKey("activity"));
        check();
        this.playNum++;
    }

    private void check() {
        Date date = new Date();
        if (activity.checkStartTime(date)) throw new BusinessExecption("weixin2d14");
        if (activity.checkEndTime(date)) throw new BusinessExecption("weixin2d15");
        if (playNum >= totalNum) throw new BusinessExecption("weixin2d16");
        if (!isMatchRegex(secureNum.getPlainText(), REGEX_MOBILE))
            throw new BusinessExecption("weixin2d17");
    }

    public void update(PlayerDTO playerDTO) {
        check();
        this.score = playerDTO.getScore();
        this.playNum++;
    }

    public String getPhone() {
        return secureNum.getMask();
    }

    public Integer getResidueNum() {
        return totalNum - playNum;
    }

    public PlayerDTO makeDTO() {
        return copyProperties(this, PlayerDTO.class);
    }
}
