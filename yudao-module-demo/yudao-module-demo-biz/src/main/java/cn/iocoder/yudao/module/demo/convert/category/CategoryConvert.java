package cn.iocoder.yudao.module.demo.convert.category;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryCreateReqVO;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryExcelVO;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryRespVO;
import cn.iocoder.yudao.module.demo.controller.admin.category.vo.CategoryUpdateReqVO;
import cn.iocoder.yudao.module.demo.dal.dataobject.category.CategoryDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 商品分类 Convert
 *
 * @author liuj
 */
@Mapper
public interface CategoryConvert {

    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    CategoryDO convert(CategoryCreateReqVO bean);

    CategoryDO convert(CategoryUpdateReqVO bean);

    CategoryRespVO convert(CategoryDO bean);

    List<CategoryRespVO> convertList(List<CategoryDO> list);

    PageResult<CategoryRespVO> convertPage(PageResult<CategoryDO> page);

    List<CategoryExcelVO> convertList02(List<CategoryDO> list);

}
