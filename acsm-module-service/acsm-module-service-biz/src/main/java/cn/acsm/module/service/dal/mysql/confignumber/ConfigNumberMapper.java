package cn.acsm.module.service.dal.mysql.confignumber;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.confignumber.ConfigNumberDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 当天最新编号 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ConfigNumberMapper extends BaseMapperX<ConfigNumberDO> {

    @Select("<script>"
            + " UPDATE service_config_number set number = #{configNumber.number} "
            + " where  table_name =  #{configNumber.tableName}"
            + "<if test ='configNumber!= null and configNumber.time !=null '> "
            + " and DATE_FORMAT( time,'%Y-%m-%d') = DATE_FORMAT(#{configNumber.time}, '%Y-%m-%d'); "
            + "</if>"
            + "</script>")
    void updateConfigNumber(@Param("configNumber") ConfigNumberDO configNumber);

    @Select("<script>"
            + "select *  from service_config_number where table_name =  #{configNumber.tableName}  "
            + "<if test ='configNumber!= null and configNumber.time !=null '> "
            + " and DATE_FORMAT( time,'%Y-%m-%d') = DATE_FORMAT(#{configNumber.time}, '%Y-%m-%d')  "
            + "</if>"
            +"ORDER BY time DESC "
            +"LIMIT 1 "
            + "</script>")
    ConfigNumberDO getConfigNumber(@Param("configNumber") ConfigNumberDO configNumber);


}
