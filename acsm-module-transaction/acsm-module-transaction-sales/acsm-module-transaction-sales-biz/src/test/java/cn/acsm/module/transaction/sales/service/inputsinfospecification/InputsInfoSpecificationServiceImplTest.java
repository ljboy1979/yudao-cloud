package cn.acsm.module.transaction.sales.service.inputsinfospecification;

import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.InputsInfoSpecificationUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;
import cn.acsm.module.transaction.sales.dal.mysql.inputsinfospecification.InputsInfoSpecificationMapper;
import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.acsm.module.transaction.sales.controller.admin.inputsinfospecification.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfospecification.InputsInfoSpecificationDO;
import cn.acsm.module.transaction.sales.dal.mysql.inputsinfospecification.InputsInfoSpecificationMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link InputsInfoSpecificationServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(InputsInfoSpecificationServiceImpl.class)
public class InputsInfoSpecificationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private InputsInfoSpecificationServiceImpl inputsInfoSpecificationService;

    @Resource
    private InputsInfoSpecificationMapper inputsInfoSpecificationMapper;

    @Test
    public void testCreateInputsInfoSpecification_success() {
        // 准备参数
        InputsInfoSpecificationCreateReqVO reqVO = randomPojo(InputsInfoSpecificationCreateReqVO.class);

        // 调用
        CommonResult<String> result = inputsInfoSpecificationService.createInputsInfoSpecification(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        InputsInfoSpecificationDO inputsInfoSpecification = inputsInfoSpecificationMapper.selectById(result.getData());
        assertPojoEquals(reqVO, inputsInfoSpecification);
    }

    @Test
    public void testUpdateInputsInfoSpecification_success() {
        // mock 数据
        InputsInfoSpecificationDO dbInputsInfoSpecification = randomPojo(InputsInfoSpecificationDO.class);
        inputsInfoSpecificationMapper.insert(dbInputsInfoSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        InputsInfoSpecificationUpdateReqVO reqVO = randomPojo(InputsInfoSpecificationUpdateReqVO.class, o -> {
            o.setId(dbInputsInfoSpecification.getId()); // 设置更新的 ID
        });

        // 调用
        inputsInfoSpecificationService.updateInputsInfoSpecification(reqVO);
        // 校验是否更新正确
        InputsInfoSpecificationDO inputsInfoSpecification = inputsInfoSpecificationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, inputsInfoSpecification);
    }

    @Test
    public void testUpdateInputsInfoSpecification_notExists() {
        // 准备参数
        InputsInfoSpecificationUpdateReqVO reqVO = randomPojo(InputsInfoSpecificationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> inputsInfoSpecificationService.updateInputsInfoSpecification(reqVO), ErrorCodeConstants.INPUTS_INFO_SPECIFICATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteInputsInfoSpecification_success() {
        // mock 数据
        InputsInfoSpecificationDO dbInputsInfoSpecification = randomPojo(InputsInfoSpecificationDO.class);
        inputsInfoSpecificationMapper.insert(dbInputsInfoSpecification);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbInputsInfoSpecification.getId();

        // 调用
        inputsInfoSpecificationService.deleteInputsInfoSpecification(id);
       // 校验数据不存在了
       assertNull(inputsInfoSpecificationMapper.selectById(id));
    }

    @Test
    public void testDeleteInputsInfoSpecification_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> inputsInfoSpecificationService.deleteInputsInfoSpecification(id), ErrorCodeConstants.INPUTS_INFO_SPECIFICATION_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInputsInfoSpecificationPage() {
       // mock 数据
       InputsInfoSpecificationDO dbInputsInfoSpecification = randomPojo(InputsInfoSpecificationDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       inputsInfoSpecificationMapper.insert(dbInputsInfoSpecification);
       // 测试 specificationsName 不匹配
       inputsInfoSpecificationMapper.insert(cloneIgnoreId(dbInputsInfoSpecification, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       inputsInfoSpecificationMapper.insert(cloneIgnoreId(dbInputsInfoSpecification, o -> o.setCreateTime(null)));
       // 准备参数
       InputsInfoSpecificationPageReqVO reqVO = new InputsInfoSpecificationPageReqVO();
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<InputsInfoSpecificationDO> pageResult = inputsInfoSpecificationService.getInputsInfoSpecificationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInputsInfoSpecification, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInputsInfoSpecificationList() {
       // mock 数据
       InputsInfoSpecificationDO dbInputsInfoSpecification = randomPojo(InputsInfoSpecificationDO.class, o -> { // 等会查询到
           o.setSpecificationsName(null);
           o.setCreateTime(null);
       });
       inputsInfoSpecificationMapper.insert(dbInputsInfoSpecification);
       // 测试 specificationsName 不匹配
       inputsInfoSpecificationMapper.insert(cloneIgnoreId(dbInputsInfoSpecification, o -> o.setSpecificationsName(null)));
       // 测试 createTime 不匹配
       inputsInfoSpecificationMapper.insert(cloneIgnoreId(dbInputsInfoSpecification, o -> o.setCreateTime(null)));
       // 准备参数
       InputsInfoSpecificationExportReqVO reqVO = new InputsInfoSpecificationExportReqVO();
       reqVO.setSpecificationsName(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<InputsInfoSpecificationDO> list = inputsInfoSpecificationService.getInputsInfoSpecificationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInputsInfoSpecification, list.get(0));
    }

}
