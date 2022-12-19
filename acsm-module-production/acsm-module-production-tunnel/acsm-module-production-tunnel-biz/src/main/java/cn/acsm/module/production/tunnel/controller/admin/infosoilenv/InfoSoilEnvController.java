package cn.acsm.module.production.tunnel.controller.admin.infosoilenv;

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

import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.infosoilenv.InfoSoilEnvDO;
import cn.acsm.module.production.tunnel.convert.infosoilenv.InfoSoilEnvConvert;
import cn.acsm.module.production.tunnel.service.infosoilenv.InfoSoilEnvService;

@Api(tags = "管理后台 - 地块土壤环境")
@RestController
@RequestMapping("/tunnel/info-soil-env")
@Validated
public class InfoSoilEnvController {

    @Resource
    private InfoSoilEnvService infoSoilEnvService;

    @PostMapping("/create")
    @ApiOperation("创建地块土壤环境")
    @PreAuthorize("@ss.hasPermission('tunnel:info-soil-env:create')")
    public CommonResult<Long> createInfoSoilEnv(@Valid @RequestBody InfoSoilEnvCreateReqVO createReqVO) {
        return success(infoSoilEnvService.createInfoSoilEnv(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新地块土壤环境")
    @PreAuthorize("@ss.hasPermission('tunnel:info-soil-env:update')")
    public CommonResult<Boolean> updateInfoSoilEnv(@Valid @RequestBody InfoSoilEnvUpdateReqVO updateReqVO) {
        infoSoilEnvService.updateInfoSoilEnv(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除地块土壤环境")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('tunnel:info-soil-env:delete')")
    public CommonResult<Boolean> deleteInfoSoilEnv(@RequestParam("id") Long id) {
        infoSoilEnvService.deleteInfoSoilEnv(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得地块土壤环境")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('tunnel:info-soil-env:query')")
    public CommonResult<InfoSoilEnvRespVO> getInfoSoilEnv(@RequestParam("id") Long id) {
        InfoSoilEnvDO infoSoilEnv = infoSoilEnvService.getInfoSoilEnv(id);
        return success(InfoSoilEnvConvert.INSTANCE.convert(infoSoilEnv));
    }

    @GetMapping("/list")
    @ApiOperation("获得地块土壤环境列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('tunnel:info-soil-env:query')")
    public CommonResult<List<InfoSoilEnvRespVO>> getInfoSoilEnvList(@RequestParam("ids") Collection<Long> ids) {
        List<InfoSoilEnvDO> list = infoSoilEnvService.getInfoSoilEnvList(ids);
        return success(InfoSoilEnvConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得地块土壤环境分页")
    @PreAuthorize("@ss.hasPermission('tunnel:info-soil-env:query')")
    public CommonResult<PageResult<InfoSoilEnvRespVO>> getInfoSoilEnvPage(@Valid InfoSoilEnvPageReqVO pageVO) {
        PageResult<InfoSoilEnvDO> pageResult = infoSoilEnvService.getInfoSoilEnvPage(pageVO);
        return success(InfoSoilEnvConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出地块土壤环境 Excel")
    @PreAuthorize("@ss.hasPermission('tunnel:info-soil-env:export')")
    @OperateLog(type = EXPORT)
    public void exportInfoSoilEnvExcel(@Valid InfoSoilEnvExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<InfoSoilEnvDO> list = infoSoilEnvService.getInfoSoilEnvList(exportReqVO);
        // 导出 Excel
        List<InfoSoilEnvExcelVO> datas = InfoSoilEnvConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "地块土壤环境.xls", "数据", InfoSoilEnvExcelVO.class, datas);
    }

}
