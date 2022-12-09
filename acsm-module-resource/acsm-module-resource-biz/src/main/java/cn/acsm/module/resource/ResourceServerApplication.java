package cn.acsm.module.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("cn.acsm.module.resource.dal.mysql.*")
@EnableFeignClients
public class ResourceServerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ResourceServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
