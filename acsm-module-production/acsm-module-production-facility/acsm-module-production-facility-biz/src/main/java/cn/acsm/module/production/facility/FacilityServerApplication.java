package cn.acsm.module.production.facility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.acsm.module.production.facility.*"})
@EnableFeignClients
public class FacilityServerApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(FacilityServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
