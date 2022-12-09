package cn.acsm.module.service.controller.admin.activitysession.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 时间排期 Excel VO
 *
 * @author smile
 */
@Data
public class ActivitySessionExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("最多参与人数")
    private String maxAttendPeople;

    @ExcelProperty("实际参与人数")
    private String attendPeople;

    @ExcelProperty("活动报名费用")
    private String registrationFee;

    @ExcelProperty("活动id")
    private String activityId;

    @ExcelProperty("开始时间")
    private String startTime;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("服务id")
    private String serviceId;

    @ExcelProperty("开始日期")
    private String startDate;

    @ExcelProperty("结束日期")
    private Date endDate;

    @ExcelProperty("结束时间")
    private String endTime;

    @ExcelProperty("基地id")
    private String basesId;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

}
