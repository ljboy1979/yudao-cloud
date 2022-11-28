package cn.acsm.module.member.signin.service.auth;

import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatReqDTO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthSmsLoginReqVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthSmsSendReqVO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;

import javax.validation.Valid;

/**
 * 会员登录授权配置信息 Service 接口
 *
 * @author lihongyan
 */
public interface AppAuthService {

    /**
     * 给用户发送短信验证码
     * @param userId 用户编号
     * @param reqVO 发送信息
     */
    void sendSmsCode(Long userId, AppAuthSmsSendReqVO reqVO);

    /**
     * 手机 + 验证码登陆
     * @param reqVO 登陆信息
     * @return 登录结果
     */
    CommonResult smsLogin(@Valid AppAuthSmsLoginReqVO reqVO);

    /**
     * 微信小程序的一键登录
     * @param weChatReqDTO 登录信息
     * @return 登录结果
     */
    CommonResult weixinMiniAppLogin(WeChatReqDTO weChatReqDTO);
}
