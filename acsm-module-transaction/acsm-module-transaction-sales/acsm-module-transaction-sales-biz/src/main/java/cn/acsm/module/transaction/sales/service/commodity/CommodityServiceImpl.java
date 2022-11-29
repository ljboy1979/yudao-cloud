package cn.acsm.module.transaction.sales.service.commodity;

import cn.acsm.module.transaction.sales.service.commodity.CommodityService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.COMMODITY_NOT_EXISTS;

/**
 * 商品 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CommodityServiceImpl implements CommodityService {

    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public String createCommodity(CommodityCreateReqVO createReqVO) {
        // 插入
        CommodityDO commodity = CommodityConvert.INSTANCE.convert(createReqVO);
        commodityMapper.insert(commodity);
        // 返回
        return commodity.getId();
    }

    @Override
    public void updateCommodity(CommodityUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCommodityExists(updateReqVO.getId());
        // 更新
        CommodityDO updateObj = CommodityConvert.INSTANCE.convert(updateReqVO);
        commodityMapper.updateById(updateObj);
    }

    @Override
    public void deleteCommodity(String id) {
        // 校验存在
        this.validateCommodityExists(id);
        // 删除
        commodityMapper.deleteById(id);
    }

    private void validateCommodityExists(String id) {
        if (commodityMapper.selectById(id) == null) {
            throw exception(COMMODITY_NOT_EXISTS);
        }
    }

    @Override
    public CommodityDO getCommodity(String id) {
        return commodityMapper.selectById(id);
    }

    @Override
    public List<CommodityDO> getCommodityList(Collection<String> ids) {
        return commodityMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommodityDO> getCommodityPage(CommodityPageReqVO pageReqVO) {
        return commodityMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommodityDO> getCommodityList(CommodityExportReqVO exportReqVO) {
        return commodityMapper.selectList(exportReqVO);
    }

}
