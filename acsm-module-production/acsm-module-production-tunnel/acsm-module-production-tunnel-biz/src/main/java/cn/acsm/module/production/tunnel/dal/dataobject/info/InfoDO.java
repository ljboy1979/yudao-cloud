package cn.acsm.module.production.tunnel.dal.dataobject.info;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 地块信息 DO
 *
 * @author 芋道源码
 */
@TableName("tunnel_info")
@KeySequence("tunnel_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
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
     * 基地
     */
    private String baseId;
    /**
     * 分区
     */
    private String partitionId;
    /**
     * 当前种植的json
     */
    private String realPlantJson;
    /**
     * 原主键id 暂未使用
     */
    private Integer tunnelInfoId;
    /**
     * 地块名称
     */
    private String tunnelName;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 维度
     */
    private BigDecimal latitude;
    /**
     * 实际可用面积
     */
    private BigDecimal areaNumber;
    /**
     * 地图画出的面积
     */
    private BigDecimal muNumber;
    /**
     * 行政区划：乡镇、村、区域
     */
    private String areaId;
    /**
     * 百度经度
     */
    private BigDecimal bdLongitude;
    /**
     * 百度纬度
     */
    private BigDecimal bdLatitude;
    /**
     * 边界经纬度
     */
    private String coordinateGroup;
    /**
     * 类型
     */
    private String plantEnvTypeId;
    /**
     * google 抓取的静态图
     */
    private String staticPicture;
    /**
     * 地块颜色
     */
    private String viewColor;
    /**
     * 边框颜色
     */
    private String borderColor;
    /**
     * 透明度 0-100
     */
    private Integer opacity;
    /**
     * 星级
     */
    private Integer littleStar;
    /**
     * 小类别(灌溉水田,天然草地等)
     */
    private Integer littleType;
    /**
     * 乡镇ID
     */
    private String villagesId;
    /**
     * 乡镇CODE
     */
    private String villagesCode;
    /**
     * 村id
     */
    private String ruralId;
    /**
     * 村code
     */
    private String ruralCode;
    /**
     * 地块编号
     */
    private String tunnelCode;
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
     * 归档状态0,正在使用1,已归档
     */
    private String archiveStatus;
    /**
     * 归档时间
     */
    private Date archiveTime;
    /**
     * 租户代码
     */
    private String corpCode;
    /**
     * 租户名称
     */
    private String corpName;
    /**
     * 同步状态 1已同步
     */
    private String syncStatus;
    /**
     * 农户
     */
    private String farmers;
    /**
     * 技术指导员
     */
    private String instructors;
    /**
     * 农户
     */
    private String farmersName;
    /**
     * 技术指导员
     */
    private String instructorsName;
    /**
     * 义田帮手1.0主键
     */
    private Integer oldId;
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
    private String villagesName;
    /**
     * 执行人Id
     */
    private String performId;
    /**
     * 部门Id
     */
    private String departmentId;
    /**
     * 农户id
     */
    private String makersId;
    /**
     * 农户部门id
     */
    private String makersDepartmentId;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * 面积单位
     */
    private String areaNumUnit;
    /**
     * 地块位置
     */
    private String areaLocation;
    /**
     * 多个标签id 逗号隔开
     */
    private String lableIds;
    /**
     * 地块使用状态 0=休耕,1=种植中
     */
    private String plantStatus;
    /**
     * 图片，多张图片用逗号隔开
     */
    private String tunnelinfoImage;
    /**
     * 可播种作物数量
     */
    private Integer plantAmount;
    /**
     * 0认养，1不可认养
     */
    private String adoption;
    /**
     * 租户集合
     */
    private Long source;

}
