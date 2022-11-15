package cn.acsm.module.wallet.convert.wallet;

import java.util.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryExcelVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryRespVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.TransactionHistoryUpdateReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.TransactionHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 钱包交易记录子 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface TransactionHistoryConvert {

    TransactionHistoryConvert INSTANCE = Mappers.getMapper(TransactionHistoryConvert.class);

    TransactionHistoryDO convert(TransactionHistoryCreateReqVO bean);

    TransactionHistoryDO convert(TransactionHistoryUpdateReqVO bean);

    TransactionHistoryRespVO convert(TransactionHistoryDO bean);

    List<TransactionHistoryRespVO> convertList(List<TransactionHistoryDO> list);

    PageResult<TransactionHistoryRespVO> convertPage(PageResult<TransactionHistoryDO> page);

    List<TransactionHistoryExcelVO> convertList02(List<TransactionHistoryDO> list);

}
