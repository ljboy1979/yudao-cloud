package cn.acsm.module.purchase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("cn.acsm.module.purchase.dal.mysql.*")
@EnableFeignClients
public class PurchaseServerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PurchaseServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
