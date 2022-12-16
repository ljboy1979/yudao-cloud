package cn.acsm.module.production.devices.dal.dataobject.info;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 设备 DO
 *
 * @author 芋道源码
 */
@TableName("devices_info")
@KeySequence("devices_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
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
     * 地块id
     */
    private String tunnelId;
    /**
     * 设施id
     */
    private String facilitysId;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备编号
     */
    private String deviceSn;
    /**
     * 分类（环境监测设备,自动控制设备等等）
     */
    private String classify;
    /**
     * 设备类型（海康，大华的视频或者新普慧，首扑的传感器）
     */
    private String deviceType;
    /**
     * 设备类型名称
     */
    private String deviceTypeName;
    /**
     * 购买人
     */
    private String buyer;
    /**
     * 安装时间
     */
    private Date buyTime;
    /**
     * 厂商
     */
    private String productBy;
    /**
     * 产品型号
     */
    private String productModel;
    /**
     * 功率
     */
    private String power;
    /**
     * 0:工作,1:待命,2:库存
     */
    private String workStatus;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 视频ip
     */
    private String paramDeviceIp;
    /**
     * 视频http端口
     */
    private String paramHttpPort;
    /**
     * 视频服务端口
     */
    private String paramDevicePort;
    /**
     * 视频rtsp端口
     */
    private String paramRtspPort;
    /**
     * 视频用户名
     */
    private String paramDeviceUsername;
    /**
     * 视频密码
     */
    private String paramDevicePassword;
    /**
     * 视频通道号
     */
    private String paramChanelNum;
    /**
     * 影视云普清
     */
    private String paramYsyUrl;
    /**
     * 萤石云高清
     */
    private String paramYsyUrlHd;
    /**
     * 视频码流类型
     */
    private String paramStreamType;
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
     * 是否公开
     */
    private String isopen;
    /**
     * 组态王链接
     */
    private String kingViewUrl;
    /**
     * 0移动设备,1固定设备
     */
    private String isMobile;
    /**
     * 租户代码
     */
    private String corpCode;
    /**
     * 租户名称
     */
    private String corpName;
    /**
     * 标识时间（接口）
     */
    private Date serviceDate;
    /**
     * 同步状态1已同步
     */
    private String syncStatus;
    /**
     * 1.0版本设备需要拉去数据
     */
    private String isbeta;
    /**
     * 1.0id
     */
    private Integer oldId;
    /**
     * iot_key
     */
    private String iotProductKey;
    /**
     * iot_name
     */
    private String iotDeviceName;
    /**
     * iot_product_name
     */
    private String iotProductName;
    /**
     * iot_id
     */
    private String iotIotId;
    /**
     * 警告设备(0-否1-是)
     */
    private String isAlarm;
    /**
     * 是否在线(0-否1-是)
     */
    private String online;
    /**
     * 设备型号id
     */
    private String deviceModelId;
    /**
     * 分类
     */
    private String deviceClassify;
    /**
     * 厂家code
     */
    private String manufacturer;
    /**
     * 设备型号id
     */
    private String deviceModelName;
    /**
     * 设施id
     */
    private String induFacilityInfoId;
    /**
     * 0阿里1物联网联网
     */
    private String devicesSource;
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
     * 摄像头类型(0阿里1萤石云2直连)
     */
    private String cameraType;
    /**
     * 摄像头id
     */
    private String cameraId;
    /**
     * 称账号
     */
    private String account;
    /**
     * 称密码
     */
    private String passWord;
    /**
     * 关联用户
     */
    private String personnelInfoId;
    /**
     * 设备标签
     */
    private String devicesTag;
    /**
     * 是否在线(0-否1-是)(新)
     */
    private String devicesOnline;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
