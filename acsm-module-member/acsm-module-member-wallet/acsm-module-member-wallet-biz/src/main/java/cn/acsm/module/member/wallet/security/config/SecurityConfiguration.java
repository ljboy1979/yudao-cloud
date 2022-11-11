package cn.acsm.module.member.wallet.security.config;

import cn.acsm.module.member.wallet.enums.ApiConstants;
import cn.iocoder.yudao.framework.security.config.AuthorizeRequestsCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * Demo 模块的 Security 配置
 */
@Configuration("userSecurityConfiguration")
public class SecurityConfiguration {

    @Value("${spring.boot.admin.context-path:''}")
    private String adminSeverContextPath;

    @Bean("walletAuthorizeRequestsCustomizer")
    public AuthorizeRequestsCustomizer authorizeRequestsCustomizer() {
        return new AuthorizeRequestsCustomizer() {

            @Override
            public void customize(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry) {
                // Swagger 接口文档
                registry.antMatchers("/swagger-ui.html").anonymous()
                        .antMatchers("/swagger-resources/**").anonymous()
                        .antMatchers("/webjars/**").anonymous()
                        .antMatchers("/*/api-docs").anonymous();
                // Spring Boot Actuator 的安全配置
                registry.antMatchers("/actuator").anonymous()
                        .antMatchers("/actuator/**").anonymous();
                // Druid 监控
                registry.antMatchers("/druid/**").anonymous();
                // Spring Boot Admin Server 的安全配置
                registry.antMatchers(adminSeverContextPath).anonymous()
                        .antMatchers(adminSeverContextPath + "/**").anonymous();

                // TODO 芋艿：这个每个项目都需要重复配置，得捉摸有没通用的方案
                // RPC 服务的安全配置
                registry.antMatchers(ApiConstants.PREFIX + "/**").permitAll();
            }

        };
    }

}
