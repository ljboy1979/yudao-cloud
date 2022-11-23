package cn.iocoder.yudao.framework.excel.core.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import cn.hutool.json.JSONUtil;
import java.util.List;

public class ListStringConverter implements Converter<List> {

    @Override
    public Class<List> supportJavaTypeKey() {
        return List.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public List convertToJavaData(ReadCellData cellData, ExcelContentProperty excelContentProperty
            , GlobalConfiguration globalConfiguration)  {
        //从excel中读数据时被EasyExcel调用
        String stringValue = cellData.getStringValue();
        //用json转换工具将excel单元格中数据转换为java List<String>对象
        List<String> list = JSONUtil.toList(stringValue, String.class);
        return list;
    }

    @Override
    public WriteCellData convertToExcelData(List list, ExcelContentProperty excelContentProperty
            , GlobalConfiguration globalConfiguration) throws Exception {
        //写excel文件时被EasyExcel调用
        //用json转换工具将List对象转换为json字符串
        String json = JSONUtil.toJsonStr(list);
        return new WriteCellData(json);
    }
}
