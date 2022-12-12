package cn.iocoder.yudao.module.system.controller.admin.area.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 行政区划 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class AreaExcelVO {

    @ExcelProperty("区域编码")
    private String areaCode;

    @ExcelProperty("父级编号")
    private String parentCode;

    @ExcelProperty("所有父级编号")
    private String parentCodes;

    @ExcelProperty("本级排序号（升序）")
    private BigDecimal treeSort;

    @ExcelProperty("所有级别排序号")
    private String treeSorts;

    @ExcelProperty("是否最末级")
    private String treeLeaf;

    @ExcelProperty("层次级别")
    private BigDecimal treeLevel;

    @ExcelProperty("全节点名")
    private String treeNames;

    @ExcelProperty("区域名称")
    private String areaName;

    @ExcelProperty("区域类型")
    private String areaType;

    @ExcelProperty("状态")
    private String status;

    @ExcelProperty("是否删除")
    private Boolean deleted;

    @ExcelProperty("创建者")
    private String creator;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("更新者")
    private String updater;

    @ExcelProperty("更新时间")
    private Date updateTime;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("地区拼音")
    private String areaEn;

    @ExcelProperty("上")
    private Double top;

    @ExcelProperty("下")
    private Double bottom;

    @ExcelProperty("左")
    private Double left;

    @ExcelProperty("右")
    private Double right;

    @ExcelProperty("经度")
    private Double longitude;

    @ExcelProperty("纬度")
    private Double latitude;

    @ExcelProperty("行政区划id")
    private Long id;

}
