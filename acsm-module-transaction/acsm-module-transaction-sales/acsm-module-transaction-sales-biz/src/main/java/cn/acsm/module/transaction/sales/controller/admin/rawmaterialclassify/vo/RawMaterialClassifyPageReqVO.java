package cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel("管理后台 - 原料分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RawMaterialClassifyPageReqVO extends PageParam {

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "父级编号", required = true)
    private String parentCode;

}
