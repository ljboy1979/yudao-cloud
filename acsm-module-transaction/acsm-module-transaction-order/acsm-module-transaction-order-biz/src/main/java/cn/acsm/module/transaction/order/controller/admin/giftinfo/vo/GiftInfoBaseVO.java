package cn.acsm.module.transaction.order.controller.admin.giftinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 赠品 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class GiftInfoBaseVO {

    @ApiModelProperty(value = "赠品编号")
    private String giftNumber;

    @ApiModelProperty(value = "货品id")
    private String goodsId;

    @ApiModelProperty(value = "赠品名称(套餐id)")
    private String giftName;

    @ApiModelProperty(value = "数量")
    private String giftAmount;

    @ApiModelProperty(value = "订单id")
    private String skuPackageOrderId;

    @ApiModelProperty(value = "分类id")
    private String classifyId;

    @ApiModelProperty(value = "分类名称")
    private String classifyName;

    @ApiModelProperty(value = "计量单位")
    private String unit;

    @ApiModelProperty(value = "计量单位名称")
    private String unitName;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
