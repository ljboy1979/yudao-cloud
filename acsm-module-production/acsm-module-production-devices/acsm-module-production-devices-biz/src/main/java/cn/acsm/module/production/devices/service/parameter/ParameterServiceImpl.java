package cn.acsm.module.production.devices.service.parameter;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.devices.controller.admin.parameter.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.parameter.ParameterDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.devices.convert.parameter.ParameterConvert;
import cn.acsm.module.production.devices.dal.mysql.parameter.ParameterMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;

/**
 * 设备表参数 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ParameterServiceImpl implements ParameterService {

    @Resource
    private ParameterMapper parameterMapper;

    @Override
    public Long createParameter(ParameterCreateReqVO createReqVO) {
        // 插入
        ParameterDO parameter = ParameterConvert.INSTANCE.convert(createReqVO);
        parameterMapper.insert(parameter);
        // 返回
        return parameter.getId();
    }

    @Override
    public void updateParameter(ParameterUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateParameterExists(updateReqVO.getId());
        // 更新
        ParameterDO updateObj = ParameterConvert.INSTANCE.convert(updateReqVO);
        parameterMapper.updateById(updateObj);
    }

    @Override
    public void deleteParameter(Long id) {
        // 校验存在
        this.validateParameterExists(id);
        // 删除
        parameterMapper.deleteById(id);
    }

    private void validateParameterExists(Long id) {
        if (parameterMapper.selectById(id) == null) {
            throw exception(PARAMETER_NOT_EXISTS);
        }
    }

    @Override
    public ParameterDO getParameter(Long id) {
        return parameterMapper.selectById(id);
    }

    @Override
    public List<ParameterDO> getParameterList(Collection<Long> ids) {
        return parameterMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ParameterDO> getParameterPage(ParameterPageReqVO pageReqVO) {
        return parameterMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ParameterDO> getParameterList(ParameterExportReqVO exportReqVO) {
        return parameterMapper.selectList(exportReqVO);
    }

}
