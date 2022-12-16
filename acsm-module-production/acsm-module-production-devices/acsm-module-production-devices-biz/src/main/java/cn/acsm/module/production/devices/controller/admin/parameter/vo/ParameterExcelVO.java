package cn.acsm.module.production.devices.controller.admin.parameter.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 设备表参数 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ParameterExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("设备id")
    private String deviceId;

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

    @ExcelProperty("组态王链接")
    private String kingViewUrl;

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

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
