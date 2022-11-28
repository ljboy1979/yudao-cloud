package cn.iocoder.yudao.module.transaction.sales.service.commoditysku;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commoditysku.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commoditysku.CommoditySkuDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.commoditysku.CommoditySkuConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.commoditysku.CommoditySkuMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.COMMODITY_SKU_NOT_EXISTS;

/**
 * 商品sku Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CommoditySkuServiceImpl implements CommoditySkuService {

    @Resource
    private CommoditySkuMapper commoditySkuMapper;

    @Override
    public String createCommoditySku(CommoditySkuCreateReqVO createReqVO) {
        // 插入
        CommoditySkuDO commoditySku = CommoditySkuConvert.INSTANCE.convert(createReqVO);
        commoditySkuMapper.insert(commoditySku);
        // 返回
        return commoditySku.getId();
    }

    @Override
    public void updateCommoditySku(CommoditySkuUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCommoditySkuExists(updateReqVO.getId());
        // 更新
        CommoditySkuDO updateObj = CommoditySkuConvert.INSTANCE.convert(updateReqVO);
        commoditySkuMapper.updateById(updateObj);
    }

    @Override
    public void deleteCommoditySku(String id) {
        // 校验存在
        this.validateCommoditySkuExists(id);
        // 删除
        commoditySkuMapper.deleteById(id);
    }

    private void validateCommoditySkuExists(String id) {
        if (commoditySkuMapper.selectById(id) == null) {
            throw exception(COMMODITY_SKU_NOT_EXISTS);
        }
    }

    @Override
    public CommoditySkuDO getCommoditySku(String id) {
        return commoditySkuMapper.selectById(id);
    }

    @Override
    public List<CommoditySkuDO> getCommoditySkuList(Collection<String> ids) {
        return commoditySkuMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommoditySkuDO> getCommoditySkuPage(CommoditySkuPageReqVO pageReqVO) {
        return commoditySkuMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommoditySkuDO> getCommoditySkuList(CommoditySkuExportReqVO exportReqVO) {
        return commoditySkuMapper.selectList(exportReqVO);
    }

}
