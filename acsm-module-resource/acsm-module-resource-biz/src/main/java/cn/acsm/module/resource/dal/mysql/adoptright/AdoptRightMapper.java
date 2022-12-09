package cn.acsm.module.resource.dal.mysql.adoptright;

import java.util.*;

import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightRespVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.resource.dal.dataobject.adoptright.AdoptRightDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 认养/租凭权益 Mapper
 *
 * @author smile
 */
@Mapper
public interface AdoptRightMapper extends BaseMapperX<AdoptRightDO> {

    default PageResult<AdoptRightDO> selectPage(AdoptRightPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AdoptRightDO>()
                .eqIfPresent(AdoptRightDO::getRightType, reqVO.getRightType())
                .eqIfPresent(AdoptRightDO::getRightDescription, reqVO.getRightDescription())
                .betweenIfPresent(AdoptRightDO::getAdoptTime, reqVO.getAdoptTime())
                .eqIfPresent(AdoptRightDO::getAdoptContentNum, reqVO.getAdoptContentNum())
                .eqIfPresent(AdoptRightDO::getIncomeItemAmountScale, reqVO.getIncomeItemAmountScale())
                .betweenIfPresent(AdoptRightDO::getIncomeEffectiveDate, reqVO.getIncomeEffectiveDate())
                .eqIfPresent(AdoptRightDO::getLeasePersonFlag, reqVO.getLeasePersonFlag())
                .eqIfPresent(AdoptRightDO::getAdoptRightId, reqVO.getAdoptRightId())
                .eqIfPresent(AdoptRightDO::getPrice, reqVO.getPrice())
                .eqIfPresent(AdoptRightDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AdoptRightDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AdoptRightDO::getSource, reqVO.getSource())
                .eqIfPresent(AdoptRightDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AdoptRightDO::getId));
    }

    default List<AdoptRightDO> selectList(AdoptRightExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AdoptRightDO>()
                .eqIfPresent(AdoptRightDO::getRightType, reqVO.getRightType())
                .eqIfPresent(AdoptRightDO::getRightDescription, reqVO.getRightDescription())
                .betweenIfPresent(AdoptRightDO::getAdoptTime, reqVO.getAdoptTime())
                .eqIfPresent(AdoptRightDO::getAdoptContentNum, reqVO.getAdoptContentNum())
                .eqIfPresent(AdoptRightDO::getIncomeItemAmountScale, reqVO.getIncomeItemAmountScale())
                .betweenIfPresent(AdoptRightDO::getIncomeEffectiveDate, reqVO.getIncomeEffectiveDate())
                .eqIfPresent(AdoptRightDO::getLeasePersonFlag, reqVO.getLeasePersonFlag())
                .eqIfPresent(AdoptRightDO::getAdoptRightId, reqVO.getAdoptRightId())
                .eqIfPresent(AdoptRightDO::getPrice, reqVO.getPrice())
                .eqIfPresent(AdoptRightDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AdoptRightDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AdoptRightDO::getSource, reqVO.getSource())
                .eqIfPresent(AdoptRightDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AdoptRightDO::getId));
    }

    /**
     *  根据权益的ids 查询出 对应的实体
     * @param stringList 权益的IDS
     * @return 实体集合
     */
    List<AdoptRightRespVO> findListByIds(@Param("list") List<String> stringList);

}
