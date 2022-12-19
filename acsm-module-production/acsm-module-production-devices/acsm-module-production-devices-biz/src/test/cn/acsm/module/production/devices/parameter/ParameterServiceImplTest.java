package cn.acsm.module.production.devices.service.parameter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.parameter.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.parameter.ParameterDO;
import cn.acsm.module.production.devices.dal.mysql.parameter.ParameterMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.devices.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ParameterServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ParameterServiceImpl.class)
public class ParameterServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ParameterServiceImpl parameterService;

    @Resource
    private ParameterMapper parameterMapper;

    @Test
    public void testCreateParameter_success() {
        // 准备参数
        ParameterCreateReqVO reqVO = randomPojo(ParameterCreateReqVO.class);

        // 调用
        Long parameterId = parameterService.createParameter(reqVO);
        // 断言
        assertNotNull(parameterId);
        // 校验记录的属性是否正确
        ParameterDO parameter = parameterMapper.selectById(parameterId);
        assertPojoEquals(reqVO, parameter);
    }

    @Test
    public void testUpdateParameter_success() {
        // mock 数据
        ParameterDO dbParameter = randomPojo(ParameterDO.class);
        parameterMapper.insert(dbParameter);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ParameterUpdateReqVO reqVO = randomPojo(ParameterUpdateReqVO.class, o -> {
            o.setId(dbParameter.getId()); // 设置更新的 ID
        });

        // 调用
        parameterService.updateParameter(reqVO);
        // 校验是否更新正确
        ParameterDO parameter = parameterMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, parameter);
    }

    @Test
    public void testUpdateParameter_notExists() {
        // 准备参数
        ParameterUpdateReqVO reqVO = randomPojo(ParameterUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> parameterService.updateParameter(reqVO), PARAMETER_NOT_EXISTS);
    }

    @Test
    public void testDeleteParameter_success() {
        // mock 数据
        ParameterDO dbParameter = randomPojo(ParameterDO.class);
        parameterMapper.insert(dbParameter);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbParameter.getId();

        // 调用
        parameterService.deleteParameter(id);
       // 校验数据不存在了
       assertNull(parameterMapper.selectById(id));
    }

    @Test
    public void testDeleteParameter_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> parameterService.deleteParameter(id), PARAMETER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetParameterPage() {
       // mock 数据
       ParameterDO dbParameter = randomPojo(ParameterDO.class, o -> { // 等会查询到
           o.setDeviceId(null);
           o.setParamDeviceIp(null);
           o.setParamHttpPort(null);
           o.setParamDevicePort(null);
           o.setParamRtspPort(null);
           o.setParamDeviceUsername(null);
           o.setParamDevicePassword(null);
           o.setParamChanelNum(null);
           o.setKingViewUrl(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
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
       parameterMapper.insert(dbParameter);
       // 测试 deviceId 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setDeviceId(null)));
       // 测试 paramDeviceIp 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamDeviceIp(null)));
       // 测试 paramHttpPort 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamHttpPort(null)));
       // 测试 paramDevicePort 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamDevicePort(null)));
       // 测试 paramRtspPort 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamRtspPort(null)));
       // 测试 paramDeviceUsername 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamDeviceUsername(null)));
       // 测试 paramDevicePassword 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamDevicePassword(null)));
       // 测试 paramChanelNum 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamChanelNum(null)));
       // 测试 kingViewUrl 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setKingViewUrl(null)));
       // 测试 officeCode 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCompanyName(null)));
       // 测试 remarks 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setSubjectId(null)));
       // 准备参数
       ParameterPageReqVO reqVO = new ParameterPageReqVO();
       reqVO.setDeviceId(null);
       reqVO.setParamDeviceIp(null);
       reqVO.setParamHttpPort(null);
       reqVO.setParamDevicePort(null);
       reqVO.setParamRtspPort(null);
       reqVO.setParamDeviceUsername(null);
       reqVO.setParamDevicePassword(null);
       reqVO.setParamChanelNum(null);
       reqVO.setKingViewUrl(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
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
       PageResult<ParameterDO> pageResult = parameterService.getParameterPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbParameter, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetParameterList() {
       // mock 数据
       ParameterDO dbParameter = randomPojo(ParameterDO.class, o -> { // 等会查询到
           o.setDeviceId(null);
           o.setParamDeviceIp(null);
           o.setParamHttpPort(null);
           o.setParamDevicePort(null);
           o.setParamRtspPort(null);
           o.setParamDeviceUsername(null);
           o.setParamDevicePassword(null);
           o.setParamChanelNum(null);
           o.setKingViewUrl(null);
           o.setOfficeCode(null);
           o.setOfficeName(null);
           o.setCompanyCode(null);
           o.setCompanyName(null);
           o.setRemarks(null);
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
       parameterMapper.insert(dbParameter);
       // 测试 deviceId 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setDeviceId(null)));
       // 测试 paramDeviceIp 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamDeviceIp(null)));
       // 测试 paramHttpPort 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamHttpPort(null)));
       // 测试 paramDevicePort 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamDevicePort(null)));
       // 测试 paramRtspPort 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamRtspPort(null)));
       // 测试 paramDeviceUsername 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamDeviceUsername(null)));
       // 测试 paramDevicePassword 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamDevicePassword(null)));
       // 测试 paramChanelNum 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setParamChanelNum(null)));
       // 测试 kingViewUrl 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setKingViewUrl(null)));
       // 测试 officeCode 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCompanyName(null)));
       // 测试 remarks 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       parameterMapper.insert(cloneIgnoreId(dbParameter, o -> o.setSubjectId(null)));
       // 准备参数
       ParameterExportReqVO reqVO = new ParameterExportReqVO();
       reqVO.setDeviceId(null);
       reqVO.setParamDeviceIp(null);
       reqVO.setParamHttpPort(null);
       reqVO.setParamDevicePort(null);
       reqVO.setParamRtspPort(null);
       reqVO.setParamDeviceUsername(null);
       reqVO.setParamDevicePassword(null);
       reqVO.setParamChanelNum(null);
       reqVO.setKingViewUrl(null);
       reqVO.setOfficeCode(null);
       reqVO.setOfficeName(null);
       reqVO.setCompanyCode(null);
       reqVO.setCompanyName(null);
       reqVO.setRemarks(null);
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
       List<ParameterDO> list = parameterService.getParameterList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbParameter, list.get(0));
    }

}
