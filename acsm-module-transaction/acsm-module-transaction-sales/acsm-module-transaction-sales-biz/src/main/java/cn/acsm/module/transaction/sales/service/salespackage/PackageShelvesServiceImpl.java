package cn.acsm.module.transaction.sales.service.salespackage;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.ShelvesSalesRespVO;
import cn.acsm.module.transaction.sales.convert.commodity.CommodityConvert;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.dal.mysql.salespackage.PackageMapper;
import cn.acsm.module.transaction.sales.service.api.shelves.ShelvesService;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
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
    @Override
    public PageResult<ShelvesSalesRespVO> findSpecificationsVo(ShelvesSalesReqVO shelvesSalesReqVO) {
        shelvesSalesReqVO.setPageNo((shelvesSalesReqVO.getPageNo()-1)*shelvesSalesReqVO.getPageSize());
        List<ShelvesSalesRespDo> salesList = packageMapper.findSpecificationsVo(shelvesSalesReqVO);
        List<ShelvesSalesRespVO> shelvesSalesRespVOS = CommodityConvert.INSTANCE.convertShelvesSalesRespVo(salesList);
        PageResult<ShelvesSalesRespVO> page = new PageResult<>();
        page.setList(shelvesSalesRespVOS);
        page.setTotal(packageMapper.findSpecificationsVoCount(shelvesSalesReqVO));
        return page;
    }
}
