package cn.acsm.module.production.devices.controller.admin.info.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 设备 Excel 导出 Request VO", description = "参数和 InfoPageReqVO 是一致的")
@Data
public class InfoExportReqVO {

    @ApiModelProperty(value = "基地")
    private String baseId;

    @ApiModelProperty(value = "地块id")
    private String tunnelId;

    @ApiModelProperty(value = "设施id")
    private String facilitysId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备编号")
    private String deviceSn;

    @ApiModelProperty(value = "分类（环境监测设备,自动控制设备等等）")
    private String classify;

    @ApiModelProperty(value = "设备类型（海康，大华的视频或者新普慧，首扑的传感器）")
    private String deviceType;

    @ApiModelProperty(value = "设备类型名称")
    private String deviceTypeName;

    @ApiModelProperty(value = "购买人")
    private String buyer;

    @ApiModelProperty(value = "安装时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] buyTime;

    @ApiModelProperty(value = "厂商")
    private String productBy;

    @ApiModelProperty(value = "产品型号")
    private String productModel;

    @ApiModelProperty(value = "功率")
    private String power;

    @ApiModelProperty(value = "0:工作,1:待命,2:库存")
    private String workStatus;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "视频ip")
    private String paramDeviceIp;

    @ApiModelProperty(value = "视频http端口")
    private String paramHttpPort;

    @ApiModelProperty(value = "视频服务端口")
    private String paramDevicePort;

    @ApiModelProperty(value = "视频rtsp端口")
    private String paramRtspPort;

    @ApiModelProperty(value = "视频用户名")
    private String paramDeviceUsername;

    @ApiModelProperty(value = "视频密码")
    private String paramDevicePassword;

    @ApiModelProperty(value = "视频通道号")
    private String paramChanelNum;

    @ApiModelProperty(value = "影视云普清")
    private String paramYsyUrl;

    @ApiModelProperty(value = "萤石云高清")
    private String paramYsyUrlHd;

    @ApiModelProperty(value = "视频码流类型")
    private String paramStreamType;

    @ApiModelProperty(value = "机构编码")
    private String officeCode;

    @ApiModelProperty(value = "机构名称")
    private String officeName;

    @ApiModelProperty(value = "公司编码")
    private String companyCode;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "审核状态")
    private String reviewStatus;

    @ApiModelProperty(value = "审核人")
    private String reviewer;

    @ApiModelProperty(value = "审核时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] reviewDate;

    @ApiModelProperty(value = "审核内容")
    private String reviewContent;

    @ApiModelProperty(value = "是否公开")
    private String isopen;

    @ApiModelProperty(value = "组态王链接")
    private String kingViewUrl;

    @ApiModelProperty(value = "0移动设备,1固定设备")
    private String isMobile;

    @ApiModelProperty(value = "租户代码")
    private String corpCode;

    @ApiModelProperty(value = "租户名称")
    private String corpName;

    @ApiModelProperty(value = "标识时间（接口）")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] serviceDate;

    @ApiModelProperty(value = "同步状态1已同步")
    private String syncStatus;

    @ApiModelProperty(value = "1.0版本设备需要拉去数据")
    private String isbeta;

    @ApiModelProperty(value = "1.0id")
    private Integer oldId;

    @ApiModelProperty(value = "iot_key")
    private String iotProductKey;

    @ApiModelProperty(value = "iot_name")
    private String iotDeviceName;

    @ApiModelProperty(value = "iot_product_name")
    private String iotProductName;

    @ApiModelProperty(value = "iot_id")
    private String iotIotId;

    @ApiModelProperty(value = "警告设备(0-否1-是)")
    private String isAlarm;

    @ApiModelProperty(value = "是否在线(0-否1-是)")
    private String online;

    @ApiModelProperty(value = "设备型号id")
    private String deviceModelId;

    @ApiModelProperty(value = "分类")
    private String deviceClassify;

    @ApiModelProperty(value = "厂家code")
    private String manufacturer;

    @ApiModelProperty(value = "设备型号id")
    private String deviceModelName;

    @ApiModelProperty(value = "设施id")
    private String induFacilityInfoId;

    @ApiModelProperty(value = "0阿里1物联网联网")
    private String devicesSource;

    @ApiModelProperty(value = "市id")
    private String areaId;

    @ApiModelProperty(value = "区id")
    private String ruralId;

    @ApiModelProperty(value = "省id")
    private String villagesAreaId;

    @ApiModelProperty(value = "市名称")
    private String areaName;

    @ApiModelProperty(value = "区名称")
    private String ruralName;

    @ApiModelProperty(value = "省名称")
    private String villagesAreaName;

    @ApiModelProperty(value = "摄像头类型(0阿里1萤石云2直连)")
    private String cameraType;

    @ApiModelProperty(value = "摄像头id")
    private String cameraId;

    @ApiModelProperty(value = "称账号")
    private String account;

    @ApiModelProperty(value = "称密码")
    private String passWord;

    @ApiModelProperty(value = "关联用户")
    private String personnelInfoId;

    @ApiModelProperty(value = "设备标签")
    private String devicesTag;

    @ApiModelProperty(value = "是否在线(0-否1-是)(新)")
    private String devicesOnline;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
