package cn.acsm.module.user.user.controller.admin.user;

import cn.acsm.module.user.user.controller.admin.user.vo.*;
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

import cn.acsm.module.user.user.dal.dataobject.user.MemberUserDO;
import cn.acsm.module.user.user.convert.user.MemberUserConvert;
import cn.acsm.module.user.user.service.user.MemberUserService;

@Api(tags = "管理后台 - 用户")
@RestController
@RequestMapping("/user/member-user")
@Validated
public class MemberUserController {

    @Resource
    private MemberUserService memberUserService;

    @PostMapping("/create")
    @ApiOperation("创建用户")
    @PreAuthorize("@ss.hasPermission('user:member-user:create')")
    public CommonResult<Long> createMemberUser(@Valid @RequestBody MemberUserCreateReqVO createReqVO) {
        return success(memberUserService.createMemberUser(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新用户")
    @PreAuthorize("@ss.hasPermission('user:member-user:update')")
    public CommonResult<Boolean> updateMemberUser(@Valid @RequestBody MemberUserUpdateReqVO updateReqVO) {
        memberUserService.updateMemberUser(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('user:member-user:delete')")
    public CommonResult<Boolean> deleteMemberUser(@RequestParam("id") Long id) {
        memberUserService.deleteMemberUser(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得用户")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('user:member-user:query')")
    public CommonResult<MemberUserRespVO> getMemberUser(@RequestParam("id") Long id) {
        MemberUserDO memberUser = memberUserService.getMemberUser(id);
        return success(MemberUserConvert.INSTANCE.convert(memberUser));
    }

    @GetMapping("/list")
    @ApiOperation("获得用户列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('user:member-user:query')")
    public CommonResult<List<MemberUserRespVO>> getMemberUserList(@RequestParam("ids") Collection<Long> ids) {
        List<MemberUserDO> list = memberUserService.getMemberUserList(ids);
        return success(MemberUserConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得用户分页")
    @PreAuthorize("@ss.hasPermission('user:member-user:query')")
    public CommonResult<PageResult<MemberUserRespVO>> getMemberUserPage(@Valid MemberUserPageReqVO pageVO) {
        PageResult<MemberUserDO> pageResult = memberUserService.getMemberUserPage(pageVO);
        return success(MemberUserConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出用户 Excel")
    @PreAuthorize("@ss.hasPermission('user:member-user:export')")
    @OperateLog(type = EXPORT)
    public void exportMemberUserExcel(@Valid MemberUserExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MemberUserDO> list = memberUserService.getMemberUserList(exportReqVO);
        // 导出 Excel
        List<MemberUserExcelVO> datas = MemberUserConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "用户.xls", "数据", MemberUserExcelVO.class, datas);
    }

}
