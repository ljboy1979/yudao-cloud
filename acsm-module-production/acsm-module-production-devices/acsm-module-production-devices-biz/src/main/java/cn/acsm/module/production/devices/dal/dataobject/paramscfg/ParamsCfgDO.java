package cn.acsm.module.production.devices.dal.dataobject.paramscfg;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 设备参数配置 DO
 *
 * @author 芋道源码
 */
@TableName("devices_params_cfg")
@KeySequence("devices_params_cfg_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParamsCfgDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 参数对应字段名
     */
    private String paramColumn;
    /**
     * 参数名称
     */
    private String paramName;
    /**
     * 参数单位
     */
    private String paramUnit;
    /**
     * 机构编码
     */
    private String officeCode;
    /**
     * 机构名称
     */
    private String officeName;
    /**
     * 公司编码
     */
    private String companyCode;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 审核状态
     */
    private String reviewStatus;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 审核时间
     */
    private Date reviewDate;
    /**
     * 审核内容
     */
    private String reviewContent;
    /**
     * 租户代码
     */
    private String corpCode;
    /**
     * 租户名称
     */
    private String corpName;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 参数配置id
     */
    private String cfgId;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
