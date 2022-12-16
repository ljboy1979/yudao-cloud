package cn.acsm.module.production.bases.service.soilenv;

import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvExportReqVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvPageReqVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.soilenv.SoilEnvDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.bases.convert.soilenv.SoilEnvConvert;
import cn.acsm.module.production.bases.dal.mysql.soilenv.SoilEnvMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.*;

/**
 * 基地土壤环境 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SoilEnvServiceImpl implements SoilEnvService {

    @Resource
    private SoilEnvMapper soilEnvMapper;

    @Override
    public Long createSoilEnv(SoilEnvCreateReqVO createReqVO) {
        // 插入
        SoilEnvDO soilEnv = SoilEnvConvert.INSTANCE.convert(createReqVO);
        soilEnvMapper.insert(soilEnv);
        // 返回
        return soilEnv.getId();
    }

    @Override
    public void updateSoilEnv(SoilEnvUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSoilEnvExists(updateReqVO.getId());
        // 更新
        SoilEnvDO updateObj = SoilEnvConvert.INSTANCE.convert(updateReqVO);
        soilEnvMapper.updateById(updateObj);
    }

    @Override
    public void deleteSoilEnv(Long id) {
        // 校验存在
        this.validateSoilEnvExists(id);
        // 删除
        soilEnvMapper.deleteById(id);
    }

    private void validateSoilEnvExists(Long id) {
        if (soilEnvMapper.selectById(id) == null) {
            throw exception(SOIL_ENV_NOT_EXISTS);
        }
    }

    @Override
    public SoilEnvDO getSoilEnv(Long id) {
        return soilEnvMapper.selectById(id);
    }

    @Override
    public List<SoilEnvDO> getSoilEnvList(Collection<Long> ids) {
        return soilEnvMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SoilEnvDO> getSoilEnvPage(SoilEnvPageReqVO pageReqVO) {
        return soilEnvMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SoilEnvDO> getSoilEnvList(SoilEnvExportReqVO exportReqVO) {
        return soilEnvMapper.selectList(exportReqVO);
    }

}
