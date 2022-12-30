package cn.acsm.module.transaction.sales.controller.admin.inputclassify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 投入品分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InputClassifyPageReqVO extends PageParam {

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;


    @ApiModelProperty(value = "父级编号", required = true)
    private String parentCode;

}
