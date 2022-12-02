package cn.acsm.module.transaction.sales.dal.dataobject.salespackage;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 套餐 DO
 *
 * @author 芋道源码
 */
@TableName("sales_package")
@KeySequence("sales_package_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 套餐名称
     */
    private String name;
    /**
     * 套餐价格
     */
    private BigDecimal price;
    /**
     * meals_time
     */
    private String mealsTime;
    /**
     * 热量
     */
    private String calories;
    /**
     * 关联医嘱字典
     */
    private String medicalAdvice;
    /**
     * 套餐方案(字典)
     */
    private String mealsPlan;
    /**
     * 套餐规格
     */
    private String mealsSpecs;
    /**
     * 开放日期
     */
    private String availableDate;
    /**
     * 套餐图片
     */
    private String imgs;
    /**
     * 能量
     */
    private String energy;
    /**
     * 蛋白质
     */
    private String protein;
    /**
     * 专家建议
     */
    private String expertAdvice;
    /**
     * 脂肪
     */
    private String fat;
    /**
     * 碳水化合物
     */
    private String carbohydrate;
    /**
     * 套餐编号
     */
    private String mealNumber;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改着
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 供应商id
     */
    private String providerId;
    /**
     * 关联营养信息表
     */
    private String nutritionId;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 钠
     */
    private String sodium;
    /**
     * 钾
     */
    private String potassium;
    /**
     * 磷
     */
    private String phosphorus;
    /**
     * 来源
     */
    private String source;
    /**
     * 库存数量（上架）
     */
    private String num;
    /**
     * 0下架 1上架
     */
    private String auditStatus;
    /**
     * 库存数量(剩余)
     */
    private String inventoryNum;
    /**
     * 剩余数量
     */
    private String remnantNum;
    /**
     * 来源套餐id
     */
    private String originPackageId;
    /**
     * 套餐类型
     */
    private String skupageTag;
    /**
     * 套餐类型名称
     */
    private String skupageTagName;
    /**
     * 套餐说明
     */
    private String skupageExplain;
    /**
     * 库存锁
     */
    private Integer version;
    /**
     * 序列号
     */
    private String sort;
    /**
     * 小程序套餐分类id一级 关联os_commodity_category_mini
     */
    private String miniClassificationIdOne;
    /**
     * 小程序套餐分类id二级 关联os_commodity_category_mini
     */
    private String miniClassificationIdTwo;
    /**
     * 套餐商品构成
     */
    private String commodityName;
    /**
     * 套餐视频
     */
    private String video;
    /**
     * 处理规格 字典Process_specifications 可存多个
     */
    private String processTag;
    /**
     * 物流费
     */
    private Double logisticsFees;
    /**
     * 捕捞商品id
     */
    private String osCommodityFishingId;
    /**
     * 捕捞规格id
     */
    private String productSpecificationsFishingId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 经营主体id
     */
    private String subjectId;

}
