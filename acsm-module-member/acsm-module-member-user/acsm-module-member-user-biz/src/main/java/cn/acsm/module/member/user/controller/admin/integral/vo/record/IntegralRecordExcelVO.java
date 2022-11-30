package cn.acsm.module.member.user.controller.admin.integral.vo.record;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

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

    @ExcelProperty("评分项目")
    private Long ratingItems;

    @ExcelProperty("本次积分变动")
    private String integralChange;

    @ExcelProperty("当前剩余积分")
    private String integralRemaining;

    @ExcelProperty("积分使用明细")
    private String integralUseDetails;

    @ExcelProperty("积分变动时间")
    private Date integralChangeTime;

    @ExcelProperty("图片")
    private String picture;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
