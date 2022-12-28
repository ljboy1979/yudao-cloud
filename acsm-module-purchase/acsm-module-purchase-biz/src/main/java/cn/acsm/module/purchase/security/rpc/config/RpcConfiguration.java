package cn.acsm.module.purchase.security.rpc.config;

import cn.acsm.module.stock.api.inventory.StockInventoryApi;
import cn.acsm.module.transaction.sales.api.shelves.ShelvesApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {ShelvesApi.class, StockInventoryApi.class})
public class RpcConfiguration {
}
