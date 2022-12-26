package cn.acsm.module.stock.api.inventory;

import cn.acsm.module.stock.api.inventory.qo.InventoryQO;
import cn.acsm.module.stock.api.inventory.vo.StockInventoryApiReqVO;
import cn.acsm.module.stock.service.inventory.StockInventoryService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.module.system.enums.ApiConstants.VERSION;

/**
 * <pre>
 * 对象功能: StockInventoryApiImpl.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/23
 * <pre>
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
@Transactional
public class StockInventoryApiImpl implements StockInventoryApi {

    @Resource
    private StockInventoryService inventoryService;

    @Override
    public List<StockInventoryApiReqVO> getInventorys(InventoryQO reqQO) {
        return inventoryService.getInventoryList(reqQO);
    }
}
