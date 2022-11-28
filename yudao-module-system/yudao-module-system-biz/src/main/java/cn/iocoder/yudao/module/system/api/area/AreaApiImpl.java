package cn.iocoder.yudao.module.system.api.area;

import cn.iocoder.yudao.module.system.service.area.AreaService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import static cn.iocoder.yudao.module.system.enums.ApiConstants.VERSION;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class AreaApiImpl implements AreaApi {

    @Resource
    private AreaService areaService;
}
