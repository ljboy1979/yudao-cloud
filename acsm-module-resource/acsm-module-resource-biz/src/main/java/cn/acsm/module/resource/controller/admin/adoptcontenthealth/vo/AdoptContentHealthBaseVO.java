package cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 服务资源-认养物/租凭物就医记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AdoptContentHealthBaseVO {

    @ApiModelProperty(value = "关联认养物/租凭物")
    private String adoptContentId;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "评估时间")
    private Date assessment;

    @ApiModelProperty(value = "评估人")
    private String assessmenter;

    @ApiModelProperty(value = "评估结果")
    private String assessmentResult;

    @ApiModelProperty(value = "简要概述")
    private String description;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "状态", required = true)
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
