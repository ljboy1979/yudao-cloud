package cn.acsm.module.member.signin.controller.app.auth;

import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatReqDTO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthLoginRespVO;
import cn.acsm.module.member.signin.service.auth.AppAuthService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "用户 APP - 会员登录授权配置信息")
@RestController
@RequestMapping("/member/auth-config-info")
@Validated
public class AppAuthController {

    @Resource
    private AppAuthService authService;

    @PostMapping("/weixinMiniAppLogin")
    @ApiOperation("微信小程序的一键登录")
    public CommonResult<AppAuthLoginRespVO> weixinMiniAppLogin(@RequestBody @Valid WeChatReqDTO weChatReqDTO) {
        return authService.weixinMiniAppLogin(weChatReqDTO);
    }

}
