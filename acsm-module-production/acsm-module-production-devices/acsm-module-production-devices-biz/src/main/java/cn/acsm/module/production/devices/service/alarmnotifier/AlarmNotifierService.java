package cn.acsm.module.production.devices.service.alarmnotifier;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.alarmnotifier.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarmnotifier.AlarmNotifierDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 告警通知规则 Service 接口
 *
 * @author 芋道源码
 */
public interface AlarmNotifierService {

    /**
     * 创建告警通知规则
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAlarmNotifier(@Valid AlarmNotifierCreateReqVO createReqVO);

    /**
     * 更新告警通知规则
     *
     * @param updateReqVO 更新信息
     */
    void updateAlarmNotifier(@Valid AlarmNotifierUpdateReqVO updateReqVO);

    /**
     * 删除告警通知规则
     *
     * @param id 编号
     */
    void deleteAlarmNotifier(Long id);

    /**
     * 获得告警通知规则
     *
     * @param id 编号
     * @return 告警通知规则
     */
    AlarmNotifierDO getAlarmNotifier(Long id);

    /**
     * 获得告警通知规则列表
     *
     * @param ids 编号
     * @return 告警通知规则列表
     */
    List<AlarmNotifierDO> getAlarmNotifierList(Collection<Long> ids);

    /**
     * 获得告警通知规则分页
     *
     * @param pageReqVO 分页查询
     * @return 告警通知规则分页
     */
    PageResult<AlarmNotifierDO> getAlarmNotifierPage(AlarmNotifierPageReqVO pageReqVO);

    /**
     * 获得告警通知规则列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 告警通知规则列表
     */
    List<AlarmNotifierDO> getAlarmNotifierList(AlarmNotifierExportReqVO exportReqVO);

}
