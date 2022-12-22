package cn.acsm.module.purchase.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 对象功能: SnowFlakeUtil.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/19
 * 功能：生成询价单编号
 * <pre>
 */
@Component
public class SnowFlakeUtil {

    private long machineId ;
    private long dataCenterId ;


    public SnowFlakeUtil(long machineId, long dataCenterId) {
        this.machineId = machineId;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 成员类，SnowFlakeUtil的实例对象的保存域
     */
    private static class IdGenHolder {
        private static final SnowFlakeUtil instance = new SnowFlakeUtil();
    }

    /**
     * 外部调用获取SnowFlakeUtil的实例对象，确保不可变
     */
    public static SnowFlakeUtil get() {
        return IdGenHolder.instance;
    }

    /**
     * 初始化构造，无参构造有参函数，默认节点都是0
     */
    public SnowFlakeUtil() {
        this(0L, 0L);
    }

    private Snowflake snowflake = IdUtil.createSnowflake(machineId,dataCenterId);

    public synchronized long id(){
        return snowflake.nextId();
    }

    public static Long getId() {
        return SnowFlakeUtil.get().id();
    }

}
