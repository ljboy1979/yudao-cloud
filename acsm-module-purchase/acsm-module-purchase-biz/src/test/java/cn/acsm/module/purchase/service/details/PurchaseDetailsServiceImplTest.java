package cn.acsm.module.purchase.service.details;

import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsCreateReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsExportReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsPageReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.acsm.module.purchase.dal.mysql.details.PurchaseDetailsMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.DETAILS_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PurchaseDetailsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PurchaseDetailsServiceImpl.class)
public class PurchaseDetailsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PurchaseDetailsServiceImpl detailsService;

    @Resource
    private PurchaseDetailsMapper detailsMapper;

    @Test
    public void testCreateDetails_success() {
        // 准备参数
        PurchaseDetailsCreateReqVO reqVO = randomPojo(PurchaseDetailsCreateReqVO.class);

        // 调用
        Long detailsId = detailsService.createDetails(reqVO);
        // 断言
        assertNotNull(detailsId);
        // 校验记录的属性是否正确
        PurchaseDetailsDO details = detailsMapper.selectById(detailsId);
        assertPojoEquals(reqVO, details);
    }

    @Test
    public void testUpdateDetails_success() {
        // mock 数据
        PurchaseDetailsDO dbDetails = randomPojo(PurchaseDetailsDO.class);
        detailsMapper.insert(dbDetails);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PurchaseDetailsUpdateReqVO reqVO = randomPojo(PurchaseDetailsUpdateReqVO.class, o -> {
            o.setId(dbDetails.getId()); // 设置更新的 ID
        });

        // 调用
        detailsService.updateDetails(reqVO);
        // 校验是否更新正确
        PurchaseDetailsDO details = detailsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, details);
    }

    @Test
    public void testUpdateDetails_notExists() {
        // 准备参数
        PurchaseDetailsUpdateReqVO reqVO = randomPojo(PurchaseDetailsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> detailsService.updateDetails(reqVO), DETAILS_NOT_EXISTS);
    }

    @Test
    public void testDeleteDetails_success() {
        // mock 数据
        PurchaseDetailsDO dbDetails = randomPojo(PurchaseDetailsDO.class);
        detailsMapper.insert(dbDetails);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbDetails.getId();

        // 调用
        detailsService.deleteDetails(id);
       // 校验数据不存在了
       assertNull(detailsMapper.selectById(id));
    }

    @Test
    public void testDeleteDetails_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> detailsService.deleteDetails(id), DETAILS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDetailsPage() {
       // mock 数据
       PurchaseDetailsDO dbDetails = randomPojo(PurchaseDetailsDO.class, o -> { // 等会查询到
           o.setPurchaseId(null);
           o.setPurchaseNumber(null);
           o.setGoodsId(null);
           o.setGoodsName(null);
           o.setPackagingSpecificationId(null);
           o.setPackagingSpecification(null);
           o.setUnit(null);
           o.setPackagingType(null);
           o.setBuyNumber(null);
           o.setFrequency(null);
           o.setPrice(null);
           o.setDiscount(null);
           o.setTotal(null);
           o.setStandardId(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       detailsMapper.insert(dbDetails);
       // 测试 purchaseId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPurchaseId(null)));
       // 测试 purchaseNumber 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPurchaseNumber(null)));
       // 测试 goodsId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setGoodsId(null)));
       // 测试 goodsName 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setGoodsName(null)));
       // 测试 packagingSpecificationId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPackagingSpecificationId(null)));
       // 测试 packagingSpecification 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPackagingSpecification(null)));
       // 测试 unit 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setUnit(null)));
       // 测试 packagingType 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPackagingType(null)));
       // 测试 buyNumber 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setBuyNumber(null)));
       // 测试 frequency 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setFrequency(null)));
       // 测试 price 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPrice(null)));
       // 测试 discount 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setDiscount(null)));
       // 测试 total 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setTotal(null)));
       // 测试 standardId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setStandardId(null)));
       // 测试 createTime 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseDetailsPageReqVO reqVO = new PurchaseDetailsPageReqVO();
       reqVO.setPurchaseId(null);
       reqVO.setPurchaseNumber(null);
       reqVO.setGoodsId(null);
       reqVO.setGoodsName(null);
       reqVO.setPackagingSpecificationId(null);
       reqVO.setPackagingSpecification(null);
       reqVO.setUnit(null);
       reqVO.setPackagingType(null);
       reqVO.setBuyNumber(null);
       reqVO.setFrequency(null);
       reqVO.setPrice(null);
       reqVO.setDiscount(null);
       reqVO.setTotal(null);
       reqVO.setStandardId(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PurchaseDetailsDO> pageResult = detailsService.getDetailsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDetails, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDetailsList() {
       // mock 数据
       PurchaseDetailsDO dbDetails = randomPojo(PurchaseDetailsDO.class, o -> { // 等会查询到
           o.setPurchaseId(null);
           o.setPurchaseNumber(null);
           o.setGoodsId(null);
           o.setGoodsName(null);
           o.setPackagingSpecificationId(null);
           o.setPackagingSpecification(null);
           o.setUnit(null);
           o.setPackagingType(null);
           o.setBuyNumber(null);
           o.setFrequency(null);
           o.setPrice(null);
           o.setDiscount(null);
           o.setTotal(null);
           o.setStandardId(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       detailsMapper.insert(dbDetails);
       // 测试 purchaseId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPurchaseId(null)));
       // 测试 purchaseNumber 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPurchaseNumber(null)));
       // 测试 goodsId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setGoodsId(null)));
       // 测试 goodsName 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setGoodsName(null)));
       // 测试 packagingSpecificationId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPackagingSpecificationId(null)));
       // 测试 packagingSpecification 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPackagingSpecification(null)));
       // 测试 unit 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setUnit(null)));
       // 测试 packagingType 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPackagingType(null)));
       // 测试 buyNumber 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setBuyNumber(null)));
       // 测试 frequency 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setFrequency(null)));
       // 测试 price 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setPrice(null)));
       // 测试 discount 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setDiscount(null)));
       // 测试 total 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setTotal(null)));
       // 测试 standardId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setStandardId(null)));
       // 测试 createTime 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       detailsMapper.insert(cloneIgnoreId(dbDetails, o -> o.setSubjectId(null)));
       // 准备参数
       PurchaseDetailsExportReqVO reqVO = new PurchaseDetailsExportReqVO();
       reqVO.setPurchaseId(null);
       reqVO.setPurchaseNumber(null);
       reqVO.setGoodsId(null);
       reqVO.setGoodsName(null);
       reqVO.setPackagingSpecificationId(null);
       reqVO.setPackagingSpecification(null);
       reqVO.setUnit(null);
       reqVO.setPackagingType(null);
       reqVO.setBuyNumber(null);
       reqVO.setFrequency(null);
       reqVO.setPrice(null);
       reqVO.setDiscount(null);
       reqVO.setTotal(null);
       reqVO.setStandardId(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<PurchaseDetailsDO> list = detailsService.getDetailsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDetails, list.get(0));
    }

}
