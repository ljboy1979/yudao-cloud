package cn.acsm.module.production.facility.controller.admin.cargospace.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 设施货位 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CargoSpaceBaseVO {

    @ApiModelProperty(value = "货位号")
    private String spaceCode;

    @ApiModelProperty(value = "行数")
    private Integer spaceRowNumber;

    @ApiModelProperty(value = "列数")
    private Integer spaceColumnNumber;

    @ApiModelProperty(value = "层数")
    private Integer spaceLayerNumber;

    @ApiModelProperty(value = "设施")
    private Integer facilityId;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
