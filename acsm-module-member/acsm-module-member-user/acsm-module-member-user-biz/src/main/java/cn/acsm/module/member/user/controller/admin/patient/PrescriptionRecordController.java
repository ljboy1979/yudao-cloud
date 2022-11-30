package cn.acsm.module.member.user.controller.admin.patient;

import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.*;
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

import cn.acsm.module.member.user.dal.dataobject.patienthealth.PrescriptionRecordDO;
import cn.acsm.module.member.user.convert.patienthealth.PrescriptionRecordConvert;
import cn.acsm.module.member.user.service.patienthealth.PrescriptionRecordService;

@Api(tags = "管理后台 - 处方记录表")
@RestController
@RequestMapping("/member/prescription-record")
@Validated
public class PrescriptionRecordController {

    @Resource
    private PrescriptionRecordService prescriptionRecordService;

    @PostMapping("/create")
    @ApiOperation("创建处方记录表")
    @PreAuthorize("@ss.hasPermission('member:prescription-record:create')")
    public CommonResult<Long> createPrescriptionRecord(@Valid @RequestBody PrescriptionRecordCreateReqVO createReqVO) {
        return success(prescriptionRecordService.createPrescriptionRecord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新处方记录表")
    @PreAuthorize("@ss.hasPermission('member:prescription-record:update')")
    public CommonResult<Boolean> updatePrescriptionRecord(@Valid @RequestBody PrescriptionRecordUpdateReqVO updateReqVO) {
        prescriptionRecordService.updatePrescriptionRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除处方记录表")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:prescription-record:delete')")
    public CommonResult<Boolean> deletePrescriptionRecord(@RequestParam("id") Long id) {
        prescriptionRecordService.deletePrescriptionRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得处方记录表")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:prescription-record:query')")
    public CommonResult<PrescriptionRecordRespVO> getPrescriptionRecord(@RequestParam("id") Long id) {
        PrescriptionRecordDO prescriptionRecord = prescriptionRecordService.getPrescriptionRecord(id);
        return success(PrescriptionRecordConvert.INSTANCE.convert(prescriptionRecord));
    }

    @GetMapping("/list")
    @ApiOperation("获得处方记录表列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:prescription-record:query')")
    public CommonResult<List<PrescriptionRecordRespVO>> getPrescriptionRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<PrescriptionRecordDO> list = prescriptionRecordService.getPrescriptionRecordList(ids);
        return success(PrescriptionRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得处方记录表分页")
    @PreAuthorize("@ss.hasPermission('member:prescription-record:query')")
    public CommonResult<PageResult<PrescriptionRecordRespVO>> getPrescriptionRecordPage(@Valid PrescriptionRecordPageReqVO pageVO) {
        PageResult<PrescriptionRecordDO> pageResult = prescriptionRecordService.getPrescriptionRecordPage(pageVO);
        return success(PrescriptionRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出处方记录表 Excel")
    @PreAuthorize("@ss.hasPermission('member:prescription-record:export')")
    @OperateLog(type = EXPORT)
    public void exportPrescriptionRecordExcel(@Valid PrescriptionRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PrescriptionRecordDO> list = prescriptionRecordService.getPrescriptionRecordList(exportReqVO);
        // 导出 Excel
        List<PrescriptionRecordExcelVO> datas = PrescriptionRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "处方记录表.xls", "数据", PrescriptionRecordExcelVO.class, datas);
    }

}
