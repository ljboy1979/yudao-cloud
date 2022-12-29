package cn.acsm.module.production.tunnel.service.infosoilenv;

import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.InfoSoilEnvCreateReqVO;
import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.InfoSoilEnvExportReqVO;
import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.InfoSoilEnvPageReqVO;
import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.InfoSoilEnvUpdateReqVO;
import cn.acsm.module.production.tunnel.convert.infosoilenv.InfoSoilEnvConvert;
import cn.acsm.module.production.tunnel.dal.dataobject.infosoilenv.InfoSoilEnvDO;
import cn.acsm.module.production.tunnel.dal.mysql.infosoilenv.InfoSoilEnvMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.tunnel.enums.ErrorCodeConstants.INFO_SOIL_ENV_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 地块土壤环境 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InfoSoilEnvServiceImpl implements InfoSoilEnvService {

    @Resource
    private InfoSoilEnvMapper infoSoilEnvMapper;

    @Override
    public Long createInfoSoilEnv(InfoSoilEnvCreateReqVO createReqVO) {
        // 插入
        InfoSoilEnvDO infoSoilEnv = InfoSoilEnvConvert.INSTANCE.convert(createReqVO);
        infoSoilEnvMapper.insert(infoSoilEnv);
        // 返回
        return infoSoilEnv.getId();
    }

    @Override
    @CacheEvict(value = "tunnel-infoSoilEnv", key = "#updateReqVO.id")
    public void updateInfoSoilEnv(InfoSoilEnvUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInfoSoilEnvExists(updateReqVO.getId());
        // 更新
        InfoSoilEnvDO updateObj = InfoSoilEnvConvert.INSTANCE.convert(updateReqVO);
        infoSoilEnvMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "tunnel-infoSoilEnv", key = "#id")
    public void deleteInfoSoilEnv(Long id) {
        // 校验存在
        this.validateInfoSoilEnvExists(id);
        // 删除
        infoSoilEnvMapper.deleteById(id);
    }

    private void validateInfoSoilEnvExists(Long id) {
        if (infoSoilEnvMapper.selectById(id) == null) {
            throw exception(INFO_SOIL_ENV_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "tunnel-infoSoilEnv", key = "#updateReqVO.id")
    public InfoSoilEnvDO getInfoSoilEnv(Long id) {
        return infoSoilEnvMapper.selectById(id);
    }

    @Override
    public List<InfoSoilEnvDO> getInfoSoilEnvList(Collection<Long> ids) {
        return infoSoilEnvMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InfoSoilEnvDO> getInfoSoilEnvPage(InfoSoilEnvPageReqVO pageReqVO) {
        return infoSoilEnvMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InfoSoilEnvDO> getInfoSoilEnvList(InfoSoilEnvExportReqVO exportReqVO) {
        return infoSoilEnvMapper.selectList(exportReqVO);
    }

}
