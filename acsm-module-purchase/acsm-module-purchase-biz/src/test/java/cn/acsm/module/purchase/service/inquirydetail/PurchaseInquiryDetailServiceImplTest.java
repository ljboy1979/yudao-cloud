package cn.acsm.module.purchase.service.inquirydetail;

import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailCreateReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailExportReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailPageReqVO;
import cn.acsm.module.purchase.controller.admin.inquirydetail.vo.PurchaseInquiryDetailUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.inquirydetail.PurchaseInquiryDetailDO;
import cn.acsm.module.purchase.dal.mysql.inquirydetail.PurchaseInquiryDetailMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.INQUIRY_DETAIL_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseInquiryDetailServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseInquiryDetailServiceImpl.class)
public class PurchaseInquiryDetailServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseInquiryDetailServiceImpl inquiryDetailService;

    @Resource
    private PurchaseInquiryDetailMapper inquiryDetailMapper;

    @Test
    public void testCreateInquiryDetail_success() {
        // 准备参数
        PurchaseInquiryDetailCreateReqVO reqVO = randomPojo(PurchaseInquiryDetailCreateReqVO.class);

        // 调用
        Long inquiryDetailId = inquiryDetailService.createInquiryDetail(reqVO);
        // 断言
        assertNotNull(inquiryDetailId);
        // 校验记录的属性是否正确
        PurchaseInquiryDetailDO inquiryDetail = inquiryDetailMapper.selectById(inquiryDetailId);
        assertPojoEquals(reqVO, inquiryDetail);
    }

    @Test
    public void testUpdateInquiryDetail_success() {
        // mock 数据
        PurchaseInquiryDetailDO dbInquiryDetail = randomPojo(PurchaseInquiryDetailDO.class);
        inquiryDetailMapper.insert(dbInquiryDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseInquiryDetailUpdateReqVO reqVO = randomPojo(PurchaseInquiryDetailUpdateReqVO.class, o -> {
            o.setId(dbInquiryDetail.getId()); // 设置更新的 ID
        });

        // 调用
        inquiryDetailService.updateInquiryDetail(reqVO);
        // 校验是否更新正确
        PurchaseInquiryDetailDO inquiryDetail = inquiryDetailMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, inquiryDetail);
    }

    @Test
    public void testUpdateInquiryDetail_notExists() {
        // 准备参数
        PurchaseInquiryDetailUpdateReqVO reqVO = randomPojo(PurchaseInquiryDetailUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> inquiryDetailService.updateInquiryDetail(reqVO), INQUIRY_DETAIL_NOT_EXISTS);
    }

    @Test
    public void testDeleteInquiryDetail_success() {
        // mock 数据
        PurchaseInquiryDetailDO dbInquiryDetail = randomPojo(PurchaseInquiryDetailDO.class);
        inquiryDetailMapper.insert(dbInquiryDetail);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbInquiryDetail.getId();

        // 调用
        inquiryDetailService.deleteInquiryDetail(id);
       // 校验数据不存在了
       assertNull(inquiryDetailMapper.selectById(id));
    }

    @Test
    public void testDeleteInquiryDetail_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> inquiryDetailService.deleteInquiryDetail(id), INQUIRY_DETAIL_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInquiryDetailPage() {
       // mock 数据
       PurchaseInquiryDetailDO dbInquiryDetail = randomPojo(PurchaseInquiryDetailDO.class, o -> { // 等会查询到
           o.setEnquiryId(null);
           o.setCommodityId(null);
           o.setCommodityCategoryId(null);
           o.setProductSpecificationsId(null);
           o.setPlannedQuantityMin(null);
           o.setPlannedQuantityMax(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inquiryDetailMapper.insert(dbInquiryDetail);
       // 测试 enquiryId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setEnquiryId(null)));
       // 测试 commodityId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setCommodityId(null)));
       // 测试 commodityCategoryId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setCommodityCategoryId(null)));
       // 测试 productSpecificationsId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setProductSpecificationsId(null)));
       // 测试 plannedQuantityMin 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setPlannedQuantityMin(null)));
       // 测试 plannedQuantityMax 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setPlannedQuantityMax(null)));
       // 测试 createTime 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setSourceId(null)));
       // 准备参数
       PurchaseInquiryDetailPageReqVO reqVO = new PurchaseInquiryDetailPageReqVO();
       reqVO.setEnquiryId(null);
       reqVO.setCommodityId(null);
       reqVO.setCommodityCategoryId(null);
       reqVO.setProductSpecificationsId(null);
       reqVO.setPlannedQuantityMin(null);
       reqVO.setPlannedQuantityMax(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
//       PageResult<PurchaseInquiryDetailDO> pageResult = inquiryDetailService.getInquiryDetailPage(reqVO);
       // 断言
//       assertEquals(1, pageResult.getTotal());
//       assertEquals(1, pageResult.getList().size());
//       assertPojoEquals(dbInquiryDetail, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInquiryDetailList() {
       // mock 数据
       PurchaseInquiryDetailDO dbInquiryDetail = randomPojo(PurchaseInquiryDetailDO.class, o -> { // 等会查询到
           o.setEnquiryId(null);
           o.setCommodityId(null);
           o.setCommodityCategoryId(null);
           o.setProductSpecificationsId(null);
           o.setPlannedQuantityMin(null);
           o.setPlannedQuantityMax(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
           o.setUserId(null);
           o.setSourceId(null);
       });
       inquiryDetailMapper.insert(dbInquiryDetail);
       // 测试 enquiryId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setEnquiryId(null)));
       // 测试 commodityId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setCommodityId(null)));
       // 测试 commodityCategoryId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setCommodityCategoryId(null)));
       // 测试 productSpecificationsId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setProductSpecificationsId(null)));
       // 测试 plannedQuantityMin 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setPlannedQuantityMin(null)));
       // 测试 plannedQuantityMax 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setPlannedQuantityMax(null)));
       // 测试 createTime 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setSubjectId(null)));
       // 测试 userId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setUserId(null)));
       // 测试 sourceId 不匹配
       inquiryDetailMapper.insert(cloneIgnoreId(dbInquiryDetail, o -> o.setSourceId(null)));
       // 准备参数
       PurchaseInquiryDetailExportReqVO reqVO = new PurchaseInquiryDetailExportReqVO();
       reqVO.setEnquiryId(null);
       reqVO.setCommodityId(null);
       reqVO.setCommodityCategoryId(null);
       reqVO.setProductSpecificationsId(null);
       reqVO.setPlannedQuantityMin(null);
       reqVO.setPlannedQuantityMax(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);
       reqVO.setUserId(null);
       reqVO.setSourceId(null);

       // 调用
       List<PurchaseInquiryDetailDO> list = inquiryDetailService.getInquiryDetailList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInquiryDetail, list.get(0));
    }

}
