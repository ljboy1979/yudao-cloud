package cn.acsm.module.wallet.controller.admin.wallet;

import cn.acsm.module.wallet.controller.admin.wallet.vo.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.annotation.security.PermitAll;
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

import cn.acsm.module.wallet.dal.dataobject.wallet.WalletInfoDO;
import cn.acsm.module.wallet.convert.wallet.WalletInfoConvert;
import cn.acsm.module.wallet.service.wallet.WalletInfoService;

@Api(tags = "管理后台 - 钱包信息")
@RestController
@RequestMapping("/wallet/info")
@Validated
public class WalletInfoController {

    @Resource
    private WalletInfoService infoService;

    @PostMapping("/create")
    @ApiOperation("创建钱包信息")
    @PreAuthorize("@ss.hasPermission('wallet:info:create')")
    public CommonResult<Long> createInfo(@Valid @RequestBody WalletInfoCreateReqVO createReqVO) {
        return success(infoService.createInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新钱包信息")
    @PreAuthorize("@ss.hasPermission('wallet:info:update')")
    public CommonResult<Boolean> updateInfo(@Valid @RequestBody WalletInfoUpdateReqVO updateReqVO) {
        infoService.updateInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除钱包信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:info:delete')")
    public CommonResult<Boolean> deleteInfo(@RequestParam("id") Long id) {
        infoService.deleteInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得钱包信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:info:query')")
    public CommonResult<WalletInfoRespVO> getInfo(@RequestParam("id") Long id) {
        WalletInfoDO info = infoService.getInfo(id);
        return success(WalletInfoConvert.INSTANCE.convert(info));
    }

    @GetMapping("/list")
    @ApiOperation("获得钱包信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('wallet:info:query')")
    public CommonResult<List<WalletInfoRespVO>> getInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<WalletInfoDO> list = infoService.getInfoList(ids);
        return success(WalletInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得钱包信息分页")
    @PreAuthorize("@ss.hasPermission('wallet:info:query')")
    public CommonResult<PageResult<WalletInfoRespVO>> getInfoPage(@Valid WalletInfoPageReqVO pageVO) {
        PageResult<WalletInfoDO> pageResult = infoService.getInfoPage(pageVO);
        return success(WalletInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出钱包信息 Excel")
    @PreAuthorize("@ss.hasPermission('wallet:info:export')")
    @OperateLog(type = EXPORT)
    public void exportInfoExcel(@Valid WalletInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<WalletInfoDO> list = infoService.getInfoList(exportReqVO);
        // 导出 Excel
        List<WalletInfoExcelVO> datas = WalletInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "钱包信息.xls", "数据", WalletInfoExcelVO.class, datas);
    }

}
