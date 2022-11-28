package cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesspecification.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 菜品规格 Excel 导出 Request VO", description = "参数和 DishesSpecificationPageReqVO 是一致的")
@Data
public class DishesSpecificationExportReqVO {

    @ApiModelProperty(value = "规格名称")
    private String specificationsName;

}
