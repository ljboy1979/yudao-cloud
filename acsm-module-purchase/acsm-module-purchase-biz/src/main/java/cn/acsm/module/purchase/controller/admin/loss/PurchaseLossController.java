package cn.acsm.module.purchase.controller.admin.loss;

import cn.acsm.module.purchase.controller.admin.loss.vo.*;
import cn.acsm.module.purchase.convert.loss.PurchaseLossConvert;
import cn.acsm.module.purchase.dal.dataobject.loss.PurchaseLossDO;
import cn.acsm.module.purchase.service.loss.PurchaseLossService;
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

@Api(tags = "管理后台 - 损耗")
@RestController
@RequestMapping("/purchase/loss")
@Validated
public class PurchaseLossController {

    @Resource
    private PurchaseLossService lossService;

    @PostMapping("/create")
    @ApiOperation("创建损耗")
    @PreAuthorize("@ss.hasPermission('purchase:loss:create')")
    public CommonResult<Long> createLoss(@Valid @RequestBody PurchaseLossCreateReqVO createReqVO) {
        return success(lossService.createLoss(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新损耗")
    @PreAuthorize("@ss.hasPermission('purchase:loss:update')")
    public CommonResult<Boolean> updateLoss(@Valid @RequestBody PurchaseLossUpdateReqVO updateReqVO) {
        lossService.updateLoss(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除损耗")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:loss:delete')")
    public CommonResult<Boolean> deleteLoss(@RequestParam("id") Long id) {
        lossService.deleteLoss(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得损耗")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:loss:query')")
    public CommonResult<PurchaseLossRespVO> getLoss(@RequestParam("id") Long id) {
        PurchaseLossDO loss = lossService.getLoss(id);
        return success(PurchaseLossConvert.INSTANCE.convert(loss));
    }

    @GetMapping("/list")
    @ApiOperation("获得损耗列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:loss:query')")
    public CommonResult<List<PurchaseLossRespVO>> getLossList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseLossDO> list = lossService.getLossList(ids);
        return success(PurchaseLossConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得损耗分页")
    @PreAuthorize("@ss.hasPermission('purchase:loss:query')")
    public CommonResult<PageResult<PurchaseLossRespVO>> getLossPage(@Valid PurchaseLossPageReqVO pageVO) {
        PageResult<PurchaseLossDO> pageResult = lossService.getLossPage(pageVO);
        return success(PurchaseLossConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出损耗 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:loss:export')")
    @OperateLog(type = EXPORT)
    public void exportLossExcel(@Valid PurchaseLossExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseLossDO> list = lossService.getLossList(exportReqVO);
        // 导出 Excel
        List<PurchaseLossExcelVO> datas = PurchaseLossConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "损耗.xls", "数据", PurchaseLossExcelVO.class, datas);
    }

}
