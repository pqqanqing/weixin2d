package com.wjs.weixin2d.domain.luck;

import com.wjs.common.base.base.BaseEntity;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.wjs.weixin2d.api.dto.LuckDTO;
import lombok.Getter;
import lombok.Setter;

import static com.wjs.common.base.util.BeanPropertiesUtil.copyProperties;

@Setter
@Getter
public class Luck extends BaseEntity {
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

    public Luck() {

    }

    public Luck(LuckDTO luckDTO) throws PinyinException{
        this.activityName = luckDTO.getActivityName();
        this.name = luckDTO.getName();
        this.Pinyin = PinyinHelper.convertToPinyinString(name, " ", PinyinFormat.WITHOUT_TONE);
        this.initial = Pinyin.substring(0, 1);
    }

    public LuckDTO makeDTO() {
        return copyProperties(this, LuckDTO.class);
    }
}
