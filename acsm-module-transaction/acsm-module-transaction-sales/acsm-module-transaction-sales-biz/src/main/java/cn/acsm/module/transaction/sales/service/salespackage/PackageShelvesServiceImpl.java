package cn.acsm.module.transaction.sales.service.salespackage;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.dal.mysql.salespackage.PackageMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;

import javax.annotation.Resource;
import java.util.List;

public class PackageShelvesServiceImpl implements ShelvesService {

    @Resource
    private PackageMapper packageMapper;

    @Override
    public List<ShelvesSalesRespDto> findSales(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = packageMapper.findSales(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);
    }

    @Override
    public List<ShelvesSalesRespDto> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = packageMapper.findSpecifications(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);

    }
}
