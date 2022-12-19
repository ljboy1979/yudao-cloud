package cn.acsm.module.production.bases.service.consume;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.bases.dal.dataobject.consume.ConsumeDO;
import cn.acsm.module.production.bases.dal.mysql.consume.ConsumeMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ConsumeServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ConsumeServiceImpl.class)
public class ConsumeServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ConsumeServiceImpl consumeService;

    @Resource
    private ConsumeMapper consumeMapper;

    @Test
    public void testCreateConsume_success() {
        // 准备参数
        ConsumeCreateReqVO reqVO = randomPojo(ConsumeCreateReqVO.class);

        // 调用
        Long consumeId = consumeService.createConsume(reqVO);
        // 断言
        assertNotNull(consumeId);
        // 校验记录的属性是否正确
        ConsumeDO consume = consumeMapper.selectById(consumeId);
        assertPojoEquals(reqVO, consume);
    }

    @Test
    public void testUpdateConsume_success() {
        // mock 数据
        ConsumeDO dbConsume = randomPojo(ConsumeDO.class);
        consumeMapper.insert(dbConsume);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ConsumeUpdateReqVO reqVO = randomPojo(ConsumeUpdateReqVO.class, o -> {
            o.setId(dbConsume.getId()); // 设置更新的 ID
        });

        // 调用
        consumeService.updateConsume(reqVO);
        // 校验是否更新正确
        ConsumeDO consume = consumeMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, consume);
    }

    @Test
    public void testUpdateConsume_notExists() {
        // 准备参数
        ConsumeUpdateReqVO reqVO = randomPojo(ConsumeUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> consumeService.updateConsume(reqVO), CONSUME_NOT_EXISTS);
    }

    @Test
    public void testDeleteConsume_success() {
        // mock 数据
        ConsumeDO dbConsume = randomPojo(ConsumeDO.class);
        consumeMapper.insert(dbConsume);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbConsume.getId();

        // 调用
        consumeService.deleteConsume(id);
       // 校验数据不存在了
       assertNull(consumeMapper.selectById(id));
    }

    @Test
    public void testDeleteConsume_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> consumeService.deleteConsume(id), CONSUME_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetConsumePage() {
       // mock 数据
       ConsumeDO dbConsume = randomPojo(ConsumeDO.class, o -> { // 等会查询到
           o.setBasesId(null);
           o.setConsumeNum(null);
           o.setUnit(null);
           o.setInsertTime(null);
           o.setConsumeType(null);
           o.setSource(null);
           o.setStatus(null);
           o.setRemarks(null);
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
           o.setParamName(null);
           o.setParamUnit(null);
           o.setNum(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       consumeMapper.insert(dbConsume);
       // 测试 basesId 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setBasesId(null)));
       // 测试 consumeNum 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setConsumeNum(null)));
       // 测试 unit 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setUnit(null)));
       // 测试 insertTime 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setInsertTime(null)));
       // 测试 consumeType 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setConsumeType(null)));
       // 测试 source 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setSource(null)));
       // 测试 status 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setStatus(null)));
       // 测试 remarks 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCorpName(null)));
       // 测试 paramName 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setParamName(null)));
       // 测试 paramUnit 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setParamUnit(null)));
       // 测试 num 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setNum(null)));
       // 测试 createTime 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setSubjectId(null)));
       // 准备参数
       ConsumePageReqVO reqVO = new ConsumePageReqVO();
       reqVO.setBasesId(null);
       reqVO.setConsumeNum(null);
       reqVO.setUnit(null);
       reqVO.setInsertTime((new LocalDateTime[]{}));
       reqVO.setConsumeType(null);
       reqVO.setSource(null);
       reqVO.setStatus(null);
       reqVO.setRemarks(null);
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
       reqVO.setParamName(null);
       reqVO.setParamUnit(null);
       reqVO.setNum(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSubjectId(null);

       // 调用
       PageResult<ConsumeDO> pageResult = consumeService.getConsumePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbConsume, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetConsumeList() {
       // mock 数据
       ConsumeDO dbConsume = randomPojo(ConsumeDO.class, o -> { // 等会查询到
           o.setBasesId(null);
           o.setConsumeNum(null);
           o.setUnit(null);
           o.setInsertTime(null);
           o.setConsumeType(null);
           o.setSource(null);
           o.setStatus(null);
           o.setRemarks(null);
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
           o.setParamName(null);
           o.setParamUnit(null);
           o.setNum(null);
           o.setCreateTime(null);
           o.setSubjectId(null);
       });
       consumeMapper.insert(dbConsume);
       // 测试 basesId 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setBasesId(null)));
       // 测试 consumeNum 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setConsumeNum(null)));
       // 测试 unit 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setUnit(null)));
       // 测试 insertTime 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setInsertTime(null)));
       // 测试 consumeType 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setConsumeType(null)));
       // 测试 source 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setSource(null)));
       // 测试 status 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setStatus(null)));
       // 测试 remarks 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCorpName(null)));
       // 测试 paramName 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setParamName(null)));
       // 测试 paramUnit 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setParamUnit(null)));
       // 测试 num 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setNum(null)));
       // 测试 createTime 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setCreateTime(null)));
       // 测试 subjectId 不匹配
       consumeMapper.insert(cloneIgnoreId(dbConsume, o -> o.setSubjectId(null)));
       // 准备参数
       ConsumeExportReqVO reqVO = new ConsumeExportReqVO();
       reqVO.setBasesId(null);
       reqVO.setConsumeNum(null);
       reqVO.setUnit(null);
       reqVO.setInsertTime((new LocalDateTime[]{}));
       reqVO.setConsumeType(null);
       reqVO.setSource(null);
       reqVO.setStatus(null);
       reqVO.setRemarks(null);
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
       reqVO.setParamName(null);
       reqVO.setParamUnit(null);
       reqVO.setNum(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSubjectId(null);

       // 调用
       List<ConsumeDO> list = consumeService.getConsumeList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbConsume, list.get(0));
    }

}
