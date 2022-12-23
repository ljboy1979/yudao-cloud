package cn.acsm.module.transaction.pricetag.util;

import cn.acsm.module.transaction.pricetag.dal.mysql.confignumber.ConfigNumberMapper;
import cn.acsm.module.transaction.pricetag.dal.dataobject.confignumber.ConfigNumberDO;
import cn.acsm.module.transaction.pricetag.enums.ErrorCodeConstants;
import cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class ConfigNumberUtil {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private ConfigNumberMapper configNumberMapper;


/*
    public String getNumber(String tableName) {
        CompletableFuture<String> number = CompletableFuture.supplyAsync(() -> this.getNumberAsynchronous(tableName));
        String code = "";
        try {
            code = number.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return code;
    }*/

    public String getNumber(String tableName){
        String code = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        ConfigNumberDO c = new ConfigNumberDO();
        Date now = new Date();
        c.setTableName(tableName);
        c.setTime(now);
        ConfigNumberDO configNumber = configNumberMapper.getConfigNumber(c);
        if (configNumber != null && !configNumber.equals("")) {
            String format = sdf.format(configNumber.getTime());
            Integer number = configNumber.getNumber();
            number = number + 1;
            String s = number.toString();
            if (s.length() == 1) {
                s = "0000" + s;
            } else if (s.length() == 2) {
                s = "000" + s;
            } else if (s.length() == 3) {
                s = "00" + s;
            } else if (s.length() == 4) {
                s = "0" + s;
            }
            code = format + s;
            configNumber.setNumber(Integer.valueOf(s));
            System.out.println(configNumber.getNumber());
            configNumberMapper.updateConfigNumber(configNumber);
        } else {
            ConfigNumberDO cc = new ConfigNumberDO();
            cc.setTableName(tableName);
            Date parse = null;
            try {
                parse = sdf.parse(sdf.format(new Date()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cc.setTime(parse);
            c.setNumber(1);
            String format = sdf.format(now);
            configNumberMapper.insert(c);
            code = format + "00001";
        }

        return code;
    }


    public String getNumberAsynchronous(String tableName){
        String code = "";
        RedisDistributedLockUtil redisDistributedLock = new RedisDistributedLockUtil();
        redisDistributedLock.setRedisTemplate(redisTemplate);
        while(true){
            Boolean flag=redisDistributedLock.getLock(tableName);
            if(flag){
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    ConfigNumberDO c = new ConfigNumberDO();
                    Date now = new Date();
                    c.setTableName(tableName);
                    c.setTime(now);
                    ConfigNumberDO configNumber = configNumberMapper.getConfigNumber(c);
                    if (configNumber != null && !configNumber.equals("")) {
                        String format = sdf.format(configNumber.getTime());
                        Integer number = configNumber.getNumber();
                        number = number + 1;
                        String s = number.toString();
                        if (s.length() == 1) {
                            s = "0000" + s;
                        } else if (s.length() == 2) {
                            s = "000" + s;
                        } else if (s.length() == 3) {
                            s = "00" + s;
                        } else if (s.length() == 4) {
                            s = "0" + s;
                        }
                        code = format + s;
                        configNumber.setNumber(Integer.valueOf(s));
                        System.out.println(configNumber.getNumber());
                        configNumberMapper.updateConfigNumber(configNumber);
                    } else {
                        ConfigNumberDO cc = new ConfigNumberDO();
                        cc.setTableName(tableName);
                        Date parse = sdf.parse(sdf.format(new Date()));
                        cc.setTime(parse);
                        c.setNumber(1);
                        String format = sdf.format(now);
                        configNumberMapper.insert(c);
                        code = format + "00001";
                    }
                }catch (Exception e){
                    throw ServiceExceptionUtil.exception(ErrorCodeConstants.CONFIG_NUMBER_EXISTS);
                }finally {
                    redisDistributedLock.releaseLock(tableName);
                }
                break;
            }else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw ServiceExceptionUtil.exception(ErrorCodeConstants.NUMBER_GET_LOCK_EXISTS);
                }

            }
        }
        return code;
    }



}
