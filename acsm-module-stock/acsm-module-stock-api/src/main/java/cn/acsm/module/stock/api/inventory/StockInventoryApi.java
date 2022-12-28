package cn.acsm.module.stock.api.inventory;

import cn.acsm.module.stock.api.inventory.qo.InventoryQO;
import cn.acsm.module.stock.api.inventory.vo.StockInventoryApiReqVO;
import cn.acsm.module.stock.enums.ApiConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <pre>
 * 对象功能: StockInventoryApi.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/23
 * <pre>
 */
@FeignClient(value = ApiConstants.NAME,path = "stock/feign/purchase")
@Api(tags = "RPC 服务 - 获取清单信息接口")
public interface StockInventoryApi {

    @PostMapping("/get/inventorys")
    @ApiOperation("获取库存清单数据")
    StockInventoryApiReqVO getInventorys(@RequestBody InventoryQO inventoryQO);

}
