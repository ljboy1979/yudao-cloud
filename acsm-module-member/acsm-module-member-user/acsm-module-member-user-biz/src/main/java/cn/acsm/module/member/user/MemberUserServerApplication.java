package cn.acsm.module.member.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("cn.acsm.module.member.user.dal.mysql.*")
@EnableFeignClients
public class MemberUserServerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MemberUserServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
