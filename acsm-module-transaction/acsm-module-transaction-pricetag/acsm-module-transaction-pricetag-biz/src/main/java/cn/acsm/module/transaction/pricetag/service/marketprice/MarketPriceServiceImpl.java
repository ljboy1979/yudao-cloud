package cn.acsm.module.transaction.pricetag.service.marketprice;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceInfoDO;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.PriceTrendDO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.pricetag.convert.marketprice.MarketPriceConvert;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketprice.MarketPriceMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.pricetag.enums.ErrorCodeConstants.*;

/**
 * 市场价格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MarketPriceServiceImpl implements MarketPriceService {

    @Resource
    private MarketPriceMapper marketPriceMapper;

    @Override
    public String createMarketPrice(MarketPriceCreateReqVO createReqVO) {
        // 插入
        MarketPriceDO marketPrice = MarketPriceConvert.INSTANCE.convert(createReqVO);
        marketPriceMapper.insert(marketPrice);
        // 返回
        return marketPrice.getId();
    }

    @Override
    public void updateMarketPrice(MarketPriceUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMarketPriceExists(updateReqVO.getId());
        // 更新
        MarketPriceDO updateObj = MarketPriceConvert.INSTANCE.convert(updateReqVO);
        marketPriceMapper.updateById(updateObj);
    }

    @Override
    public void deleteMarketPrice(String id) {
        // 校验存在
        this.validateMarketPriceExists(id);
        // 删除
        marketPriceMapper.deleteById(id);
    }

    private void validateMarketPriceExists(String id) {
        if (marketPriceMapper.selectById(id) == null) {
            throw exception(MARKET_PRICE_NOT_EXISTS);
        }
    }

    @Override
    public MarketPriceDO getMarketPrice(String id) {

        return marketPriceMapper.selectById(id);
    }

    @Override
    public List<MarketPriceDO> getMarketPriceList(Collection<String> ids) {
        return marketPriceMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MarketPriceDO> getMarketPricePage(MarketPricePageReqVO pageReqVO) {
        return marketPriceMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MarketPriceDO> getMarketPriceList(MarketPriceExportReqVO exportReqVO) {
        return marketPriceMapper.selectList(exportReqVO);
    }
    @Override
    public MarketPriceInfoVo getMarketPriceInfo(String id) {
        MarketPriceInfoDO marketPriceInfo =  marketPriceMapper.getMarketPriceInfo(id);
        MarketPriceInfoVo marketPriceInfoVo = MarketPriceConvert.INSTANCE.convertPriceInfoDO(marketPriceInfo);
        List<PriceTrendDO> priceTrendDOS = marketPriceMapper.findPriceTrend(id);
        List<PriceTrendVO> priceTrendVOS = MarketPriceConvert.INSTANCE.convertPriceTrendDO(priceTrendDOS);
        marketPriceInfoVo.setPriceTrendS(priceTrendVOS);
        return marketPriceInfoVo;
    }

}
