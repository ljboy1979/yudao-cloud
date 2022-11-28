package cn.iocoder.yudao.module.transaction.sales.service.commodityspecification;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.transaction.sales.convert.commodityspecification.CommoditySpecificationConvert;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.commodityspecification.CommoditySpecificationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.*;

/**
 * 商品规格 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CommoditySpecificationServiceImpl implements CommoditySpecificationService {

    @Resource
    private CommoditySpecificationMapper commoditySpecificationMapper;

    @Override
    public String createCommoditySpecification(CommoditySpecificationCreateReqVO createReqVO) {
        // 插入
        CommoditySpecificationDO commoditySpecification = CommoditySpecificationConvert.INSTANCE.convert(createReqVO);
        commoditySpecificationMapper.insert(commoditySpecification);
        // 返回
        return commoditySpecification.getId();
    }

    @Override
    public void updateCommoditySpecification(CommoditySpecificationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCommoditySpecificationExists(updateReqVO.getId());
        // 更新
        CommoditySpecificationDO updateObj = CommoditySpecificationConvert.INSTANCE.convert(updateReqVO);
        commoditySpecificationMapper.updateById(updateObj);
    }

    @Override
    public void deleteCommoditySpecification(String id) {
        // 校验存在
        this.validateCommoditySpecificationExists(id);
        // 删除
        commoditySpecificationMapper.deleteById(id);
    }

    private void validateCommoditySpecificationExists(String id) {
        if (commoditySpecificationMapper.selectById(id) == null) {
            throw exception(COMMODITY_SPECIFICATION_NOT_EXISTS);
        }
    }

    @Override
    public CommoditySpecificationDO getCommoditySpecification(String id) {
        return commoditySpecificationMapper.selectById(id);
    }

    @Override
    public List<CommoditySpecificationDO> getCommoditySpecificationList(Collection<String> ids) {
        return commoditySpecificationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommoditySpecificationDO> getCommoditySpecificationPage(CommoditySpecificationPageReqVO pageReqVO) {
        return commoditySpecificationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommoditySpecificationDO> getCommoditySpecificationList(CommoditySpecificationExportReqVO exportReqVO) {
        return commoditySpecificationMapper.selectList(exportReqVO);
    }

}
