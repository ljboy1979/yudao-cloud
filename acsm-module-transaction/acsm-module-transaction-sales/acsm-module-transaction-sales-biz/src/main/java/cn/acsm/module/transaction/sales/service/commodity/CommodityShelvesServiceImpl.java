package cn.acsm.module.transaction.sales.service.commodity;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityShelvesServiceImpl implements ShelvesService {

    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public List<ShelvesSalesRespDto> findSales(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = commodityMapper.findSales(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);
    }

    @Override
    public List<ShelvesSalesRespDto> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = commodityMapper.findSpecifications(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);

    }
}
