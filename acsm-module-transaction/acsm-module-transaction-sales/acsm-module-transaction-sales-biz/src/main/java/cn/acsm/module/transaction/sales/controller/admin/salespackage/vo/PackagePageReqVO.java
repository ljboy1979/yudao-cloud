package cn.acsm.module.transaction.sales.controller.admin.salespackage.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 套餐分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PackagePageReqVO extends PageParam {

    @ApiModelProperty(value = "套餐名称")
    private String name;

    @ApiModelProperty(value = "序列号")
    private String sort;

    @ApiModelProperty(value = "小程序套餐分类id一级 关联os_commodity_category_mini")
    private String miniClassificationIdOne;

    @ApiModelProperty(value = "小程序套餐分类id二级 关联os_commodity_category_mini")
    private String miniClassificationIdTwo;

    @ApiModelProperty(value = "套餐商品构成")
    private String commodityName;

    @ApiModelProperty(value = "套餐视频")
    private String video;

    @ApiModelProperty(value = "处理规格 字典Process_specifications 可存多个")
    private String processTag;

    @ApiModelProperty(value = "物流费")
    private Double logisticsFees;

    @ApiModelProperty(value = "捕捞商品id")
    private String osCommodityFishingId;

    @ApiModelProperty(value = "捕捞规格id")
    private String productSpecificationsFishingId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
