package cn.acsm.module.transaction.sales.service.api.shelves;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.STRATEGY_NOT_DEFINED;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

@Component
public class ShelvesContext {

    @Resource
    Map<String, ShelvesService> strategyMap = new ConcurrentHashMap();

    public ShelvesService getService(String type){
        ShelvesService shelvesService = strategyMap.get(type);
        if (shelvesService == null) {
            throw exception(STRATEGY_NOT_DEFINED);
        }
        return shelvesService;
    }


}
