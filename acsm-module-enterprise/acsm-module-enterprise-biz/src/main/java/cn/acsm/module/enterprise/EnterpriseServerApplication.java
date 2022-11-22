package cn.acsm.module.enterprise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("cn.acsm.module.enterprise.dal.mysql.*")
@EnableFeignClients
public class EnterpriseServerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EnterpriseServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
