package cn.iocoder.yudao.module.system.framework.datapermission.config;

import cn.iocoder.yudao.module.system.dal.dataobject.dept.DeptDO;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.PostDO;
import cn.iocoder.yudao.module.system.dal.dataobject.notice.NoticeDO;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
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
            // dept
            rule.addDeptColumn(AdminUserDO.class);
            rule.addDeptColumn(DeptDO.class, "id");
            // user
            rule.addUserColumn(AdminUserDO.class, "id");

            // notice,如果哪个模块要配置部门和用户权限，请如下新增
            rule.addUserColumn(PostDO.class, "creator");
            rule.addUserColumn(NoticeDO.class, "creator");
        };
    }

}
