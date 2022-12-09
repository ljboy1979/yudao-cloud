package cn.acsm.module.service.controller.admin.ticketdetail.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 套票详情 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TicketDetailBaseVO {

    @ApiModelProperty(value = "套票id")
    private String ticketId;

    @ApiModelProperty(value = "商品id")
    private String skuId;

    @ApiModelProperty(value = "每次兑换数量")
    private Integer useNumber;

    @ApiModelProperty(value = "兑换频次 0 年 1月 ")
    private Integer useRate;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
