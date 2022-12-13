package cn.acsm.module.transaction.order.service.redisdelayqueue;


public interface RedisDelayQueueService {

    /**
     * 执行
     * @param t
     */
    void execute(ExecuteDTO t);
}
