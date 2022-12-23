package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 特医食品组成 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SpecialMedicalFoodOrganizationBaseVO {

    @ApiModelProperty(value = "特医食品id")
    private String foodId;

    @ApiModelProperty(value = "组成编号")
    private String organizationNumber;

    @ApiModelProperty(value = "组成名称")
    private String organizationName;

    @ApiModelProperty(value = "产地")
    private String origin;

    @ApiModelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

    @ApiModelProperty(value = "备注", required = true)
    private String remarks;
}
