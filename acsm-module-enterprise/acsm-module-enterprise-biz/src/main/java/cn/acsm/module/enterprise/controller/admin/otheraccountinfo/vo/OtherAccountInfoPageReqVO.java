package cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 经营主体其他账户分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OtherAccountInfoPageReqVO extends PageParam {

    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "经营主体ID")
    private Long enterpriseId;

    @ApiModelProperty(value = "账户名")
    private String accountName;

    @ApiModelProperty(value = "账户银行卡号")
    private String accountNo;

    @ApiModelProperty(value = "账户身份证号")
    private String accountIdCard;

    @ApiModelProperty(value = "账户开户行")
    private String accountBank;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "更新者")
    private String updater;

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] updateTime;


}
