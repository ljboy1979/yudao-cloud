package cn.acsm.module.production.tunnel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.acsm.module.production.tunnel.*"})
@EnableFeignClients
public class TunnelServerApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(TunnelServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
