package cn.acsm.module.transaction.shelves.framework.rpc.config;

import cn.acsm.module.transaction.sales.api.shelves.ShelvesApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {ShelvesApi.class})
public class RpcConfiguration {
}
