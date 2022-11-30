package cn.acsm.module.member.user.controller.admin.integral;

import cn.acsm.module.member.user.controller.admin.integral.vo.rules.*;
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

import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRulesDO;
import cn.acsm.module.member.user.convert.integral.IntegralRulesConvert;
import cn.acsm.module.member.user.service.integral.IntegralRulesService;

@Api(tags = "管理后台 - 会员积分规则")
@RestController
@RequestMapping("/member/integral-rules")
@Validated
public class IntegralRulesController {

    @Resource
    private IntegralRulesService integralRulesService;

    @PostMapping("/create")
    @ApiOperation("创建会员积分规则")
    @PreAuthorize("@ss.hasPermission('member:integral-rules:create')")
    public CommonResult<Long> createIntegralRules(@Valid @RequestBody IntegralRulesCreateReqVO createReqVO) {
        return success(integralRulesService.createIntegralRules(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新会员积分规则")
    @PreAuthorize("@ss.hasPermission('member:integral-rules:update')")
    public CommonResult<Boolean> updateIntegralRules(@Valid @RequestBody IntegralRulesUpdateReqVO updateReqVO) {
        integralRulesService.updateIntegralRules(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除会员积分规则")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:integral-rules:delete')")
    public CommonResult<Boolean> deleteIntegralRules(@RequestParam("id") Long id) {
        integralRulesService.deleteIntegralRules(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得会员积分规则")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:integral-rules:query')")
    public CommonResult<IntegralRulesRespVO> getIntegralRules(@RequestParam("id") Long id) {
        IntegralRulesDO integralRules = integralRulesService.getIntegralRules(id);
        return success(IntegralRulesConvert.INSTANCE.convert(integralRules));
    }

    @GetMapping("/list")
    @ApiOperation("获得会员积分规则列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:integral-rules:query')")
    public CommonResult<List<IntegralRulesRespVO>> getIntegralRulesList(@RequestParam("ids") Collection<Long> ids) {
        List<IntegralRulesDO> list = integralRulesService.getIntegralRulesList(ids);
        return success(IntegralRulesConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得会员积分规则分页")
    @PreAuthorize("@ss.hasPermission('member:integral-rules:query')")
    public CommonResult<PageResult<IntegralRulesRespVO>> getIntegralRulesPage(@Valid IntegralRulesPageReqVO pageVO) {
        PageResult<IntegralRulesDO> pageResult = integralRulesService.getIntegralRulesPage(pageVO);
        return success(IntegralRulesConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出会员积分规则 Excel")
    @PreAuthorize("@ss.hasPermission('member:integral-rules:export')")
    @OperateLog(type = EXPORT)
    public void exportIntegralRulesExcel(@Valid IntegralRulesExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<IntegralRulesDO> list = integralRulesService.getIntegralRulesList(exportReqVO);
        // 导出 Excel
        List<IntegralRulesExcelVO> datas = IntegralRulesConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员积分规则.xls", "数据", IntegralRulesExcelVO.class, datas);
    }

}
