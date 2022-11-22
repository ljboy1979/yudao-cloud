package cn.acsm.module.wallet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.acsm.module.wallet.dal.mysql.*")
public class WalletServerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WalletServerApplication.class);
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }
}
