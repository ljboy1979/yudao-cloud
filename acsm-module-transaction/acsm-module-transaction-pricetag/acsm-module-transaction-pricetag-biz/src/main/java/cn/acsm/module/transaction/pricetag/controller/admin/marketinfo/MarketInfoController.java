package cn.acsm.module.transaction.pricetag.controller.admin.marketinfo;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
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

import cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketinfo.MarketInfoDO;
import cn.acsm.module.transaction.pricetag.convert.marketinfo.MarketInfoConvert;
import cn.acsm.module.transaction.pricetag.service.marketinfo.MarketInfoService;

@Api(tags = "管理后台 - 市场信息")
@RestController
@RequestMapping("/pricetag/market-info")
@Validated
public class MarketInfoController {

    @Resource
    private MarketInfoService marketInfoService;

    @PostMapping("/create")
    @ApiOperation("创建市场信息")
    @PreAuthorize("@ss.hasPermission('pricetag:market-info:create')")
    public CommonResult<String> createMarketInfo(@Valid @RequestBody MarketInfoCreateReqVO createReqVO) {
        return success(marketInfoService.createMarketInfo(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新市场信息")
    @PreAuthorize("@ss.hasPermission('pricetag:market-info:update')")
    public CommonResult<Boolean> updateMarketInfo(@Valid @RequestBody MarketInfoUpdateReqVO updateReqVO) {
        marketInfoService.updateMarketInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除市场信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-info:delete')")
    public CommonResult<Boolean> deleteMarketInfo(@RequestParam("id") String id) {
        marketInfoService.deleteMarketInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得市场信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-info:query')")
    public CommonResult<MarketInfoRespVO> getMarketInfo(@RequestParam("id") String id) {
        MarketInfoDO marketInfo = marketInfoService.getMarketInfo(id);
        return success(MarketInfoConvert.INSTANCE.convert(marketInfo));
    }

    @GetMapping("/list")
    @ApiOperation("获得市场信息列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-info:query')")
    public CommonResult<List<MarketInfoRespVO>> getMarketInfoList(@RequestParam("ids") Collection<String> ids) {
        List<MarketInfoDO> list = marketInfoService.getMarketInfoList(ids);
        return success(MarketInfoConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得市场信息分页")
    @PreAuthorize("@ss.hasPermission('pricetag:market-info:query')")
    public CommonResult<PageResult<MarketInfoRespVO>> getMarketInfoPage(@Valid MarketInfoPageReqVO pageVO) {
        PageResult<MarketInfoDO> pageResult = marketInfoService.getMarketInfoPage(pageVO);
        return success(MarketInfoConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出市场信息 Excel")
    @PreAuthorize("@ss.hasPermission('pricetag:market-info:export')")
    @OperateLog(type = EXPORT)
    public void exportMarketInfoExcel(@Valid MarketInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MarketInfoDO> list = marketInfoService.getMarketInfoList(exportReqVO);
        // 导出 Excel
        List<MarketInfoExcelVO> datas = MarketInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "市场信息.xls", "数据", MarketInfoExcelVO.class, datas);
    }

    @GetMapping("/getList")
    @ApiOperation("获得市场信息列表")
    @PreAuthorize("@ss.hasPermission('pricetag:market-info:query')")
    public CommonResult<List<MarketInfoRespVO>> getList() {
        List<MarketInfoDO> list = marketInfoService.getList();
        return success(MarketInfoConvert.INSTANCE.convertList(list));
    }

}
