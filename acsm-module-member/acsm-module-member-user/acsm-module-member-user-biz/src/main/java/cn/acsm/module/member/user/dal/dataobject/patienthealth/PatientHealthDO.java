package cn.acsm.module.member.user.dal.dataobject.patienthealth;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 健康档案 DO
 *
 * @author lihongyan
 */
@TableName("member_patient_health")
@KeySequence("member_patient_health_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientHealthDO extends TenantBaseDO {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 医嘱id
     */
    private Long medicalAdviceId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 身高
     */
    private String height;
    /**
     * 体重
     */
    private String weight;
    /**
     * 住院号
     */
    private String inpatientNo;
    /**
     * 收货点
     */
    private String receiptPoint;
    /**
     * 疗区
     */
    private String treatmentArea;
    /**
     * 科室
     */
    private String department;
    /**
     * 楼栋号
     */
    private String buildingNo;
    /**
     * 楼层号
     */
    private String floorNo;
    /**
     * 房间号
     */
    private String roomNo;
    /**
     * 床位号
     */
    private String bedNo;
    /**
     * 入院日期
     */
    private Date admissionDate;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
