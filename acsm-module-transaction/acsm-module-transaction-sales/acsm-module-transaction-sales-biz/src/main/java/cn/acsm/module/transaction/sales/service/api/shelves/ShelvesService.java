package cn.acsm.module.transaction.sales.service.api.shelves;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShelvesService {

    List<ShelvesSalesRespDto> findSales(ShelvesSalesReqDto shelvesSalesReqDto);

    List<ShelvesSalesRespDto> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto);

    PageResult<ShelvesSalesRespVO> findSpecificationsVo(ShelvesSalesReqVO shelvesSalesReqVO);

    List<TreeSelect> findClassify();
}
