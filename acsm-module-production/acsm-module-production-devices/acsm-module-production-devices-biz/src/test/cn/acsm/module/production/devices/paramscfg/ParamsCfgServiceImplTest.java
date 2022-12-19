package cn.acsm.module.production.devices.service.paramscfg;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.devices.controller.admin.paramscfg.vo.*;
import cn.acsm.module.production.devices.dal.dataobject.paramscfg.ParamsCfgDO;
import cn.acsm.module.production.devices.dal.mysql.paramscfg.ParamsCfgMapper;
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
* {@link ParamsCfgServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ParamsCfgServiceImpl.class)
public class ParamsCfgServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ParamsCfgServiceImpl paramsCfgService;

    @Resource
    private ParamsCfgMapper paramsCfgMapper;

    @Test
    public void testCreateParamsCfg_success() {
        // 准备参数
        ParamsCfgCreateReqVO reqVO = randomPojo(ParamsCfgCreateReqVO.class);

        // 调用
        Long paramsCfgId = paramsCfgService.createParamsCfg(reqVO);
        // 断言
        assertNotNull(paramsCfgId);
        // 校验记录的属性是否正确
        ParamsCfgDO paramsCfg = paramsCfgMapper.selectById(paramsCfgId);
        assertPojoEquals(reqVO, paramsCfg);
    }

    @Test
    public void testUpdateParamsCfg_success() {
        // mock 数据
        ParamsCfgDO dbParamsCfg = randomPojo(ParamsCfgDO.class);
        paramsCfgMapper.insert(dbParamsCfg);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ParamsCfgUpdateReqVO reqVO = randomPojo(ParamsCfgUpdateReqVO.class, o -> {
            o.setId(dbParamsCfg.getId()); // 设置更新的 ID
        });

        // 调用
        paramsCfgService.updateParamsCfg(reqVO);
        // 校验是否更新正确
        ParamsCfgDO paramsCfg = paramsCfgMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, paramsCfg);
    }

    @Test
    public void testUpdateParamsCfg_notExists() {
        // 准备参数
        ParamsCfgUpdateReqVO reqVO = randomPojo(ParamsCfgUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> paramsCfgService.updateParamsCfg(reqVO), PARAMS_CFG_NOT_EXISTS);
    }

    @Test
    public void testDeleteParamsCfg_success() {
        // mock 数据
        ParamsCfgDO dbParamsCfg = randomPojo(ParamsCfgDO.class);
        paramsCfgMapper.insert(dbParamsCfg);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbParamsCfg.getId();

        // 调用
        paramsCfgService.deleteParamsCfg(id);
       // 校验数据不存在了
       assertNull(paramsCfgMapper.selectById(id));
    }

    @Test
    public void testDeleteParamsCfg_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> paramsCfgService.deleteParamsCfg(id), PARAMS_CFG_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetParamsCfgPage() {
       // mock 数据
       ParamsCfgDO dbParamsCfg = randomPojo(ParamsCfgDO.class, o -> { // 等会查询到
           o.setParamColumn(null);
           o.setParamName(null);
           o.setParamUnit(null);
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
           o.setRemarks(null);
           o.setCfgId(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       paramsCfgMapper.insert(dbParamsCfg);
       // 测试 paramColumn 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setParamColumn(null)));
       // 测试 paramName 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setParamName(null)));
       // 测试 paramUnit 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setParamUnit(null)));
       // 测试 officeCode 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCorpName(null)));
       // 测试 remarks 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setRemarks(null)));
       // 测试 cfgId 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCfgId(null)));
       // 测试 createTime 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setSubjectId(null)));
       // 准备参数
       ParamsCfgPageReqVO reqVO = new ParamsCfgPageReqVO();
       reqVO.setParamColumn(null);
       reqVO.setParamName(null);
       reqVO.setParamUnit(null);
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
       reqVO.setRemarks(null);
       reqVO.setCfgId(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<ParamsCfgDO> pageResult = paramsCfgService.getParamsCfgPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbParamsCfg, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetParamsCfgList() {
       // mock 数据
       ParamsCfgDO dbParamsCfg = randomPojo(ParamsCfgDO.class, o -> { // 等会查询到
           o.setParamColumn(null);
           o.setParamName(null);
           o.setParamUnit(null);
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
           o.setRemarks(null);
           o.setCfgId(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       paramsCfgMapper.insert(dbParamsCfg);
       // 测试 paramColumn 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setParamColumn(null)));
       // 测试 paramName 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setParamName(null)));
       // 测试 paramUnit 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setParamUnit(null)));
       // 测试 officeCode 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCorpName(null)));
       // 测试 remarks 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setRemarks(null)));
       // 测试 cfgId 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCfgId(null)));
       // 测试 createTime 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       paramsCfgMapper.insert(cloneIgnoreId(dbParamsCfg, o -> o.setSubjectId(null)));
       // 准备参数
       ParamsCfgExportReqVO reqVO = new ParamsCfgExportReqVO();
       reqVO.setParamColumn(null);
       reqVO.setParamName(null);
       reqVO.setParamUnit(null);
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
       reqVO.setRemarks(null);
       reqVO.setCfgId(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<ParamsCfgDO> list = paramsCfgService.getParamsCfgList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbParamsCfg, list.get(0));
    }

}
