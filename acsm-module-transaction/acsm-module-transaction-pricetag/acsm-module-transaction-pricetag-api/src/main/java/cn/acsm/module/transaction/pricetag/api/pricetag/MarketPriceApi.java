package cn.acsm.module.transaction.pricetag.api.pricetag;

import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDetailsDto;
import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDto;
import cn.acsm.module.transaction.pricetag.enums.ApiConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = ApiConstants.NAME,path = "priceTag/feign/MarketPrice")
@Api(tags = "RPC 服务 - 价格牌相关接口")
public interface MarketPriceApi {

    @GetMapping("getIdBySpecificationId")
    @ApiOperation("查询商品")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    CommonResult<List<MarketPriceDto>> getIdBySpecificationId(@RequestParam("id") String id);

    @PostMapping("saveMarketPriceDetails")
    @ApiOperation("新增价格牌详情")
    void saveMarketPriceDetails(@RequestBody MarketPriceDetailsDto marketPriceDetailsDto);


}
