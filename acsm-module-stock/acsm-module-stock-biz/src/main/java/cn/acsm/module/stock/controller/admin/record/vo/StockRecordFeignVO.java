package cn.acsm.module.stock.controller.admin.record.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 获得库存信息分页 Request VO")
@Data
@ToString(callSuper = true)
public class StockRecordFeignVO implements Serializable {

    /**
     * 库存记录id
     */
    private Long id;
    /**
     * 库存类型(1.原料 2.投入品 3.成品 4.办公用品)
     */
    private Integer type;
    /**
     * 操作类型(0.入库 1.出库)
     */
    private Boolean operationType;
    /**
     * 仓库id
     */
    private String warehouseId;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date operationTime;
    /**
     * 负责人id
     */
    private Long headId;
    /**
     * 负责人名称
     */
    private String headName;
    /**
     * 部门id
     */
    private Long departmentId;
    /**
     * 部门名称
     */
    private String departmentName;
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
