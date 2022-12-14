package cn.acsm.module.transaction.order.service.redisdelayqueue;

import lombok.Data;

@Data
public class ExecuteDTO<T> {

    private T key;
}
