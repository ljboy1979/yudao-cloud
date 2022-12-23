package cn.acsm.module.transaction.pricetag.service.marketclassify;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketclassify.MarketClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.pricetag.convert.marketclassify.MarketClassifyConvert;
import cn.acsm.module.transaction.pricetag.dal.mysql.marketclassify.MarketClassifyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.pricetag.enums.ErrorCodeConstants.*;

/**
 * 市场分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MarketClassifyServiceImpl implements MarketClassifyService {

    @Resource
    private MarketClassifyMapper marketClassifyMapper;

    @Override
    public String createMarketClassify(MarketClassifyCreateReqVO createReqVO) {
        if (StringUtils.isNotEmpty(createReqVO.getParentCode())) {
            MarketClassifyDO parenMarketClassify = marketClassifyMapper.selectById(createReqVO.getParentCode());
            createReqVO.setParentCodes(parenMarketClassify.getParentCodes()+createReqVO.getParentCode()+",");
            createReqVO.setTreeSort(new BigDecimal(0));
            createReqVO.setTreeSorts(parenMarketClassify.getTreeSorts()+"0,");
            createReqVO.setTreeLeaf("0");
            createReqVO.setTreeLevel(parenMarketClassify.getTreeLevel().add(new BigDecimal(1)));
            createReqVO.setTreeNames(parenMarketClassify.getTreeNames()+"/"+createReqVO.getCategoryName());
        }else {
            createReqVO.setParentCode("0");
            createReqVO.setParentCodes("0,");
            createReqVO.setTreeSort(new BigDecimal(0));
            createReqVO.setTreeSorts("0,");
            createReqVO.setTreeLeaf("0");
            createReqVO.setTreeLevel(new BigDecimal(0));
            createReqVO.setTreeNames(createReqVO.getCategoryName());
        }
        // 插入
        MarketClassifyDO marketClassify = MarketClassifyConvert.INSTANCE.convert(createReqVO);
        marketClassify.setId(UUID.randomUUID().toString().replace("-",""));
        marketClassifyMapper.insert(marketClassify);
        // 返回
        return marketClassify.getId();
    }

    @Override
    public void updateMarketClassify(MarketClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMarketClassifyExists(updateReqVO.getId());
        // 更新
        MarketClassifyDO updateObj = MarketClassifyConvert.INSTANCE.convert(updateReqVO);
        marketClassifyMapper.updateById(updateObj);
    }

    @Override
    public void deleteMarketClassify(String id) {
        // 校验存在
        this.validateMarketClassifyExists(id);
        // 删除
        marketClassifyMapper.deleteById(id);
    }

    private void validateMarketClassifyExists(String id) {
        if (marketClassifyMapper.selectById(id) == null) {
            throw exception(MARKET_CLASSIFY_NOT_EXISTS);
        }
    }

    @Override
    public MarketClassifyDO getMarketClassify(String id) {
        return marketClassifyMapper.selectById(id);
    }

    @Override
    public List<MarketClassifyDO> getMarketClassifyList(Collection<String> ids) {
        return marketClassifyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MarketClassifyDO> getMarketClassifyPage(MarketClassifyPageReqVO pageReqVO) {
        return marketClassifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MarketClassifyDO> getMarketClassifyList(MarketClassifyExportReqVO exportReqVO) {
        return marketClassifyMapper.selectList(exportReqVO);
    }


    @Override
    public List<TreeSelect> findTreeList(MarketClassifyTreeVO marketClassifyTreeVO) {
        List<MarketClassifyDO> marketClassifyDOS =  marketClassifyMapper.selectListToTree(marketClassifyTreeVO);
        List< MarketClassifyTreeVO > areaTreeVos = marketClassifyDOS.stream().map(o -> MarketClassifyConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.buildTreeSelect(areaTreeVos);
        return treeSelects;
    }
}
