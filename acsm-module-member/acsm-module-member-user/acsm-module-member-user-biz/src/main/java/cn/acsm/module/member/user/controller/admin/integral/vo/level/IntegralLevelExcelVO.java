package cn.acsm.module.member.user.controller.admin.integral.vo.level;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 会员积分等级 Excel VO
 *
 * @author lihongyan
 */
@Data
public class IntegralLevelExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("企业id")
    private Long enterpriseId;

    @ExcelProperty("企业名称")
    private String enterpriseName;

    @ExcelProperty("会员等级")
    private String memberLevel;

    @ExcelProperty("积分阀值")
    private Integer integralThreshold;

    @ExcelProperty("等级优惠")
    private String levelDiscount;

    @ExcelProperty("等级描述")
    private String levelDescription;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
