package cn.acsm.module.stock.controller.admin.inventoryrecorddetail;

import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.*;
import cn.acsm.module.stock.convert.inventoryrecorddetail.StockInventoryRecordDetailConvert;
import cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail.StockInventoryRecordDetailDO;
import cn.acsm.module.stock.service.inventoryrecorddetail.StockInventoryRecordDetailService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
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

@Api(tags = "管理后台 - 盘点详情")
@RestController
@RequestMapping("/stock/inventory-record-detail")
@Validated
public class StockInventoryRecordDetailController {

    @Resource
    private StockInventoryRecordDetailService inventoryRecordDetailService;

    @PostMapping("/create")
    @ApiOperation("创建盘点详情")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record-detail:create')")
    public CommonResult<Long> createInventoryRecordDetail(@Valid @RequestBody StockInventoryRecordDetailCreateReqVO createReqVO) {
        return success(inventoryRecordDetailService.createInventoryRecordDetail(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新盘点详情")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record-detail:update')")
    public CommonResult<Boolean> updateInventoryRecordDetail(@Valid @RequestBody StockInventoryRecordDetailUpdateReqVO updateReqVO) {
        inventoryRecordDetailService.updateInventoryRecordDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除盘点详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory-record-detail:delete')")
    public CommonResult<Boolean> deleteInventoryRecordDetail(@RequestParam("id") Long id) {
        inventoryRecordDetailService.deleteInventoryRecordDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得盘点详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory-record-detail:query')")
    public CommonResult<StockInventoryRecordDetailRespVO> getInventoryRecordDetail(@RequestParam("id") Long id) {
        StockInventoryRecordDetailDO inventoryRecordDetail = inventoryRecordDetailService.getInventoryRecordDetail(id);
        return success(StockInventoryRecordDetailConvert.INSTANCE.convert(inventoryRecordDetail));
    }

    @GetMapping("/list")
    @ApiOperation("获得盘点详情列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('stock:inventory-record-detail:query')")
    public CommonResult<List<StockInventoryRecordDetailRespVO>> getInventoryRecordDetailList(@RequestParam("ids") Collection<Long> ids) {
        List<StockInventoryRecordDetailDO> list = inventoryRecordDetailService.getInventoryRecordDetailList(ids);
        return success(StockInventoryRecordDetailConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得盘点详情分页")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record-detail:query')")
    public CommonResult<PageResult<StockInventoryRecordDetailRespVO>> getInventoryRecordDetailPage(@Valid StockInventoryRecordDetailPageReqVO pageVO) {
        PageResult<StockInventoryRecordDetailDO> pageResult = inventoryRecordDetailService.getInventoryRecordDetailPage(pageVO);
        return success(StockInventoryRecordDetailConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出盘点详情 Excel")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record-detail:export')")
    @OperateLog(type = EXPORT)
    public void exportInventoryRecordDetailExcel(@Valid StockInventoryRecordDetailExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<StockInventoryRecordDetailDO> list = inventoryRecordDetailService.getInventoryRecordDetailList(exportReqVO);
        // 导出 Excel
        List<StockInventoryRecordDetailExcelVO> datas = StockInventoryRecordDetailConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "盘点记录表子表-明细.xls", "数据", StockInventoryRecordDetailExcelVO.class, datas);
    }

    @GetMapping("/page/detail")
    @ApiOperation("3.7.2.17.获取盘点详情分页")
    @PreAuthorize("@ss.hasPermission('stock:inventory-record-detail:query')")
    public CommonResult<Page<StockInventoryRecordDetailDO>> getInventoryRecordDetailPage(@Valid StockInventoryRecordDetailPageVO pageVO) {
        Page<StockInventoryRecordDetailDO> pageResult = inventoryRecordDetailService.getInventoryRecordDetailPage(pageVO);
        return success(pageResult);
    }

}
