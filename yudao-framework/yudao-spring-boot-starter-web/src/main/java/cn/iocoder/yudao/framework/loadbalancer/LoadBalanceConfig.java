
package cn.iocoder.yudao.framework.loadbalancer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.cloud.loadbalancer.support.SimpleObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import cn.iocoder.yudao.framework.loadbalancer.NetSegmentServiceInstanceListSupplier;
@Configuration(proxyBeanMethods = false)
public class LoadBalanceConfig {

    @Bean
    @ConditionalOnProperty(value = "spring.cloud.loadbalancer.configurations", havingValue = "net-segment")
    public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context) {
        ServiceInstanceListSupplier supplier = ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withCaching().build(context);
        return new NetSegmentServiceInstanceListSupplier(supplier);
    }

    @Bean
    public ReactorLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(Environment environment, ServiceInstanceListSupplier serviceInstanceListSupplier) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RoundRobinLoadBalancer(new SimpleObjectProvider<>(serviceInstanceListSupplier), name);
    }
}
