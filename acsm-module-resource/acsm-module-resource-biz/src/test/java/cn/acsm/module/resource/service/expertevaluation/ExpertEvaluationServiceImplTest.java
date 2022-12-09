package cn.acsm.module.resource.service.expertevaluation;

import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationCreateReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationExportReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationPageReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.expertevaluation.ExpertEvaluationDO;
import cn.acsm.module.resource.dal.mysql.expertevaluation.ExpertEvaluationMapper;
import cn.acsm.module.resource.service.expertevaluation.ExpertEvaluationServiceImpl;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.acsm.module.resource.enums.ErrorCodeConstants.EXPERT_EVALUATION_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link ExpertEvaluationServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(ExpertEvaluationServiceImpl.class)
public class ExpertEvaluationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ExpertEvaluationServiceImpl expertEvaluationService;

    @Resource
    private ExpertEvaluationMapper expertEvaluationMapper;

    @Test
    public void testCreateExpertEvaluation_success() {
        // 准备参数
        ExpertEvaluationCreateReqVO reqVO = randomPojo(ExpertEvaluationCreateReqVO.class);

        // 调用
        Long expertEvaluationId = expertEvaluationService.createExpertEvaluation(reqVO);
        // 断言
        assertNotNull(expertEvaluationId);
        // 校验记录的属性是否正确
        ExpertEvaluationDO expertEvaluation = expertEvaluationMapper.selectById(expertEvaluationId);
        assertPojoEquals(reqVO, expertEvaluation);
    }

    @Test
    public void testUpdateExpertEvaluation_success() {
        // mock 数据
        ExpertEvaluationDO dbExpertEvaluation = randomPojo(ExpertEvaluationDO.class);
        expertEvaluationMapper.insert(dbExpertEvaluation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ExpertEvaluationUpdateReqVO reqVO = randomPojo(ExpertEvaluationUpdateReqVO.class, o -> {
            o.setId(dbExpertEvaluation.getId()); // 设置更新的 ID
        });

        // 调用
        expertEvaluationService.updateExpertEvaluation(reqVO);
        // 校验是否更新正确
        ExpertEvaluationDO expertEvaluation = expertEvaluationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, expertEvaluation);
    }

    @Test
    public void testUpdateExpertEvaluation_notExists() {
        // 准备参数
        ExpertEvaluationUpdateReqVO reqVO = randomPojo(ExpertEvaluationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> expertEvaluationService.updateExpertEvaluation(reqVO), EXPERT_EVALUATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteExpertEvaluation_success() {
        // mock 数据
        ExpertEvaluationDO dbExpertEvaluation = randomPojo(ExpertEvaluationDO.class);
        expertEvaluationMapper.insert(dbExpertEvaluation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbExpertEvaluation.getId();

        // 调用
        expertEvaluationService.deleteExpertEvaluation(id);
       // 校验数据不存在了
       assertNull(expertEvaluationMapper.selectById(id));
    }

    @Test
    public void testDeleteExpertEvaluation_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> expertEvaluationService.deleteExpertEvaluation(id), EXPERT_EVALUATION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetExpertEvaluationPage() {
       // mock 数据
       ExpertEvaluationDO dbExpertEvaluation = randomPojo(ExpertEvaluationDO.class, o -> { // 等会查询到
           o.setEvaluationPerson(null);
           o.setExceptionItem(null);
           o.setEvaluationTime(null);
           o.setEvaluationResult(null);
           o.setAdoptContentId(null);
           o.setBehavior(null);
           o.setCoat(null);
           o.setAppetite(null);
           o.setTeeth(null);
           o.setEyes(null);
           o.setNose(null);
           o.setTrunk(null);
           o.setDefecation(null);
           o.setTemperature(null);
           o.setHeartbeat(null);
           o.setBreathing(null);
           o.setWeight(null);
           o.setBehaviorContent(null);
           o.setCoatContent(null);
           o.setAppetiteContent(null);
           o.setTeethContent(null);
           o.setEyesContent(null);
           o.setNoseContent(null);
           o.setTrunkContent(null);
           o.setDefecationContent(null);
           o.setTemperatureContent(null);
           o.setHeartbeatContent(null);
           o.setBreathingContent(null);
           o.setWeightContent(null);
           o.setType(null);
           o.setMicturition(null);
           o.setMicturitionContent(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       expertEvaluationMapper.insert(dbExpertEvaluation);
       // 测试 evaluationPerson 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEvaluationPerson(null)));
       // 测试 exceptionItem 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setExceptionItem(null)));
       // 测试 evaluationTime 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEvaluationTime(null)));
       // 测试 evaluationResult 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEvaluationResult(null)));
       // 测试 adoptContentId 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setAdoptContentId(null)));
       // 测试 behavior 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setBehavior(null)));
       // 测试 coat 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setCoat(null)));
       // 测试 appetite 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setAppetite(null)));
       // 测试 teeth 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTeeth(null)));
       // 测试 eyes 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEyes(null)));
       // 测试 nose 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setNose(null)));
       // 测试 trunk 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTrunk(null)));
       // 测试 defecation 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setDefecation(null)));
       // 测试 temperature 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTemperature(null)));
       // 测试 heartbeat 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setHeartbeat(null)));
       // 测试 breathing 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setBreathing(null)));
       // 测试 weight 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setWeight(null)));
       // 测试 behaviorContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setBehaviorContent(null)));
       // 测试 coatContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setCoatContent(null)));
       // 测试 appetiteContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setAppetiteContent(null)));
       // 测试 teethContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTeethContent(null)));
       // 测试 eyesContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEyesContent(null)));
       // 测试 noseContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setNoseContent(null)));
       // 测试 trunkContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTrunkContent(null)));
       // 测试 defecationContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setDefecationContent(null)));
       // 测试 temperatureContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTemperatureContent(null)));
       // 测试 heartbeatContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setHeartbeatContent(null)));
       // 测试 breathingContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setBreathingContent(null)));
       // 测试 weightContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setWeightContent(null)));
       // 测试 type 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setType(null)));
       // 测试 micturition 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setMicturition(null)));
       // 测试 micturitionContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setMicturitionContent(null)));
       // 测试 status 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setSubjectId(null)));
       // 准备参数
       ExpertEvaluationPageReqVO reqVO = new ExpertEvaluationPageReqVO();
       reqVO.setEvaluationPerson(null);
       reqVO.setExceptionItem(null);
       reqVO.setEvaluationTime((new Date[]{}));
       reqVO.setEvaluationResult(null);
       reqVO.setAdoptContentId(null);
       reqVO.setBehavior(null);
       reqVO.setCoat(null);
       reqVO.setAppetite(null);
       reqVO.setTeeth(null);
       reqVO.setEyes(null);
       reqVO.setNose(null);
       reqVO.setTrunk(null);
       reqVO.setDefecation(null);
       reqVO.setTemperature(null);
       reqVO.setHeartbeat(null);
       reqVO.setBreathing(null);
       reqVO.setWeight(null);
       reqVO.setBehaviorContent(null);
       reqVO.setCoatContent(null);
       reqVO.setAppetiteContent(null);
       reqVO.setTeethContent(null);
       reqVO.setEyesContent(null);
       reqVO.setNoseContent(null);
       reqVO.setTrunkContent(null);
       reqVO.setDefecationContent(null);
       reqVO.setTemperatureContent(null);
       reqVO.setHeartbeatContent(null);
       reqVO.setBreathingContent(null);
       reqVO.setWeightContent(null);
       reqVO.setType(null);
       reqVO.setMicturition(null);
       reqVO.setMicturitionContent(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<ExpertEvaluationDO> pageResult = expertEvaluationService.getExpertEvaluationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbExpertEvaluation, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetExpertEvaluationList() {
       // mock 数据
       ExpertEvaluationDO dbExpertEvaluation = randomPojo(ExpertEvaluationDO.class, o -> { // 等会查询到
           o.setEvaluationPerson(null);
           o.setExceptionItem(null);
           o.setEvaluationTime(null);
           o.setEvaluationResult(null);
           o.setAdoptContentId(null);
           o.setBehavior(null);
           o.setCoat(null);
           o.setAppetite(null);
           o.setTeeth(null);
           o.setEyes(null);
           o.setNose(null);
           o.setTrunk(null);
           o.setDefecation(null);
           o.setTemperature(null);
           o.setHeartbeat(null);
           o.setBreathing(null);
           o.setWeight(null);
           o.setBehaviorContent(null);
           o.setCoatContent(null);
           o.setAppetiteContent(null);
           o.setTeethContent(null);
           o.setEyesContent(null);
           o.setNoseContent(null);
           o.setTrunkContent(null);
           o.setDefecationContent(null);
           o.setTemperatureContent(null);
           o.setHeartbeatContent(null);
           o.setBreathingContent(null);
           o.setWeightContent(null);
           o.setType(null);
           o.setMicturition(null);
           o.setMicturitionContent(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       expertEvaluationMapper.insert(dbExpertEvaluation);
       // 测试 evaluationPerson 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEvaluationPerson(null)));
       // 测试 exceptionItem 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setExceptionItem(null)));
       // 测试 evaluationTime 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEvaluationTime(null)));
       // 测试 evaluationResult 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEvaluationResult(null)));
       // 测试 adoptContentId 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setAdoptContentId(null)));
       // 测试 behavior 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setBehavior(null)));
       // 测试 coat 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setCoat(null)));
       // 测试 appetite 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setAppetite(null)));
       // 测试 teeth 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTeeth(null)));
       // 测试 eyes 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEyes(null)));
       // 测试 nose 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setNose(null)));
       // 测试 trunk 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTrunk(null)));
       // 测试 defecation 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setDefecation(null)));
       // 测试 temperature 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTemperature(null)));
       // 测试 heartbeat 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setHeartbeat(null)));
       // 测试 breathing 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setBreathing(null)));
       // 测试 weight 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setWeight(null)));
       // 测试 behaviorContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setBehaviorContent(null)));
       // 测试 coatContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setCoatContent(null)));
       // 测试 appetiteContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setAppetiteContent(null)));
       // 测试 teethContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTeethContent(null)));
       // 测试 eyesContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setEyesContent(null)));
       // 测试 noseContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setNoseContent(null)));
       // 测试 trunkContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTrunkContent(null)));
       // 测试 defecationContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setDefecationContent(null)));
       // 测试 temperatureContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setTemperatureContent(null)));
       // 测试 heartbeatContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setHeartbeatContent(null)));
       // 测试 breathingContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setBreathingContent(null)));
       // 测试 weightContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setWeightContent(null)));
       // 测试 type 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setType(null)));
       // 测试 micturition 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setMicturition(null)));
       // 测试 micturitionContent 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setMicturitionContent(null)));
       // 测试 status 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       expertEvaluationMapper.insert(cloneIgnoreId(dbExpertEvaluation, o -> o.setSubjectId(null)));
       // 准备参数
       ExpertEvaluationExportReqVO reqVO = new ExpertEvaluationExportReqVO();
       reqVO.setEvaluationPerson(null);
       reqVO.setExceptionItem(null);
       reqVO.setEvaluationTime((new Date[]{}));
       reqVO.setEvaluationResult(null);
       reqVO.setAdoptContentId(null);
       reqVO.setBehavior(null);
       reqVO.setCoat(null);
       reqVO.setAppetite(null);
       reqVO.setTeeth(null);
       reqVO.setEyes(null);
       reqVO.setNose(null);
       reqVO.setTrunk(null);
       reqVO.setDefecation(null);
       reqVO.setTemperature(null);
       reqVO.setHeartbeat(null);
       reqVO.setBreathing(null);
       reqVO.setWeight(null);
       reqVO.setBehaviorContent(null);
       reqVO.setCoatContent(null);
       reqVO.setAppetiteContent(null);
       reqVO.setTeethContent(null);
       reqVO.setEyesContent(null);
       reqVO.setNoseContent(null);
       reqVO.setTrunkContent(null);
       reqVO.setDefecationContent(null);
       reqVO.setTemperatureContent(null);
       reqVO.setHeartbeatContent(null);
       reqVO.setBreathingContent(null);
       reqVO.setWeightContent(null);
       reqVO.setType(null);
       reqVO.setMicturition(null);
       reqVO.setMicturitionContent(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<ExpertEvaluationDO> list = expertEvaluationService.getExpertEvaluationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbExpertEvaluation, list.get(0));
    }

}
