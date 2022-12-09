package cn.acsm.module.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("cn.acsm.module.service.dal.mysql.*")
@EnableFeignClients(basePackages = "")
public class ServiceServerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServiceServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
