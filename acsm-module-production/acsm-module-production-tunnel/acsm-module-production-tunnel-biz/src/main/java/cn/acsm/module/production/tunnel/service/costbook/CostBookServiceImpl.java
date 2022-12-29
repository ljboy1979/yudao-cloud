package cn.acsm.module.production.tunnel.service.costbook;

import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.CostBookCreateReqVO;
import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.CostBookExportReqVO;
import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.CostBookPageReqVO;
import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.CostBookUpdateReqVO;
import cn.acsm.module.production.tunnel.convert.costbook.CostBookConvert;
import cn.acsm.module.production.tunnel.dal.dataobject.costbook.CostBookDO;
import cn.acsm.module.production.tunnel.dal.mysql.costbook.CostBookMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.tunnel.enums.ErrorCodeConstants.COST_BOOK_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 地块账本 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CostBookServiceImpl implements CostBookService {

    @Resource
    private CostBookMapper costBookMapper;

    @Override
    public Long createCostBook(CostBookCreateReqVO createReqVO) {
        // 插入
        CostBookDO costBook = CostBookConvert.INSTANCE.convert(createReqVO);
        costBookMapper.insert(costBook);
        // 返回
        return costBook.getId();
    }

    @Override
    @CacheEvict(value = "tunnel-costBook", key = "#updateReqVO.id")
    public void updateCostBook(CostBookUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCostBookExists(updateReqVO.getId());
        // 更新
        CostBookDO updateObj = CostBookConvert.INSTANCE.convert(updateReqVO);
        costBookMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "tunnel-costBook", key = "#id")
    public void deleteCostBook(Long id) {
        // 校验存在
        this.validateCostBookExists(id);
        // 删除
        costBookMapper.deleteById(id);
    }

    private void validateCostBookExists(Long id) {
        if (costBookMapper.selectById(id) == null) {
            throw exception(COST_BOOK_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "tunnel-costBook", key = "#id")
    public CostBookDO getCostBook(Long id) {
        return costBookMapper.selectById(id);
    }

    @Override
    public List<CostBookDO> getCostBookList(Collection<Long> ids) {
        return costBookMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CostBookDO> getCostBookPage(CostBookPageReqVO pageReqVO) {
        return costBookMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CostBookDO> getCostBookList(CostBookExportReqVO exportReqVO) {
        return costBookMapper.selectList(exportReqVO);
    }

}
