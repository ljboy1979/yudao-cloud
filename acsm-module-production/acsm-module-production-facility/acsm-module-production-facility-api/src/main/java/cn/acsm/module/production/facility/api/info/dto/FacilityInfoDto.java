package cn.acsm.module.production.facility.api.info.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityInfoDto {

    /**
     * 主键
     */
    private Long id;
    /**
     * 基地
     */
    private String baseId;
    /**
     * 名称
     */
    private String name;
    /**
     * 设施编号
     */
    private String facilityCode;
    /**
     * 分类(生产类,加工类,服务类,管理类)
     */
    private Integer classify;
    /**
     * 加工车间,饭店等等
     */
    private Integer facilityType;
    /**
     * 实际可用面积
     */
    private Double areaNumber;
    /**
     * 地图画出的面积
     */
    private Double muNumber;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 百度坐标系经度
     */
    private BigDecimal bdLongitude;
    /**
     * 百度坐标系纬度
     */
    private BigDecimal bdLatitude;
    /**
     * 边界坐标集
     */
    private String coordinateGroup;
    /**
     * 透明度
     */
    private Integer opacity;
    /**
     * 边界颜色
     */
    private String viewColor;
    /**
     * 边框颜色
     */
    private String borderColor;
    /**
     * 品类id
     */
    private String plantId;
    /**
     * 商品规格
     */
    private String commoditySpec;
    /**
     * 商品数量
     */
    private String commodityNum;
    /**
     * 品类名称
     */
    private String plantName;
    /**
     * 机构编码
     */
    private String officeCode;
    /**
     * 机构名称
     */
    private String officeName;
    /**
     * 公司编码
     */
    private String companyCode;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 审核状态
     */
    private String reviewStatus;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 审核时间
     */
    private Date reviewDate;
    /**
     * 审核内容
     */
    private String reviewContent;
    /**
     * 产业标签
     */
    private String industryLabel;
    /**
     * 地址
     */
    private String address;
    /**
     * 类型
     */
    private Integer secondFacilityType;
    /**
     * 储藏条件
     */
    private String storageConditions;
    /**
     * 租户代码
     */
    private String corpCode;
    /**
     * 租户名称
     */
    private String corpName;
    /**
     * 同步状态1已同步
     */
    private String syncStatus;
    /**
     * 地块id
     */
    private String tunnelInfoId;
    /**
     * 市id
     */
    private String areaId;
    /**
     * 区id
     */
    private String ruralId;
    /**
     * 省id
     */
    private String villagesAreaId;
    /**
     * 市名称
     */
    private String areaName;
    /**
     * 区名称
     */
    private String ruralName;
    /**
     * 省名称
     */
    private String villagesAreaName;
    /**
     * 所属区域
     */
    private String regionalManagementId;
    /**
     * 设施状态(已出租0未出租1停用2)
     */
    private String induFacilityInfoState;
    /**
     * 到期时间
     */
    private Date expirationTime;
    /**
     * 图片，多个图片用逗号隔开
     */
    private String indufacilityinfoImage;
    /**
     * 实际可用面积单位 关联字典
     */
    private String areaNumberUnit;
    /**
     * 楼栋/单元
     */
    private String building;
    /**
     * 楼层 关联字典
     */
    private String floor;
    /**
     * 门牌号
     */
    private String houseNumber;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;
}
