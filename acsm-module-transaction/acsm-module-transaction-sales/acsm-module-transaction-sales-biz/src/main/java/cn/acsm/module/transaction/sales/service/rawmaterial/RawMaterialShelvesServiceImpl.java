package cn.acsm.module.transaction.sales.service.rawmaterial;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.acsm.module.transaction.sales.controller.admin.rawmaterialclassify.vo.RawMaterialClassifyTreeVO;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.rawmaterial.RawMaterialMapper;
import cn.acsm.module.transaction.sales.dal.mysql.salespackage.PackageMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;
import cn.acsm.module.transaction.sales.service.rawmaterialclassify.RawMaterialClassifyService;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.TreeSelect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RawMaterialShelvesServiceImpl implements ShelvesService {

    @Resource
    private RawMaterialMapper rawMaterialMapper;

    @Resource
    private RawMaterialClassifyService rawMaterialClassifyService;

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
    public PageResult<ShelvesSalesRespVO> findSpecificationsVo(ShelvesSalesReqVO shelvesSalesReqVO) {
        shelvesSalesReqVO.setPageNo((shelvesSalesReqVO.getPageNo()-1)*shelvesSalesReqVO.getPageSize());
        List<ShelvesSalesRespDo> salesList = rawMaterialMapper.findSpecificationsVo(shelvesSalesReqVO);
        List<ShelvesSalesRespVO> shelvesSalesRespVOS = CommodityConvert.INSTANCE.convertShelvesSalesRespVo(salesList);
        PageResult<ShelvesSalesRespVO> page = new PageResult<>();
        page.setList(shelvesSalesRespVOS);
        page.setTotal(rawMaterialMapper.findSpecificationsVoCount(shelvesSalesReqVO));
        return page;
    }

    @Override
    public List<TreeSelect> findClassify() {
        RawMaterialClassifyTreeVO rawMaterialClassifyTreeVO = new RawMaterialClassifyTreeVO();
        return rawMaterialClassifyService.findTreeList(rawMaterialClassifyTreeVO);
    }
}
