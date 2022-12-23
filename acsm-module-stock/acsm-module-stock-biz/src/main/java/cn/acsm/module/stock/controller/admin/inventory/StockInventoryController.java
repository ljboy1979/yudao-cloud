package cn.acsm.module.stock.controller.admin.inventory;

import cn.acsm.module.stock.controller.admin.inventory.vo.*;
import cn.acsm.module.stock.convert.inventory.StockInventoryConvert;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import cn.acsm.module.stock.service.inventory.StockInventoryService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "管理后台 - 库存清单")
@RestController
@RequestMapping("/stock/inventory")
@Validated
public class StockInventoryController {

    @Resource
    private StockInventoryService inventoryService;

    @PostMapping("/create")
    @ApiOperation("创建库存清单")
    @PreAuthorize("@ss.hasPermission('stock:inventory:create')")
    public CommonResult<String> createInventory(@Valid @RequestBody StockInventoryCreateReqVO createReqVO) {
        return success(inventoryService.createInventory(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新库存清单")
    @PreAuthorize("@ss.hasPermission('stock:inventory:update')")
    public CommonResult<Boolean> updateInventory(@Valid @RequestBody StockInventoryUpdateReqVO updateReqVO) {
        inventoryService.updateInventory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除库存清单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory:delete')")
    public CommonResult<Boolean> deleteInventory(@RequestParam("id") String id) {
        inventoryService.deleteInventory(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得库存清单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory:query')")
    public CommonResult<StockInventoryRespVO> getInventory(@RequestParam("id") String id) {
        StockInventoryDO inventory = inventoryService.getInventory(id);
        return success(StockInventoryConvert.INSTANCE.convert(inventory));
    }

    @GetMapping("/list")
    @ApiOperation("获得库存清单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory:query')")
    public CommonResult<List<StockInventoryRespVO>> getInventoryList(@RequestParam("ids") Collection<String> ids) {
        List<StockInventoryDO> list = inventoryService.getInventoryList(ids);
        return success(StockInventoryConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("3.7.2.3.查询 库存清单")
    @PreAuthorize("@ss.hasPermission('stock:inventory:query')")
    public CommonResult<PageResult<StockInventoryRespVO>> getInventoryPage(@Valid @RequestBody StockInventoryPageReqVO pageVO) {
        PageResult<StockInventoryDO> pageResult = inventoryService.getInventoryPage(pageVO);
        return success(StockInventoryConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出库存清单 Excel")
    @PreAuthorize("@ss.hasPermission('stock:inventory:export')")
    @OperateLog(type = EXPORT)
    public void exportInventoryExcel(@Valid StockInventoryExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<StockInventoryDO> list = inventoryService.getInventoryList(exportReqVO);
        // 导出 Excel
        List<StockInventoryExcelVO> datas = StockInventoryConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "库存清单.xls", "数据", StockInventoryExcelVO.class, datas);
    }

    @PutMapping("/update/inventory")
    @ApiOperation("3.7.2.6.更新库存量")
    @PreAuthorize("@ss.hasPermission('stock:update:inventory')")
    public CommonResult<Boolean> updateInventoryCount(@Valid @RequestBody StockInventoryUpdateCountVO updateReqVO) {
        inventoryService.updateInventoryCount(updateReqVO);
        return success(true);
    }

    @PutMapping("/loss/reporting")
    @ApiOperation("3.7.2.8.报损")
    @PreAuthorize("@ss.hasPermission('stock:loss:reporting')")
    public CommonResult<Boolean> lossReporting(@Valid @RequestBody StockLossReportingVO reportingVO) {
        inventoryService.lossReporting(reportingVO);
        return success(true);
    }

}
