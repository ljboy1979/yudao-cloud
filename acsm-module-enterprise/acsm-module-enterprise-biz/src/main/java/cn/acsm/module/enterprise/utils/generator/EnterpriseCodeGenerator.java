package cn.acsm.module.enterprise.utils.generator;

import cn.acsm.module.enterprise.exception.OverflowException;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;

import static cn.acsm.module.enterprise.dal.redis.RedisKeyConstants.ENTERPRISE_CODE_SEQUENCE;

/**
 * Created by wangd on 2019/11/15.  订单编号生成器
 */
@Component
public class EnterpriseCodeGenerator {

    @Autowired
	public RedisTemplate<String, String> redisTemplate;

    private static final String codePattern = "JYZT-{0}{1}";

    private static final Logger logger = LoggerFactory.getLogger(EnterpriseCodeGenerator.class);

    public synchronized String generate(Date d) {

        String date = DateUtil.format(d,"yyyyMMdd");

        BoundZSetOperations<String, String> operation = redisTemplate.boundZSetOps(ENTERPRISE_CODE_SEQUENCE.getKeyTemplate());

        //按当前日期，累加
        int currentNum = operation.incrementScore(date, 1d).intValue();

        if(currentNum > 65535) {
            throw new OverflowException("code overflow!");
        }
        String current = StringUtils.leftPad(currentNum+"", 4, '0');
        String code = MessageFormat.format(codePattern, date, current);

        logger.info("new enterprise code: " + code);

        return code;
    }

    public synchronized String generate() {

        return generate(new Date(System.currentTimeMillis()));
    }

}
