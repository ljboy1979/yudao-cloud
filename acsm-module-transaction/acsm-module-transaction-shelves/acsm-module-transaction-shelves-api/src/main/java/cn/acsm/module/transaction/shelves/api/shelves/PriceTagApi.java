package cn.acsm.module.transaction.shelves.api.shelves;

import cn.acsm.module.transaction.shelves.api.dto.PriceTagShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.acsm.module.transaction.shelves.enums.ApiConstants;
import cn.acsm.module.transaction.shelves.api.dto.PriceTagShelvesRespDto;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = ApiConstants.NAME,path = "sales/feign/pricetag")
@Api(tags = "RPC 服务 - 价格牌相关接口")
public interface PriceTagApi {

    @PostMapping("findPriceTagShelves")
    @ApiOperation("查询售品")
    CommonResult<List<PriceTagShelvesRespDto>> findPriceTagShelves(@RequestBody PriceTagShelvesReqDto shelvesReqDto);

    @PostMapping("findPriceTagSpecifications")
    @ApiOperation("查询售品")
    CommonResult<List<PriceTagShelvesRespDto>> findPriceTagSpecifications(@RequestBody PriceTagShelvesReqDto shelvesReqDto);

    @PostMapping("treeList")
    @ApiOperation("查询售品")
    CommonResult<List<TreeSelectDto>> treeList(@RequestBody PriceTagShelvesReqDto shelvesReqDto);

}
