package cn.acsm.module.transaction.sales.controller.admin.salespackage.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 套餐 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PackageBaseVO {

    @ApiModelProperty(value = "套餐名称", required = true)
    @NotNull(message = "套餐名称不能为空")
    private String name;

    @ApiModelProperty(value = "套餐价格")
    private BigDecimal price;

    @ApiModelProperty(value = "meals_time")
    private String mealsTime;

    @ApiModelProperty(value = "热量")
    private String calories;

    @ApiModelProperty(value = "关联医嘱字典")
    private String medicalAdvice;

    @ApiModelProperty(value = "套餐方案(字典)")
    private String mealsPlan;

    @ApiModelProperty(value = "套餐规格")
    private String mealsSpecs;

    @ApiModelProperty(value = "开放日期")
    private String availableDate;

    @ApiModelProperty(value = "套餐图片")
    private String imgs;

    @ApiModelProperty(value = "能量")
    private String energy;

    @ApiModelProperty(value = "蛋白质")
    private String protein;

    @ApiModelProperty(value = "专家建议")
    private String expertAdvice;

    @ApiModelProperty(value = "脂肪")
    private String fat;

    @ApiModelProperty(value = "碳水化合物")
    private String carbohydrate;

    @ApiModelProperty(value = "套餐编号")
    private String mealNumber;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改着")
    private String updateBy;

    @ApiModelProperty(value = "修改时间")
    private Date updateDate;

    @ApiModelProperty(value = "供应商id")
    private String providerId;

    @ApiModelProperty(value = "关联营养信息表")
    private String nutritionId;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "钠")
    private String sodium;

    @ApiModelProperty(value = "钾")
    private String potassium;

    @ApiModelProperty(value = "磷")
    private String phosphorus;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "库存数量（上架）")
    private String num;

    @ApiModelProperty(value = "0下架 1上架")
    private String auditStatus;

    @ApiModelProperty(value = "库存数量(剩余)")
    private String inventoryNum;

    @ApiModelProperty(value = "剩余数量")
    private String remnantNum;

    @ApiModelProperty(value = "来源套餐id")
    private String originPackageId;

    @ApiModelProperty(value = "套餐类型")
    private String skupageTag;

    @ApiModelProperty(value = "套餐类型名称")
    private String skupageTagName;

    @ApiModelProperty(value = "套餐说明")
    private String skupageExplain;

    @ApiModelProperty(value = "库存锁")
    private Integer version;

    @ApiModelProperty(value = "序列号")
    private String sort;

    @ApiModelProperty(value = "小程序套餐分类id一级 关联os_commodity_category_mini")
    @NotNull(message = "套餐分类不能为空")
    private String miniClassificationIdOne;

    @ApiModelProperty(value = "小程序套餐分类id二级 关联os_commodity_category_mini")
    private String miniClassificationIdTwo;

    @ApiModelProperty(value = "套餐商品构成")
    private String commodityName;

    @ApiModelProperty(value = "套餐视频")
    private String video;

    @ApiModelProperty(value = "处理规格 字典Process_specifications 可存多个")
    private String processTag;

    @ApiModelProperty(value = "物流费")
    private Double logisticsFees;

    @ApiModelProperty(value = "捕捞商品id")
    private String osCommodityFishingId;

    @ApiModelProperty(value = "捕捞规格id")
    private String productSpecificationsFishingId;

    @ApiModelProperty(value = "状态", required = true)
    //@NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
