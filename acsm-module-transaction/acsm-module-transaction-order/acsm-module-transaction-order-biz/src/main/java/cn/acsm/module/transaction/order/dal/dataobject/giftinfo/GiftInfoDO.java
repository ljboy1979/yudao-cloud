package cn.acsm.module.transaction.order.dal.dataobject.giftinfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 赠品 DO
 *
 * @author 芋道源码
 */
@TableName("order_gift_info")
@KeySequence("order_gift_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftInfoDO extends BaseDO {

    /**
     * 赠品id
     */
    @TableId
    private Integer id;
    /**
     * 赠品编号
     */
    private String giftNumber;
    /**
     * 货品id
     */
    private String goodsId;
    /**
     * 赠品名称(套餐id)
     */
    private String giftName;
    /**
     * 数量
     */
    private String giftAmount;
    /**
     * 订单id
     */
    private String skuPackageOrderId;
    /**
     * 分类id
     */
    private String classifyId;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 计量单位
     */
    private String unit;
    /**
     * 计量单位名称
     */
    private String unitName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 经营主体id
     */
    private String subjectId;
    /**
     * source
     */
    private String source;

}
