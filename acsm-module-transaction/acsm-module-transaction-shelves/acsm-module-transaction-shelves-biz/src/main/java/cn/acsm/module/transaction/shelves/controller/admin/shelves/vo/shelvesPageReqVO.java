package cn.acsm.module.transaction.shelves.controller.admin.shelves.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 货架分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class shelvesPageReqVO extends PageParam {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "分类id")
    private String classifyId;


    @ApiModelProperty(value = "是否上架 0下架 1上架 2禁售")
    private String saleState;


    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
