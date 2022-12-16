package cn.acsm.module.production.bases.controller.admin.soilenv;

import cn.acsm.module.production.bases.controller.admin.soilenv.vo.*;
import cn.acsm.module.production.bases.convert.soilenv.SoilEnvConvert;
import cn.acsm.module.production.bases.dal.dataobject.soilenv.SoilEnvDO;
import cn.acsm.module.production.bases.service.soilenv.SoilEnvService;
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

@Api(tags = "管理后台 - 基地土壤环境")
@RestController
@RequestMapping("/bases/soil-env")
@Validated
public class SoilEnvController {

    @Resource
    private SoilEnvService soilEnvService;

    @PostMapping("/create")
    @ApiOperation("创建基地土壤环境")
    @PreAuthorize("@ss.hasPermission('bases:soil-env:create')")
    public CommonResult<Long> createSoilEnv(@Valid @RequestBody SoilEnvCreateReqVO createReqVO) {
        return success(soilEnvService.createSoilEnv(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新基地土壤环境")
    @PreAuthorize("@ss.hasPermission('bases:soil-env:update')")
    public CommonResult<Boolean> updateSoilEnv(@Valid @RequestBody SoilEnvUpdateReqVO updateReqVO) {
        soilEnvService.updateSoilEnv(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除基地土壤环境")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:soil-env:delete')")
    public CommonResult<Boolean> deleteSoilEnv(@RequestParam("id") Long id) {
        soilEnvService.deleteSoilEnv(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得基地土壤环境")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bases:soil-env:query')")
    public CommonResult<SoilEnvRespVO> getSoilEnv(@RequestParam("id") Long id) {
        SoilEnvDO soilEnv = soilEnvService.getSoilEnv(id);
        return success(SoilEnvConvert.INSTANCE.convert(soilEnv));
    }

    @GetMapping("/list")
    @ApiOperation("获得基地土壤环境列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bases:soil-env:query')")
    public CommonResult<List<SoilEnvRespVO>> getSoilEnvList(@RequestParam("ids") Collection<Long> ids) {
        List<SoilEnvDO> list = soilEnvService.getSoilEnvList(ids);
        return success(SoilEnvConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得基地土壤环境分页")
    @PreAuthorize("@ss.hasPermission('bases:soil-env:query')")
    public CommonResult<PageResult<SoilEnvRespVO>> getSoilEnvPage(@Valid SoilEnvPageReqVO pageVO) {
        PageResult<SoilEnvDO> pageResult = soilEnvService.getSoilEnvPage(pageVO);
        return success(SoilEnvConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出基地土壤环境 Excel")
    @PreAuthorize("@ss.hasPermission('bases:soil-env:export')")
    @OperateLog(type = EXPORT)
    public void exportSoilEnvExcel(@Valid SoilEnvExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SoilEnvDO> list = soilEnvService.getSoilEnvList(exportReqVO);
        // 导出 Excel
        List<SoilEnvExcelVO> datas = SoilEnvConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "基地土壤环境.xls", "数据", SoilEnvExcelVO.class, datas);
    }

}
