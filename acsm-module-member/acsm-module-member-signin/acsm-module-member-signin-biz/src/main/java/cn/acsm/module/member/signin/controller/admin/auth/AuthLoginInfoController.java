package cn.acsm.module.member.signin.controller.admin.auth;

import cn.acsm.module.member.signin.controller.admin.auth.vo.*;
import cn.acsm.module.member.signin.dal.dataobject.auth.AuthLoginInfoDO;
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

import cn.acsm.module.member.signin.convert.auth.AuthLoginInfoConvert;
import cn.acsm.module.member.signin.service.auth.AuthLoginInfoService;

@Api(tags = "管理后台 - 会员授权登录信息记录")
@RestController
@RequestMapping("/member/auth-login-info")
@Validated
public class AuthLoginInfoController {

    @Resource
    private AuthLoginInfoService authLoginInfoService;

    @PostMapping("/create")
    @ApiOperation("创建会员授权登录信息记录")
    @PreAuthorize("@ss.hasPermission('member:auth-login-info:create')")
    public CommonResult<Long> createAuthLoginInfo(@Valid @RequestBody AuthLoginInfoCreateReqVO createReqVO) {
        return success(authLoginInfoService.createAuthLoginInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新会员授权登录信息记录")
    @PreAuthorize("@ss.hasPermission('member:auth-login-info:update')")
    public CommonResult<Boolean> updateAuthLoginInfo(@Valid @RequestBody AuthLoginInfoUpdateReqVO updateReqVO) {
        authLoginInfoService.updateAuthLoginInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除会员授权登录信息记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:auth-login-info:delete')")
    public CommonResult<Boolean> deleteAuthLoginInfo(@RequestParam("id") Long id) {
        authLoginInfoService.deleteAuthLoginInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得会员授权登录信息记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:auth-login-info:query')")
    public CommonResult<AuthLoginInfoRespVO> getAuthLoginInfo(@RequestParam("id") Long id) {
        AuthLoginInfoDO authLoginInfo = authLoginInfoService.getAuthLoginInfo(id);
        return success(AuthLoginInfoConvert.INSTANCE.convert(authLoginInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得会员授权登录信息记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:auth-login-info:query')")
    public CommonResult<List<AuthLoginInfoRespVO>> getAuthLoginInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<AuthLoginInfoDO> list = authLoginInfoService.getAuthLoginInfoList(ids);
        return success(AuthLoginInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得会员授权登录信息记录分页")
    @PreAuthorize("@ss.hasPermission('member:auth-login-info:query')")
    public CommonResult<PageResult<AuthLoginInfoRespVO>> getAuthLoginInfoPage(@Valid AuthLoginInfoPageReqVO pageVO) {
        PageResult<AuthLoginInfoDO> pageResult = authLoginInfoService.getAuthLoginInfoPage(pageVO);
        return success(AuthLoginInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出会员授权登录信息记录 Excel")
    @PreAuthorize("@ss.hasPermission('member:auth-login-info:export')")
    @OperateLog(type = EXPORT)
    public void exportAuthLoginInfoExcel(@Valid AuthLoginInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AuthLoginInfoDO> list = authLoginInfoService.getAuthLoginInfoList(exportReqVO);
        // 导出 Excel
        List<AuthLoginInfoExcelVO> datas = AuthLoginInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员授权登录信息记录.xls", "数据", AuthLoginInfoExcelVO.class, datas);
    }

}
