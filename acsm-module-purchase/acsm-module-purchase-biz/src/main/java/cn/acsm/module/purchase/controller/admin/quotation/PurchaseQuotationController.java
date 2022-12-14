package cn.acsm.module.purchase.controller.admin.quotation;

import cn.acsm.module.purchase.controller.admin.quotation.vo.*;
import cn.acsm.module.purchase.convert.quotation.PurchaseQuotationConvert;
import cn.acsm.module.purchase.dal.dataobject.quotation.PurchaseQuotationDO;
import cn.acsm.module.purchase.service.quotation.PurchaseQuotationService;
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

@Api(tags = "管理后台 - 采购询价电子")
@RestController
@RequestMapping("/purchase/quotation")
@Validated
public class PurchaseQuotationController {

    @Resource
    private PurchaseQuotationService quotationService;

    @PostMapping("/create")
    @ApiOperation("创建采购询价电子")
    @PreAuthorize("@ss.hasPermission('purchase:quotation:create')")
    public CommonResult<Long> createQuotation(@Valid @RequestBody PurchaseQuotationCreateReqVO createReqVO) {
        return success(quotationService.createQuotation(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新采购询价电子")
    @PreAuthorize("@ss.hasPermission('purchase:quotation:update')")
    public CommonResult<Boolean> updateQuotation(@Valid @RequestBody PurchaseQuotationUpdateReqVO updateReqVO) {
        quotationService.updateQuotation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除采购询价电子")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:quotation:delete')")
    public CommonResult<Boolean> deleteQuotation(@RequestParam("id") Long id) {
        quotationService.deleteQuotation(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得采购询价电子")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:quotation:query')")
    public CommonResult<PurchaseQuotationRespVO> getQuotation(@RequestParam("id") Long id) {
        PurchaseQuotationDO quotation = quotationService.getQuotation(id);
        return success(PurchaseQuotationConvert.INSTANCE.convert(quotation));
    }

    @GetMapping("/list")
    @ApiOperation("获得采购询价电子列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:quotation:query')")
    public CommonResult<List<PurchaseQuotationRespVO>> getQuotationList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseQuotationDO> list = quotationService.getQuotationList(ids);
        return success(PurchaseQuotationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得采购询价电子分页")
    @PreAuthorize("@ss.hasPermission('purchase:quotation:query')")
    public CommonResult<PageResult<PurchaseQuotationRespVO>> getQuotationPage(@Valid PurchaseQuotationPageReqVO pageVO) {
        PageResult<PurchaseQuotationDO> pageResult = quotationService.getQuotationPage(pageVO);
        return success(PurchaseQuotationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出采购询价电子 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:quotation:export')")
    @OperateLog(type = EXPORT)
    public void exportQuotationExcel(@Valid PurchaseQuotationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseQuotationDO> list = quotationService.getQuotationList(exportReqVO);
        // 导出 Excel
        List<PurchaseQuotationExcelVO> datas = PurchaseQuotationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "采购询价电子.xls", "数据", PurchaseQuotationExcelVO.class, datas);
    }

}
