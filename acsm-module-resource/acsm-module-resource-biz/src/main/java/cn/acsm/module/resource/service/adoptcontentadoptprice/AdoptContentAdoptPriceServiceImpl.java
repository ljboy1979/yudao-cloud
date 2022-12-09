package cn.acsm.module.resource.service.adoptcontentadoptprice;

import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.*;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptright.vo.AdoptRightRespVO;
import cn.acsm.module.resource.dal.mysql.adoptright.AdoptRightMapper;
import cn.acsm.module.resource.convert.adoptright.AdoptRightConvert;
import cn.acsm.module.resource.dal.dataobject.adoptright.AdoptRightDO;
import cn.acsm.module.resource.service.adoptright.AdoptRightServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;

import cn.acsm.module.resource.dal.dataobject.adoptcontentadoptprice.AdoptContentAdoptPriceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.resource.convert.adoptcontentadoptprice.AdoptContentAdoptPriceConvert;
import cn.acsm.module.resource.dal.mysql.adoptcontentadoptprice.AdoptContentAdoptPriceMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.resource.enums.ErrorCodeConstants.*;

/**
 * 认养/租凭价格 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class AdoptContentAdoptPriceServiceImpl implements AdoptContentAdoptPriceService {

    @Resource
    private AdoptContentAdoptPriceMapper adoptContentAdoptPriceMapper;
    @Resource
    private AdoptRightMapper adoptRightMapper;
    @Resource
    private AdoptRightServiceImpl adoptRightServiceImpl;

    @Override
    public String createAdoptContentAdoptPrice(AdoptContentAdoptPriceCreateReqVO createReqVO) {
        QueryWrapper<AdoptContentAdoptPriceDO> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(createReqVO.getAdoptId())) {
            wrapper.eq("adopt_id", createReqVO.getAdoptId());
        }
        List<AdoptContentAdoptPriceDO> adoptPriceDOS = adoptContentAdoptPriceMapper.selectList(wrapper);
        if(adoptPriceDOS.size()>0){
            return "已经存在价格";
        }
        AdoptRightCreateReqVO adoptRight = createReqVO.getAdoptRight();
        if(adoptRight!=null){
            List<Map<String,String>> mapList;
            if (!CollectionUtils.isEmpty(mapList = adoptRight.getIncomeItemAmountScaleMapList())){
                final String incomeItemAmountScale = mapList.stream().filter(Objects::nonNull).map(stringStringMap ->
                        stringStringMap.get("item") + ":" +
                        stringStringMap.get("amount") + ":" +
                        stringStringMap.get("scale") + ":"+
                        stringStringMap.get("adoptTime") + ":"+
                        stringStringMap.get("adoptEndTime")
                ).collect(Collectors.joining(","));
                // 收入项：收入金额：收入比例
                adoptRight.setIncomeItemAmountScale(incomeItemAmountScale);
            }
            //保存权益
            AdoptRightDO adoptRightDO = AdoptRightConvert.INSTANCE.convert(adoptRight);
            adoptRightMapper.insert(adoptRightDO);
            createReqVO.setAdoptRightId(String.valueOf(adoptRightDO.getId()));
        }
        createReqVO.setAdoptQuota(createReqVO.getAdoptTotal());
        // 插入
        AdoptContentAdoptPriceDO adoptContentAdoptPrice = AdoptContentAdoptPriceConvert.INSTANCE.convert(createReqVO);
        adoptContentAdoptPriceMapper.insert(adoptContentAdoptPrice);
        // 返回
        return "保存权益表成功";
    }

    @Override
    public void updateAdoptContentAdoptPrice(AdoptContentAdoptPriceUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAdoptContentAdoptPriceExists(updateReqVO.getId());
        // 更新
        AdoptContentAdoptPriceDO updateObj = AdoptContentAdoptPriceConvert.INSTANCE.convert(updateReqVO);
        adoptContentAdoptPriceMapper.updateById(updateObj);
    }

    @Override
    public void deleteAdoptContentAdoptPrice(Long id) {
        // 校验存在
        this.validateAdoptContentAdoptPriceExists(id);
        // 删除
        adoptContentAdoptPriceMapper.deleteById(id);
    }

    private void validateAdoptContentAdoptPriceExists(Long id) {
        if (adoptContentAdoptPriceMapper.selectById(id) == null) {
            throw exception(ADOPT_CONTENT_ADOPT_PRICE_NOT_EXISTS);
        }
    }

    @Override
    public AdoptContentAdoptPriceDO getAdoptContentAdoptPrice(Long id) {
        return adoptContentAdoptPriceMapper.selectById(id);
    }

    @Override
    public List<AdoptContentAdoptPriceDO> getAdoptContentAdoptPriceList(Collection<Long> ids) {
        return adoptContentAdoptPriceMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AdoptContentAdoptPriceRespVO> getAdoptContentAdoptPricePage(AdoptContentAdoptPricePageReqVO pageReqVO) {
        PageResult<AdoptContentAdoptPriceDO> page = adoptContentAdoptPriceMapper.selectPage(pageReqVO);
        PageResult<AdoptContentAdoptPriceRespVO> convertPage = AdoptContentAdoptPriceConvert.INSTANCE.convertPage(page);
        if (!CollectionUtils.isEmpty(convertPage.getList())){
            List<String> stringList = convertPage.getList().stream().filter(Objects::nonNull)
                    .map(AdoptContentAdoptPriceRespVO::getAdoptRightId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(stringList)){
                Map<Long, AdoptRightRespVO> map = adoptRightServiceImpl.findListByIds(stringList);
                convertPage.getList().stream().parallel().forEach(c->
                        c.setAdoptRights(map.get(Long.valueOf(c.getAdoptRightId())))
                );
            }
        }
        return convertPage;
    }

    @Override
    public List<AdoptContentAdoptPriceDO> getAdoptContentAdoptPriceList(AdoptContentAdoptPriceExportReqVO exportReqVO) {
        return adoptContentAdoptPriceMapper.selectList(exportReqVO);
    }

}
