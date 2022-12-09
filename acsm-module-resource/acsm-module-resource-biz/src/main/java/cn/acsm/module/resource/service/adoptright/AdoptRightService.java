package cn.acsm.module.resource.service.adoptright;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptright.AdoptRightDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 认养/租凭权益 Service 接口
 *
 * @author smile
 */
public interface AdoptRightService {

    /**
     * 创建认养/租凭权益
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAdoptRight(@Valid AdoptRightCreateReqVO createReqVO);

    /**
     * 更新认养/租凭权益
     *
     * @param updateReqVO 更新信息
     */
    void updateAdoptRight(@Valid AdoptRightUpdateReqVO updateReqVO);

    /**
     * 删除认养/租凭权益
     *
     * @param id 编号
     */
    void deleteAdoptRight(Long id);

    /**
     * 获得认养/租凭权益
     *
     * @param id 编号
     * @return 认养/租凭权益
     */
    AdoptRightDO getAdoptRight(Long id);

    /**
     * 获得认养/租凭权益列表
     *
     * @param ids 编号
     * @return 认养/租凭权益列表
     */
    List<AdoptRightDO> getAdoptRightList(Collection<Long> ids);

    /**
     * 获得认养/租凭权益分页
     *
     * @param pageReqVO 分页查询
     * @return 认养/租凭权益分页
     */
    PageResult<AdoptRightDO> getAdoptRightPage(AdoptRightPageReqVO pageReqVO);

    /**
     * 获得认养/租凭权益列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 认养/租凭权益列表
     */
    List<AdoptRightDO> getAdoptRightList(AdoptRightExportReqVO exportReqVO);

}
