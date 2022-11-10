package cn.acsm.module.user.user.controller.app.memberuserinfo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("用户 APP - 用户基本信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMemberUserInfoCreateReqVO extends AppMemberUserInfoBaseVO {

}
