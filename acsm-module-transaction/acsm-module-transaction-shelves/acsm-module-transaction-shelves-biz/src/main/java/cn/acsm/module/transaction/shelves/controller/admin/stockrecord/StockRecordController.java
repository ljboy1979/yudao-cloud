package cn.acsm.module.transaction.shelves.controller.admin.stockrecord;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordDO;
import cn.acsm.module.transaction.shelves.convert.stockrecord.StockRecordConvert;
import cn.acsm.module.transaction.shelves.service.stockrecord.StockRecordService;

@Api(tags = "管理后台 - 货架库存记录")
@RestController
@RequestMapping("/shelves/stock-record")
@Validated
public class StockRecordController {

    @Resource
    private StockRecordService stockRecordService;

    @PostMapping("/create")
    @ApiOperation("创建货架库存记录")
    @PreAuthorize("@ss.hasPermission('shelves:stock-record:create')")
    public CommonResult<String> createStockRecord(@Valid @RequestBody StockRecordCreateReqVO createReqVO) {
        return success(stockRecordService.createStockRecord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新货架库存记录")
    @PreAuthorize("@ss.hasPermission('shelves:stock-record:update')")
    public CommonResult<Boolean> updateStockRecord(@Valid @RequestBody StockRecordUpdateReqVO updateReqVO) {
        stockRecordService.updateStockRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除货架库存记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('shelves:stock-record:delete')")
    public CommonResult<Boolean> deleteStockRecord(@RequestParam("id") String id) {
        stockRecordService.deleteStockRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得货架库存记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('shelves:stock-record:query')")
    public CommonResult<StockRecordRespVO> getStockRecord(@RequestParam("id") String id) {
        StockRecordDO stockRecord = stockRecordService.getStockRecord(id);
        return success(StockRecordConvert.INSTANCE.convert(stockRecord));
    }

    @GetMapping("/list")
    @ApiOperation("获得货架库存记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('shelves:stock-record:query')")
    public CommonResult<List<StockRecordRespVO>> getStockRecordList(@RequestParam("ids") Collection<String> ids) {
        List<StockRecordDO> list = stockRecordService.getStockRecordList(ids);
        return success(StockRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得货架库存记录分页")
    @PreAuthorize("@ss.hasPermission('shelves:stock-record:query')")
    public CommonResult<PageResult<StockRecordRespVO>> getStockRecordPage(@Valid StockRecordPageReqVO pageVO) {
        PageResult<StockRecordDO> pageResult = stockRecordService.getStockRecordPage(pageVO);
        return success(StockRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出货架库存记录 Excel")
    @PreAuthorize("@ss.hasPermission('shelves:stock-record:export')")
    @OperateLog(type = EXPORT)
    public void exportStockRecordExcel(@Valid StockRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<StockRecordDO> list = stockRecordService.getStockRecordList(exportReqVO);
        // 导出 Excel
        List<StockRecordExcelVO> datas = StockRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "货架库存记录.xls", "数据", StockRecordExcelVO.class, datas);
    }

}
