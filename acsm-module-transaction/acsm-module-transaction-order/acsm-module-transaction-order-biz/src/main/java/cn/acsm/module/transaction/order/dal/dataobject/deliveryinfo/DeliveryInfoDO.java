package cn.acsm.module.transaction.order.dal.dataobject.deliveryinfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 配送 DO
 *
 * @author 芋道源码
 */
@TableName("order_delivery_info")
@KeySequence("order_delivery_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfoDO extends BaseDO {

    /**
     * ID
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 配送编号
     */
    private String deliveryCode;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 货架id
     */
    private String shelvesId;
    /**
     * 计划id
     */
    private String planId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 配送状态(0未配送 1已配送 2配送装箱中)
     */
    private String sendStatus;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 来源
     */
    private String source;
    /**
     * 科室
     */
    private String department;
    /**
     * 床位号
     */
    private String bedNumber;
    /**
     * 地址
     */
    private String address;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 数量
     */
    private String num;
    /**
     * 配送时间
     */
    private Date deliveryTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 经营主体id
     */
    private String subjectId;

}
