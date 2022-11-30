package cn.acsm.module.member.user.dal.dataobject.patienthealth;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 住院记录 DO
 *
 * @author lihongyan
 */
@TableName("member_hospital_admission_record")
@KeySequence("member_hospital_admission_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalAdmissionRecordDO extends BaseDO {

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
     * 主治医生
     */
    private String doctor;
    /**
     * 住院日期
     */
    private Date hospitalizationDate;
    /**
     * 出院日期
     */
    private Date dischargeDate;
    /**
     * 住院类别
     */
    private String hospitalizationCategories;
    /**
     * 治疗内容
     */
    private String treatmentContent;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
