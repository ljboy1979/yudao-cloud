package cn.acsm.module.purchase.controller.admin.deliver;

import cn.acsm.module.purchase.api.orderdetails.vo.OrderDetailsApiVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.*;
import cn.acsm.module.purchase.convert.deliver.PurchaseDeliverConvert;
import cn.acsm.module.purchase.dal.dataobject.deliver.PurchaseDeliverDO;
import cn.acsm.module.purchase.service.deliver.PurchaseDeliverService;
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
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "管理后台 - 采购交付")
@RestController
@RequestMapping("/purchase/deliver")
@Validated
public class PurchaseDeliverController {

    @Resource
    private PurchaseDeliverService deliverService;

    @PostMapping("/create")
    @ApiOperation("创建采购交付")
    @PreAuthorize("@ss.hasPermission('purchase:deliver:create')")
    public CommonResult<Long> createDeliver(@Valid @RequestBody PurchaseDeliverCreateReqVO createReqVO) {
        return success(deliverService.createDeliver(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新采购交付")
    @PreAuthorize("@ss.hasPermission('purchase:deliver:update')")
    public CommonResult<Boolean> updateDeliver(@Valid @RequestBody PurchaseDeliverUpdateReqVO updateReqVO) {
        deliverService.updateDeliver(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除采购交付")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('purchase:deliver:delete')")
    public CommonResult<Boolean> deleteDeliver(@RequestParam("id") Long id) {
        deliverService.deleteDeliver(id);
        return success(true);
    }

//    @GetMapping("/get")
//    @ApiOperation("获得采购交付")
//    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
//    @PreAuthorize("@ss.hasPermission('purchase:deliver:query')")
//    public CommonResult<PurchaseDeliverRespVO> getDeliver(@RequestParam("id") Long id) {
//        PurchaseDeliverDO deliver = deliverService.getDeliver(id);
//        return success(PurchaseDeliverConvert.INSTANCE.convert(deliver));
//    }

    @GetMapping("/list")
    @ApiOperation("获得采购交付列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('purchase:deliver:query')")
    public CommonResult<List<PurchaseDeliverRespVO>> getDeliverList(@RequestParam("ids") Collection<Long> ids) {
        List<PurchaseDeliverDO> list = deliverService.getDeliverList(ids);
        return success(PurchaseDeliverConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得采购交付分页")
    @PreAuthorize("@ss.hasPermission('purchase:deliver:query')")
    public CommonResult<PageResult<PurchaseDeliverRespVO>> getDeliverPage(@Valid PurchaseDeliverPageReqVO pageVO) {
        PageResult<PurchaseDeliverDO> pageResult = deliverService.getDeliverPage(pageVO);
        return success(PurchaseDeliverConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出采购交付 Excel")
    @PreAuthorize("@ss.hasPermission('purchase:deliver:export')")
    @OperateLog(type = EXPORT)
    public void exportDeliverExcel(@Valid PurchaseDeliverExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PurchaseDeliverDO> list = deliverService.getDeliverList(exportReqVO);
        // 导出 Excel
        List<PurchaseDeliverExcelVO> datas = PurchaseDeliverConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "采购交付.xls", "数据", PurchaseDeliverExcelVO.class, datas);
    }

    @GetMapping("/delivery/count")
    @ApiOperation("根据采购单id获取交付数量")
    @PreAuthorize("@ss.hasPermission('purchase:deliver:count')")
    public CommonResult<BigDecimal> exportDeliverExcel(@Valid @RequestBody PurchaseDeliverReqCountVO reqCountVO) throws IOException {
        return success(deliverService.getDeliveryCount(reqCountVO));
    }

}
