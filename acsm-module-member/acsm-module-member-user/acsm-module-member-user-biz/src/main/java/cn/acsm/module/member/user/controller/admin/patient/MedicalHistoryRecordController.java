package cn.acsm.module.member.user.controller.admin.patient;

import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.*;
import cn.acsm.module.member.user.convert.patienthealth.MedicalHistoryRecordConvert;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalHistoryRecordDO;
import cn.acsm.module.member.user.service.patienthealth.MedicalHistoryRecordService;
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


@Api(tags = "管理后台 - 病史记录")
@RestController
@RequestMapping("/member/medical-history-record")
@Validated
public class MedicalHistoryRecordController {

    @Resource
    private MedicalHistoryRecordService medicalHistoryRecordService;

    @PostMapping("/create")
    @ApiOperation("创建病史记录")
    @PreAuthorize("@ss.hasPermission('member:medical-history-record:create')")
    public CommonResult<Long> createMedicalHistoryRecord(@Valid @RequestBody MedicalHistoryRecordCreateReqVO createReqVO) {
        return success(medicalHistoryRecordService.createMedicalHistoryRecord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新病史记录")
    @PreAuthorize("@ss.hasPermission('member:medical-history-record:update')")
    public CommonResult<Boolean> updateMedicalHistoryRecord(@Valid @RequestBody MedicalHistoryRecordUpdateReqVO updateReqVO) {
        medicalHistoryRecordService.updateMedicalHistoryRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除病史记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:medical-history-record:delete')")
    public CommonResult<Boolean> deleteMedicalHistoryRecord(@RequestParam("id") Long id) {
        medicalHistoryRecordService.deleteMedicalHistoryRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得病史记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:medical-history-record:query')")
    public CommonResult<MedicalHistoryRecordRespVO> getMedicalHistoryRecord(@RequestParam("id") Long id) {
        MedicalHistoryRecordDO medicalHistoryRecord = medicalHistoryRecordService.getMedicalHistoryRecord(id);
        return success(MedicalHistoryRecordConvert.INSTANCE.convert(medicalHistoryRecord));
    }

    @GetMapping("/list")
    @ApiOperation("获得病史记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:medical-history-record:query')")
    public CommonResult<List<MedicalHistoryRecordRespVO>> getMedicalHistoryRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<MedicalHistoryRecordDO> list = medicalHistoryRecordService.getMedicalHistoryRecordList(ids);
        return success(MedicalHistoryRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得病史记录分页")
    @PreAuthorize("@ss.hasPermission('member:medical-history-record:query')")
    public CommonResult<PageResult<MedicalHistoryRecordRespVO>> getMedicalHistoryRecordPage(@Valid MedicalHistoryRecordPageReqVO pageVO) {
        PageResult<MedicalHistoryRecordDO> pageResult = medicalHistoryRecordService.getMedicalHistoryRecordPage(pageVO);
        return success(MedicalHistoryRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出病史记录 Excel")
    @PreAuthorize("@ss.hasPermission('member:medical-history-record:export')")
    @OperateLog(type = EXPORT)
    public void exportMedicalHistoryRecordExcel(@Valid MedicalHistoryRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MedicalHistoryRecordDO> list = medicalHistoryRecordService.getMedicalHistoryRecordList(exportReqVO);
        // 导出 Excel
        List<MedicalHistoryRecordExcelVO> datas = MedicalHistoryRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "病史记录.xls", "数据", MedicalHistoryRecordExcelVO.class, datas);
    }

}
