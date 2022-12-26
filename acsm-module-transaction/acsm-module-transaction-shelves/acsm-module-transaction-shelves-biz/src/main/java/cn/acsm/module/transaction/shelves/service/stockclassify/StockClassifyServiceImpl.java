package cn.acsm.module.transaction.shelves.service.stockclassify;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockclassify.StockClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.shelves.convert.stockclassify.StockClassifyConvert;
import cn.acsm.module.transaction.shelves.dal.mysql.stockclassify.StockClassifyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.shelves.enums.ErrorCodeConstants.*;

/**
 * 库存分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class StockClassifyServiceImpl implements StockClassifyService {

    @Resource
    private StockClassifyMapper stockClassifyMapper;

    @Override
    public String createStockClassify(StockClassifyCreateReqVO createReqVO) {
        if (StringUtils.isNotEmpty(createReqVO.getParentCode())) {
            StockClassifyDO parenMarketClassify = stockClassifyMapper.selectById(createReqVO.getParentCode());
            createReqVO.setParentCodes(parenMarketClassify.getParentCodes()+createReqVO.getParentCode()+",");
            createReqVO.setTreeSort(new BigDecimal(0));
            createReqVO.setTreeSorts(parenMarketClassify.getTreeSorts()+"0,");
            createReqVO.setTreeLeaf("0");
            createReqVO.setTreeLevel(parenMarketClassify.getTreeLevel().add(new BigDecimal(1)));
            createReqVO.setTreeNames(parenMarketClassify.getTreeNames()+"/"+createReqVO.getClassifyName());
        }else {
            createReqVO.setParentCode("0");
            createReqVO.setParentCodes("0,");
            createReqVO.setTreeSort(new BigDecimal(0));
            createReqVO.setTreeSorts("0,");
            createReqVO.setTreeLeaf("0");
            createReqVO.setTreeLevel(new BigDecimal(0));
            createReqVO.setTreeNames(createReqVO.getClassifyName());
        }
        Integer uuid=UUID.randomUUID().toString().replaceAll("-","").hashCode();
        uuid = uuid < 0 ? -uuid : uuid;
        // 插入
        StockClassifyDO stockClassify = StockClassifyConvert.INSTANCE.convert(createReqVO);
        stockClassify.setId(uuid.toString());
        stockClassifyMapper.insert(stockClassify);
        // 返回
        return stockClassify.getId();
    }

    @Override
    public void updateStockClassify(StockClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateStockClassifyExists(updateReqVO.getId());
        // 更新
        StockClassifyDO updateObj = StockClassifyConvert.INSTANCE.convert(updateReqVO);
        stockClassifyMapper.updateById(updateObj);
    }

    @Override
    public void deleteStockClassify(String id) {
        // 校验存在
        this.validateStockClassifyExists(id);
        // 删除
        stockClassifyMapper.deleteById(id);
    }

    private void validateStockClassifyExists(String id) {
        if (stockClassifyMapper.selectById(id) == null) {
            throw exception(STOCK_CLASSIFY_NOT_EXISTS);
        }
    }

    @Override
    public StockClassifyDO getStockClassify(String id) {
        return stockClassifyMapper.selectById(id);
    }

    @Override
    public List<StockClassifyDO> getStockClassifyList(Collection<String> ids) {
        return stockClassifyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<StockClassifyDO> getStockClassifyPage(StockClassifyPageReqVO pageReqVO) {
        return stockClassifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<StockClassifyDO> getStockClassifyList(StockClassifyExportReqVO exportReqVO) {
        return stockClassifyMapper.selectList(exportReqVO);
    }

    @Override
    public List<TreeSelect> findTreeList(StockClassifyTreeVO stockClassifyTreeVO) {
        List<StockClassifyDO> rawMaterialClassifyDOS =  stockClassifyMapper.selectListToTree(stockClassifyTreeVO);
        List< StockClassifyTreeVO > areaTreeVos = rawMaterialClassifyDOS.stream().map(o -> StockClassifyConvert.convertListToTree(o)).collect(Collectors.toList());
        List<TreeSelect> treeSelects = TreeUtils.buildTreeSelect(areaTreeVos);
        return treeSelects;
    }

}
