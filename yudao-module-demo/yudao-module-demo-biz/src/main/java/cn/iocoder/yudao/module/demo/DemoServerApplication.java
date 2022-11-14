package cn.iocoder.yudao.module.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoServerApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(DemoServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
