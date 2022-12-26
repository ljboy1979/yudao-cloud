package cn.acsm.module.transaction.sales.dal.mysql.rawmaterial;

import java.util.*;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.rawmaterial.RawMaterialDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterial.vo.*;

/**
 * 原料 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface RawMaterialMapper extends BaseMapperX<RawMaterialDO> {

    default PageResult<RawMaterialDO> selectPage(RawMaterialPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RawMaterialDO>()
                .eqIfPresent(RawMaterialDO::getIngredientNumber, reqVO.getIngredientNumber())
                .eqIfPresent(RawMaterialDO::getClassify, reqVO.getClassify())
                .likeIfPresent(RawMaterialDO::getName, reqVO.getName())
                .betweenIfPresent(RawMaterialDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RawMaterialDO::getId));
    }

    default List<RawMaterialDO> selectList(RawMaterialExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<RawMaterialDO>()
                .eqIfPresent(RawMaterialDO::getIngredientNumber, reqVO.getIngredientNumber())
                .eqIfPresent(RawMaterialDO::getClassify, reqVO.getClassify())
                .likeIfPresent(RawMaterialDO::getName, reqVO.getName())
                .betweenIfPresent(RawMaterialDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RawMaterialDO::getId));
    }

    default Long findSelectCount(RawMaterialDO rawMaterialDO) {
        return selectCount(new LambdaQueryWrapperX<RawMaterialDO>()
                .eqIfPresent(RawMaterialDO::getIngredientNumber, rawMaterialDO.getIngredientNumber())
                .eqIfPresent(RawMaterialDO::getClassify, rawMaterialDO.getClassify())
                .eqIfPresent(RawMaterialDO::getName, rawMaterialDO.getName())
                .notIn(RawMaterialDO::getId,rawMaterialDO.getId())
                .orderByDesc(RawMaterialDO::getId));
    }

    List<ShelvesSalesRespDo> findSales(ShelvesSalesReqDto shelvesSalesReqDto);

    List<ShelvesSalesRespDo> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto);

    List<RawMaterialDO> findList(RawMaterialReqVO rawMaterialReqVO);
}
