package cn.acsm.module.resource.dal.mysql.adoptcontentadoptprice;

import java.util.*;

import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.AdoptContentAdoptPriceExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.AdoptContentAdoptPricePageReqVO;
import cn.acsm.module.resource.dal.dataobject.adoptcontentadoptprice.AdoptContentAdoptPriceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;

/**
 * 认养/租凭价格 Mapper
 *
 * @author smile
 */
@Mapper
public interface AdoptContentAdoptPriceMapper extends BaseMapperX<AdoptContentAdoptPriceDO> {

    default PageResult<AdoptContentAdoptPriceDO> selectPage(AdoptContentAdoptPricePageReqVO reqVO) {
        LambdaQueryWrapperX<AdoptContentAdoptPriceDO> lambdaQueryWrapperX = new LambdaQueryWrapperX<AdoptContentAdoptPriceDO>()
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptId, reqVO.getAdoptId())
                .likeIfPresent(AdoptContentAdoptPriceDO::getAdoptName, reqVO.getAdoptName())
                .betweenIfPresent(AdoptContentAdoptPriceDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(AdoptContentAdoptPriceDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptPriceFee, reqVO.getAdoptPriceFee())
                .eqIfPresent(AdoptContentAdoptPriceDO::getFeeType, reqVO.getFeeType())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptPersonFlag, reqVO.getAdoptPersonFlag())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptRightId, reqVO.getAdoptRightId())
                .eqIfPresent(AdoptContentAdoptPriceDO::getPayNum, reqVO.getPayNum())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptTotal, reqVO.getAdoptTotal())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptQuota, reqVO.getAdoptQuota())
                .eqIfPresent(AdoptContentAdoptPriceDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AdoptContentAdoptPriceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AdoptContentAdoptPriceDO::getSource, reqVO.getSource())
                .eqIfPresent(AdoptContentAdoptPriceDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AdoptContentAdoptPriceDO::getId);
        if(!StringUtils.isEmpty(reqVO.getAdoptIds())){
            lambdaQueryWrapperX.inSql(AdoptContentAdoptPriceDO::getAdoptId, reqVO.getAdoptIds());
        }
        return selectPage(reqVO, lambdaQueryWrapperX);
    }

    default List<AdoptContentAdoptPriceDO> selectList(AdoptContentAdoptPriceExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AdoptContentAdoptPriceDO>()
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptId, reqVO.getAdoptId())
                .likeIfPresent(AdoptContentAdoptPriceDO::getAdoptName, reqVO.getAdoptName())
                .betweenIfPresent(AdoptContentAdoptPriceDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(AdoptContentAdoptPriceDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptPriceFee, reqVO.getAdoptPriceFee())
                .eqIfPresent(AdoptContentAdoptPriceDO::getFeeType, reqVO.getFeeType())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptPersonFlag, reqVO.getAdoptPersonFlag())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptRightId, reqVO.getAdoptRightId())
                .eqIfPresent(AdoptContentAdoptPriceDO::getPayNum, reqVO.getPayNum())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptTotal, reqVO.getAdoptTotal())
                .eqIfPresent(AdoptContentAdoptPriceDO::getAdoptQuota, reqVO.getAdoptQuota())
                .eqIfPresent(AdoptContentAdoptPriceDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AdoptContentAdoptPriceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(AdoptContentAdoptPriceDO::getSource, reqVO.getSource())
                .eqIfPresent(AdoptContentAdoptPriceDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(AdoptContentAdoptPriceDO::getId));
    }

}
