package cn.acsm.module.transaction.sales.service.specialmedicalfood;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfood.SpecialMedicalFoodMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;

import javax.annotation.Resource;
import java.util.List;

public class SpecialMedicalFoodShelvesServiceImpl implements ShelvesService {

    @Resource
    private SpecialMedicalFoodMapper specialMedicalFoodMapper;

    @Override
    public List<ShelvesSalesRespDto> findSales(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = specialMedicalFoodMapper.findSales(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);
    }

    @Override
    public List<ShelvesSalesRespDto> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto) {
        List<ShelvesSalesRespDo> salesList = specialMedicalFoodMapper.findSpecifications(shelvesSalesReqDto);
        return CommodityConvert.INSTANCE.convertShelvesSales(salesList);

    }

    @Override
    public List<ShelvesSalesRespVO> findSpecificationsVo(ShelvesSalesReqVO shelvesSalesReqVO) {
        List<ShelvesSalesRespDo> salesList = specialMedicalFoodMapper.findSpecificationsVo(shelvesSalesReqVO);
        return CommodityConvert.INSTANCE.convertShelvesSalesRespVo(salesList);
    }
}
