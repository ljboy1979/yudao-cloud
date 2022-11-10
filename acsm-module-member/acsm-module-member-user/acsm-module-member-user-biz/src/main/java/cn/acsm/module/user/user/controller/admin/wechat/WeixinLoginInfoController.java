package cn.acsm.module.user.user.controller.admin.wechat;

import cn.acsm.module.user.user.controller.admin.wechat.vo.*;
import cn.acsm.module.user.user.convert.wechat.WeixinLoginInfoConvert;
import cn.acsm.module.user.user.dal.dataobject.wechat.WeixinLoginInfoDO;
import cn.acsm.module.user.user.service.wechat.WeixinLoginInfoService;
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


@Api(tags = "管理后台 - 微信登录信息记录")
@RestController
@RequestMapping("/user/weixin-login-info")
@Validated
public class WeixinLoginInfoController {

    @Resource
    private WeixinLoginInfoService weixinLoginInfoService;

    @PostMapping("/create")
    @ApiOperation("创建微信登录信息记录")
    @PreAuthorize("@ss.hasPermission('user:weixin-login-info:create')")
    public CommonResult<Long> createWeixinLoginInfo(@Valid @RequestBody WeixinLoginInfoCreateReqVO createReqVO) {
        return success(weixinLoginInfoService.createWeixinLoginInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新微信登录信息记录")
    @PreAuthorize("@ss.hasPermission('user:weixin-login-info:update')")
    public CommonResult<Boolean> updateWeixinLoginInfo(@Valid @RequestBody WeixinLoginInfoUpdateReqVO updateReqVO) {
        weixinLoginInfoService.updateWeixinLoginInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除微信登录信息记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('user:weixin-login-info:delete')")
    public CommonResult<Boolean> deleteWeixinLoginInfo(@RequestParam("id") Long id) {
        weixinLoginInfoService.deleteWeixinLoginInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得微信登录信息记录")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('user:weixin-login-info:query')")
    public CommonResult<WeixinLoginInfoRespVO> getWeixinLoginInfo(@RequestParam("id") Long id) {
        WeixinLoginInfoDO weixinLoginInfo = weixinLoginInfoService.getWeixinLoginInfo(id);
        return success(WeixinLoginInfoConvert.INSTANCE.convert(weixinLoginInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得微信登录信息记录列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('user:weixin-login-info:query')")
    public CommonResult<List<WeixinLoginInfoRespVO>> getWeixinLoginInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<WeixinLoginInfoDO> list = weixinLoginInfoService.getWeixinLoginInfoList(ids);
        return success(WeixinLoginInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得微信登录信息记录分页")
    @PreAuthorize("@ss.hasPermission('user:weixin-login-info:query')")
    public CommonResult<PageResult<WeixinLoginInfoRespVO>> getWeixinLoginInfoPage(@Valid WeixinLoginInfoPageReqVO pageVO) {
        PageResult<WeixinLoginInfoDO> pageResult = weixinLoginInfoService.getWeixinLoginInfoPage(pageVO);
        return success(WeixinLoginInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出微信登录信息记录 Excel")
    @PreAuthorize("@ss.hasPermission('user:weixin-login-info:export')")
    @OperateLog(type = EXPORT)
    public void exportWeixinLoginInfoExcel(@Valid WeixinLoginInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<WeixinLoginInfoDO> list = weixinLoginInfoService.getWeixinLoginInfoList(exportReqVO);
        // 导出 Excel
        List<WeixinLoginInfoExcelVO> datas = WeixinLoginInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "微信登录信息记录.xls", "数据", WeixinLoginInfoExcelVO.class, datas);
    }

}
