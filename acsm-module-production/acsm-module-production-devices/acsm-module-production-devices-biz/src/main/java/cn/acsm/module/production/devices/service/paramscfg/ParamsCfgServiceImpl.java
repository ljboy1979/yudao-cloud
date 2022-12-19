package cn.acsm.module.production.devices.service.paramscfg;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.devices.controller.admin.paramscfg.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.paramscfg.ParamsCfgDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.devices.convert.paramscfg.ParamsCfgConvert;
import cn.acsm.module.production.devices.dal.mysql.paramscfg.ParamsCfgMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;

/**
 * 设备参数配置 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ParamsCfgServiceImpl implements ParamsCfgService {

    @Resource
    private ParamsCfgMapper paramsCfgMapper;

    @Override
    public Long createParamsCfg(ParamsCfgCreateReqVO createReqVO) {
        // 插入
        ParamsCfgDO paramsCfg = ParamsCfgConvert.INSTANCE.convert(createReqVO);
        paramsCfgMapper.insert(paramsCfg);
        // 返回
        return paramsCfg.getId();
    }

    @Override
    public void updateParamsCfg(ParamsCfgUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateParamsCfgExists(updateReqVO.getId());
        // 更新
        ParamsCfgDO updateObj = ParamsCfgConvert.INSTANCE.convert(updateReqVO);
        paramsCfgMapper.updateById(updateObj);
    }

    @Override
    public void deleteParamsCfg(Long id) {
        // 校验存在
        this.validateParamsCfgExists(id);
        // 删除
        paramsCfgMapper.deleteById(id);
    }

    private void validateParamsCfgExists(Long id) {
        if (paramsCfgMapper.selectById(id) == null) {
            throw exception(PARAMS_CFG_NOT_EXISTS);
        }
    }

    @Override
    public ParamsCfgDO getParamsCfg(Long id) {
        return paramsCfgMapper.selectById(id);
    }

    @Override
    public List<ParamsCfgDO> getParamsCfgList(Collection<Long> ids) {
        return paramsCfgMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ParamsCfgDO> getParamsCfgPage(ParamsCfgPageReqVO pageReqVO) {
        return paramsCfgMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ParamsCfgDO> getParamsCfgList(ParamsCfgExportReqVO exportReqVO) {
        return paramsCfgMapper.selectList(exportReqVO);
    }

}
