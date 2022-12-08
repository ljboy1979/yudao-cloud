package cn.acsm.module.transaction.order.dal.mysql.confignumber;

import java.util.*;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.confignumber.ConfigNumberDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表当天最新编号 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ConfigNumberMapper extends BaseMapperX<ConfigNumberDO> {


    ConfigNumberDO getConfigNumber(ConfigNumberDO c);

    void updateConfigNumber(ConfigNumberDO configNumber);
}
