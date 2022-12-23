package cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 投入品分类 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class InputClassifyBaseVO {

    @ApiModelProperty(value = "分类名称", required = true)
    @NotNull(message = "分类名称不能为空")
    private String categoryName;

    @ApiModelProperty(value = "父级编号", required = true)
    @NotNull(message = "父级编号不能为空")
    private String parentCode;

    @ApiModelProperty(value = "所有父级编号", required = true)
    @NotNull(message = "所有父级编号不能为空")
    private String parentCodes;

    @ApiModelProperty(value = "本级排序号（升序）", required = true)
    @NotNull(message = "本级排序号（升序）不能为空")
    private BigDecimal treeSort;

    @ApiModelProperty(value = "所有级别排序号", required = true)
    @NotNull(message = "所有级别排序号不能为空")
    private String treeSorts;

    @ApiModelProperty(value = "是否最末级", required = true)
    @NotNull(message = "是否最末级不能为空")
    private String treeLeaf;

    @ApiModelProperty(value = "层次级别", required = true)
    @NotNull(message = "层次级别不能为空")
    private BigDecimal treeLevel;

    @ApiModelProperty(value = "全节点名", required = true)
    @NotNull(message = "全节点名不能为空")
    private String treeNames;

    @ApiModelProperty(value = "0单条新增1批量新增")
    private String state;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;

    @ApiModelProperty(value = "排序序号")
    private String sort;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

    @ApiModelProperty(value = "备注")
    private String remarks;
}
