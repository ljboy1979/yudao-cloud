package cn.acsm.module.purchase.controller.admin.quotationelectronic;

import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.*;
import cn.acsm.module.purchase.convert.quotationelectronic.PurchaseQuotationElectronicConvert;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.acsm.module.purchase.service.quotationelectronic.PurchaseQuotationElectronicService;
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

@Api(tags = "管理后台 - 采购报价单电子")
@RestController
@RequestMapping("/purchase/quotation-electronic")
@Validated
public class PurchaseQuotationElectronicController {

    @Resource
    private PurchaseQuotationElectronicService quotationElectronicService;

    @PostMapping("/create")
    @ApiOperation("创建采购报价单电子")
    @PreAuthorize("@ss.hasPermission('purchase:quotation-electronic:create')")
    public CommonResult<Long> createQuotationElectronic(@Valid @RequestBody PurchaseQuotationElectronicCreateReqVO createReqVO) {
        return success(quotationElectronicService.createQuotationElectronic(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新采购报价单电子")
    @PreAuthorize("@ss.hasPermission('purchase:quotation-electronic:update')")
    public CommonResult<Boolean> updateQuotationElectronic(@Valid @RequestBody PurchaseQuotationElectronicUpdateReqVO updateReqVO) {
        quotationElectronicService.updateQuotationElectronic(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除采购报价单电子")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:quotation-electronic:delete')")
    public CommonResult<Boolean> deleteQuotationElectronic(@RequestParam("id") Long id) {
        quotationElectronicService.deleteQuotationElectronic(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得采购报价单电子")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:quotation-electronic:query')")
    public CommonResult<PurchaseQuotationElectronicRespVO> getQuotationElectronic(@RequestParam("id") Long id) {
        PurchaseQuotationElectronicDO quotationElectronic = quotationElectronicService.getQuotationElectronic(id);
        return success(PurchaseQuotationElectronicConvert.INSTANCE.convert(quotationElectronic));
    }

    @GetMapping("/list")
    @ApiOperation("获得采购报价单电子列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:quotation-electronic:query')")
    public CommonResult<List<PurchaseQuotationElectronicRespVO>> getQuotationElectronicList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseQuotationElectronicDO> list = quotationElectronicService.getQuotationElectronicList(ids);
        return success(PurchaseQuotationElectronicConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得采购报价单电子分页")
    @PreAuthorize("@ss.hasPermission('purchase:quotation-electronic:query')")
    public CommonResult<PageResult<PurchaseQuotationElectronicRespVO>> getQuotationElectronicPage(@Valid PurchaseQuotationElectronicPageReqVO pageVO) {
        PageResult<PurchaseQuotationElectronicDO> pageResult = quotationElectronicService.getQuotationElectronicPage(pageVO);
        return success(PurchaseQuotationElectronicConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出采购报价单电子 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:quotation-electronic:export')")
    @OperateLog(type = EXPORT)
    public void exportQuotationElectronicExcel(@Valid PurchaseQuotationElectronicExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseQuotationElectronicDO> list = quotationElectronicService.getQuotationElectronicList(exportReqVO);
        // 导出 Excel
        List<PurchaseQuotationElectronicExcelVO> datas = PurchaseQuotationElectronicConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "采购报价单电子.xls", "数据", PurchaseQuotationElectronicExcelVO.class, datas);
    }

    @GetMapping("/price-tag/detail")
    @ApiOperation("价格牌明细")
    @PreAuthorize("@ss.hasPermission('purchase:price-tag:detail')")
    public CommonResult<PageResult<PurchaseQuotationElectronicDO>> getQuotationElectronicPage(@Valid PurchasePriceTagDetailVO pageVO) {
        return success(quotationElectronicService.getQuotationElectronicPage(pageVO));
    }

    @GetMapping("/get/info")
    @ApiOperation("3.6.2.45.查询采购报价明细")
    @PreAuthorize("@ss.hasPermission('purchase:quotation-electronic:info')")
    public CommonResult<PageResult<PurchaseQuotationElectronicDO>> getQuotationElectronicInfo(PurchaseQuotationInfoVO infoVO) {
        return success(quotationElectronicService.getQuotationElectronicInfo(infoVO));
    }

}
