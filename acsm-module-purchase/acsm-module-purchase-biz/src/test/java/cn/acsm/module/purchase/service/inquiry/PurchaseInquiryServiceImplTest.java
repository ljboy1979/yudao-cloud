package cn.acsm.module.purchase.service.inquiry;

import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryCreateReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryPageReqVO;
import cn.acsm.module.purchase.controller.admin.inquiry.vo.PurchaseInquiryUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.inquiry.PurchaseInquiryDO;
import cn.acsm.module.purchase.dal.mysql.inquiry.PurchaseInquiryMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.INQUIRY_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseInquiryServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseInquiryServiceImpl.class)
public class PurchaseInquiryServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseInquiryServiceImpl inquiryService;

    @Resource
    private PurchaseInquiryMapper inquiryMapper;

    @Test
    public void testCreateInquiry_success() {
        // 准备参数
        PurchaseInquiryCreateReqVO reqVO = randomPojo(PurchaseInquiryCreateReqVO.class);

        // 调用
        Long inquiryId = inquiryService.createInquiry(reqVO);
        // 断言
        assertNotNull(inquiryId);
        // 校验记录的属性是否正确
        PurchaseInquiryDO inquiry = inquiryMapper.selectById(inquiryId);
        assertPojoEquals(reqVO, inquiry);
    }

    @Test
    public void testUpdateInquiry_success() {
        // mock 数据
        PurchaseInquiryDO dbInquiry = randomPojo(PurchaseInquiryDO.class);
        inquiryMapper.insert(dbInquiry);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseInquiryUpdateReqVO reqVO = randomPojo(PurchaseInquiryUpdateReqVO.class, o -> {
            o.setId(dbInquiry.getId()); // 设置更新的 ID
        });

        // 调用
        inquiryService.updateInquiry(reqVO);
        // 校验是否更新正确
        PurchaseInquiryDO inquiry = inquiryMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, inquiry);
    }

    @Test
    public void testUpdateInquiry_notExists() {
        // 准备参数
        PurchaseInquiryUpdateReqVO reqVO = randomPojo(PurchaseInquiryUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> inquiryService.updateInquiry(reqVO), INQUIRY_NOT_EXISTS);
    }

    @Test
    public void testDeleteInquiry_success() {
        // mock 数据
        PurchaseInquiryDO dbInquiry = randomPojo(PurchaseInquiryDO.class);
        inquiryMapper.insert(dbInquiry);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbInquiry.getId();

        // 调用
        inquiryService.deleteInquiry(id);
       // 校验数据不存在了
       assertNull(inquiryMapper.selectById(id));
    }

    @Test
    public void testDeleteInquiry_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> inquiryService.deleteInquiry(id), INQUIRY_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInquiryPage() {
       // mock 数据
       PurchaseInquiryDO dbInquiry = randomPojo(PurchaseInquiryDO.class, o -> { // 等会查询到
           o.setEnquiryId(null);
           o.setEnquiryName(null);
           o.setProviderId(null);
           o.setProviderName(null);
           o.setPostStatus(null);
           o.setEnquiryStatus(null);
           o.setReleaseTime(null);
           o.setReadStatus(null);
           o.setUid(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inquiryMapper.insert(dbInquiry);
       // 测试 enquiryId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setEnquiryId(null)));
       // 测试 enquiryName 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setEnquiryName(null)));
       // 测试 providerId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setProviderId(null)));
       // 测试 providerName 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setProviderName(null)));
       // 测试 postStatus 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setPostStatus(null)));
       // 测试 enquiryStatus 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setEnquiryStatus(null)));
       // 测试 releaseTime 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setReleaseTime(null)));
       // 测试 readStatus 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setReadStatus(null)));
       // 测试 uid 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setUid(null)));
       // 测试 createTime 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setSourceId(null)));
       // 准备参数
       PurchaseInquiryPageReqVO reqVO = new PurchaseInquiryPageReqVO();
       reqVO.setEnquiryId(null);
       reqVO.setEnquiryName(null);
       reqVO.setProviderId(null);
       reqVO.setProviderName(null);
       reqVO.setPostStatus(null);
       reqVO.setEnquiryStatus(null);
       reqVO.setReleaseTime((new Date[]{}));
       reqVO.setReadStatus(null);
       reqVO.setUid(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       PageResult<PurchaseInquiryDO> pageResult = inquiryService.getInquiryPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInquiry, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInquiryList() {
       // mock 数据
       PurchaseInquiryDO dbInquiry = randomPojo(PurchaseInquiryDO.class, o -> { // 等会查询到
           o.setEnquiryId(null);
           o.setEnquiryName(null);
           o.setProviderId(null);
           o.setProviderName(null);
           o.setPostStatus(null);
           o.setEnquiryStatus(null);
           o.setReleaseTime(null);
           o.setReadStatus(null);
           o.setUid(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inquiryMapper.insert(dbInquiry);
       // 测试 enquiryId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setEnquiryId(null)));
       // 测试 enquiryName 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setEnquiryName(null)));
       // 测试 providerId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setProviderId(null)));
       // 测试 providerName 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setProviderName(null)));
       // 测试 postStatus 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setPostStatus(null)));
       // 测试 enquiryStatus 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setEnquiryStatus(null)));
       // 测试 releaseTime 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setReleaseTime(null)));
       // 测试 readStatus 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setReadStatus(null)));
       // 测试 uid 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setUid(null)));
       // 测试 createTime 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inquiryMapper.insert(cloneIgnoreId(dbInquiry, o -> o.setSourceId(null)));
       // 准备参数
       PurchaseInquiryExportReqVO reqVO = new PurchaseInquiryExportReqVO();
       reqVO.setEnquiryId(null);
       reqVO.setEnquiryName(null);
       reqVO.setProviderId(null);
       reqVO.setProviderName(null);
       reqVO.setPostStatus(null);
       reqVO.setEnquiryStatus(null);
       reqVO.setReleaseTime((new Date[]{}));
       reqVO.setReadStatus(null);
       reqVO.setUid(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       List<PurchaseInquiryDO> list = inquiryService.getInquiryList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInquiry, list.get(0));
    }

}
