package cn.acsm.module.member.signin.framework.rpc.config;

import cn.acsm.module.member.user.api.member.MemberUserApi;
import cn.iocoder.yudao.module.system.api.sms.SmsCodeApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {MemberUserApi.class, SmsCodeApi.class})
public class RpcConfiguration {
}
