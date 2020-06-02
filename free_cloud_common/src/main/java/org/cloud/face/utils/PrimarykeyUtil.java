package org.cloud.face.utils;

import lombok.extern.slf4j.Slf4j;
import org.cloud.face.consts.RedisKeyConst;
import org.cloud.face.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassNmae: PrimarkeyUtil
 * @description: 生成唯一的key
 * @Author: liulin
 * @Date: 2020/2/2 14:36
 **/
@Slf4j
@Component
public class PrimarykeyUtil {

    @Autowired
    private RedisUtil redisUtil;

    public String getIdPrefix(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String monthFormat = String.format("%1$02d", month);
        String dayFormat = String.format("%1$02d", day);
        String hourFormat = String.format("%1$02d", hour);
        return year + monthFormat + dayFormat + hourFormat;
    }

    /**
     * 生产主键id
     *
     * @return
     */
    public String generatePimaryKey(){
        String key = RedisKeyConst.PIMARY_KEY;
        String id = null;
        try {
            Long increment = redisUtil.incrBy(key, 1L);
            id = getIdPrefix() + String.format("%1$022d", increment);
            return id;
        }catch (Exception e){
            log.error("生成id失败", e);
        }
        return id;
    }

    /**
     * 获取主键id
     *
     * @return
     */
    public synchronized String getPimaryKey(){
        String id = (String) redisUtil.sRandomMember(RedisKeyConst.PIMARY_KEY_LIST);
        redisUtil.sRemove(RedisKeyConst.PIMARY_KEY_LIST, id);
        return id;
    }
}
