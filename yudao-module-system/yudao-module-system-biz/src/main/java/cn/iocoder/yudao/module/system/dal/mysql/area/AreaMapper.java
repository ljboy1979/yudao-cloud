package cn.iocoder.yudao.module.system.dal.mysql.area;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaExportReqVO;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.AreaPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 行政区划 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AreaMapper extends BaseMapperX< AreaDO > {

    default PageResult<AreaDO> selectPage(AreaPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AreaDO>()
                .eqIfPresent(AreaDO::getAreaCode, reqVO.getAreaCode())
                .eqIfPresent(AreaDO::getParentCode, reqVO.getParentCode())
                .eqIfPresent(AreaDO::getParentCodes, reqVO.getParentCodes())
                .eqIfPresent(AreaDO::getTreeSort, reqVO.getTreeSort())
                .eqIfPresent(AreaDO::getTreeSorts, reqVO.getTreeSorts())
                .eqIfPresent(AreaDO::getTreeLeaf, reqVO.getTreeLeaf())
                .eqIfPresent(AreaDO::getTreeLevel, reqVO.getTreeLevel())
                .eqIfPresent(AreaDO::getTreeNames, reqVO.getTreeNames())
                .likeIfPresent(AreaDO::getAreaName, reqVO.getAreaName())
                .eqIfPresent(AreaDO::getAreaType, reqVO.getAreaType())
                .eqIfPresent(AreaDO::getDeleted, reqVO.getDeleted())
                .eqIfPresent(AreaDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(AreaDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AreaDO::getUpdater, reqVO.getUpdater())
                .betweenIfPresent(AreaDO::getUpdateTime, reqVO.getUpdateTime())
                .eqIfPresent(AreaDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(AreaDO::getAreaEn, reqVO.getAreaEn())
                .eqIfPresent(AreaDO::getTop, reqVO.getTop())
                .eqIfPresent(AreaDO::getBottom, reqVO.getBottom())
                .eqIfPresent(AreaDO::getLeft, reqVO.getLeft())
                .eqIfPresent(AreaDO::getRight, reqVO.getRight())
                .eqIfPresent(AreaDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(AreaDO::getLatitude, reqVO.getLatitude())
                .orderByDesc(AreaDO::getId));
    }

    default List<AreaDO> selectList(AreaExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AreaDO>()
                .eqIfPresent(AreaDO::getAreaCode, reqVO.getAreaCode())
                .eqIfPresent(AreaDO::getParentCode, reqVO.getParentCode())
                .eqIfPresent(AreaDO::getParentCodes, reqVO.getParentCodes())
                .eqIfPresent(AreaDO::getTreeSort, reqVO.getTreeSort())
                .eqIfPresent(AreaDO::getTreeSorts, reqVO.getTreeSorts())
                .eqIfPresent(AreaDO::getTreeLeaf, reqVO.getTreeLeaf())
                .eqIfPresent(AreaDO::getTreeLevel, reqVO.getTreeLevel())
                .eqIfPresent(AreaDO::getTreeNames, reqVO.getTreeNames())
                .likeIfPresent(AreaDO::getAreaName, reqVO.getAreaName())
                .eqIfPresent(AreaDO::getAreaType, reqVO.getAreaType())
                .eqIfPresent(AreaDO::getDeleted, reqVO.getDeleted())
                .eqIfPresent(AreaDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(AreaDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AreaDO::getUpdater, reqVO.getUpdater())
                .betweenIfPresent(AreaDO::getUpdateTime, reqVO.getUpdateTime())
                .eqIfPresent(AreaDO::getRemarks, reqVO.getRemarks())
                .eqIfPresent(AreaDO::getAreaEn, reqVO.getAreaEn())
                .eqIfPresent(AreaDO::getTop, reqVO.getTop())
                .eqIfPresent(AreaDO::getBottom, reqVO.getBottom())
                .eqIfPresent(AreaDO::getLeft, reqVO.getLeft())
                .eqIfPresent(AreaDO::getRight, reqVO.getRight())
                .eqIfPresent(AreaDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(AreaDO::getLatitude, reqVO.getLatitude())
                .orderByDesc(AreaDO::getId));
    }

}
