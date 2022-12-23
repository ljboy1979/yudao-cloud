package cn.acsm.module.stock.convert.inventory;

import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryCreateReqVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryExcelVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryRespVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.StockInventoryUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 库存清单 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface StockInventoryConvert {

    StockInventoryConvert INSTANCE = Mappers.getMapper(StockInventoryConvert.class);

    StockInventoryDO convert(StockInventoryCreateReqVO bean);

    StockInventoryDO convert(StockInventoryUpdateReqVO bean);

    StockInventoryRespVO convert(StockInventoryDO bean);

    List<StockInventoryRespVO> convertList(List<StockInventoryDO> list);

    PageResult<StockInventoryRespVO> convertPage(PageResult<StockInventoryDO> page);

    List<StockInventoryExcelVO> convertList02(List<StockInventoryDO> list);
}
