package com.lazysmooth.pos.model.enums;

public enum OrderType {
    DINE_IN("Dine-In", 1),
    TAKEAWAY("Takeaway", 2),
    DELIVERY("Delivery", 3);

    private final String valueString;
    private final Integer valueInt;

    OrderType(String valueString, Integer valueInt) {
        this.valueString = valueString;
        this.valueInt = valueInt;
    }

    public String getValueString() {
        return this.valueString;
    }

    public Integer getValueInt() {
        return this.valueInt;
    }

    public static OrderType fromString(String value) {
        for (OrderType foodType : OrderType.values()) {
            if (foodType.valueString.equalsIgnoreCase(value)) {
                return foodType;
            }
        }
        return null;
    }

    public static OrderType fromInt(Integer value) {
        for (OrderType orderType : OrderType.values()) {
            if (orderType.valueInt.intValue() == value) {
                return orderType;
            }
        }
        return null;
    }
}