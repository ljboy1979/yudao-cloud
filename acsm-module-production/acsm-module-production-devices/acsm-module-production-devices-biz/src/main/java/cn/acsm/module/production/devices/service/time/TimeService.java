package cn.acsm.module.production.devices.service.time;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.time.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.time.TimeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 设备运行时间 Service 接口
 *
 * @author 芋道源码
 */
public interface TimeService {

    /**
     * 创建设备运行时间
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createTime(@Valid TimeCreateReqVO createReqVO);

    /**
     * 更新设备运行时间
     *
     * @param updateReqVO 更新信息
     */
    void updateTime(@Valid TimeUpdateReqVO updateReqVO);

    /**
     * 删除设备运行时间
     *
     * @param id 编号
     */
    void deleteTime(Integer id);

    /**
     * 获得设备运行时间
     *
     * @param id 编号
     * @return 设备运行时间
     */
    TimeDO getTime(Integer id);

    /**
     * 获得设备运行时间列表
     *
     * @param ids 编号
     * @return 设备运行时间列表
     */
    List<TimeDO> getTimeList(Collection<Integer> ids);

    /**
     * 获得设备运行时间分页
     *
     * @param pageReqVO 分页查询
     * @return 设备运行时间分页
     */
    PageResult<TimeDO> getTimePage(TimePageReqVO pageReqVO);

    /**
     * 获得设备运行时间列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设备运行时间列表
     */
    List<TimeDO> getTimeList(TimeExportReqVO exportReqVO);

}
