package cn.acsm.module.transaction.sales.service.nutritionfacts;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.nutritionfacts.NutritionFactsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 营养成分 Service 接口
 *
 * @author 芋道源码
 */
public interface NutritionFactsService {

    /**
     * 创建营养成分
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createNutritionFacts(@Valid NutritionFactsCreateReqVO createReqVO);

    /**
     * 更新营养成分
     *
     * @param updateReqVO 更新信息
     */
    void updateNutritionFacts(@Valid NutritionFactsUpdateReqVO updateReqVO);

    /**
     * 删除营养成分
     *
     * @param id 编号
     */
    void deleteNutritionFacts(String id);

    /**
     * 获得营养成分
     *
     * @param id 编号
     * @return 营养成分
     */
    NutritionFactsDO getNutritionFacts(String id);

    /**
     * 获得营养成分列表
     *
     * @param ids 编号
     * @return 营养成分列表
     */
    List<NutritionFactsDO> getNutritionFactsList(Collection<String> ids);

    /**
     * 获得营养成分分页
     *
     * @param pageReqVO 分页查询
     * @return 营养成分分页
     */
    PageResult<NutritionFactsDO> getNutritionFactsPage(NutritionFactsPageReqVO pageReqVO);

    /**
     * 获得营养成分列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 营养成分列表
     */
    List<NutritionFactsDO> getNutritionFactsList(NutritionFactsExportReqVO exportReqVO);

}
