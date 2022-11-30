package cn.acsm.module.member.user.controller.admin.member;

import cn.acsm.module.member.user.controller.admin.member.vo.*;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDO;
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

import cn.acsm.module.member.user.convert.member.MemberUserConvert;
import cn.acsm.module.member.user.service.member.MemberUserService;

@Api(tags = "管理后台 - 会员")
@RestController
@RequestMapping("/member/user")
@Validated
public class MemberUserController {

    @Resource
    private MemberUserService userService;

    @PostMapping("/create")
    @ApiOperation("创建会员")
    @PreAuthorize("@ss.hasPermission('member:user:create')")
    public CommonResult<Long> createUser(@Valid @RequestBody MemberUserCreateReqVO createReqVO) {
        return success(userService.createUser(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新会员")
    @PreAuthorize("@ss.hasPermission('member:user:update')")
    public CommonResult<Boolean> updateUser(@Valid @RequestBody MemberUserUpdateReqVO updateReqVO) {
        userService.updateUser(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除会员")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:user:delete')")
    public CommonResult<Boolean> deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得会员")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:user:query')")
    public CommonResult<MemberUserRespVO> getUser(@RequestParam("id") Long id) {
        MemberUserDO user = userService.getUser(id);
        return success(MemberUserConvert.INSTANCE.convert(user));
    }

    @GetMapping("/list")
    @ApiOperation("获得会员列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:user:query')")
    public CommonResult<List<MemberUserRespVO>> getUserList(@RequestParam("ids") Collection<Long> ids) {
        List<MemberUserDO> list = userService.getUserList(ids);
        return success(MemberUserConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得会员分页")
    @PreAuthorize("@ss.hasPermission('member:user:query')")
    public CommonResult<PageResult<MemberUserRespVO>> getUserPage(@Valid MemberUserPageReqVO pageVO) {
        PageResult<MemberUserDO> pageResult = userService.getUserPage(pageVO);
        return success(MemberUserConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出会员 Excel")
    @PreAuthorize("@ss.hasPermission('member:user:export')")
    @OperateLog(type = EXPORT)
    public void exportUserExcel(@Valid MemberUserExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MemberUserDO> list = userService.getUserList(exportReqVO);
        // 导出 Excel
        List<MemberUserExcelVO> datas = MemberUserConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员.xls", "数据", MemberUserExcelVO.class, datas);
    }

    @GetMapping("/selectList4Query")
    @ApiOperation("获得会员分页（关联其他业务表数据）")
    @PreAuthorize("@ss.hasPermission('member:user:query')")
    public CommonResult<PageResult<MemberUserRespVO>> selectList4Query(@Valid MemberUserPageReqVO pageVO) {
        return success(userService.getUserPage4Query(pageVO));
    }

    @RequestMapping("/updateAuditStatus")
    @ApiOperation("审核")
    @PreAuthorize("@ss.hasPermission('member:user:update')")
    public CommonResult updateAuditStatus(@RequestBody MemberUserUpdateAuditReqVO updateReqVO) {
        return success(userService.updateAuditStatus(updateReqVO));
    }

    @RequestMapping("/unbundling")
    @ApiOperation("解绑")
    @PreAuthorize("@ss.hasPermission('member:user:update')")
    public CommonResult unbundling(@RequestBody MemberUserUpdateAuditReqVO updateReqVO) {
        return success(userService.unbundling(updateReqVO));
    }

    @RequestMapping("/updateMemberType")
    @ApiOperation("修改会员类型")
    @PreAuthorize("@ss.hasPermission('member:user:update')")
    public CommonResult updateMemberType(@RequestBody MemberUserUpdateAuditReqVO updateReqVO) {
        return success(userService.unbundling(updateReqVO));
    }
}
