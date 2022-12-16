package cn.acsm.module.production.bases.controller.admin.subsidy;

import cn.acsm.module.production.bases.controller.admin.subsidy.vo.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

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

import cn.acsm.module.production.bases.controller.admin.subsidy.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.subsidy.SubsidyDO;
import cn.acsm.module.production.bases.convert.subsidy.SubsidyConvert;
import cn.acsm.module.production.bases.service.subsidy.SubsidyService;

@Api(tags = "管理后台 - 基地补贴信息")
@RestController
@RequestMapping("/bases/subsidy")
@Validated
public class SubsidyController {

    @Resource
    private SubsidyService subsidyService;

    @PostMapping("/create")
    @ApiOperation("创建基地补贴信息")
    @PreAuthorize("@ss.hasPermission('bases:subsidy:create')")
    public CommonResult<Long> createSubsidy(@Valid @RequestBody SubsidyCreateReqVO createReqVO) {
        return success(subsidyService.createSubsidy(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新基地补贴信息")
    @PreAuthorize("@ss.hasPermission('bases:subsidy:update')")
    public CommonResult<Boolean> updateSubsidy(@Valid @RequestBody SubsidyUpdateReqVO updateReqVO) {
        subsidyService.updateSubsidy(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除基地补贴信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:subsidy:delete')")
    public CommonResult<Boolean> deleteSubsidy(@RequestParam("id") Long id) {
        subsidyService.deleteSubsidy(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得基地补贴信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:subsidy:query')")
    public CommonResult<SubsidyRespVO> getSubsidy(@RequestParam("id") Long id) {
        SubsidyDO subsidy = subsidyService.getSubsidy(id);
        return success(SubsidyConvert.INSTANCE.convert(subsidy));
    }

    @GetMapping("/list")
    @ApiOperation("获得基地补贴信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bases:subsidy:query')")
    public CommonResult<List<SubsidyRespVO>> getSubsidyList(@RequestParam("ids") Collection<Long> ids) {
        List<SubsidyDO> list = subsidyService.getSubsidyList(ids);
        return success(SubsidyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得基地补贴信息分页")
    @PreAuthorize("@ss.hasPermission('bases:subsidy:query')")
    public CommonResult<PageResult<SubsidyRespVO>> getSubsidyPage(@Valid SubsidyPageReqVO pageVO) {
        PageResult<SubsidyDO> pageResult = subsidyService.getSubsidyPage(pageVO);
        return success(SubsidyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出基地补贴信息 Excel")
    @PreAuthorize("@ss.hasPermission('bases:subsidy:export')")
    @OperateLog(type = EXPORT)
    public void exportSubsidyExcel(@Valid SubsidyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SubsidyDO> list = subsidyService.getSubsidyList(exportReqVO);
        // 导出 Excel
        List<SubsidyExcelVO> datas = SubsidyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "基地补贴信息.xls", "数据", SubsidyExcelVO.class, datas);
    }

}
