package com.wjs.weixin2d.domain.activity;

import com.wjs.common.base.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class Activity extends BaseEntity {

    private String title;
    private Date startTime;
    private Date endTime;

    public Activity() {
    }

    public boolean checkStartTime(Date date) {
        return date.getTime() < startTime.getTime();
    }

    public boolean checkEndTime(Date date) {
        return date.getTime() > endTime.getTime();
    }
}
