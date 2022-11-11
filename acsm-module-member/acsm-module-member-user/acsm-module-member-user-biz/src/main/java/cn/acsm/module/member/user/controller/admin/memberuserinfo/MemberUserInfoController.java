package cn.acsm.module.member.user.controller.admin.memberuserinfo;

import cn.acsm.module.member.user.controller.admin.memberuserinfo.vo.*;
import cn.acsm.module.member.user.convert.memberuserinfo.MemberUserInfoConvert;
import cn.acsm.module.member.user.dal.dataobject.memberuserinfo.MemberUserInfoDO;
import cn.acsm.module.member.user.service.memberuserinfo.MemberUserInfoService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


@Api(tags = "管理后台 - 用户基本信息")
@RestController
@RequestMapping("/member/user-info")
@Validated
public class MemberUserInfoController {

    @Resource
    private MemberUserInfoService userInfoService;

    @PostMapping("/create")
    @ApiOperation("创建用户基本信息")
    @PreAuthorize("@ss.hasPermission('member:user-info:create')")
    public CommonResult<Long> createUserInfo(@Valid @RequestBody MemberUserInfoCreateReqVO createReqVO) {
        return success(userInfoService.createUserInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新用户基本信息")
    @PreAuthorize("@ss.hasPermission('member:user-info:update')")
    public CommonResult<Boolean> updateUserInfo(@Valid @RequestBody MemberUserInfoUpdateReqVO updateReqVO) {
        userInfoService.updateUserInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除用户基本信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:user-info:delete')")
    public CommonResult<Boolean> deleteUserInfo(@RequestParam("id") Long id) {
        userInfoService.deleteUserInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得用户基本信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:user-info:query')")
    public CommonResult<MemberUserInfoRespVO> getUserInfo(@RequestParam("id") Long id) {
        MemberUserInfoDO userInfo = userInfoService.getUserInfo(id);
        return success(MemberUserInfoConvert.INSTANCE.convert(userInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得用户基本信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:user-info:query')")
    public CommonResult<List<MemberUserInfoRespVO>> getUserInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<MemberUserInfoDO> list = userInfoService.getUserInfoList(ids);
        return success(MemberUserInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得用户基本信息分页")
    @PreAuthorize("@ss.hasPermission('member:user-info:query')")
    public CommonResult<PageResult<MemberUserInfoRespVO>> getUserInfoPage(@Valid MemberUserInfoPageReqVO pageVO) {
        PageResult<MemberUserInfoDO> pageResult = userInfoService.getUserInfoPage(pageVO);
        return success(MemberUserInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出用户基本信息 Excel")
    @PreAuthorize("@ss.hasPermission('member:user-info:export')")
    @OperateLog(type = EXPORT)
    public void exportUserInfoExcel(@Valid MemberUserInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MemberUserInfoDO> list = userInfoService.getUserInfoList(exportReqVO);
        // 导出 Excel
        List<MemberUserInfoExcelVO> datas = MemberUserInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "用户基本信息.xls", "数据", MemberUserInfoExcelVO.class, datas);
    }
}
