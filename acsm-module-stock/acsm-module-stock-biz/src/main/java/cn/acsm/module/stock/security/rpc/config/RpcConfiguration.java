package cn.acsm.module.stock.security.rpc.config;

import cn.acsm.module.purchase.api.orderdetails.OrderDetailsApi;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {DeptApi.class, AdminUserApi.class, OrderDetailsApi.class})
public class RpcConfiguration {
}
