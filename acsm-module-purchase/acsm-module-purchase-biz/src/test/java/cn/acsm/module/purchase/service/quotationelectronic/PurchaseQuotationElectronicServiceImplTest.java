package cn.acsm.module.purchase.service.quotationelectronic;

import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicCreateReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicExportReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicPageReqVO;
import cn.acsm.module.purchase.controller.admin.quotationelectronic.vo.PurchaseQuotationElectronicUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.quotationelectronic.PurchaseQuotationElectronicDO;
import cn.acsm.module.purchase.dal.mysql.quotationelectronic.PurchaseQuotationElectronicMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.QUOTATION_ELECTRONIC_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseQuotationElectronicServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseQuotationElectronicServiceImpl.class)
public class PurchaseQuotationElectronicServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseQuotationElectronicServiceImpl quotationElectronicService;

    @Resource
    private PurchaseQuotationElectronicMapper quotationElectronicMapper;

    @Test
    public void testCreateQuotationElectronic_success() {
        // 准备参数
        PurchaseQuotationElectronicCreateReqVO reqVO = randomPojo(PurchaseQuotationElectronicCreateReqVO.class);

        // 调用
        Long quotationElectronicId = quotationElectronicService.createQuotationElectronic(reqVO);
        // 断言
        assertNotNull(quotationElectronicId);
        // 校验记录的属性是否正确
        PurchaseQuotationElectronicDO quotationElectronic = quotationElectronicMapper.selectById(quotationElectronicId);
        assertPojoEquals(reqVO, quotationElectronic);
    }

    @Test
    public void testUpdateQuotationElectronic_success() {
        // mock 数据
        PurchaseQuotationElectronicDO dbQuotationElectronic = randomPojo(PurchaseQuotationElectronicDO.class);
        quotationElectronicMapper.insert(dbQuotationElectronic);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseQuotationElectronicUpdateReqVO reqVO = randomPojo(PurchaseQuotationElectronicUpdateReqVO.class, o -> {
            o.setId(dbQuotationElectronic.getId()); // 设置更新的 ID
        });

        // 调用
        quotationElectronicService.updateQuotationElectronic(reqVO);
        // 校验是否更新正确
        PurchaseQuotationElectronicDO quotationElectronic = quotationElectronicMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, quotationElectronic);
    }

    @Test
    public void testUpdateQuotationElectronic_notExists() {
        // 准备参数
        PurchaseQuotationElectronicUpdateReqVO reqVO = randomPojo(PurchaseQuotationElectronicUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> quotationElectronicService.updateQuotationElectronic(reqVO), QUOTATION_ELECTRONIC_NOT_EXISTS);
    }

    @Test
    public void testDeleteQuotationElectronic_success() {
        // mock 数据
        PurchaseQuotationElectronicDO dbQuotationElectronic = randomPojo(PurchaseQuotationElectronicDO.class);
        quotationElectronicMapper.insert(dbQuotationElectronic);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbQuotationElectronic.getId();

        // 调用
        quotationElectronicService.deleteQuotationElectronic(id);
       // 校验数据不存在了
       assertNull(quotationElectronicMapper.selectById(id));
    }

    @Test
    public void testDeleteQuotationElectronic_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> quotationElectronicService.deleteQuotationElectronic(id), QUOTATION_ELECTRONIC_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetQuotationElectronicPage() {
       // mock 数据
       PurchaseQuotationElectronicDO dbQuotationElectronic = randomPojo(PurchaseQuotationElectronicDO.class, o -> { // 等会查询到
           o.setQuoteId(null);
           o.setEnquiryId(null);
           o.setCommodityId(null);
           o.setCommodityCategoryId(null);
           o.setSpecificationsId(null);
           o.setBatchNumber(null);
           o.setPrice(null);
           o.setOrderSize(null);
           o.setTotalPrice(null);
           o.setStartTime(null);
           o.setEndTime(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       quotationElectronicMapper.insert(dbQuotationElectronic);
       // 测试 quoteId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setQuoteId(null)));
       // 测试 enquiryId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setEnquiryId(null)));
       // 测试 commodityId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setCommodityId(null)));
       // 测试 commodityCategoryId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setCommodityCategoryId(null)));
       // 测试 specificationsId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setSpecificationsId(null)));
       // 测试 batchNumber 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setBatchNumber(null)));
       // 测试 price 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setPrice(null)));
       // 测试 orderSize 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setOrderSize(null)));
       // 测试 totalPrice 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setTotalPrice(null)));
       // 测试 startTime 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setStartTime(null)));
       // 测试 endTime 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setEndTime(null)));
       // 测试 createTime 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseQuotationElectronicPageReqVO reqVO = new PurchaseQuotationElectronicPageReqVO();
       reqVO.setQuoteId(null);
       reqVO.setEnquiryId(null);
       reqVO.setCommodityId(null);
       reqVO.setCommodityCategoryId(null);
       reqVO.setSpecificationsId(null);
       reqVO.setBatchNumber(null);
       reqVO.setPrice(null);
       reqVO.setOrderSize(null);
       reqVO.setTotalPrice(null);
       reqVO.setStartTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PurchaseQuotationElectronicDO> pageResult = quotationElectronicService.getQuotationElectronicPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbQuotationElectronic, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetQuotationElectronicList() {
       // mock 数据
       PurchaseQuotationElectronicDO dbQuotationElectronic = randomPojo(PurchaseQuotationElectronicDO.class, o -> { // 等会查询到
           o.setQuoteId(null);
           o.setEnquiryId(null);
           o.setCommodityId(null);
           o.setCommodityCategoryId(null);
           o.setSpecificationsId(null);
           o.setBatchNumber(null);
           o.setPrice(null);
           o.setOrderSize(null);
           o.setTotalPrice(null);
           o.setStartTime(null);
           o.setEndTime(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       quotationElectronicMapper.insert(dbQuotationElectronic);
       // 测试 quoteId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setQuoteId(null)));
       // 测试 enquiryId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setEnquiryId(null)));
       // 测试 commodityId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setCommodityId(null)));
       // 测试 commodityCategoryId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setCommodityCategoryId(null)));
       // 测试 specificationsId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setSpecificationsId(null)));
       // 测试 batchNumber 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setBatchNumber(null)));
       // 测试 price 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setPrice(null)));
       // 测试 orderSize 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setOrderSize(null)));
       // 测试 totalPrice 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setTotalPrice(null)));
       // 测试 startTime 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setStartTime(null)));
       // 测试 endTime 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setEndTime(null)));
       // 测试 createTime 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       quotationElectronicMapper.insert(cloneIgnoreId(dbQuotationElectronic, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseQuotationElectronicExportReqVO reqVO = new PurchaseQuotationElectronicExportReqVO();
       reqVO.setQuoteId(null);
       reqVO.setEnquiryId(null);
       reqVO.setCommodityId(null);
       reqVO.setCommodityCategoryId(null);
       reqVO.setSpecificationsId(null);
       reqVO.setBatchNumber(null);
       reqVO.setPrice(null);
       reqVO.setOrderSize(null);
       reqVO.setTotalPrice(null);
       reqVO.setStartTime((new Date[]{}));
       reqVO.setEndTime((new Date[]{}));
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<PurchaseQuotationElectronicDO> list = quotationElectronicService.getQuotationElectronicList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbQuotationElectronic, list.get(0));
    }

}
