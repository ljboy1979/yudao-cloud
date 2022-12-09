package cn.acsm.module.service.service.ticketdetail;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.service.controller.admin.ticketdetail.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketdetail.TicketDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 套票详情 Service 接口
 *
 * @author smile
 */
public interface TicketDetailService {

    /**
     * 创建套票详情
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTicketDetail(@Valid TicketDetailCreateReqVO createReqVO);

    /**
     * 更新套票详情
     *
     * @param updateReqVO 更新信息
     */
    void updateTicketDetail(@Valid TicketDetailUpdateReqVO updateReqVO);

    /**
     * 删除套票详情
     *
     * @param id 编号
     */
    void deleteTicketDetail(Long id);

    /**
     * 获得套票详情
     *
     * @param id 编号
     * @return 套票详情
     */
    TicketDetailDO getTicketDetail(Long id);

    /**
     * 获得套票详情列表
     *
     * @param ids 编号
     * @return 套票详情列表
     */
    List<TicketDetailDO> getTicketDetailList(Collection<Long> ids);

    /**
     * 获得套票详情分页
     *
     * @param pageReqVO 分页查询
     * @return 套票详情分页
     */
    PageResult<TicketDetailDO> getTicketDetailPage(TicketDetailPageReqVO pageReqVO);

    /**
     * 获得套票详情列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 套票详情列表
     */
    List<TicketDetailDO> getTicketDetailList(TicketDetailExportReqVO exportReqVO);

}
