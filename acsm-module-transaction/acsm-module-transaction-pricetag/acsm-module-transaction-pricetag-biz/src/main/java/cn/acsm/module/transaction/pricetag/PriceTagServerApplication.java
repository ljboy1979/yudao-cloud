package cn.acsm.module.transaction.pricetag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.acsm.module.transaction.pricetag.*"})
@EnableFeignClients
public class PriceTagServerApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(PriceTagServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
