package cn.iocoder.yudao.module.bpm.framework.bpm.config;

import cn.iocoder.yudao.framework.security.config.AuthorizeRequestsCustomizer;
import cn.iocoder.yudao.module.bpm.enums.ApiConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @author kemengkai
 * @create 2022-05-07 08:15
 */
@Configuration(proxyBeanMethods = false, value = "bpmSecurityConfiguration")
public class BpmSecurityConfiguration {
    @Value("${spring.boot.admin.context-path:''}")
    private String adminSeverContextPath;
    @Bean("bpmAuthorizeRequestsCustomizer")
//    public AuthorizeRequestsCustomizer authorizeRequestsCustomizer() {
//        return new AuthorizeRequestsCustomizer() {
//
//            @Override
//            public void customize(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry) {
//                // 任务回退接口
//                registry.antMatchers(buildAdminApi("/bpm/task/back")).permitAll();
//            }
//
//        };
//    }
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
