package cn.acsm.module.service.service.serviceadoptinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceadoptinfo.ServiceAdoptInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.service.convert.serviceadoptinfo.ServiceAdoptInfoConvert;
import cn.acsm.module.service.dal.mysql.serviceadoptinfo.ServiceAdoptInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.service.enums.ErrorCodeConstants.*;

/**
 * 认养信息 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class ServiceAdoptInfoServiceImpl implements ServiceAdoptInfoService {

    @Resource
    private ServiceAdoptInfoMapper adoptInfoMapper;

    @Override
    public Long createAdoptInfo(ServiceAdoptInfoCreateReqVO createReqVO) {
        // 插入
        ServiceAdoptInfoDO adoptInfo = ServiceAdoptInfoConvert.INSTANCE.convert(createReqVO);
        adoptInfoMapper.insert(adoptInfo);
        // 返回
        return adoptInfo.getId();
    }

    @Override
    public void updateAdoptInfo(ServiceAdoptInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAdoptInfoExists(updateReqVO.getId());
        // 更新
        ServiceAdoptInfoDO updateObj = ServiceAdoptInfoConvert.INSTANCE.convert(updateReqVO);
        adoptInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteAdoptInfo(Long id) {
        // 校验存在
        this.validateAdoptInfoExists(id);
        // 删除
        adoptInfoMapper.deleteById(id);
    }

    private void validateAdoptInfoExists(Long id) {
        if (adoptInfoMapper.selectById(id) == null) {
            throw exception(ADOPT_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ServiceAdoptInfoDO getAdoptInfo(Long id) {
        return adoptInfoMapper.selectById(id);
    }

    @Override
    public List<ServiceAdoptInfoDO> getAdoptInfoList(Collection<Long> ids) {
        return adoptInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ServiceAdoptInfoDO> getAdoptInfoPage(ServiceAdoptInfoPageReqVO pageReqVO) {
        return adoptInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ServiceAdoptInfoDO> getAdoptInfoList(ServiceAdoptInfoExportReqVO exportReqVO) {
        return adoptInfoMapper.selectList(exportReqVO);
    }

}
