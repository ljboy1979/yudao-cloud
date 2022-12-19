package cn.acsm.module.production.bases.service.partitions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import cn.iocoder.yudao.module.infra.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.production.bases.dal.dataobject.partitions.PartitionsDO;
import cn.acsm.module.production.bases.dal.mysql.partitions.PartitionsMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.module.infra.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link PartitionsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PartitionsServiceImpl.class)
public class PartitionsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PartitionsServiceImpl partitionsService;

    @Resource
    private PartitionsMapper partitionsMapper;

    @Test
    public void testCreatePartitions_success() {
        // 准备参数
        PartitionsCreateReqVO reqVO = randomPojo(PartitionsCreateReqVO.class);

        // 调用
        Long partitionsId = partitionsService.createPartitions(reqVO);
        // 断言
        assertNotNull(partitionsId);
        // 校验记录的属性是否正确
        PartitionsDO partitions = partitionsMapper.selectById(partitionsId);
        assertPojoEquals(reqVO, partitions);
    }

    @Test
    public void testUpdatePartitions_success() {
        // mock 数据
        PartitionsDO dbPartitions = randomPojo(PartitionsDO.class);
        partitionsMapper.insert(dbPartitions);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PartitionsUpdateReqVO reqVO = randomPojo(PartitionsUpdateReqVO.class, o -> {
            o.setId(dbPartitions.getId()); // 设置更新的 ID
        });

        // 调用
        partitionsService.updatePartitions(reqVO);
        // 校验是否更新正确
        PartitionsDO partitions = partitionsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, partitions);
    }

    @Test
    public void testUpdatePartitions_notExists() {
        // 准备参数
        PartitionsUpdateReqVO reqVO = randomPojo(PartitionsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> partitionsService.updatePartitions(reqVO), PARTITIONS_NOT_EXISTS);
    }

    @Test
    public void testDeletePartitions_success() {
        // mock 数据
        PartitionsDO dbPartitions = randomPojo(PartitionsDO.class);
        partitionsMapper.insert(dbPartitions);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbPartitions.getId();

        // 调用
        partitionsService.deletePartitions(id);
       // 校验数据不存在了
       assertNull(partitionsMapper.selectById(id));
    }

    @Test
    public void testDeletePartitions_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> partitionsService.deletePartitions(id), PARTITIONS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPartitionsPage() {
       // mock 数据
       PartitionsDO dbPartitions = randomPojo(PartitionsDO.class, o -> { // 等会查询到
           o.setBaseId(null);
           o.setName(null);
           o.setMuNumber(null);
           o.setViewColor(null);
           o.setBorderColor(null);
           o.setOpacity(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setCoordinateGroup(null);
           o.setBdLatitude(null);
           o.setBdLongitude(null);
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
           o.setSyncStatus(null);
           o.setOldId(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       partitionsMapper.insert(dbPartitions);
       // 测试 baseId 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setBaseId(null)));
       // 测试 name 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setName(null)));
       // 测试 muNumber 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setMuNumber(null)));
       // 测试 viewColor 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setViewColor(null)));
       // 测试 borderColor 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setBorderColor(null)));
       // 测试 opacity 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setOpacity(null)));
       // 测试 longitude 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setLatitude(null)));
       // 测试 coordinateGroup 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCoordinateGroup(null)));
       // 测试 bdLatitude 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setBdLatitude(null)));
       // 测试 bdLongitude 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setBdLongitude(null)));
       // 测试 officeCode 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCompanyName(null)));
       // 测试 remarks 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCorpName(null)));
       // 测试 syncStatus 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setSyncStatus(null)));
       // 测试 oldId 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setOldId(null)));
       // 测试 createTime 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setSubjectId(null)));
       // 准备参数
       PartitionsPageReqVO reqVO = new PartitionsPageReqVO();
       reqVO.setBaseId(null);
       reqVO.setName(null);
       reqVO.setMuNumber(null);
       reqVO.setViewColor(null);
       reqVO.setBorderColor(null);
       reqVO.setOpacity(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setCoordinateGroup(null);
       reqVO.setBdLatitude(null);
       reqVO.setBdLongitude(null);
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
       reqVO.setSyncStatus(null);
       reqVO.setOldId(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       PageResult<PartitionsDO> pageResult = partitionsService.getPartitionsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPartitions, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPartitionsList() {
       // mock 数据
       PartitionsDO dbPartitions = randomPojo(PartitionsDO.class, o -> { // 等会查询到
           o.setBaseId(null);
           o.setName(null);
           o.setMuNumber(null);
           o.setViewColor(null);
           o.setBorderColor(null);
           o.setOpacity(null);
           o.setLongitude(null);
           o.setLatitude(null);
           o.setCoordinateGroup(null);
           o.setBdLatitude(null);
           o.setBdLongitude(null);
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
           o.setSyncStatus(null);
           o.setOldId(null);
           o.setCreateTime(null);
           o.setSource(null);
           o.setSubjectId(null);
       });
       partitionsMapper.insert(dbPartitions);
       // 测试 baseId 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setBaseId(null)));
       // 测试 name 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setName(null)));
       // 测试 muNumber 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setMuNumber(null)));
       // 测试 viewColor 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setViewColor(null)));
       // 测试 borderColor 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setBorderColor(null)));
       // 测试 opacity 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setOpacity(null)));
       // 测试 longitude 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setLongitude(null)));
       // 测试 latitude 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setLatitude(null)));
       // 测试 coordinateGroup 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCoordinateGroup(null)));
       // 测试 bdLatitude 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setBdLatitude(null)));
       // 测试 bdLongitude 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setBdLongitude(null)));
       // 测试 officeCode 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setOfficeCode(null)));
       // 测试 officeName 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setOfficeName(null)));
       // 测试 companyCode 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCompanyCode(null)));
       // 测试 companyName 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCompanyName(null)));
       // 测试 remarks 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setRemarks(null)));
       // 测试 reviewStatus 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setReviewStatus(null)));
       // 测试 reviewer 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setReviewer(null)));
       // 测试 reviewDate 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setReviewDate(null)));
       // 测试 reviewContent 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setReviewContent(null)));
       // 测试 corpCode 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCorpCode(null)));
       // 测试 corpName 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCorpName(null)));
       // 测试 syncStatus 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setSyncStatus(null)));
       // 测试 oldId 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setOldId(null)));
       // 测试 createTime 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setCreateTime(null)));
       // 测试 source 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setSource(null)));
       // 测试 subjectId 不匹配
       partitionsMapper.insert(cloneIgnoreId(dbPartitions, o -> o.setSubjectId(null)));
       // 准备参数
       PartitionsExportReqVO reqVO = new PartitionsExportReqVO();
       reqVO.setBaseId(null);
       reqVO.setName(null);
       reqVO.setMuNumber(null);
       reqVO.setViewColor(null);
       reqVO.setBorderColor(null);
       reqVO.setOpacity(null);
       reqVO.setLongitude(null);
       reqVO.setLatitude(null);
       reqVO.setCoordinateGroup(null);
       reqVO.setBdLatitude(null);
       reqVO.setBdLongitude(null);
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
       reqVO.setSyncStatus(null);
       reqVO.setOldId(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setSource(null);
       reqVO.setSubjectId(null);

       // 调用
       List<PartitionsDO> list = partitionsService.getPartitionsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPartitions, list.get(0));
    }

}
