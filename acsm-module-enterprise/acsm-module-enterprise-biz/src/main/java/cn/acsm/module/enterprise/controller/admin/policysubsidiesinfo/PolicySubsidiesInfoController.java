package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo;

import cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo.*;
import cn.acsm.module.enterprise.convert.policysubsidiesinfo.PolicySubsidiesInfoConvert;
import cn.acsm.module.enterprise.dal.dataobject.policysubsidiesinfo.PolicySubsidiesInfoDO;
import cn.acsm.module.enterprise.service.policysubsidiesinfo.PolicySubsidiesInfoService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
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


@Api(tags = "管理后台 - 企业政策补贴信息")
@RestController
@RequestMapping("/enterprise/policy-subsidies-info")
@Validated
public class PolicySubsidiesInfoController {

    @Resource
    private PolicySubsidiesInfoService policySubsidiesInfoService;

    @PostMapping("/create")
    @ApiOperation("创建企业政策补贴信息")
    @PreAuthorize("@ss.hasPermission('enterprise:policy-subsidies-info:create')")
    public CommonResult<Long> createPolicySubsidiesInfo(@Valid @RequestBody PolicySubsidiesInfoCreateReqVO createReqVO) {
        return success(policySubsidiesInfoService.createPolicySubsidiesInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新企业政策补贴信息")
    @PreAuthorize("@ss.hasPermission('enterprise:policy-subsidies-info:update')")
    public CommonResult<Boolean> updatePolicySubsidiesInfo(@Valid @RequestBody PolicySubsidiesInfoUpdateReqVO updateReqVO) {
        policySubsidiesInfoService.updatePolicySubsidiesInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除企业政策补贴信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('enterprise:policy-subsidies-info:delete')")
    public CommonResult<Boolean> deletePolicySubsidiesInfo(@RequestParam("id") Long id) {
        policySubsidiesInfoService.deletePolicySubsidiesInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得企业政策补贴信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('enterprise:policy-subsidies-info:query')")
    public CommonResult< PolicySubsidiesInfoRespVO > getPolicySubsidiesInfo(@RequestParam("id") Long id) {
        PolicySubsidiesInfoDO policySubsidiesInfo = policySubsidiesInfoService.getPolicySubsidiesInfo(id);
        return success(PolicySubsidiesInfoConvert.INSTANCE.convert(policySubsidiesInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得企业政策补贴信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('enterprise:policy-subsidies-info:query')")
    public CommonResult<List< PolicySubsidiesInfoRespVO >> getPolicySubsidiesInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<PolicySubsidiesInfoDO> list = policySubsidiesInfoService.getPolicySubsidiesInfoList(ids);
        return success(PolicySubsidiesInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得企业政策补贴信息分页")
    @PreAuthorize("@ss.hasPermission('enterprise:policy-subsidies-info:query')")
    public CommonResult<PageResult< PolicySubsidiesInfoRespVO >> getPolicySubsidiesInfoPage(@Valid PolicySubsidiesInfoPageReqVO pageVO) {
        PageResult<PolicySubsidiesInfoDO> pageResult = policySubsidiesInfoService.getPolicySubsidiesInfoPage(pageVO);
        return success(PolicySubsidiesInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出企业政策补贴信息 Excel")
    @PreAuthorize("@ss.hasPermission('enterprise:policy-subsidies-info:export')")
    @OperateLog(type = EXPORT)
    public void exportPolicySubsidiesInfoExcel(@Valid PolicySubsidiesInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PolicySubsidiesInfoDO> list = policySubsidiesInfoService.getPolicySubsidiesInfoList(exportReqVO);
        // 导出 Excel
        List< PolicySubsidiesInfoExcelVO > datas = PolicySubsidiesInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "企业政策补贴信息.xls", "数据", PolicySubsidiesInfoExcelVO.class, datas);
    }

}
