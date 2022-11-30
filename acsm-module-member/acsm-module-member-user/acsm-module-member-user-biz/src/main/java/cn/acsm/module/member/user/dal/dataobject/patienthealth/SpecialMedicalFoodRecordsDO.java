package cn.acsm.module.member.user.dal.dataobject.patienthealth;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特医食品使用记录表 DO
 *
 * @author lihongyan
 */
@TableName("member_special_medical_food_records")
@KeySequence("member_special_medical_food_records_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialMedicalFoodRecordsDO extends BaseDO {

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
     * 营养师名称
     */
    private String doctor;
    /**
     * 使用时间
     */
    private Date specialMedicalDate;
    /**
     * 特医食品类别
     */
    private String specialMedicalCategory;
    /**
     * 特医食品内容
     */
    private String specialMedicalContent;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
