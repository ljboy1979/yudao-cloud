package cn.acsm.module.service.framework.rpc.config;

import cn.acsm.module.resource.api.adoptcontent.AdoptcontentApi;
import cn.acsm.module.service.api.serviceinfo.ServiceInfoApi;
import cn.iocoder.yudao.module.system.api.logger.LoginLogApi;
import cn.iocoder.yudao.module.system.api.sms.SmsCodeApi;
import cn.iocoder.yudao.module.system.api.social.SocialUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {AdoptcontentApi.class})
public class RpcConfiguration {
}
