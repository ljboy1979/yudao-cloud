package cn.acsm.module.member.user.controller.app.memberuserinfo;

import cn.acsm.module.member.user.controller.app.memberuserinfo.vo.AppMemberUserInfoRegisteredVO;
import cn.acsm.module.member.user.service.memberuserinfo.MemberUserInfoService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "用户 APP - 用户基本信息")
@RestController
@RequestMapping("/member/user-info")
@Validated
public class AppMemberUserInfoController {

    @Resource
    private MemberUserInfoService userInfoService;

    /**
     * @Description:获取用户openId微信小程序
     * @param registeredVO
     * @Date: 2022/11/8
     * @author: lihongyan
     * @throws
     * @return:cn.iocoder.yudao.framework.common.pojo.CommonResult
     */
    @GetMapping(value = "/registOrLoginByPhoneAndTenantId")
    @ApiOperation(value = "获取用户openId并登录",response = String.class)
    @PermitAll
    public CommonResult registOrLoginByPhoneAndTenantId(@RequestBody AppMemberUserInfoRegisteredVO registeredVO) throws Exception{
        return success(userInfoService.registOrLoginByPhoneAndTenantId(registeredVO));
    }

}
