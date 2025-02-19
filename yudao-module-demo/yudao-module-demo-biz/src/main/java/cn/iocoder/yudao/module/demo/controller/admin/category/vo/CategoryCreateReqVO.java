package cn.iocoder.yudao.module.demo.controller.admin.category.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 商品分类创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryCreateReqVO extends CategoryBaseVO {

}
