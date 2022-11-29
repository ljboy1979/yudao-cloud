package cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 商品sku Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CommoditySkuExcelVO {

    @ExcelProperty("sku_id")
    private String id;

    @ExcelProperty("商品id")
    private String commodityId;

    @ExcelProperty("发货单id")
    private String shippingOrderInfoId;

    @ExcelProperty("进货单id")
    private String stockManagementId;

    @ExcelProperty("会员VIP_Id")
    private String vipId;

    @ExcelProperty("sku编号")
    private String skuCode;

    @ExcelProperty("上货批次")
    private String batch;

    @ExcelProperty("可销售数量")
    private BigDecimal availableNum;

    @ExcelProperty("可销售重量")
    private BigDecimal availableWeight;

    @ExcelProperty("单位数量")
    private String specNum;

    @ExcelProperty("规格单位 字典")
    private String weightUnit;

    @ExcelProperty("包装单位 字典")
    private String packageUnit;

    @ExcelProperty("批发价格")
    private BigDecimal wholesalePrice;

    @ExcelProperty("零售价格")
    private BigDecimal retailPrice;

    @ExcelProperty("是否追溯 0-否 1-是")
    private String traceStatus;

    @ExcelProperty("是否上架 0下架 1上架2禁售")
    private String saleState;

    @ExcelProperty("货品标签 0新品、1应季、2推荐、3尾货拼团、4扶贫集采")
    private String tag;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("销售单位 字典")
    private String saleUnit;

    @ExcelProperty("规格单位")
    private String specName;

    @ExcelProperty("追溯批次")
    private String traceBatch;

    @ExcelProperty("溯源状态 10货单溯源 20自有溯源")
    private Integer traceType;

    @ExcelProperty("溯源地址")
    private String traceAddress;

    @ExcelProperty("产地/联系人名称")
    private String traceContact;

    @ExcelProperty("联系方式")
    private String tracePhone;

    @ExcelProperty("上游企业名称")
    private String traceEnterName;

    @ExcelProperty("上游统一信用代码/身份证号")
    private String traceLicense;

    @ExcelProperty("车牌号")
    private String carCode;

    @ExcelProperty("浙食链报备id")
    private String zslRecordId;

    @ExcelProperty("摊位号")
    private String boothNo;

    @ExcelProperty("溯源纬度")
    private Double latitude;

    @ExcelProperty("溯源经度")
    private Double longitude;

    @ExcelProperty("商户id")
    private String merchantId;

    @ExcelProperty("收货地址")
    private String address;

    @ExcelProperty("到货时间")
    private Date arriveDate;

    @ExcelProperty("商品规格id")
    private String productSpecificationsId;

    @ExcelProperty("增加方式 0-货单上架 1-手工上架")
    private String addType;

    @ExcelProperty("销售类型 0-自营 1-代售 2-合营")
    private String sellType;

    @ExcelProperty("供应商id")
    private String providerId;

    @ExcelProperty("原供应商id,商品来源商户")
    private String oldProviderId;

    @ExcelProperty("来源sku id")
    private String sourceSkuId;

    @ExcelProperty("公示单价")
    private BigDecimal publicityPrice;

    @ExcelProperty("包装类型 字典")
    private String packingType;

    @ExcelProperty("库存类型 0弱库存 1强库存")
    private String stockType;

    @ExcelProperty("货款")
    private BigDecimal goodsPrice;

    @ExcelProperty("售出价格")
    private BigDecimal sellingPrice;

    @ExcelProperty("采购价格")
    private BigDecimal purchasePrice;

    @ExcelProperty("上架数量")
    private BigDecimal addNum;

    @ExcelProperty("重量")
    private BigDecimal weight;

    @ExcelProperty("plu编号")
    private String pluCode;

    @ExcelProperty("osCommodity_sku_thumbnail")
    private String oscommoditySkuThumbnail;

    @ExcelProperty("personnel_info_slideshow")
    private String personnelInfoSlideshow;

    @ExcelProperty("personnel_info_details_figure")
    private String personnelInfoDetailsFigure;

    @ExcelProperty("等级")
    private String grade;

    @ExcelProperty("创建的用户id")
    private String createId;

    @ExcelProperty("商户端商品的标签")
    private String businessSellerTag;

    @ExcelProperty("商品描述")
    private String content;

    @ExcelProperty("检疫证明图片")
    private String quarantineImgs;

    @ExcelProperty("包装名称")
    private String packagingName;

    @ExcelProperty("销售单位名称")
    private String saleUnitName;

    @ExcelProperty("每人限购数量")
    private String availablePersonnel;

    @ExcelProperty("商品类型，1为农资商场")
    private String commodityType;

    @ExcelProperty("溯源")
    private String tracea;

    @ExcelProperty("食材")
    private String ingredients;

    @ExcelProperty("烹饪方法")
    private String cookingMethod;

    @ExcelProperty("商品规格")
    private String specificationsName;

    @ExcelProperty("收藏数量")
    private String collectNum;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

}
