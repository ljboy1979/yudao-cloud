package cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 商品分类 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CommodityCategoryBaseVO {

    @ApiModelProperty(value = "商品分类名称", required = true)
    @NotNull(message = "商品分类名称不能为空")
    private String commodityCategoryName;

    @ApiModelProperty(value = "父级编号", required = true)
    @NotNull(message = "父级编号不能为空")
    private String parentCode;

    @ApiModelProperty(value = "所有父级编号", required = true)
    @NotNull(message = "所有父级编号不能为空")
    private String parentCodes;

    @ApiModelProperty(value = "本级排序号（升序）", required = true)
    @NotNull(message = "本级排序号（升序）不能为空")
    private BigDecimal treeSort;

    @ApiModelProperty(value = "所有级别排序号", required = true)
    @NotNull(message = "所有级别排序号不能为空")
    private String treeSorts;

    @ApiModelProperty(value = "是否最末级", required = true)
    @NotNull(message = "是否最末级不能为空")
    private String treeLeaf;

    @ApiModelProperty(value = "层次级别", required = true)
    @NotNull(message = "层次级别不能为空")
    private BigDecimal treeLevel;

    @ApiModelProperty(value = "全节点名", required = true)
    @NotNull(message = "全节点名不能为空")
    private String treeNames;

    @ApiModelProperty(value = "0 渠道商商品 1农资商城商品 多个使用逗号隔开")
    private String type;

    @ApiModelProperty(value = "0单条新增1批量新增")
    private String state;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;

    @ApiModelProperty(value = "排序序号")
    private String order;

    @ApiModelProperty(value = "商品类型，1为农资商场")
    private String commodityType;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remarks;
}
