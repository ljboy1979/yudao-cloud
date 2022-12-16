package cn.acsm.module.production.bases.controller.admin.phenologicalenv;

import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.*;
import cn.acsm.module.production.bases.convert.phenologicalenv.PhenologicalEnvConvert;
import cn.acsm.module.production.bases.dal.dataobject.phenologicalenv.PhenologicalEnvDO;
import cn.acsm.module.production.bases.service.phenologicalenv.PhenologicalEnvService;
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

@Api(tags = "管理后台 - 基地物候环境")
@RestController
@RequestMapping("/bases/phenological-env")
@Validated
public class PhenologicalEnvController {

    @Resource
    private PhenologicalEnvService phenologicalEnvService;

    @PostMapping("/create")
    @ApiOperation("创建基地物候环境")
    @PreAuthorize("@ss.hasPermission('bases:phenological-env:create')")
    public CommonResult<Long> createPhenologicalEnv(@Valid @RequestBody PhenologicalEnvCreateReqVO createReqVO) {
        return success(phenologicalEnvService.createPhenologicalEnv(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新基地物候环境")
    @PreAuthorize("@ss.hasPermission('bases:phenological-env:update')")
    public CommonResult<Boolean> updatePhenologicalEnv(@Valid @RequestBody PhenologicalEnvUpdateReqVO updateReqVO) {
        phenologicalEnvService.updatePhenologicalEnv(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除基地物候环境")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:phenological-env:delete')")
    public CommonResult<Boolean> deletePhenologicalEnv(@RequestParam("id") Long id) {
        phenologicalEnvService.deletePhenologicalEnv(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得基地物候环境")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:phenological-env:query')")
    public CommonResult<PhenologicalEnvRespVO> getPhenologicalEnv(@RequestParam("id") Long id) {
        PhenologicalEnvDO phenologicalEnv = phenologicalEnvService.getPhenologicalEnv(id);
        return success(PhenologicalEnvConvert.INSTANCE.convert(phenologicalEnv));
    }

    @GetMapping("/list")
    @ApiOperation("获得基地物候环境列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bases:phenological-env:query')")
    public CommonResult<List<PhenologicalEnvRespVO>> getPhenologicalEnvList(@RequestParam("ids") Collection<Long> ids) {
        List<PhenologicalEnvDO> list = phenologicalEnvService.getPhenologicalEnvList(ids);
        return success(PhenologicalEnvConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得基地物候环境分页")
    @PreAuthorize("@ss.hasPermission('bases:phenological-env:query')")
    public CommonResult<PageResult<PhenologicalEnvRespVO>> getPhenologicalEnvPage(@Valid PhenologicalEnvPageReqVO pageVO) {
        PageResult<PhenologicalEnvDO> pageResult = phenologicalEnvService.getPhenologicalEnvPage(pageVO);
        return success(PhenologicalEnvConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出基地物候环境 Excel")
    @PreAuthorize("@ss.hasPermission('bases:phenological-env:export')")
    @OperateLog(type = EXPORT)
    public void exportPhenologicalEnvExcel(@Valid PhenologicalEnvExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PhenologicalEnvDO> list = phenologicalEnvService.getPhenologicalEnvList(exportReqVO);
        // 导出 Excel
        List<PhenologicalEnvExcelVO> datas = PhenologicalEnvConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "基地物候环境.xls", "数据", PhenologicalEnvExcelVO.class, datas);
    }

}
