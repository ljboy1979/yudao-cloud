package cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
 * 健康档案 Excel VO
 *
 * @author lihongyan
 */
@Data
public class PatientHealthExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("会员id")
    private Long memberId;

    @ExcelProperty("会员id")
    private Long medicalAdviceId;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("性别")
    private Integer sex;

    @ExcelProperty("身高")
    private String height;

    @ExcelProperty("体重")
    private String weight;

    @ExcelProperty("住院号")
    private String inpatientNo;

    @ExcelProperty("收货点")
    private String receiptPoint;

    @ExcelProperty("疗区")
    private String treatmentArea;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("楼栋号")
    private String buildingNo;

    @ExcelProperty("楼层号")
    private String floorNo;

    @ExcelProperty("房间号")
    private String roomNo;

    @ExcelProperty("床位号")
    private String bedNo;

    @ExcelProperty("入院日期")
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private Date admissionDate;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
