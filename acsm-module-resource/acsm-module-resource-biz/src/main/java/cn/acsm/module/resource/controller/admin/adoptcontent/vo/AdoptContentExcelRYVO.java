package cn.acsm.module.resource.controller.admin.adoptcontent.vo;

import cn.acsm.module.resource.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.checkerframework.checker.units.qual.Acceleration;

/**
 * 认养物 Excel VO
 *
 * @author smile
 */
@Data
@Accessors(chain = false)
public class AdoptContentExcelRYVO {

    @ExcelProperty("认养物编号")
    private String adoptContentCode;

    @ExcelProperty("认养物名称")
    private String name;

    @ExcelProperty(value = "认养方式(共享,私有)",converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ADOPT_WAY)
    private String adoptWay;

    @ExcelProperty(value = "认养物类型(地块,个体,设施,其他)",converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ADOPT_TYPE)
    private String type;

    @ExcelProperty(value = "认养状态(待认养,认养中,不可认养)",converter = DictConvert.class)
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

    @ExcelProperty(value = "认养物介绍")
    private String introduce;

}
