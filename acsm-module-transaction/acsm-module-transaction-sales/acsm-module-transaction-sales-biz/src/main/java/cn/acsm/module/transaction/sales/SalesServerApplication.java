package cn.acsm.module.transaction.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.acsm.module.transaction.sales"})
public class SalesServerApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(SalesServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
