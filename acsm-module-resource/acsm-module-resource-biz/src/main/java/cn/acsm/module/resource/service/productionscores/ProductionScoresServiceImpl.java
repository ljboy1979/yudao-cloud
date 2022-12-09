package cn.acsm.module.resource.service.productionscores;

import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresCreateReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresExportReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresPageReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresUpdateReqVO;
import cn.acsm.module.resource.dal.mysql.productionscores.ProductionScoresMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.resource.dal.dataobject.productionscores.ProductionScoresDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.resource.convert.productionscores.ProductionScoresConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.resource.enums.ErrorCodeConstants.*;

/**
 * 服务资源-生产品种 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class ProductionScoresServiceImpl implements ProductionScoresService {

    @Resource
    private ProductionScoresMapper productionScoresMapper;

    @Override
    public Long createProductionScores(ProductionScoresCreateReqVO createReqVO) {
        // 插入
        ProductionScoresDO productionScores = ProductionScoresConvert.INSTANCE.convert(createReqVO);
        productionScoresMapper.insert(productionScores);
        // 返回
        return productionScores.getId();
    }

    @Override
    public void updateProductionScores(ProductionScoresUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateProductionScoresExists(updateReqVO.getId());
        // 更新
        ProductionScoresDO updateObj = ProductionScoresConvert.INSTANCE.convert(updateReqVO);
        productionScoresMapper.updateById(updateObj);
    }

    @Override
    public void deleteProductionScores(Long id) {
        // 校验存在
        this.validateProductionScoresExists(id);
        // 删除
        productionScoresMapper.deleteById(id);
    }

    private void validateProductionScoresExists(Long id) {
        if (productionScoresMapper.selectById(id) == null) {
            throw exception(PRODUCTION_SCORES_NOT_EXISTS);
        }
    }

    @Override
    public ProductionScoresDO getProductionScores(Long id) {
        return productionScoresMapper.selectById(id);
    }

    @Override
    public List<ProductionScoresDO> getProductionScoresList(Collection<Long> ids) {
        return productionScoresMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ProductionScoresDO> getProductionScoresPage(ProductionScoresPageReqVO pageReqVO) {
        return productionScoresMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductionScoresDO> getProductionScoresList(ProductionScoresExportReqVO exportReqVO) {
        return productionScoresMapper.selectList(exportReqVO);
    }

}
