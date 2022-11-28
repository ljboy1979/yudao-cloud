package cn.iocoder.yudao.module.transaction.sales.dal.mysql.inputsinfospecification;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputsinfospecification.vo.*;

/**
 * 投入品规格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface InputsInfoSpecificationMapper extends BaseMapperX<InputsInfoSpecificationDO> {

    default PageResult<InputsInfoSpecificationDO> selectPage(InputsInfoSpecificationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InputsInfoSpecificationDO>()
                .likeIfPresent(InputsInfoSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(InputsInfoSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InputsInfoSpecificationDO::getId));
    }

    default List<InputsInfoSpecificationDO> selectList(InputsInfoSpecificationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InputsInfoSpecificationDO>()
                .likeIfPresent(InputsInfoSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(InputsInfoSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InputsInfoSpecificationDO::getId));
    }

}
