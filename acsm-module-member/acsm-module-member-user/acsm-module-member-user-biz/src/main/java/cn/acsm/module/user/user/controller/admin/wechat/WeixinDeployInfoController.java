package cn.acsm.module.user.user.controller.admin.wechat;

import cn.acsm.module.user.user.controller.admin.wechat.vo.*;
import cn.acsm.module.user.user.convert.wechat.WeixinDeployInfoConvert;
import cn.acsm.module.user.user.dal.dataobject.wechat.WeixinDeployInfoDO;
import cn.acsm.module.user.user.service.wechat.WeixinDeployInfoService;
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

@Api(tags = "管理后台 - 微信公众号配置信息")
@RestController
@RequestMapping("/user/weixin-deploy-info")
@Validated
public class WeixinDeployInfoController {

    @Resource
    private WeixinDeployInfoService weixinDeployInfoService;

    @PostMapping("/create")
    @ApiOperation("创建微信公众号配置信息")
    @PreAuthorize("@ss.hasPermission('user:weixin-deploy-info:create')")
    public CommonResult<Long> createWeixinDeployInfo(@Valid @RequestBody WeixinDeployInfoCreateReqVO createReqVO) {
        return success(weixinDeployInfoService.createWeixinDeployInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新微信公众号配置信息")
    @PreAuthorize("@ss.hasPermission('user:weixin-deploy-info:update')")
    public CommonResult<Boolean> updateWeixinDeployInfo(@Valid @RequestBody WeixinDeployInfoUpdateReqVO updateReqVO) {
        weixinDeployInfoService.updateWeixinDeployInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除微信公众号配置信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('user:weixin-deploy-info:delete')")
    public CommonResult<Boolean> deleteWeixinDeployInfo(@RequestParam("id") Long id) {
        weixinDeployInfoService.deleteWeixinDeployInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得微信公众号配置信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('user:weixin-deploy-info:query')")
    public CommonResult<WeixinDeployInfoRespVO> getWeixinDeployInfo(@RequestParam("id") Long id) {
        WeixinDeployInfoDO weixinDeployInfo = weixinDeployInfoService.getWeixinDeployInfo(id);
        return success(WeixinDeployInfoConvert.INSTANCE.convert(weixinDeployInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得微信公众号配置信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('user:weixin-deploy-info:query')")
    public CommonResult<List<WeixinDeployInfoRespVO>> getWeixinDeployInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<WeixinDeployInfoDO> list = weixinDeployInfoService.getWeixinDeployInfoList(ids);
        return success(WeixinDeployInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得微信公众号配置信息分页")
    @PreAuthorize("@ss.hasPermission('user:weixin-deploy-info:query')")
    public CommonResult<PageResult<WeixinDeployInfoRespVO>> getWeixinDeployInfoPage(@Valid WeixinDeployInfoPageReqVO pageVO) {
        PageResult<WeixinDeployInfoDO> pageResult = weixinDeployInfoService.getWeixinDeployInfoPage(pageVO);
        return success(WeixinDeployInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出微信公众号配置信息 Excel")
    @PreAuthorize("@ss.hasPermission('user:weixin-deploy-info:export')")
    @OperateLog(type = EXPORT)
    public void exportWeixinDeployInfoExcel(@Valid WeixinDeployInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<WeixinDeployInfoDO> list = weixinDeployInfoService.getWeixinDeployInfoList(exportReqVO);
        // 导出 Excel
        List<WeixinDeployInfoExcelVO> datas = WeixinDeployInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "微信公众号配置信息.xls", "数据", WeixinDeployInfoExcelVO.class, datas);
    }

}
