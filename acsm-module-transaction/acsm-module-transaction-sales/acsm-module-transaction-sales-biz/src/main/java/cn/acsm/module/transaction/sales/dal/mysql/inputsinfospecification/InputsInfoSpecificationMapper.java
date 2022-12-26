package cn.acsm.module.transaction.sales.dal.mysql.inputsinfospecification;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.*;

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
                .eqIfPresent(InputsInfoSpecificationDO::getInputsInfoId, reqVO.getInputsInfoId())
                .eqIfPresent(InputsInfoSpecificationDO::getPackagingType, reqVO.getPackagingType())
                .betweenIfPresent(InputsInfoSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InputsInfoSpecificationDO::getCreateTime));
    }

    default List<InputsInfoSpecificationDO> selectList(InputsInfoSpecificationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InputsInfoSpecificationDO>()
                .likeIfPresent(InputsInfoSpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .betweenIfPresent(InputsInfoSpecificationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InputsInfoSpecificationDO::getId));
    }

    default Long findSelectCount(InputsInfoSpecificationDO inputsInfoSpecificationDO) {
        return selectCount(new LambdaQueryWrapperX<InputsInfoSpecificationDO>()
                .eqIfPresent(InputsInfoSpecificationDO::getSpecificationsName, inputsInfoSpecificationDO.getSpecificationsName())
                .eqIfPresent(InputsInfoSpecificationDO::getInputsInfoId,inputsInfoSpecificationDO.getInputsInfoId())
                .notIn(InputsInfoSpecificationDO::getId,inputsInfoSpecificationDO.getId())
                .orderByDesc(InputsInfoSpecificationDO::getId));
    }

}
