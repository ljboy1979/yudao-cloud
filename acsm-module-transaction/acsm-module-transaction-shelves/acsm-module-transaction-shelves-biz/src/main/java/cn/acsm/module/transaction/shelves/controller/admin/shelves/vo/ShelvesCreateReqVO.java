package cn.acsm.module.transaction.shelves.controller.admin.shelves.vo;

import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.SpecificationsCreateReqVO;
import lombok.*;
import io.swagger.annotations.*;

import java.util.List;

@ApiModel("管理后台 - 货架创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShelvesCreateReqVO extends ShelvesBaseVO {

    @ApiModelProperty(value = "名称")
    private List<SpecificationsCreateReqVO> specificationsCreateReqVOS;

}
