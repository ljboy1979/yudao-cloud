package cn.acsm.module.transaction.order.service.redisdelayqueue;

import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;
import cn.acsm.module.transaction.order.dal.mysql.orderinfo.OrderInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class CompleteLogisticsServiceImpl implements RedisDelayQueueService {

    @Resource
    private OrderInfoMapper infoMapper;

    @Override
    public void execute(ExecuteDTO t) {
        String id = (String) t.getKey();

        OrderInfoDO updateObj = new OrderInfoDO();
        updateObj.setId(id);
        updateObj.setLogisticsStatus("4");
        infoMapper.updateById(updateObj);
        log.info("物流服务期结束 id：{}",id);

    }
}
