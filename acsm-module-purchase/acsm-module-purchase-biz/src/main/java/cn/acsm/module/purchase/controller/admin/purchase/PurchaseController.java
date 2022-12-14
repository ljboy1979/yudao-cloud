package cn.acsm.module.purchase.controller.admin.purchase;

import cn.acsm.module.purchase.controller.admin.purchase.vo.*;
import cn.acsm.module.purchase.convert.purchase.PurchaseConvert;
import cn.acsm.module.purchase.dal.dataobject.purchase.PurchaseDO;
import cn.acsm.module.purchase.service.purchase.PurchaseService;
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

@Api(tags = "管理后台 - 采购单")
@RestController
@RequestMapping("/purchase/purchase")
@Validated
public class PurchaseController {

    @Resource
    private PurchaseService purchaseService;

    @PostMapping("/create")
    @ApiOperation("创建采购单")
    @PreAuthorize("@ss.hasPermission('purchase:purchase:create')")
    public CommonResult<Long> createpurchase(@Valid @RequestBody PurchaseCreateReqVO createReqVO) {
        return success(purchaseService.createpurchase(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新采购单")
    @PreAuthorize("@ss.hasPermission('purchase:purchase:update')")
    public CommonResult<Boolean> updatepurchase(@Valid @RequestBody PurchaseUpdateReqVO updateReqVO) {
        purchaseService.updatepurchase(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除采购单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:purchase:delete')")
    public CommonResult<Boolean> deletepurchase(@RequestParam("id") Long id) {
        purchaseService.deletepurchase(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得采购单")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:purchase:query')")
    public CommonResult<PurchaseRespVO> getpurchase(@RequestParam("id") Long id) {
        PurchaseDO purchase = purchaseService.getpurchase(id);
        return success(PurchaseConvert.INSTANCE.convert(purchase));
    }

    @GetMapping("/list")
    @ApiOperation("获得采购单列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:purchase:query')")
    public CommonResult<List<PurchaseRespVO>> getpurchaseList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseDO> list = purchaseService.getpurchaseList(ids);
        return success(PurchaseConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得采购单分页")
    @PreAuthorize("@ss.hasPermission('purchase:purchase:query')")
    public CommonResult<PageResult<PurchaseRespVO>> getpurchasePage(@Valid PurchasePageReqVO pageVO) {
        PageResult<PurchaseDO> pageResult = purchaseService.getpurchasePage(pageVO);
        return success(PurchaseConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出采购单 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:purchase:export')")
    @OperateLog(type = EXPORT)
    public void exportpurchaseExcel(@Valid PurchaseExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseDO> list = purchaseService.getpurchaseList(exportReqVO);
        // 导出 Excel
        List<PurchaseExcelVO> datas = PurchaseConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "采购单.xls", "数据", PurchaseExcelVO.class, datas);
    }

}
