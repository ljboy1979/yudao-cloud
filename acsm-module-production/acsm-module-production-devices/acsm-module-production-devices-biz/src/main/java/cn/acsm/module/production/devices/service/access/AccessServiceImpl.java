package cn.acsm.module.production.devices.service.access;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.devices.controller.admin.access.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.access.AccessDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.devices.convert.access.AccessConvert;
import cn.acsm.module.production.devices.dal.mysql.access.AccessMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;

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
    public void updateAccess(AccessUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAccessExists(updateReqVO.getId());
        // 更新
        AccessDO updateObj = AccessConvert.INSTANCE.convert(updateReqVO);
        accessMapper.updateById(updateObj);
    }

    @Override
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
