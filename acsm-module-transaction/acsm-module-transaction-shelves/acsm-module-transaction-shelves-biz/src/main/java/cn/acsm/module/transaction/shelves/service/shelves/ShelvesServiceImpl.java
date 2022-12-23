package cn.acsm.module.transaction.shelves.service.shelves;

import cn.acsm.module.transaction.pricetag.api.pricetag.MarketPriceApi;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesRespDto;
import cn.acsm.module.transaction.sales.api.shelves.ShelvesApi;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesReqDto;
import cn.acsm.module.transaction.shelves.api.dto.ShelvesRespDto;
import cn.acsm.module.transaction.shelves.controller.admin.specifications.vo.SpecificationsCreateReqVO;
import cn.acsm.module.transaction.shelves.convert.specifications.SpecificationsConvert;
import cn.acsm.module.transaction.shelves.dal.dataobject.shelves.ShelvesRespDO;
import cn.acsm.module.transaction.shelves.dal.dataobject.specifications.SpecificationsDO;
import cn.acsm.module.transaction.shelves.dal.mysql.specifications.SpecificationsMapper;
import cn.acsm.module.transaction.shelves.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.*;
import cn.acsm.module.transaction.shelves.controller.admin.shelves.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.shelves.ShelvesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.shelves.convert.shelves.ShelvesConvert;
import cn.acsm.module.transaction.shelves.dal.mysql.shelves.ShelvesMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.shelves.enums.ErrorCodeConstants.*;

/**
 * 货架 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ShelvesServiceImpl implements ShelvesService {

    @Resource
    private ShelvesMapper shelvesMapper;

    @Resource
    private ShelvesApi shelvesApi;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Resource
    private SpecificationsMapper specificationsMapper;

    @Override
    @Transactional
    public String createShelves(ShelvesCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("shelves"+tenantId);

        if (createReqVO.getSpecificationsCreateReqVOS()!=null && createReqVO.getSpecificationsCreateReqVOS().size()!=0){
            BigDecimal addNum = new BigDecimal(0.00);
            BigDecimal availableNum = new BigDecimal(0.00);
            for (SpecificationsCreateReqVO specificationsCreateReqVO : createReqVO.getSpecificationsCreateReqVOS()) {
                addNum = addNum.add(specificationsCreateReqVO.getAddNum());
                availableNum = availableNum.add(specificationsCreateReqVO.getAddNum());
            }
            createReqVO.setAddNum(addNum);
            createReqVO.setAvailableNum(availableNum);
        }

        // 插入
        ShelvesDO shelves = ShelvesConvert.INSTANCE.convert(createReqVO);
        shelves.setNumber("HJ"+number);
        shelves.setId(UUID.randomUUID().toString());
        shelvesMapper.insert(shelves);
        if (createReqVO.getSpecificationsCreateReqVOS()!=null && createReqVO.getSpecificationsCreateReqVOS().size()!=0){
            createReqVO.getSpecificationsCreateReqVOS().stream().forEach(specificationsCreateReqVO -> {
                // 插入
                SpecificationsDO specifications = SpecificationsConvert.INSTANCE.convert(specificationsCreateReqVO);
                specifications.setId(UUID.randomUUID().toString());
                specificationsMapper.insert(specifications);
            });
        }
        // 返回
        return shelves.getId();
    }

    @Override
    public void updateshelves(ShelvesUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateshelvesExists(updateReqVO.getId());
        // 更新
        ShelvesDO updateObj = ShelvesConvert.INSTANCE.convert(updateReqVO);
        shelvesMapper.updateById(updateObj);
    }


    @Override
    public void deleteshelves(String id) {
        // 校验存在
        this.validateshelvesExists(id);
        // 删除
        shelvesMapper.deleteById(id);
    }

    private void validateshelvesExists(String id) {
        if (shelvesMapper.selectById(id) == null) {
            throw exception(SHELVES_NOT_EXISTS);
        }
    }

    @Override
    public ShelvesDO getshelves(String id) {
        return shelvesMapper.selectById(id);
    }

    @Override
    public List<ShelvesDO> getshelvesList(Collection<String> ids) {
        return shelvesMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ShelvesDO> getshelvesPage(shelvesPageReqVO pageReqVO) {
        return shelvesMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ShelvesDO> getshelvesList(ShelvesExportReqVO exportReqVO) {
        return shelvesMapper.selectList(exportReqVO);
    }

    @Override
    public List<ShelvesSalesRespVO> findShelves(ShelvesReqVO shelvesReqVO) {
        ShelvesSalesReqDto shelvesSalesReqDto = ShelvesConvert.INSTANCE.convertShelvesSalesReq(shelvesReqVO);
        CommonResult<List<ShelvesSalesRespDto>> shelvesSalesRespDtos = shelvesApi.findSales(shelvesSalesReqDto);
        return ShelvesConvert.INSTANCE.convertShelvesSalesResp(shelvesSalesRespDtos.getData());
    }

    @Override
    public List<ShelvesSalesRespVO> findSpecifications(ShelvesReqVO shelvesReqVO) {
        ShelvesSalesReqDto shelvesSalesReqDto = ShelvesConvert.INSTANCE.convertShelvesSalesReq(shelvesReqVO);
        CommonResult<List<ShelvesSalesRespDto>> shelvesSalesRespDtos = shelvesApi.findSpecifications(shelvesSalesReqDto);
        return ShelvesConvert.INSTANCE.convertShelvesSalesResp(shelvesSalesRespDtos.getData());
    }

    @Override
    public List<ShelvesRespDto> findShelvesList(ShelvesReqDto shelvesReqDto) {
        List<ShelvesRespDO>  priceTagShelves = shelvesMapper.findPriceTagShelves(shelvesReqDto);
        return ShelvesConvert.INSTANCE.convertShelvesPriceTag(priceTagShelves);
    }

    @Override
    public List<ShelvesRespDto> findSpecificationsList(ShelvesReqDto shelvesReqDto) {
        List<ShelvesRespDO>  priceTagShelves = shelvesMapper.findPriceTagSpecifications(shelvesReqDto);
        return ShelvesConvert.INSTANCE.convertShelvesPriceTag(priceTagShelves);
    }

}
