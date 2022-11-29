package cn.acsm.module.transaction.sales.dal.dataobject.commoditysku;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品sku DO
 *
 * @author 芋道源码
 */
@TableName("sales_commodity_sku")
@KeySequence("sales_commodity_sku_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommoditySkuDO extends BaseDO {

    /**
     * sku_id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 商品id
     */
    private String commodityId;
    /**
     * 发货单id
     */
    private String shippingOrderInfoId;
    /**
     * 进货单id
     */
    private String stockManagementId;
    /**
     * 会员VIP_Id
     */
    private String vipId;
    /**
     * sku编号
     */
    private String skuCode;
    /**
     * 上货批次
     */
    private String batch;
    /**
     * 可销售数量
     */
    private BigDecimal availableNum;
    /**
     * 可销售重量
     */
    private BigDecimal availableWeight;
    /**
     * 单位数量
     */
    private String specNum;
    /**
     * 规格单位 字典
     */
    private String weightUnit;
    /**
     * 包装单位 字典
     */
    private String packageUnit;
    /**
     * 批发价格
     */
    private BigDecimal wholesalePrice;
    /**
     * 零售价格
     */
    private BigDecimal retailPrice;
    /**
     * 是否追溯 0-否 1-是
     */
    private String traceStatus;
    /**
     * 是否上架 0下架 1上架2禁售
     */
    private String saleState;
    /**
     * 货品标签 0新品、1应季、2推荐、3尾货拼团、4扶贫集采
     */
    private String tag;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * 销售单位 字典
     */
    private String saleUnit;
    /**
     * 规格单位
     */
    private String specName;
    /**
     * 追溯批次
     */
    private String traceBatch;
    /**
     * 溯源状态 10货单溯源 20自有溯源
     */
    private Integer traceType;
    /**
     * 溯源地址
     */
    private String traceAddress;
    /**
     * 产地/联系人名称
     */
    private String traceContact;
    /**
     * 联系方式
     */
    private String tracePhone;
    /**
     * 上游企业名称
     */
    private String traceEnterName;
    /**
     * 上游统一信用代码/身份证号
     */
    private String traceLicense;
    /**
     * 车牌号
     */
    private String carCode;
    /**
     * 浙食链报备id
     */
    private String zslRecordId;
    /**
     * 摊位号
     */
    private String boothNo;

    /**
     * 溯源纬度
     */
    private Double latitude;
    /**
     * 溯源经度
     */
    private Double longitude;
    /**
     * 商户id
     */
    private String merchantId;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 到货时间
     */
    private Date arriveDate;
    /**
     * 商品规格id
     */
    private String productSpecificationsId;
    /**
     * 增加方式 0-货单上架 1-手工上架
     */
    private String addType;
    /**
     * 销售类型 0-自营 1-代售 2-合营
     */
    private String sellType;
    /**
     * 供应商id
     */
    private String providerId;
    /**
     * 原供应商id,商品来源商户
     */
    private String oldProviderId;
    /**
     * 来源sku id
     */
    private String sourceSkuId;
    /**
     * 公示单价
     */
    private BigDecimal publicityPrice;
    /**
     * 包装类型 字典
     */
    private String packingType;
    /**
     * 库存类型 0弱库存 1强库存
     */
    private String stockType;
    /**
     * 货款
     */
    private BigDecimal goodsPrice;
    /**
     * 售出价格
     */
    private BigDecimal sellingPrice;
    /**
     * 采购价格
     */
    private BigDecimal purchasePrice;
    /**
     * 上架数量
     */
    private BigDecimal addNum;
    /**
     * 重量
     */
    private BigDecimal weight;
    /**
     * plu编号
     */
    private String pluCode;
    /**
     * osCommodity_sku_thumbnail
     */
    private String oscommoditySkuThumbnail;
    /**
     * personnel_info_slideshow
     */
    private String personnelInfoSlideshow;
    /**
     * personnel_info_details_figure
     */
    private String personnelInfoDetailsFigure;
    /**
     * 等级
     */
    private String grade;
    /**
     * 创建的用户id
     */
    private String createId;
    /**
     * 商户端商品的标签
     */
    private String businessSellerTag;
    /**
     * 商品描述
     */
    private String content;
    /**
     * 检疫证明图片
     */
    private String quarantineImgs;
    /**
     * 包装名称
     */
    private String packagingName;
    /**
     * 销售单位名称
     */
    private String saleUnitName;
    /**
     * 每人限购数量
     */
    private String availablePersonnel;
    /**
     * 商品类型，1为农资商场
     */
    private String commodityType;
    /**
     * 溯源
     */
    private String tracea;
    /**
     * 食材
     */
    private String ingredients;
    /**
     * 烹饪方法
     */
    private String cookingMethod;
    /**
     * 商品规格
     */
    private String specificationsName;
    /**
     * 收藏数量
     */
    private String collectNum;
    /**
     * 状态
     */
    private Integer status;

}
