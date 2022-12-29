package cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * 货架库存记录 DO
 *
 * @author 芋道源码
 */
@TableName("shelves_stock_record")
@KeySequence("shelves_stock_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRecordInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 货架规格id
     */
    private String specificationsId;
    /**
     * 货架规格名称
     */
    private String specificationsName;
    /**
     * 类型 0 上架 1下架 2销售 3报损 4退货
     */
    private String type;
    /**
     * 操作量
     */
    private BigDecimal amount;
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
