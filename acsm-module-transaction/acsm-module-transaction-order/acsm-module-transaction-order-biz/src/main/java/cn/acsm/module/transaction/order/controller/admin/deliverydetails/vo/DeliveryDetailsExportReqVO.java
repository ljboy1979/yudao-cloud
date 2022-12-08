package cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel(value = "管理后台 - 配送详情 Excel 导出 Request VO", description = "参数和 DeliveryDetailsPageReqVO 是一致的")
@Data
public class DeliveryDetailsExportReqVO {

    @ApiModelProperty(value = "配送id")
    private String deliveryId;

    @ApiModelProperty(value = "名称")
    private String name;

}
