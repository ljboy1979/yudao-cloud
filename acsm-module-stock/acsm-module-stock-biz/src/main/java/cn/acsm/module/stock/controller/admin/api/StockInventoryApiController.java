package cn.acsm.module.stock.controller.admin.api;

import cn.acsm.module.stock.api.inventory.qo.InventoryVirtualQO;
import cn.acsm.module.stock.api.inventory.vo.StockInventoryApiReqVO;
import cn.acsm.module.stock.service.inventory.StockInventoryService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * <pre>
 * 对象功能: StockInventoryApiController.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/30
 * <pre>
 */
@Api(tags = "管理后台 - (feign)库存清单")
@RestController
@RequestMapping("/stock/inventory")
@Validated
public class StockInventoryApiController {

    @Resource
    private StockInventoryService inventoryService;

    @PostMapping("/get/specificationId")
    @ApiOperation("根据规格id获取具体清单数据")
    @PreAuthorize("@ss.hasPermission('stock:inventory:get')")
    public CommonResult<StockInventoryApiReqVO> getInventorysBySpId(@Valid @RequestParam("packagingSpecificationId") String packagingSpecificationId) {
        return success(inventoryService.getInventorysBySpId(packagingSpecificationId));
    }

    @PostMapping("/update/virtual")
    @ApiOperation("根据规格id修改虚拟库存量")
    @PreAuthorize("@ss.hasPermission('stock:inventory:update')")
    public CommonResult<Boolean> updateInventorys(@Valid @RequestBody InventoryVirtualQO qo) {
        return success(inventoryService.updateInventorys(qo));
    }

}
