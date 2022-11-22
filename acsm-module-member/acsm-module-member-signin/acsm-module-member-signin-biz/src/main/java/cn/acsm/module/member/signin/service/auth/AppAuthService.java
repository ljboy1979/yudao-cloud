package cn.acsm.module.member.signin.service.auth;

import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatReqDTO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthLoginRespVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthWeixinMiniAppLoginReqVO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;

/**
 * 会员登录授权配置信息 Service 接口
 *
 * @author lihongyan
 */
public interface AppAuthService {

    /**
     * 微信小程序的一键登录
     * @param weChatReqDTO 登录信息
     * @return 登录结果
     */
    CommonResult weixinMiniAppLogin(WeChatReqDTO weChatReqDTO);
}
