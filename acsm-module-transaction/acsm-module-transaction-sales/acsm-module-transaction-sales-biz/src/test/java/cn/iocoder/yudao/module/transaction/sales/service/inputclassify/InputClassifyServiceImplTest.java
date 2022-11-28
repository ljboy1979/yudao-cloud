package cn.iocoder.yudao.module.transaction.sales.service.inputclassify;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.transaction.sales.controller.admin.inputclassify.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.inputclassify.InputClassifyDO;
import cn.iocoder.yudao.module.transaction.sales.dal.mysql.inputclassify.InputClassifyMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static cn.iocoder.yudao.module.transaction.sales.enums.ErrorCodeConstants.INPUT_CLASSIFY_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link InputClassifyServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(InputClassifyServiceImpl.class)
public class InputClassifyServiceImplTest extends BaseDbUnitTest {

    @Resource
    private InputClassifyServiceImpl inputClassifyService;

    @Resource
    private InputClassifyMapper inputClassifyMapper;

    @Test
    public void testCreateInputClassify_success() {
        // 准备参数
        InputClassifyCreateReqVO reqVO = randomPojo(InputClassifyCreateReqVO.class);

        // 调用
        String inputClassifyId = inputClassifyService.createInputClassify(reqVO);
        // 断言
        assertNotNull(inputClassifyId);
        // 校验记录的属性是否正确
        InputClassifyDO inputClassify = inputClassifyMapper.selectById(inputClassifyId);
        assertPojoEquals(reqVO, inputClassify);
    }

    @Test
    public void testUpdateInputClassify_success() {
        // mock 数据
        InputClassifyDO dbInputClassify = randomPojo(InputClassifyDO.class);
        inputClassifyMapper.insert(dbInputClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        InputClassifyUpdateReqVO reqVO = randomPojo(InputClassifyUpdateReqVO.class, o -> {
            o.setId(dbInputClassify.getId()); // 设置更新的 ID
        });

        // 调用
        inputClassifyService.updateInputClassify(reqVO);
        // 校验是否更新正确
        InputClassifyDO inputClassify = inputClassifyMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, inputClassify);
    }

    @Test
    public void testUpdateInputClassify_notExists() {
        // 准备参数
        InputClassifyUpdateReqVO reqVO = randomPojo(InputClassifyUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> inputClassifyService.updateInputClassify(reqVO), INPUT_CLASSIFY_NOT_EXISTS);
    }

    @Test
    public void testDeleteInputClassify_success() {
        // mock 数据
        InputClassifyDO dbInputClassify = randomPojo(InputClassifyDO.class);
        inputClassifyMapper.insert(dbInputClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbInputClassify.getId();

        // 调用
        inputClassifyService.deleteInputClassify(id);
       // 校验数据不存在了
       assertNull(inputClassifyMapper.selectById(id));
    }

    @Test
    public void testDeleteInputClassify_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> inputClassifyService.deleteInputClassify(id), INPUT_CLASSIFY_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInputClassifyPage() {
       // mock 数据
       InputClassifyDO dbInputClassify = randomPojo(InputClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setSubjectId(null);
           o.setSource(null);
       });
       inputClassifyMapper.insert(dbInputClassify);
       // 测试 categoryName 不匹配
       inputClassifyMapper.insert(cloneIgnoreId(dbInputClassify, o -> o.setCategoryName(null)));
       // 测试 subjectId 不匹配
       inputClassifyMapper.insert(cloneIgnoreId(dbInputClassify, o -> o.setSubjectId(null)));
       // 测试 source 不匹配
       inputClassifyMapper.insert(cloneIgnoreId(dbInputClassify, o -> o.setSource(null)));
       // 准备参数
       InputClassifyPageReqVO reqVO = new InputClassifyPageReqVO();
       reqVO.setCategoryName(null);
       reqVO.setSubjectId(null);
       reqVO.setSource(null);

       // 调用
       PageResult<InputClassifyDO> pageResult = inputClassifyService.getInputClassifyPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInputClassify, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInputClassifyList() {
       // mock 数据
       InputClassifyDO dbInputClassify = randomPojo(InputClassifyDO.class, o -> { // 等会查询到
           o.setCategoryName(null);
           o.setSubjectId(null);
           o.setSource(null);
       });
       inputClassifyMapper.insert(dbInputClassify);
       // 测试 categoryName 不匹配
       inputClassifyMapper.insert(cloneIgnoreId(dbInputClassify, o -> o.setCategoryName(null)));
       // 测试 subjectId 不匹配
       inputClassifyMapper.insert(cloneIgnoreId(dbInputClassify, o -> o.setSubjectId(null)));
       // 测试 source 不匹配
       inputClassifyMapper.insert(cloneIgnoreId(dbInputClassify, o -> o.setSource(null)));
       // 准备参数
       InputClassifyExportReqVO reqVO = new InputClassifyExportReqVO();
       reqVO.setCategoryName(null);
       reqVO.setSubjectId(null);
       reqVO.setSource(null);

       // 调用
       List<InputClassifyDO> list = inputClassifyService.getInputClassifyList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInputClassify, list.get(0));
    }

}
