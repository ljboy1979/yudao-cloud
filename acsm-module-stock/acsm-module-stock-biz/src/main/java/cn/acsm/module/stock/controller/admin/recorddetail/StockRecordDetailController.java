package cn.acsm.module.stock.controller.admin.recorddetail;

import cn.acsm.module.stock.controller.admin.recorddetail.vo.*;
import cn.acsm.module.stock.convert.recorddetail.StockRecordDetailConvert;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.acsm.module.stock.service.recorddetail.StockRecordDetailService;
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

@Api(tags = "管理后台 - 库存详情【出库-入库】")
@RestController
@RequestMapping("/stock/record-detail")
@Validated
public class StockRecordDetailController {

    @Resource
    private StockRecordDetailService recordDetailService;

    @PostMapping("/create")
    @ApiOperation("创建库存详情")
    @PreAuthorize("@ss.hasPermission('stock:record-detail:create')")
    public CommonResult<Long> createRecordDetail(@Valid @RequestBody StockRecordDetailCreateReqVO createReqVO) {
        return success(recordDetailService.createRecordDetail(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新库存详情")
    @PreAuthorize("@ss.hasPermission('stock:record-detail:update')")
    public CommonResult<Boolean> updateRecordDetail(@Valid @RequestBody StockRecordDetailUpdateReqVO updateReqVO) {
        recordDetailService.updateRecordDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除库存详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('stock:record-detail:delete')")
    public CommonResult<Boolean> deleteRecordDetail(@RequestParam("id") Long id) {
        recordDetailService.deleteRecordDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得库存详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('stock:record-detail:query')")
    public CommonResult<StockRecordDetailRespVO> getRecordDetail(@RequestParam("id") Long id) {
        StockRecordDetailDO recordDetail = recordDetailService.getRecordDetail(id);
        return success(StockRecordDetailConvert.INSTANCE.convert(recordDetail));
    }

    @GetMapping("/list")
    @ApiOperation("获得库存详情列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('stock:record-detail:query')")
    public CommonResult<List<StockRecordDetailRespVO>> getRecordDetailList(@RequestParam("ids") Collection<Long> ids) {
        List<StockRecordDetailDO> list = recordDetailService.getRecordDetailList(ids);
        return success(StockRecordDetailConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("3.7.2.11.获取入库详情及现有库存量")
    @PreAuthorize("@ss.hasPermission('stock:record-detail:query')")
    public CommonResult<Page<StockRecordDetailDO>> getRecordDetailPage(@Valid StockRecordDetailPageReqVO pageVO) {
        Page<StockRecordDetailDO> pageResult = recordDetailService.getRecordDetailPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/page/inout")
    @ApiOperation("+获取出库记录详情")
    @PreAuthorize("@ss.hasPermission('stock:record-detail:query')")
    public CommonResult<Page<StockRecordDetailDO>> getRecordDetailOutPage(@Valid StockRecordDetailPageInOutVO pageVO) {
        Page<StockRecordDetailDO> pageResult = recordDetailService.getRecordDetailOutPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出库存详情 Excel")
    @PreAuthorize("@ss.hasPermission('stock:record-detail:export')")
    @OperateLog(type = EXPORT)
    public void exportRecordDetailExcel(@Valid StockRecordDetailExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<StockRecordDetailDO> list = recordDetailService.getRecordDetailList(exportReqVO);
        // 导出 Excel
        List<StockRecordDetailExcelVO> datas = StockRecordDetailConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "库存记录字表-明细.xls", "数据", StockRecordDetailExcelVO.class, datas);
    }

    @PutMapping("/update/detail/record")
    @ApiOperation("3.7.2.13.修改出/入库存")
    @PreAuthorize("@ss.hasPermission('stock:update:detail-record')")
    public CommonResult<Boolean> updateRecordDetail(@Valid @RequestBody StockRecordDetailOutEnterVO updateReqVO) {
        recordDetailService.updateRecordDetailOutEnter(updateReqVO);
        return success(true);
    }

    @GetMapping("/page/detail")
    @ApiOperation("3.7.2.15.根据库存id或批次号查询库存详情")
    @PreAuthorize("@ss.hasPermission('stock:record-detail:page')")
    public CommonResult<Page<StockRecordDetailRespVO>> getRecordDetailPage(@Valid StockRecordDetailPageVO pageVO) {
        Page<StockRecordDetailRespVO> pageResult = recordDetailService.getRecordDetailPage(pageVO);
        return success(pageResult);
    }

    @GetMapping("/page/temporary")
    @ApiOperation("3.7.2.20.临期时间管理")
    @PreAuthorize("@ss.hasPermission('stock:record-detail:query')")
    public CommonResult<Page<StockRecordDetailDO>> getRecordByTemporaryPage(@Valid @RequestBody StockRecordTempPageVO pageVO) {
        Page<StockRecordDetailDO> pageResult = recordDetailService.getRecordDetailPage(pageVO);
        return success(pageResult);
    }

    @PostMapping("/print-list")
    @ApiOperation("打印库存详情列表")
    @PreAuthorize("@ss.hasPermission('stock:record-detail:print')")
    public CommonResult<List<StockRecordDetailPrintRespVO>> getRecordDetailList(@RequestBody StockRecordDetailPrintVO printVO) {
        List<StockRecordDetailPrintRespVO> list = recordDetailService.getRecordDetailList(printVO);
        return success(list);
    }

}
