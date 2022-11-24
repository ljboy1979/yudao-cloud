package cn.acsm.module.enterprise.dal.dataobject.othercertificateinfo;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 经营主体其他证件 DO
 *
 * @author 芋道源码
 */
@TableName("enterprise_other_certificate_info")
@KeySequence("enterprise_other_certificate_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OtherCertificateInfoDO extends TenantBaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 经营主体ID
     */
    private Long enterpriseId;
    /**
     * 证件类型
     *
     * 枚举 {@link TODO certificate_type 对应的类}
     */
    private Integer certificateType;
    /**
     * 证件名称
     */
    private String certificateName;
    /**
     * 证件号
     */
    private String certificateNo;
    /**
     * 证件截止日期
     */
    private Date certificateEndTime;
    /**
     * 证件照片
     */
    private String certificatePhoto;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
