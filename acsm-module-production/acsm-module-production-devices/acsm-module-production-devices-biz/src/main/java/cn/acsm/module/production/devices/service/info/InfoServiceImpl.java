package cn.acsm.module.production.devices.service.info;

import cn.acsm.module.production.devices.controller.admin.info.vo.InfoCreateReqVO;
import cn.acsm.module.production.devices.controller.admin.info.vo.InfoExportReqVO;
import cn.acsm.module.production.devices.controller.admin.info.vo.InfoPageReqVO;
import cn.acsm.module.production.devices.controller.admin.info.vo.InfoUpdateReqVO;
import cn.acsm.module.production.devices.convert.info.InfoConvert;
import cn.acsm.module.production.devices.dal.dataobject.info.InfoDO;
import cn.acsm.module.production.devices.dal.mysql.info.InfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 设备 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InfoServiceImpl implements InfoService {

    @Resource
    private InfoMapper infoMapper;

    @Override
    public Long createInfo(InfoCreateReqVO createReqVO) {
        // 插入
        InfoDO info = InfoConvert.INSTANCE.convert(createReqVO);
        infoMapper.insert(info);
        // 返回
        return info.getId();
    }

    @Override
    @CacheEvict(value = "device-info", key = "#updateReqVO.id")
    public void updateInfo(InfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInfoExists(updateReqVO.getId());
        // 更新
        InfoDO updateObj = InfoConvert.INSTANCE.convert(updateReqVO);
        infoMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "device-info", key = "#id")
    public void deleteInfo(Long id) {
        // 校验存在
        this.validateInfoExists(id);
        // 删除
        infoMapper.deleteById(id);
    }

    private void validateInfoExists(Long id) {
        if (infoMapper.selectById(id) == null) {
            throw exception(INFO_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "device-info", key = "#id")
    public InfoDO getInfo(Long id) {
        return infoMapper.selectById(id);
    }

    @Override
    public List<InfoDO> getInfoList(Collection<Long> ids) {
        return infoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InfoDO> getInfoPage(InfoPageReqVO pageReqVO) {
        return infoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InfoDO> getInfoList(InfoExportReqVO exportReqVO) {
        return infoMapper.selectList(exportReqVO);
    }

}
