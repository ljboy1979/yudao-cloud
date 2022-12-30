package cn.acsm.module.transaction.sales.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {

    // ========== 商品 TODO 2000000000 ==========
    ErrorCode COMMODITY_NOT_EXISTS = new ErrorCode(2000000000, "商品不存在");
    ErrorCode COMMODITY_ORGANIZATION_NOT_EXISTS = new ErrorCode(2000000001, "商品组成不存在");
    ErrorCode COMMODITY_SKU_NOT_EXISTS = new ErrorCode(2000000002, "商品sku不存在");
    ErrorCode COMMODITY_CATEGORY_NOT_EXISTS = new ErrorCode(2000000003, "商品分类不存在");
    ErrorCode RAW_MATERIAL_NOT_EXISTS = new ErrorCode(2000000004, "原料不存在");
    ErrorCode RAW_MATERIAL_CLASSIFY_NOT_EXISTS = new ErrorCode(2000000005, "原料分类不存在");
    ErrorCode INPUTS_INFO_NOT_EXISTS = new ErrorCode(2000000006, "投入品不存在");
    ErrorCode INPUT_CLASSIFY_NOT_EXISTS = new ErrorCode(2000000007, "投入品分类不存在");
    ErrorCode RAW_MATERIAL_SPECIFICATION_NOT_EXISTS = new ErrorCode(2000000008, "原料规格不存在");
    ErrorCode COMMODITY_SPECIFICATION_NOT_EXISTS = new ErrorCode(2000000009, "商品规格不存在");
    ErrorCode INPUTS_INFO_SPECIFICATION_NOT_EXISTS = new ErrorCode(2000000010, "投入品规格不存在");
    ErrorCode DISHES_NOT_EXISTS = new ErrorCode(2000000011, "菜品不存在");
    ErrorCode DISHES_CATEGORY_NOT_EXISTS = new ErrorCode(2000000012, "菜品分类不存在");
    ErrorCode DISHES_ORGANIZATION_NOT_EXISTS = new ErrorCode(2000000013, "菜品组成不存在");
    ErrorCode DISHES_SPECIFICATION_NOT_EXISTS = new ErrorCode(2000000014, "菜品规格不存在");
    ErrorCode CONFIG_NUMBER_EXISTS = new ErrorCode(2000000015, "生成编码失败，异常信息");
    ErrorCode NUMBER_GET_LOCK_EXISTS= new ErrorCode(2000000016, "编码获取锁失败，异常信息");
    ErrorCode COMMODITY_EXISTENCE = new ErrorCode(2000000017, "商品已存在");
    ErrorCode COMMODITY_ORGANIZATION_EXISTENCE = new ErrorCode(2000000018, "商品组成已存在");
    ErrorCode COMMODITY_SPECIFICATION_EXISTENCE = new ErrorCode(2000000019, "商品规格以存在");
    ErrorCode RAW_MATERIAL_EXISTENCE = new ErrorCode(2000000020, "原料已存在");
    ErrorCode RAW_MATERIAL_SPECIFICATION_EXISTENCE = new ErrorCode(2000000021, "原料规格已存在");
    ErrorCode INPUTS_INFO_EXISTENCE = new ErrorCode(2000000022, "投入品已存在");
    ErrorCode INPUTS_INFO_SPECIFICATION_EXISTENCE= new ErrorCode(2000000023, "投入品规格已存在");
    ErrorCode DISHES_NOT_EXISTENCE = new ErrorCode(2000000024, "菜品已存在");
    ErrorCode PACKAGE_NOT_EXISTS = new ErrorCode(2000000025, "套餐不存在");
    ErrorCode PACKAGE_NOT_EXISTENCE = new ErrorCode(2000000026, "套餐已存在");
    ErrorCode PACKAGE_SPECIFICATION_NOT_EXISTS = new ErrorCode(2000000027, "套餐规格不存在");
    ErrorCode PACKAGE_SPECIFICATION_EXISTENCE = new ErrorCode(2000000028, "套餐规格已存在");
    ErrorCode PACKAGE_ORGANIZATION_NOT_EXISTS = new ErrorCode(2000000029, "套餐组成不存在");
    ErrorCode PACKAGE_ORGANIZATION_EXISTENCE  = new ErrorCode(2000000030, "套餐组成已存在");
    ErrorCode NUTRITION_FACTS_NOT_EXISTS  = new ErrorCode(2000000031, "营养成分不存在");
    ErrorCode PACKAGE_CLASSIFY_NOT_EXISTS = new ErrorCode(2000000032, "套餐分类不存在");
    ErrorCode SPECIAL_MEDICAL_FOOD_NOT_EXISTS = new ErrorCode(2000000033, "特医食品不存在");
    ErrorCode SPECIAL_MEDICAL_FOOD_CLASSIFY_NOT_EXISTS = new ErrorCode(2000000034, "特医食品分类不存在");
    ErrorCode SPECIAL_MEDICAL_FOOD_ORGANIZATION_NOT_EXISTS = new ErrorCode(2000000035, "特医食品组成不存在");
    ErrorCode SPECIAL_MEDICAL_FOOD_SPECIFICATION_NOT_EXISTS = new ErrorCode(2000000036, "特医食品规格不存在");
    ErrorCode SPECIAL_MEDICAL_FOOD_EXISTENCE = new ErrorCode(2000000033, "特医食品已存在");
    ErrorCode SPECIAL_MEDICAL_FOOD_SPECIFICATION_EXISTENCE = new ErrorCode(2000000036, "特医食品规格不存在");
    ErrorCode STRATEGY_NOT_DEFINED =  new ErrorCode (2000000037, "未定义策略,未找到通知接口对应的处理实现类");
    ErrorCode STOCK_CLASSIFY_OVER_LIMIT = new ErrorCode(2100000038, "库存分类层级已超限制，最大4级");
    ErrorCode STOCK_CLASSIFY_OVER_LIMIT3 = new ErrorCode(2100000038, "库存分类层级已超限制，最大3级");

}
