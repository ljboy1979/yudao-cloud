package cn.acsm.module.member.user.controller.admin.patient;

import cn.acsm.module.member.user.controller.admin.patient.vo.specialmedicalfood.*;
import cn.acsm.module.member.user.convert.patienthealth.SpecialMedicalFoodRecordsConvert;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.SpecialMedicalFoodRecordsDO;
import cn.acsm.module.member.user.service.patienthealth.SpecialMedicalFoodRecordsService;
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


@Api(tags = "管理后台 - 特医食品使用记录表")
@RestController
@RequestMapping("/member/special-medical-food-records")
@Validated
public class SpecialMedicalFoodRecordsController {

    @Resource
    private SpecialMedicalFoodRecordsService specialMedicalFoodRecordsService;

    @PostMapping("/create")
    @ApiOperation("创建特医食品使用记录表")
    @PreAuthorize("@ss.hasPermission('member:special-medical-food-records:create')")
    public CommonResult<Long> createSpecialMedicalFoodRecords(@Valid @RequestBody SpecialMedicalFoodRecordsCreateReqVO createReqVO) {
        return success(specialMedicalFoodRecordsService.createSpecialMedicalFoodRecords(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新特医食品使用记录表")
    @PreAuthorize("@ss.hasPermission('member:special-medical-food-records:update')")
    public CommonResult<Boolean> updateSpecialMedicalFoodRecords(@Valid @RequestBody SpecialMedicalFoodRecordsUpdateReqVO updateReqVO) {
        specialMedicalFoodRecordsService.updateSpecialMedicalFoodRecords(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除特医食品使用记录表")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:special-medical-food-records:delete')")
    public CommonResult<Boolean> deleteSpecialMedicalFoodRecords(@RequestParam("id") Long id) {
        specialMedicalFoodRecordsService.deleteSpecialMedicalFoodRecords(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得特医食品使用记录表")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:special-medical-food-records:query')")
    public CommonResult<SpecialMedicalFoodRecordsRespVO> getSpecialMedicalFoodRecords(@RequestParam("id") Long id) {
        SpecialMedicalFoodRecordsDO specialMedicalFoodRecords = specialMedicalFoodRecordsService.getSpecialMedicalFoodRecords(id);
        return success(SpecialMedicalFoodRecordsConvert.INSTANCE.convert(specialMedicalFoodRecords));
    }

    @GetMapping("/list")
    @ApiOperation("获得特医食品使用记录表列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:special-medical-food-records:query')")
    public CommonResult<List<SpecialMedicalFoodRecordsRespVO>> getSpecialMedicalFoodRecordsList(@RequestParam("ids") Collection<Long> ids) {
        List<SpecialMedicalFoodRecordsDO> list = specialMedicalFoodRecordsService.getSpecialMedicalFoodRecordsList(ids);
        return success(SpecialMedicalFoodRecordsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得特医食品使用记录表分页")
    @PreAuthorize("@ss.hasPermission('member:special-medical-food-records:query')")
    public CommonResult<PageResult<SpecialMedicalFoodRecordsRespVO>> getSpecialMedicalFoodRecordsPage(@Valid SpecialMedicalFoodRecordsPageReqVO pageVO) {
        PageResult<SpecialMedicalFoodRecordsDO> pageResult = specialMedicalFoodRecordsService.getSpecialMedicalFoodRecordsPage(pageVO);
        return success(SpecialMedicalFoodRecordsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出特医食品使用记录表 Excel")
    @PreAuthorize("@ss.hasPermission('member:special-medical-food-records:export')")
    @OperateLog(type = EXPORT)
    public void exportSpecialMedicalFoodRecordsExcel(@Valid SpecialMedicalFoodRecordsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SpecialMedicalFoodRecordsDO> list = specialMedicalFoodRecordsService.getSpecialMedicalFoodRecordsList(exportReqVO);
        // 导出 Excel
        List<SpecialMedicalFoodRecordsExcelVO> datas = SpecialMedicalFoodRecordsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "特医食品使用记录表.xls", "数据", SpecialMedicalFoodRecordsExcelVO.class, datas);
    }

}
