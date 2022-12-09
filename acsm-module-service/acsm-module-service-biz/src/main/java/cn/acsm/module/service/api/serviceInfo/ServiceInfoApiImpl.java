package cn.acsm.module.service.api.serviceInfo;


import cn.acsm.module.service.api.serviceinfo.ServiceInfoApi;
import cn.acsm.module.service.api.serviceinfo.dto.ServiceInfoRespDTO;
import cn.acsm.module.service.controller.admin.serviceinfo.vo.ServiceInfoRespVO;
import cn.acsm.module.service.convert.serviceinfo.ServiceInfoConvert;
import cn.acsm.module.service.dal.dataobject.serviceinfo.ServiceInfoDO;
import cn.acsm.module.service.dal.mysql.serviceinfo.ServiceInfoMapper;
import cn.acsm.module.service.service.serviceinfo.ServiceInfoService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.acsm.module.service.enums.ApiConstants.VERSION;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * chenkun 2022/12/9
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class ServiceInfoApiImpl implements ServiceInfoApi {

    @Resource
    private ServiceInfoService serviceInfoService;

    @Override
    public CommonResult<ServiceInfoRespDTO> getServiceInfoById(String id) {
        ServiceInfoRespVO respVO = serviceInfoService.getInfo(Long.valueOf(id));
        return success(ServiceInfoConvert.INSTANCE.convert01(respVO));
    }
}
