package cn.acsm.module.production.tunnel.service.costbook;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.costbook.CostBookDO;
import cn.acsm.module.production.tunnel.dal.mysql.costbook.CostBookMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.tunnel.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link CostBookServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(CostBookServiceImpl.class)
public class CostBookServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CostBookServiceImpl costBookService;

    @Resource
    private CostBookMapper costBookMapper;

    @Test
    public void testCreateCostBook_success() {
        // 准备参数
        CostBookCreateReqVO reqVO = randomPojo(CostBookCreateReqVO.class);

        // 调用
        Long costBookId = costBookService.createCostBook(reqVO);
        // 断言
        assertNotNull(costBookId);
        // 校验记录的属性是否正确
        CostBookDO costBook = costBookMapper.selectById(costBookId);
        assertPojoEquals(reqVO, costBook);
    }

    @Test
    public void testUpdateCostBook_success() {
        // mock 数据
        CostBookDO dbCostBook = randomPojo(CostBookDO.class);
        costBookMapper.insert(dbCostBook);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CostBookUpdateReqVO reqVO = randomPojo(CostBookUpdateReqVO.class, o -> {
            o.setId(dbCostBook.getId()); // 设置更新的 ID
        });

        // 调用
        costBookService.updateCostBook(reqVO);
        // 校验是否更新正确
        CostBookDO costBook = costBookMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, costBook);
    }

    @Test
    public void testUpdateCostBook_notExists() {
        // 准备参数
        CostBookUpdateReqVO reqVO = randomPojo(CostBookUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> costBookService.updateCostBook(reqVO), COST_BOOK_NOT_EXISTS);
    }

    @Test
    public void testDeleteCostBook_success() {
        // mock 数据
        CostBookDO dbCostBook = randomPojo(CostBookDO.class);
        costBookMapper.insert(dbCostBook);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbCostBook.getId();

        // 调用
        costBookService.deleteCostBook(id);
       // 校验数据不存在了
       assertNull(costBookMapper.selectById(id));
    }

    @Test
    public void testDeleteCostBook_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> costBookService.deleteCostBook(id), COST_BOOK_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCostBookPage() {
       // mock 数据
       CostBookDO dbCostBook = randomPojo(CostBookDO.class, o -> { // 等会查询到
           o.setCostCode(null);
           o.setCostSource(null);
           o.setEntityId(null);
           o.setCostType(null);
           o.setAccountName(null);
           o.setAccountInfo(null);
           o.setAccountAmount(null);
           o.setAccountTime(null);
           o.setAccountLocation(null);
           o.setAccountingTime(null);
           o.setRemarks(null);
           o.setCounter(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       costBookMapper.insert(dbCostBook);
       // 测试 costCode 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCostCode(null)));
       // 测试 costSource 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCostSource(null)));
       // 测试 entityId 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setEntityId(null)));
       // 测试 costType 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCostType(null)));
       // 测试 accountName 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountName(null)));
       // 测试 accountInfo 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountInfo(null)));
       // 测试 accountAmount 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountAmount(null)));
       // 测试 accountTime 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountTime(null)));
       // 测试 accountLocation 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountLocation(null)));
       // 测试 accountingTime 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountingTime(null)));
       // 测试 remarks 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setRemarks(null)));
       // 测试 counter 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCounter(null)));
       // 测试 officeCode 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setSubjectId(null)));
       // 准备参数
       CostBookPageReqVO reqVO = new CostBookPageReqVO();
       reqVO.setCostCode(null);
       reqVO.setCostSource(null);
       reqVO.setEntityId(null);
       reqVO.setCostType(null);
       reqVO.setAccountName(null);
       reqVO.setAccountInfo(null);
       reqVO.setAccountAmount(null);
       reqVO.setAccountTime((new LocalDateTime[]{}));
       reqVO.setAccountLocation(null);
       reqVO.setAccountingTime((new LocalDateTime[]{}));
       reqVO.setRemarks(null);
       reqVO.setCounter(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<CostBookDO> pageResult = costBookService.getCostBookPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCostBook, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCostBookList() {
       // mock 数据
       CostBookDO dbCostBook = randomPojo(CostBookDO.class, o -> { // 等会查询到
           o.setCostCode(null);
           o.setCostSource(null);
           o.setEntityId(null);
           o.setCostType(null);
           o.setAccountName(null);
           o.setAccountInfo(null);
           o.setAccountAmount(null);
           o.setAccountTime(null);
           o.setAccountLocation(null);
           o.setAccountingTime(null);
           o.setRemarks(null);
           o.setCounter(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setReviewStatus(null);
           o.setReviewer(null);
           o.setReviewDate(null);
           o.setReviewContent(null);
           o.setCorpCode(null);
           o.setCorpName(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       costBookMapper.insert(dbCostBook);
       // 测试 costCode 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCostCode(null)));
       // 测试 costSource 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCostSource(null)));
       // 测试 entityId 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setEntityId(null)));
       // 测试 costType 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCostType(null)));
       // 测试 accountName 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountName(null)));
       // 测试 accountInfo 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountInfo(null)));
       // 测试 accountAmount 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountAmount(null)));
       // 测试 accountTime 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountTime(null)));
       // 测试 accountLocation 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountLocation(null)));
       // 测试 accountingTime 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setAccountingTime(null)));
       // 测试 remarks 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setRemarks(null)));
       // 测试 counter 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCounter(null)));
       // 测试 officeCode 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       costBookMapper.insert(cloneIgnoreId(dbCostBook, o -> o.setSubjectId(null)));
       // 准备参数
       CostBookExportReqVO reqVO = new CostBookExportReqVO();
       reqVO.setCostCode(null);
       reqVO.setCostSource(null);
       reqVO.setEntityId(null);
       reqVO.setCostType(null);
       reqVO.setAccountName(null);
       reqVO.setAccountInfo(null);
       reqVO.setAccountAmount(null);
       reqVO.setAccountTime((new LocalDateTime[]{}));
       reqVO.setAccountLocation(null);
       reqVO.setAccountingTime((new LocalDateTime[]{}));
       reqVO.setRemarks(null);
       reqVO.setCounter(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setReviewStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewDate((new LocalDateTime[]{}));
       reqVO.setReviewContent(null);
       reqVO.setCorpCode(null);
       reqVO.setCorpName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<CostBookDO> list = costBookService.getCostBookList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCostBook, list.get(0));
    }

}
