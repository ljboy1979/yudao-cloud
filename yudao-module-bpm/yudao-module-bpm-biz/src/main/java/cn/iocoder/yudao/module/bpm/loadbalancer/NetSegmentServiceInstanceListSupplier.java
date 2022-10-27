package cn.iocoder.yudao.module.bpm.loadbalancer;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtil;
import cn.iocoder.yudao.framework.common.util.ip.IPV4Util;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.loadbalancer.core.DelegatingServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.net.InetAddress;
import java.util.List;

/**
 * 按相同网段优先进行负载均衡
 */
@Slf4j
public class NetSegmentServiceInstanceListSupplier extends DelegatingServiceInstanceListSupplier {

    private InetUtils inetUtils;

    public NetSegmentServiceInstanceListSupplier(ServiceInstanceListSupplier delegate) {
        super(delegate);
        inetUtils = new InetUtils(new InetUtilsProperties());
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return getDelegate().get().map(this::filterByNetSegment);
    }

    private List<ServiceInstance> filterByNetSegment(List<ServiceInstance> instances) {
        InetAddress host = inetUtils.findFirstNonLoopbackAddress();
        if(host == null){
            return instances;
        }
        String resourceIp = host.getHostAddress();
        List<ServiceInstance> targetList = Lists.newArrayList();
        for(ServiceInstance instance : instances){
            if(IPV4Util.isSameAddress(resourceIp, instance.getHost())){
                targetList.add(instance);
            }
        }
        if(CollectionUtil.isEmpty(targetList)){
            return instances;
        }
        return targetList;
    }
}