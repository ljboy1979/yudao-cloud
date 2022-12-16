package cn.acsm.module.production.devices.service.alarminfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.alarminfo.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.alarminfo.AlarmInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 告警信息 Service 接口
 *
 * @author 芋道源码
 */
public interface AlarmInfoService {

    /**
     * 创建告警信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAlarmInfo(@Valid AlarmInfoCreateReqVO createReqVO);

    /**
     * 更新告警信息
     *
     * @param updateReqVO 更新信息
     */
    void updateAlarmInfo(@Valid AlarmInfoUpdateReqVO updateReqVO);

    /**
     * 删除告警信息
     *
     * @param id 编号
     */
    void deleteAlarmInfo(Long id);

    /**
     * 获得告警信息
     *
     * @param id 编号
     * @return 告警信息
     */
    AlarmInfoDO getAlarmInfo(Long id);

    /**
     * 获得告警信息列表
     *
     * @param ids 编号
     * @return 告警信息列表
     */
    List<AlarmInfoDO> getAlarmInfoList(Collection<Long> ids);

    /**
     * 获得告警信息分页
     *
     * @param pageReqVO 分页查询
     * @return 告警信息分页
     */
    PageResult<AlarmInfoDO> getAlarmInfoPage(AlarmInfoPageReqVO pageReqVO);

    /**
     * 获得告警信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 告警信息列表
     */
    List<AlarmInfoDO> getAlarmInfoList(AlarmInfoExportReqVO exportReqVO);

}
