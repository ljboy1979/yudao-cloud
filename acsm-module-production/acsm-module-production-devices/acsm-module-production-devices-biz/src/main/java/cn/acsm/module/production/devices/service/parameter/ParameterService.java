package cn.acsm.module.production.devices.service.parameter;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.parameter.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.parameter.ParameterDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 设备表参数 Service 接口
 *
 * @author 芋道源码
 */
public interface ParameterService {

    /**
     * 创建设备表参数
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createParameter(@Valid ParameterCreateReqVO createReqVO);

    /**
     * 更新设备表参数
     *
     * @param updateReqVO 更新信息
     */
    void updateParameter(@Valid ParameterUpdateReqVO updateReqVO);

    /**
     * 删除设备表参数
     *
     * @param id 编号
     */
    void deleteParameter(Long id);

    /**
     * 获得设备表参数
     *
     * @param id 编号
     * @return 设备表参数
     */
    ParameterDO getParameter(Long id);

    /**
     * 获得设备表参数列表
     *
     * @param ids 编号
     * @return 设备表参数列表
     */
    List<ParameterDO> getParameterList(Collection<Long> ids);

    /**
     * 获得设备表参数分页
     *
     * @param pageReqVO 分页查询
     * @return 设备表参数分页
     */
    PageResult<ParameterDO> getParameterPage(ParameterPageReqVO pageReqVO);

    /**
     * 获得设备表参数列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设备表参数列表
     */
    List<ParameterDO> getParameterList(ParameterExportReqVO exportReqVO);

}
