package cn.acsm.module.stock.convert.recorddetail;

import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailCreateReqVO;
import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailExcelVO;
import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailRespVO;
import cn.acsm.module.stock.controller.admin.recorddetail.vo.StockRecordDetailUpdateReqVO;
import cn.acsm.module.stock.dal.dataobject.recorddetail.StockRecordDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 库存记录字表-明细 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface StockRecordDetailConvert {

    StockRecordDetailConvert INSTANCE = Mappers.getMapper(StockRecordDetailConvert.class);

    StockRecordDetailDO convert(StockRecordDetailCreateReqVO bean);

    StockRecordDetailDO convert(StockRecordDetailUpdateReqVO bean);

    StockRecordDetailRespVO convert(StockRecordDetailDO bean);

    List<StockRecordDetailRespVO> convertList(List<StockRecordDetailDO> list);

    PageResult<StockRecordDetailRespVO> convertPage(PageResult<StockRecordDetailDO> page);

    List<StockRecordDetailExcelVO> convertList02(List<StockRecordDetailDO> list);

}
