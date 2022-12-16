package cn.acsm.module.production.bases.dal.dataobject.info;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基地信息 DO
 *
 * @author 芋道源码
 */
@TableName("bases_info")
@KeySequence("bases_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 行政区域
     */
    private String areaId;
    /**
     * 行政区域
     */
    private String areaName;
    /**
     * 乡镇id
     */
    private String villagesAreaId;
    /**
     * 乡镇id
     */
    private String villagesAreaName;
    /**
     * 村镇id
     */
    private String ruralId;
    /**
     * 村镇id
     */
    private String ruralName;
    /**
     * 基地名称
     */
    private String baseName;
    /**
     * 联系人
     */
    private String contactName;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 百度坐标系经度
     */
    private BigDecimal bdLongitude;
    /**
     * 百度坐标系纬度
     */
    private BigDecimal bdLatitude;
    /**
     * 边界范围
     */
    private String coordinateGroup;
    /**
     * 实际可使用的面积
     */
    private String areaNumber;
    /**
     * geometry计算测出的面积
     */
    private String muNumber;
    /**
     * 颜色
     */
    private String viewColor;
    /**
     * google 抓取的图片
     */
    private String staticPicture;
    /**
     * 海拔
     */
    private String altitude;
    /**
     * 常年供应
     */
    private String persistSupply;
    /**
     * 基地编号
     */
    private String baseCode;
    /**
     * 使用水源
     */
    private String waterSource;
    /**
     * 地形
     */
    private String terrain;
    /**
     * 土壤类型
     */
    private String soilType;
    /**
     * 土壤酸碱度
     */
    private String soilPh;
    /**
     * 气候类型
     */
    private String climateType;
    /**
     * 年降雨量
     */
    private String annualRainfall;
    /**
     * 年平均温度
     */
    private String averageTemperature;
    /**
     * 基地介绍
     */
    private String basesContent;
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
     * gap主键Id
     */
    private String gapId;
    /**
     * 所属企业
     */
    private String affiliatedEnterprises;
    /**
     * 分类
     */
    private String classify;
    /**
     * 租户代码
     */
    private String corpCode;
    /**
     * 租户名称
     */
    private String corpName;
    /**
     * 颜色
     */
    private String borderColor;
    /**
     * 分类
     */
    private String panoramaUrl;
    /**
     * 建设时间
     */
    private Date buildDate;
    /**
     * 同步状态 1已同步
     */
    private String syncStatus;
    /**
     * 宣传视频
     */
    private String propagandaVideo;
    /**
     * 宣传视频
     */
    private String opacity;
    /**
     * 1.0Id
     */
    private Integer oldId;
    /**
     * 图片，多张图片用逗号隔开
     */
    private String basesImage;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
