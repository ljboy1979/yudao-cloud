package cn.iocoder.yudao.module.demo.controller.admin.category.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 商品分类 Excel 导出 Request VO", description = "参数和 CategoryPageReqVO 是一致的")
@Data
public class CategoryExportReqVO {

    @ApiModelProperty(value = "上级分类的编号：0表示一级分类")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "分类级别：0->1级；1->2级")
    private Boolean level;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Boolean showStatus;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "描述")
    private String description;

}
