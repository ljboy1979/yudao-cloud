package cn.acsm.module.member.signin.controller.admin.auth;

import cn.acsm.module.member.signin.controller.admin.auth.vo.*;
import cn.acsm.module.member.signin.convert.auth.AuthConfigInfoConvert;
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

import cn.acsm.module.member.signin.dal.dataobject.auth.AuthConfigInfoDO;
import cn.acsm.module.member.signin.service.auth.AuthConfigInfoService;

@Api(tags = "管理后台 - 会员登录授权配置信息")
@RestController
@RequestMapping("/member/auth-config-info")
@Validated
public class AuthConfigInfoController {

    @Resource
    private AuthConfigInfoService authConfigInfoService;

    @PostMapping("/create")
    @ApiOperation("创建会员登录授权配置信息")
    @PreAuthorize("@ss.hasPermission('member:auth-config-info:create')")
    public CommonResult<Long> createAuthConfigInfo(@Valid @RequestBody AuthConfigInfoCreateReqVO createReqVO) {
        return success(authConfigInfoService.createAuthConfigInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新会员登录授权配置信息")
    @PreAuthorize("@ss.hasPermission('member:auth-config-info:update')")
    public CommonResult<Boolean> updateAuthConfigInfo(@Valid @RequestBody AuthConfigInfoUpdateReqVO updateReqVO) {
        authConfigInfoService.updateAuthConfigInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除会员登录授权配置信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:auth-config-info:delete')")
    public CommonResult<Boolean> deleteAuthConfigInfo(@RequestParam("id") Long id) {
        authConfigInfoService.deleteAuthConfigInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得会员登录授权配置信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:auth-config-info:query')")
    public CommonResult<AuthConfigInfoRespVO> getAuthConfigInfo(@RequestParam("id") Long id) {
        AuthConfigInfoDO authConfigInfo = authConfigInfoService.getAuthConfigInfo(id);
        return success(AuthConfigInfoConvert.INSTANCE.convert(authConfigInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得会员登录授权配置信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:auth-config-info:query')")
    public CommonResult<List<AuthConfigInfoRespVO>> getAuthConfigInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<AuthConfigInfoDO> list = authConfigInfoService.getAuthConfigInfoList(ids);
        return success(AuthConfigInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得会员登录授权配置信息分页")
    @PreAuthorize("@ss.hasPermission('member:auth-config-info:query')")
    public CommonResult<PageResult<AuthConfigInfoRespVO>> getAuthConfigInfoPage(@Valid AuthConfigInfoPageReqVO pageVO) {
        PageResult<AuthConfigInfoDO> pageResult = authConfigInfoService.getAuthConfigInfoPage(pageVO);
        return success(AuthConfigInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出会员登录授权配置信息 Excel")
    @PreAuthorize("@ss.hasPermission('member:auth-config-info:export')")
    @OperateLog(type = EXPORT)
    public void exportAuthConfigInfoExcel(@Valid AuthConfigInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AuthConfigInfoDO> list = authConfigInfoService.getAuthConfigInfoList(exportReqVO);
        // 导出 Excel
        List<AuthConfigInfoExcelVO> datas = AuthConfigInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员登录授权配置信息.xls", "数据", AuthConfigInfoExcelVO.class, datas);
    }

}
