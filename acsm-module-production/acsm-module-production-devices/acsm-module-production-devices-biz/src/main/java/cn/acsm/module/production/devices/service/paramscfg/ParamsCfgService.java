package cn.acsm.module.production.devices.service.paramscfg;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.paramscfg.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.paramscfg.ParamsCfgDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 设备参数配置 Service 接口
 *
 * @author 芋道源码
 */
public interface ParamsCfgService {

    /**
     * 创建设备参数配置
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createParamsCfg(@Valid ParamsCfgCreateReqVO createReqVO);

    /**
     * 更新设备参数配置
     *
     * @param updateReqVO 更新信息
     */
    void updateParamsCfg(@Valid ParamsCfgUpdateReqVO updateReqVO);

    /**
     * 删除设备参数配置
     *
     * @param id 编号
     */
    void deleteParamsCfg(Long id);

    /**
     * 获得设备参数配置
     *
     * @param id 编号
     * @return 设备参数配置
     */
    ParamsCfgDO getParamsCfg(Long id);

    /**
     * 获得设备参数配置列表
     *
     * @param ids 编号
     * @return 设备参数配置列表
     */
    List<ParamsCfgDO> getParamsCfgList(Collection<Long> ids);

    /**
     * 获得设备参数配置分页
     *
     * @param pageReqVO 分页查询
     * @return 设备参数配置分页
     */
    PageResult<ParamsCfgDO> getParamsCfgPage(ParamsCfgPageReqVO pageReqVO);

    /**
     * 获得设备参数配置列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设备参数配置列表
     */
    List<ParamsCfgDO> getParamsCfgList(ParamsCfgExportReqVO exportReqVO);

}
