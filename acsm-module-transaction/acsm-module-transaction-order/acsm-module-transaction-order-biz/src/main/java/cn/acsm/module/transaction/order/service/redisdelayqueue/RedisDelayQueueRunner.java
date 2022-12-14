package cn.acsm.module.transaction.order.service.redisdelayqueue;

import cn.acsm.module.transaction.order.enums.RedisDelayQueueEnum;
import cn.acsm.module.transaction.order.util.RedisDelayQueueUtil;
import com.alibaba.nacos.shaded.com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisDelayQueueRunner implements CommandLineRunner {
    private final RedisDelayQueueUtil redisDelayQueueUtil;

    private final RedisDelayQueueContext redisDelayQueueContext;

    @Override
    public void run(String... args) throws Exception {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("redis-delay-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(() -> {
            while (true) {
                RedisDelayQueueEnum[] queueArray = RedisDelayQueueEnum.values();
                for (RedisDelayQueueEnum queue : queueArray) {
                    try {
                        Object o = redisDelayQueueUtil.getDelayQueue(queue.getQueueCode());
                        if (null != o) {
                            RedisDelayQueueService redisDelayQueueHandle = redisDelayQueueContext.geRedisDelayQueueService(queue.getBeanId());
                            ExecuteDTO executeDTO = new ExecuteDTO();
                            executeDTO.setKey(o);
                            redisDelayQueueHandle.execute(executeDTO);
                        }
                    } catch (Exception e) {
                        log.error("Redis延迟队列{}异常中断：{}", queue.getDesc(), e.getMessage(), e);
                    }
                }
            }
        });

        log.info("Redis延迟队列启动成功");
    }

}