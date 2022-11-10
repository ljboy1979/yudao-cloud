package cn.acsm.module.user.user.dal.dataobject.memberuserinfo;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * 用户基本信息 DO
 *
 * @author lihongyan
 */
@TableName("member_user_info")
@KeySequence("member_user_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberUserInfoDO extends TenantBaseDO {

    /**
     * 用基本信息表ID
     */
    @TableId
    private Long id;
    /**
     * 用户表id
     */
    private String memberUserId;
    /**
     * 用户账号
     */
    private String username;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 住院号
     */
    private String inpatientNumber;
    /**
     * 体重
     */
    private String weight;
    /**
     * 身高
     */
    private String height;
    /**
     * 关联饮食医嘱表
     */
    private String medicalAdviceId;
    /**
     * 床位号
     */
    private String bedNumber;
    /**
     * 紧急联系人
     */
    private String emergencyContact;
    /**
     * 紧急联系电话
     */
    private String emergencyPhone;
    /**
     * 订餐用户类型 0，普通用户 1，医生
     */
    private String type;
    /**
     * 工卡卡号
     */
    private String account;
    /**
     * 科室
     */
    private String department;
    /**
     * 分区
     */
    private String partition;
    /**
     * 楼号
     */
    private String building;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 房间号
     */
    private String room;
    /**
     * 身份证号
     */
    private String cardNum;
    /**
     * 性别(0女，1男)
     */
    private String sex;
    /**
     * 年龄
     */
    private String age;
    /**
     * 一屋一码主键ID
     */
    private String mealsAppletQrcodeId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 帐号状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 最后登录IP
     */
    private String loginIp;
    /**
     * 最后登录时间
     */
    private Date loginDate;

}
