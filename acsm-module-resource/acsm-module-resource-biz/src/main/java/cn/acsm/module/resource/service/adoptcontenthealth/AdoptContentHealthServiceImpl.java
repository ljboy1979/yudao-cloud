package cn.acsm.module.resource.service.adoptcontenthealth;

import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.resource.dal.dataobject.adoptcontenthealth.AdoptContentHealthDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.resource.convert.adoptcontenthealth.AdoptContentHealthConvert;
import cn.acsm.module.resource.dal.mysql.adoptcontenthealth.AdoptContentHealthMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.resource.enums.ErrorCodeConstants.*;

/**
 * 服务资源-认养物/租凭物就医记录 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class AdoptContentHealthServiceImpl implements AdoptContentHealthService {

    @Resource
    private AdoptContentHealthMapper adoptContentHealthMapper;

    @Override
    public Long createAdoptContentHealth(AdoptContentHealthCreateReqVO createReqVO) {
        // 插入
        AdoptContentHealthDO adoptContentHealth = AdoptContentHealthConvert.INSTANCE.convert(createReqVO);
        adoptContentHealthMapper.insert(adoptContentHealth);
        // 返回
        return adoptContentHealth.getId();
    }

    @Override
    public void updateAdoptContentHealth(AdoptContentHealthUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAdoptContentHealthExists(updateReqVO.getId());
        // 更新
        AdoptContentHealthDO updateObj = AdoptContentHealthConvert.INSTANCE.convert(updateReqVO);
        adoptContentHealthMapper.updateById(updateObj);
    }

    @Override
    public void deleteAdoptContentHealth(Long id) {
        // 校验存在
        this.validateAdoptContentHealthExists(id);
        // 删除
        adoptContentHealthMapper.deleteById(id);
    }

    private void validateAdoptContentHealthExists(Long id) {
        if (adoptContentHealthMapper.selectById(id) == null) {
            throw exception(ADOPT_CONTENT_HEALTH_NOT_EXISTS);
        }
    }

    @Override
    public AdoptContentHealthDO getAdoptContentHealth(Long id) {
        return adoptContentHealthMapper.selectById(id);
    }

    @Override
    public List<AdoptContentHealthDO> getAdoptContentHealthList(Collection<Long> ids) {
        return adoptContentHealthMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AdoptContentHealthDO> getAdoptContentHealthPage(AdoptContentHealthPageReqVO pageReqVO) {
        return adoptContentHealthMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AdoptContentHealthDO> getAdoptContentHealthList(AdoptContentHealthExportReqVO exportReqVO) {
        return adoptContentHealthMapper.selectList(exportReqVO);
    }

}
