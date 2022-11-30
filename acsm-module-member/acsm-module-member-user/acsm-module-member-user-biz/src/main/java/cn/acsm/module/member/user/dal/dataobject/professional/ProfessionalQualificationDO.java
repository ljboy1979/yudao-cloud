package cn.acsm.module.member.user.dal.dataobject.professional;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 专业资质 DO
 *
 * @author lihongyan
 */
@TableName("member_professional_qualification")
@KeySequence("member_professional_qualification_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalQualificationDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 备案类型
     */
    private String recordType;
    /**
     * 备案名称
     */
    private String recordName;
    /**
     * 许可证号码
     */
    private String permitNo;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 备案日期
     */
    private String recordDate;
    /**
     * 证照
     */
    private String idPhoto;
    /**
     * 审核状态
     */
    private Integer auditStatus;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
