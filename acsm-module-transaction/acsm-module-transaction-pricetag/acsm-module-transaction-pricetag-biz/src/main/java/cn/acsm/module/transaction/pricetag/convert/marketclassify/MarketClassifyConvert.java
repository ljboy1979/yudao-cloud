package cn.acsm.module.transaction.pricetag.convert.marketclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketclassify.MarketClassifyDO;

/**
 * 市场分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketClassifyConvert {

    MarketClassifyConvert INSTANCE = Mappers.getMapper(MarketClassifyConvert.class);

    MarketClassifyDO convert(MarketClassifyCreateReqVO bean);

    MarketClassifyDO convert(MarketClassifyUpdateReqVO bean);

    MarketClassifyRespVO convert(MarketClassifyDO bean);

    List<MarketClassifyRespVO> convertList(List<MarketClassifyDO> list);

    PageResult<MarketClassifyRespVO> convertPage(PageResult<MarketClassifyDO> page);

    List<MarketClassifyExcelVO> convertList02(List<MarketClassifyDO> list);

    static MarketClassifyTreeVO convertListToTree(MarketClassifyDO bean) {
        MarketClassifyTreeVO stockClassifyTreeVO = new MarketClassifyTreeVO();
        stockClassifyTreeVO.setId(Long.valueOf(bean.getId()));
        stockClassifyTreeVO.setName(bean.getCategoryName());
        stockClassifyTreeVO.setParentId(Long.valueOf(bean.getParentCode()));
        stockClassifyTreeVO.setSort(bean.getTreeSort().intValue());
        return stockClassifyTreeVO;
    };

}
