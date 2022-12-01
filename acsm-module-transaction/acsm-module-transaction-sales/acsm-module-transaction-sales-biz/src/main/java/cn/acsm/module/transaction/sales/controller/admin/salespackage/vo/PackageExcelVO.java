package cn.acsm.module.transaction.sales.controller.admin.salespackage.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 套餐 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PackageExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("套餐名称")
    private String name;

    @ExcelProperty("套餐价格")
    private BigDecimal price;

    @ExcelProperty("meals_time")
    private String mealsTime;

    @ExcelProperty("热量")
    private String calories;

    @ExcelProperty("关联医嘱字典")
    private String medicalAdvice;

    @ExcelProperty("套餐方案(字典)")
    private String mealsPlan;

    @ExcelProperty("套餐规格")
    private String mealsSpecs;

    @ExcelProperty("开放日期")
    private String availableDate;

    @ExcelProperty("套餐图片")
    private String imgs;

    @ExcelProperty("能量")
    private String energy;

    @ExcelProperty("蛋白质")
    private String protein;

    @ExcelProperty("专家建议")
    private String expertAdvice;

    @ExcelProperty("脂肪")
    private String fat;

    @ExcelProperty("碳水化合物")
    private String carbohydrate;

    @ExcelProperty("套餐编号")
    private String mealNumber;

    @ExcelProperty("创建者")
    private String createBy;

    @ExcelProperty("创建时间")
    private Date createDate;

    @ExcelProperty("修改着")
    private String updateBy;

    @ExcelProperty("修改时间")
    private Date updateDate;

    @ExcelProperty("供应商id")
    private String providerId;

    @ExcelProperty("关联营养信息表")
    private String nutritionId;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("钠")
    private String sodium;

    @ExcelProperty("钾")
    private String potassium;

    @ExcelProperty("磷")
    private String phosphorus;

    @ExcelProperty("来源")
    private String source;

    @ExcelProperty("库存数量（上架）")
    private String num;

    @ExcelProperty("0下架 1上架")
    private String auditStatus;

    @ExcelProperty("库存数量(剩余)")
    private String inventoryNum;

    @ExcelProperty("剩余数量")
    private String remnantNum;

    @ExcelProperty("来源套餐id")
    private String originPackageId;

    @ExcelProperty("套餐类型")
    private String skupageTag;

    @ExcelProperty("套餐类型名称")
    private String skupageTagName;

    @ExcelProperty("套餐说明")
    private String skupageExplain;

    @ExcelProperty("库存锁")
    private Integer version;

    @ExcelProperty("序列号")
    private String sort;

    @ExcelProperty("小程序套餐分类id一级 关联os_commodity_category_mini")
    private String miniClassificationIdOne;

    @ExcelProperty("小程序套餐分类id二级 关联os_commodity_category_mini")
    private String miniClassificationIdTwo;

    @ExcelProperty("套餐商品构成")
    private String commodityName;

    @ExcelProperty("套餐视频")
    private String video;

    @ExcelProperty("处理规格 字典Process_specifications 可存多个")
    private String processTag;

    @ExcelProperty("物流费")
    private Double logisticsFees;

    @ExcelProperty("捕捞商品id")
    private String osCommodityFishingId;

    @ExcelProperty("捕捞规格id")
    private String productSpecificationsFishingId;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
