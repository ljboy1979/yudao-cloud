package cn.acsm.module.service.service.activitysession;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.service.controller.admin.activitysession.vo.*;
import cn.acsm.module.service.dal.dataobject.activitysession.ActivitySessionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 时间排期 Service 接口
 *
 * @author smile
 */
public interface ActivitySessionService {

    /**
     * 创建时间排期
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createActivitySession(@Valid ActivitySessionCreateReqVO createReqVO);

    /**
     * 更新时间排期
     *
     * @param updateReqVO 更新信息
     */
    void updateActivitySession(@Valid ActivitySessionUpdateReqVO updateReqVO);

    /**
     * 删除时间排期
     *
     * @param id 编号
     */
    void deleteActivitySession(Long id);

    /**
     * 获得时间排期
     *
     * @param id 编号
     * @return 时间排期
     */
    ActivitySessionDO getActivitySession(Long id);

    /**
     * 获得时间排期列表
     *
     * @param ids 编号
     * @return 时间排期列表
     */
    List<ActivitySessionDO> getActivitySessionList(Collection<Long> ids);

    /**
     * 获得时间排期分页
     *
     * @param pageReqVO 分页查询
     * @return 时间排期分页
     */
    PageResult<ActivitySessionDO> getActivitySessionPage(ActivitySessionPageReqVO pageReqVO);

    /**
     * 获得时间排期列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 时间排期列表
     */
    List<ActivitySessionDO> getActivitySessionList(ActivitySessionExportReqVO exportReqVO);

}
