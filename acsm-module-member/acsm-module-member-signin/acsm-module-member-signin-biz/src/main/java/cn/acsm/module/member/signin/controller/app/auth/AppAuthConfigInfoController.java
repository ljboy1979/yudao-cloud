package cn.acsm.module.member.signin.controller.app.auth;

import cn.acsm.module.member.signin.service.auth.AuthConfigInfoService;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户 APP - 会员登录授权配置信息")
@RestController
@RequestMapping("/member/auth-config-info")
@Validated
public class AppAuthConfigInfoController {

    @Resource
    private AuthConfigInfoService authConfigInfoService;


}
