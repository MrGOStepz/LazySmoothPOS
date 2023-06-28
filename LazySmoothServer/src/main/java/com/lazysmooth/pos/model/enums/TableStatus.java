package com.lazysmooth.pos.model.enums;

public enum TableStatus {

    APPETIZER("appetizer", 1),
    MAIN("main", 2),
    SET("set", 3),
    BEVERAGE("beverage", 4),
    DESSERT("dessert", 5);

    private final String valueString;
    private final Integer valueInt;

    TableStatus(String valueString, Integer valueInt) {
        this.valueString = valueString;
        this.valueInt = valueInt;
    }

    public String getValueString() {
        return this.valueString;
    }
    public Integer getValueInt() {
        return this.valueInt;
    }

    public static TableStatus fromString(String value) {
        for (TableStatus tableStatus : TableStatus.values()) {
            if (tableStatus.valueString.equalsIgnoreCase(value)) {
                return tableStatus;
            }
        }
        return null;
    }

    public static TableStatus fromInt(Integer value) {
        for (TableStatus tableStatus : TableStatus.values()) {
            if (tableStatus.valueInt.intValue() == value) {
                return tableStatus;
            }
        }
        return null;
    }
}
