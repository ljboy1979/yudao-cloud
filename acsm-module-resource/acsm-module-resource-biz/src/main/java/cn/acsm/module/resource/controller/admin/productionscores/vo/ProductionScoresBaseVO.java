package cn.acsm.module.resource.controller.admin.productionscores.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 服务资源-生产品种 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ProductionScoresBaseVO {

    @ApiModelProperty(value = "关联认养物/租凭物")
    private String serviceAdoptContentId;

    @ApiModelProperty(value = "关联生产品种")
    private String productionScoresId;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
