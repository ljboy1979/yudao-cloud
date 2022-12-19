package cn.acsm.module.production.tunnel.service.infosoilenv;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.tunnel.controller.admin.infosoilenv.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.infosoilenv.InfoSoilEnvDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 地块土壤环境 Service 接口
 *
 * @author 芋道源码
 */
public interface InfoSoilEnvService {

    /**
     * 创建地块土壤环境
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInfoSoilEnv(@Valid InfoSoilEnvCreateReqVO createReqVO);

    /**
     * 更新地块土壤环境
     *
     * @param updateReqVO 更新信息
     */
    void updateInfoSoilEnv(@Valid InfoSoilEnvUpdateReqVO updateReqVO);

    /**
     * 删除地块土壤环境
     *
     * @param id 编号
     */
    void deleteInfoSoilEnv(Long id);

    /**
     * 获得地块土壤环境
     *
     * @param id 编号
     * @return 地块土壤环境
     */
    InfoSoilEnvDO getInfoSoilEnv(Long id);

    /**
     * 获得地块土壤环境列表
     *
     * @param ids 编号
     * @return 地块土壤环境列表
     */
    List<InfoSoilEnvDO> getInfoSoilEnvList(Collection<Long> ids);

    /**
     * 获得地块土壤环境分页
     *
     * @param pageReqVO 分页查询
     * @return 地块土壤环境分页
     */
    PageResult<InfoSoilEnvDO> getInfoSoilEnvPage(InfoSoilEnvPageReqVO pageReqVO);

    /**
     * 获得地块土壤环境列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 地块土壤环境列表
     */
    List<InfoSoilEnvDO> getInfoSoilEnvList(InfoSoilEnvExportReqVO exportReqVO);

}
