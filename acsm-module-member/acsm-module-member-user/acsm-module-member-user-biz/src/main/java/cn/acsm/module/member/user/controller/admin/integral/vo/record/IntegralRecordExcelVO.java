package cn.acsm.module.member.user.controller.admin.integral.vo.record;

import cn.acsm.module.member.user.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.TIME_ZONE_DEFAULT;

/**
 * 会员积分记录 Excel VO
 *
 * @author lihongyan
 */
@Data
public class IntegralRecordExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("会员id")
    private Long memberId;

    @ExcelProperty("会员账号")
    private String memberAccount;

    @ExcelProperty("会员名称")
    private String memberName;

    @ExcelProperty(value = "评分项目", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MEMBER_RATING_ITEMS)
    private Long ratingItems;

    @ExcelProperty("本次积分变动")
    private String integralChange;

    @ExcelProperty("当前剩余积分")
    private String integralRemaining;

    @ExcelProperty("积分使用明细")
    private String integralUseDetails;

    @ExcelProperty("积分变动时间")
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private Date integralChangeTime;

    @ExcelProperty("图片")
    private String picture;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("评分分数")
    private String ratingScore;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
