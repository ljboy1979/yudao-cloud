
package cn.iocoder.yudao.framework.loadbalancer;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerBeanPostProcessorAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerClientAutoConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Configuration;
import cn.iocoder.yudao.framework.loadbalancer.LoadBalanceConfig;
@Configuration(proxyBeanMethods = false)
@LoadBalancerClients(defaultConfiguration = LoadBalanceConfig.class)
@AutoConfigureBefore({ ReactorLoadBalancerClientAutoConfiguration.class,
        LoadBalancerBeanPostProcessorAutoConfiguration.class })
public class LoadBalanceAutoConfiguration {
}
