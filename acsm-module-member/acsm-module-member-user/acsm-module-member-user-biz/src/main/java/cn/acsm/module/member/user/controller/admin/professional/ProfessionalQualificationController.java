package cn.acsm.module.member.user.controller.admin.professional;

import cn.acsm.module.member.user.controller.admin.professional.vo.*;
import cn.acsm.module.member.user.convert.professional.ProfessionalQualificationConvert;
import cn.acsm.module.member.user.dal.dataobject.professional.ProfessionalQualificationDO;
import cn.acsm.module.member.user.service.professional.ProfessionalQualificationService;
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


@Api(tags = "管理后台 - 专业资质")
@RestController
@RequestMapping("/member/professional-qualification")
@Validated
public class ProfessionalQualificationController {

    @Resource
    private ProfessionalQualificationService professionalQualificationService;

    @PostMapping("/create")
    @ApiOperation("创建专业资质")
    @PreAuthorize("@ss.hasPermission('member:professional-qualification:create')")
    public CommonResult<Long> createProfessionalQualification(@Valid @RequestBody ProfessionalQualificationCreateReqVO createReqVO) {
        return success(professionalQualificationService.createProfessionalQualification(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新专业资质")
    @PreAuthorize("@ss.hasPermission('member:professional-qualification:update')")
    public CommonResult<Boolean> updateProfessionalQualification(@Valid @RequestBody ProfessionalQualificationUpdateReqVO updateReqVO) {
        professionalQualificationService.updateProfessionalQualification(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除专业资质")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:professional-qualification:delete')")
    public CommonResult<Boolean> deleteProfessionalQualification(@RequestParam("id") Long id) {
        professionalQualificationService.deleteProfessionalQualification(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得专业资质")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:professional-qualification:query')")
    public CommonResult<ProfessionalQualificationRespVO> getProfessionalQualification(@RequestParam("id") Long id) {
        ProfessionalQualificationDO professionalQualification = professionalQualificationService.getProfessionalQualification(id);
        return success(ProfessionalQualificationConvert.INSTANCE.convert(professionalQualification));
    }

    @GetMapping("/list")
    @ApiOperation("获得专业资质列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:professional-qualification:query')")
    public CommonResult<List<ProfessionalQualificationRespVO>> getProfessionalQualificationList(@RequestParam("ids") Collection<Long> ids) {
        List<ProfessionalQualificationDO> list = professionalQualificationService.getProfessionalQualificationList(ids);
        return success(ProfessionalQualificationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得专业资质分页")
    @PreAuthorize("@ss.hasPermission('member:professional-qualification:query')")
    public CommonResult<PageResult<ProfessionalQualificationRespVO>> getProfessionalQualificationPage(@Valid ProfessionalQualificationPageReqVO pageVO) {
        PageResult<ProfessionalQualificationDO> pageResult = professionalQualificationService.getProfessionalQualificationPage(pageVO);
        return success(ProfessionalQualificationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出专业资质 Excel")
    @PreAuthorize("@ss.hasPermission('member:professional-qualification:export')")
    @OperateLog(type = EXPORT)
    public void exportProfessionalQualificationExcel(@Valid ProfessionalQualificationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProfessionalQualificationDO> list = professionalQualificationService.getProfessionalQualificationList(exportReqVO);
        // 导出 Excel
        List<ProfessionalQualificationExcelVO> datas = ProfessionalQualificationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "专业资质.xls", "数据", ProfessionalQualificationExcelVO.class, datas);
    }

}
