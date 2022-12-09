package cn.acsm.module.resource.controller.admin.adoptright.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 认养/租凭权益 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AdoptRightBaseVO {

    @ApiModelProperty(value = "权益类型")
    private String rightType;

    @ApiModelProperty(value = "权益描述")
    private String rightDescription;

    @ApiModelProperty(value = "认养时间")
    private Date adoptTime;

    @ApiModelProperty(value = "认养物编号")
    private String adoptContentNum;

    @ApiModelProperty(value = "收入项：收入金额：收入比例")
    private String incomeItemAmountScale;

    @ApiModelProperty(value = "收入有效日期")
    private Date incomeEffectiveDate;

    @ApiModelProperty(value = "租用人标签")
    private String leasePersonFlag;

    @ApiModelProperty(value = "权益价格的id")
    private String adoptRightId;

    @ApiModelProperty(value = "金额")
    private String price;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "认养权益List")
    private List<Map<String,String>>  incomeItemAmountScaleMapList;

}
