package cn.acsm.module.transaction.pricetag.service.marketcommodity;

import cn.acsm.module.transaction.pricetag.dal.mysql.marketcommodity.*;
import cn.acsm.module.transaction.pricetag.util.ConfigNumberUtil;
import cn.acsm.module.transaction.shelves.api.dto.PriceTagShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.PriceTagShelvesRespDto;
import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.acsm.module.transaction.shelves.api.shelves.PriceTagApi;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketcommodity.MarketCommodityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.pricetag.convert.marketcommodity.MarketCommodityConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.pricetag.enums.ErrorCodeConstants.*;

/**
 * 市场商品 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MarketCommodityServiceImpl implements MarketCommodityService {

    @Resource
    private MarketCommodityMapper marketCommodityMapper;
    @Resource
    private PriceTagApi priceTagApi;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public String createMarketCommodity(MarketCommodityCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("pricetag_market_commodity"+tenantId);
        // 插入
        MarketCommodityDO marketCommodity = MarketCommodityConvert.INSTANCE.convert(createReqVO);
        marketCommodity.setCommodityCode("SP"+number);
        marketCommodity.setId(UUID.randomUUID().toString());
        marketCommodityMapper.insert(marketCommodity);

        // 返回
        return marketCommodity.getId();
    }

    @Override
    public void updateMarketCommodity(MarketCommodityUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMarketCommodityExists(updateReqVO.getId());
        // 更新
        MarketCommodityDO updateObj = MarketCommodityConvert.INSTANCE.convert(updateReqVO);
        marketCommodityMapper.updateById(updateObj);
    }

    @Override
    public void deleteMarketCommodity(String id) {
        // 校验存在
        this.validateMarketCommodityExists(id);
        // 删除
        marketCommodityMapper.deleteById(id);
    }

    private void validateMarketCommodityExists(String id) {
        if (marketCommodityMapper.selectById(id) == null) {
            throw exception(MARKET_COMMODITY_NOT_EXISTS);
        }
    }

    @Override
    public MarketCommodityDO getMarketCommodity(String id) {
        return marketCommodityMapper.selectById(id);
    }

    @Override
    public List<MarketCommodityDO> getMarketCommodityList(Collection<String> ids) {
        return marketCommodityMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MarketCommodityDO> getMarketCommodityPage(MarketCommodityPageReqVO pageReqVO) {
        return marketCommodityMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MarketCommodityDO> getMarketCommodityList(MarketCommodityExportReqVO exportReqVO) {
        return marketCommodityMapper.selectList(exportReqVO);
    }

    @Override
    public List<PriceTagShelvesRespVo> findShelves(PriceTagShelvesReqVo shelvesReqVO) {
        PriceTagShelvesReqDto priceTagShelvesReqDto = MarketCommodityConvert.INSTANCE.convertShelvesReqDto(shelvesReqVO);
        CommonResult<List<PriceTagShelvesRespDto>>  result =  priceTagApi.findPriceTagShelves(priceTagShelvesReqDto);
        return  MarketCommodityConvert.INSTANCE.convertShelvesRespList(result.getData());
    }

    @Override
    public List<PriceTagShelvesRespVo> findSpecifications(PriceTagShelvesReqVo shelvesReqVO) {
        PriceTagShelvesReqDto priceTagShelvesReqDto = MarketCommodityConvert.INSTANCE.convertShelvesReqDto(shelvesReqVO);
        CommonResult<List<PriceTagShelvesRespDto>>  result =  priceTagApi.findPriceTagSpecifications(priceTagShelvesReqDto);
        return  MarketCommodityConvert.INSTANCE.convertShelvesRespList(result.getData());
    }

    @Override
    public List<TreeSelectVo> findTreeList(PriceTagShelvesReqVo shelvesReqVO) {
        PriceTagShelvesReqDto priceTagShelvesReqDto = MarketCommodityConvert.INSTANCE.convertShelvesReqDto(shelvesReqVO);
        CommonResult<List<TreeSelectDto>>  result =  priceTagApi.treeList(priceTagShelvesReqDto);
        return  MarketCommodityConvert.convertShelvesTreeRespList(result.getData());
    }

}
