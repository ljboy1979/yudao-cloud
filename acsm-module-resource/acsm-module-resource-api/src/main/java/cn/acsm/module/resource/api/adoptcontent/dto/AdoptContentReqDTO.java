package cn.acsm.module.resource.api.adoptcontent.dto;

import cn.acsm.module.resource.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("管理后台 - 认养/租赁 Response DTO")
@Data
public class AdoptContentReqDTO {

    @ApiModelProperty(value = "编号")
    private String adoptContentCode;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    @DictFormat(DictTypeConstants.ADOPT_TYPE)
    private String type;

    @ApiModelProperty(value = "认养状态")
    private String adoptState;

    @ApiModelProperty(value = "关联地块")
    private String tunnelInfoId;

    @ApiModelProperty(value = "设施id")
    private String induFacilityInfoId;

    @ApiModelProperty(value = "植株/个体的id")
    private String tunnelPlanterId;

    @ApiModelProperty(value = "分类id")
    private String categoryId;

    @ApiModelProperty(value = "群体id")
    private String groupId;
}
