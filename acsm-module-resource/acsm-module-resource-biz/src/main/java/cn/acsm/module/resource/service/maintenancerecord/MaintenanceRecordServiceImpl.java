package cn.acsm.module.resource.service.maintenancerecord;

import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordCreateReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordExportReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordPageReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.resource.dal.dataobject.maintenancerecord.MaintenanceRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.resource.convert.maintenancerecord.MaintenanceRecordConvert;
import cn.acsm.module.resource.dal.mysql.maintenancerecord.MaintenanceRecordMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.resource.enums.ErrorCodeConstants.*;

/**
 * 服务资源-养护记录 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class MaintenanceRecordServiceImpl implements MaintenanceRecordService {

    @Resource
    private MaintenanceRecordMapper maintenanceRecordMapper;

    @Override
    public Long createMaintenanceRecord(MaintenanceRecordCreateReqVO createReqVO) {
        // 插入
        MaintenanceRecordDO maintenanceRecord = MaintenanceRecordConvert.INSTANCE.convert(createReqVO);
        maintenanceRecordMapper.insert(maintenanceRecord);
        // 返回
        return maintenanceRecord.getId();
    }

    @Override
    public void updateMaintenanceRecord(MaintenanceRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMaintenanceRecordExists(updateReqVO.getId());
        // 更新
        MaintenanceRecordDO updateObj = MaintenanceRecordConvert.INSTANCE.convert(updateReqVO);
        maintenanceRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteMaintenanceRecord(Long id) {
        // 校验存在
        this.validateMaintenanceRecordExists(id);
        // 删除
        maintenanceRecordMapper.deleteById(id);
    }

    private void validateMaintenanceRecordExists(Long id) {
        if (maintenanceRecordMapper.selectById(id) == null) {
            throw exception(MAINTENANCE_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public MaintenanceRecordDO getMaintenanceRecord(Long id) {
        return maintenanceRecordMapper.selectById(id);
    }

    @Override
    public List<MaintenanceRecordDO> getMaintenanceRecordList(Collection<Long> ids) {
        return maintenanceRecordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MaintenanceRecordDO> getMaintenanceRecordPage(MaintenanceRecordPageReqVO pageReqVO) {
        return maintenanceRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MaintenanceRecordDO> getMaintenanceRecordList(MaintenanceRecordExportReqVO exportReqVO) {
        return maintenanceRecordMapper.selectList(exportReqVO);
    }

}
