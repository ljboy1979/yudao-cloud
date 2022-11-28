package cn.acsm.module.member.user.api.member;

import cn.acsm.module.member.user.api.member.dto.MemberUserRespDTO;
import cn.acsm.module.member.user.enums.ApiConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = ApiConstants.NAME)
@Api(tags = "RPC 服务 - 会员相关接口")
public interface MemberUserApi {

    String PREFIX = ApiConstants.PREFIX + "/member";

    @GetMapping(PREFIX + "/getMemberUser")
    @ApiOperation("根据id获取会员数据")
    @ApiImplicitParam(name = "id", value = "会员id", required = true, dataTypeClass = Long.class, example = "123")
    CommonResult getMemberUser(@RequestParam("id") Long id);

    @GetMapping(PREFIX + "/createUserIfAbsent")
    @ApiOperation("查询是否存在会员信息并创建")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataTypeClass = String.class, example = "18888888888"),
            @ApiImplicitParam(name = "clientIp", value = "ip", required = true, dataTypeClass = String.class, example = "127.0.0.1")
    })
    CommonResult<MemberUserRespDTO> createUserIfAbsent(@RequestParam("phone") String phone, @RequestParam("clientIp") String clientIp);

    @GetMapping(PREFIX + "/createLoginLog")
    @ApiOperation("注册插入登陆日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "会员id", required = true, dataTypeClass = Long.class, example = "123"),
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataTypeClass = String.class, example = "18888888888")
    })
    void createLoginLog(@RequestParam("userId") Long userId,  @RequestParam("mobile") String mobile);

}
