package cn.iocoder.yudao.module.transaction.sales.dal.mysql.rawmaterial;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.rawmaterial.vo.*;

/**
 * 原料 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface RawMaterialMapper extends BaseMapperX<RawMaterialDO> {

    default PageResult<RawMaterialDO> selectPage(RawMaterialPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RawMaterialDO>()
                .eqIfPresent(RawMaterialDO::getIngredientNumber, reqVO.getIngredientNumber())
                .eqIfPresent(RawMaterialDO::getClassify, reqVO.getClassify())
                .likeIfPresent(RawMaterialDO::getName, reqVO.getName())
                .betweenIfPresent(RawMaterialDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RawMaterialDO::getId));
    }

    default List<RawMaterialDO> selectList(RawMaterialExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<RawMaterialDO>()
                .eqIfPresent(RawMaterialDO::getIngredientNumber, reqVO.getIngredientNumber())
                .eqIfPresent(RawMaterialDO::getClassify, reqVO.getClassify())
                .likeIfPresent(RawMaterialDO::getName, reqVO.getName())
                .betweenIfPresent(RawMaterialDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RawMaterialDO::getId));
    }

}
