package cn.acsm.module.transaction.sales.service.inputsinfo;

import cn.acsm.module.transaction.sales.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;


import cn.acsm.module.transaction.sales.controller.admin.inputsinfo.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.inputsinfo.InputsInfoDO;
import cn.acsm.module.transaction.sales.dal.mysql.inputsinfo.InputsInfoMapper;
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
import static cn.acsm.module.transaction.sales.enums.ErrorCodeConstants.INPUTS_INFO_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link InputsInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(InputsInfoServiceImpl.class)
public class InputsInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private InputsInfoServiceImpl inputsInfoService;

    @Resource
    private InputsInfoMapper inputsInfoMapper;

    @Test
    public void testCreateInputsInfo_success() {
        // 准备参数
        InputsInfoCreateReqVO reqVO = randomPojo(InputsInfoCreateReqVO.class);

        // 调用
        CommonResult<String> result = inputsInfoService.createInputsInfo(reqVO);
        // 断言
        assertNotNull(result.getData());
        // 校验记录的属性是否正确
        InputsInfoDO inputsInfo = inputsInfoMapper.selectById(result.getData());
        assertPojoEquals(reqVO, inputsInfo);
    }

    @Test
    public void testUpdateInputsInfo_success() {
        // mock 数据
        InputsInfoDO dbInputsInfo = randomPojo(InputsInfoDO.class);
        inputsInfoMapper.insert(dbInputsInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        InputsInfoUpdateReqVO reqVO = randomPojo(InputsInfoUpdateReqVO.class, o -> {
            o.setId(dbInputsInfo.getId()); // 设置更新的 ID
        });

        // 调用
        inputsInfoService.updateInputsInfo(reqVO);
        // 校验是否更新正确
        InputsInfoDO inputsInfo = inputsInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, inputsInfo);
    }

    @Test
    public void testUpdateInputsInfo_notExists() {
        // 准备参数
        InputsInfoUpdateReqVO reqVO = randomPojo(InputsInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> inputsInfoService.updateInputsInfo(reqVO), ErrorCodeConstants.INPUTS_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteInputsInfo_success() {
        // mock 数据
        InputsInfoDO dbInputsInfo = randomPojo(InputsInfoDO.class);
        inputsInfoMapper.insert(dbInputsInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbInputsInfo.getId();

        // 调用
        inputsInfoService.deleteInputsInfo(id);
       // 校验数据不存在了
       assertNull(inputsInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteInputsInfo_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> inputsInfoService.deleteInputsInfo(id), ErrorCodeConstants.INPUTS_INFO_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInputsInfoPage() {
       // mock 数据
       InputsInfoDO dbInputsInfo = randomPojo(InputsInfoDO.class, o -> { // 等会查询到
           o.setInputsName(null);
           o.setInputsKind(null);
           o.setCreateTime(null);
       });
       inputsInfoMapper.insert(dbInputsInfo);
       // 测试 inputsName 不匹配
       inputsInfoMapper.insert(cloneIgnoreId(dbInputsInfo, o -> o.setInputsName(null)));
       // 测试 inputsKind 不匹配
       inputsInfoMapper.insert(cloneIgnoreId(dbInputsInfo, o -> o.setInputsKind(null)));
       // 测试 createTime 不匹配
       inputsInfoMapper.insert(cloneIgnoreId(dbInputsInfo, o -> o.setCreateTime(null)));
       // 准备参数
       InputsInfoPageReqVO reqVO = new InputsInfoPageReqVO();
       reqVO.setInputsName(null);
       reqVO.setInputsKind(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<InputsInfoDO> pageResult = inputsInfoService.getInputsInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInputsInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInputsInfoList() {
       // mock 数据
       InputsInfoDO dbInputsInfo = randomPojo(InputsInfoDO.class, o -> { // 等会查询到
           o.setInputsName(null);
           o.setInputsKind(null);
           o.setCreateTime(null);
       });
       inputsInfoMapper.insert(dbInputsInfo);
       // 测试 inputsName 不匹配
       inputsInfoMapper.insert(cloneIgnoreId(dbInputsInfo, o -> o.setInputsName(null)));
       // 测试 inputsKind 不匹配
       inputsInfoMapper.insert(cloneIgnoreId(dbInputsInfo, o -> o.setInputsKind(null)));
       // 测试 createTime 不匹配
       inputsInfoMapper.insert(cloneIgnoreId(dbInputsInfo, o -> o.setCreateTime(null)));
       // 准备参数
       InputsInfoExportReqVO reqVO = new InputsInfoExportReqVO();
       reqVO.setInputsName(null);
       reqVO.setInputsKind(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<InputsInfoDO> list = inputsInfoService.getInputsInfoList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInputsInfo, list.get(0));
    }

}
