package cn.acsm.module.production.facility.api.info;

import cn.acsm.module.production.facility.api.ApiConstants;
import cn.acsm.module.production.facility.api.info.dto.FacilityInfoDto;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = ApiConstants.NAME)
@Api(tags = "RPC 服务 - 设施相关接口")
public interface FacilityInfoApi {

    String PREFIX = ApiConstants.PREFIX + "/info";
    @GetMapping(PREFIX+"/get")
    @ApiOperation("获得设施")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    CommonResult<FacilityInfoDto> getFacilityInfoById(@RequestParam("id") Long id) ;


}
