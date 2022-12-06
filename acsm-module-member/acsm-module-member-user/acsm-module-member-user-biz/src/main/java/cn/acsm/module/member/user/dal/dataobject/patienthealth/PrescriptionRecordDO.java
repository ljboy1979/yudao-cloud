package cn.acsm.module.member.user.dal.dataobject.patienthealth;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 处方记录表 DO
 *
 * @author lihongyan
 */
@TableName("member_prescription_record")
@KeySequence("member_prescription_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionRecordDO extends TenantBaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 健康档案id
     */
    private Long patientHealthId;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 医院
     */
    private String hospital;
    /**
     * 科室
     */
    private String department;
    /**
     * 处方医生
     */
    private String doctor;
    /**
     * 下处方日期
     */
    private Date prescriptionDate;
    /**
     * 处方类别
     */
    private String prescriptionCategory;
    /**
     * 处方内容
     */
    private String prescriptionContent;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
