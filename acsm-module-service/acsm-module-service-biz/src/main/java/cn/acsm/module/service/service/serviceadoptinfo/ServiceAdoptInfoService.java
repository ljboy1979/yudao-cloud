package cn.acsm.module.service.service.serviceadoptinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.service.controller.admin.serviceadoptinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceadoptinfo.ServiceAdoptInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 认养信息 Service 接口
 *
 * @author smile
 */
public interface ServiceAdoptInfoService {

    /**
     * 创建认养信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAdoptInfo(@Valid ServiceAdoptInfoCreateReqVO createReqVO);

    /**
     * 更新认养信息
     *
     * @param updateReqVO 更新信息
     */
    void updateAdoptInfo(@Valid ServiceAdoptInfoUpdateReqVO updateReqVO);

    /**
     * 删除认养信息
     *
     * @param id 编号
     */
    void deleteAdoptInfo(Long id);

    /**
     * 获得认养信息
     *
     * @param id 编号
     * @return 认养信息
     */
    ServiceAdoptInfoDO getAdoptInfo(Long id);

    /**
     * 获得认养信息列表
     *
     * @param ids 编号
     * @return 认养信息列表
     */
    List<ServiceAdoptInfoDO> getAdoptInfoList(Collection<Long> ids);

    /**
     * 获得认养信息分页
     *
     * @param pageReqVO 分页查询
     * @return 认养信息分页
     */
    PageResult<ServiceAdoptInfoDO> getAdoptInfoPage(ServiceAdoptInfoPageReqVO pageReqVO);

    /**
     * 获得认养信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 认养信息列表
     */
    List<ServiceAdoptInfoDO> getAdoptInfoList(ServiceAdoptInfoExportReqVO exportReqVO);

}
