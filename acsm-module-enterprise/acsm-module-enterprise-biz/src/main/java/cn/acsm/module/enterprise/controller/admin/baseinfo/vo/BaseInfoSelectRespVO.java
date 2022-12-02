package cn.acsm.module.enterprise.controller.admin.baseinfo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 经营主体下拉列表 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BaseInfoSelectRespVO extends BaseInfoBaseVO {

    @ApiModelProperty(value = "主键ID", required = true)
    private Long id;

    @ApiModelProperty(value = "主体编号")
    private String code;

    @ApiModelProperty(value = "主体名称")

    private String name;
}
