package cn.acsm.module.transaction.sales.service.specialmedicalfood;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodclassify.vo.SpecialMedicalFoodClassifyTreeVO;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.dal.mysql.specialmedicalfood.SpecialMedicalFoodMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;
import cn.acsm.module.transaction.sales.service.specialmedicalfoodclassify.SpecialMedicalFoodClassifyService;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SpecialMedicalFoodShelvesServiceImpl implements ShelvesService {

    @Resource
    private SpecialMedicalFoodMapper specialMedicalFoodMapper;

    @Resource
    private SpecialMedicalFoodClassifyService specialMedicalFoodClassifyService;

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
    public PageResult<ShelvesSalesRespVO> findSpecificationsVo(ShelvesSalesReqVO shelvesSalesReqVO) {
        shelvesSalesReqVO.setPageNo((shelvesSalesReqVO.getPageNo()-1)*shelvesSalesReqVO.getPageSize());
        List<ShelvesSalesRespDo> salesList = specialMedicalFoodMapper.findSpecificationsVo(shelvesSalesReqVO);
        List<ShelvesSalesRespVO> shelvesSalesRespVOS = CommodityConvert.INSTANCE.convertShelvesSalesRespVo(salesList);
        PageResult<ShelvesSalesRespVO> page = new PageResult<>();
        page.setList(shelvesSalesRespVOS);
        page.setTotal(specialMedicalFoodMapper.findSpecificationsVoCount(shelvesSalesReqVO));
        return page;
    }

    @Override
    public List<TreeSelect> findClassify(ShelvesSalesReqVO shelvesSalesReqDto) {
        SpecialMedicalFoodClassifyTreeVO specialMedicalFoodClassifyTreeVO = new SpecialMedicalFoodClassifyTreeVO();
        specialMedicalFoodClassifyTreeVO.setId(shelvesSalesReqDto.getClassify());
        return specialMedicalFoodClassifyService.findTreeList(specialMedicalFoodClassifyTreeVO);
    }
}
