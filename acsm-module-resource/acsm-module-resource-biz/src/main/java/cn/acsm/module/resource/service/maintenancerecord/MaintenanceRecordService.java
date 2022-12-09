package cn.acsm.module.resource.service.maintenancerecord;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordCreateReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordExportReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordPageReqVO;
import cn.acsm.module.resource.controller.admin.maintenancerecord.vo.MaintenanceRecordUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.maintenancerecord.MaintenanceRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 服务资源-养护记录 Service 接口
 *
 * @author smile
 */
public interface MaintenanceRecordService {

    /**
     * 创建服务资源-养护记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMaintenanceRecord(@Valid MaintenanceRecordCreateReqVO createReqVO);

    /**
     * 更新服务资源-养护记录
     *
     * @param updateReqVO 更新信息
     */
    void updateMaintenanceRecord(@Valid MaintenanceRecordUpdateReqVO updateReqVO);

    /**
     * 删除服务资源-养护记录
     *
     * @param id 编号
     */
    void deleteMaintenanceRecord(Long id);

    /**
     * 获得服务资源-养护记录
     *
     * @param id 编号
     * @return 服务资源-养护记录
     */
    MaintenanceRecordDO getMaintenanceRecord(Long id);

    /**
     * 获得服务资源-养护记录列表
     *
     * @param ids 编号
     * @return 服务资源-养护记录列表
     */
    List<MaintenanceRecordDO> getMaintenanceRecordList(Collection<Long> ids);

    /**
     * 获得服务资源-养护记录分页
     *
     * @param pageReqVO 分页查询
     * @return 服务资源-养护记录分页
     */
    PageResult<MaintenanceRecordDO> getMaintenanceRecordPage(MaintenanceRecordPageReqVO pageReqVO);

    /**
     * 获得服务资源-养护记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 服务资源-养护记录列表
     */
    List<MaintenanceRecordDO> getMaintenanceRecordList(MaintenanceRecordExportReqVO exportReqVO);

}
