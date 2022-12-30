package cn.acsm.module.production.tunnel.api.tunnel;

import cn.acsm.module.production.tunnel.api.ApiConstants;
import cn.acsm.module.production.tunnel.api.tunnel.dto.InfoBaseDTO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = ApiConstants.NAME)
@Api(tags = "RPC 服务 - 设施相关接口")
public interface TunnelInfoApi {
    String PREFIX = ApiConstants.PREFIX + "/info";

    @GetMapping(PREFIX+"/get")
    @ApiOperation("获得设施")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    CommonResult<InfoBaseDTO> getFacilityInfoById(@RequestParam("id") Long id) ;

}
