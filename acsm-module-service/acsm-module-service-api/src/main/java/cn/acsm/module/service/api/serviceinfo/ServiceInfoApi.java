package cn.acsm.module.service.api.serviceinfo;

import cn.acsm.module.service.api.serviceinfo.dto.ServiceInfoRespDTO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.acsm.module.service.enums.ApiConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ApiConstants.NAME) // TODO 芋艿：fallbackFactory =
@Api(tags = "RPC 服务 - 服务数据")
public interface ServiceInfoApi {

    String PREFIX = ApiConstants.PREFIX + "/info";

    @GetMapping(PREFIX + "/get")
    @ApiOperation("获得指定的服务数据")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = String.class)
    CommonResult<ServiceInfoRespDTO> getServiceInfoById(@RequestParam("id") String id);



}
