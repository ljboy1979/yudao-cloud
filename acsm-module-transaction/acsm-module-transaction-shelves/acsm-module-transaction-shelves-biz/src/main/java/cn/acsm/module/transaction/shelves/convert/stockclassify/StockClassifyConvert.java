package cn.acsm.module.transaction.shelves.convert.stockclassify;

import java.util.*;

import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockclassify.StockClassifyDO;

/**
 * 库存分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface StockClassifyConvert {

    StockClassifyConvert INSTANCE = Mappers.getMapper(StockClassifyConvert.class);

    StockClassifyDO convert(StockClassifyCreateReqVO bean);

    StockClassifyDO convert(StockClassifyUpdateReqVO bean);

    StockClassifyRespVO convert(StockClassifyDO bean);

    List<StockClassifyRespVO> convertList(List<StockClassifyDO> list);

    PageResult<StockClassifyRespVO> convertPage(PageResult<StockClassifyDO> page);

    List<StockClassifyExcelVO> convertList02(List<StockClassifyDO> list);

    static StockClassifyTreeVO convertListToTree(StockClassifyDO bean) {
        StockClassifyTreeVO stockClassifyTreeVO = new StockClassifyTreeVO();
        stockClassifyTreeVO.setId(Long.valueOf(bean.getId()));
        stockClassifyTreeVO.setName(bean.getClassifyName());
        stockClassifyTreeVO.setParentId(Long.valueOf(bean.getParentCode()));
        stockClassifyTreeVO.setParentName(bean.getTreeNames());
        stockClassifyTreeVO.setSort(bean.getTreeSort().intValue());
        return stockClassifyTreeVO;
    };

    static TreeSelectDto convertListToTreeDto(TreeSelect bean) {
        TreeSelectDto treeSelectDto = new TreeSelectDto();
        treeSelectDto.setId(Long.valueOf(bean.getId()));
        treeSelectDto.setChildren(bean.getChildren());
        treeSelectDto.setLabel(bean.getLabel());
        return treeSelectDto;
    };
}
