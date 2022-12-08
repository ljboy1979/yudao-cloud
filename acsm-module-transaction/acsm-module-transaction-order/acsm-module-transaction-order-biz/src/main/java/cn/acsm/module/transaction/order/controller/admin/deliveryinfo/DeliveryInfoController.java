package cn.acsm.module.transaction.order.controller.admin.deliveryinfo;

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

import cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.deliveryinfo.DeliveryInfoDO;
import cn.acsm.module.transaction.order.convert.deliveryinfo.DeliveryInfoConvert;
import cn.acsm.module.transaction.order.service.deliveryinfo.DeliveryInfoService;

@Api(tags = "管理后台 - 配送")
@RestController
@RequestMapping("/order/delivery-info")
@Validated
public class DeliveryInfoController {

    @Resource
    private DeliveryInfoService deliveryInfoService;

    @PostMapping("/create")
    @ApiOperation("创建配送")
    @PreAuthorize("@ss.hasPermission('order:delivery-info:create')")
    public CommonResult<String> createDeliveryInfo(@Valid @RequestBody DeliveryInfoCreateReqVO createReqVO) {
        return success(deliveryInfoService.createDeliveryInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新配送")
    @PreAuthorize("@ss.hasPermission('order:delivery-info:update')")
    public CommonResult<Boolean> updateDeliveryInfo(@Valid @RequestBody DeliveryInfoUpdateReqVO updateReqVO) {
        deliveryInfoService.updateDeliveryInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除配送")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:delivery-info:delete')")
    public CommonResult<Boolean> deleteDeliveryInfo(@RequestParam("id") String id) {
        deliveryInfoService.deleteDeliveryInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得配送")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:delivery-info:query')")
    public CommonResult<DeliveryInfoRespVO> getDeliveryInfo(@RequestParam("id") String id) {
        DeliveryInfoDO deliveryInfo = deliveryInfoService.getDeliveryInfo(id);
        return success(DeliveryInfoConvert.INSTANCE.convert(deliveryInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得配送列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:delivery-info:query')")
    public CommonResult<List<DeliveryInfoRespVO>> getDeliveryInfoList(@RequestParam("ids") Collection<String> ids) {
        List<DeliveryInfoDO> list = deliveryInfoService.getDeliveryInfoList(ids);
        return success(DeliveryInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得配送分页")
    @PreAuthorize("@ss.hasPermission('order:delivery-info:query')")
    public CommonResult<PageResult<DeliveryInfoRespVO>> getDeliveryInfoPage(@Valid DeliveryInfoPageReqVO pageVO) {
        PageResult<DeliveryInfoDO> pageResult = deliveryInfoService.getDeliveryInfoPage(pageVO);
        return success(DeliveryInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出配送 Excel")
    @PreAuthorize("@ss.hasPermission('order:delivery-info:export')")
    @OperateLog(type = EXPORT)
    public void exportDeliveryInfoExcel(@Valid DeliveryInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DeliveryInfoDO> list = deliveryInfoService.getDeliveryInfoList(exportReqVO);
        // 导出 Excel
        List<DeliveryInfoExcelVO> datas = DeliveryInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "配送.xls", "数据", DeliveryInfoExcelVO.class, datas);
    }

}
