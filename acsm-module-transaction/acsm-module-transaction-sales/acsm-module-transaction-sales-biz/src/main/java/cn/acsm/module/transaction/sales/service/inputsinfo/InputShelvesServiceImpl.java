package cn.acsm.module.transaction.sales.service.inputsinfo;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.dal.mysql.inputsinfo.InputsInfoMapper;
import cn.acsm.module.transaction.sales.dal.mysql.salespackage.PackageMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InputShelvesServiceImpl implements ShelvesService {

    @Resource
    private InputsInfoMapper inputsInfoMapper;

    @Override
    public List<ShelvesSalesRespDto> findSales(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = inputsInfoMapper.findSales(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);
    }

    @Override
    public List<ShelvesSalesRespDto> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = inputsInfoMapper.findSpecifications(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);

    }
}
