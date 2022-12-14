package cn.acsm.module.purchase.controller.admin.details;

import cn.acsm.module.purchase.controller.admin.details.vo.*;
import cn.acsm.module.purchase.convert.details.PurchaseDetailsConvert;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.acsm.module.purchase.service.details.PurchaseDetailsService;
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

@Api(tags = "管理后台 - 采购单明细")
@RestController
@RequestMapping("/purchase/details")
@Validated
public class PurchaseDetailsController {

    @Resource
    private PurchaseDetailsService detailsService;

    @PostMapping("/create")
    @ApiOperation("创建采购单明细")
    @PreAuthorize("@ss.hasPermission('purchase:details:create')")
    public CommonResult<Long> createDetails(@Valid @RequestBody PurchaseDetailsCreateReqVO createReqVO) {
        return success(detailsService.createDetails(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新采购单明细")
    @PreAuthorize("@ss.hasPermission('purchase:details:update')")
    public CommonResult<Boolean> updateDetails(@Valid @RequestBody PurchaseDetailsUpdateReqVO updateReqVO) {
        detailsService.updateDetails(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除采购单明细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:details:delete')")
    public CommonResult<Boolean> deleteDetails(@RequestParam("id") Long id) {
        detailsService.deleteDetails(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得采购单明细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:details:query')")
    public CommonResult<PurchaseDetailsRespVO> getDetails(@RequestParam("id") Long id) {
        PurchaseDetailsDO details = detailsService.getDetails(id);
        return success(PurchaseDetailsConvert.INSTANCE.convert(details));
    }

    @GetMapping("/list")
    @ApiOperation("获得采购单明细列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:details:query')")
    public CommonResult<List<PurchaseDetailsRespVO>> getDetailsList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseDetailsDO> list = detailsService.getDetailsList(ids);
        return success(PurchaseDetailsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得采购单明细分页")
    @PreAuthorize("@ss.hasPermission('purchase:details:query')")
    public CommonResult<PageResult<PurchaseDetailsRespVO>> getDetailsPage(@Valid PurchaseDetailsPageReqVO pageVO) {
        PageResult<PurchaseDetailsDO> pageResult = detailsService.getDetailsPage(pageVO);
        return success(PurchaseDetailsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出采购单明细 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:details:export')")
    @OperateLog(type = EXPORT)
    public void exportDetailsExcel(@Valid PurchaseDetailsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseDetailsDO> list = detailsService.getDetailsList(exportReqVO);
        // 导出 Excel
        List<PurchaseDetailsExcelVO> datas = PurchaseDetailsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "采购单明细.xls", "数据", PurchaseDetailsExcelVO.class, datas);
    }

}
