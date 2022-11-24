package cn.acsm.module.enterprise.dal.redis.code;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import static cn.acsm.module.enterprise.dal.redis.RedisKeyConstants.ENTERPRISE_CODE_SEQUENCE;


/**
 * {@link code} 的 RedisDAO
 *
 * @author wangd
 */
@Repository
public class EnterpriseCodeRedisDAO {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public String get(String accessToken) {
        String redisKey = formatKey(accessToken);
        return stringRedisTemplate.opsForValue().get(redisKey);
    }

    private static String formatKey(String accessToken) {
        return String.format(ENTERPRISE_CODE_SEQUENCE.getKeyTemplate(), accessToken);
    }

}
