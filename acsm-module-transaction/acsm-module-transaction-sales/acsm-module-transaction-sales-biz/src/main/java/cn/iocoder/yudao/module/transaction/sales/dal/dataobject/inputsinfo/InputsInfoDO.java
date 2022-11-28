package cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputsinfo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 投入品 DO
 *
 * @author 芋道源码
 */
@TableName("sales_inputs_info")
@KeySequence("sales_inputs_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputsInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 类型(农药,化肥,物料,种子)
     */
    private String inputsType;
    /**
     * 投入品名称
     */
    private String inputsName;
    /**
     * 种类
     */
    private String inputsKind;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 有效成分
     */
    private String activeIngredients;
    /**
     * 包装规格
     */
    private String packingSpecification;
    /**
     * 产品剂型
     */
    private String productDosageForm;
    /**
     * picture
     */
    private String picture;
    /**
     * 每亩最高用量
     */
    private BigDecimal standardUse;
    /**
     * 标准用量
     */
    private BigDecimal unitConsumption;
    /**
     * 条形码
     */
    private String barCode;
    /**
     * 包装类型
     */
    private String packagingType;
    /**
     * 计量单位
     */
    private String measureUnit;
    /**
     * 状态（0正常 1不可修改）
     */
    private String state;
    /**
     * 单位
     */
    private String unit;
    /**
     * 数量
     */
    private String num;
    /**
     * 采购价（单价）
     */
    private BigDecimal purchasePrice;
    /**
     * 供应商
     */
    private String supplier;
    /**
     * 安全期
     */
    private Integer secureDays;
    /**
     * 项目类型
     */
    private String projectType;
    /**
     * 投入品编码
     */
    private String inputsCode;
    /**
     * 投入品批次号
     */
    private String inputsBatch;
    /**
     * 单位名称
     */
    private String unitNames;
    /**
     * 包装规格名称
     */
    private String packingSpecificationNames;
    /**
     * 中华水产专用，图片，多张逗号隔开
     */
    private String inputsinfoImage;
    /**
     * 供应商
     */
    private String refactsupplier;
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

    /**
     * 专家建议
     */
    private String expertAdvice;
}
