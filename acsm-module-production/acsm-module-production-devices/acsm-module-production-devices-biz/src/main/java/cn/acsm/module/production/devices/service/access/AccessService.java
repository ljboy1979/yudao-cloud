package cn.acsm.module.production.devices.service.access;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.access.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.access.AccessDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 设备允许访问名单信息 Service 接口
 *
 * @author 芋道源码
 */
public interface AccessService {

    /**
     * 创建设备允许访问名单信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAccess(@Valid AccessCreateReqVO createReqVO);

    /**
     * 更新设备允许访问名单信息
     *
     * @param updateReqVO 更新信息
     */
    void updateAccess(@Valid AccessUpdateReqVO updateReqVO);

    /**
     * 删除设备允许访问名单信息
     *
     * @param id 编号
     */
    void deleteAccess(Long id);

    /**
     * 获得设备允许访问名单信息
     *
     * @param id 编号
     * @return 设备允许访问名单信息
     */
    AccessDO getAccess(Long id);

    /**
     * 获得设备允许访问名单信息列表
     *
     * @param ids 编号
     * @return 设备允许访问名单信息列表
     */
    List<AccessDO> getAccessList(Collection<Long> ids);

    /**
     * 获得设备允许访问名单信息分页
     *
     * @param pageReqVO 分页查询
     * @return 设备允许访问名单信息分页
     */
    PageResult<AccessDO> getAccessPage(AccessPageReqVO pageReqVO);

    /**
     * 获得设备允许访问名单信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设备允许访问名单信息列表
     */
    List<AccessDO> getAccessList(AccessExportReqVO exportReqVO);

}
