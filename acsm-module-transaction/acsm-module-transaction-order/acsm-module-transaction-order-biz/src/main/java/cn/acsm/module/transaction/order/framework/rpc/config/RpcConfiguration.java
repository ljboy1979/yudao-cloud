package cn.acsm.module.transaction.order.framework.rpc.config;

import cn.acsm.module.transaction.shelves.api.shelves.PriceTagApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {})
public class RpcConfiguration {
}
