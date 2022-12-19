package cn.acsm.module.purchase.api.quotation.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <pre>
 * 对象功能: QuotationReqDTO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/15
 * <pre>
 */
@ApiModel("管理后台 - 报价单信息 Response DTO")
@Data
public class QuotationReqDTO {

    /**
     * 编号
     */
    private Long id;

    /**
     * 创建人
     */
    private String creator;

}
