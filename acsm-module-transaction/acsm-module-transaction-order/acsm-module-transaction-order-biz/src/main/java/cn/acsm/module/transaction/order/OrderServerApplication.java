package cn.acsm.module.transaction.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.acsm.module.transaction.order.*"})
@EnableFeignClients
public class OrderServerApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(OrderServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
