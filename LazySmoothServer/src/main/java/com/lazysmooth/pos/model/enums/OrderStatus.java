package com.lazysmooth.pos.model.enums;

public enum OrderStatus {

    APPETIZER("appetizer", 1),
    MAIN("main", 2),
    SET("set", 3),
    BEVERAGE("beverage", 4),
    DESSERT("dessert", 5);

    private final String valueString;
    private final Integer valueInt;

    OrderStatus(String valueString, Integer valueInt) {
        this.valueString = valueString;
        this.valueInt = valueInt;
    }

    public String getValueString() {
        return this.valueString;
    }
    public Integer getValueInt() {
        return this.valueInt;
    }

    public static OrderStatus fromString(String value) {
        for (OrderStatus tableStatus : OrderStatus.values()) {
            if (tableStatus.valueString.equalsIgnoreCase(value)) {
                return tableStatus;
            }
        }
        return null;
    }

    public static OrderStatus fromInt(Integer value) {
        for (OrderStatus tableStatus : OrderStatus.values()) {
            if (tableStatus.valueInt.intValue() == value) {
                return tableStatus;
            }
        }
        return null;
    }
}
