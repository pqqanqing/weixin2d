package com.wjs.weixin2d.api.dto;

import cn.com.common.base.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LuckDTO extends BaseDTO {
    /**
     * 活动
     */
    private String activityName;
    /**
     * 姓名拼音
     */
    private String Pinyin;
    /**
     * 姓名首字母
     */
    private String initial;
    private String openId;

}
