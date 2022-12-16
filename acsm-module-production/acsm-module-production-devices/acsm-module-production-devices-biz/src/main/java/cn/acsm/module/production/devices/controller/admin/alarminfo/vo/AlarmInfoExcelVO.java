package cn.acsm.module.production.devices.controller.admin.alarminfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 告警信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class AlarmInfoExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("编号")
    private Integer number;

    @ExcelProperty("告警类型")
    private String alarmType;

    @ExcelProperty("告警来源")
    private String alarmSource;

    @ExcelProperty("告警内容")
    private String alarmContent;

    @ExcelProperty("发生时间")
    private Date happenDate;

    @ExcelProperty("发生地点")
    private String happenPlace;

    @ExcelProperty("通知人(多个逗号隔开)")
    private String notifiers;

    @ExcelProperty("处理状态(0-待处理 1-已处理)")
    private String handleStatus;

    @ExcelProperty("处理描述")
    private String handleContent;

    @ExcelProperty("机构编码")
    private String officeCode;

    @ExcelProperty("机构名称")
    private String officeName;

    @ExcelProperty("公司编码")
    private String companyCode;

    @ExcelProperty("公司名称")
    private String companyName;

    @ExcelProperty("审核状态")
    private String reviewStatus;

    @ExcelProperty("审核人")
    private String reviewer;

    @ExcelProperty("审核时间")
    private Date reviewDate;

    @ExcelProperty("审核内容")
    private String reviewContent;

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("设备id")
    private String devicesId;

    @ExcelProperty("设备名称")
    private String deviceName;

    @ExcelProperty("设备编号")
    private String deviceSn;

    @ExcelProperty("养殖户名称")
    private String subjectName;

    @ExcelProperty("静默小时")
    private Integer silenceHour;

    @ExcelProperty("静默截止期")
    private Date silenceExpiry;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
