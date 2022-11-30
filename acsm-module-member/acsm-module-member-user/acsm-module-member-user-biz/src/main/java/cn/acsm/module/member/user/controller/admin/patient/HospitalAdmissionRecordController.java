package cn.acsm.module.member.user.controller.admin.patient;

import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.*;
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

import cn.acsm.module.member.user.dal.dataobject.patienthealth.HospitalAdmissionRecordDO;
import cn.acsm.module.member.user.convert.patienthealth.HospitalAdmissionRecordConvert;
import cn.acsm.module.member.user.service.patienthealth.HospitalAdmissionRecordService;

@Api(tags = "管理后台 - 住院记录")
@RestController
@RequestMapping("/member/hospital-admission-record")
@Validated
public class HospitalAdmissionRecordController {

    @Resource
    private HospitalAdmissionRecordService hospitalAdmissionRecordService;

    @PostMapping("/create")
    @ApiOperation("创建住院记录")
    @PreAuthorize("@ss.hasPermission('member:hospital-admission-record:create')")
    public CommonResult<Long> createHospitalAdmissionRecord(@Valid @RequestBody HospitalAdmissionRecordCreateReqVO createReqVO) {
        return success(hospitalAdmissionRecordService.createHospitalAdmissionRecord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新住院记录")
    @PreAuthorize("@ss.hasPermission('member:hospital-admission-record:update')")
    public CommonResult<Boolean> updateHospitalAdmissionRecord(@Valid @RequestBody HospitalAdmissionRecordUpdateReqVO updateReqVO) {
        hospitalAdmissionRecordService.updateHospitalAdmissionRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除住院记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:hospital-admission-record:delete')")
    public CommonResult<Boolean> deleteHospitalAdmissionRecord(@RequestParam("id") Long id) {
        hospitalAdmissionRecordService.deleteHospitalAdmissionRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得住院记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:hospital-admission-record:query')")
    public CommonResult<HospitalAdmissionRecordRespVO> getHospitalAdmissionRecord(@RequestParam("id") Long id) {
        HospitalAdmissionRecordDO hospitalAdmissionRecord = hospitalAdmissionRecordService.getHospitalAdmissionRecord(id);
        return success(HospitalAdmissionRecordConvert.INSTANCE.convert(hospitalAdmissionRecord));
    }

    @GetMapping("/list")
    @ApiOperation("获得住院记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:hospital-admission-record:query')")
    public CommonResult<List<HospitalAdmissionRecordRespVO>> getHospitalAdmissionRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<HospitalAdmissionRecordDO> list = hospitalAdmissionRecordService.getHospitalAdmissionRecordList(ids);
        return success(HospitalAdmissionRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得住院记录分页")
    @PreAuthorize("@ss.hasPermission('member:hospital-admission-record:query')")
    public CommonResult<PageResult<HospitalAdmissionRecordRespVO>> getHospitalAdmissionRecordPage(@Valid HospitalAdmissionRecordPageReqVO pageVO) {
        PageResult<HospitalAdmissionRecordDO> pageResult = hospitalAdmissionRecordService.getHospitalAdmissionRecordPage(pageVO);
        return success(HospitalAdmissionRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出住院记录 Excel")
    @PreAuthorize("@ss.hasPermission('member:hospital-admission-record:export')")
    @OperateLog(type = EXPORT)
    public void exportHospitalAdmissionRecordExcel(@Valid HospitalAdmissionRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<HospitalAdmissionRecordDO> list = hospitalAdmissionRecordService.getHospitalAdmissionRecordList(exportReqVO);
        // 导出 Excel
        List<HospitalAdmissionRecordExcelVO> datas = HospitalAdmissionRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "住院记录.xls", "数据", HospitalAdmissionRecordExcelVO.class, datas);
    }

}
