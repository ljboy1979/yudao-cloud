package cn.acsm.module.transaction.shelves.shelves;

import cn.acsm.module.transaction.shelves.service.shelves.ShelvesServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.acsm.module.transaction.shelves.controller.admin.shelves.vo.*;
import cn.acsm.module.transaction.shelves.dal.dataobject.shelves.ShelvesDO;
import cn.acsm.module.transaction.shelves.dal.mysql.shelves.ShelvesMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.acsm.module.transaction.shelves.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link ShelvesServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ShelvesServiceImpl.class)
public class shelvesServerApplicationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ShelvesServiceImpl shelvesService;

    @Resource
    private ShelvesMapper ShelvesMapper;

    @Test
    public void testCreateshelves_success() {
        // 准备参数
        ShelvesCreateReqVO reqVO = randomPojo(ShelvesCreateReqVO.class);

        // 调用
        String shelvesId = shelvesService.createShelves(reqVO);
        // 断言
        assertNotNull(shelvesId);
        // 校验记录的属性是否正确
        ShelvesDO shelves = ShelvesMapper.selectById(shelvesId);
        assertPojoEquals(reqVO, shelves);
    }

    @Test
    public void testUpdateshelves_success() {
        // mock 数据
        ShelvesDO dbshelves = randomPojo(ShelvesDO.class);
        ShelvesMapper.insert(dbshelves);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ShelvesUpdateReqVO reqVO = randomPojo(ShelvesUpdateReqVO.class, o -> {
            o.setId(dbshelves.getId()); // 设置更新的 ID
        });

        // 调用
        shelvesService.updateshelves(reqVO);
        // 校验是否更新正确
        ShelvesDO shelves = ShelvesMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, shelves);
    }

    @Test
    public void testUpdateshelves_notExists() {
        // 准备参数
        ShelvesUpdateReqVO reqVO = randomPojo(ShelvesUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> shelvesService.updateshelves(reqVO), SHELVES_NOT_EXISTS);
    }

    @Test
    public void testDeleteshelves_success() {
        // mock 数据
        ShelvesDO dbshelves = randomPojo(ShelvesDO.class);
        ShelvesMapper.insert(dbshelves);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbshelves.getId();

        // 调用
        shelvesService.deleteshelves(id);
       // 校验数据不存在了
       assertNull(ShelvesMapper.selectById(id));
    }

    @Test
    public void testDeleteshelves_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> shelvesService.deleteshelves(id), SHELVES_NOT_EXISTS);
    }

    private String randomStringId() {
        return null;
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetshelvesPage() {
       // mock 数据
       ShelvesDO dbshelves = randomPojo(ShelvesDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setClassifyId(null);
           o.setCreateTime(null);
       });
       ShelvesMapper.insert(dbshelves);
       // 测试 name 不匹配
       ShelvesMapper.insert(cloneIgnoreId(dbshelves, o -> o.setName(null)));
       // 测试 classifyId 不匹配
       ShelvesMapper.insert(cloneIgnoreId(dbshelves, o -> o.setClassifyId(null)));
       // 测试 createTime 不匹配
       ShelvesMapper.insert(cloneIgnoreId(dbshelves, o -> o.setCreateTime(null)));
       // 准备参数
       shelvesPageReqVO reqVO = new shelvesPageReqVO();
       reqVO.setName(null);
       reqVO.setClassifyId(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       PageResult<ShelvesDO> pageResult = shelvesService.getshelvesPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbshelves, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetshelvesList() {
       // mock 数据
       ShelvesDO dbshelves = randomPojo(ShelvesDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setClassifyId(null);
           o.setCreateTime(null);
       });
       ShelvesMapper.insert(dbshelves);
       // 测试 name 不匹配
       ShelvesMapper.insert(cloneIgnoreId(dbshelves, o -> o.setName(null)));
       // 测试 classifyId 不匹配
       ShelvesMapper.insert(cloneIgnoreId(dbshelves, o -> o.setClassifyId(null)));
       // 测试 createTime 不匹配
       ShelvesMapper.insert(cloneIgnoreId(dbshelves, o -> o.setCreateTime(null)));
       // 准备参数
       ShelvesExportReqVO reqVO = new ShelvesExportReqVO();
       reqVO.setName(null);
       reqVO.setClassifyId(null);
       reqVO.setCreateTime((new Date[]{}));

       // 调用
       List<ShelvesDO> list = shelvesService.getshelvesList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbshelves, list.get(0));
    }

}
