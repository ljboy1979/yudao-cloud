package cn.acsm.module.transaction.order.controller.admin.sartinfo;

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

import cn.acsm.module.transaction.order.controller.admin.sartinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.sartinfo.SartInfoDO;
import cn.acsm.module.transaction.order.convert.sartinfo.SartInfoConvert;
import cn.acsm.module.transaction.order.service.sartinfo.SartInfoService;

@Api(tags = "管理后台 - 购物车")
@RestController
@RequestMapping("/order/sart-info")
@Validated
public class SartInfoController {

    @Resource
    private SartInfoService sartInfoService;

    @PostMapping("/create")
    @ApiOperation("创建购物车")
    @PreAuthorize("@ss.hasPermission('order:sart-info:create')")
    public CommonResult<String> createSartInfo(@Valid @RequestBody SartInfoCreateReqVO createReqVO) {
        return success(sartInfoService.createSartInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新购物车")
    @PreAuthorize("@ss.hasPermission('order:sart-info:update')")
    public CommonResult<Boolean> updateSartInfo(@Valid @RequestBody SartInfoUpdateReqVO updateReqVO) {
        sartInfoService.updateSartInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除购物车")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:sart-info:delete')")
    public CommonResult<Boolean> deleteSartInfo(@RequestParam("id") String id) {
        sartInfoService.deleteSartInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得购物车")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:sart-info:query')")
    public CommonResult<SartInfoRespVO> getSartInfo(@RequestParam("id") String id) {
        SartInfoDO sartInfo = sartInfoService.getSartInfo(id);
        return success(SartInfoConvert.INSTANCE.convert(sartInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得购物车列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:sart-info:query')")
    public CommonResult<List<SartInfoRespVO>> getSartInfoList(@RequestParam("ids") Collection<String> ids) {
        List<SartInfoDO> list = sartInfoService.getSartInfoList(ids);
        return success(SartInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得购物车分页")
    @PreAuthorize("@ss.hasPermission('order:sart-info:query')")
    public CommonResult<PageResult<SartInfoRespVO>> getSartInfoPage(@Valid SartInfoPageReqVO pageVO) {
        PageResult<SartInfoDO> pageResult = sartInfoService.getSartInfoPage(pageVO);
        return success(SartInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出购物车 Excel")
    @PreAuthorize("@ss.hasPermission('order:sart-info:export')")
    @OperateLog(type = EXPORT)
    public void exportSartInfoExcel(@Valid SartInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SartInfoDO> list = sartInfoService.getSartInfoList(exportReqVO);
        // 导出 Excel
        List<SartInfoExcelVO> datas = SartInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "购物车.xls", "数据", SartInfoExcelVO.class, datas);
    }

}
