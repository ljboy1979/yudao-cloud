package cn.acsm.module.resource.controller.admin.adoptcontent.vo;

import cn.acsm.module.resource.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import lombok.*;
import io.swagger.annotations.*;

/**
* 认养物/租凭物 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AdoptContentBaseVO {

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
