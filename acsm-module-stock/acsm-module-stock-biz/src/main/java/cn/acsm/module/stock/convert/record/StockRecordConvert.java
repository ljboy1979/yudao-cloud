package cn.acsm.module.stock.convert.record;

import cn.acsm.module.stock.controller.admin.record.vo.StockRecordCreateReqVO;
import cn.acsm.module.stock.controller.admin.record.vo.StockRecordExcelVO;
import cn.acsm.module.stock.controller.admin.record.vo.StockRecordRespVO;
import cn.acsm.module.stock.controller.admin.record.vo.StockRecordUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.record.StockRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 库存记录 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface StockRecordConvert {

    StockRecordConvert INSTANCE = Mappers.getMapper(StockRecordConvert.class);

    StockRecordDO convert(StockRecordCreateReqVO bean);

    StockRecordDO convert(StockRecordUpdateReqVO bean);

    StockRecordRespVO convert(StockRecordDO bean);

    List<StockRecordRespVO> convertList(List<StockRecordDO> list);

    PageResult<StockRecordRespVO> convertPage(PageResult<StockRecordDO> page);

    List<StockRecordExcelVO> convertList02(List<StockRecordDO> list);

}
