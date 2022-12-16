package cn.acsm.module.production.bases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.acsm.module.production.bases.*"})
@EnableFeignClients
public class BasesServerApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(BasesServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
