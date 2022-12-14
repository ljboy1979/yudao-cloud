package cn.acsm.module.transaction.shelves.service.shelves;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.transaction.shelves.api.dto.ShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesRespDto;
import cn.acsm.module.transaction.shelves.controller.admin.shelves.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.shelves.ShelvesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 货架 Service 接口
 *
 * @author 芋道源码
 */
public interface ShelvesService {

    /**
     * 创建货架
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createShelves(@Valid ShelvesCreateReqVO createReqVO);

    /**
     * 更新货架
     *
     * @param updateReqVO 更新信息
     */
    void updateshelves(@Valid ShelvesUpdateReqVO updateReqVO);

    /**
     * 删除货架
     *
     * @param id 编号
     */
    void deleteshelves(String id);

    /**
     * 获得货架
     *
     * @param id 编号
     * @return 货架
     */
    ShelvesDO getshelves(String id);

    /**
     * 获得货架列表
     *
     * @param ids 编号
     * @return 货架列表
     */
    List<ShelvesDO> getshelvesList(Collection<String> ids);

    /**
     * 获得货架分页
     *
     * @param pageReqVO 分页查询
     * @return 货架分页
     */
    PageResult<ShelvesDO> getshelvesPage(shelvesPageReqVO pageReqVO);

    /**
     * 获得货架列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 货架列表
     */
    List<ShelvesDO> getshelvesList(ShelvesExportReqVO exportReqVO);

    List<ShelvesSalesRespVO> findShelves(ShelvesReqVO createReqVO);

    List<ShelvesSalesRespVO> findSpecifications(ShelvesReqVO shelvesReqVO);

    List<ShelvesRespDto> findShelvesList(ShelvesReqDto shelvesReqDto);

    List<ShelvesRespDto> findSpecificationsList(ShelvesReqDto shelvesReqDto);
}
