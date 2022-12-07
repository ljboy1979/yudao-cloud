package cn.acsm.module.transaction.sales.service.dishes;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.dal.mysql.dishes.DishesMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DishesShelvesServiceImpl implements ShelvesService {

    @Resource
    private DishesMapper dishesMapper;


    @Override
    public List<ShelvesSalesRespDto> findSales(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = dishesMapper.findSales(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);
    }

    @Override
    public List<ShelvesSalesRespDto> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = dishesMapper.findSpecifications(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);

    }
}
