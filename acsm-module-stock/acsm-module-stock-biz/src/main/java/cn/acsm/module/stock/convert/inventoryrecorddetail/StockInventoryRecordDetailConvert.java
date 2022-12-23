package cn.acsm.module.stock.convert.inventoryrecorddetail;

import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailCreateReqVO;
import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailExcelVO;
import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailRespVO;
import cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo.StockInventoryRecordDetailUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.inventoryrecorddetail.StockInventoryRecordDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 盘点记录表子表-明细 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface StockInventoryRecordDetailConvert {

    StockInventoryRecordDetailConvert INSTANCE = Mappers.getMapper(StockInventoryRecordDetailConvert.class);

    StockInventoryRecordDetailDO convert(StockInventoryRecordDetailCreateReqVO bean);

    StockInventoryRecordDetailDO convert(StockInventoryRecordDetailUpdateReqVO bean);

    StockInventoryRecordDetailRespVO convert(StockInventoryRecordDetailDO bean);

    List<StockInventoryRecordDetailRespVO> convertList(List<StockInventoryRecordDetailDO> list);

    PageResult<StockInventoryRecordDetailRespVO> convertPage(PageResult<StockInventoryRecordDetailDO> page);

    List<StockInventoryRecordDetailExcelVO> convertList02(List<StockInventoryRecordDetailDO> list);

}
