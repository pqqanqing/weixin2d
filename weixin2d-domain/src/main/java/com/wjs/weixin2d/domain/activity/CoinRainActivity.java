package com.wjs.weixin2d.domain.activity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CoinRainActivity extends Activity {

    private Integer goldNum;
    private Integer silverNum;
    private Integer goldHeadNum;
    private Integer bombNum;

    public CoinRainActivity() {
    }

}