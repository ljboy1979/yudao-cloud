package cn.acsm.module.resource.controller.admin.adoptcontent.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 认养物/租凭物 Excel 导出 Request VO", description = "参数和 AdoptContentPageReqVO 是一致的")
@Data
public class AdoptContentExportReqVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "认养状态")
    private String adoptState;

    @ApiModelProperty(value = "认养ids")
    private String adoptIds;

}
