package com.lazysmooth.pos.model.enums;

public enum Status {
    VACANT("Vacant", 1),
    EATING("Eating", 2),
    COOK("Cook", 3),
    PAID("Paid", 4),
    CLEANING("Cleaning", 5),
    DONE("Done", 6);

    private final String valueString;
    private final Integer valueInt;

    Status(String valueString, Integer valueInt) {
        this.valueString = valueString;
        this.valueInt = valueInt;
    }

    public String getValueString() {
        return this.valueString;
    }

    public Integer getValueInt() {
        return this.valueInt;
    }

    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            if (status.valueString.equalsIgnoreCase(value)) {
                return status;
            }
        }
        return null;
    }

    public static Status fromInt(Integer value) {
        for (Status status : Status.values()) {
            if (status.valueInt.intValue() == value) {
                return status;
            }
        }
        return null;
    }
}
