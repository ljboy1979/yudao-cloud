package cn.acsm.module.wallet.controller.admin.wallet.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 钱包交易记录子更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransactionHistoryUpdateReqVO extends TransactionHistoryBaseVO {

    @ApiModelProperty(value = "主键ID", required = true)
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
