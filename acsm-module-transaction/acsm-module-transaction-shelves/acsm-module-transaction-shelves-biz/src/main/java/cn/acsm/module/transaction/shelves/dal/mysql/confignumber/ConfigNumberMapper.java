package cn.acsm.module.transaction.shelves.dal.mysql.confignumber;

import cn.acsm.module.transaction.shelves.dal.dataobject.confignumber.ConfigNumberDO;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 售品表当天最新编号 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ConfigNumberMapper extends BaseMapperX<ConfigNumberDO> {

    ConfigNumberDO getConfigNumber(ConfigNumberDO configNumber);

    void updateConfigNumber(ConfigNumberDO configNumber);
}
