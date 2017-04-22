package com.wjs.weixin2d.api.dto;

import com.wjs.common.base.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(value = {"id", "createTime", "orderByScore",
        "basePageResults", "updateTime", "version",
        "logicDelete", "type", "name",
        "memo", "statusVal", "statusDescribe"}, allowSetters = true)
public class PlayerDTO extends BaseDTO {

    /**
     * 分数
     */
    private Integer score;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 剩余次数
     */
    private Integer residueNum;

    /**
     * 按分数排序
     */
    private Boolean orderByScore = true;

    /**
     * 排名
     */
    private Integer rank;

    public PlayerDTO() {
    }
}
