package cn.acsm.module.transaction.sales.service.commoditysku;

import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.CommoditySkuCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.CommoditySkuExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.CommoditySkuPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.CommoditySkuUpdateReqVO;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditysku.CommoditySkuDO;
import cn.acsm.module.transaction.sales.dal.mysql.commoditysku.CommoditySkuMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.COMMODITY_SKU_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link CommoditySkuServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CommoditySkuServiceImpl.class)
public class CommoditySkuServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CommoditySkuServiceImpl commoditySkuService;

    @Resource
    private CommoditySkuMapper commoditySkuMapper;

    @Test
    public void testCreateCommoditySku_success() {
        // 准备参数
        CommoditySkuCreateReqVO reqVO = randomPojo(CommoditySkuCreateReqVO.class);

        // 调用
        String commoditySkuId = commoditySkuService.createCommoditySku(reqVO);
        // 断言
        assertNotNull(commoditySkuId);
        // 校验记录的属性是否正确
        CommoditySkuDO commoditySku = commoditySkuMapper.selectById(commoditySkuId);
        assertPojoEquals(reqVO, commoditySku);
    }

    @Test
    public void testUpdateCommoditySku_success() {
        // mock 数据
        CommoditySkuDO dbCommoditySku = randomPojo(CommoditySkuDO.class);
        commoditySkuMapper.insert(dbCommoditySku);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CommoditySkuUpdateReqVO reqVO = randomPojo(CommoditySkuUpdateReqVO.class, o -> {
            o.setId(dbCommoditySku.getId()); // 设置更新的 ID
        });

        // 调用
        commoditySkuService.updateCommoditySku(reqVO);
        // 校验是否更新正确
        CommoditySkuDO commoditySku = commoditySkuMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, commoditySku);
    }

    @Test
    public void testUpdateCommoditySku_notExists() {
        // 准备参数
        CommoditySkuUpdateReqVO reqVO = randomPojo(CommoditySkuUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> commoditySkuService.updateCommoditySku(reqVO), COMMODITY_SKU_NOT_EXISTS);
    }

    @Test
    public void testDeleteCommoditySku_success() {
        // mock 数据
        CommoditySkuDO dbCommoditySku = randomPojo(CommoditySkuDO.class);
        commoditySkuMapper.insert(dbCommoditySku);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbCommoditySku.getId();

        // 调用
        commoditySkuService.deleteCommoditySku(id);
       // 校验数据不存在了
       assertNull(commoditySkuMapper.selectById(id));
    }

    @Test
    public void testDeleteCommoditySku_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> commoditySkuService.deleteCommoditySku(id), COMMODITY_SKU_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommoditySkuPage() {
       // mock 数据
       CommoditySkuDO dbCommoditySku = randomPojo(CommoditySkuDO.class, o -> { // 等会查询到
           o.setCommodityId(null);
           o.setShippingOrderInfoId(null);
           o.setStockManagementId(null);
           o.setVipId(null);
           o.setSkuCode(null);
           o.setBatch(null);
           o.setAvailableNum(null);
           o.setAvailableWeight(null);
           o.setSpecNum(null);
           o.setWeightUnit(null);
           o.setPackageUnit(null);
           o.setWholesalePrice(null);
           o.setRetailPrice(null);
           o.setTraceStatus(null);
           o.setSaleState(null);
           o.setTag(null);
           o.setSubjectId(null);
           o.setSaleUnit(null);
           o.setSpecName(null);
           o.setTraceBatch(null);
           o.setTraceType(null);
           o.setTraceAddress(null);
           o.setTraceContact(null);
           o.setTracePhone(null);
           o.setTraceEnterName(null);
           o.setTraceLicense(null);
           o.setCarCode(null);
           o.setZslRecordId(null);
           o.setBoothNo(null);
           o.setBoothNo(null);
           o.setLatitude(null);
           o.setLongitude(null);
           o.setMerchantId(null);
           o.setAddress(null);
           o.setArriveDate(null);
           o.setProductSpecificationsId(null);
           o.setAddType(null);
           o.setSellType(null);
           o.setProviderId(null);
           o.setOldProviderId(null);
           o.setSourceSkuId(null);
           o.setPublicityPrice(null);
           o.setPackingType(null);
           o.setStockType(null);
           o.setGoodsPrice(null);
           o.setSellingPrice(null);
           o.setPurchasePrice(null);
           o.setAddNum(null);
           o.setWeight(null);
           o.setPluCode(null);
           o.setOscommoditySkuThumbnail(null);
           o.setPersonnelInfoSlideshow(null);
           o.setPersonnelInfoDetailsFigure(null);
           o.setGrade(null);
           o.setCreateId(null);
           o.setBusinessSellerTag(null);
           o.setContent(null);
           o.setQuarantineImgs(null);
           o.setPackagingName(null);
           o.setSaleUnitName(null);
           o.setAvailablePersonnel(null);
           o.setCommodityType(null);
           o.setTracea(null);
           o.setIngredients(null);
           o.setCookingMethod(null);
           o.setSpecificationsName(null);
           o.setCollectNum(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       commoditySkuMapper.insert(dbCommoditySku);
       // 测试 commodityId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCommodityId(null)));
       // 测试 shippingOrderInfoId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setShippingOrderInfoId(null)));
       // 测试 stockManagementId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setStockManagementId(null)));
       // 测试 vipId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setVipId(null)));
       // 测试 skuCode 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSkuCode(null)));
       // 测试 batch 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setBatch(null)));
       // 测试 availableNum 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAvailableNum(null)));
       // 测试 availableWeight 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAvailableWeight(null)));
       // 测试 specNum 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSpecNum(null)));
       // 测试 weightUnit 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setWeightUnit(null)));
       // 测试 packageUnit 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPackageUnit(null)));
       // 测试 wholesalePrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setWholesalePrice(null)));
       // 测试 retailPrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setRetailPrice(null)));
       // 测试 traceStatus 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceStatus(null)));
       // 测试 saleState 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSaleState(null)));
       // 测试 tag 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTag(null)));
       // 测试 subjectId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSubjectId(null)));
       // 测试 saleUnit 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSaleUnit(null)));
       // 测试 specName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSpecName(null)));
       // 测试 traceBatch 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceBatch(null)));
       // 测试 traceType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceType(null)));
       // 测试 traceAddress 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceAddress(null)));
       // 测试 traceContact 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceContact(null)));
       // 测试 tracePhone 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTracePhone(null)));
       // 测试 traceEnterName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceEnterName(null)));
       // 测试 traceLicense 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceLicense(null)));
       // 测试 carCode 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCarCode(null)));
       // 测试 zslRecordId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setZslRecordId(null)));
       // 测试 boothNo 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setBoothNo(null)));
       // 测试 boothNo 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setBoothNo(null)));
       // 测试 latitude 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setLatitude(null)));
       // 测试 longitude 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setLongitude(null)));
       // 测试 merchantId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setMerchantId(null)));
       // 测试 address 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAddress(null)));
       // 测试 arriveDate 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setArriveDate(null)));
       // 测试 productSpecificationsId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setProductSpecificationsId(null)));
       // 测试 addType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAddType(null)));
       // 测试 sellType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSellType(null)));
       // 测试 providerId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setProviderId(null)));
       // 测试 oldProviderId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setOldProviderId(null)));
       // 测试 sourceSkuId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSourceSkuId(null)));
       // 测试 publicityPrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPublicityPrice(null)));
       // 测试 packingType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPackingType(null)));
       // 测试 stockType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setStockType(null)));
       // 测试 goodsPrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setGoodsPrice(null)));
       // 测试 sellingPrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSellingPrice(null)));
       // 测试 purchasePrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPurchasePrice(null)));
       // 测试 addNum 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAddNum(null)));
       // 测试 weight 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setWeight(null)));
       // 测试 pluCode 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPluCode(null)));
       // 测试 oscommoditySkuThumbnail 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setOscommoditySkuThumbnail(null)));
       // 测试 personnelInfoSlideshow 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPersonnelInfoSlideshow(null)));
       // 测试 personnelInfoDetailsFigure 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPersonnelInfoDetailsFigure(null)));
       // 测试 grade 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setGrade(null)));
       // 测试 createId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCreateId(null)));
       // 测试 businessSellerTag 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setBusinessSellerTag(null)));
       // 测试 content 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setContent(null)));
       // 测试 quarantineImgs 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setQuarantineImgs(null)));
       // 测试 packagingName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPackagingName(null)));
       // 测试 saleUnitName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSaleUnitName(null)));
       // 测试 availablePersonnel 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAvailablePersonnel(null)));
       // 测试 commodityType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCommodityType(null)));
       // 测试 tracea 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTracea(null)));
       // 测试 ingredients 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setIngredients(null)));
       // 测试 cookingMethod 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCookingMethod(null)));
       // 测试 specificationsName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSpecificationsName(null)));
       // 测试 collectNum 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCollectNum(null)));
       // 测试 status 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCreateTime(null)));
       // 准备参数
       CommoditySkuPageReqVO reqVO = new CommoditySkuPageReqVO();
       reqVO.setCommodityId(null);
       reqVO.setShippingOrderInfoId(null);
       reqVO.setStockManagementId(null);
       reqVO.setVipId(null);
       reqVO.setSkuCode(null);
       reqVO.setBatch(null);
       reqVO.setAvailableNum(null);
       reqVO.setAvailableWeight(null);
       reqVO.setSpecNum(null);
       reqVO.setWeightUnit(null);
       reqVO.setPackageUnit(null);
       reqVO.setWholesalePrice(null);
       reqVO.setRetailPrice(null);
       reqVO.setTraceStatus(null);
       reqVO.setSaleState(null);
       reqVO.setTag(null);
       reqVO.setSubjectId(null);
       reqVO.setSaleUnit(null);
       reqVO.setSpecName(null);
       reqVO.setTraceBatch(null);
       reqVO.setTraceType(null);
       reqVO.setTraceAddress(null);
       reqVO.setTraceContact(null);
       reqVO.setTracePhone(null);
       reqVO.setTraceEnterName(null);
       reqVO.setTraceLicense(null);
       reqVO.setCarCode(null);
       reqVO.setZslRecordId(null);
       reqVO.setBoothNo(null);
       reqVO.setBoothNo(null);
       reqVO.setLatitude(null);
       reqVO.setLongitude(null);
       reqVO.setMerchantId(null);
       reqVO.setAddress(null);
       reqVO.setArriveDate((new Date[]{}));
       reqVO.setProductSpecificationsId(null);
       reqVO.setAddType(null);
       reqVO.setSellType(null);
       reqVO.setProviderId(null);
       reqVO.setOldProviderId(null);
       reqVO.setSourceSkuId(null);
       reqVO.setPublicityPrice(null);
       reqVO.setPackingType(null);
       reqVO.setStockType(null);
       reqVO.setGoodsPrice(null);
       reqVO.setSellingPrice(null);
       reqVO.setPurchasePrice(null);
       reqVO.setAddNum(null);
       reqVO.setWeight(null);
       reqVO.setPluCode(null);
       reqVO.setOscommoditySkuThumbnail(null);
       reqVO.setPersonnelInfoSlideshow(null);
       reqVO.setPersonnelInfoDetailsFigure(null);
       reqVO.setGrade(null);
       reqVO.setCreateId(null);
       reqVO.setBusinessSellerTag(null);
       reqVO.setContent(null);
       reqVO.setQuarantineImgs(null);
       reqVO.setPackagingName(null);
       reqVO.setSaleUnitName(null);
       reqVO.setAvailablePersonnel(null);
       reqVO.setCommodityType(null);
       reqVO.setTracea(null);
       reqVO.setIngredients(null);
       reqVO.setCookingMethod(null);
       reqVO.setSpecificationsName(null);
       reqVO.setCollectNum(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<CommoditySkuDO> pageResult = commoditySkuService.getCommoditySkuPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCommoditySku, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCommoditySkuList() {
       // mock 数据
       CommoditySkuDO dbCommoditySku = randomPojo(CommoditySkuDO.class, o -> { // 等会查询到
           o.setCommodityId(null);
           o.setShippingOrderInfoId(null);
           o.setStockManagementId(null);
           o.setVipId(null);
           o.setSkuCode(null);
           o.setBatch(null);
           o.setAvailableNum(null);
           o.setAvailableWeight(null);
           o.setSpecNum(null);
           o.setWeightUnit(null);
           o.setPackageUnit(null);
           o.setWholesalePrice(null);
           o.setRetailPrice(null);
           o.setTraceStatus(null);
           o.setSaleState(null);
           o.setTag(null);
           o.setSubjectId(null);
           o.setSaleUnit(null);
           o.setSpecName(null);
           o.setTraceBatch(null);
           o.setTraceType(null);
           o.setTraceAddress(null);
           o.setTraceContact(null);
           o.setTracePhone(null);
           o.setTraceEnterName(null);
           o.setTraceLicense(null);
           o.setCarCode(null);
           o.setZslRecordId(null);
           o.setBoothNo(null);
           o.setBoothNo(null);
           o.setLatitude(null);
           o.setLongitude(null);
           o.setMerchantId(null);
           o.setAddress(null);
           o.setArriveDate(null);
           o.setProductSpecificationsId(null);
           o.setAddType(null);
           o.setSellType(null);
           o.setProviderId(null);
           o.setOldProviderId(null);
           o.setSourceSkuId(null);
           o.setPublicityPrice(null);
           o.setPackingType(null);
           o.setStockType(null);
           o.setGoodsPrice(null);
           o.setSellingPrice(null);
           o.setPurchasePrice(null);
           o.setAddNum(null);
           o.setWeight(null);
           o.setPluCode(null);
           o.setOscommoditySkuThumbnail(null);
           o.setPersonnelInfoSlideshow(null);
           o.setPersonnelInfoDetailsFigure(null);
           o.setGrade(null);
           o.setCreateId(null);
           o.setBusinessSellerTag(null);
           o.setContent(null);
           o.setQuarantineImgs(null);
           o.setPackagingName(null);
           o.setSaleUnitName(null);
           o.setAvailablePersonnel(null);
           o.setCommodityType(null);
           o.setTracea(null);
           o.setIngredients(null);
           o.setCookingMethod(null);
           o.setSpecificationsName(null);
           o.setCollectNum(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       commoditySkuMapper.insert(dbCommoditySku);
       // 测试 commodityId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCommodityId(null)));
       // 测试 shippingOrderInfoId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setShippingOrderInfoId(null)));
       // 测试 stockManagementId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setStockManagementId(null)));
       // 测试 vipId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setVipId(null)));
       // 测试 skuCode 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSkuCode(null)));
       // 测试 batch 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setBatch(null)));
       // 测试 availableNum 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAvailableNum(null)));
       // 测试 availableWeight 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAvailableWeight(null)));
       // 测试 specNum 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSpecNum(null)));
       // 测试 weightUnit 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setWeightUnit(null)));
       // 测试 packageUnit 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPackageUnit(null)));
       // 测试 wholesalePrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setWholesalePrice(null)));
       // 测试 retailPrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setRetailPrice(null)));
       // 测试 traceStatus 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceStatus(null)));
       // 测试 saleState 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSaleState(null)));
       // 测试 tag 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTag(null)));
       // 测试 subjectId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSubjectId(null)));
       // 测试 saleUnit 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSaleUnit(null)));
       // 测试 specName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSpecName(null)));
       // 测试 traceBatch 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceBatch(null)));
       // 测试 traceType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceType(null)));
       // 测试 traceAddress 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceAddress(null)));
       // 测试 traceContact 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceContact(null)));
       // 测试 tracePhone 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTracePhone(null)));
       // 测试 traceEnterName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceEnterName(null)));
       // 测试 traceLicense 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTraceLicense(null)));
       // 测试 carCode 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCarCode(null)));
       // 测试 zslRecordId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setZslRecordId(null)));
       // 测试 boothNo 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setBoothNo(null)));
       // 测试 boothNo 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setBoothNo(null)));
       // 测试 latitude 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setLatitude(null)));
       // 测试 longitude 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setLongitude(null)));
       // 测试 merchantId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setMerchantId(null)));
       // 测试 address 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAddress(null)));
       // 测试 arriveDate 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setArriveDate(null)));
       // 测试 productSpecificationsId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setProductSpecificationsId(null)));
       // 测试 addType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAddType(null)));
       // 测试 sellType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSellType(null)));
       // 测试 providerId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setProviderId(null)));
       // 测试 oldProviderId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setOldProviderId(null)));
       // 测试 sourceSkuId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSourceSkuId(null)));
       // 测试 publicityPrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPublicityPrice(null)));
       // 测试 packingType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPackingType(null)));
       // 测试 stockType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setStockType(null)));
       // 测试 goodsPrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setGoodsPrice(null)));
       // 测试 sellingPrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSellingPrice(null)));
       // 测试 purchasePrice 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPurchasePrice(null)));
       // 测试 addNum 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAddNum(null)));
       // 测试 weight 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setWeight(null)));
       // 测试 pluCode 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPluCode(null)));
       // 测试 oscommoditySkuThumbnail 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setOscommoditySkuThumbnail(null)));
       // 测试 personnelInfoSlideshow 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPersonnelInfoSlideshow(null)));
       // 测试 personnelInfoDetailsFigure 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPersonnelInfoDetailsFigure(null)));
       // 测试 grade 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setGrade(null)));
       // 测试 createId 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCreateId(null)));
       // 测试 businessSellerTag 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setBusinessSellerTag(null)));
       // 测试 content 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setContent(null)));
       // 测试 quarantineImgs 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setQuarantineImgs(null)));
       // 测试 packagingName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setPackagingName(null)));
       // 测试 saleUnitName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSaleUnitName(null)));
       // 测试 availablePersonnel 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setAvailablePersonnel(null)));
       // 测试 commodityType 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCommodityType(null)));
       // 测试 tracea 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setTracea(null)));
       // 测试 ingredients 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setIngredients(null)));
       // 测试 cookingMethod 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCookingMethod(null)));
       // 测试 specificationsName 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setSpecificationsName(null)));
       // 测试 collectNum 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCollectNum(null)));
       // 测试 status 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       commoditySkuMapper.insert(cloneIgnoreId(dbCommoditySku, o -> o.setCreateTime(null)));
       // 准备参数
       CommoditySkuExportReqVO reqVO = new CommoditySkuExportReqVO();
       reqVO.setCommodityId(null);
       reqVO.setShippingOrderInfoId(null);
       reqVO.setStockManagementId(null);
       reqVO.setVipId(null);
       reqVO.setSkuCode(null);
       reqVO.setBatch(null);
       reqVO.setAvailableNum(null);
       reqVO.setAvailableWeight(null);
       reqVO.setSpecNum(null);
       reqVO.setWeightUnit(null);
       reqVO.setPackageUnit(null);
       reqVO.setWholesalePrice(null);
       reqVO.setRetailPrice(null);
       reqVO.setTraceStatus(null);
       reqVO.setSaleState(null);
       reqVO.setTag(null);
       reqVO.setSubjectId(null);
       reqVO.setSaleUnit(null);
       reqVO.setSpecName(null);
       reqVO.setTraceBatch(null);
       reqVO.setTraceType(null);
       reqVO.setTraceAddress(null);
       reqVO.setTraceContact(null);
       reqVO.setTracePhone(null);
       reqVO.setTraceEnterName(null);
       reqVO.setTraceLicense(null);
       reqVO.setCarCode(null);
       reqVO.setZslRecordId(null);
       reqVO.setBoothNo(null);
       reqVO.setBoothNo(null);
       reqVO.setLatitude(null);
       reqVO.setLongitude(null);
       reqVO.setMerchantId(null);
       reqVO.setAddress(null);
       reqVO.setArriveDate((new Date[]{}));
       reqVO.setProductSpecificationsId(null);
       reqVO.setAddType(null);
       reqVO.setSellType(null);
       reqVO.setProviderId(null);
       reqVO.setOldProviderId(null);
       reqVO.setSourceSkuId(null);
       reqVO.setPublicityPrice(null);
       reqVO.setPackingType(null);
       reqVO.setStockType(null);
       reqVO.setGoodsPrice(null);
       reqVO.setSellingPrice(null);
       reqVO.setPurchasePrice(null);
       reqVO.setAddNum(null);
       reqVO.setWeight(null);
       reqVO.setPluCode(null);
       reqVO.setOscommoditySkuThumbnail(null);
       reqVO.setPersonnelInfoSlideshow(null);
       reqVO.setPersonnelInfoDetailsFigure(null);
       reqVO.setGrade(null);
       reqVO.setCreateId(null);
       reqVO.setBusinessSellerTag(null);
       reqVO.setContent(null);
       reqVO.setQuarantineImgs(null);
       reqVO.setPackagingName(null);
       reqVO.setSaleUnitName(null);
       reqVO.setAvailablePersonnel(null);
       reqVO.setCommodityType(null);
       reqVO.setTracea(null);
       reqVO.setIngredients(null);
       reqVO.setCookingMethod(null);
       reqVO.setSpecificationsName(null);
       reqVO.setCollectNum(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<CommoditySkuDO> list = commoditySkuService.getCommoditySkuList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCommoditySku, list.get(0));
    }

}
