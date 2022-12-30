package cn.acsm.module.production.facility.api.cargospace;

import cn.acsm.module.production.facility.api.ApiConstants;
import cn.acsm.module.production.facility.api.cargospace.dto.CargoSpaceBaseDTO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = ApiConstants.NAME)
@Api(tags = "RPC 服务 - 设施相关接口")
public interface FacilityCargospaceApi {

    String PREFIX = ApiConstants.PREFIX + "/cargospace";
    @GetMapping(PREFIX+"/getById")
    @ApiOperation("获得设施仓位详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    CommonResult<CargoSpaceBaseDTO> getById(@RequestParam("id") Long id) ;


    @GetMapping(PREFIX+"/findListByFacilityId")
    @ApiOperation("通过设施ID获取货位列表")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    CommonResult<List<CargoSpaceBaseDTO>> findListByFacilityId(@RequestParam("id") Long id) ;


    @GetMapping(PREFIX+"/findListByCode")
    @ApiOperation("通过货位编号获取货位列表")
    @ApiImplicitParam(name = "code", value = "货位编号", required = true, example = "XX", dataTypeClass = String.class)
    CommonResult<List<CargoSpaceBaseDTO>> findListByCode(@RequestParam("code") String code) ;
}
