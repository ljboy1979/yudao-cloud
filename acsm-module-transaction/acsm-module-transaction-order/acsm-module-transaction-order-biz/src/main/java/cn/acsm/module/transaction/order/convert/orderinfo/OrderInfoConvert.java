package cn.acsm.module.transaction.order.convert.orderinfo;

import java.util.*;

import cn.acsm.module.transaction.shelves.api.dto.ShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesRespDto;
import cn.acsm.module.transaction.shelves.api.dto.TreeSelectDto;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.transaction.order.controller.admin.orderinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;

/**
 * 订单 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface OrderInfoConvert {

    OrderInfoConvert INSTANCE = Mappers.getMapper(OrderInfoConvert.class);

    OrderInfoDO convert(OrderInfoCreateReqVO bean);

    OrderInfoDO convert(OrderInfoUpdateReqVO bean);

    OrderInfoRespVO convert(OrderInfoDO bean);

    List<OrderInfoRespVO> convertList(List<OrderInfoDO> list);

    PageResult<OrderInfoRespVO> convertPage(PageResult<OrderInfoDO> page);

    List<OrderInfoExcelVO> convertList02(List<OrderInfoDO> list);
    ShelvesReqDto convertShelvesReqDto(ShelvesReqVo bean);

    List<ShelvesRespVo> convertShelvesRespList(List<ShelvesRespDto> list);

    static   List<TreeSelectVo> convertShelvesTreeRespList(List<TreeSelectDto> list) {
        if ( list == null ) {
            return null;
        }

        List<TreeSelectVo> treeSelectVos = new ArrayList<>(list.size());
        for ( TreeSelectDto treeSelectDto : list ) {
            TreeSelectVo treeSelectVo = new TreeSelectVo();
            treeSelectVo.setId(Long.valueOf(treeSelectDto.getId()));
            treeSelectVo.setChildren(treeSelectDto.getChildren());
            treeSelectVo.setLabel(treeSelectDto.getLabel());
            treeSelectVos.add(treeSelectVo) ;
        }

        return treeSelectVos;
    };
}
