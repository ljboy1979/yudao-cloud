package cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 货架库存记录创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordCreateReqVO extends StockRecordBaseVO {

}
