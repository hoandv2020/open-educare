package com.educare.open.utils;

public enum Rate {
    VERY_BAD(1), BAD(2), NORMAL(3), GOOD(4), EXCELLENT(5);
    private final Integer value;

    private Rate(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
