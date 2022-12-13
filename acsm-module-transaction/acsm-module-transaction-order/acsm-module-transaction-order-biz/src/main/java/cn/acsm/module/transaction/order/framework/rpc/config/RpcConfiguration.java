package cn.acsm.module.transaction.order.framework.rpc.config;

import cn.acsm.module.transaction.pricetag.api.pricetag.MarketPriceApi;
import cn.acsm.module.transaction.shelves.api.shelves.ShelvesApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {ShelvesApi.class,MarketPriceApi.class})
public class RpcConfiguration {
}
