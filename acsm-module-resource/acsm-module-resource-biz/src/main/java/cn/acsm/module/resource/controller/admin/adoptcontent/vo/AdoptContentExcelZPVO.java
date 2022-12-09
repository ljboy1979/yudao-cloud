package cn.acsm.module.resource.controller.admin.adoptcontent.vo;

import cn.acsm.module.resource.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 认养物 Excel VO
 *
 * @author smile
 */
@Data
@Accessors(chain = false)
public class AdoptContentExcelZPVO {

    @ExcelProperty("租凭物编号")
    private String adoptContentCode;

    @ExcelProperty("租凭物名称")
    private String name;

    @ExcelProperty(value = "租凭方式(共享,私有)",converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ADOPT_WAY)
    private String adoptWay;

    @ExcelProperty(value = "租凭物类型(地块,个体,设施,其他)",converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ADOPT_TYPE)
    private String type;

    @ExcelProperty(value = "租凭状态(待认养,认养中,不可认养)",converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ADOPT_STATE)
    private String adoptState;

    @ExcelProperty("关联地块")
    private String tunnelInfoId;

    @ExcelProperty("关联设施")
    private String induFacilityInfoId;

    @ExcelProperty("关联个体")
    private String tunnelPlanterId;

    @ExcelProperty("关联群体")
    private String groupId;

    @ExcelProperty("租凭物介绍")
    private String introduce;

}
