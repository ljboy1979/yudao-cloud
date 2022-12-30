package cn.acsm.module.production.facility.service.cargospace;

import cn.acsm.module.production.facility.api.cargospace.dto.CargoSpaceBaseDTO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceCreateReqVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceExportReqVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpacePageReqVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceUpdateReqVO;
import cn.acsm.module.production.facility.dal.dataobject.cargospace.CargoSpaceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 设施货位 Service 接口
 *
 * @author 芋道源码
 */
public interface CargoSpaceService {

    /**
     * 创建设施货位
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCargoSpace(@Valid CargoSpaceCreateReqVO createReqVO);

    /**
     * 更新设施货位
     *
     * @param updateReqVO 更新信息
     */
    void updateCargoSpace(@Valid CargoSpaceUpdateReqVO updateReqVO);

    /**
     * 删除设施货位
     *
     * @param id 编号
     */
    void deleteCargoSpace(Long id);

    /**
     * 获得设施货位
     *
     * @param id 编号
     * @return 设施货位
     */
    CargoSpaceDO getCargoSpace(Long id);

    /**
     * 获得设施货位列表
     *
     * @param ids 编号
     * @return 设施货位列表
     */
    List<CargoSpaceDO> getCargoSpaceList(Collection<Long> ids);

    /**
     * 获得设施货位分页
     *
     * @param pageReqVO 分页查询
     * @return 设施货位分页
     */
    PageResult<CargoSpaceDO> getCargoSpacePage(CargoSpacePageReqVO pageReqVO);

    /**
     * 获得设施货位列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 设施货位列表
     */
    List<CargoSpaceDO> getCargoSpaceList(CargoSpaceExportReqVO exportReqVO);

    /**
     * 通过Id 查询详情
     * @param id
     * @return
     */
    public CargoSpaceBaseDTO getById(Long id);


    public List<CargoSpaceBaseDTO> findListByFacilityId(Long fid);

    ;
    public List<CargoSpaceBaseDTO> findListByCode(String code);

}
