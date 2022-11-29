package cn.acsm.module.transaction.sales.service.commodity;

import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.CommodityCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.CommodityExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.CommodityPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.CommodityUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import cn.acsm.module.transaction.sales.dal.mysql.commodity.CommodityMapper;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import cn.acsm.module.transaction.sales.service.commodity.CommodityServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link CommodityServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CommodityServiceImpl.class)
public class CommodityServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CommodityServiceImpl commodityService;

    @Resource
    private CommodityMapper commodityMapper;

    @Test
    public void testCreateCommodity_success() {
        // 准备参数
        CommodityCreateReqVO reqVO = randomPojo(CommodityCreateReqVO.class);

        // 调用
        String commodityId = commodityService.createCommodity(reqVO);
        // 断言
        assertNotNull(commodityId);
        // 校验记录的属性是否正确
        CommodityDO commodity = commodityMapper.selectById(commodityId);
        assertPojoEquals(reqVO, commodity);
    }



    @Test
    public void testUpdateCommodity_success() {
        // mock 数据
        CommodityDO dbCommodity = randomPojo(CommodityDO.class);
        commodityMapper.insert(dbCommodity);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CommodityUpdateReqVO reqVO = randomPojo(CommodityUpdateReqVO.class, o -> {
            o.setId(dbCommodity.getId()); // 设置更新的 ID
        });

        // 调用
        commodityService.updateCommodity(reqVO);
        // 校验是否更新正确
        CommodityDO commodity = commodityMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, commodity);
    }
    @Test
    public void testUpdateCommodity_notExists() {
        // 准备参数
        CommodityUpdateReqVO reqVO = randomPojo2(CommodityUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> commodityService.updateCommodity(reqVO), ErrorCodeConstants.COMMODITY_NOT_EXISTS);
    }

    private CommodityUpdateReqVO randomPojo2(Class<CommodityUpdateReqVO> commodityUpdateReqVOClass) {
        return null;
    }

    @Test
    public void testDeleteCommodity_success() {
        // mock 数据
        CommodityDO dbCommodity = randomPojo(CommodityDO.class);
        commodityMapper.insert(dbCommodity);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbCommodity.getId();

        // 调用
        commodityService.deleteCommodity(id);
       // 校验数据不存在了
       assertNull(commodityMapper.selectById(id));
    }

    @Test
    public void testDeleteCommodity_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> commodityService.deleteCommodity(id), ErrorCodeConstants.COMMODITY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommodityPage() {
       // mock 数据
       CommodityDO dbCommodity = randomPojo(CommodityDO.class, o -> { // 等会查询到
           o.setCommodityCode(null);
           o.setArticleNo(null);
           o.setCommodityBarCode(null);
           o.setCommodityName(null);
           o.setType(null);
           o.setSort(null);
           o.setKeyWord(null);
           o.setManufacturer(null);
           o.setBatch(null);
           o.setAvailableNum(null);
           o.setProviderName(null);
           o.setProviderId(null);
           o.setOldProviderId(null);
           o.setSpecNum(null);
           o.setLableIds(null);
           o.setWarnStockNum(null);
           o.setWeightUnit(null);
           o.setPackageUnit(null);
           o.setCommodityCategoryId(null);
           o.setManufacturerName(null);
           o.setWholesalePrice(null);
           o.setRetailPrice(null);
           o.setStockNum(null);
           o.setSaleState(null);
           o.setIntroduction(null);
           o.setTraceStatus(null);
           o.setPlantId(null);
           o.setCommodityPlantId(null);
           o.setSellType(null);
           o.setAddType(null);
           o.setAddress(null);
           o.setNum(null);
           o.setSyncStatus(null);
           o.setArriveDate(null);
           o.setCommodityType(null);
           o.setCommodityImg(null);
           o.setPublicityPrice(null);
           o.setProductionAddress(null);
           o.setOriginPlace(null);
           o.setAntName(null);
           o.setCreateId(null);
           o.setVideoUrl(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       commodityMapper.insert(dbCommodity);
       // 测试 commodityCode 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityCode(null)));
       // 测试 articleNo 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setArticleNo(null)));
       // 测试 commodityBarCode 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityBarCode(null)));
       // 测试 commodityName 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityName(null)));
       // 测试 type 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setType(null)));
       // 测试 sort 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSort(null)));
       // 测试 keyWord 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setKeyWord(null)));
       // 测试 manufacturer 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setManufacturer(null)));
       // 测试 batch 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setBatch(null)));
       // 测试 availableNum 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setAvailableNum(null)));
       // 测试 providerName 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setProviderName(null)));
       // 测试 providerId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setProviderId(null)));
       // 测试 oldProviderId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setOldProviderId(null)));
       // 测试 specNum 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSpecNum(null)));
       // 测试 lableIds 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setLableIds(null)));
       // 测试 warnStockNum 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setWarnStockNum(null)));
       // 测试 weightUnit 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setWeightUnit(null)));
       // 测试 packageUnit 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setPackageUnit(null)));
       // 测试 commodityCategoryId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityCategoryId(null)));
       // 测试 manufacturerName 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setManufacturerName(null)));
       // 测试 wholesalePrice 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setWholesalePrice(null)));
       // 测试 retailPrice 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setRetailPrice(null)));
       // 测试 stockNum 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setStockNum(null)));
       // 测试 saleState 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSaleState(null)));
       // 测试 introduction 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setIntroduction(null)));
       // 测试 traceStatus 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setTraceStatus(null)));
       // 测试 plantId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setPlantId(null)));
       // 测试 commodityPlantId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityPlantId(null)));
       // 测试 sellType 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSellType(null)));
       // 测试 addType 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setAddType(null)));
       // 测试 address 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setAddress(null)));
       // 测试 num 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setNum(null)));
       // 测试 syncStatus 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSyncStatus(null)));
       // 测试 arriveDate 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setArriveDate(null)));
       // 测试 commodityType 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityType(null)));
       // 测试 commodityImg 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityImg(null)));
       // 测试 publicityPrice 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setPublicityPrice(null)));
       // 测试 productionAddress 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setProductionAddress(null)));
       // 测试 originPlace 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setOriginPlace(null)));
       // 测试 antName 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setAntName(null)));
       // 测试 createId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCreateId(null)));
       // 测试 videoUrl 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setVideoUrl(null)));
       // 测试 status 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCreateTime(null)));
       // 准备参数
       CommodityPageReqVO reqVO = new CommodityPageReqVO();
       reqVO.setCommodityCode(null);
       reqVO.setArticleNo(null);
       reqVO.setCommodityBarCode(null);
       reqVO.setCommodityName(null);
       reqVO.setType(null);
       reqVO.setSort(null);
       reqVO.setKeyWord(null);
       reqVO.setManufacturer(null);
       reqVO.setBatch(null);
       reqVO.setAvailableNum(null);
       reqVO.setProviderName(null);
       reqVO.setProviderId(null);
       reqVO.setOldProviderId(null);
       reqVO.setSpecNum(null);
       reqVO.setLableIds(null);
       reqVO.setWarnStockNum(null);
       reqVO.setWeightUnit(null);
       reqVO.setPackageUnit(null);
       reqVO.setCommodityCategoryId(null);
       reqVO.setManufacturerName(null);
       reqVO.setWholesalePrice(null);
       reqVO.setRetailPrice(null);
       reqVO.setStockNum(null);
       reqVO.setSaleState(null);
       reqVO.setIntroduction(null);
       reqVO.setTraceStatus(null);
       reqVO.setPlantId(null);
       reqVO.setCommodityPlantId(null);
       reqVO.setSellType(null);
       reqVO.setAddType(null);
       reqVO.setAddress(null);
       reqVO.setNum(null);
       reqVO.setSyncStatus(null);
       reqVO.setArriveDate((new Date[]{}));
       reqVO.setCommodityType(null);
       reqVO.setCommodityImg(null);
       reqVO.setPublicityPrice(null);
       reqVO.setProductionAddress(null);
       reqVO.setOriginPlace(null);
       reqVO.setAntName(null);
       reqVO.setCreateId(null);
       reqVO.setVideoUrl(null);
       reqVO.setStatus(null);

       // 调用
       PageResult<CommodityDO> pageResult = commodityService.getCommodityPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCommodity, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommodityList() {
       // mock 数据
       CommodityDO dbCommodity = randomPojo(CommodityDO.class, o -> { // 等会查询到
           o.setCommodityCode(null);
           o.setArticleNo(null);
           o.setCommodityBarCode(null);
           o.setCommodityName(null);
           o.setType(null);
           o.setSort(null);
           o.setKeyWord(null);
           o.setManufacturer(null);
           o.setBatch(null);
           o.setAvailableNum(null);
           o.setProviderName(null);
           o.setProviderId(null);
           o.setOldProviderId(null);
           o.setSpecNum(null);
           o.setLableIds(null);
           o.setWarnStockNum(null);
           o.setWeightUnit(null);
           o.setPackageUnit(null);
           o.setCommodityCategoryId(null);
           o.setManufacturerName(null);
           o.setWholesalePrice(null);
           o.setRetailPrice(null);
           o.setStockNum(null);
           o.setSaleState(null);
           o.setIntroduction(null);
           o.setTraceStatus(null);
           o.setPlantId(null);
           o.setCommodityPlantId(null);
           o.setSellType(null);
           o.setAddType(null);
           o.setAddress(null);
           o.setNum(null);
           o.setSyncStatus(null);
           o.setArriveDate(null);
           o.setCommodityType(null);
           o.setCommodityImg(null);
           o.setPublicityPrice(null);
           o.setProductionAddress(null);
           o.setOriginPlace(null);
           o.setAntName(null);
           o.setCreateId(null);
           o.setVideoUrl(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       commodityMapper.insert(dbCommodity);
       // 测试 commodityCode 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityCode(null)));
       // 测试 articleNo 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setArticleNo(null)));
       // 测试 commodityBarCode 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityBarCode(null)));
       // 测试 commodityName 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityName(null)));
       // 测试 type 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setType(null)));
       // 测试 sort 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSort(null)));
       // 测试 keyWord 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setKeyWord(null)));
       // 测试 manufacturer 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setManufacturer(null)));
       // 测试 batch 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setBatch(null)));
       // 测试 availableNum 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setAvailableNum(null)));
       // 测试 providerName 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setProviderName(null)));
       // 测试 providerId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setProviderId(null)));
       // 测试 oldProviderId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setOldProviderId(null)));
       // 测试 specNum 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSpecNum(null)));
       // 测试 lableIds 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setLableIds(null)));
       // 测试 warnStockNum 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setWarnStockNum(null)));
       // 测试 weightUnit 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setWeightUnit(null)));
       // 测试 packageUnit 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setPackageUnit(null)));
       // 测试 commodityCategoryId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityCategoryId(null)));
       // 测试 manufacturerName 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setManufacturerName(null)));
       // 测试 wholesalePrice 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setWholesalePrice(null)));
       // 测试 retailPrice 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setRetailPrice(null)));
       // 测试 stockNum 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setStockNum(null)));
       // 测试 saleState 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSaleState(null)));
       // 测试 introduction 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setIntroduction(null)));
       // 测试 traceStatus 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setTraceStatus(null)));
       // 测试 plantId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setPlantId(null)));
       // 测试 commodityPlantId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityPlantId(null)));
       // 测试 sellType 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSellType(null)));
       // 测试 addType 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setAddType(null)));
       // 测试 address 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setAddress(null)));
       // 测试 num 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setNum(null)));
       // 测试 syncStatus 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setSyncStatus(null)));
       // 测试 arriveDate 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setArriveDate(null)));
       // 测试 commodityType 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityType(null)));
       // 测试 commodityImg 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCommodityImg(null)));
       // 测试 publicityPrice 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setPublicityPrice(null)));
       // 测试 productionAddress 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setProductionAddress(null)));
       // 测试 originPlace 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setOriginPlace(null)));
       // 测试 antName 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setAntName(null)));
       // 测试 createId 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCreateId(null)));
       // 测试 videoUrl 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setVideoUrl(null)));
       // 测试 status 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       commodityMapper.insert(cloneIgnoreId(dbCommodity, o -> o.setCreateTime(null)));
       // 准备参数
       CommodityExportReqVO reqVO = new CommodityExportReqVO();
       reqVO.setCommodityCode(null);
       reqVO.setArticleNo(null);
       reqVO.setCommodityBarCode(null);
       reqVO.setCommodityName(null);
       reqVO.setType(null);
       reqVO.setSort(null);
       reqVO.setKeyWord(null);
       reqVO.setManufacturer(null);
       reqVO.setBatch(null);
       reqVO.setAvailableNum(null);
       reqVO.setProviderName(null);
       reqVO.setProviderId(null);
       reqVO.setOldProviderId(null);
       reqVO.setSpecNum(null);
       reqVO.setLableIds(null);
       reqVO.setWarnStockNum(null);
       reqVO.setWeightUnit(null);
       reqVO.setPackageUnit(null);
       reqVO.setCommodityCategoryId(null);
       reqVO.setManufacturerName(null);
       reqVO.setWholesalePrice(null);
       reqVO.setRetailPrice(null);
       reqVO.setStockNum(null);
       reqVO.setSaleState(null);
       reqVO.setIntroduction(null);
       reqVO.setTraceStatus(null);
       reqVO.setPlantId(null);
       reqVO.setCommodityPlantId(null);
       reqVO.setSellType(null);
       reqVO.setAddType(null);
       reqVO.setAddress(null);
       reqVO.setNum(null);
       reqVO.setSyncStatus(null);
       reqVO.setArriveDate((new Date[]{}));
       reqVO.setCommodityType(null);
       reqVO.setCommodityImg(null);
       reqVO.setPublicityPrice(null);
       reqVO.setProductionAddress(null);
       reqVO.setOriginPlace(null);
       reqVO.setAntName(null);
       reqVO.setCreateId(null);
       reqVO.setVideoUrl(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<CommodityDO> list = commodityService.getCommodityList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCommodity, list.get(0));
    }

}
