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

}
