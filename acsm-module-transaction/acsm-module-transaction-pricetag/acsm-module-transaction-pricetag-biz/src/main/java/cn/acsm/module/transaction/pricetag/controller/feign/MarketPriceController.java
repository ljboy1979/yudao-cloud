package cn.acsm.module.transaction.pricetag.controller.feign;

import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDetailsDto;
import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDto;
import cn.acsm.module.transaction.pricetag.api.pricetag.MarketPriceApi;
import cn.acsm.module.transaction.pricetag.service.marketcommodity.MarketCommodityService;
import cn.acsm.module.transaction.pricetag.service.marketpricedetails.MarketPriceDetailsService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value = "priceTag/feign/MarketPrice")
@Api(value = "MarketPriceController", description = "(价格牌)FeignController")
public class MarketPriceController {

    @Resource
    private MarketCommodityService marketCommodityService;
    @Resource
    private MarketPriceDetailsService marketPriceDetailsService;

    @GetMapping("getIdBySpecificationId")
    @ApiOperation("查询商品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    public CommonResult<List<MarketPriceDto>> getIdBySpecificationId(String id) {
        List<MarketPriceDto> marketPriceDtos = marketCommodityService.getIdBySpecificationId(id);
        return CommonResult.success(marketPriceDtos);
    }
    @PostMapping("saveMarketPriceDetails")
    @ApiOperation("新增价格牌详情")
    public void saveMarketPriceDetails(MarketPriceDetailsDto marketPriceDetailsDto) {
        marketPriceDetailsService.saveMarketPriceDetails(marketPriceDetailsDto);
    }
}
