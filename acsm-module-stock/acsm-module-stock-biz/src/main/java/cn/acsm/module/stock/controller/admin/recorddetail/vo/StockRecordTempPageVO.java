package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 3.7.2.20.临期时间管理 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordTempPageVO extends PageParam {

    @ApiModelProperty(value = "临时时间大于当前时间：0 临时时间小于当前时间：1")
    private Integer maxOrmin;


}
