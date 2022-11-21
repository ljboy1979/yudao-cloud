package cn.acsm.module.member.signin.convert.auth;

import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthLoginRespVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthResetPasswordReqVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthSmsLoginReqVO;
import cn.acsm.module.member.signin.controller.app.auth.vo.AppAuthSmsSendReqVO;
import cn.iocoder.yudao.module.system.api.oauth2.dto.OAuth2AccessTokenRespDTO;
import cn.iocoder.yudao.module.system.api.sms.dto.code.SmsCodeSendReqDTO;
import cn.iocoder.yudao.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import cn.iocoder.yudao.module.system.enums.sms.SmsSceneEnum;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthConvert {

    AuthConvert INSTANCE = Mappers.getMapper(AuthConvert.class);
    SmsCodeSendReqDTO convert(AppAuthSmsSendReqVO reqVO);
    SmsCodeUseReqDTO convert(AppAuthResetPasswordReqVO reqVO, SmsSceneEnum scene, String usedIp);
    SmsCodeUseReqDTO convert(AppAuthSmsLoginReqVO reqVO, Integer scene, String usedIp);

    AppAuthLoginRespVO convert(OAuth2AccessTokenRespDTO bean);

}
