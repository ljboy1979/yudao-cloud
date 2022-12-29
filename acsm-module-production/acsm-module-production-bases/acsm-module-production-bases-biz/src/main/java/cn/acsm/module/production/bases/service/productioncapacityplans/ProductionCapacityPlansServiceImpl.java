package cn.acsm.module.production.bases.service.productioncapacityplans;

import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansExportReqVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansPageReqVO;
import cn.acsm.module.production.bases.controller.admin.productioncapacityplans.vo.ProductionCapacityPlansUpdateReqVO;
import cn.acsm.module.production.bases.convert.productioncapacityplans.ProductionCapacityPlansConvert;
import cn.acsm.module.production.bases.dal.dataobject.productioncapacityplans.ProductionCapacityPlansDO;
import cn.acsm.module.production.bases.dal.mysql.productioncapacityplans.ProductionCapacityPlansMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.PRODUCTION_CAPACITY_PLANS_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 产能计划 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ProductionCapacityPlansServiceImpl implements ProductionCapacityPlansService {

    @Resource
    private ProductionCapacityPlansMapper productionCapacityPlansMapper;

    @Override
    public Long createProductionCapacityPlans(ProductionCapacityPlansCreateReqVO createReqVO) {
        // 插入
        ProductionCapacityPlansDO productionCapacityPlans = ProductionCapacityPlansConvert.INSTANCE.convert(createReqVO);
        productionCapacityPlansMapper.insert(productionCapacityPlans);
        // 返回
        return productionCapacityPlans.getId();
    }

    @Override
    @CacheEvict(value = "basesProductionCapacity", key = "#updateReqVO.id")
    public void updateProductionCapacityPlans(ProductionCapacityPlansUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateProductionCapacityPlansExists(updateReqVO.getId());
        // 更新
        ProductionCapacityPlansDO updateObj = ProductionCapacityPlansConvert.INSTANCE.convert(updateReqVO);
        productionCapacityPlansMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "basesProductionCapacity", key = "#id")
    public void deleteProductionCapacityPlans(Long id) {
        // 校验存在
        this.validateProductionCapacityPlansExists(id);
        // 删除
        productionCapacityPlansMapper.deleteById(id);
    }

    private void validateProductionCapacityPlansExists(Long id) {
        if (productionCapacityPlansMapper.selectById(id) == null) {
            throw exception(PRODUCTION_CAPACITY_PLANS_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "basesProductionCapacity", key = "#id")
    public ProductionCapacityPlansDO getProductionCapacityPlans(Long id) {
        return productionCapacityPlansMapper.selectById(id);
    }

    @Override
    public List<ProductionCapacityPlansDO> getProductionCapacityPlansList(Collection<Long> ids) {
        return productionCapacityPlansMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ProductionCapacityPlansDO> getProductionCapacityPlansPage(ProductionCapacityPlansPageReqVO pageReqVO) {
        return productionCapacityPlansMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductionCapacityPlansDO> getProductionCapacityPlansList(ProductionCapacityPlansExportReqVO exportReqVO) {
        return productionCapacityPlansMapper.selectList(exportReqVO);
    }

}
