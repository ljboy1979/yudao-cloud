package cn.acsm.module.transaction.sales.dal.mysql.rawmaterialspecification;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.RawMaterialSpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.RawMaterialSpecificationPageReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialspecification.RawMaterialSpecificationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialspecification.vo.*;

/**
 * 原料规格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface RawMaterialSpecificationMapper extends BaseMapperX<RawMaterialSpecificationDO> {

    default PageResult<RawMaterialSpecificationDO> selectPage(RawMaterialSpecificationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RawMaterialSpecificationDO>()
                .likeIfPresent(RawMaterialSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(RawMaterialSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RawMaterialSpecificationDO::getId));
    }

    default List<RawMaterialSpecificationDO> selectList(RawMaterialSpecificationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<RawMaterialSpecificationDO>()
                .likeIfPresent(RawMaterialSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(RawMaterialSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RawMaterialSpecificationDO::getId));
    }

}
