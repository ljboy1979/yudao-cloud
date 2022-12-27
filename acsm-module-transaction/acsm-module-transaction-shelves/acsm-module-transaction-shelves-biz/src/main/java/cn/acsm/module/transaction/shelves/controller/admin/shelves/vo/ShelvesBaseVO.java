package cn.acsm.module.transaction.shelves.controller.admin.shelves.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 货架 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ShelvesBaseVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "分类id")
    private String classifyId;

    @ApiModelProperty(value = "来源id")
    private String sourceId;

    @ApiModelProperty(value = "货架编号")
    private String number;

    @ApiModelProperty(value = "售品类型 0原料、1投入品、2商品、3菜品、4套餐 5特医食品")
    private Integer type;

    @ApiModelProperty(value = "上架数量")
    private BigDecimal addNum;

    @ApiModelProperty(value = "可销售量")
    private BigDecimal availableNum;

    @ApiModelProperty(value = "销量")
    private BigDecimal salesNum;

    @ApiModelProperty(value = "计量单位")
    private String measurementUnit;

    @ApiModelProperty(value = "计量单位名称")
    private String measurementUnitName;

    @ApiModelProperty(value = "是否上架 0下架 1上架 2禁售")
    private String saleState;

    @ApiModelProperty(value = "供应日期")
    private Date supplyDate;

    @ApiModelProperty(value = "供应结束日期")
    private Date supplyEndDate;

    @ApiModelProperty(value = "供应类型 0 日期 1 长期")
    private Integer supplyType;

    @ApiModelProperty(value = "餐次 0早/1中/2晚")
    private Integer meals;

    @ApiModelProperty(value = "售品图片")
    private String imgUrl;

    @ApiModelProperty(value = "售品视频")
    private String videoUrl;

    @ApiModelProperty(value = "售品说明")
    private String salesExplain;

    @ApiModelProperty(value = "标签")
    private String label;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "供应商")
    private String vendor;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
