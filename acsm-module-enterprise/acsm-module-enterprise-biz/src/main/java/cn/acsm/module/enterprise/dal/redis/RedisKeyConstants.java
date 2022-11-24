package cn.acsm.module.enterprise.dal.redis;

import cn.iocoder.yudao.framework.redis.core.RedisKeyDefine;
import static cn.iocoder.yudao.framework.redis.core.RedisKeyDefine.KeyTypeEnum.HASH;

/**
 * System Redis Key 枚举类
 *
 * @author 芋道源码
 */
public interface RedisKeyConstants {

    RedisKeyDefine ENTERPRISE_CODE_SEQUENCE = new RedisKeyDefine("经营主体编号",
            "enterprise_code_sequence:%s", // 参数为访问令牌 token
            HASH, Integer.class, RedisKeyDefine.TimeoutTypeEnum.FIXED);
}
