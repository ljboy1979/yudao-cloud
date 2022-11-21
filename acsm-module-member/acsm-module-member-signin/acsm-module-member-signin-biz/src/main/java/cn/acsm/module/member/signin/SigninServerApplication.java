package cn.acsm.module.member.signin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("cn.acsm.module.member.signin.dal.mysql.*")
@EnableFeignClients
public class SigninServerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SigninServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
