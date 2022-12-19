package cn.acsm.module.production.devices.service.manufacturer;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.manufacturer.ManufacturerDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 设备厂家 Service 接口
 *
 * @author 芋道源码
 */
public interface ManufacturerService {

    /**
     * 创建设备厂家
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createManufacturer(@Valid ManufacturerCreateReqVO createReqVO);

    /**
     * 更新设备厂家
     *
     * @param updateReqVO 更新信息
     */
    void updateManufacturer(@Valid ManufacturerUpdateReqVO updateReqVO);

    /**
     * 删除设备厂家
     *
     * @param id 编号
     */
    void deleteManufacturer(Long id);

    /**
     * 获得设备厂家
     *
     * @param id 编号
     * @return 设备厂家
     */
    ManufacturerDO getManufacturer(Long id);

    /**
     * 获得设备厂家列表
     *
     * @param ids 编号
     * @return 设备厂家列表
     */
    List<ManufacturerDO> getManufacturerList(Collection<Long> ids);

    /**
     * 获得设备厂家分页
     *
     * @param pageReqVO 分页查询
     * @return 设备厂家分页
     */
    PageResult<ManufacturerDO> getManufacturerPage(ManufacturerPageReqVO pageReqVO);

    /**
     * 获得设备厂家列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设备厂家列表
     */
    List<ManufacturerDO> getManufacturerList(ManufacturerExportReqVO exportReqVO);

}
