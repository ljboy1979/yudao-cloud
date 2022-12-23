package cn.acsm.module.stock.convert.inventoryrecord;

import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordCreateReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordExcelVO;
import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordRespVO;
import cn.acsm.module.stock.controller.admin.inventoryrecord.vo.StockInventoryRecordUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.inventoryrecord.StockInventoryRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 盘点记录 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface StockInventoryRecordConvert {

    StockInventoryRecordConvert INSTANCE = Mappers.getMapper(StockInventoryRecordConvert.class);

    StockInventoryRecordDO convert(StockInventoryRecordCreateReqVO bean);

    StockInventoryRecordDO convert(StockInventoryRecordUpdateReqVO bean);

    StockInventoryRecordRespVO convert(StockInventoryRecordDO bean);

    List<StockInventoryRecordRespVO> convertList(List<StockInventoryRecordDO> list);

    PageResult<StockInventoryRecordRespVO> convertPage(PageResult<StockInventoryRecordDO> page);

    List<StockInventoryRecordExcelVO> convertList02(List<StockInventoryRecordDO> list);

}
