package cn.acsm.module.member.wallet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 * @author 芋道源码
 */
@SpringBootApplication
@MapperScan("cn.acsm.module.member.wallet.dal.mysql.*")
public class MemberWalletServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberWalletServerApplication.class, args);
    }

}
