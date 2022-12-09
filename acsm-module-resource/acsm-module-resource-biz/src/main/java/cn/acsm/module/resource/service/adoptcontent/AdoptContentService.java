package cn.acsm.module.resource.service.adoptcontent;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.resource.controller.admin.adoptcontent.vo.*;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptcontent.AdoptContentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 认养物/租凭物 Service 接口
 *
 * @author smile
 */
public interface AdoptContentService {

    /**
     * 创建认养物/租凭物
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAdoptContent(@Valid AdoptContentCreateReqVO createReqVO);

    /**
     * 更新认养物/租凭物
     *
     * @param updateReqVO 更新信息
     */
    void updateAdoptContent(@Valid AdoptContentUpdateReqVO updateReqVO);

    /**
     * 删除认养物/租凭物
     *
     * @param id 编号
     */
    void deleteAdoptContent(Long id);

    /**
     * 获得认养物/租凭物
     *
     * @param id 编号
     * @return 认养物/租凭物
     */
    AdoptContentDO getAdoptContent(Long id);

    /**
     * 获得认养物/租凭物列表
     *
     * @param ids 编号
     * @return 认养物/租凭物列表
     */
    List<AdoptContentDO> getAdoptContentList(Collection<Long> ids);

    /**
     * 获得认养物/租凭物分页
     *
     * @param pageReqVO 分页查询
     * @return 认养物/租凭物分页
     */
    PageResult<AdoptContentDO> getAdoptContentPage(AdoptContentPageReqVO pageReqVO);

    /**
     * 获得认养物/租凭物列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 认养物/租凭物列表
     */
    List<AdoptContentDO> getAdoptContentList(AdoptContentExportReqVO exportReqVO);

    /**
     * 导入认养物
     *
     * @param list 导入数据
     * @return
     */
    String importRY(List<AdoptContentExcelRYVO> list);

    /**
     * 导入租凭物
     *
     * @param list 导入数据
     * @return
     */
    String importZP(List<AdoptContentExcelZPVO> list);

    /**
     * 获得没关联服务的认养物/租凭物列表
     *
     * @param type 资源类型字段（1-认养物；2-租赁物）
     * @param serviceId 服务id
     * @return
     */
    List<AdoptContentRespVO> listAdoptService(String type, String serviceId);

}
