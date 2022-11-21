package cn.acsm.module.member.user.api.member;

import cn.acsm.module.member.user.enums.ApiConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = ApiConstants.NAME)
@Api(tags = "RPC 服务 - 会员相关接口")
public interface MemberUserApi {

    String PREFIX = ApiConstants.PREFIX + "/member";

    @GetMapping(PREFIX + "/getMemberUser")
    @ApiOperation("根据id获取会员数据")
    CommonResult getMemberUser(@RequestParam("id") Long id);

    @GetMapping(PREFIX + "/createUserIfAbsent")
    @ApiOperation("查询是否存在会员信息并创建")
    CommonResult createUserIfAbsent(@RequestParam("phone") String phone, @RequestParam("clientIp") String clientIp);

    @GetMapping(PREFIX + "/createLoginLog")
    @ApiOperation("注册插入登陆日志")
    void createLoginLog(@RequestParam("userId") Long userId,  @RequestParam("mobile") String mobile);

}
