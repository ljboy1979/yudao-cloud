package cn.acsm.module.production.devices.service.access;

import cn.acsm.module.production.devices.controller.admin.access.vo.AccessCreateReqVO;
import cn.acsm.module.production.devices.controller.admin.access.vo.AccessExportReqVO;
import cn.acsm.module.production.devices.controller.admin.access.vo.AccessPageReqVO;
import cn.acsm.module.production.devices.controller.admin.access.vo.AccessUpdateReqVO;
import cn.acsm.module.production.devices.convert.access.AccessConvert;
import cn.acsm.module.production.devices.dal.dataobject.access.AccessDO;
import cn.acsm.module.production.devices.dal.mysql.access.AccessMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.ACCESS_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 设备允许访问名单信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AccessServiceImpl implements AccessService {

    @Resource
    private AccessMapper accessMapper;

    @Override
    public Long createAccess(AccessCreateReqVO createReqVO) {
        // 插入
        AccessDO access = AccessConvert.INSTANCE.convert(createReqVO);
        accessMapper.insert(access);
        // 返回
        return access.getId();
    }

    @Override
    @CacheEvict(value = "devicesAccess", key = "#updateReqVO.id")
    public void updateAccess(AccessUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAccessExists(updateReqVO.getId());
        // 更新
        AccessDO updateObj = AccessConvert.INSTANCE.convert(updateReqVO);
        accessMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "devicesAccess", key = "#id")
    public void deleteAccess(Long id) {
        // 校验存在
        this.validateAccessExists(id);
        // 删除
        accessMapper.deleteById(id);
    }

    private void validateAccessExists(Long id) {
        if (accessMapper.selectById(id) == null) {
            throw exception(ACCESS_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "devicesAccess", key = "#id")
    public AccessDO getAccess(Long id) {
        return accessMapper.selectById(id);
    }

    @Override
    public List<AccessDO> getAccessList(Collection<Long> ids) {
        return accessMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AccessDO> getAccessPage(AccessPageReqVO pageReqVO) {
        return accessMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AccessDO> getAccessList(AccessExportReqVO exportReqVO) {
        return accessMapper.selectList(exportReqVO);
    }

}
