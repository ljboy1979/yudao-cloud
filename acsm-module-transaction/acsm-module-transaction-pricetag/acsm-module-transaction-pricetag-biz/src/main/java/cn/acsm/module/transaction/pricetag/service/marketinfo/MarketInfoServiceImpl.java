package cn.acsm.module.transaction.pricetag.service.marketinfo;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.MarketPriceDO;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketprice.MarketPriceMapper;
import cn.acsm.module.transaction.pricetag.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketinfo.MarketInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.pricetag.convert.marketinfo.MarketInfoConvert;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketinfo.MarketInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.pricetag.enums.ErrorCodeConstants.*;

/**
 * 市场信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MarketInfoServiceImpl implements MarketInfoService {

    @Resource
    private MarketInfoMapper marketInfoMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;

    @Resource
    private MarketPriceMapper marketPriceMapper;

    @Override
    @Transactional
    public String createMarketInfo(MarketInfoCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("pricetag_market_info"+tenantId);
        // 插入
        MarketInfoDO marketInfo = MarketInfoConvert.INSTANCE.convert(createReqVO);
        marketInfo.setId(UUID.randomUUID().toString());
        marketInfo.setMarketCode("SC"+number);
        marketInfoMapper.insert(marketInfo);
        number = configNumberUtil.getNumber("pricetag_market_price"+tenantId);
        MarketPriceDO marketPriceDO = new MarketPriceDO();
        marketPriceDO.setId(UUID.randomUUID().toString());
        marketPriceDO.setCode("JG"+number);
        marketPriceDO.setMarketCommodityId(marketInfo.getId());
        marketPriceDO.setMaxPrice(0F);
        marketPriceDO.setMiddlePrice(0F);
        marketPriceDO.setMinPrice(0F);
        marketPriceDO.setMarketId(marketInfo.getId());
        marketPriceDO.setSubjectId(marketInfo.getSubjectId());
        marketPriceDO.setSource(marketInfo.getSource());
        marketPriceMapper.insert(marketPriceDO);
        // 返回
        return marketInfo.getId();
    }

    @Override
    public void updateMarketInfo(MarketInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMarketInfoExists(updateReqVO.getId());
        // 更新
        MarketInfoDO updateObj = MarketInfoConvert.INSTANCE.convert(updateReqVO);
        marketInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteMarketInfo(String id) {
        // 校验存在
        this.validateMarketInfoExists(id);
        // 删除
        marketInfoMapper.deleteById(id);
    }

    private void validateMarketInfoExists(String id) {
        if (marketInfoMapper.selectById(id) == null) {
            throw exception(MARKET_INFO_NOT_EXISTS);
        }
    }

    @Override
    public MarketInfoDO getMarketInfo(String id) {
        return marketInfoMapper.selectById(id);
    }

    @Override
    public List<MarketInfoDO> getMarketInfoList(Collection<String> ids) {
        return marketInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MarketInfoDO> getMarketInfoPage(MarketInfoPageReqVO pageReqVO) {
        return marketInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MarketInfoDO> getMarketInfoList(MarketInfoExportReqVO exportReqVO) {
        return marketInfoMapper.selectList(exportReqVO);
    }

}
