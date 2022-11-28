package cn.iocoder.yudao.module.transaction.sales.controller.admin.inputclassify.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 投入品分类 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class InputClassifyExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("分类名称")
    private String categoryName;

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

    @ExcelProperty("0单条新增1批量新增")
    private String state;

    @ExcelProperty("图片路径")
    private String imgUrl;

    @ExcelProperty("排序序号")
    private String order;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
