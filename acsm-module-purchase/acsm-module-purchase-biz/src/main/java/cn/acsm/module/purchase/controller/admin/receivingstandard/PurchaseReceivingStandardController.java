package cn.acsm.module.purchase.controller.admin.receivingstandard;

import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.*;
import cn.acsm.module.purchase.convert.receivingstandard.PurchaseReceivingStandardConvert;
import cn.acsm.module.purchase.dal.dataobject.receivingstandard.PurchaseReceivingStandardDO;
import cn.acsm.module.purchase.service.receivingstandard.PurchaseReceivingStandardService;
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

@Api(tags = "管理后台 - 收货标准")
@RestController
@RequestMapping("/purchase/receiving-standard")
@Validated
public class PurchaseReceivingStandardController {

    @Resource
    private PurchaseReceivingStandardService receivingStandardService;

    @PostMapping("/create")
    @ApiOperation("创建收货标准")
    @PreAuthorize("@ss.hasPermission('purchase:receiving-standard:create')")
    public CommonResult<Long> createReceivingStandard(@Valid @RequestBody PurchaseReceivingStandardCreateReqVO createReqVO) {
        return success(receivingStandardService.createReceivingStandard(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新收货标准")
    @PreAuthorize("@ss.hasPermission('purchase:receiving-standard:update')")
    public CommonResult<Boolean> updateReceivingStandard(@Valid @RequestBody PurchaseReceivingStandardUpdateReqVO updateReqVO) {
        receivingStandardService.updateReceivingStandard(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除收货标准")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:receiving-standard:delete')")
    public CommonResult<Boolean> deleteReceivingStandard(@RequestParam("id") Long id) {
        receivingStandardService.deleteReceivingStandard(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得收货标准")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:receiving-standard:query')")
    public CommonResult<PurchaseReceivingStandardRespVO> getReceivingStandard(@RequestParam("id") Long id) {
        PurchaseReceivingStandardDO receivingStandard = receivingStandardService.getReceivingStandard(id);
        return success(PurchaseReceivingStandardConvert.INSTANCE.convert(receivingStandard));
    }

    @GetMapping("/list")
    @ApiOperation("获得收货标准列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:receiving-standard:query')")
    public CommonResult<List<PurchaseReceivingStandardRespVO>> getReceivingStandardList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseReceivingStandardDO> list = receivingStandardService.getReceivingStandardList(ids);
        return success(PurchaseReceivingStandardConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得收货标准分页")
    @PreAuthorize("@ss.hasPermission('purchase:receiving-standard:query')")
    public CommonResult<PageResult<PurchaseReceivingStandardRespVO>> getReceivingStandardPage(@Valid PurchaseReceivingStandardPageReqVO pageVO) {
        PageResult<PurchaseReceivingStandardDO> pageResult = receivingStandardService.getReceivingStandardPage(pageVO);
        return success(PurchaseReceivingStandardConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出收货标准 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:receiving-standard:export')")
    @OperateLog(type = EXPORT)
    public void exportReceivingStandardExcel(@Valid PurchaseReceivingStandardExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseReceivingStandardDO> list = receivingStandardService.getReceivingStandardList(exportReqVO);
        // 导出 Excel
        List<PurchaseReceivingStandardExcelVO> datas = PurchaseReceivingStandardConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "收货标准.xls", "数据", PurchaseReceivingStandardExcelVO.class, datas);
    }

}
