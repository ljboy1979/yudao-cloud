package cn.acsm.module.transaction.sales.dal.mysql.rawmaterialclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterialclassify.RawMaterialClassifyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.*;

/**
 * 原料分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface RawMaterialClassifyMapper extends BaseMapperX<RawMaterialClassifyDO> {

    default PageResult<RawMaterialClassifyDO> selectPage(RawMaterialClassifyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RawMaterialClassifyDO>()
                .likeIfPresent(RawMaterialClassifyDO::getCategoryName, reqVO.getCategoryName())
                .orderByDesc(RawMaterialClassifyDO::getId));
    }

    default List<RawMaterialClassifyDO> selectList(RawMaterialClassifyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<RawMaterialClassifyDO>()
                .likeIfPresent(RawMaterialClassifyDO::getCategoryName, reqVO.getCategoryName())
                .orderByDesc(RawMaterialClassifyDO::getId));
    }

    default List<RawMaterialClassifyDO> selectListToTree(RawMaterialClassifyTreeVO rawMaterialClassifyTreeVO) {
        return selectList(new LambdaQueryWrapperX<RawMaterialClassifyDO>()
                .likeIfPresent(RawMaterialClassifyDO::getCategoryName, rawMaterialClassifyTreeVO.getCategoryName())
                .orderByAsc(RawMaterialClassifyDO::getId));
    }
}
