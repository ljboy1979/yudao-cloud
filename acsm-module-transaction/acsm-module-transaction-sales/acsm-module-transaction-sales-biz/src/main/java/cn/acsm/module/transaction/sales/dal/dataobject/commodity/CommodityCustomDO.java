package cn.acsm.module.transaction.sales.dal.dataobject.commodity;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品 DO
 *
 * @author 芋道源码
 */
@TableName("sales_commodity")
@KeySequence("sales_commodity_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommodityCustomDO extends BaseDO {

    /**
     * 商品id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 商品编号
     */
    private String commodityCode;
    /**
     * 序号
     */
    private String articleNo;
    /**
     * 商品条码
     */
    private String commodityBarCode;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 0 渠道商商品 1农资商城商品
     */
    private Boolean type;
    /**
     * 排序权重
     */
    private Integer sort;
    /**
     * 关键字
     */
    private String keyWord;
    /**
     * 生产商
     */
    private String manufacturer;
    /**
     * 批次
     */
    private String batch;
    /**
     * 可销售数量
     */
    private Integer availableNum;
    /**
     * 供应商名称
     */
    private String providerName;
    /**
     * 供应商id
     */
    private String providerId;
    /**
     * 原供应商id,商品来源商户
     */
    private String oldProviderId;
    /**
     * 单位数量
     */
    private BigDecimal specNum;
    /**
     * 多个标签id 逗号隔开
     */
    private String lableIds;
    /**
     * 库存预警数量
     */
    private Long warnStockNum;
    /**
     * 规格单位 字典
     */
    private String weightUnit;
    /**
     * 包装单位 字典
     */
    private String packageUnit;
    /**
     * 商品分类
     */
    private String commodityCategoryId;

    /**
     * 商品分类名称
     */
    private String commodityCategoryName;
    /**
     * 生产商
     */
    private String manufacturerName;
    /**
     * 批发价格
     */
    private BigDecimal wholesalePrice;
    /**
     * 零售价格
     */
    private BigDecimal retailPrice;
    /**
     * 库存数量
     */
    private Long stockNum;
    /**
     * 是否上架 0下架 1上架
     */
    private String saleState;
    /**
     * 介绍 富文本
     */
    private String introduction;
    /**
     * 是否追溯 0-否 1-是
     */
    private String traceStatus;
    /**
     * 库存商品分类id,关联os_plant表
     */
    private String plantId;
    /**
     * 商品分类id,关联plant表
     */
    private String commodityPlantId;
    /**
     * 销售类型 0-自营 1-代售
     */
    private String sellType;
    /**
     * 增加方式 0-货单上架 1-手工上架
     */
    private String addType;
    /**
     * 交货地址
     */
    private String address;
    /**
     * 销售数量
     */
    private BigDecimal num;
    /**
     * 同步状态（0未同步1已同步）
     */
    private String syncStatus;
    /**
     * 货单上货到货时间
     */
    private Date arriveDate;
    /**
     * 0商品
     */
    private String commodityType;
    /**
     * 商品图片
     */
    private String commodityImg;
    /**
     * 公示单价
     */
    private BigDecimal publicityPrice;
    /**
     * 产地
     */
    private String productionAddress;
    /**
     * 产地地址
     */
    private String originPlace;
    /**
     * 商品别名
     */
    private String antName;
    /**
     * 创建的用户id
     */
    private String createId;
    /**
     * 视频连接
     */
    private String videoUrl;

    /**
     * 专家建议
     */
    private String expertAdvice;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 租户编号
     */
    private Long tenantId;
    /**
     * 备注
     */
    private String remark;

}
