package cn.acsm.module.production.tunnel.convert.costbook;

import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.CostBookCreateReqVO;
import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.CostBookExcelVO;
import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.CostBookRespVO;
import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.CostBookUpdateReqVO;
import cn.acsm.module.production.tunnel.dal.dataobject.costbook.CostBookDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 地块账本 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CostBookConvert {

    CostBookConvert INSTANCE = Mappers.getMapper(CostBookConvert.class);

    CostBookDO convert(CostBookCreateReqVO bean);

    CostBookDO convert(CostBookUpdateReqVO bean);

    CostBookRespVO convert(CostBookDO bean);

    List<CostBookRespVO> convertList(List<CostBookDO> list);

    PageResult<CostBookRespVO> convertPage(PageResult<CostBookDO> page);

    List<CostBookExcelVO> convertList02(List<CostBookDO> list);

}
