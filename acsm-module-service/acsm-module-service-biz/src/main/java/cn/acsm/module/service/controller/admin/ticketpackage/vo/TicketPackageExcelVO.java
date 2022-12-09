package cn.acsm.module.service.controller.admin.ticketpackage.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 套票 Excel VO
 *
 * @author smile
 */
@Data
public class TicketPackageExcelVO {

    @ExcelProperty("套票编号")
    private Long id;

    @ExcelProperty("套票名称")
    private String packageName;

    @ExcelProperty("套票种类")
    private String packageType;

    @ExcelProperty("购买人")
    private String purchaser;

    @ExcelProperty("服务id")
    private String carrierId;

    @ExcelProperty("使用次数")
    private Integer number;

    @ExcelProperty("套票金额")
    private String packageMoney;

    @ExcelProperty("使用期限")
    private Date serviceLife;

    @ExcelProperty("授权人")
    private String certigier;

    @ExcelProperty("套票状态(未开通/正常使用/过期/使用完毕)")
    private String packageStatus;

    @ExcelProperty("备注")
    private String remarks;

    @ExcelProperty("封面")
    private String cover;

    @ExcelProperty("内容")
    private String content;

    @ExcelProperty("使用规则")
    private String regulation;

    @ExcelProperty(" 使用期限说明")
    private String serviceLifeType;

    @ExcelProperty("套票内容")
    private String packageContent;

    @ExcelProperty("套票规则")
    private String packageRule;

    @ExcelProperty("开始日期")
    private Date startDate;

    @ExcelProperty("结束日期")
    private Date endDate;

    @ExcelProperty("是否上架 0:已上架，1:未上架")
    private String ticketStatus;

    @ExcelProperty("使用年限周期")
    private String timeNum;

    @ExcelProperty("使用年限类型 0固定1不固定")
    private String timeType;

    @ExcelProperty("使用年限频次 0年1月")
    private String timeLimitMode;

    @ExcelProperty("套票场景0活动1商品")
    private String ticketType;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

}
