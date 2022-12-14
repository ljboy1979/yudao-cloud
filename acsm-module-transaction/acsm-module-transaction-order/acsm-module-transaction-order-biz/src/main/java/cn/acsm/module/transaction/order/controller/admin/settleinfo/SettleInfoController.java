package cn.acsm.module.transaction.order.controller.admin.settleinfo;

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

import cn.acsm.module.transaction.order.controller.admin.settleinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.settleinfo.SettleInfoDO;
import cn.acsm.module.transaction.order.convert.settleinfo.SettleInfoConvert;
import cn.acsm.module.transaction.order.service.settleinfo.SettleInfoService;

@Api(tags = "管理后台 - 订单结账")
@RestController
@RequestMapping("/order/settle-info")
@Validated
public class SettleInfoController {

    @Resource
    private SettleInfoService settleInfoService;

    @PostMapping("/create")
    @ApiOperation("创建订单结账")
    @PreAuthorize("@ss.hasPermission('order:info:create')")
    public CommonResult<String> createSettleInfo(@Valid @RequestBody SettleInfoCreateReqVO createReqVO) {
        return success(settleInfoService.createSettleInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新订单结账")
    @PreAuthorize("@ss.hasPermission('order:settle-info:update')")
    public CommonResult<Boolean> updateSettleInfo(@Valid @RequestBody SettleInfoUpdateReqVO updateReqVO) {
        settleInfoService.updateSettleInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除订单结账")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:settle-info:delete')")
    public CommonResult<Boolean> deleteSettleInfo(@RequestParam("id") String id) {
        settleInfoService.deleteSettleInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得订单结账")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:settle-info:query')")
    public CommonResult<SettleInfoRespVO> getSettleInfo(@RequestParam("id") String id) {
        SettleInfoDO settleInfo = settleInfoService.getSettleInfo(id);
        return success(SettleInfoConvert.INSTANCE.convert(settleInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得订单结账列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:settle-info:query')")
    public CommonResult<List<SettleInfoRespVO>> getSettleInfoList(@RequestParam("ids") Collection<String> ids) {
        List<SettleInfoDO> list = settleInfoService.getSettleInfoList(ids);
        return success(SettleInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得订单结账分页")
    @PreAuthorize("@ss.hasPermission('order:settle-info:query')")
    public CommonResult<PageResult<SettleInfoRespVO>> getSettleInfoPage(@Valid SettleInfoPageReqVO pageVO) {
        PageResult<SettleInfoDO> pageResult = settleInfoService.getSettleInfoPage(pageVO);
        return success(SettleInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出订单结账 Excel")
    @PreAuthorize("@ss.hasPermission('order:settle-info:export')")
    @OperateLog(type = EXPORT)
    public void exportSettleInfoExcel(@Valid SettleInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SettleInfoDO> list = settleInfoService.getSettleInfoList(exportReqVO);
        // 导出 Excel
        List<SettleInfoExcelVO> datas = SettleInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "订单结账.xls", "数据", SettleInfoExcelVO.class, datas);
    }

}
