package cn.acsm.module.service.dal.dataobject.customerlist;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 服务客户名单 DO
 *
 * @author smile
 */
@TableName("service_customer_list")
@KeySequence("service_customer_list_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 身份码
     */
    private String identityCode;
    /**
     * 参与者姓名
     */
    private String participantName;
    /**
     * 手机号码
     */
    private String cellphoneNumber;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 性别
     */
    private String gender;
    /**
     * 服务交易id
     */
    private String serviceOrderId;
    /**
     * 收款账户
     */
    private String payee;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;

}
