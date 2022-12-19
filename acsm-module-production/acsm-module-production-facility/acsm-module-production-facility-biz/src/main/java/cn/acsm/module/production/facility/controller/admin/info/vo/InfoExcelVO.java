package cn.acsm.module.production.facility.controller.admin.info.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 设施 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class InfoExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("基地")
    private String baseId;

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("设施编号")
    private String facilityCode;

    @ExcelProperty("分类(生产类,加工类,服务类,管理类)")
    private Integer classify;

    @ExcelProperty("加工车间,饭店等等")
    private Integer facilityType;

    @ExcelProperty("实际可用面积")
    private Double areaNumber;

    @ExcelProperty("地图画出的面积")
    private Double muNumber;

    @ExcelProperty("经度")
    private Double longitude;

    @ExcelProperty("纬度")
    private Double latitude;

    @ExcelProperty("百度坐标系经度")
    private BigDecimal bdLongitude;

    @ExcelProperty("百度坐标系纬度")
    private BigDecimal bdLatitude;

    @ExcelProperty("边界坐标集")
    private String coordinateGroup;

    @ExcelProperty("透明度")
    private Integer opacity;

    @ExcelProperty("边界颜色")
    private String viewColor;

    @ExcelProperty("边框颜色")
    private String borderColor;

    @ExcelProperty("品类id")
    private String plantId;

    @ExcelProperty("商品规格")
    private String commoditySpec;

    @ExcelProperty("商品数量")
    private String commodityNum;

    @ExcelProperty("品类名称")
    private String plantName;

    @ExcelProperty("机构编码")
    private String officeCode;

    @ExcelProperty("机构名称")
    private String officeName;

    @ExcelProperty("公司编码")
    private String companyCode;

    @ExcelProperty("公司名称")
    private String companyName;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("审核状态")
    private String reviewStatus;

    @ExcelProperty("审核人")
    private String reviewer;

    @ExcelProperty("审核时间")
    private Date reviewDate;

    @ExcelProperty("审核内容")
    private String reviewContent;

    @ExcelProperty("产业标签")
    private String industryLabel;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("类型")
    private Integer secondFacilityType;

    @ExcelProperty("储藏条件")
    private String storageConditions;

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("同步状态1已同步")
    private String syncStatus;

    @ExcelProperty("地块id")
    private String tunnelInfoId;

    @ExcelProperty("市id")
    private String areaId;

    @ExcelProperty("区id")
    private String ruralId;

    @ExcelProperty("省id")
    private String villagesAreaId;

    @ExcelProperty("市名称")
    private String areaName;

    @ExcelProperty("区名称")
    private String ruralName;

    @ExcelProperty("省名称")
    private String villagesAreaName;

    @ExcelProperty("所属区域")
    private String regionalManagementId;

    @ExcelProperty("设施状态(已出租0未出租1停用2)")
    private String induFacilityInfoState;

    @ExcelProperty("到期时间")
    private Date expirationTime;

    @ExcelProperty("图片，多个图片用逗号隔开")
    private String indufacilityinfoImage;

    @ExcelProperty("实际可用面积单位 关联字典")
    private String areaNumberUnit;

    @ExcelProperty("楼栋/单元")
    private String building;

    @ExcelProperty("楼层 关联字典")
    private String floor;

    @ExcelProperty("门牌号")
    private String houseNumber;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
