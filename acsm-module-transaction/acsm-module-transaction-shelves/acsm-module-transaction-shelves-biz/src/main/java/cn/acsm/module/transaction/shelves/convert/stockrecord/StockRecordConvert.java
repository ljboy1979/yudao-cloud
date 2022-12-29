package cn.acsm.module.transaction.shelves.convert.stockrecord;

import java.util.*;

import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordDO;

/**
 * 货架库存记录 Convert
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

    PageResult<StockRecordRespVO> convertInfoPage(PageResult<StockRecordInfoDO> pageResult);
}
