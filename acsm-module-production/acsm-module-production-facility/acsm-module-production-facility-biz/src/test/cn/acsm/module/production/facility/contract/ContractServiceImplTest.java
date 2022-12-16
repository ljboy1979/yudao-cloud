package cn.acsm.module.production.facility.service.contract;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.facility.controller.admin.contract.vo.*;
import cn.acsm.module.production.facility.dal.dataobject.contract.ContractDO;
import cn.acsm.module.production.facility.dal.mysql.contract.ContractMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.facility.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ContractServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ContractServiceImpl.class)
public class ContractServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ContractServiceImpl contractService;

    @Resource
    private ContractMapper contractMapper;

    @Test
    public void testCreateContract_success() {
        // 准备参数
        ContractCreateReqVO reqVO = randomPojo(ContractCreateReqVO.class);

        // 调用
        Long contractId = contractService.createContract(reqVO);
        // 断言
        assertNotNull(contractId);
        // 校验记录的属性是否正确
        ContractDO contract = contractMapper.selectById(contractId);
        assertPojoEquals(reqVO, contract);
    }

    @Test
    public void testUpdateContract_success() {
        // mock 数据
        ContractDO dbContract = randomPojo(ContractDO.class);
        contractMapper.insert(dbContract);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ContractUpdateReqVO reqVO = randomPojo(ContractUpdateReqVO.class, o -> {
            o.setId(dbContract.getId()); // 设置更新的 ID
        });

        // 调用
        contractService.updateContract(reqVO);
        // 校验是否更新正确
        ContractDO contract = contractMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, contract);
    }

    @Test
    public void testUpdateContract_notExists() {
        // 准备参数
        ContractUpdateReqVO reqVO = randomPojo(ContractUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> contractService.updateContract(reqVO), CONTRACT_NOT_EXISTS);
    }

    @Test
    public void testDeleteContract_success() {
        // mock 数据
        ContractDO dbContract = randomPojo(ContractDO.class);
        contractMapper.insert(dbContract);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbContract.getId();

        // 调用
        contractService.deleteContract(id);
       // 校验数据不存在了
       assertNull(contractMapper.selectById(id));
    }

    @Test
    public void testDeleteContract_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> contractService.deleteContract(id), CONTRACT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetContractPage() {
       // mock 数据
       ContractDO dbContract = randomPojo(ContractDO.class, o -> { // 等会查询到
           o.setInduSubjectId(null);
           o.setContractName(null);
           o.setContractNum(null);
           o.setContractContent(null);
           o.setSignTime(null);
           o.setSignatory(null);
           o.setAmount(null);
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
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       contractMapper.insert(dbContract);
       // 测试 induSubjectId 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setInduSubjectId(null)));
       // 测试 contractName 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setContractName(null)));
       // 测试 contractNum 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setContractNum(null)));
       // 测试 contractContent 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setContractContent(null)));
       // 测试 signTime 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setSignTime(null)));
       // 测试 signatory 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setSignatory(null)));
       // 测试 amount 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setAmount(null)));
       // 测试 remarks 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setSubjectId(null)));
       // 准备参数
       ContractPageReqVO reqVO = new ContractPageReqVO();
       reqVO.setInduSubjectId(null);
       reqVO.setContractName(null);
       reqVO.setContractNum(null);
       reqVO.setContractContent(null);
       reqVO.setSignTime((new LocalDateTime[]{}));
       reqVO.setSignatory(null);
       reqVO.setAmount(null);
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
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<ContractDO> pageResult = contractService.getContractPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbContract, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetContractList() {
       // mock 数据
       ContractDO dbContract = randomPojo(ContractDO.class, o -> { // 等会查询到
           o.setInduSubjectId(null);
           o.setContractName(null);
           o.setContractNum(null);
           o.setContractContent(null);
           o.setSignTime(null);
           o.setSignatory(null);
           o.setAmount(null);
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
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       contractMapper.insert(dbContract);
       // 测试 induSubjectId 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setInduSubjectId(null)));
       // 测试 contractName 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setContractName(null)));
       // 测试 contractNum 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setContractNum(null)));
       // 测试 contractContent 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setContractContent(null)));
       // 测试 signTime 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setSignTime(null)));
       // 测试 signatory 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setSignatory(null)));
       // 测试 amount 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setAmount(null)));
       // 测试 remarks 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setRemarks(null)));
       // 测试 officeCode 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCompanyName(null)));
       // 测试 reviewStatus 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCorpName(null)));
       // 测试 createTime 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       contractMapper.insert(cloneIgnoreId(dbContract, o -> o.setSubjectId(null)));
       // 准备参数
       ContractExportReqVO reqVO = new ContractExportReqVO();
       reqVO.setInduSubjectId(null);
       reqVO.setContractName(null);
       reqVO.setContractNum(null);
       reqVO.setContractContent(null);
       reqVO.setSignTime((new LocalDateTime[]{}));
       reqVO.setSignatory(null);
       reqVO.setAmount(null);
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
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<ContractDO> list = contractService.getContractList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbContract, list.get(0));
    }

}
