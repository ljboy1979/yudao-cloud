package cn.acsm.module.stock.controller.admin.inventoryrecord;

import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.*;
import cn.acsm.module.stock.convert.inventoryrecord.StockInventoryRecordConvert;
import cn.acsm.module.stock.dal.dataobject.inventoryrecord.StockInventoryRecordDO;
import cn.acsm.module.stock.service.inventoryrecord.StockInventoryRecordService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

@Api(tags = "管理后台 - 盘点")
@RestController
@RequestMapping("/stock/inventory-record")
@Validated
public class StockInventoryRecordController {

    @Resource
    private StockInventoryRecordService inventoryRecordService;

    @PostMapping("/create")
    @ApiOperation("创建盘点信息")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record:create')")
    public CommonResult<Long> createInventoryRecord(@Valid @RequestBody StockInventoryRecordCreateReqVO createReqVO) {
        return success(inventoryRecordService.createInventoryRecord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新盘点信息")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record:update')")
    public CommonResult<Boolean> updateInventoryRecord(@Valid @RequestBody StockInventoryRecordUpdateReqVO updateReqVO) {
        inventoryRecordService.updateInventoryRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除盘点信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory-record:delete')")
    public CommonResult<Boolean> deleteInventoryRecord(@RequestParam("id") Long id) {
        inventoryRecordService.deleteInventoryRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得盘点信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory-record:query')")
    public CommonResult<StockInventoryRecordRespVO> getInventoryRecord(@RequestParam("id") Long id) {
        StockInventoryRecordDO inventoryRecord = inventoryRecordService.getInventoryRecord(id);
        return success(StockInventoryRecordConvert.INSTANCE.convert(inventoryRecord));
    }

    @GetMapping("/list")
    @ApiOperation("获得盘点信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory-record:query')")
    public CommonResult<List<StockInventoryRecordRespVO>> getInventoryRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<StockInventoryRecordDO> list = inventoryRecordService.getInventoryRecordList(ids);
        return success(StockInventoryRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得盘点记录分页")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record:query')")
    public CommonResult<Page<StockInventoryRecordRespVO>> getInventoryRecordPage(@Valid StockInventoryRecordPageReqVO pageVO) {
        Page<StockInventoryRecordRespVO> pageResult = inventoryRecordService.getInventoryRecordPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出盘点信息 Excel")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record:export')")
    @OperateLog(type = EXPORT)
    public void exportInventoryRecordExcel(@Valid StockInventoryRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<StockInventoryRecordDO> list = inventoryRecordService.getInventoryRecordList(exportReqVO);
        // 导出 Excel
        List<StockInventoryRecordExcelVO> datas = StockInventoryRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "盘点记录.xls", "数据", StockInventoryRecordExcelVO.class, datas);
    }

    @GetMapping("/page/record")
    @ApiOperation("3.7.2.16.查询盘点信息")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record:query')")
    public CommonResult<Page<StockInventoryRecordDO>> getInventoryRecordPage(@Valid StockInventoryRecordPageVO pageVO) {
        Page<StockInventoryRecordDO> pageResult = inventoryRecordService.getInventoryRecordPage(pageVO);
        return success(pageResult);
    }

}
