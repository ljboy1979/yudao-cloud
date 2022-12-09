package cn.acsm.module.resource.service.adoptcontent;

import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentCreateReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentExportReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentPageReqVO;
import cn.acsm.module.resource.controller.admin.adoptcontent.vo.AdoptContentUpdateReqVO;
import cn.acsm.module.resource.dal.mysql.adoptcontent.AdoptContentMapper;
import cn.acsm.module.resource.service.adoptcontent.AdoptContentServiceImpl;
import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


import cn.acsm.module.resource.dal.dataobject.adoptcontent.AdoptContentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.acsm.module.resource.enums.ErrorCodeConstants.ADOPT_CONTENT_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomLongId;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link AdoptContentServiceImpl} 的单元测试类
*
* @author smile
*/
@Import(AdoptContentServiceImpl.class)
public class AdoptContentServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AdoptContentServiceImpl adoptContentService;

    @Resource
    private AdoptContentMapper adoptContentMapper;

    @Test
    public void testCreateAdoptContent_success() {
        // 准备参数
        AdoptContentCreateReqVO reqVO = randomPojo(AdoptContentCreateReqVO.class);

        // 调用
        Long adoptContentId = adoptContentService.createAdoptContent(reqVO);
        // 断言
        assertNotNull(adoptContentId);
        // 校验记录的属性是否正确
        AdoptContentDO adoptContent = adoptContentMapper.selectById(adoptContentId);
        assertPojoEquals(reqVO, adoptContent);
    }

    @Test
    public void testUpdateAdoptContent_success() {
        // mock 数据
        AdoptContentDO dbAdoptContent = randomPojo(AdoptContentDO.class);
        adoptContentMapper.insert(dbAdoptContent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AdoptContentUpdateReqVO reqVO = randomPojo(AdoptContentUpdateReqVO.class, o -> {
            o.setId(dbAdoptContent.getId()); // 设置更新的 ID
        });

        // 调用
        adoptContentService.updateAdoptContent(reqVO);
        // 校验是否更新正确
        AdoptContentDO adoptContent = adoptContentMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, adoptContent);
    }

    @Test
    public void testUpdateAdoptContent_notExists() {
        // 准备参数
        AdoptContentUpdateReqVO reqVO = randomPojo(AdoptContentUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> adoptContentService.updateAdoptContent(reqVO), ADOPT_CONTENT_NOT_EXISTS);
    }

    @Test
    public void testDeleteAdoptContent_success() {
        // mock 数据
        AdoptContentDO dbAdoptContent = randomPojo(AdoptContentDO.class);
        adoptContentMapper.insert(dbAdoptContent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAdoptContent.getId();

        // 调用
        adoptContentService.deleteAdoptContent(id);
       // 校验数据不存在了
       assertNull(adoptContentMapper.selectById(id));
    }

    @Test
    public void testDeleteAdoptContent_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> adoptContentService.deleteAdoptContent(id), ADOPT_CONTENT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptContentPage() {
       // mock 数据
       AdoptContentDO dbAdoptContent = randomPojo(AdoptContentDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setType(null);
           o.setAdoptState(null);
       });
       adoptContentMapper.insert(dbAdoptContent);
       // 测试 name 不匹配
       adoptContentMapper.insert(cloneIgnoreId(dbAdoptContent, o -> o.setName(null)));
       // 测试 type 不匹配
       adoptContentMapper.insert(cloneIgnoreId(dbAdoptContent, o -> o.setType(null)));
       // 测试 adoptState 不匹配
       adoptContentMapper.insert(cloneIgnoreId(dbAdoptContent, o -> o.setAdoptState(null)));
       // 准备参数
       AdoptContentPageReqVO reqVO = new AdoptContentPageReqVO();
       reqVO.setName(null);
       reqVO.setType(null);
       reqVO.setAdoptState(null);

       // 调用
       PageResult<AdoptContentDO> pageResult = adoptContentService.getAdoptContentPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAdoptContent, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAdoptContentList() {
       // mock 数据
       AdoptContentDO dbAdoptContent = randomPojo(AdoptContentDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setType(null);
           o.setAdoptState(null);
       });
       adoptContentMapper.insert(dbAdoptContent);
       // 测试 name 不匹配
       adoptContentMapper.insert(cloneIgnoreId(dbAdoptContent, o -> o.setName(null)));
       // 测试 type 不匹配
       adoptContentMapper.insert(cloneIgnoreId(dbAdoptContent, o -> o.setType(null)));
       // 测试 adoptState 不匹配
       adoptContentMapper.insert(cloneIgnoreId(dbAdoptContent, o -> o.setAdoptState(null)));
       // 准备参数
       AdoptContentExportReqVO reqVO = new AdoptContentExportReqVO();
       reqVO.setName(null);
       reqVO.setType(null);
       reqVO.setAdoptState(null);

       // 调用
       List<AdoptContentDO> list = adoptContentService.getAdoptContentList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAdoptContent, list.get(0));
    }

}
