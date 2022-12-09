package cn.acsm.module.resource.service.adoptcontenthealth;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptcontenthealth.AdoptContentHealthDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 服务资源-认养物/租凭物就医记录 Service 接口
 *
 * @author smile
 */
public interface AdoptContentHealthService {

    /**
     * 创建服务资源-认养物/租凭物就医记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAdoptContentHealth(@Valid AdoptContentHealthCreateReqVO createReqVO);

    /**
     * 更新服务资源-认养物/租凭物就医记录
     *
     * @param updateReqVO 更新信息
     */
    void updateAdoptContentHealth(@Valid AdoptContentHealthUpdateReqVO updateReqVO);

    /**
     * 删除服务资源-认养物/租凭物就医记录
     *
     * @param id 编号
     */
    void deleteAdoptContentHealth(Long id);

    /**
     * 获得服务资源-认养物/租凭物就医记录
     *
     * @param id 编号
     * @return 服务资源-认养物/租凭物就医记录
     */
    AdoptContentHealthDO getAdoptContentHealth(Long id);

    /**
     * 获得服务资源-认养物/租凭物就医记录列表
     *
     * @param ids 编号
     * @return 服务资源-认养物/租凭物就医记录列表
     */
    List<AdoptContentHealthDO> getAdoptContentHealthList(Collection<Long> ids);

    /**
     * 获得服务资源-认养物/租凭物就医记录分页
     *
     * @param pageReqVO 分页查询
     * @return 服务资源-认养物/租凭物就医记录分页
     */
    PageResult<AdoptContentHealthDO> getAdoptContentHealthPage(AdoptContentHealthPageReqVO pageReqVO);

    /**
     * 获得服务资源-认养物/租凭物就医记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 服务资源-认养物/租凭物就医记录列表
     */
    List<AdoptContentHealthDO> getAdoptContentHealthList(AdoptContentHealthExportReqVO exportReqVO);

}
