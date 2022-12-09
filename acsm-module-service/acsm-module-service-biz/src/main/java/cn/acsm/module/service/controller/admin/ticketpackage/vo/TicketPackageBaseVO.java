package cn.acsm.module.service.controller.admin.ticketpackage.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 套票 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TicketPackageBaseVO {

    @ApiModelProperty(value = "套票名称")
    private String packageName;

    @ApiModelProperty(value = "套票种类")
    private String packageType;

    @ApiModelProperty(value = "购买人")
    private String purchaser;

    @ApiModelProperty(value = "服务id")
    private String carrierId;

    @ApiModelProperty(value = "使用次数")
    private Integer number;

    @ApiModelProperty(value = "套票金额")
    private String packageMoney;

    @ApiModelProperty(value = "使用期限")
    private Date serviceLife;

    @ApiModelProperty(value = "授权人")
    private String certigier;

    @ApiModelProperty(value = "套票状态(未开通/正常使用/过期/使用完毕)")
    private String packageStatus;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "使用规则")
    private String regulation;

    @ApiModelProperty(value = " 使用期限说明")
    private String serviceLifeType;

    @ApiModelProperty(value = "套票内容")
    private String packageContent;

    @ApiModelProperty(value = "套票规则")
    private String packageRule;

    @ApiModelProperty(value = "开始日期")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "是否上架 0:已上架，1:未上架")
    private String ticketStatus;

    @ApiModelProperty(value = "使用年限周期")
    private String timeNum;

    @ApiModelProperty(value = "使用年限类型 0固定1不固定")
    private String timeType;

    @ApiModelProperty(value = "使用年限频次 0年1月")
    private String timeLimitMode;

    @ApiModelProperty(value = "套票场景0活动1商品")
    private String ticketType;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
