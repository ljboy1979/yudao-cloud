package cn.acsm.module.production.devices.dal.dataobject.parameter;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 设备表参数 DO
 *
 * @author 芋道源码
 */
@TableName("devices_parameter")
@KeySequence("devices_parameter_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 设备id
     */
    private String deviceId;
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
     * 组态王链接
     */
    private String kingViewUrl;
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
     * 租户代码
     */
    private String corpCode;
    /**
     * 租户名称
     */
    private String corpName;
    /**
     * 租户集合
     */
    private Long source;
    /**
     * 经营主体ID
     */
    private Long subjectId;

}
