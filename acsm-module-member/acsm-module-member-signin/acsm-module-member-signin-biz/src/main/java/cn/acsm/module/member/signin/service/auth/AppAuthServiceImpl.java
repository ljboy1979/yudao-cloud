package cn.acsm.module.member.signin.service.auth;

import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatReqDTO;
import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatRespDTO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthLoginRespVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthSmsLoginReqVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthSmsSendReqVO;
import cn.acsm.module.member.signin.convert.auth.AuthConvert;
import cn.acsm.module.member.signin.dal.dataobject.config.AuthLoginInfoDO;
import cn.acsm.module.member.signin.dal.mysql.config.AuthLoginInfoMapper;
import cn.acsm.module.member.signin.service.config.AuthConfigInfoService;
import cn.acsm.module.member.user.api.member.MemberUserApi;
import cn.acsm.module.member.user.api.member.dto.MemberUserRespDTO;
import cn.hutool.core.lang.Assert;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.api.oauth2.OAuth2TokenApi;
import cn.iocoder.yudao.module.system.api.oauth2.dto.OAuth2AccessTokenCreateReqDTO;
import cn.iocoder.yudao.module.system.api.oauth2.dto.OAuth2AccessTokenRespDTO;
import cn.iocoder.yudao.module.system.api.sms.SmsCodeApi;
import cn.iocoder.yudao.module.system.enums.oauth2.OAuth2ClientConstants;
import cn.iocoder.yudao.module.system.enums.sms.SmsSceneEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.util.servlet.ServletUtils.getClientIP;

/**
 * 会员登录授权配置信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class AppAuthServiceImpl implements AppAuthService {
    @Resource
    private OAuth2TokenApi oauth2TokenApi;
    @Resource
    private MemberUserApi memberUserApi;
    @Resource
    private SmsCodeApi smsCodeApi;

    @Resource
    private AuthConfigInfoService authConfigInfoServiceImpl;
    @Resource
    private AuthLoginInfoMapper authLoginInfoMapper;

    /**
     * @Description:发送短信
     * @param userId
     * @param reqVO
     * @Date: 2022/11/22
     * @author: lihongyan
     * @throws
     * @return:void
     */
    @Override
    public void sendSmsCode(Long userId, AppAuthSmsSendReqVO reqVO) {
        // TODO 根据短接信息添加
    }

    /**
     * @Description:手机号短信登录
     * @param reqVO
     * @Date: 2022/11/22
     * @author: lihongyan
     * @throws
     * @return:cn.iocoder.yudao.framework.common.pojo.CommonResult
     */
    @Override
    @Transactional
    public CommonResult smsLogin(AppAuthSmsLoginReqVO reqVO) {
        // 校验验证码
        String userIp = getClientIP();
        smsCodeApi.useSmsCode(AuthConvert.INSTANCE.convert(reqVO, SmsSceneEnum.MEMBER_LOGIN.getScene(), userIp));

        // 获得获得注册用户
        CommonResult<MemberUserRespDTO> respDTOCommonResult = memberUserApi.createUserIfAbsent(reqVO.getMobile(), userIp);
        if (respDTOCommonResult.getCode() != 0){
            return respDTOCommonResult;
        }
        Assert.notNull(respDTOCommonResult.getData(), "获取用户失败，结果为空");
        MemberUserRespDTO memberUserRespDTO = respDTOCommonResult.getData();

        // 创建 Token 令牌，记录登录日志
        return CommonResult.success(createTokenAfterLoginSuccess(memberUserRespDTO));
    }

    /**
     * @Description:微信小程序注册登录
     * @param weChatReqDTO
     * @Date: 2022/11/21
     * @author: lihongyan
     * @throws
     * @return:cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthLoginRespVO
     */
    @Override
    public CommonResult weixinMiniAppLogin(WeChatReqDTO weChatReqDTO) {
        // 获得对应的手机号信息
        CommonResult<WeChatRespDTO> result = authConfigInfoServiceImpl.getOpenIdAndPhone(weChatReqDTO);
        if (result.getCode() != 0){
            return result;
        }
        WeChatRespDTO respDTO = result.getData();
        String phone = respDTO.getPhone();
        // 获得获得注册用户
        CommonResult<MemberUserRespDTO> respDTOCommonResult = memberUserApi.createUserIfAbsent(phone, getClientIP());
        if (respDTOCommonResult.getCode() != 0){
            return respDTOCommonResult;
        }
        Assert.notNull(respDTOCommonResult.getData(), "获取用户失败，结果为空");
        MemberUserRespDTO memberUserRespDTO = respDTOCommonResult.getData();
        // 保存或修改登录信息记录
        AuthLoginInfoDO authLoginInfoDO = authLoginInfoMapper.selectInfoByMemberId(memberUserRespDTO.getId());
        if (authLoginInfoDO==null){
            authLoginInfoDO = new AuthLoginInfoDO();
            authLoginInfoDO.setOpenId(respDTO.getOpenId());
            authLoginInfoDO.setType(1); // 1-微信
            authLoginInfoDO.setMemberId(memberUserRespDTO.getId());
            authLoginInfoDO.setPhone(phone);
            authLoginInfoMapper.insert(authLoginInfoDO);
        }else{
            authLoginInfoDO.setOpenId(respDTO.getOpenId());
            authLoginInfoMapper.updateById(authLoginInfoDO);
        }
        memberUserRespDTO.setOpenId(respDTO.getOpenId());

        // 创建 Token 令牌，记录登录日志
        return CommonResult.success(createTokenAfterLoginSuccess(memberUserRespDTO));
    }

    /**
     * @Description:调用system创建访问令牌
     * @param userDTO
     * @Date: 2022/11/17
     * @author: lihongyan
     * @throws
     * @return:cn.acsm.module.member.user.controller.app.auth.vo.AppAuthLoginRespVO
     */
    private AppAuthLoginRespVO createTokenAfterLoginSuccess(MemberUserRespDTO userDTO) {
        // 插入登陆日志
        memberUserApi.createLoginLog(userDTO.getId(), userDTO.getMobile());
        // 创建 Token 令牌
        CommonResult<OAuth2AccessTokenRespDTO> result = oauth2TokenApi.createAccessToken(new OAuth2AccessTokenCreateReqDTO()
                .setUserId(userDTO.getId()).setUserType(getUserType().getValue())
                .setClientId(OAuth2ClientConstants.CLIENT_ID_DEFAULT));
        // 构建返回结果
        AppAuthLoginRespVO respVO = AuthConvert.INSTANCE.convert(result.getData(),userDTO.getMobile() ,userDTO.getOpenId());
        return respVO;
    }

    private UserTypeEnum getUserType() {
        return UserTypeEnum.MEMBER;
    }
}
