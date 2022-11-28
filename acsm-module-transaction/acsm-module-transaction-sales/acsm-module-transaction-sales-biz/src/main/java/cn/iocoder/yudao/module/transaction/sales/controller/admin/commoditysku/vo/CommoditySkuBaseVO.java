package cn.iocoder.yudao.module.transaction.sales.controller.admin.commoditysku.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 商品sku Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CommoditySkuBaseVO {

    @ApiModelProperty(value = "商品id")
    private String commodityId;

    @ApiModelProperty(value = "发货单id")
    private String shippingOrderInfoId;

    @ApiModelProperty(value = "进货单id")
    private String stockManagementId;

    @ApiModelProperty(value = "会员VIP_Id")
    private String vipId;

    @ApiModelProperty(value = "sku编号")
    private String skuCode;

    @ApiModelProperty(value = "上货批次")
    private String batch;

    @ApiModelProperty(value = "可销售数量")
    private BigDecimal availableNum;

    @ApiModelProperty(value = "可销售重量")
    private BigDecimal availableWeight;

    @ApiModelProperty(value = "单位数量")
    private String specNum;

    @ApiModelProperty(value = "规格单位 字典")
    private String weightUnit;

    @ApiModelProperty(value = "包装单位 字典")
    private String packageUnit;

    @ApiModelProperty(value = "批发价格")
    private BigDecimal wholesalePrice;

    @ApiModelProperty(value = "零售价格")
    private BigDecimal retailPrice;

    @ApiModelProperty(value = "是否追溯 0-否 1-是")
    private String traceStatus;

    @ApiModelProperty(value = "是否上架 0下架 1上架2禁售")
    private String saleState;

    @ApiModelProperty(value = "货品标签 0新品、1应季、2推荐、3尾货拼团、4扶贫集采")
    private String tag;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "销售单位 字典")
    private String saleUnit;

    @ApiModelProperty(value = "规格单位")
    private String specName;

    @ApiModelProperty(value = "追溯批次")
    private String traceBatch;

    @ApiModelProperty(value = "溯源状态 10货单溯源 20自有溯源")
    private Integer traceType;

    @ApiModelProperty(value = "溯源地址")
    private String traceAddress;

    @ApiModelProperty(value = "产地/联系人名称")
    private String traceContact;

    @ApiModelProperty(value = "联系方式")
    private String tracePhone;

    @ApiModelProperty(value = "上游企业名称")
    private String traceEnterName;

    @ApiModelProperty(value = "上游统一信用代码/身份证号")
    private String traceLicense;

    @ApiModelProperty(value = "车牌号")
    private String carCode;

    @ApiModelProperty(value = "浙食链报备id")
    private String zslRecordId;

    @ApiModelProperty(value = "摊位号")
    private String boothNo;

    @ApiModelProperty(value = "溯源纬度")
    private Double latitude;

    @ApiModelProperty(value = "溯源经度")
    private Double longitude;

    @ApiModelProperty(value = "商户id")
    private String merchantId;

    @ApiModelProperty(value = "收货地址")
    private String address;

    @ApiModelProperty(value = "到货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date arriveDate;

    @ApiModelProperty(value = "商品规格id")
    private String productSpecificationsId;

    @ApiModelProperty(value = "增加方式 0-货单上架 1-手工上架")
    private String addType;

    @ApiModelProperty(value = "销售类型 0-自营 1-代售 2-合营")
    private String sellType;

    @ApiModelProperty(value = "供应商id")
    private String providerId;

    @ApiModelProperty(value = "原供应商id,商品来源商户")
    private String oldProviderId;

    @ApiModelProperty(value = "来源sku id")
    private String sourceSkuId;

    @ApiModelProperty(value = "公示单价")
    private BigDecimal publicityPrice;

    @ApiModelProperty(value = "包装类型 字典")
    private String packingType;

    @ApiModelProperty(value = "库存类型 0弱库存 1强库存")
    private String stockType;

    @ApiModelProperty(value = "货款")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "售出价格")
    private BigDecimal sellingPrice;

    @ApiModelProperty(value = "采购价格")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "上架数量")
    private BigDecimal addNum;

    @ApiModelProperty(value = "重量")
    private BigDecimal weight;

    @ApiModelProperty(value = "plu编号")
    private String pluCode;

    @ApiModelProperty(value = "osCommodity_sku_thumbnail")
    private String oscommoditySkuThumbnail;

    @ApiModelProperty(value = "personnel_info_slideshow")
    private String personnelInfoSlideshow;

    @ApiModelProperty(value = "personnel_info_details_figure")
    private String personnelInfoDetailsFigure;

    @ApiModelProperty(value = "等级")
    private String grade;

    @ApiModelProperty(value = "创建的用户id")
    private String createId;

    @ApiModelProperty(value = "商户端商品的标签")
    private String businessSellerTag;

    @ApiModelProperty(value = "商品描述")
    private String content;

    @ApiModelProperty(value = "检疫证明图片")
    private String quarantineImgs;

    @ApiModelProperty(value = "包装名称")
    private String packagingName;

    @ApiModelProperty(value = "销售单位名称")
    private String saleUnitName;

    @ApiModelProperty(value = "每人限购数量")
    private String availablePersonnel;

    @ApiModelProperty(value = "商品类型，1为农资商场")
    private String commodityType;

    @ApiModelProperty(value = "溯源")
    private String tracea;

    @ApiModelProperty(value = "食材")
    private String ingredients;

    @ApiModelProperty(value = "烹饪方法")
    private String cookingMethod;

    @ApiModelProperty(value = "商品规格")
    private String specificationsName;

    @ApiModelProperty(value = "收藏数量")
    private String collectNum;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

}
