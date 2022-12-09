package cn.acsm.module.resource.dal.dataobject.adoptcontentadoptprice;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 认养/租凭价格 DO
 *
 * @author smile
 */
@TableName("resource_adopt_content_adopt_price")
@KeySequence("resource_adopt_content_adopt_price_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptContentAdoptPriceDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 认养物的id
     */
    private String adoptId;
    /**
     * 认养物的名称
     */
    private String adoptName;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 认养费用
     */
    private BigDecimal adoptPriceFee;
    /**
     * 费用类型
     */
    private String feeType;
    /**
     * 认养人标签
     */
    private String adoptPersonFlag;
    /**
     * 权益价格的id
     */
    private String adoptRightId;
    /**
     * 付款人数
     */
    private String payNum;
    /**
     * 认养总数
     */
    private String adoptTotal;
    /**
     * 认养剩余名额
     */
    private String adoptQuota;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;
    /**
     * 经营主体id
     */
    private String subjectId;

}
