package cn.acsm.module.member.wallet.controller.admin.walletinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 用户钱包信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserWalletInfoPageReqVO extends PageParam {

    @ApiModelProperty(value = "钱包编号")
    private String walletId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
