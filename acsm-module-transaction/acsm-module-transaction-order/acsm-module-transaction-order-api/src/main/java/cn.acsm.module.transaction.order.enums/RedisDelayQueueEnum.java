package cn.acsm.module.transaction.order.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RedisDelayQueueEnum {
    /**
     * 运营通知
     */
    COMPLETE_LOGISTICS("COMPLETE_LOGISTICS", "完成物流", "completeLogisticsServiceImpl");

    private final String queueCode;
    private final String desc;
    private final String beanId;

    public String getQueueCode() {
        return queueCode;
    }

    public String getDesc() {
        return desc;
    }

    public String getBeanId() {
        return beanId;
    }
}
