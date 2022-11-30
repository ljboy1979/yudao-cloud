package cn.acsm.module.member.user.dal.dataobject.patienthealth;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 医嘱记录 DO
 *
 * @author lihongyan
 */
@TableName("member_medical_record")
@KeySequence("member_medical_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordDO extends BaseDO {

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
     * 医院
     */
    private String hospital;
    /**
     * 科室
     */
    private String department;
    /**
     * 医生名称
     */
    private String doctor;
    /**
     * 下医嘱日期
     */
    private Date medicalDate;
    /**
     * 医嘱类别
     */
    private String medicalCategory;
    /**
     * 医嘱内容
     */
    private String medicalContent;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
