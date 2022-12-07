package cn.acsm.module.transaction.sales.service.api.shelves;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;

import java.util.List;

public interface ShelvesService {

    List<ShelvesSalesRespDto> findSales(ShelvesSalesReqDto shelvesSalesReqDto);

    List<ShelvesSalesRespDto> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto);

}
