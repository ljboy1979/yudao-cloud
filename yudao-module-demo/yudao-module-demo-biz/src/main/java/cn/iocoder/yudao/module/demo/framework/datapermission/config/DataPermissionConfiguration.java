package cn.iocoder.yudao.module.demo.framework.datapermission.config;

import cn.iocoder.yudao.framework.datapermission.core.rule.dept.DeptDataPermissionRule;
import cn.iocoder.yudao.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import cn.iocoder.yudao.framework.security.core.LoginUser;
import cn.iocoder.yudao.module.demo.dal.dataobject.notice.NoticeDO;
import cn.iocoder.yudao.module.system.api.permission.PermissionApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 基于部门的数据权限 AutoConfiguration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
//@ConditionalOnClass(LoginUser.class)
@ConditionalOnClass(value = {LoginUser.class, PermissionApi.class, DeptDataPermissionRuleCustomizer.class})
public class DataPermissionConfiguration {

    @Bean
    public DeptDataPermissionRule deptDataPermissionRule(PermissionApi permissionApi,
                                                         List<DeptDataPermissionRuleCustomizer> customizers) {
        // 创建 DeptDataPermissionRule 对象
        DeptDataPermissionRule rule = new DeptDataPermissionRule(permissionApi);
        // 补全表配置
        customizers.forEach(customizer -> customizer.customize(rule));
        return rule;
    }
    @Bean
    public DeptDataPermissionRuleCustomizer demoDeptDataPermissionRuleCustomizer() {
       //如果哪个模块要配置部门和用户权限，请如下新增
        return rule -> {
            rule.addUserColumn(NoticeDO.class, "creator");
        };
    }
}
