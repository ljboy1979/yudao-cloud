package cn.acsm.module.production.facility.service.cargospace;

import cn.acsm.module.production.facility.api.cargospace.dto.CargoSpaceBaseDTO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceCreateReqVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceExportReqVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpacePageReqVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceUpdateReqVO;
import cn.acsm.module.production.facility.convert.cargospace.CargoSpaceConvert;
import cn.acsm.module.production.facility.dal.dataobject.cargospace.CargoSpaceDO;
import cn.acsm.module.production.facility.dal.mysql.cargospace.CargoSpaceMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.production.facility.enums.ErrorCodeConstants.CARGO_SPACE_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 设施货位 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CargoSpaceServiceImpl implements CargoSpaceService {

    @Resource
    private CargoSpaceMapper cargoSpaceMapper;

    @Override
    public Long createCargoSpace(CargoSpaceCreateReqVO createReqVO) {
        // 插入
        CargoSpaceDO cargoSpace = CargoSpaceConvert.INSTANCE.convert(createReqVO);
        cargoSpaceMapper.insert(cargoSpace);
        // 返回
        return cargoSpace.getId();
    }

    @Override
    public void updateCargoSpace(CargoSpaceUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCargoSpaceExists(updateReqVO.getId());
        // 更新
        CargoSpaceDO updateObj = CargoSpaceConvert.INSTANCE.convert(updateReqVO);
        cargoSpaceMapper.updateById(updateObj);
    }

    @Override
    public void deleteCargoSpace(Long id) {
        // 校验存在
        this.validateCargoSpaceExists(id);
        // 删除
        cargoSpaceMapper.deleteById(id);
    }

    private void validateCargoSpaceExists(Long id) {
        if (cargoSpaceMapper.selectById(id) == null) {
            throw exception(CARGO_SPACE_NOT_EXISTS);
        }
    }

    @Override
    public CargoSpaceDO getCargoSpace(Long id) {
        return cargoSpaceMapper.selectById(id);
    }

    @Override
    public List<CargoSpaceDO> getCargoSpaceList(Collection<Long> ids) {
        return cargoSpaceMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CargoSpaceDO> getCargoSpacePage(CargoSpacePageReqVO pageReqVO) {
        return cargoSpaceMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CargoSpaceDO> getCargoSpaceList(CargoSpaceExportReqVO exportReqVO) {
        return cargoSpaceMapper.selectList(exportReqVO);
    }

    @Override
    public CargoSpaceBaseDTO getById(Long id) {
        return CargoSpaceConvert.INSTANCE.convert01(cargoSpaceMapper.selectById(id));
    }

    @Override
    public List<CargoSpaceBaseDTO> findListByFacilityId(Long fid){
        CargoSpaceExportReqVO vo = new CargoSpaceExportReqVO();
        vo.setFacilityId(fid.intValue());
        return CargoSpaceConvert.INSTANCE.convertList03(cargoSpaceMapper.selectList(vo));
    }

    @Override
    public List<CargoSpaceBaseDTO> findListByCode(String code){
        CargoSpaceExportReqVO vo = new CargoSpaceExportReqVO();
        vo.setSpaceCode(code);
        return CargoSpaceConvert.INSTANCE.convertList03(cargoSpaceMapper.selectList(vo));
    }

}
