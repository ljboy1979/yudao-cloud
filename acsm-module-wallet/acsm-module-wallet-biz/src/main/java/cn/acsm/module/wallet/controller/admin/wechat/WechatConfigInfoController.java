package cn.acsm.module.wallet.controller.admin.wechat;

import cn.acsm.module.wallet.controller.admin.wechat.vo.*;
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

import cn.acsm.module.wallet.dal.dataobject.wechat.WechatConfigInfoDO;
import cn.acsm.module.wallet.convert.wechat.WechatConfigInfoConvert;
import cn.acsm.module.wallet.service.wechat.WechatConfigInfoService;

@Api(tags = "管理后台 - 微信支付配置信息")
@RestController
@RequestMapping("/wallet/wechat-config-info")
@Validated
public class WechatConfigInfoController {

    @Resource
    private WechatConfigInfoService wechatConfigInfoService;

    @PostMapping("/create")
    @ApiOperation("创建微信支付配置信息")
    @PreAuthorize("@ss.hasPermission('wallet:wechat-config-info:create')")
    public CommonResult<Long> createWechatConfigInfo(@Valid @RequestBody WechatConfigInfoCreateReqVO createReqVO) {
        return success(wechatConfigInfoService.createWechatConfigInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新微信支付配置信息")
    @PreAuthorize("@ss.hasPermission('wallet:wechat-config-info:update')")
    public CommonResult<Boolean> updateWechatConfigInfo(@Valid @RequestBody WechatConfigInfoUpdateReqVO updateReqVO) {
        wechatConfigInfoService.updateWechatConfigInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除微信支付配置信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:wechat-config-info:delete')")
    public CommonResult<Boolean> deleteWechatConfigInfo(@RequestParam("id") Long id) {
        wechatConfigInfoService.deleteWechatConfigInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得微信支付配置信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('wallet:wechat-config-info:query')")
    public CommonResult<WechatConfigInfoRespVO> getWechatConfigInfo(@RequestParam("id") Long id) {
        WechatConfigInfoDO wechatConfigInfo = wechatConfigInfoService.getWechatConfigInfo(id);
        return success(WechatConfigInfoConvert.INSTANCE.convert(wechatConfigInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得微信支付配置信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('wallet:wechat-config-info:query')")
    public CommonResult<List<WechatConfigInfoRespVO>> getWechatConfigInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<WechatConfigInfoDO> list = wechatConfigInfoService.getWechatConfigInfoList(ids);
        return success(WechatConfigInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得微信支付配置信息分页")
    @PreAuthorize("@ss.hasPermission('wallet:wechat-config-info:query')")
    public CommonResult<PageResult<WechatConfigInfoRespVO>> getWechatConfigInfoPage(@Valid WechatConfigInfoPageReqVO pageVO) {
        PageResult<WechatConfigInfoDO> pageResult = wechatConfigInfoService.getWechatConfigInfoPage(pageVO);
        return success(WechatConfigInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出微信支付配置信息 Excel")
    @PreAuthorize("@ss.hasPermission('wallet:wechat-config-info:export')")
    @OperateLog(type = EXPORT)
    public void exportWechatConfigInfoExcel(@Valid WechatConfigInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<WechatConfigInfoDO> list = wechatConfigInfoService.getWechatConfigInfoList(exportReqVO);
        // 导出 Excel
        List<WechatConfigInfoExcelVO> datas = WechatConfigInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "微信支付配置信息.xls", "数据", WechatConfigInfoExcelVO.class, datas);
    }

}
