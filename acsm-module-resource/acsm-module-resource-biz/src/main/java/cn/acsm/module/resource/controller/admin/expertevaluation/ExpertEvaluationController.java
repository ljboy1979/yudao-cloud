package cn.acsm.module.resource.controller.admin.expertevaluation;

import cn.acsm.module.resource.controller.admin.expertevaluation.vo.*;
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

import cn.acsm.module.resource.dal.dataobject.expertevaluation.ExpertEvaluationDO;
import cn.acsm.module.resource.convert.expertevaluation.ExpertEvaluationConvert;
import cn.acsm.module.resource.service.expertevaluation.ExpertEvaluationService;

@Api(tags = "管理后台 - 健康状况")
@RestController
@RequestMapping("/resource/expert-evaluation")
@Validated
public class ExpertEvaluationController {

    @Resource
    private ExpertEvaluationService expertEvaluationService;

    @PostMapping("/create")
    @ApiOperation("创建健康状况")
    @PreAuthorize("@ss.hasPermission('service:expert-evaluation:create')")
    public CommonResult<Long> createExpertEvaluation(@Valid @RequestBody ExpertEvaluationCreateReqVO createReqVO) {
        return success(expertEvaluationService.createExpertEvaluation(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新健康状况")
    @PreAuthorize("@ss.hasPermission('service:expert-evaluation:update')")
    public CommonResult<Boolean> updateExpertEvaluation(@Valid @RequestBody ExpertEvaluationUpdateReqVO updateReqVO) {
        expertEvaluationService.updateExpertEvaluation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除健康状况")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:expert-evaluation:delete')")
    public CommonResult<Boolean> deleteExpertEvaluation(@RequestParam("id") Long id) {
        expertEvaluationService.deleteExpertEvaluation(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得健康状况")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('service:expert-evaluation:query')")
    public CommonResult<ExpertEvaluationRespVO> getExpertEvaluation(@RequestParam("id") Long id) {
        ExpertEvaluationDO expertEvaluation = expertEvaluationService.getExpertEvaluation(id);
        return success(ExpertEvaluationConvert.INSTANCE.convert(expertEvaluation));
    }

    @GetMapping("/list")
    @ApiOperation("获得健康状况列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('service:expert-evaluation:query')")
    public CommonResult<List<ExpertEvaluationRespVO>> getExpertEvaluationList(@RequestParam("ids") Collection<Long> ids) {
        List<ExpertEvaluationDO> list = expertEvaluationService.getExpertEvaluationList(ids);
        return success(ExpertEvaluationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得健康状况分页")
    @PreAuthorize("@ss.hasPermission('service:expert-evaluation:query')")
    public CommonResult<PageResult<ExpertEvaluationRespVO>> getExpertEvaluationPage(@Valid ExpertEvaluationPageReqVO pageVO) {
        PageResult<ExpertEvaluationDO> pageResult = expertEvaluationService.getExpertEvaluationPage(pageVO);
        return success(ExpertEvaluationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出健康状况 Excel")
    @PreAuthorize("@ss.hasPermission('service:expert-evaluation:export')")
    @OperateLog(type = EXPORT)
    public void exportExpertEvaluationExcel(@Valid ExpertEvaluationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ExpertEvaluationDO> list = expertEvaluationService.getExpertEvaluationList(exportReqVO);
        // 导出 Excel
        List<ExpertEvaluationExcelVO> datas = ExpertEvaluationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "健康状况.xls", "数据", ExpertEvaluationExcelVO.class, datas);
    }

}
