package cn.acsm.module.transaction.sales.controller.feign.shelves;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.enums.ShelvesEnums;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesContext;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;


@RestController
@RequestMapping(value = "sales/feign/shelves")
@Api(value = "ShelvesApiController", description = "(售品)FeignController")
public class ShelvesApiController {

    @Resource
    private ShelvesContext shelvesContext;

    @PostMapping("/findSales")
    @ApiOperation("查询售品")
    public CommonResult<List<ShelvesSalesRespDto>> findSales(@RequestBody ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDto> salesList = shelvesContext.getService(ShelvesEnums.getByType(shelvesSalesReqDto.getType()).getValue()).findSales(shelvesSalesReqDto);
        return CommonResult.success(salesList);
    }

    @PostMapping("/findSpecifications")
    @ApiOperation("查询售品规格")
    public CommonResult<List<ShelvesSalesRespDto>> findSpecifications(@RequestBody ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDto> specifications = shelvesContext.getService(ShelvesEnums.getByType(shelvesSalesReqDto.getType()).getValue()).findSpecifications(shelvesSalesReqDto);
        return CommonResult.success(specifications);

    }
}
