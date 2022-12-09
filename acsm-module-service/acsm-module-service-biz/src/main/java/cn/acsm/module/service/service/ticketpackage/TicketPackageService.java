package cn.acsm.module.service.service.ticketpackage;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.service.controller.admin.ticketpackage.vo.*;
import cn.acsm.module.service.dal.dataobject.ticketpackage.TicketPackageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 套票 Service 接口
 *
 * @author smile
 */
public interface TicketPackageService {

    /**
     * 创建套票
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTicketPackage(@Valid TicketPackageCreateReqVO createReqVO);

    /**
     * 更新套票
     *
     * @param updateReqVO 更新信息
     */
    void updateTicketPackage(@Valid TicketPackageUpdateReqVO updateReqVO);

    /**
     * 删除套票
     *
     * @param id 编号
     */
    void deleteTicketPackage(Long id);

    /**
     * 获得套票
     *
     * @param id 编号
     * @return 套票
     */
    TicketPackageDO getTicketPackage(Long id);

    /**
     * 获得套票列表
     *
     * @param ids 编号
     * @return 套票列表
     */
    List<TicketPackageDO> getTicketPackageList(Collection<Long> ids);

    /**
     * 获得套票分页
     *
     * @param pageReqVO 分页查询
     * @return 套票分页
     */
    PageResult<TicketPackageRespVO> getTicketPackagePage(TicketPackagePageReqVO pageReqVO);

    /**
     * 获得套票列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 套票列表
     */
    List<TicketPackageDO> getTicketPackageList(TicketPackageExportReqVO exportReqVO);

    /**
     * 创建套票关联服务
     *
     * @param createReqVO 创建套票关联服务信息
     * @return string
     */
    String createTicketPackageService(@Valid TicketPackageUpdateReqVO createReqVO);

    /**
     * 删除套票关联服务
     *
     * @param reqVO 删除套票关联服务信息
     * @return string
     */
    String deleteTicketPackageService(@Valid TicketPackageUpdateReqVO reqVO);

}
