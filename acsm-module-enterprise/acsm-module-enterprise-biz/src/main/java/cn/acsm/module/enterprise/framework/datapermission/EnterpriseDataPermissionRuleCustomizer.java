//package cn.acsm.module.enterprise.framework.datapermission;
//
//import cn.iocoder.yudao.framework.datapermission.core.rule.dept.DeptDataPermissionRule;
//
///**
// * {@link DeptDataPermissionRule} 的自定义配置接口
// *
// * @author 芋道源码
// */
//@FunctionalInterface
//public interface EnterpriseDataPermissionRuleCustomizer {
//
//    /**
//     * 自定义该权限规则
//     * 1. 调用 {@link DeptDataPermissionRule#addDeptColumn(Class, String)} 方法，配置基于 dept_id 的过滤规则
//     * 2. 调用 {@link DeptDataPermissionRule#addUserColumn(Class, String)} 方法，配置基于 user_id 的过滤规则
//     *
//     * @param rule 权限规则
//     */
//    void customize(EnterpriseDataPermissionRule rule);
//
//}
