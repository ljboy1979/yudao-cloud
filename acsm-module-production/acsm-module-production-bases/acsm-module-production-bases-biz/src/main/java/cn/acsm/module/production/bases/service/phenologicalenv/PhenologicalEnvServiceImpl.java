package cn.acsm.module.production.bases.service.phenologicalenv;

import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvExportReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvPageReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.phenologicalenv.PhenologicalEnvDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.bases.convert.phenologicalenv.PhenologicalEnvConvert;
import cn.acsm.module.production.bases.dal.mysql.phenologicalenv.PhenologicalEnvMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.*;

/**
 * 基地物候环境 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PhenologicalEnvServiceImpl implements PhenologicalEnvService {

    @Resource
    private PhenologicalEnvMapper phenologicalEnvMapper;

    @Override
    public Long createPhenologicalEnv(PhenologicalEnvCreateReqVO createReqVO) {
        // 插入
        PhenologicalEnvDO phenologicalEnv = PhenologicalEnvConvert.INSTANCE.convert(createReqVO);
        phenologicalEnvMapper.insert(phenologicalEnv);
        // 返回
        return phenologicalEnv.getId();
    }

    @Override
    public void updatePhenologicalEnv(PhenologicalEnvUpdateReqVO updateReqVO) {
        // 校验存在
        this.validatePhenologicalEnvExists(updateReqVO.getId());
        // 更新
        PhenologicalEnvDO updateObj = PhenologicalEnvConvert.INSTANCE.convert(updateReqVO);
        phenologicalEnvMapper.updateById(updateObj);
    }

    @Override
    public void deletePhenologicalEnv(Long id) {
        // 校验存在
        this.validatePhenologicalEnvExists(id);
        // 删除
        phenologicalEnvMapper.deleteById(id);
    }

    private void validatePhenologicalEnvExists(Long id) {
        if (phenologicalEnvMapper.selectById(id) == null) {
            throw exception(PHENOLOGICAL_ENV_NOT_EXISTS);
        }
    }

    @Override
    public PhenologicalEnvDO getPhenologicalEnv(Long id) {
        return phenologicalEnvMapper.selectById(id);
    }

    @Override
    public List<PhenologicalEnvDO> getPhenologicalEnvList(Collection<Long> ids) {
        return phenologicalEnvMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PhenologicalEnvDO> getPhenologicalEnvPage(PhenologicalEnvPageReqVO pageReqVO) {
        return phenologicalEnvMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PhenologicalEnvDO> getPhenologicalEnvList(PhenologicalEnvExportReqVO exportReqVO) {
        return phenologicalEnvMapper.selectList(exportReqVO);
    }

}
