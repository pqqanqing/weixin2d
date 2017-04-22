package com.wjs.weixin2d.rpt.player;

import cn.com.common.base.rpt.BaseRptImpl;
import com.wjs.weixin2d.api.dto.PlayerDTO;
import com.wjs.weixin2d.domain.player.Player;
import com.wjs.weixin2d.domain.player.PlayerRpt;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

import static cn.com.common.base.security.SecurityKeyFactory.getSecurityKey;

@Repository
public class PlayerRptImpl extends BaseRptImpl<Player, Serializable> implements PlayerRpt {

    @Override
    public Player queryByPhone(String phone) {
        Query query = getSession().createQuery("from Player p where p.secureNum.digest = :digest");
        query.setParameter("digest", getSecurityKey("activity").digest(phone));
        return (Player) query.uniqueResult();
    }

    @Override
    public Integer counts(Long activityId) {
        Query query = getSession().createQuery("select count(*) from Player p where p.activity.id = :activityId");
        query.setParameter("activityId", activityId);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer rankByPhone(Long activityId, String phone) {
        String sql = " SELECT count(1) + 1 AS rank " +
                " FROM TB_PLAYER t1 " +
                " WHERE t1.score > (SELECT t2.score FROM TB_PLAYER t2 WHERE plain_text = :phone) AND t1.activity_id = :activityId";
        //addScalar 显示指定sql中字段的返回类型
        Query query = getSession().createSQLQuery(sql).addScalar("rank", IntegerType.INSTANCE);
        query.setParameter("phone", phone);
        query.setParameter("activityId", activityId);
        return (Integer) query.uniqueResult();
    }

    @Override
    public List<PlayerDTO> rank(Long activityId) {
        String sql = "SELECT  score,mask phone, @curRank \\:= @curRank + 1 AS rank " +
                " FROM TB_PLAYER t1, (SELECT @curRank \\:= 0) t2 " +
                " WHERE t1.activity_id = :activityId " +
                " ORDER BY score DESC, create_time ASC ";
        Query query = getSession().createSQLQuery(sql).addScalar("score").addScalar("phone").addScalar("rank", IntegerType.INSTANCE);
        query.setParameter("activityId", activityId);
        query.setFirstResult(0);
        query.setMaxResults(3);
        query.setResultTransformer(Transformers.aliasToBean(PlayerDTO.class));
        return query.list();
    }
}
