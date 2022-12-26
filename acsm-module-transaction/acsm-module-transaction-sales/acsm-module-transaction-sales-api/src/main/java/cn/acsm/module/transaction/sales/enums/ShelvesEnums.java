package cn.acsm.module.transaction.sales.enums;

/**
 * 售品类型
 */
public enum ShelvesEnums {

    RawMaterialShelvesServiceImpl(0,"rawMaterialShelvesServiceImpl"),
    InputShelvesServiceImpl(1,"inputShelvesServiceImpl"),
    CommodityShelvesServiceImpl(2,"commodityShelvesServiceImpl"),
    DishesShelvesServiceImpl(3,"dishesShelvesServiceImpl"),
    PackageShelvesServiceImpl(4,"packageShelvesServiceImpl"),
    SpecialMedicalFoodShelvesServiceImpl(5,"specialMedicalFoodShelvesServiceImpl"),
    ;

    private final Integer type;

    private final String value;

    ShelvesEnums(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public static ShelvesEnums getByType(Integer type) {
        for (ShelvesEnums shelvesEnums : ShelvesEnums.values()) {
            if (shelvesEnums.type==type) {
                return shelvesEnums;
            }
        }
        return null;
    }
}
