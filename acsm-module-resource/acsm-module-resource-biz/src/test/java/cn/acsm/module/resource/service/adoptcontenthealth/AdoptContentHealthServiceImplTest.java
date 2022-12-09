package cn.acsm.module.resource.service.adoptcontenthealth;

import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo.AdoptContentHealthUpdateReqVO;
import cn.acsm.module.resource.service.adoptcontenthealth.AdoptContentHealthServiceImpl;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


import cn.acsm.module.resource.dal.dataobject.adoptcontenthealth.AdoptContentHealthDO;
import cn.acsm.module.resource.dal.mysql.adoptcontenthealth.AdoptContentHealthMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.acsm.module.resource.enums.ErrorCodeConstants.ADOPT_CONTENT_HEALTH_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link AdoptContentHealthServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(AdoptContentHealthServiceImpl.class)
public class AdoptContentHealthServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AdoptContentHealthServiceImpl adoptContentHealthService;

    @Resource
    private AdoptContentHealthMapper adoptContentHealthMapper;

    @Test
    public void testCreateAdoptContentHealth_success() {
        // 准备参数
        AdoptContentHealthCreateReqVO reqVO = randomPojo(AdoptContentHealthCreateReqVO.class);

        // 调用
        Long adoptContentHealthId = adoptContentHealthService.createAdoptContentHealth(reqVO);
        // 断言
        assertNotNull(adoptContentHealthId);
        // 校验记录的属性是否正确
        AdoptContentHealthDO adoptContentHealth = adoptContentHealthMapper.selectById(adoptContentHealthId);
        assertPojoEquals(reqVO, adoptContentHealth);
    }

    @Test
    public void testUpdateAdoptContentHealth_success() {
        // mock 数据
        AdoptContentHealthDO dbAdoptContentHealth = randomPojo(AdoptContentHealthDO.class);
        adoptContentHealthMapper.insert(dbAdoptContentHealth);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AdoptContentHealthUpdateReqVO reqVO = randomPojo(AdoptContentHealthUpdateReqVO.class, o -> {
            o.setId(dbAdoptContentHealth.getId()); // 设置更新的 ID
        });

        // 调用
        adoptContentHealthService.updateAdoptContentHealth(reqVO);
        // 校验是否更新正确
        AdoptContentHealthDO adoptContentHealth = adoptContentHealthMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, adoptContentHealth);
    }

    @Test
    public void testUpdateAdoptContentHealth_notExists() {
        // 准备参数
        AdoptContentHealthUpdateReqVO reqVO = randomPojo(AdoptContentHealthUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> adoptContentHealthService.updateAdoptContentHealth(reqVO), ADOPT_CONTENT_HEALTH_NOT_EXISTS);
    }

    @Test
    public void testDeleteAdoptContentHealth_success() {
        // mock 数据
        AdoptContentHealthDO dbAdoptContentHealth = randomPojo(AdoptContentHealthDO.class);
        adoptContentHealthMapper.insert(dbAdoptContentHealth);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAdoptContentHealth.getId();

        // 调用
        adoptContentHealthService.deleteAdoptContentHealth(id);
       // 校验数据不存在了
       assertNull(adoptContentHealthMapper.selectById(id));
    }

    @Test
    public void testDeleteAdoptContentHealth_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> adoptContentHealthService.deleteAdoptContentHealth(id), ADOPT_CONTENT_HEALTH_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptContentHealthPage() {
       // mock 数据
       AdoptContentHealthDO dbAdoptContentHealth = randomPojo(AdoptContentHealthDO.class, o -> { // 等会查询到
           o.setAdoptContentId(null);
           o.setType(null);
           o.setAssessment(null);
           o.setAssessmenter(null);
           o.setAssessmentResult(null);
           o.setDescription(null);
           o.setCompanyName(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       adoptContentHealthMapper.insert(dbAdoptContentHealth);
       // 测试 adoptContentId 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setAdoptContentId(null)));
       // 测试 type 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setType(null)));
       // 测试 assessment 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setAssessment(null)));
       // 测试 assessmenter 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setAssessmenter(null)));
       // 测试 assessmentResult 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setAssessmentResult(null)));
       // 测试 description 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setDescription(null)));
       // 测试 companyName 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setCompanyName(null)));
       // 测试 status 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setSubjectId(null)));
       // 准备参数
       AdoptContentHealthPageReqVO reqVO = new AdoptContentHealthPageReqVO();
       reqVO.setAdoptContentId(null);
       reqVO.setType(null);
       reqVO.setAssessment(null);
       reqVO.setAssessmenter(null);
       reqVO.setAssessmentResult(null);
       reqVO.setDescription(null);
       reqVO.setCompanyName(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<AdoptContentHealthDO> pageResult = adoptContentHealthService.getAdoptContentHealthPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAdoptContentHealth, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptContentHealthList() {
       // mock 数据
       AdoptContentHealthDO dbAdoptContentHealth = randomPojo(AdoptContentHealthDO.class, o -> { // 等会查询到
           o.setAdoptContentId(null);
           o.setType(null);
           o.setAssessment(null);
           o.setAssessmenter(null);
           o.setAssessmentResult(null);
           o.setDescription(null);
           o.setCompanyName(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       adoptContentHealthMapper.insert(dbAdoptContentHealth);
       // 测试 adoptContentId 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setAdoptContentId(null)));
       // 测试 type 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setType(null)));
       // 测试 assessment 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setAssessment(null)));
       // 测试 assessmenter 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setAssessmenter(null)));
       // 测试 assessmentResult 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setAssessmentResult(null)));
       // 测试 description 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setDescription(null)));
       // 测试 companyName 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setCompanyName(null)));
       // 测试 status 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       adoptContentHealthMapper.insert(cloneIgnoreId(dbAdoptContentHealth, o -> o.setSubjectId(null)));
       // 准备参数
       AdoptContentHealthExportReqVO reqVO = new AdoptContentHealthExportReqVO();
       reqVO.setAdoptContentId(null);
       reqVO.setType(null);
       reqVO.setAssessment(null);
       reqVO.setAssessmenter(null);
       reqVO.setAssessmentResult(null);
       reqVO.setDescription(null);
       reqVO.setCompanyName(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<AdoptContentHealthDO> list = adoptContentHealthService.getAdoptContentHealthList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAdoptContentHealth, list.get(0));
    }

}
