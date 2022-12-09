package cn.acsm.module.service.service.serviceinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.service.controller.admin.serviceinfo.vo.*;
import cn.acsm.module.service.dal.dataobject.serviceinfo.ServiceInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 服务 Service 接口
 *
 * @author smile
 */
public interface ServiceInfoService {

    /**
     * 创建服务
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInfo(@Valid ServiceInfoCreateReqVO createReqVO);

    /**
     * 更新服务
     *
     * @param updateReqVO 更新信息
     */
    void updateInfo(@Valid ServiceInfoUpdateReqVO updateReqVO);

    /**
     * 删除服务
     *
     * @param id 编号
     */
    void deleteInfo(Long id);

    /**
     * 获得服务
     *
     * @param id 编号
     * @return 服务
     */
    ServiceInfoRespVO getInfo(Long id);

    /**
     * 获得服务列表
     *
     * @param ids 编号
     * @return 服务列表
     */
    List<ServiceInfoDO> getInfoList(Collection<Long> ids);

    /**
     * 获得服务分页
     *
     * @param pageReqVO 分页查询
     * @return 服务分页
     */
    PageResult<ServiceInfoRespVO> getInfoPage(ServiceInfoPageReqVO pageReqVO);

    /**
     * 获得服务列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 服务列表
     */
    List<ServiceInfoDO> getInfoList(ServiceInfoExportReqVO exportReqVO);

}
