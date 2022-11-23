package cn.acsm.module.enterprise.dal.dataobject.baseinfo;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 经营主体 DO
 *
 * @author 芋道源码
 */
@TableName("enterprise_base_info")
@KeySequence("enterprise_base_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseInfoDO extends TenantBaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 主体编号
     */
    private String code;
    /**
     * 主体名称
     */
    private String name;
    /**
     * 主体类型
     *
     * 枚举 {@link TODO enterprise_type 对应的类}
     */
    private String enterpriseType;
    /**
     * 主体类型名称
     */
    private String enterpriseTypeName;
    /**
     * 状态
     */
    private String stauts;
    /**
     * 产业角色
     *
     * 枚举 {@link TODO user_tag 对应的类}
     */
    private String userTag;
    /**
     * 产业角色名称
     */
    private String userTagName;
    /**
     * 经营状态
     *
     * 枚举 {@link TODO manage_status 对应的类}
     */
    private String manageStatus;
    /**
     * 注册地址
     */
    private String address;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 统一社会信用代码或注册号
     */
    private String socialCreditCode;
    /**
     * 电子营业执照
     */
    private String businessCertificatePhoto;
    /**
     * 法定代表人
     */
    private String legalPerson;
    /**
     * 法人身份证
     */
    private String legalIdCard;
    /**
     * 法人身份证照片
     */
    private String legalIdCardPhoto;
    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * 公司简介
     */
    private String description;
    /**
     * 企业LOGO
     */
    private String logo;
    /**
     * 经营许可证号
     */
    private String businessLicenseNo;
    /**
     * 生产/经营许可证图片
     */
    private String businessLicensePhoto;
    /**
     * 证件截止日期
     */
    private Date businessLicenseEndTime;
    /**
     * 账户名
     */
    private String accountName;
    /**
     * 账户银行卡号
     */
    private String accountNo;
    /**
     * 账户身份证号
     */
    private String accountIdCard;
    /**
     * 账户开户行
     */
    private String accountBank;
    /**
     * 联系人
     */
    private String contactName;
    /**
     * 联系人电话
     */
    private String contactPhone;
    /**
     * 省id
     */
    private String villagesAreaId;
    /**
     * 省名称
     */
    private String villagesAreaName;
    /**
     * 市id
     */
    private String areaId;
    /**
     * 市名称
     */
    private String areaName;
    /**
     * 区id
     */
    private String ruralId;
    /**
     * 区名称
     */
    private String ruralName;
    /**
     * 企业规模
     */
    private String enterpriseScale;
    /**
     * 主营业务
     */
    private String serviceRange;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
