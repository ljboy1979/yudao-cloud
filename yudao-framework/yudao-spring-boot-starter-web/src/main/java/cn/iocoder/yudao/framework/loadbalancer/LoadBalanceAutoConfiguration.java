package cn.iocoder.yudao.framework.web.core.loadbalancer;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerBeanPostProcessorAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerClientAutoConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@LoadBalancerClients(defaultConfiguration = LoadBalanceConfig.class)
@AutoConfigureBefore({ ReactorLoadBalancerClientAutoConfiguration.class,
        LoadBalancerBeanPostProcessorAutoConfiguration.class })
public class LoadBalanceAutoConfiguration {
}
