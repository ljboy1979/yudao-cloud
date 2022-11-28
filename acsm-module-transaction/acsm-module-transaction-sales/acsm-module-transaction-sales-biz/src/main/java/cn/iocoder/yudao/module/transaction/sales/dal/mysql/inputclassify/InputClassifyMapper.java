package cn.iocoder.yudao.module.transaction.sales.dal.mysql.inputclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputclassify.vo.*;

/**
 * 投入品分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface InputClassifyMapper extends BaseMapperX<InputClassifyDO> {

    default PageResult<InputClassifyDO> selectPage(InputClassifyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InputClassifyDO>()
                .likeIfPresent(InputClassifyDO::getCategoryName, reqVO.getCategoryName())
                .eqIfPresent(InputClassifyDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(InputClassifyDO::getSource, reqVO.getSource())
                .orderByDesc(InputClassifyDO::getId));
    }

    default List<InputClassifyDO> selectList(InputClassifyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InputClassifyDO>()
                .likeIfPresent(InputClassifyDO::getCategoryName, reqVO.getCategoryName())
                .eqIfPresent(InputClassifyDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(InputClassifyDO::getSource, reqVO.getSource())
                .orderByDesc(InputClassifyDO::getId));
    }

}
