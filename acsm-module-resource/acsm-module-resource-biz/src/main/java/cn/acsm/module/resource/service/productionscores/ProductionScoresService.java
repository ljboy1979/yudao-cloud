package cn.acsm.module.resource.service.productionscores;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresCreateReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresExportReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresPageReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.productionscores.ProductionScoresDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 服务资源-生产品种 Service 接口
 *
 * @author smile
 */
public interface ProductionScoresService {

    /**
     * 创建服务资源-生产品种
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProductionScores(@Valid ProductionScoresCreateReqVO createReqVO);

    /**
     * 更新服务资源-生产品种
     *
     * @param updateReqVO 更新信息
     */
    void updateProductionScores(@Valid ProductionScoresUpdateReqVO updateReqVO);

    /**
     * 删除服务资源-生产品种
     *
     * @param id 编号
     */
    void deleteProductionScores(Long id);

    /**
     * 获得服务资源-生产品种
     *
     * @param id 编号
     * @return 服务资源-生产品种
     */
    ProductionScoresDO getProductionScores(Long id);

    /**
     * 获得服务资源-生产品种列表
     *
     * @param ids 编号
     * @return 服务资源-生产品种列表
     */
    List<ProductionScoresDO> getProductionScoresList(Collection<Long> ids);

    /**
     * 获得服务资源-生产品种分页
     *
     * @param pageReqVO 分页查询
     * @return 服务资源-生产品种分页
     */
    PageResult<ProductionScoresDO> getProductionScoresPage(ProductionScoresPageReqVO pageReqVO);

    /**
     * 获得服务资源-生产品种列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 服务资源-生产品种列表
     */
    List<ProductionScoresDO> getProductionScoresList(ProductionScoresExportReqVO exportReqVO);

}
