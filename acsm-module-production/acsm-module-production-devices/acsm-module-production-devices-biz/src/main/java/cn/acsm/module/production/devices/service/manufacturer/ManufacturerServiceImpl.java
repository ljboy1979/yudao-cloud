package cn.acsm.module.production.devices.service.manufacturer;

import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.ManufacturerCreateReqVO;
import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.ManufacturerExportReqVO;
import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.ManufacturerPageReqVO;
import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.ManufacturerUpdateReqVO;
import cn.acsm.module.production.devices.convert.manufacturer.ManufacturerConvert;
import cn.acsm.module.production.devices.dal.dataobject.manufacturer.ManufacturerDO;
import cn.acsm.module.production.devices.dal.mysql.manufacturer.ManufacturerMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.MANUFACTURER_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 设备厂家 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ManufacturerServiceImpl implements ManufacturerService {

    @Resource
    private ManufacturerMapper manufacturerMapper;

    @Override
    public Long createManufacturer(ManufacturerCreateReqVO createReqVO) {
        // 插入
        ManufacturerDO manufacturer = ManufacturerConvert.INSTANCE.convert(createReqVO);
        manufacturerMapper.insert(manufacturer);
        // 返回
        return manufacturer.getId();
    }

    @Override
    @CacheEvict(value = "devices-manufacturer", key = "#updateReqVO.id")
    public void updateManufacturer(ManufacturerUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateManufacturerExists(updateReqVO.getId());
        // 更新
        ManufacturerDO updateObj = ManufacturerConvert.INSTANCE.convert(updateReqVO);
        manufacturerMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "devices-manufacturer", key = "#id")
    public void deleteManufacturer(Long id) {
        // 校验存在
        this.validateManufacturerExists(id);
        // 删除
        manufacturerMapper.deleteById(id);
    }

    private void validateManufacturerExists(Long id) {
        if (manufacturerMapper.selectById(id) == null) {
            throw exception(MANUFACTURER_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(value = "devices-manufacturer", key = "#id")
    public ManufacturerDO getManufacturer(Long id) {
        return manufacturerMapper.selectById(id);
    }

    @Override
    public List<ManufacturerDO> getManufacturerList(Collection<Long> ids) {
        return manufacturerMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ManufacturerDO> getManufacturerPage(ManufacturerPageReqVO pageReqVO) {
        return manufacturerMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ManufacturerDO> getManufacturerList(ManufacturerExportReqVO exportReqVO) {
        return manufacturerMapper.selectList(exportReqVO);
    }

}
