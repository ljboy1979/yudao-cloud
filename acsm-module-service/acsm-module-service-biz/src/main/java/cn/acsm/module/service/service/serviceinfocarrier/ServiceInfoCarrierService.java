package cn.acsm.module.service.service.serviceinfocarrier;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.service.controller.admin.serviceinfocarrier.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfocarrier.ServiceInfoCarrierDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 服务-认养物/租凭物 Service 接口
 *
 * @author smile
 */
public interface ServiceInfoCarrierService {

    /**
     * 创建服务-认养物/租凭物
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInfoCarrier(@Valid ServiceInfoCarrierCreateReqVO createReqVO);

    /**
     * 更新服务-认养物/租凭物
     *
     * @param updateReqVO 更新信息
     */
    void updateInfoCarrier(@Valid ServiceInfoCarrierUpdateReqVO updateReqVO);

    /**
     * 删除服务-认养物/租凭物
     *
     * @param id 编号
     */
    void deleteInfoCarrier(Long id);

    /**
     * 获得服务-认养物/租凭物
     *
     * @param id 编号
     * @return 服务-认养物/租凭物
     */
    ServiceInfoCarrierDO getInfoCarrier(Long id);

    /**
     * 获得服务-认养物/租凭物列表
     *
     * @param ids 编号
     * @return 服务-认养物/租凭物列表
     */
    List<ServiceInfoCarrierDO> getInfoCarrierList(Collection<Long> ids);

    /**
     * 获得服务-认养物/租凭物分页
     *
     * @param pageReqVO 分页查询
     * @return 服务-认养物/租凭物分页
     */
    PageResult<ServiceInfoCarrierRespVO> getInfoCarrierPage(ServiceInfoCarrierPageReqVO pageReqVO);

    /**
     * 获得服务-认养物/租凭物列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 服务-认养物/租凭物列表
     */
    List<ServiceInfoCarrierDO> getInfoCarrierList(ServiceInfoCarrierExportReqVO exportReqVO);

}
