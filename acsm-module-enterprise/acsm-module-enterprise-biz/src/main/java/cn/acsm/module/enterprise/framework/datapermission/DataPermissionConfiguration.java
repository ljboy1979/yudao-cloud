package cn.acsm.module.enterprise.framework.datapermission;

import cn.acsm.module.enterprise.dal.dataobject.baseinfo.BaseInfoDO;
import cn.iocoder.yudao.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * system 模块的数据权限 Configuration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class DataPermissionConfiguration {

    @Bean
    public DeptDataPermissionRuleCustomizer sysDeptDataPermissionRuleCustomizer() {
        return rule -> {
            // user
            rule.addUserColumn(BaseInfoDO.class, "creator");
        };
    }

}
