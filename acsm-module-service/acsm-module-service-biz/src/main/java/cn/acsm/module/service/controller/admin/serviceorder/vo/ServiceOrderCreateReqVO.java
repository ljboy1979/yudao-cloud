package cn.acsm.module.service.controller.admin.serviceorder.vo;

import cn.acsm.module.service.controller.admin.customerlist.vo.CustomerListCreateReqVO;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 服务交易单创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ServiceOrderCreateReqVO extends ServiceOrderBaseVO {

    @ApiModelProperty(value = "客户List")
    private List<CustomerListCreateReqVO> customerLists;

}
