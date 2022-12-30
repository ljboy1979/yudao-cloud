package cn.acsm.module.production.facility.api.cargospace.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CargoSpaceBaseDTO {

    @ApiModelProperty(value = "主键")
    private String id;

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
