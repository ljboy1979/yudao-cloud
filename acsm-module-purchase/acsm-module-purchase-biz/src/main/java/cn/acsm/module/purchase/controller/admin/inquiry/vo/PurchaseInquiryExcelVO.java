package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 采购询价 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseInquiryExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("询价单编号")
    private String enquiryId;

    @ExcelProperty("询价单名称")
    private String enquiryName;

    @ExcelProperty("供应商id")
    private Long providerId;

    @ExcelProperty("供应商名称")
    private String providerName;

    @ExcelProperty("发布状态（0未发布 1已发布）")
    private String postStatus;

    @ExcelProperty("询价情况（0已回复 1暂未回复）")
    private String enquiryStatus;

    @ExcelProperty("发布时间")
    private Date releaseTime;

    @ExcelProperty("是否阅读（0未读 1已读）")
    private String readStatus;

    @ExcelProperty("uid")
    private Long uid;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

    @ExcelProperty("用户id")
    private Long userId;

    @ExcelProperty("租户集合")
    private Long sourceId;

}
