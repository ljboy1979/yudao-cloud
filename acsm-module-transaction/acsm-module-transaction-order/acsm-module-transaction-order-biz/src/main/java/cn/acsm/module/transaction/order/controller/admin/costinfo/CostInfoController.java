package cn.acsm.module.transaction.order.controller.admin.costinfo;

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

import cn.acsm.module.transaction.order.controller.admin.costinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.costinfo.CostInfoDO;
import cn.acsm.module.transaction.order.convert.costinfo.CostInfoConvert;
import cn.acsm.module.transaction.order.service.costinfo.CostInfoService;

@Api(tags = "管理后台 - 费用")
@RestController
@RequestMapping("/order/cost-info")
@Validated
public class CostInfoController {

    @Resource
    private CostInfoService costInfoService;

    @PostMapping("/create")
    @ApiOperation("创建费用")
    @PreAuthorize("@ss.hasPermission('order:cost-info:create')")
    public CommonResult<String> createCostInfo(@Valid @RequestBody CostInfoCreateReqVO createReqVO) {
        return success(costInfoService.createCostInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新费用")
    @PreAuthorize("@ss.hasPermission('order:cost-info:update')")
    public CommonResult<Boolean> updateCostInfo(@Valid @RequestBody CostInfoUpdateReqVO updateReqVO) {
        costInfoService.updateCostInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除费用")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:cost-info:delete')")
    public CommonResult<Boolean> deleteCostInfo(@RequestParam("id") String id) {
        costInfoService.deleteCostInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得费用")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('order:cost-info:query')")
    public CommonResult<CostInfoRespVO> getCostInfo(@RequestParam("id") String id) {
        CostInfoDO costInfo = costInfoService.getCostInfo(id);
        return success(CostInfoConvert.INSTANCE.convert(costInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得费用列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('order:cost-info:query')")
    public CommonResult<List<CostInfoRespVO>> getCostInfoList(@RequestParam("ids") Collection<String> ids) {
        List<CostInfoDO> list = costInfoService.getCostInfoList(ids);
        return success(CostInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得费用分页")
    @PreAuthorize("@ss.hasPermission('order:cost-info:query')")
    public CommonResult<PageResult<CostInfoRespVO>> getCostInfoPage(@Valid CostInfoPageReqVO pageVO) {
        PageResult<CostInfoDO> pageResult = costInfoService.getCostInfoPage(pageVO);
        return success(CostInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出费用 Excel")
    @PreAuthorize("@ss.hasPermission('order:cost-info:export')")
    @OperateLog(type = EXPORT)
    public void exportCostInfoExcel(@Valid CostInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CostInfoDO> list = costInfoService.getCostInfoList(exportReqVO);
        // 导出 Excel
        List<CostInfoExcelVO> datas = CostInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "费用.xls", "数据", CostInfoExcelVO.class, datas);
    }

}
