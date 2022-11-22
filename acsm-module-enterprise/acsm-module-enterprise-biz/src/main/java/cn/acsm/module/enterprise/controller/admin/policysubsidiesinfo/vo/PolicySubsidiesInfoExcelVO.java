package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 企业政策补贴信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PolicySubsidiesInfoExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty(value = "补贴种类", converter = DictConvert.class)
    @DictFormat("subsidies_category") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private String subsidiesCategory;

    @ExcelProperty("补贴名称")
    private String subsidiesName;

    @ExcelProperty(value = "补贴状态", converter = DictConvert.class)
    @DictFormat("subsidies_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer subsidiesStatus;

    @ExcelProperty("申请人")
    private String applyPerson;

    @ExcelProperty("申请时间")
    private Date applyTime;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("更新时间")
    private Date updateTime;

}
