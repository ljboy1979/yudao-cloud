package cn.acsm.module.transaction.pricetag.dal.mysql.confignumber;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.pricetag.dal.dataobject.confignumber.ConfigNumberDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 价格牌当天最新编号 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ConfigNumberMapper extends BaseMapperX<ConfigNumberDO> {

    ConfigNumberDO getConfigNumber(ConfigNumberDO configNumber);

    void updateConfigNumber(ConfigNumberDO configNumber);

}
