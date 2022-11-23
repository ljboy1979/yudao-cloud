package cn.acsm.module.member.signin.api.wechat.wechat;

import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatReqDTO;
import cn.acsm.module.member.signin.enums.ApiConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@FeignClient(name = ApiConstants.NAME, path = "rpc-api")
@Api(tags = "RPC 服务 - 微信相关接口")
public interface WeChatApi {

    String PREFIX = ApiConstants.PREFIX + "/weChat";

    @GetMapping(PREFIX + "/getOpenIdAndPhone")
    @ApiOperation("获取微信用户的openid和手机号")
    CommonResult getOpenIdAndPhone(@RequestBody WeChatReqDTO reqDTO);

}
