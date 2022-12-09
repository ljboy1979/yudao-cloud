package cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

/**
* 认养/租凭价格 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AdoptContentAdoptPriceBaseVO {

    @ApiModelProperty(value = "认养物的id")
    private String adoptId;

    @ApiModelProperty(value = "认养物的名称")
    private String adoptName;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "认养费用")
    private BigDecimal adoptPriceFee;

    @ApiModelProperty(value = "费用类型")
    private String feeType;

    @ApiModelProperty(value = "认养人标签")
    private String adoptPersonFlag;

    @ApiModelProperty(value = "权益价格的id")
    private String adoptRightId;

    @ApiModelProperty(value = "付款人数")
    private String payNum;

    @ApiModelProperty(value = "认养总数")
    private String adoptTotal;

    @ApiModelProperty(value = "认养剩余名额")
    private String adoptQuota;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;


}
