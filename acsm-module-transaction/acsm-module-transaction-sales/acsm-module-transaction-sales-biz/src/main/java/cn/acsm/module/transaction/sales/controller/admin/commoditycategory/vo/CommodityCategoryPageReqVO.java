package cn.acsm.module.transaction.sales.controller.admin.commoditycategory.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 商品分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommodityCategoryPageReqVO extends PageParam {

    @ApiModelProperty(value = "商品分类名称")
    private String commodityCategoryName;

    @ApiModelProperty(value = "父级编号")
    private String parentCode;

    @ApiModelProperty(value = "所有父级编号")
    private String parentCodes;

    @ApiModelProperty(value = "本级排序号（升序）")
    private BigDecimal treeSort;

    @ApiModelProperty(value = "所有级别排序号")
    private String treeSorts;

    @ApiModelProperty(value = "是否最末级")
    private String treeLeaf;

    @ApiModelProperty(value = "层次级别")
    private BigDecimal treeLevel;

    @ApiModelProperty(value = "全节点名")
    private String treeNames;

    @ApiModelProperty(value = "0 渠道商商品 1农资商城商品 多个使用逗号隔开")
    private String type;

    @ApiModelProperty(value = "0单条新增1批量新增")
    private String state;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;

    @ApiModelProperty(value = "排序序号")
    private String sort;

    @ApiModelProperty(value = "商品类型，1为农资商场")
    private String commodityType;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
