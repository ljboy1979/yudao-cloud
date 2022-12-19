package cn.acsm.module.production.bases.service.phenologicalenv;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvExportReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvPageReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.PhenologicalEnvUpdateReqVO;
import cn.acsm.module.production.bases.controller.admin.phenologicalenv.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.phenologicalenv.PhenologicalEnvDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 基地物候环境 Service 接口
 *
 * @author 芋道源码
 */
public interface PhenologicalEnvService {

    /**
     * 创建基地物候环境
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPhenologicalEnv(@Valid PhenologicalEnvCreateReqVO createReqVO);

    /**
     * 更新基地物候环境
     *
     * @param updateReqVO 更新信息
     */
    void updatePhenologicalEnv(@Valid PhenologicalEnvUpdateReqVO updateReqVO);

    /**
     * 删除基地物候环境
     *
     * @param id 编号
     */
    void deletePhenologicalEnv(Long id);

    /**
     * 获得基地物候环境
     *
     * @param id 编号
     * @return 基地物候环境
     */
    PhenologicalEnvDO getPhenologicalEnv(Long id);

    /**
     * 获得基地物候环境列表
     *
     * @param ids 编号
     * @return 基地物候环境列表
     */
    List<PhenologicalEnvDO> getPhenologicalEnvList(Collection<Long> ids);

    /**
     * 获得基地物候环境分页
     *
     * @param pageReqVO 分页查询
     * @return 基地物候环境分页
     */
    PageResult<PhenologicalEnvDO> getPhenologicalEnvPage(PhenologicalEnvPageReqVO pageReqVO);

    /**
     * 获得基地物候环境列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 基地物候环境列表
     */
    List<PhenologicalEnvDO> getPhenologicalEnvList(PhenologicalEnvExportReqVO exportReqVO);

}
