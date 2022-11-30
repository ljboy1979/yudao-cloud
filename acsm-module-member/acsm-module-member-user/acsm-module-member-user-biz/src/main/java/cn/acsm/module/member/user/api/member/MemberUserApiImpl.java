package cn.acsm.module.member.user.api.member;

import cn.acsm.module.member.user.api.member.dto.MemberUserReqDTO;
import cn.acsm.module.member.user.api.member.dto.MemberUserRespDTO;
import cn.acsm.module.member.user.convert.member.MemberUserConvert;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDO;
import cn.acsm.module.member.user.service.member.MemberUserService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.enums.logger.LoginLogTypeEnum;
import cn.iocoder.yudao.module.system.enums.logger.LoginResultEnum;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.acsm.module.member.user.enums.ApiConstants.VERSION;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class MemberUserApiImpl implements MemberUserApi {

    @Resource
    private MemberUserService userService;

    @Override
    public CommonResult getMemberUser(Long id) {
        MemberUserDO memberUserDO = userService.getUser(id);
        return CommonResult.success(memberUserDO);
    }

    @Override
    public CommonResult<MemberUserRespDTO> createUserIfAbsent(MemberUserReqDTO memberUserReqDTO) {
        MemberUserRespDTO dto = MemberUserConvert.INSTANCE.convertRespDTO(userService.createUserIfAbsent(memberUserReqDTO));
        return CommonResult.success(dto);
    }

    @Override
    public void createLoginLog(Long userId, String mobile) {
        userService.createLoginLog(userId, mobile, LoginLogTypeEnum.LOGIN_MOBILE, LoginResultEnum.SUCCESS);
    }
}
