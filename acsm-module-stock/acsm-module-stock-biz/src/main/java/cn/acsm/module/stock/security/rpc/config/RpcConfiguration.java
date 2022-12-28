package cn.acsm.module.stock.security.rpc.config;

import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {DeptApi.class})
public class RpcConfiguration {
}
