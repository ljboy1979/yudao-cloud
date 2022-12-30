package cn.acsm.module.production.facility.dal.mysql.cargospace;

import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpaceExportReqVO;
import cn.acsm.module.production.facility.controller.admin.cargospace.vo.CargoSpacePageReqVO;
import cn.acsm.module.production.facility.dal.dataobject.cargospace.CargoSpaceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设施货位 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CargoSpaceMapper extends BaseMapperX<CargoSpaceDO> {

    default PageResult<CargoSpaceDO> selectPage(CargoSpacePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CargoSpaceDO>()
                .eqIfPresent(CargoSpaceDO::getSpaceCode, reqVO.getSpaceCode())
                .eqIfPresent(CargoSpaceDO::getSpaceRowNumber, reqVO.getSpaceRowNumber())
                .eqIfPresent(CargoSpaceDO::getSpaceColumnNumber, reqVO.getSpaceColumnNumber())
                .eqIfPresent(CargoSpaceDO::getSpaceLayerNumber, reqVO.getSpaceLayerNumber())
                .eqIfPresent(CargoSpaceDO::getFacilityId, reqVO.getFacilityId())
                .betweenIfPresent(CargoSpaceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CargoSpaceDO::getSource, reqVO.getSource())
                .eqIfPresent(CargoSpaceDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(CargoSpaceDO::getId));
    }

    default List<CargoSpaceDO> selectList(CargoSpaceExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CargoSpaceDO>()
                .eqIfPresent(CargoSpaceDO::getSpaceCode, reqVO.getSpaceCode())
                .eqIfPresent(CargoSpaceDO::getSpaceRowNumber, reqVO.getSpaceRowNumber())
                .eqIfPresent(CargoSpaceDO::getSpaceColumnNumber, reqVO.getSpaceColumnNumber())
                .eqIfPresent(CargoSpaceDO::getSpaceLayerNumber, reqVO.getSpaceLayerNumber())
                .eqIfPresent(CargoSpaceDO::getFacilityId, reqVO.getFacilityId())
                .betweenIfPresent(CargoSpaceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CargoSpaceDO::getSource, reqVO.getSource())
                .eqIfPresent(CargoSpaceDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(CargoSpaceDO::getId));
    }

}
