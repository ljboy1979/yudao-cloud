package cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 健康档案分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PatientHealthPageReqVO extends PageParam {

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "医嘱id")
    private Long medicalAdviceId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "身高")
    private String height;

    @ApiModelProperty(value = "体重")
    private String weight;

    @ApiModelProperty(value = "住院号")
    private String inpatientNo;

    @ApiModelProperty(value = "收货点")
    private String receiptPoint;

    @ApiModelProperty(value = "疗区")
    private String treatmentArea;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "楼栋号")
    private String buildingNo;

    @ApiModelProperty(value = "楼层号")
    private String floorNo;

    @ApiModelProperty(value = "房间号")
    private String roomNo;

    @ApiModelProperty(value = "床位号")
    private String bedNo;

    @ApiModelProperty(value = "入院日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] admissionDate;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
