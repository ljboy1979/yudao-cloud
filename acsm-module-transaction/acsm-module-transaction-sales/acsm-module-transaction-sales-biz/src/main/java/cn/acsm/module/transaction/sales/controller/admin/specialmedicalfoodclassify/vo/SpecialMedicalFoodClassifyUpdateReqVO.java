package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 特医食品分类更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpecialMedicalFoodClassifyUpdateReqVO extends SpecialMedicalFoodClassifyBaseVO {

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private String id;

}
