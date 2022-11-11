package cn.acsm.module.member.user.controller.admin.wechat.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 微信公众号配置信息 Excel 导出 Request VO", description = "参数和 WeixinDeployInfoPageReqVO 是一致的")
@Data
public class WeixinDeployInfoExportReqVO {

    @ApiModelProperty(value = "公众号appId")
    private String appid;

    @ApiModelProperty(value = "公众号appSecret")
    private String appsecret;

    @ApiModelProperty(value = "商户号")
    private String mchId;

    @ApiModelProperty(value = "商户密钥key")
    private String mchKey;

    @ApiModelProperty(value = "标识")
    private String appletFlag;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
