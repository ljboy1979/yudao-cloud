package cn.acsm.module.transaction.sales.dal.mysql.dishescategory;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryPageReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.dishescategory.DishesCategoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.*;

/**
 * 菜品分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DishesCategoryMapper extends BaseMapperX<DishesCategoryDO> {

    default PageResult<DishesCategoryDO> selectPage(DishesCategoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DishesCategoryDO>()
                .likeIfPresent(DishesCategoryDO::getCategoryName, reqVO.getCategoryName())
                .betweenIfPresent(DishesCategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DishesCategoryDO::getId));
    }

    default List<DishesCategoryDO> selectList(DishesCategoryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DishesCategoryDO>()
                .likeIfPresent(DishesCategoryDO::getCategoryName, reqVO.getCategoryName())
                .betweenIfPresent(DishesCategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DishesCategoryDO::getId));
    }

    default List<DishesCategoryDO> selectListToTree(DishesCategoryTreeVO dishesCategoryTreeVO) {
        return selectList(new LambdaQueryWrapperX<DishesCategoryDO>()
                .likeIfPresent(DishesCategoryDO::getCategoryName, dishesCategoryTreeVO.getCategoryName())
                .eqIfPresent(DishesCategoryDO::getId,dishesCategoryTreeVO.getId())
                .orderByAsc(DishesCategoryDO::getId));
    }
}
