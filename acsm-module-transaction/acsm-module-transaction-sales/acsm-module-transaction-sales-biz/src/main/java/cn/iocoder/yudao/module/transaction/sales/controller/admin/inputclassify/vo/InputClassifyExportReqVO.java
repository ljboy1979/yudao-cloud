package cn.iocoder.yudao.module.transaction.sales.controller.admin.inputclassify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 投入品分类 Excel 导出 Request VO", description = "参数和 InputClassifyPageReqVO 是一致的")
@Data
public class InputClassifyExportReqVO {

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
