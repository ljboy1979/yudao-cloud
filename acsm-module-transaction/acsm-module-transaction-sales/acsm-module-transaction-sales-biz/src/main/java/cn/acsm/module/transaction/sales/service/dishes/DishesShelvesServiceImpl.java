package cn.acsm.module.transaction.sales.service.dishes;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.acsm.module.transaction.sales.controller.admin.dishescategory.vo.DishesCategoryTreeVO;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.dal.mysql.dishes.DishesMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;
import cn.acsm.module.transaction.sales.service.dishescategory.DishesCategoryService;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DishesShelvesServiceImpl implements ShelvesService {

    @Resource
    private DishesMapper dishesMapper;

    @Resource
    private DishesCategoryService dishesCategoryService;
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
    @Override
    public PageResult<ShelvesSalesRespVO> findSpecificationsVo(ShelvesSalesReqVO shelvesSalesReqVO) {
        shelvesSalesReqVO.setPageNo((shelvesSalesReqVO.getPageNo()-1)*shelvesSalesReqVO.getPageSize());
        List<ShelvesSalesRespDo> salesList = dishesMapper.findSpecificationsVo(shelvesSalesReqVO);
        List<ShelvesSalesRespVO> shelvesSalesRespVOS = CommodityConvert.INSTANCE.convertShelvesSalesRespVo(salesList);
        PageResult<ShelvesSalesRespVO> page = new PageResult<>();
        page.setList(shelvesSalesRespVOS);
        page.setTotal(dishesMapper.findSpecificationsVoCount(shelvesSalesReqVO));
        return page;
    }

    @Override
    public List<TreeSelect> findClassify() {
        DishesCategoryTreeVO dishesCategoryTreeVO = new DishesCategoryTreeVO();
        return dishesCategoryService.findTreeList(dishesCategoryTreeVO);
    }
}
