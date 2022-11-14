package cn.acsm.module.member.user.controller.app.member;

import cn.acsm.module.member.user.service.member.MemberUserService;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户 APP - 用户")
@RestController
@RequestMapping("/user/member-user")
@Validated
public class AppMemberUserController {

    @Resource
    private MemberUserService memberUserService;


}
