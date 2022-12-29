package cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 货架库存记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class StockRecordBaseVO {

    @ApiModelProperty(value = "货架规格id")
    private String specificationsId;

    @ApiModelProperty(value = "类型 0 上架 1下架 2销售 3报损 4退货")
    @NotNull(message = "类型不能为空")
    private String type;

    @ApiModelProperty(value = "操作量", required = true)
    @NotNull(message = "操作量不能为空")
    private BigDecimal amount;

    @ApiModelProperty(value = "备注", required = true)
    //@NotNull(message = "备注不能为空")
    private String remark;

    @ApiModelProperty(value = "状态", required = true)
    //@NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id", required = true)
    //@NotNull(message = "经营主体id不能为空")
    private String subjectId;

    @ApiModelProperty(value = "source", required = true)
    //@NotNull(message = "source不能为空")
    private String source;

}
