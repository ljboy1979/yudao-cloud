package cn.acsm.module.purchase.service.quotation;

import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationCreateReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationExportReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationPageReqVO;
import cn.acsm.module.purchase.controller.admin.quotation.vo.PurchaseQuotationUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.quotation.PurchaseQuotationDO;
import cn.acsm.module.purchase.dal.mysql.quotation.PurchaseQuotationMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.QUOTATION_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseQuotationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseQuotationServiceImpl.class)
public class PurchaseQuotationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseQuotationServiceImpl quotationService;

    @Resource
    private PurchaseQuotationMapper quotationMapper;

    @Test
    public void testCreateQuotation_success() {
        // 准备参数
        PurchaseQuotationCreateReqVO reqVO = randomPojo(PurchaseQuotationCreateReqVO.class);

        // 调用
        Long quotationId = quotationService.createQuotation(reqVO);
        // 断言
        assertNotNull(quotationId);
        // 校验记录的属性是否正确
        PurchaseQuotationDO quotation = quotationMapper.selectById(quotationId);
        assertPojoEquals(reqVO, quotation);
    }

    @Test
    public void testUpdateQuotation_success() {
        // mock 数据
        PurchaseQuotationDO dbQuotation = randomPojo(PurchaseQuotationDO.class);
        quotationMapper.insert(dbQuotation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseQuotationUpdateReqVO reqVO = randomPojo(PurchaseQuotationUpdateReqVO.class, o -> {
            o.setId(dbQuotation.getId()); // 设置更新的 ID
        });

        // 调用
        quotationService.updateQuotation(reqVO);
        // 校验是否更新正确
        PurchaseQuotationDO quotation = quotationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, quotation);
    }

    @Test
    public void testUpdateQuotation_notExists() {
        // 准备参数
        PurchaseQuotationUpdateReqVO reqVO = randomPojo(PurchaseQuotationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> quotationService.updateQuotation(reqVO), QUOTATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteQuotation_success() {
        // mock 数据
        PurchaseQuotationDO dbQuotation = randomPojo(PurchaseQuotationDO.class);
        quotationMapper.insert(dbQuotation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbQuotation.getId();

        // 调用
        quotationService.deleteQuotation(id);
       // 校验数据不存在了
       assertNull(quotationMapper.selectById(id));
    }

    @Test
    public void testDeleteQuotation_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> quotationService.deleteQuotation(id), QUOTATION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetQuotationPage() {
       // mock 数据
       PurchaseQuotationDO dbQuotation = randomPojo(PurchaseQuotationDO.class, o -> { // 等会查询到
           o.setQuotationNo(null);
           o.setQuotationName(null);
           o.setPurchaserId(null);
           o.setInquiryId(null);
           o.setInquiryNo(null);
           o.setQuotationValidTime(null);
           o.setIsSubmit(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       quotationMapper.insert(dbQuotation);
       // 测试 quotationNo 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setQuotationNo(null)));
       // 测试 quotationName 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setQuotationName(null)));
       // 测试 purchaserId 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setPurchaserId(null)));
       // 测试 inquiryId 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setInquiryId(null)));
       // 测试 inquiryNo 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setInquiryNo(null)));
       // 测试 quotationValidTime 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setQuotationValidTime(null)));
       // 测试 isSubmit 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setIsSubmit(null)));
       // 测试 createTime 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseQuotationPageReqVO reqVO = new PurchaseQuotationPageReqVO();
       reqVO.setQuotationNo(null);
       reqVO.setQuotationName(null);
       reqVO.setPurchaserId(null);
       reqVO.setInquiryId(null);
       reqVO.setInquiryNo(null);
       reqVO.setQuotationValidTime((new Date[]{}));
       reqVO.setIsSubmit(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PurchaseQuotationDO> pageResult = quotationService.getQuotationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbQuotation, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetQuotationList() {
       // mock 数据
       PurchaseQuotationDO dbQuotation = randomPojo(PurchaseQuotationDO.class, o -> { // 等会查询到
           o.setQuotationNo(null);
           o.setQuotationName(null);
           o.setPurchaserId(null);
           o.setInquiryId(null);
           o.setInquiryNo(null);
           o.setQuotationValidTime(null);
           o.setIsSubmit(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       quotationMapper.insert(dbQuotation);
       // 测试 quotationNo 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setQuotationNo(null)));
       // 测试 quotationName 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setQuotationName(null)));
       // 测试 purchaserId 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setPurchaserId(null)));
       // 测试 inquiryId 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setInquiryId(null)));
       // 测试 inquiryNo 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setInquiryNo(null)));
       // 测试 quotationValidTime 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setQuotationValidTime(null)));
       // 测试 isSubmit 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setIsSubmit(null)));
       // 测试 createTime 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       quotationMapper.insert(cloneIgnoreId(dbQuotation, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseQuotationExportReqVO reqVO = new PurchaseQuotationExportReqVO();
       reqVO.setQuotationNo(null);
       reqVO.setQuotationName(null);
       reqVO.setPurchaserId(null);
       reqVO.setInquiryId(null);
       reqVO.setInquiryNo(null);
       reqVO.setQuotationValidTime((new Date[]{}));
       reqVO.setIsSubmit(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<PurchaseQuotationDO> list = quotationService.getQuotationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbQuotation, list.get(0));
    }

}
