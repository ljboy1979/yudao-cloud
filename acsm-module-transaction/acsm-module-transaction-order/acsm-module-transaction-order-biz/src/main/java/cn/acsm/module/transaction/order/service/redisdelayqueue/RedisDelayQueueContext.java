package cn.acsm.module.transaction.order.service.redisdelayqueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略工厂
 */
@Component
public class RedisDelayQueueContext {

    @Autowired
    Map<String, RedisDelayQueueService> strategyMap = new ConcurrentHashMap();



    public RedisDelayQueueService geRedisDelayQueueService(String type) {
        RedisDelayQueueService redisDelayQueueService = strategyMap.get(type);
        if (redisDelayQueueService == null) {
            return null;
        }
        return redisDelayQueueService;
    }
}
