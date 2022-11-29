package cn.iocoder.yudao.module.system.api.area;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.area.AreaTreeSelect;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = ApiConstants.NAME)
@Api(tags = "RPC 服务 - 行政区划")
public interface AreaApi {

    String PREFIX = ApiConstants.PREFIX + "/area";

    @GetMapping(PREFIX + "/tree")
    @ApiOperation("获取行政区划树形数据")
    CommonResult< List< AreaTreeSelect > > tree();
}
