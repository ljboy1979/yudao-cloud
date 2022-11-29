package cn.iocoder.yudao.module.system.convert.area;


import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.area.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.area.AreaDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 行政区划 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AreaConvert {

    AreaConvert INSTANCE = Mappers.getMapper(AreaConvert.class);

    AreaDO convert(AreaCreateReqVO bean);

    AreaDO convert(AreaUpdateReqVO bean);

    AreaRespVO convert(AreaDO bean);

    List<AreaRespVO> convertList(List<AreaDO> list);

    PageResult<AreaRespVO> convertPage(PageResult<AreaDO> page);

    List< AreaExcelVO > convertList02(List<AreaDO> list);
    static AreaTreeVO convertListToTree(AreaDO areaDO){
        AreaTreeVO areaTreeVO =new AreaTreeVO();
        areaTreeVO.setId(areaDO.getAreaCode());
        areaTreeVO.setName(areaDO.getAreaName());
        areaTreeVO.setParentId(areaDO.getParentCode());
        areaTreeVO.setSort(areaDO.getTreeSort().intValue());
        return areaTreeVO;
    }

}
