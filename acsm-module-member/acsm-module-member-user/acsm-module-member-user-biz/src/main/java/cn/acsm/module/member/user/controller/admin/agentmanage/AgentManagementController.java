package cn.acsm.module.member.user.controller.admin.agentmanage;

import cn.acsm.module.member.user.controller.admin.agentmanage.vo.*;
import cn.acsm.module.member.user.convert.agentmanage.AgentManagementConvert;
import cn.acsm.module.member.user.dal.dataobject.agentmanage.AgentManagementDO;
import cn.acsm.module.member.user.service.agentmanage.AgentManagementService;
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


@Api(tags = "管理后台 - 代理商管理")
@RestController
@RequestMapping("/member/agent-management")
@Validated
public class AgentManagementController {

    @Resource
    private AgentManagementService agentManagementService;

    @PostMapping("/create")
    @ApiOperation("创建代理商管理")
    @PreAuthorize("@ss.hasPermission('member:agent-management:create')")
    public CommonResult<Long> createAgentManagement(@Valid @RequestBody AgentManagementCreateReqVO createReqVO) {
        return success(agentManagementService.createAgentManagement(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新代理商管理")
    @PreAuthorize("@ss.hasPermission('member:agent-management:update')")
    public CommonResult<Boolean> updateAgentManagement(@Valid @RequestBody AgentManagementUpdateReqVO updateReqVO) {
        agentManagementService.updateAgentManagement(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除代理商管理")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:agent-management:delete')")
    public CommonResult<Boolean> deleteAgentManagement(@RequestParam("id") Long id) {
        agentManagementService.deleteAgentManagement(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得代理商管理")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:agent-management:query')")
    public CommonResult<AgentManagementRespVO> getAgentManagement(@RequestParam("id") Long id) {
        AgentManagementDO agentManagement = agentManagementService.getAgentManagement(id);
        return success(AgentManagementConvert.INSTANCE.convert(agentManagement));
    }

    @GetMapping("/list")
    @ApiOperation("获得代理商管理列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:agent-management:query')")
    public CommonResult<List<AgentManagementRespVO>> getAgentManagementList(@RequestParam("ids") Collection<Long> ids) {
        List<AgentManagementDO> list = agentManagementService.getAgentManagementList(ids);
        return success(AgentManagementConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得代理商管理分页")
    @PreAuthorize("@ss.hasPermission('member:agent-management:query')")
    public CommonResult<PageResult<AgentManagementRespVO>> getAgentManagementPage(@Valid AgentManagementPageReqVO pageVO) {
        PageResult<AgentManagementDO> pageResult = agentManagementService.getAgentManagementPage(pageVO);
        return success(AgentManagementConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出代理商管理 Excel")
    @PreAuthorize("@ss.hasPermission('member:agent-management:export')")
    @OperateLog(type = EXPORT)
    public void exportAgentManagementExcel(@Valid AgentManagementExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AgentManagementDO> list = agentManagementService.getAgentManagementList(exportReqVO);
        // 导出 Excel
        List<AgentManagementExcelVO> datas = AgentManagementConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "代理商管理.xls", "数据", AgentManagementExcelVO.class, datas);
    }

}
