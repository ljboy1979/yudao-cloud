package cn.acsm.module.member.signin.api.wechat;

import cn.acsm.module.member.signin.api.wechat.wechat.WeChatApi;
import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatReqDTO;
import cn.acsm.module.member.signin.service.config.AuthConfigInfoService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.acsm.module.member.signin.enums.ApiConstants.VERSION;


@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class WeChatApiImpl implements WeChatApi {

    @Resource
    private AuthConfigInfoService authConfigInfoService;

    @Override
    public CommonResult getOpenIdAndPhone(WeChatReqDTO reqDTO) {
        return authConfigInfoService.getOpenIdAndPhone(reqDTO);
    }
}
