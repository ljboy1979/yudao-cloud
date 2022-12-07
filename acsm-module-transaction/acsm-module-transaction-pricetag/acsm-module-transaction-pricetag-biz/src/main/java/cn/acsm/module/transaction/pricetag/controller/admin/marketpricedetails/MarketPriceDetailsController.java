package cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails;

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

import cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketpricedetails.MarketPriceDetailsDO;
import cn.acsm.module.transaction.pricetag.convert.marketpricedetails.MarketPriceDetailsConvert;
import cn.acsm.module.transaction.pricetag.service.marketpricedetails.MarketPriceDetailsService;

@Api(tags = "管理后台 - 市场价格明细")
@RestController
@RequestMapping("/pricetag/market-price-details")
@Validated
public class MarketPriceDetailsController {

    @Resource
    private MarketPriceDetailsService marketPriceDetailsService;

    @PostMapping("/create")
    @ApiOperation("创建市场价格明细")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price-details:create')")
    public CommonResult<String> createMarketPriceDetails(@Valid @RequestBody MarketPriceDetailsCreateReqVO createReqVO) {
        return success(marketPriceDetailsService.createMarketPriceDetails(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新市场价格明细")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price-details:update')")
    public CommonResult<Boolean> updateMarketPriceDetails(@Valid @RequestBody MarketPriceDetailsUpdateReqVO updateReqVO) {
        marketPriceDetailsService.updateMarketPriceDetails(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除市场价格明细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-price-details:delete')")
    public CommonResult<Boolean> deleteMarketPriceDetails(@RequestParam("id") String id) {
        marketPriceDetailsService.deleteMarketPriceDetails(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得市场价格明细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-price-details:query')")
    public CommonResult<MarketPriceDetailsRespVO> getMarketPriceDetails(@RequestParam("id") String id) {
        MarketPriceDetailsDO marketPriceDetails = marketPriceDetailsService.getMarketPriceDetails(id);
        return success(MarketPriceDetailsConvert.INSTANCE.convert(marketPriceDetails));
    }

    @GetMapping("/list")
    @ApiOperation("获得市场价格明细列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-price-details:query')")
    public CommonResult<List<MarketPriceDetailsRespVO>> getMarketPriceDetailsList(@RequestParam("ids") Collection<String> ids) {
        List<MarketPriceDetailsDO> list = marketPriceDetailsService.getMarketPriceDetailsList(ids);
        return success(MarketPriceDetailsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得市场价格明细分页")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price-details:query')")
    public CommonResult<PageResult<MarketPriceDetailsRespVO>> getMarketPriceDetailsPage(@Valid MarketPriceDetailsPageReqVO pageVO) {
        PageResult<MarketPriceDetailsDO> pageResult = marketPriceDetailsService.getMarketPriceDetailsPage(pageVO);
        return success(MarketPriceDetailsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出市场价格明细 Excel")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price-details:export')")
    @OperateLog(type = EXPORT)
    public void exportMarketPriceDetailsExcel(@Valid MarketPriceDetailsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MarketPriceDetailsDO> list = marketPriceDetailsService.getMarketPriceDetailsList(exportReqVO);
        // 导出 Excel
        List<MarketPriceDetailsExcelVO> datas = MarketPriceDetailsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "市场价格明细.xls", "数据", MarketPriceDetailsExcelVO.class, datas);
    }

    @GetMapping("/import-excel")
    @ApiOperation("导入市场价格明细 Excel")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price-details:import')")
    @OperateLog(type = EXPORT)
    public void importMarketPriceDetailsExcel(@Valid MarketPriceDetailsExportReqVO exportReqVO,
                                              HttpServletResponse response) throws IOException {
        List<MarketPriceDetailsDO> list = marketPriceDetailsService.getMarketPriceDetailsList(exportReqVO);
        // 导出 Excel
        List<MarketPriceDetailsExcelVO> datas = MarketPriceDetailsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "市场价格明细.xls", "数据", MarketPriceDetailsExcelVO.class, datas);
    }

}
