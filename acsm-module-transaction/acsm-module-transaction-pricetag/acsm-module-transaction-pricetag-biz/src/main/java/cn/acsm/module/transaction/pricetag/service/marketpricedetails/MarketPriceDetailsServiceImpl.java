package cn.acsm.module.transaction.pricetag.service.marketpricedetails;

import cn.acsm.module.transaction.pricetag.api.dto.MarketPriceDetailsDto;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketprice.MarketPriceMapper;
import cn.acsm.module.transaction.pricetag.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketpricedetails.MarketPriceDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.pricetag.convert.marketpricedetails.MarketPriceDetailsConvert;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketpricedetails.MarketPriceDetailsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.pricetag.enums.ErrorCodeConstants.*;

/**
 * 市场价格明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MarketPriceDetailsServiceImpl implements MarketPriceDetailsService {

    @Resource
    private MarketPriceDetailsMapper marketPriceDetailsMapper;

    @Resource
    private MarketPriceMapper marketPriceMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;

    @Override
    public String createMarketPriceDetails(MarketPriceDetailsCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("pricetag_market_price_details"+tenantId);
        // 插入
        MarketPriceDetailsDO marketPriceDetails = MarketPriceDetailsConvert.INSTANCE.convert(createReqVO);
        marketPriceDetails.setId(UUID.randomUUID().toString());
        marketPriceDetails.setPriceCode("MX"+number);
        marketPriceDetailsMapper.insert(marketPriceDetails);
        // 返回
        return marketPriceDetails.getId();
    }

    @Override
    public void updateMarketPriceDetails(MarketPriceDetailsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMarketPriceDetailsExists(updateReqVO.getId());
        // 更新
        MarketPriceDetailsDO updateObj = MarketPriceDetailsConvert.INSTANCE.convert(updateReqVO);
        marketPriceDetailsMapper.updateById(updateObj);
    }

    @Override
    public void deleteMarketPriceDetails(String id) {
        // 校验存在
        this.validateMarketPriceDetailsExists(id);
        // 删除
        marketPriceDetailsMapper.deleteById(id);
    }

    private void validateMarketPriceDetailsExists(String id) {
        if (marketPriceDetailsMapper.selectById(id) == null) {
            throw exception(MARKET_PRICE_DETAILS_NOT_EXISTS);
        }
    }

    @Override
    public MarketPriceDetailsDO getMarketPriceDetails(String id) {
        return marketPriceDetailsMapper.selectById(id);
    }

    @Override
    public List<MarketPriceDetailsDO> getMarketPriceDetailsList(Collection<String> ids) {
        return marketPriceDetailsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MarketPriceDetailsDO> getMarketPriceDetailsPage(MarketPriceDetailsPageReqVO pageReqVO) {
        return marketPriceDetailsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MarketPriceDetailsDO> getMarketPriceDetailsList(MarketPriceDetailsExportReqVO exportReqVO) {
        return marketPriceDetailsMapper.selectList(exportReqVO);
    }

    @Override
    public void saveMarketPriceDetails(MarketPriceDetailsDto marketPriceDetailsDto) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("pricetag_market_price_details"+tenantId);
        // 插入
        MarketPriceDetailsDO marketPriceDetails = MarketPriceDetailsConvert.INSTANCE.convertDto(marketPriceDetailsDto);
        marketPriceDetails.setId(UUID.randomUUID().toString());
        marketPriceDetails.setPriceCode("MX"+number);
        marketPriceDetailsMapper.insert(marketPriceDetails);
    }

    private void renewPrice(String id){
        MarketPriceDO marketPriceDO = marketPriceDetailsMapper.findPriceByPriceId(id);
        marketPriceDO.setId(id);
        marketPriceMapper.updateById(marketPriceDO);
    }

}
