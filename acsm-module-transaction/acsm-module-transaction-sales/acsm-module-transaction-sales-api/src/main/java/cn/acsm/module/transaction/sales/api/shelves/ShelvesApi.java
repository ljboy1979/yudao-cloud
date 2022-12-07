package cn.acsm.module.transaction.sales.api.shelves;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.enums.ApiConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = ApiConstants.NAME,path = "sales/feign/shelves")
@Api(tags = "RPC 服务 - 货架相关接口")
public interface ShelvesApi {

    @PostMapping("findSales")
    @ApiOperation("查询售品")
    CommonResult<List<ShelvesSalesRespDto>> findSales(@RequestBody ShelvesSalesReqDto shelvesSalesReqDto);

    @PostMapping("findSpecifications")
    @ApiOperation("查询售品")
    CommonResult<List<ShelvesSalesRespDto>> findSpecifications(@RequestBody ShelvesSalesReqDto shelvesSalesReqDto);
}
