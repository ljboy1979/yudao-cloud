package cn.acsm.module.member.user.controller.admin.patient;

import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.*;
import cn.acsm.module.member.user.convert.patienthealth.NutritionExaminationRecordConvert;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.NutritionExaminationRecordDO;
import cn.acsm.module.member.user.service.patienthealth.NutritionExaminationRecordService;
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


@Api(tags = "管理后台 - 营养检查记录")
@RestController
@RequestMapping("/member/nutrition-examination-record")
@Validated
public class NutritionExaminationRecordController {

    @Resource
    private NutritionExaminationRecordService nutritionExaminationRecordService;

    @PostMapping("/create")
    @ApiOperation("创建营养检查记录")
    @PreAuthorize("@ss.hasPermission('member:nutrition-examination-record:create')")
    public CommonResult<Long> createNutritionExaminationRecord(@Valid @RequestBody NutritionExaminationRecordCreateReqVO createReqVO) {
        return success(nutritionExaminationRecordService.createNutritionExaminationRecord(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新营养检查记录")
    @PreAuthorize("@ss.hasPermission('member:nutrition-examination-record:update')")
    public CommonResult<Boolean> updateNutritionExaminationRecord(@Valid @RequestBody NutritionExaminationRecordUpdateReqVO updateReqVO) {
        nutritionExaminationRecordService.updateNutritionExaminationRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除营养检查记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:nutrition-examination-record:delete')")
    public CommonResult<Boolean> deleteNutritionExaminationRecord(@RequestParam("id") Long id) {
        nutritionExaminationRecordService.deleteNutritionExaminationRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得营养检查记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:nutrition-examination-record:query')")
    public CommonResult<NutritionExaminationRecordRespVO> getNutritionExaminationRecord(@RequestParam("id") Long id) {
        NutritionExaminationRecordDO nutritionExaminationRecord = nutritionExaminationRecordService.getNutritionExaminationRecord(id);
        return success(NutritionExaminationRecordConvert.INSTANCE.convert(nutritionExaminationRecord));
    }

    @GetMapping("/list")
    @ApiOperation("获得营养检查记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:nutrition-examination-record:query')")
    public CommonResult<List<NutritionExaminationRecordRespVO>> getNutritionExaminationRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<NutritionExaminationRecordDO> list = nutritionExaminationRecordService.getNutritionExaminationRecordList(ids);
        return success(NutritionExaminationRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得营养检查记录分页")
    @PreAuthorize("@ss.hasPermission('member:nutrition-examination-record:query')")
    public CommonResult<PageResult<NutritionExaminationRecordRespVO>> getNutritionExaminationRecordPage(@Valid NutritionExaminationRecordPageReqVO pageVO) {
        PageResult<NutritionExaminationRecordDO> pageResult = nutritionExaminationRecordService.getNutritionExaminationRecordPage(pageVO);
        return success(NutritionExaminationRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出营养检查记录 Excel")
    @PreAuthorize("@ss.hasPermission('member:nutrition-examination-record:export')")
    @OperateLog(type = EXPORT)
    public void exportNutritionExaminationRecordExcel(@Valid NutritionExaminationRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<NutritionExaminationRecordDO> list = nutritionExaminationRecordService.getNutritionExaminationRecordList(exportReqVO);
        // 导出 Excel
        List<NutritionExaminationRecordExcelVO> datas = NutritionExaminationRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "营养检查记录.xls", "数据", NutritionExaminationRecordExcelVO.class, datas);
    }

}
