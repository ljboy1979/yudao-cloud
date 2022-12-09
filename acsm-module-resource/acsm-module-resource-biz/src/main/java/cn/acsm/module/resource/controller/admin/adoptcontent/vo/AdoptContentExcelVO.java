package cn.acsm.module.resource.controller.admin.adoptcontent.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.experimental.Accessors;

/**
 * 认养物/租凭物 Excel VO
 *
 * @author smile
 */
@Data
@Accessors(chain = false)
public class AdoptContentExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("编号")
    private String adoptContentCode;

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("类型")
    private String type;

    @ExcelProperty("认养状态")
    private String adoptState;

    @ExcelProperty("关联地块")
    private String tunnelInfoId;

    @ExcelProperty("设施id")
    private String induFacilityInfoId;

    @ExcelProperty("植株/个体的id")
    private String tunnelPlanterId;

    @ExcelProperty("分类id")
    private String categoryId;

    @ExcelProperty("群体id")
    private String groupId;

}
