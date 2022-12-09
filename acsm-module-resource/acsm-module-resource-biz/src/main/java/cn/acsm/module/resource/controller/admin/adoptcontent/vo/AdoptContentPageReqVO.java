package cn.acsm.module.resource.controller.admin.adoptcontent.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel("管理后台 - 认养物/租凭物分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdoptContentPageReqVO extends PageParam {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "认养状态")
    private String adoptState;

    @ApiModelProperty(value = "多个认养id")
    private String adoptIds;

    @ApiModelProperty(value = "资源类型字段（1-认养物；2-租赁物）")
    private String resourceType;

    @ApiModelProperty(value = "服务id")
    private String serviceId;
}
