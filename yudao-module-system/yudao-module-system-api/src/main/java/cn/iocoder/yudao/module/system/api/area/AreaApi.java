package cn.iocoder.yudao.module.system.api.area;

import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = ApiConstants.NAME)
@Api(tags = "RPC 服务 - 行政区划")
public interface AreaApi {

    String PREFIX = ApiConstants.PREFIX + "/area";
}
