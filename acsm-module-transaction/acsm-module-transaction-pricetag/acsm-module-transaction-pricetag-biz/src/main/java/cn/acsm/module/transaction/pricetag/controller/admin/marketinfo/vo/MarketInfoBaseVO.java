package cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 市场信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MarketInfoBaseVO {

    @ApiModelProperty(value = "市场编号")
    private String marketCode;

    @ApiModelProperty(value = "市场名称", required = true)
    @NotNull(message = "市场名称不能为空")
    private String marketName;

    @ApiModelProperty(value = "市场地址")
    private String marketAddress;

    @ApiModelProperty(value = "省")
    private String provCn;

    @ApiModelProperty(value = "市")
    private String cityCn;

    @ApiModelProperty(value = "区县")
    private String countyCn;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
