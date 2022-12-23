package cn.acsm.module.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("cn.acsm.module.stock.dal.mysql.*")
@EnableFeignClients
public class StockServerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StockServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
