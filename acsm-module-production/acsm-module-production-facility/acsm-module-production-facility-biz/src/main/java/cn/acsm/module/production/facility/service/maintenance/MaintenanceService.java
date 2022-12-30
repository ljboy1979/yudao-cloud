package cn.acsm.module.production.facility.service.maintenance;

import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceCreateReqVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceExportReqVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenancePageReqVO;
import cn.acsm.module.production.facility.controller.admin.maintenance.vo.MaintenanceUpdateReqVO;
import cn.acsm.module.production.facility.dal.dataobject.maintenance.MaintenanceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 设施维护记录 Service 接口
 *
 * @author 芋道源码
 */
public interface MaintenanceService {

    /**
     * 创建设施维护记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMaintenance(@Valid MaintenanceCreateReqVO createReqVO);

    /**
     * 更新设施维护记录
     *
     * @param updateReqVO 更新信息
     */
    void updateMaintenance(@Valid MaintenanceUpdateReqVO updateReqVO);

    /**
     * 删除设施维护记录
     *
     * @param id 编号
     */
    void deleteMaintenance(Long id);

    /**
     * 获得设施维护记录
     *
     * @param id 编号
     * @return 设施维护记录
     */
    MaintenanceDO getMaintenance(Long id);

    /**
     * 获得设施维护记录列表
     *
     * @param ids 编号
     * @return 设施维护记录列表
     */
    List<MaintenanceDO> getMaintenanceList(Collection<Long> ids);

    /**
     * 获得设施维护记录分页
     *
     * @param pageReqVO 分页查询
     * @return 设施维护记录分页
     */
    PageResult<MaintenanceDO> getMaintenancePage(MaintenancePageReqVO pageReqVO);

    /**
     * 获得设施维护记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设施维护记录列表
     */
    List<MaintenanceDO> getMaintenanceList(MaintenanceExportReqVO exportReqVO);

}
