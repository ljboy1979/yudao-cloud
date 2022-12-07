package cn.acsm.module.transaction.shelves.dal.mysql.shelves;

import java.util.*;

import cn.acsm.module.transaction.shelves.api.dto.PriceTagShelvesReqDto;
import cn.acsm.module.transaction.shelves.dal.dataobject.pricetag.PriceTagShelvesRespDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.shelves.dal.dataobject.shelves.ShelvesDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.shelves.controller.admin.shelves.vo.*;

/**
 * 货架 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ShelvesMapper extends BaseMapperX<ShelvesDO> {

    default PageResult<ShelvesDO> selectPage(shelvesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ShelvesDO>()
                .likeIfPresent(ShelvesDO::getName, reqVO.getName())
                .eqIfPresent(ShelvesDO::getClassifyId, reqVO.getClassifyId())
                .betweenIfPresent(ShelvesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ShelvesDO::getId));
    }

    default List<ShelvesDO> selectList(ShelvesExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ShelvesDO>()
                .likeIfPresent(ShelvesDO::getName, reqVO.getName())
                .eqIfPresent(ShelvesDO::getClassifyId, reqVO.getClassifyId())
                .betweenIfPresent(ShelvesDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ShelvesDO::getId));
    }

    List<PriceTagShelvesRespDO> findPriceTagShelves(PriceTagShelvesReqDto shelvesReqDto);

    List<PriceTagShelvesRespDO> findPriceTagSpecifications(PriceTagShelvesReqDto shelvesReqDto);
}
