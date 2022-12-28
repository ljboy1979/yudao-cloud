package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * <pre>
 * 对象功能: StockRecordDetailPageVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/22
 * <pre>
 */
@ApiModel("管理后台 - 库存记录字表-打印 Request VO")
@Data
@ToString(callSuper = true)
public class StockRecordDetailPrintRespVO extends StockRecordDetailDO {

    /**
     * 所属部门名称
     */
    private String departmentName;

}
