package cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo;

import cn.acsm.module.transaction.pricetag.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 市场信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MarketInfoExcelVO {

//    @ExcelProperty("编号")
//    private String id;

    @ExcelProperty("市场编号")
    private String marketCode;

    @ExcelProperty("市场名称")
    private String marketName;

    @ExcelProperty("市场地址")
    private String marketAddress;

    @ExcelProperty("省")
    private String provCn;

    @ExcelProperty("市")
    private String cityCn;

    @ExcelProperty("区县")
    private String countyCn;

//    @ExcelProperty("经度")
//    private Double longitude;
//
//    @ExcelProperty("纬度")
//    private Double latitude;

    @ExcelProperty(value = "来源", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MARKET_SOURCE)
    private String source;

//    @ExcelProperty("状态")
//    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;
    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

//    @ExcelProperty("经营主体id")
//    private String subjectId;

}
