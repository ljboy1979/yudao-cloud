package cn.iocoder.yudao.module.system.dal.redis.area;

import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO;
import cn.iocoder.yudao.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.module.system.dal.redis.RedisKeyConstants.AREA_DATA_LIST;

/**
 * {@link OAuth2AccessTokenDO} 的 RedisDAO
 *
 * @author wangd
 */
@Repository
public class AreaRedisDAO {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public List< AreaDO > get() {
        String redisKey = formatKey();
        String data = stringRedisTemplate.opsForValue().get(redisKey);
        if(StringUtils.isNotEmpty(data)){
            return JsonUtils.parseArray(data, AreaDO.class);
        }
        return null;
    }

    public void set(List< AreaDO > areaList) {
        String redisKey = formatKey();
        // 清理多余字段，避免缓存
        stringRedisTemplate.opsForValue().set(redisKey, JsonUtils.toJsonString(areaList));
    }

    public void delete() {
        String redisKey = formatKey();
        stringRedisTemplate.delete(redisKey);
    }

    private static String formatKey() {
        return AREA_DATA_LIST.getKeyTemplate();
    }

}
