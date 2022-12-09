package cn.acsm.module.resource.api.adoptcontent;

import cn.acsm.module.resource.api.adoptcontent.dto.AdoptContentReqDTO;
import cn.acsm.module.resource.enums.ApiConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * chenkun 2022/12/9
 */
@FeignClient(name = ApiConstants.NAME) // TODO 芋艿：fallbackFactory =
@Api(tags = "RPC 服务 - 认养/租赁数据")
public interface AdoptcontentApi {

    String PREFIX = ApiConstants.PREFIX + "/adopt-content";

    @GetMapping(PREFIX + "/get")
    @ApiOperation("获得指定的认养/租赁数据")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = String.class)
    CommonResult<AdoptContentReqDTO> getAdoptContentById(@RequestParam("id") String id);

    @GetMapping(PREFIX + "/listNotIn")
    @ApiOperation("获得指定的认养/租赁数据List")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = String.class)
    CommonResult<List<AdoptContentReqDTO>> getAdoptContentList(@RequestParam("id") String id);



}
