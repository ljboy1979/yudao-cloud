package cn.acsm.module.member.user.controller.admin.patient;

import cn.acsm.module.member.user.controller.admin.patient.vo.medical.*;
import cn.acsm.module.member.user.convert.patienthealth.MedicalRecordConvert;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalRecordDO;
import cn.acsm.module.member.user.service.patienthealth.MedicalRecordService;
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


@Api(tags = "管理后台 - 医嘱记录")
@RestController
@RequestMapping("/member/medical-record")
@Validated
public class MedicalRecordController {

    @Resource
    private MedicalRecordService medicalRecordService;

    @PostMapping("/create")
    @ApiOperation("创建医嘱记录")
    @PreAuthorize("@ss.hasPermission('member:medical-record:create')")
    public CommonResult<Long> createMedicalRecord(@Valid @RequestBody MedicalRecordCreateReqVO createReqVO) {
        return success(medicalRecordService.createMedicalRecord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新医嘱记录")
    @PreAuthorize("@ss.hasPermission('member:medical-record:update')")
    public CommonResult<Boolean> updateMedicalRecord(@Valid @RequestBody MedicalRecordUpdateReqVO updateReqVO) {
        medicalRecordService.updateMedicalRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除医嘱记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:medical-record:delete')")
    public CommonResult<Boolean> deleteMedicalRecord(@RequestParam("id") Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得医嘱记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:medical-record:query')")
    public CommonResult<MedicalRecordRespVO> getMedicalRecord(@RequestParam("id") Long id) {
        MedicalRecordDO medicalRecord = medicalRecordService.getMedicalRecord(id);
        return success(MedicalRecordConvert.INSTANCE.convert(medicalRecord));
    }

    @GetMapping("/list")
    @ApiOperation("获得医嘱记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:medical-record:query')")
    public CommonResult<List<MedicalRecordRespVO>> getMedicalRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<MedicalRecordDO> list = medicalRecordService.getMedicalRecordList(ids);
        return success(MedicalRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得医嘱记录分页")
    @PreAuthorize("@ss.hasPermission('member:medical-record:query')")
    public CommonResult<PageResult<MedicalRecordRespVO>> getMedicalRecordPage(@Valid MedicalRecordPageReqVO pageVO) {
        PageResult<MedicalRecordDO> pageResult = medicalRecordService.getMedicalRecordPage(pageVO);
        return success(MedicalRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出医嘱记录 Excel")
    @PreAuthorize("@ss.hasPermission('member:medical-record:export')")
    @OperateLog(type = EXPORT)
    public void exportMedicalRecordExcel(@Valid MedicalRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MedicalRecordDO> list = medicalRecordService.getMedicalRecordList(exportReqVO);
        // 导出 Excel
        List<MedicalRecordExcelVO> datas = MedicalRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "医嘱记录.xls", "数据", MedicalRecordExcelVO.class, datas);
    }

}
