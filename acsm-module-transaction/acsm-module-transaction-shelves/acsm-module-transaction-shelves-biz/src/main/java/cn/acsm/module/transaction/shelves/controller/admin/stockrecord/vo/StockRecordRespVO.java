package cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 货架库存记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordRespVO extends StockRecordBaseVO {

    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "创建人", required = true)
    private String creator;
    @ApiModelProperty(value = "货架规格名称")
    private String specificationsName;


    @ApiModelProperty(value = "创建时间", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "更新时间", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
