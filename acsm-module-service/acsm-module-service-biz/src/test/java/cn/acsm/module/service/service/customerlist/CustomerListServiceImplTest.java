package cn.acsm.module.service.service.customerlist;

import cn.acsm.module.service.controller.admin.customerlist.vo.CustomerListCreateReqVO;
import cn.acsm.module.service.controller.admin.customerlist.vo.CustomerListExportReqVO;
import cn.acsm.module.service.controller.admin.customerlist.vo.CustomerListPageReqVO;
import cn.acsm.module.service.controller.admin.customerlist.vo.CustomerListUpdateReqVO;
import cn.acsm.module.service.dal.dataobject.customerlist.CustomerListDO;
import cn.acsm.module.service.dal.mysql.customerlist.CustomerListMapper;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.acsm.module.service.enums.ErrorCodeConstants.CUSTOMER_LIST_NOT_EXISTS;
import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link CustomerListServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(CustomerListServiceImpl.class)
public class CustomerListServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CustomerListServiceImpl customerListService;

    @Resource
    private CustomerListMapper customerListMapper;

    @Test
    public void testCreateCustomerList_success() {
        // 准备参数
        CustomerListCreateReqVO reqVO = randomPojo(CustomerListCreateReqVO.class);

        // 调用
        Long customerListId = customerListService.createCustomerList(reqVO);
        // 断言
        assertNotNull(customerListId);
        // 校验记录的属性是否正确
        CustomerListDO customerList = customerListMapper.selectById(customerListId);
        assertPojoEquals(reqVO, customerList);
    }

    @Test
    public void testUpdateCustomerList_success() {
        // mock 数据
        CustomerListDO dbCustomerList = randomPojo(CustomerListDO.class);
        customerListMapper.insert(dbCustomerList);// @Sql: 先插入出一条存在的数据
        // 准备参数
        CustomerListUpdateReqVO reqVO = randomPojo(CustomerListUpdateReqVO.class, o -> {
            o.setId(dbCustomerList.getId()); // 设置更新的 ID
        });

        // 调用
        customerListService.updateCustomerList(reqVO);
        // 校验是否更新正确
        CustomerListDO customerList = customerListMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, customerList);
    }

    @Test
    public void testUpdateCustomerList_notExists() {
        // 准备参数
        CustomerListUpdateReqVO reqVO = randomPojo(CustomerListUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> customerListService.updateCustomerList(reqVO), CUSTOMER_LIST_NOT_EXISTS);
    }

    @Test
    public void testDeleteCustomerList_success() {
        // mock 数据
        CustomerListDO dbCustomerList = randomPojo(CustomerListDO.class);
        customerListMapper.insert(dbCustomerList);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbCustomerList.getId();

        // 调用
        customerListService.deleteCustomerList(id);
       // 校验数据不存在了
       assertNull(customerListMapper.selectById(id));
    }

    @Test
    public void testDeleteCustomerList_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> customerListService.deleteCustomerList(id), CUSTOMER_LIST_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCustomerListPage() {
       // mock 数据
       CustomerListDO dbCustomerList = randomPojo(CustomerListDO.class, o -> { // 等会查询到
           o.setIdentityCode(null);
           o.setParticipantName(null);
           o.setCellphoneNumber(null);
           o.setIdNumber(null);
           o.setGender(null);
           o.setServiceOrderId(null);
           o.setPayee(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       customerListMapper.insert(dbCustomerList);
       // 测试 identityCode 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setIdentityCode(null)));
       // 测试 participantName 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setParticipantName(null)));
       // 测试 cellphoneNumber 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setCellphoneNumber(null)));
       // 测试 idNumber 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setIdNumber(null)));
       // 测试 gender 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setGender(null)));
       // 测试 serviceOrderId 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setServiceOrderId(null)));
       // 测试 payee 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setPayee(null)));
       // 测试 status 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setSource(null)));
       // 准备参数
       CustomerListPageReqVO reqVO = new CustomerListPageReqVO();
       reqVO.setIdentityCode(null);
       reqVO.setParticipantName(null);
       reqVO.setCellphoneNumber(null);
       reqVO.setIdNumber(null);
       reqVO.setGender(null);
       reqVO.setServiceOrderId(null);
       reqVO.setPayee(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       PageResult<CustomerListDO> pageResult = customerListService.getCustomerListPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbCustomerList, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetCustomerListList() {
       // mock 数据
       CustomerListDO dbCustomerList = randomPojo(CustomerListDO.class, o -> { // 等会查询到
           o.setIdentityCode(null);
           o.setParticipantName(null);
           o.setCellphoneNumber(null);
           o.setIdNumber(null);
           o.setGender(null);
           o.setServiceOrderId(null);
           o.setPayee(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setSource(null);
       });
       customerListMapper.insert(dbCustomerList);
       // 测试 identityCode 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setIdentityCode(null)));
       // 测试 participantName 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setParticipantName(null)));
       // 测试 cellphoneNumber 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setCellphoneNumber(null)));
       // 测试 idNumber 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setIdNumber(null)));
       // 测试 gender 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setGender(null)));
       // 测试 serviceOrderId 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setServiceOrderId(null)));
       // 测试 payee 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setPayee(null)));
       // 测试 status 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       customerListMapper.insert(cloneIgnoreId(dbCustomerList, o -> o.setSource(null)));
       // 准备参数
       CustomerListExportReqVO reqVO = new CustomerListExportReqVO();
       reqVO.setIdentityCode(null);
       reqVO.setParticipantName(null);
       reqVO.setCellphoneNumber(null);
       reqVO.setIdNumber(null);
       reqVO.setGender(null);
       reqVO.setServiceOrderId(null);
       reqVO.setPayee(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new Date[]{}));
       reqVO.setSource(null);

       // 调用
       List<CustomerListDO> list = customerListService.getCustomerListList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbCustomerList, list.get(0));
    }

}
