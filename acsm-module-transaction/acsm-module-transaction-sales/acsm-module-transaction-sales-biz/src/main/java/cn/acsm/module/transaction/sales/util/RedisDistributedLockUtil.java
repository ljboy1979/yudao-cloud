package cn.acsm.module.transaction.sales.util;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

import java.util.Collections;

@Component
public class RedisDistributedLockUtil {
    /**
     * 锁key
     */
    private String lockKey;

    /**
     * 锁超时时间
     */
    private int expireMsecs = 60 * 1000;

    private RedisTemplate redisTemplate;

    /**
     * nx
     */
    private static final String SET_IF_NOT_EXIST = "NX";

    /**
     * px
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 加锁返回结果 ok
     */
    private static final String LOCK_OK_RESULT = "OK";

    /**
     * 加锁返回结果 no
     */
    private static final String LOCK_NO_RESULT = "NO";

    /**
     * 释放锁返回结果 ok
     */
    private static final String RELEASE_LOCK_OK_RESULT = "1";

    /**
     * 释放锁返回结果 no
     */
    private static final String RELEASE_LOCK_NO_RESULT = "0";

    /**
     * 无参构造
     */
    public RedisDistributedLockUtil() {}

    /**
     * 有参构造1
     * @param redisTemplate
     */
    public RedisDistributedLockUtil(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 有参构造2
     * @param redisTemplate
     * @param expireMsecs
     */
    public RedisDistributedLockUtil(RedisTemplate redisTemplate, int expireMsecs) {
        this(redisTemplate);
        this.expireMsecs = expireMsecs;
    }

    /**
     * 有参构造3
     * @param redisTemplate
     * @param expireMsecs
     * @param lockKey
     */
    public RedisDistributedLockUtil(RedisTemplate redisTemplate, int expireMsecs, String lockKey) {
        this(redisTemplate, expireMsecs);
        this.lockKey = lockKey;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setExpireMsecs(int expireMsecs) {
        this.expireMsecs = expireMsecs;
    }

    public boolean getLock(String lockKey) {
        return getLock(lockKey,null);
    }

    /**
     * 获取锁
     * @param lockKey
     * @return
     */
    public boolean getLock(String lockKey,Integer timeout) {

        //1.加锁
        String result = (String) redisTemplate.execute((RedisCallback<String>) connection -> {
            Object nativeConnection = connection.getNativeConnection();
            if(nativeConnection instanceof JedisCluster) {
                //集群模式
                return ((JedisCluster) nativeConnection).set(lockKey, String.valueOf(Thread.currentThread().getId()), SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireMsecs);
            }
            if(nativeConnection instanceof Jedis) {
                //单机模式/哨兵模式
                return ((Jedis) nativeConnection).set(lockKey, String.valueOf(Thread.currentThread().getId()), SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireMsecs);
            }
            return LOCK_NO_RESULT;
        });

        //2.返回
        if(LOCK_OK_RESULT.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 释放锁
     * @param lockKey
     * @return
     */
    public boolean releaseLock(String lockKey) {

        //1.lua脚本
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        //2.释放锁
        Object result = redisTemplate.execute((RedisCallback<Object>) connection -> {
            Object nativeConnection = connection.getNativeConnection();
            if(nativeConnection instanceof JedisCluster) {
                return ((JedisCluster) nativeConnection).eval(script, Collections.singletonList(lockKey), Collections.singletonList(String.valueOf(Thread.currentThread().getId())));
            }
            if(nativeConnection instanceof Jedis) {
                return ((Jedis) nativeConnection).eval(script, Collections.singletonList(lockKey), Collections.singletonList(String.valueOf(Thread.currentThread().getId())));
            }
            return RELEASE_LOCK_NO_RESULT;
        });

        //3.返回
        if(RELEASE_LOCK_OK_RESULT.equals(result.toString())) {
            return true;
        }
        return false;
    }
}
