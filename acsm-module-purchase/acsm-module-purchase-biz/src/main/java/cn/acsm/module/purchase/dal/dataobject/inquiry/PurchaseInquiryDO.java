package cn.acsm.module.purchase.dal.dataobject.inquiry;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * 采购询价 DO
 *
 * @author 芋道源码
 */
@TableName("purchase_inquiry")
@KeySequence("purchase_inquiry_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseInquiryDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 询价单编号
     */
    private String enquiryId;
    /**
     * 询价单名称
     */
    private String enquiryName;
    /**
     * 供应商id
     */
    private Long providerId;
    /**
     * 供应商名称
     */
    private String providerName;
    /**
     * 发布状态（0未发布 1已发布）
     */
    private String postStatus;
    /**
     * 询价情况（0已回复 1暂未回复）
     */
    private String enquiryStatus;
    /**
     * 发布时间
     */
    private Date releaseTime;
    /**
     * 是否阅读（0未读 1已读）
     */
    private String readStatus;
    /**
     * uid
     */
    private Long uid;
    /**
     * 经营主体
     */
    private String subjectId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 租户集合
     */
    private Long sourceId;

}
