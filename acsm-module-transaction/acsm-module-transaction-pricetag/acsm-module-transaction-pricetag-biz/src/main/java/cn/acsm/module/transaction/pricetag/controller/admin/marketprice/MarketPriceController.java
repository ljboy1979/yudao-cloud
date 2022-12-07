package cn.acsm.module.transaction.pricetag.controller.admin.marketprice;

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

import cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;
import cn.acsm.module.transaction.pricetag.convert.marketprice.MarketPriceConvert;
import cn.acsm.module.transaction.pricetag.service.marketprice.MarketPriceService;

@Api(tags = "管理后台 - 市场价格")
@RestController
@RequestMapping("/pricetag/market-price")
@Validated
public class MarketPriceController {

    @Resource
    private MarketPriceService marketPriceService;

    @PostMapping("/create")
    @ApiOperation("创建市场价格")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price:create')")
    public CommonResult<String> createMarketPrice(@Valid @RequestBody MarketPriceCreateReqVO createReqVO) {
        return success(marketPriceService.createMarketPrice(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新市场价格")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price:update')")
    public CommonResult<Boolean> updateMarketPrice(@Valid @RequestBody MarketPriceUpdateReqVO updateReqVO) {
        marketPriceService.updateMarketPrice(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除市场价格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-price:delete')")
    public CommonResult<Boolean> deleteMarketPrice(@RequestParam("id") String id) {
        marketPriceService.deleteMarketPrice(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得市场价格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-price:query')")
    public CommonResult<MarketPriceRespVO> get(@RequestParam("id") String id) {
        MarketPriceDO marketPrice = marketPriceService.getMarketPrice(id);
        return success(MarketPriceConvert.INSTANCE.convert(marketPrice));
    }

    @GetMapping("/list")
    @ApiOperation("获得市场价格列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-price:query')")
    public CommonResult<List<MarketPriceRespVO>> getMarketPriceList(@RequestParam("ids") Collection<String> ids) {
        List<MarketPriceDO> list = marketPriceService.getMarketPriceList(ids);
        return success(MarketPriceConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得市场价格分页")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price:query')")
    public CommonResult<PageResult<MarketPriceRespVO>> getMarketPricePage(@Valid MarketPricePageReqVO pageVO) {
        PageResult<MarketPriceDO> pageResult = marketPriceService.getMarketPricePage(pageVO);
        return success(MarketPriceConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出市场价格 Excel")
    @PreAuthorize("@ss.hasPermission('pricetag:market-price:export')")
    @OperateLog(type = EXPORT)
    public void exportMarketPriceExcel(@Valid MarketPriceExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MarketPriceDO> list = marketPriceService.getMarketPriceList(exportReqVO);
        // 导出 Excel
        List<MarketPriceExcelVO> datas = MarketPriceConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "市场价格.xls", "数据", MarketPriceExcelVO.class, datas);
    }


    @GetMapping("/getMarketPrice")
    @ApiOperation("获得市场价格")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('pricetag:market-price:query')")
    public CommonResult<MarketPriceInfoVo> getMarketPrice(@RequestParam("id") String id) {
        MarketPriceInfoVo marketPrice = marketPriceService.getMarketPriceInfo(id);
        return success(marketPrice);
    }

}
