package cn.acsm.module.member.signin.controller.app.auth;

import cn.acsm.module.member.signin.service.auth.AppAuthService;
import cn.acsm.module.member.signin.service.config.AuthConfigInfoService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户 APP - 会员登录授权配置信息")
@RestController
@RequestMapping("/member/auth-config-info")
@Validated
public class AppAuthController {

    @Resource
    private AppAuthService authService;

    @GetMapping("/test")
    public CommonResult getMemberUser(@RequestParam("id") Long id){

        return authService.getMemberUser(id);
    }

}
