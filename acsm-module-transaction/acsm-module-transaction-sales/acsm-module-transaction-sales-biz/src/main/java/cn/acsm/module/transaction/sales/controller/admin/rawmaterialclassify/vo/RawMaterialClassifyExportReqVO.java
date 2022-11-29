package cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 原料分类 Excel 导出 Request VO", description = "参数和 RawMaterialClassifyPageReqVO 是一致的")
@Data
public class RawMaterialClassifyExportReqVO {

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

}
