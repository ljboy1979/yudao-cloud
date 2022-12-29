package cn.acsm.module.production.bases.service.consume;

import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeExportReqVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumePageReqVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeUpdateReqVO;
import cn.acsm.module.production.bases.convert.consume.ConsumeConvert;
import cn.acsm.module.production.bases.dal.dataobject.consume.ConsumeDO;
import cn.acsm.module.production.bases.dal.mysql.consume.ConsumeMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.CONSUME_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 基地能耗信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ConsumeServiceImpl implements ConsumeService {

    @Resource
    private ConsumeMapper consumeMapper;

    @Override
    public Long createConsume(ConsumeCreateReqVO createReqVO) {
        // 插入
        ConsumeDO consume = ConsumeConvert.INSTANCE.convert(createReqVO);
        consumeMapper.insert(consume);
        // 返回
        return consume.getId();
    }

    @Override
    @CacheEvict(value = "basesConsume", key = "#updateReqVO.id")
    public void updateConsume(ConsumeUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateConsumeExists(updateReqVO.getId());
        // 更新
        ConsumeDO updateObj = ConsumeConvert.INSTANCE.convert(updateReqVO);
        consumeMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "basesConsume", key = "#id")
    public void deleteConsume(Long id) {
        // 校验存在
        this.validateConsumeExists(id);
        // 删除
        consumeMapper.deleteById(id);
    }

    private void validateConsumeExists(Long id) {
        if (consumeMapper.selectById(id) == null) {
            throw exception(CONSUME_NOT_EXISTS);
        }
    }

    @Override
    public ConsumeDO getConsume(Long id) {
        return consumeMapper.selectById(id);
    }

    @Override
    @Cacheable(cacheNames = "basesConsume", key = "#id")
    public List<ConsumeDO> getConsumeList(Collection<Long> ids) {
        return consumeMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ConsumeDO> getConsumePage(ConsumePageReqVO pageReqVO) {
        return consumeMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ConsumeDO> getConsumeList(ConsumeExportReqVO exportReqVO) {
        return consumeMapper.selectList(exportReqVO);
    }

}
