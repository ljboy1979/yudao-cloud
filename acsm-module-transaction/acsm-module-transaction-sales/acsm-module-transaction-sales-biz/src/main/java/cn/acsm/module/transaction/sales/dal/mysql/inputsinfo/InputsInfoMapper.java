package cn.acsm.module.transaction.sales.dal.mysql.inputsinfo;

import java.util.*;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfo.InputsInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfo.vo.*;

/**
 * 投入品 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface InputsInfoMapper extends BaseMapperX<InputsInfoDO> {

    default PageResult<InputsInfoDO> selectPage(InputsInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InputsInfoDO>()
                .likeIfPresent(InputsInfoDO::getInputsName, reqVO.getInputsName())
                .eqIfPresent(InputsInfoDO::getInputsKind, reqVO.getInputsKind())
                .betweenIfPresent(InputsInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InputsInfoDO::getId));
    }

    default List<InputsInfoDO> selectList(InputsInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InputsInfoDO>()
                .likeIfPresent(InputsInfoDO::getInputsName, reqVO.getInputsName())
                .eqIfPresent(InputsInfoDO::getInputsKind, reqVO.getInputsKind())
                .betweenIfPresent(InputsInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InputsInfoDO::getId));
    }

    default Long findSelectCount(InputsInfoDO inputsInfoDO) {
        return selectCount(new LambdaQueryWrapperX<InputsInfoDO>()
                .eqIfPresent(InputsInfoDO::getInputsName, inputsInfoDO.getInputsName())
                .eqIfPresent(InputsInfoDO::getInputsKind, inputsInfoDO.getInputsKind())
                .notIn(InputsInfoDO::getId,inputsInfoDO.getId())
                .orderByDesc(InputsInfoDO::getId));
    }

    List<ShelvesSalesRespDo> findSales(ShelvesSalesReqDto shelvesSalesReqDto);

    List<ShelvesSalesRespDo> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto);

    List<ShelvesSalesRespDo> findSpecificationsVo(ShelvesSalesReqVO shelvesSalesReqDto);

    Long findSpecificationsVoCount(ShelvesSalesReqVO shelvesSalesReqVO);
}
