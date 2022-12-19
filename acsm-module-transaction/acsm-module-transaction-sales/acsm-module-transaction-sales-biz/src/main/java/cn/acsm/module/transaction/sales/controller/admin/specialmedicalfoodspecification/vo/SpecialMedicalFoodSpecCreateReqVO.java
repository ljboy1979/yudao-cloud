package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodspecification.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
* 特医食品规格 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@ApiModel("管理后台 - 特医食品规格创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpecialMedicalFoodSpecCreateReqVO extends SpecialMedicalFoodSpecificationBaseVO {

}
