package cn.acsm.module.production.devices.service.model;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.model.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.model.ModelDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 设备型号 Service 接口
 *
 * @author 芋道源码
 */
public interface ModelService {

    /**
     * 创建设备型号
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createModel(@Valid ModelCreateReqVO createReqVO);

    /**
     * 更新设备型号
     *
     * @param updateReqVO 更新信息
     */
    void updateModel(@Valid ModelUpdateReqVO updateReqVO);

    /**
     * 删除设备型号
     *
     * @param id 编号
     */
    void deleteModel(Long id);

    /**
     * 获得设备型号
     *
     * @param id 编号
     * @return 设备型号
     */
    ModelDO getModel(Long id);

    /**
     * 获得设备型号列表
     *
     * @param ids 编号
     * @return 设备型号列表
     */
    List<ModelDO> getModelList(Collection<Long> ids);

    /**
     * 获得设备型号分页
     *
     * @param pageReqVO 分页查询
     * @return 设备型号分页
     */
    PageResult<ModelDO> getModelPage(ModelPageReqVO pageReqVO);

    /**
     * 获得设备型号列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设备型号列表
     */
    List<ModelDO> getModelList(ModelExportReqVO exportReqVO);

}
