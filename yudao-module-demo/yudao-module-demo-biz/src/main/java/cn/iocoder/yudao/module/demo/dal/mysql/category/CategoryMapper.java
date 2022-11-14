package cn.iocoder.yudao.module.demo.dal.mysql.category;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryExportReqVO;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryPageReqVO;
import cn.iocoder.yudao.module.demo.dal.dataobject.category.CategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品分类 Mapper
 *
 * @author liuj
 */
@Mapper
public interface CategoryMapper extends BaseMapperX<CategoryDO> {

    default PageResult<CategoryDO> selectPage(CategoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CategoryDO>()
                .eqIfPresent(CategoryDO::getParentId, reqVO.getParentId())
                .likeIfPresent(CategoryDO::getName, reqVO.getName())
                .eqIfPresent(CategoryDO::getLevel, reqVO.getLevel())
                .eqIfPresent(CategoryDO::getShowStatus, reqVO.getShowStatus())
                .eqIfPresent(CategoryDO::getSort, reqVO.getSort())
                .eqIfPresent(CategoryDO::getIcon, reqVO.getIcon())
                .eqIfPresent(CategoryDO::getDescription, reqVO.getDescription())
                .orderByDesc(CategoryDO::getId));
    }

    default List<CategoryDO> selectList(CategoryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CategoryDO>()
                .eqIfPresent(CategoryDO::getParentId, reqVO.getParentId())
                .likeIfPresent(CategoryDO::getName, reqVO.getName())
                .eqIfPresent(CategoryDO::getLevel, reqVO.getLevel())
                .eqIfPresent(CategoryDO::getShowStatus, reqVO.getShowStatus())
                .eqIfPresent(CategoryDO::getSort, reqVO.getSort())
                .eqIfPresent(CategoryDO::getIcon, reqVO.getIcon())
                .eqIfPresent(CategoryDO::getDescription, reqVO.getDescription())
                .orderByDesc(CategoryDO::getId));
    }

}
