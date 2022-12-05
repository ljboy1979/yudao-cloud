package cn.acsm.module.member.user.controller.admin.patient;

import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.*;
import cn.acsm.module.member.user.convert.patienthealth.PatientHealthConvert;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PatientHealthDO;
import cn.acsm.module.member.user.service.patienthealth.PatientHealthService;
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


@Api(tags = "管理后台 - 健康档案")
@RestController
@RequestMapping("/member/patient-health")
@Validated
public class PatientHealthController {

    @Resource
    private PatientHealthService patientHealthService;

    @PostMapping("/create")
    @ApiOperation("创建健康档案")
    @PreAuthorize("@ss.hasPermission('member:patient-health:create')")
    public CommonResult<Long> createPatientHealth(@Valid @RequestBody PatientHealthCreateReqVO createReqVO) {
        return success(patientHealthService.createPatientHealth(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新健康档案")
    @PreAuthorize("@ss.hasPermission('member:patient-health:update')")
    public CommonResult<Boolean> updatePatientHealth(@Valid @RequestBody PatientHealthUpdateReqVO updateReqVO) {
        patientHealthService.updatePatientHealth(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除健康档案")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:patient-health:delete')")
    public CommonResult<Boolean> deletePatientHealth(@RequestParam("id") Long id) {
        patientHealthService.deletePatientHealth(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得健康档案")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:patient-health:query')")
    public CommonResult<PatientHealthRespVO> getPatientHealth(@RequestParam("id") Long id) {
        PatientHealthDO patientHealth = patientHealthService.getPatientHealth(id);
        return success(PatientHealthConvert.INSTANCE.convert(patientHealth));
    }

    @GetMapping("/list")
    @ApiOperation("获得健康档案列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:patient-health:query')")
    public CommonResult<List<PatientHealthRespVO>> getPatientHealthList(@RequestParam("ids") Collection<Long> ids) {
        List<PatientHealthDO> list = patientHealthService.getPatientHealthList(ids);
        return success(PatientHealthConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得健康档案分页")
    @PreAuthorize("@ss.hasPermission('member:patient-health:query')")
    public CommonResult<PageResult<PatientHealthRespVO>> getPatientHealthPage(@Valid PatientHealthPageReqVO pageVO) {
        PageResult<PatientHealthDO> pageResult = patientHealthService.getPatientHealthPage(pageVO);
        PageResult<PatientHealthRespVO> a = PatientHealthConvert.INSTANCE.convertPage(pageResult);
        return success(a);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出健康档案 Excel")
    @PreAuthorize("@ss.hasPermission('member:patient-health:export')")
    @OperateLog(type = EXPORT)
    public void exportPatientHealthExcel(@Valid PatientHealthExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PatientHealthDO> list = patientHealthService.getPatientHealthList(exportReqVO);
        // 导出 Excel
        List<PatientHealthExcelVO> datas = PatientHealthConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "健康档案.xls", "数据", PatientHealthExcelVO.class, datas);
    }

}
