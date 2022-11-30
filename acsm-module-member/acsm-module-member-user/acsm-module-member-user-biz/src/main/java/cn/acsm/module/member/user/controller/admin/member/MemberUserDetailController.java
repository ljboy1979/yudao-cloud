package cn.acsm.module.member.user.controller.admin.member;

import cn.acsm.module.member.user.controller.admin.member.vo.*;
import cn.acsm.module.member.user.convert.member.MemberUserDetailConvert;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDetailDO;
import cn.acsm.module.member.user.service.member.MemberUserDetailService;
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


@Api(tags = "管理后台 - 会员信息")
@RestController
@RequestMapping("/member/user-detail")
@Validated
public class MemberUserDetailController {

    @Resource
    private MemberUserDetailService userDetailService;

    @PostMapping("/create")
    @ApiOperation("创建会员信息")
    @PreAuthorize("@ss.hasPermission('member:user-detail:create')")
    public CommonResult<Long> createUserDetail(@Valid @RequestBody MemberUserDetailCreateReqVO createReqVO) {
        return success(userDetailService.createUserDetail(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新会员信息")
    @PreAuthorize("@ss.hasPermission('member:user-detail:update')")
    public CommonResult<Boolean> updateUserDetail(@Valid @RequestBody MemberUserDetailUpdateReqVO updateReqVO) {
        userDetailService.updateUserDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除会员信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:user-detail:delete')")
    public CommonResult<Boolean> deleteUserDetail(@RequestParam("id") Long id) {
        userDetailService.deleteUserDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得会员信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('member:user-detail:query')")
    public CommonResult<MemberUserDetailRespVO> getUserDetail(@RequestParam("id") Long id) {
        MemberUserDetailDO userDetail = userDetailService.getUserDetail(id);
        return success(MemberUserDetailConvert.INSTANCE.convert(userDetail));
    }

    @GetMapping("/list")
    @ApiOperation("获得会员信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('member:user-detail:query')")
    public CommonResult<List<MemberUserDetailRespVO>> getUserDetailList(@RequestParam("ids") Collection<Long> ids) {
        List<MemberUserDetailDO> list = userDetailService.getUserDetailList(ids);
        return success(MemberUserDetailConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得会员信息分页")
    @PreAuthorize("@ss.hasPermission('member:user-detail:query')")
    public CommonResult<PageResult<MemberUserDetailRespVO>> getUserDetailPage(@Valid MemberUserDetailPageReqVO pageVO) {
        PageResult<MemberUserDetailDO> pageResult = userDetailService.getUserDetailPage(pageVO);
        return success(MemberUserDetailConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出会员信息 Excel")
    @PreAuthorize("@ss.hasPermission('member:user-detail:export')")
    @OperateLog(type = EXPORT)
    public void exportUserDetailExcel(@Valid MemberUserDetailExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MemberUserDetailDO> list = userDetailService.getUserDetailList(exportReqVO);
        // 导出 Excel
        List<MemberUserDetailExcelVO> datas = MemberUserDetailConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "会员信息.xls", "数据", MemberUserDetailExcelVO.class, datas);
    }

}
