package cn.acsm.module.purchase.controller.admin.quotationelectronic.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * <pre>
 * 对象功能: PurchaseQuotationInfoVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/20
 * <pre>
 */
@ApiModel("管理后台 - 3.6.2.45.查询采购报价明细 Request VO")
@Data
@ToString(callSuper = true)
public class PurchaseQuotationInfoVO extends PageParam implements Serializable {

    @ApiModelProperty(value = "报价单id")
    private Long quotationId;

    @ApiModelProperty(value = "询价单明细编号")
    private Long inquiryDetailId;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] startTime;;

}
