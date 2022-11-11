package cn.acsm.module.member.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 * @author 芋道源码
 */
@SpringBootApplication
@MapperScan("cn.acsm.module.member.user.dal.mysql.*")
public class MemberUserInfoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberUserInfoServerApplication.class, args);
    }

}
