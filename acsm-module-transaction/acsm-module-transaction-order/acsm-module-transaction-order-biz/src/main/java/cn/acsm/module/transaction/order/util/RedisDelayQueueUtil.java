package cn.acsm.module.transaction.order.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisDelayQueueUtil {

    private final RedissonClient redissonClient;

    /**
     * 添加延迟队列
     *
     * @param message   消息
     * @param delay     时长
     * @param timeUnit  单位
     * @param queueCode 队列键
     */
    public <T> void addDelayQueue(T message, long delay, TimeUnit timeUnit, String queueCode) {
        try {
            RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque(queueCode);
            RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
            delayedQueue.offer(message, delay, timeUnit);
            log.info("添加延时队列成功，队列键：{}，队列值：{}，延迟时间：{}", queueCode, message, timeUnit.toSeconds(delay) + "秒");
        } catch (Exception e) {
            log.error("添加延时队列失败：{}", e.getMessage());
            throw new RuntimeException("添加延时队列失败");
        }
    }

    /**
     * 获取延迟队列
     *
     * @param queueCode 队列键
     * @return 队列值
     */
    public <T> T getDelayQueue(String queueCode) throws InterruptedException {
        RBlockingDeque blockingDeque = redissonClient.getBlockingDeque(queueCode);
        redissonClient.getDelayedQueue(blockingDeque);
        T value = (T) blockingDeque.take();
        return value;
    }

}
