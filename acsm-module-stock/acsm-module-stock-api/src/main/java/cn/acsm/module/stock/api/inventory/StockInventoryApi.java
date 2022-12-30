package cn.acsm.module.stock.api.inventory;

import cn.acsm.module.stock.api.inventory.qo.InventoryQO;
import cn.acsm.module.stock.api.inventory.qo.InventoryVirtualQO;
import cn.acsm.module.stock.api.inventory.vo.StockInventoryApiReqVO;
import cn.acsm.module.stock.enums.ApiConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/get/specificationId")
    @ApiOperation("根据规格id获取具体清单数据")
    StockInventoryApiReqVO getInventorysBySpId(@RequestParam("packagingSpecificationId") String packagingSpecificationId);

    @PutMapping("/update/virtual")
    @ApiOperation("根据规格id修改虚拟库存量")
    Boolean updateInventorys(@RequestBody InventoryVirtualQO qo);

}
