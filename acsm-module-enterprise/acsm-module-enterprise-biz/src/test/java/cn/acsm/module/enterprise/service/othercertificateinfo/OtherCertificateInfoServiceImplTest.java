package cn.acsm.module.enterprise.service.othercertificateinfo;

import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoCreateReqVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoPageReqVO;
import cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo.OtherCertificateInfoUpdateReqVO;
import cn.acsm.module.enterprise.dal.dataobject.othercertificateinfo.OtherCertificateInfoDO;
import cn.acsm.module.enterprise.dal.mysql.othercertificateinfo.OtherCertificateInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;

import org.springframework.context.annotation.Import;
import java.util.Date;
import java.util.List;

import static cn.acsm.module.enterprise.enums.ErrorCodeConstants.OTHER_CERTIFICATE_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link OtherCertificateInfoServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(OtherCertificateInfoServiceImpl.class)
public class OtherCertificateInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private OtherCertificateInfoServiceImpl otherCertificateInfoService;

    @Resource
    private OtherCertificateInfoMapper otherCertificateInfoMapper;

    @Test
    public void testCreateOtherCertificateInfo_success() {
        // 准备参数
        OtherCertificateInfoCreateReqVO reqVO = randomPojo(OtherCertificateInfoCreateReqVO.class);

        // 调用
        Long otherCertificateInfoId = otherCertificateInfoService.createOtherCertificateInfo(reqVO);
        // 断言
        assertNotNull(otherCertificateInfoId);
        // 校验记录的属性是否正确
        OtherCertificateInfoDO otherCertificateInfo = otherCertificateInfoMapper.selectById(otherCertificateInfoId);
        assertPojoEquals(reqVO, otherCertificateInfo);
    }

    @Test
    public void testUpdateOtherCertificateInfo_success() {
        // mock 数据
        OtherCertificateInfoDO dbOtherCertificateInfo = randomPojo(OtherCertificateInfoDO.class);
        otherCertificateInfoMapper.insert(dbOtherCertificateInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        OtherCertificateInfoUpdateReqVO reqVO = randomPojo(OtherCertificateInfoUpdateReqVO.class, o -> {
            o.setId(dbOtherCertificateInfo.getId()); // 设置更新的 ID
        });

        // 调用
        otherCertificateInfoService.updateOtherCertificateInfo(reqVO);
        // 校验是否更新正确
        OtherCertificateInfoDO otherCertificateInfo = otherCertificateInfoMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, otherCertificateInfo);
    }

    @Test
    public void testUpdateOtherCertificateInfo_notExists() {
        // 准备参数
        OtherCertificateInfoUpdateReqVO reqVO = randomPojo(OtherCertificateInfoUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> otherCertificateInfoService.updateOtherCertificateInfo(reqVO), OTHER_CERTIFICATE_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteOtherCertificateInfo_success() {
        // mock 数据
        OtherCertificateInfoDO dbOtherCertificateInfo = randomPojo(OtherCertificateInfoDO.class);
        otherCertificateInfoMapper.insert(dbOtherCertificateInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbOtherCertificateInfo.getId();

        // 调用
        otherCertificateInfoService.deleteOtherCertificateInfo(id);
        // 校验数据不存在了
        assertNull(otherCertificateInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteOtherCertificateInfo_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> otherCertificateInfoService.deleteOtherCertificateInfo(id), OTHER_CERTIFICATE_INFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOtherCertificateInfoPage() {
        // mock 数据
        OtherCertificateInfoDO dbOtherCertificateInfo = randomPojo(OtherCertificateInfoDO.class, o -> { // 等会查询到
            o.setId(null);
            o.setEnterpriseId(null);
            o.setCertificateType(null);
            o.setCertificateName(null);
            o.setCertificateNo(null);
            o.setCertificateEndTime(null);
            o.setCertificatePhoto(null);
            o.setSource(null);
            o.setSubjectId(null);
            o.setCreateTime(null);
            o.setUpdateTime(null);
        });
        otherCertificateInfoMapper.insert(dbOtherCertificateInfo);
        // 测试 id 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setId(null)));
        // 测试 enterpriseId 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setEnterpriseId(null)));
        // 测试 certificateType 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificateType(null)));
        // 测试 certificateName 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificateName(null)));
        // 测试 certificateNo 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificateNo(null)));
        // 测试 certificateEndTime 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificateEndTime(null)));
        // 测试 certificatePhoto 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificatePhoto(null)));
        // 测试 source 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setSource(null)));
        // 测试 subjectId 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setSubjectId(null)));
        // 测试 createTime 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCreateTime(null)));
        // 测试 updateTime 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setUpdateTime(null)));
        // 准备参数
        OtherCertificateInfoPageReqVO reqVO = new OtherCertificateInfoPageReqVO();
        reqVO.setId(null);
        reqVO.setEnterpriseId(null);
        reqVO.setCertificateType(null);
        reqVO.setCertificateName(null);
        reqVO.setCertificateNo(null);
        reqVO.setCertificateEndTime((new Date[]{}));
        reqVO.setCertificatePhoto(null);
        reqVO.setSource(null);
        reqVO.setSubjectId(null);
        reqVO.setCreateTime((new Date[]{}));
        reqVO.setUpdateTime((new Date[]{}));

        // 调用
        PageResult<OtherCertificateInfoDO> pageResult = otherCertificateInfoService.getOtherCertificateInfoPage(reqVO);
        // 断言
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(dbOtherCertificateInfo, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOtherCertificateInfoList() {
        // mock 数据
        OtherCertificateInfoDO dbOtherCertificateInfo = randomPojo(OtherCertificateInfoDO.class, o -> { // 等会查询到
            o.setId(null);
            o.setEnterpriseId(null);
            o.setCertificateType(null);
            o.setCertificateName(null);
            o.setCertificateNo(null);
            o.setCertificateEndTime(null);
            o.setCertificatePhoto(null);
            o.setSource(null);
            o.setSubjectId(null);
            o.setCreateTime(null);
            o.setUpdateTime(null);
        });
        otherCertificateInfoMapper.insert(dbOtherCertificateInfo);
        // 测试 id 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setId(null)));
        // 测试 enterpriseId 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setEnterpriseId(null)));
        // 测试 certificateType 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificateType(null)));
        // 测试 certificateName 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificateName(null)));
        // 测试 certificateNo 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificateNo(null)));
        // 测试 certificateEndTime 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificateEndTime(null)));
        // 测试 certificatePhoto 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCertificatePhoto(null)));
        // 测试 source 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setSource(null)));
        // 测试 subjectId 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setSubjectId(null)));
        // 测试 createTime 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setCreateTime(null)));
        // 测试 updateTime 不匹配
        otherCertificateInfoMapper.insert(cloneIgnoreId(dbOtherCertificateInfo, o -> o.setUpdateTime(null)));
        // 准备参数
        OtherCertificateInfoExportReqVO reqVO = new OtherCertificateInfoExportReqVO();
        reqVO.setId(null);
        reqVO.setEnterpriseId(null);
        reqVO.setCertificateType(null);
        reqVO.setCertificateName(null);
        reqVO.setCertificateNo(null);
        reqVO.setCertificateEndTime((new Date[]{}));
        reqVO.setCertificatePhoto(null);
        reqVO.setSource(null);
        reqVO.setSubjectId(null);
        reqVO.setCreateTime((new Date[]{}));
        reqVO.setUpdateTime((new Date[]{}));

        // 调用
        List<OtherCertificateInfoDO> list = otherCertificateInfoService.getOtherCertificateInfoList(reqVO);
        // 断言
        assertEquals(1, list.size());
        assertPojoEquals(dbOtherCertificateInfo, list.get(0));
    }

}
