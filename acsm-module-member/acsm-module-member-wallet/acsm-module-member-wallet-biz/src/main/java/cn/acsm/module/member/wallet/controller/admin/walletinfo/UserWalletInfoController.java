package cn.acsm.module.member.wallet.controller.admin.walletinfo;

import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.*;
import cn.acsm.module.member.wallet.dal.dataobject.walletinfo.UserWalletInfoDO;
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

import cn.acsm.module.member.wallet.convert.walletinfo.UserWalletInfoConvert;
import cn.acsm.module.member.wallet.service.walletinfo.UserWalletInfoService;

@Api(tags = "管理后台 - 用户钱包信息")
@RestController
@RequestMapping("/wallet/user-wallet-info")
@Validated
public class UserWalletInfoController {

    @Resource
    private UserWalletInfoService userWalletInfoService;

    @PostMapping("/create")
    @ApiOperation("创建用户钱包信息")
    @PreAuthorize("@ss.hasPermission('wallet:user-wallet-info:create')")
    public CommonResult<Long> createUserWalletInfo(@Valid @RequestBody UserWalletInfoCreateReqVO createReqVO) {
        return success(userWalletInfoService.createUserWalletInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新用户钱包信息")
    @PreAuthorize("@ss.hasPermission('wallet:user-wallet-info:update')")
    public CommonResult<Boolean> updateUserWalletInfo(@Valid @RequestBody UserWalletInfoUpdateReqVO updateReqVO) {
        userWalletInfoService.updateUserWalletInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除用户钱包信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:user-wallet-info:delete')")
    public CommonResult<Boolean> deleteUserWalletInfo(@RequestParam("id") Long id) {
        userWalletInfoService.deleteUserWalletInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得用户钱包信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:user-wallet-info:query')")
    public CommonResult<UserWalletInfoRespVO> getUserWalletInfo(@RequestParam("id") Long id) {
        UserWalletInfoDO userWalletInfo = userWalletInfoService.getUserWalletInfo(id);
        return success(UserWalletInfoConvert.INSTANCE.convert(userWalletInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得用户钱包信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('wallet:user-wallet-info:query')")
    public CommonResult<List<UserWalletInfoRespVO>> getUserWalletInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<UserWalletInfoDO> list = userWalletInfoService.getUserWalletInfoList(ids);
        return success(UserWalletInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得用户钱包信息分页")
    @PreAuthorize("@ss.hasPermission('wallet:user-wallet-info:query')")
    public CommonResult<PageResult<UserWalletInfoRespVO>> getUserWalletInfoPage(@Valid UserWalletInfoPageReqVO pageVO) {
        PageResult<UserWalletInfoDO> pageResult = userWalletInfoService.getUserWalletInfoPage(pageVO);
        return success(UserWalletInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出用户钱包信息 Excel")
    @PreAuthorize("@ss.hasPermission('wallet:user-wallet-info:export')")
    @OperateLog(type = EXPORT)
    public void exportUserWalletInfoExcel(@Valid UserWalletInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<UserWalletInfoDO> list = userWalletInfoService.getUserWalletInfoList(exportReqVO);
        // 导出 Excel
        List<UserWalletInfoExcelVO> datas = UserWalletInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "用户钱包信息.xls", "数据", UserWalletInfoExcelVO.class, datas);
    }

}
