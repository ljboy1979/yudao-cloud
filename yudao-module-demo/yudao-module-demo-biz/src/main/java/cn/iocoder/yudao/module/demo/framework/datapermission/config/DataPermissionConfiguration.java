package cn.iocoder.yudao.module.demo.framework.datapermission.config;

import cn.iocoder.yudao.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import cn.iocoder.yudao.module.demo.dal.dataobject.notice.NoticeDO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 基于部门的数据权限 AutoConfiguration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class DataPermissionConfiguration {
    @Bean
    public DeptDataPermissionRuleCustomizer demoDeptDataPermissionRuleCustomizer() {
       //如果哪个模块要配置部门和用户权限，请如下新增
        return rule -> {
            rule.addUserColumn(NoticeDO.class, "creator");
        };
    }
}
