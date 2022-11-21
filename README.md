以 [ruoyi-vue-pro](https://github.com/YunaiV/ruoyi-vue-pro) 为基础，实现的 Spring Cloud Alibaba 微服务架构。开发微服务时以下3个微服务必须包括进去：

* [x] `gateway` 网关服务，需要新增你开发的微服务的路由
* [x] `system` 系统服务，一般无需修改
* [x] `infra` 基础设施，一般无需修改

启动文档，可见 <https://cloud.iocoder.cn/quick-start/> 地址。

程序可以直接启动，无需任何配置（已将必要的中间件配置在云端，如果嫌云端速度慢，可自行在本地安装必要的中间件）
-----更新：
由于公网nacos的注册中心，会导致实例冲突，必须在本地安装nacos
1下载nacos
2至/conf目录下配置nacos的mysql连接
3至/bin目录下打开startup.cmd，搜索cluster改成standalone
4启动nacos，进入nacos，账号密码nacos/nacos，在命名空间新建dev空间，注意id必须填写dev不能自动生成

----

* 学习教程见项目learning目录

  ##以下是快速学习教程，文末有云端配置的一些系统和端口账号密码。

* 1、快速启动项目，环境配置：

  见yudao-cloud启动

  依赖的引入规范：先在yudao-dependencies下pom.xml里的properties加入版本号，然后在同一文件的

  dependencymanagement下加入包，然后在新的module下引入依赖，不需要加version了

  2、新建一个模块xxx

  命名方式：

  acsm-module-xxx

  在项目最下面的pom.xml里新增一条

  <module>acsm-module-xxx</module>

  等到出现黄色的更正建议时，选择建立带父类的module

  依次类推在

  新的module下新建

  acsm-module-xxx-api

  acsm-module-xxx-biz

  两个模块

  api模块是内部调用的

  biz模块是前端调用的

  目前支持两种调用方式：

  openfeign/dubbo，我们采用openfeign

  以bpm为例

  消费方（调用方）：

  1在framework-rpc包下配置openfeign

  @Configuration(proxyBeanMethods = false) //表示对openfeign的实现类方法不用代理拦截
  @EnableFeignClients(clients = {RoleApi.class, DeptApi.class, PostApi.class, AdminUserApi.class, SmsSendApi.class, DictDataApi.class})//声明需要openfeign代理拦截的rpc类
  
  2然后在相应的调用处用@Resource注入服务方
  
* 服务方（被调用方）：

  1一个是在rpc包下用@FeignClient声明需要被内部调用的接口，
* 2方法上要加入调用链接

  

  （dubbo方式了解即可，不采用

  主要看两个注解

  一个是@DubboService，服务方

  一个是@DubboReference(version = "1.0.0", retries = 0)，消费方）

  \--------------------------

  3、代码生成功能：

  http://cloud.iocoder.cn/new-feature/

  需要启动前端，yudao-admin-ui，见学习教程

  4、权限验证

  Token 存储在数据库中，对应system_oauth2_access_token 访问令牌表的id 字段。考虑到访问的性能，缓存在 Redis 的 oauth2_access_token:%s 键中。

  默认配置下，管理后台的 

  /admin-api/** 所有 API 接口都**必须**登录后才允许访问，

  用户 App 的 /app-api/** 所有 API 接口**无需**登录就可以访问。

  token拦截

  public class TokenAuthenticationFilter extends OncePerRequestFilter

  管理端登录

  public class AuthController

  app端登录，分开的

  public class AppAuthController

  前端调用其它接口，需要在请求头带上 Token 进行访问。请求头格式如下： 

  \### Authorization: Bearer 登录时返回的

  Token Authorization: Bearer d2a3cdbc6c53470db67a582bd115103f

  前端调试用以下方法跳过认证

  考虑到使用 Postman、Swagger 调试接口方便，提供了 **Token 的模拟机制**。请求头格式如下：

  \### Authorization: Bearer test用户编号 Authorization: Bearer test1

  其中 "test" 可自定义，配置项如下：

  \### application-local.yaml yudao:  security:    mock-enable: true # 是否开启 Token 的模拟机制    mock-secret: test # Token 模拟机制的 Token 前缀

  权限控制：

  ① 基于【权限标识】的权限控制

  system_menu表的 permission 字段

  // 符合 system:user:list 权限要求 @PreAuthorize("@ss.hasPermission('system:user:list')") // 符合 system:user:add 或 system:user:edit 权限要求即可 @PreAuthorize("@ss.hasAnyPermissions('system:user:add,system:user:edit')")

  ②基于【角色标识】的权限控制

  权限标识，对应 system_role 表的 code 字段

  // 属于 user 角色 @PreAuthorize("@ss.hasRole('user')") // 属于 user 或者 admin 之一 @PreAuthorize("@ss.hasAnyRoles('user,admin')")

  ss 对应的 Bean 是

   public class PermissionServiceImpl implements PermissionService

  强制认证

  @PreAuthenticated 注解

  public class PreAuthenticatedAspect

  自定义权限

  1自定义 AuthorizeRequestsCustomizer 实现

  2、@PermitAll 注解

  3、yudao.security.permit-all-urls 配置项

  yudao:  security:    permit-all-urls:      - /admin-ui/** # /resources/admin-ui 目录下的静态资源      - /admin-api/xxx/yyy

  \------------------------------------------

  数据权限：

  在yudao-framework下面：

  yudao-spring-boot-starter-biz-data-permission

  实现类

  public class DataPermissionAnnotationInterceptor implements MethodInterceptor

  内置了基于部门的数据权限

  可通过管理后台的 [系统管理 -> 角色管理] 菜单，设置用户角色的数据权限

  参考方法：

  public DeptDataPermissionRuleCustomizer sysDeptDataPermissionRuleCustomizer()

  字段配置：存疑

  每个 Maven Module， 通过自定义 DeptDataPermissionRuleCustomizer Bean，配置哪些表的哪些字段，进行数据权限的过滤。

  @DataPermission 注解

  [@DataPermission ](https://github.com/YunaiV/ruoyi-vue-pro/blob/master/yudao-framework/yudao-spring-boot-starter-biz-data-permission/src/main/java/cn/iocoder/yudao/framework/datapermission/core/annotation/DataPermission.java)数据权限注解，可声明在类或者方法上，配置使用的数据权限规则。

  **也就是说，数据权限默认是开启的，无需添加** **@DataPermission** **注解**

  自定义的数据权限规则

  如果想要自定义数据权限规则，只需要实现 DataPermissionRule数据权限规则接口，并声明成 Spring Bean 即可。

  \---------------------------

  用户体系

  1.表结构

  2 种用户类型，采用不同数据库的表进行存储，管理员用户对应 system_users表，会员用户对应 member_user 表。

  3. 如何获取当前登录的用户？

  使用 [SecurityFrameworkUtils](https://github.com/YunaiV/ruoyi-vue-pro/blob/master/yudao-framework/yudao-spring-boot-starter-security/src/main/java/cn/iocoder/yudao/framework/security/core/util/SecurityFrameworkUtils.java)提供的如下方法，可以获得当前登录用户的信息

  4. 所有登录都由

   [AuthController](https://github.com/YunaiV/ruoyi-vue-pro/blob/master/yudao-module-system/yudao-module-system-biz/src/main/java/cn/iocoder/yudao/module/system/controller/admin/auth/AuthController.java#L55-L62)提供接口

  \-------------------------------

  多租户

  前端的每个请求 Header **必须**带上 tenant-id

  通过 yudao.tenant.ignore-urls 配置项，可以设置哪些 URL 无需带该请求头。

  主要是校验登录的用户，校验是否有权限访问该租户，避免越权问题

  public class TenantSecurityWebFilter extends ApiRequestFilter

  **需要**开启多租户的表，必须添加tenant_id 字段，开多租户的表要继承 TenantBaseDO类。

  **无需**开启多租户的表，需要添加表名到 yudao.tenant.ignore-tables 配置项目application.yaml

  ① 声明 @TenantIgnore注解在方法上，标记指定方法不进行租户的自动过滤，避免**自动**拼接 WHERE tenant_id = ? 条件

  ② 使用 TenantUtils的 #execute(Long tenantId, Runnable runnable) 方法，模拟指定租户( tenantId )，执行某段业务逻辑( runnable )。

  3 job：声明 @TenantJob注解在 Job 类上，实现**并行**遍历每个租户，执行定时任务的逻辑。

  4MQ：通过租户对 MQ 层面的封装，实现租户上下文，可以继续传递到 MQ 消费的逻辑中，避免丢失的问题。

  5Async通过使用阿里开源的 TransmittableThreadLocal组件，实现 Spring Async 执行异步逻辑时，租户上下文可以继续传递，避免丢失的问题。

  \-----------------------------------

  环境：

  \##rocketmq-console

  [http://123.56.19.224:29999/#](http://123.56.19.224:29999/#/topic)

  \##rocketmq namesrv

  [http://123.56.19.224](http://123.56.19.224:29999/#/topic):19876

  \##nacos console

  http://123.56.19.224:18848/nacos

  nacos/uodn&110

  \##redis

  [http://123.56.19.224](http://123.56.19.224:29999/#/topic):16379

  auth uodn&110

  \##xxl-job

  [http://123.56.19.224](http://123.56.19.224:29999/#/topic):19090

  \##spring-admin

  [http://123.56.19.224](http://123.56.19.224:29999/#/topic):48081

  [http://123.56.19.224](http://123.56.19.224:29999/#/topic):48082

  [http://123.56.19.224](http://123.56.19.224:29999/#/topic):48083
需要新建demo数据库，表文件在sql目录下的demo.sql
