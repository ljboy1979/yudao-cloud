package cn.acsm.module.transaction.sales.service.rawmaterial;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;
import cn.acsm.module.transaction.sales.dal.mysql.salespackage.PackageMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;

import javax.annotation.Resource;
import java.util.List;

public class RawMaterialShelvesServiceImpl implements ShelvesService {

    @Resource
    private RawMaterialMapper rawMaterialMapper;
    @Override
    public List<ShelvesSalesRespDto> findSales(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = rawMaterialMapper.findSales(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);
    }

    @Override
    public List<ShelvesSalesRespDto> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = rawMaterialMapper.findSpecifications(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);

    }
    @Override
    public List<ShelvesSalesRespVO> findSpecificationsVo(ShelvesSalesReqVO shelvesSalesReqVO) {
        List<ShelvesSalesRespDo> salesList = rawMaterialMapper.findSpecificationsVo(shelvesSalesReqVO);
        return CommodityConvert.INSTANCE.convertShelvesSalesRespVo(salesList);
    }
}
