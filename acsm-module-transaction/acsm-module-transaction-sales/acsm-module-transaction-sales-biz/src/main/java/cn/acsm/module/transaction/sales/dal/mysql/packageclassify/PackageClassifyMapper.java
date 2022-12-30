package cn.acsm.module.transaction.sales.dal.mysql.packageclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.packageclassify.PackageClassifyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.packageclassify.vo.*;

/**
 * 套餐分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PackageClassifyMapper extends BaseMapperX<PackageClassifyDO> {

    default PageResult<PackageClassifyDO> selectPage(PackageClassifyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PackageClassifyDO>()
                .likeIfPresent(PackageClassifyDO::getCategoryName, reqVO.getCategoryName())
                .eqIfPresent(PackageClassifyDO::getParentCode,reqVO.getParentCode())
                .betweenIfPresent(PackageClassifyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PackageClassifyDO::getId));
    }

    default List<PackageClassifyDO> selectList(PackageClassifyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PackageClassifyDO>()
                .likeIfPresent(PackageClassifyDO::getCategoryName, reqVO.getCategoryName())
                .betweenIfPresent(PackageClassifyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PackageClassifyDO::getId));
    }
    default List<PackageClassifyDO> selectListToTree(PackageClassifyTreeVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PackageClassifyDO>()
                .likeIfPresent(PackageClassifyDO::getCategoryName, reqVO.getCategoryName())
                .eqIfPresent(PackageClassifyDO::getId,reqVO.getId())
                .orderByDesc(PackageClassifyDO::getId));
    }

}
