package cn.iocoder.yudao.module.demo.controller.admin.category.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 商品分类 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryRespVO extends CategoryBaseVO {

    @ApiModelProperty(value = "分类id", required = true)
    private Long id;

}
