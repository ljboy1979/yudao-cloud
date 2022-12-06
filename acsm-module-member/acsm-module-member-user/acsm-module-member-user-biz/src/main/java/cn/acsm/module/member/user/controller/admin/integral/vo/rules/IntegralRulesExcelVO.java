package cn.acsm.module.member.user.controller.admin.integral.vo.rules;

import cn.acsm.module.member.user.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 会员积分规则 Excel VO
 *
 * @author lihongyan
 */
@Data
public class IntegralRulesExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("企业id")
    private Long enterpriseId;

    @ExcelProperty("企业名称")
    private String enterpriseName;

    @ExcelProperty(value = "上级项目", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MEMBER_PARENT_PROJECT)
    private Long parentLevelProject;

    @ExcelProperty(value = "评分项目", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MEMBER_RATING_ITEMS)
    private Long ratingItems;

    @ExcelProperty("数值范围")
    private String rangeValues;

    @ExcelProperty("积分值")
    private String integralValue;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
