package cn.acsm.module.production.devices.service.model;

import cn.acsm.module.production.devices.controller.admin.model.vo.ModelCreateReqVO;
import cn.acsm.module.production.devices.controller.admin.model.vo.ModelExportReqVO;
import cn.acsm.module.production.devices.controller.admin.model.vo.ModelPageReqVO;
import cn.acsm.module.production.devices.controller.admin.model.vo.ModelUpdateReqVO;
import cn.acsm.module.production.devices.convert.model.ModelConvert;
import cn.acsm.module.production.devices.dal.dataobject.model.ModelDO;
import cn.acsm.module.production.devices.dal.mysql.model.ModelMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.MODEL_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 设备型号 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ModelServiceImpl implements ModelService {

    @Resource
    private ModelMapper modelMapper;

    @Override
    public Long createModel(ModelCreateReqVO createReqVO) {
        // 插入
        ModelDO model = ModelConvert.INSTANCE.convert(createReqVO);
        modelMapper.insert(model);
        // 返回
        return model.getId();
    }

    @Override
    @CacheEvict(value = "device-model", key = "#updateReqVO.id")
    public void updateModel(ModelUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateModelExists(updateReqVO.getId());
        // 更新
        ModelDO updateObj = ModelConvert.INSTANCE.convert(updateReqVO);
        modelMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "device-model", key = "#id")
    public void deleteModel(Long id) {
        // 校验存在
        this.validateModelExists(id);
        // 删除
        modelMapper.deleteById(id);
    }

    private void validateModelExists(Long id) {
        if (modelMapper.selectById(id) == null) {
            throw exception(MODEL_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "device-model", key = "#id")
    public ModelDO getModel(Long id) {
        return modelMapper.selectById(id);
    }

    @Override
    public List<ModelDO> getModelList(Collection<Long> ids) {
        return modelMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ModelDO> getModelPage(ModelPageReqVO pageReqVO) {
        return modelMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ModelDO> getModelList(ModelExportReqVO exportReqVO) {
        return modelMapper.selectList(exportReqVO);
    }

}
