package cn.acsm.module.wallet.controller.admin.wallet.vo;

import lombok.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 钱包交易记录子创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransactionHistoryCreateReqVO extends TransactionHistoryBaseVO {

}
