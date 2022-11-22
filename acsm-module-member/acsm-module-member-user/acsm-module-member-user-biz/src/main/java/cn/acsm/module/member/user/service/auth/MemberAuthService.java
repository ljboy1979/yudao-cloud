package cn.acsm.module.member.user.service.auth;

import cn.iocoder.yudao.module.system.enums.logger.LoginLogTypeEnum;
import cn.iocoder.yudao.module.system.enums.logger.LoginResultEnum;

/**
 * 会员的认证 Service 接口
 *
 * 提供用户的账号密码登录、token 的校验等认证相关的功能
 *
 * @author lihongyan
 */
public interface MemberAuthService {

    /**
     * @Description:注册插入登陆日志
     * @param userId
     * @param mobile
     * @param logType
     * @param loginResult
     * @Date: 2022/11/21
     * @author: lihongyan
     * @throws
     * @return:void
     */
    void createLoginLog(Long userId, String mobile, LoginLogTypeEnum logType, LoginResultEnum loginResult);
}
