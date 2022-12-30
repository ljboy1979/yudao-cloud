package cn.acsm.module.production.facility.service.maintenance;

import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceCreateReqVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceExportReqVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenancePageReqVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceUpdateReqVO;
import cn.acsm.module.production.facility.convert.maintenance.MaintenanceConvert;
import cn.acsm.module.production.facility.dal.dataobject.maintenance.MaintenanceDO;
import cn.acsm.module.production.facility.dal.mysql.maintenance.MaintenanceMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.facility.enums.ErrorCodeConstants.MAINTENANCE_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 设施维护记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MaintenanceServiceImpl implements MaintenanceService {

    @Resource
    private MaintenanceMapper maintenanceMapper;

    @Override
    public Long createMaintenance(MaintenanceCreateReqVO createReqVO) {
        // 插入
        MaintenanceDO maintenance = MaintenanceConvert.INSTANCE.convert(createReqVO);
        maintenanceMapper.insert(maintenance);
        // 返回
        return maintenance.getId();
    }

    @Override
    public void updateMaintenance(MaintenanceUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMaintenanceExists(updateReqVO.getId());
        // 更新
        MaintenanceDO updateObj = MaintenanceConvert.INSTANCE.convert(updateReqVO);
        maintenanceMapper.updateById(updateObj);
    }

    @Override
    public void deleteMaintenance(Long id) {
        // 校验存在
        this.validateMaintenanceExists(id);
        // 删除
        maintenanceMapper.deleteById(id);
    }

    private void validateMaintenanceExists(Long id) {
        if (maintenanceMapper.selectById(id) == null) {
            throw exception(MAINTENANCE_NOT_EXISTS);
        }
    }

    @Override
    public MaintenanceDO getMaintenance(Long id) {
        return maintenanceMapper.selectById(id);
    }

    @Override
    public List<MaintenanceDO> getMaintenanceList(Collection<Long> ids) {
        return maintenanceMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MaintenanceDO> getMaintenancePage(MaintenancePageReqVO pageReqVO) {
        return maintenanceMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MaintenanceDO> getMaintenanceList(MaintenanceExportReqVO exportReqVO) {
        return maintenanceMapper.selectList(exportReqVO);
    }

}
