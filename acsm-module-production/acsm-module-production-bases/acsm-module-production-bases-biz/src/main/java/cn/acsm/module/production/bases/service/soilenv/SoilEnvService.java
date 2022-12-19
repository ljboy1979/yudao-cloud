package cn.acsm.module.production.bases.service.soilenv;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvExportReqVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvPageReqVO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.SoilEnvUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.soilenv.SoilEnvDO;
import cn.acsm.module.production.bases.controller.admin.soilenv.vo.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 基地土壤环境 Service 接口
 *
 * @author 芋道源码
 */
public interface SoilEnvService {

    /**
     * 创建基地土壤环境
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSoilEnv(@Valid SoilEnvCreateReqVO createReqVO);

    /**
     * 更新基地土壤环境
     *
     * @param updateReqVO 更新信息
     */
    void updateSoilEnv(@Valid SoilEnvUpdateReqVO updateReqVO);

    /**
     * 删除基地土壤环境
     *
     * @param id 编号
     */
    void deleteSoilEnv(Long id);

    /**
     * 获得基地土壤环境
     *
     * @param id 编号
     * @return 基地土壤环境
     */
    SoilEnvDO getSoilEnv(Long id);

    /**
     * 获得基地土壤环境列表
     *
     * @param ids 编号
     * @return 基地土壤环境列表
     */
    List<SoilEnvDO> getSoilEnvList(Collection<Long> ids);

    /**
     * 获得基地土壤环境分页
     *
     * @param pageReqVO 分页查询
     * @return 基地土壤环境分页
     */
    PageResult<SoilEnvDO> getSoilEnvPage(SoilEnvPageReqVO pageReqVO);

    /**
     * 获得基地土壤环境列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 基地土壤环境列表
     */
    List<SoilEnvDO> getSoilEnvList(SoilEnvExportReqVO exportReqVO);

}
