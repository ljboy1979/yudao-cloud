package cn.acsm.module.production.devices.controller.admin.info.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 设备 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class InfoExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("基地")
    private String baseId;

    @ExcelProperty("地块id")
    private String tunnelId;

    @ExcelProperty("设施id")
    private String facilitysId;

    @ExcelProperty("设备名称")
    private String deviceName;

    @ExcelProperty("设备编号")
    private String deviceSn;

    @ExcelProperty("分类（环境监测设备,自动控制设备等等）")
    private String classify;

    @ExcelProperty("设备类型（海康，大华的视频或者新普慧，首扑的传感器）")
    private String deviceType;

    @ExcelProperty("设备类型名称")
    private String deviceTypeName;

    @ExcelProperty("购买人")
    private String buyer;

    @ExcelProperty("安装时间")
    private Date buyTime;

    @ExcelProperty("厂商")
    private String productBy;

    @ExcelProperty("产品型号")
    private String productModel;

    @ExcelProperty("功率")
    private String power;

    @ExcelProperty("0:工作,1:待命,2:库存")
    private String workStatus;

    @ExcelProperty("经度")
    private BigDecimal longitude;

    @ExcelProperty("纬度")
    private BigDecimal latitude;

    @ExcelProperty("视频ip")
    private String paramDeviceIp;

    @ExcelProperty("视频http端口")
    private String paramHttpPort;

    @ExcelProperty("视频服务端口")
    private String paramDevicePort;

    @ExcelProperty("视频rtsp端口")
    private String paramRtspPort;

    @ExcelProperty("视频用户名")
    private String paramDeviceUsername;

    @ExcelProperty("视频密码")
    private String paramDevicePassword;

    @ExcelProperty("视频通道号")
    private String paramChanelNum;

    @ExcelProperty("影视云普清")
    private String paramYsyUrl;

    @ExcelProperty("萤石云高清")
    private String paramYsyUrlHd;

    @ExcelProperty("视频码流类型")
    private String paramStreamType;

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

    @ExcelProperty("是否公开")
    private String isopen;

    @ExcelProperty("组态王链接")
    private String kingViewUrl;

    @ExcelProperty("0移动设备,1固定设备")
    private String isMobile;

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("标识时间（接口）")
    private Date serviceDate;

    @ExcelProperty("同步状态1已同步")
    private String syncStatus;

    @ExcelProperty("1.0版本设备需要拉去数据")
    private String isbeta;

    @ExcelProperty("1.0id")
    private Integer oldId;

    @ExcelProperty("iot_key")
    private String iotProductKey;

    @ExcelProperty("iot_name")
    private String iotDeviceName;

    @ExcelProperty("iot_product_name")
    private String iotProductName;

    @ExcelProperty("iot_id")
    private String iotIotId;

    @ExcelProperty("警告设备(0-否1-是)")
    private String isAlarm;

    @ExcelProperty("是否在线(0-否1-是)")
    private String online;

    @ExcelProperty("设备型号id")
    private String deviceModelId;

    @ExcelProperty("分类")
    private String deviceClassify;

    @ExcelProperty("厂家code")
    private String manufacturer;

    @ExcelProperty("设备型号id")
    private String deviceModelName;

    @ExcelProperty("设施id")
    private String induFacilityInfoId;

    @ExcelProperty("0阿里1物联网联网")
    private String devicesSource;

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

    @ExcelProperty("摄像头类型(0阿里1萤石云2直连)")
    private String cameraType;

    @ExcelProperty("摄像头id")
    private String cameraId;

    @ExcelProperty("称账号")
    private String account;

    @ExcelProperty("称密码")
    private String passWord;

    @ExcelProperty("关联用户")
    private String personnelInfoId;

    @ExcelProperty("设备标签")
    private String devicesTag;

    @ExcelProperty("是否在线(0-否1-是)(新)")
    private String devicesOnline;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
