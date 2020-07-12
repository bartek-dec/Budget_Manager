package com.example;

import java.math.BigDecimal;

public enum Category {

    FOOD(null),
    CLOTHES(null),
    ENTERTAINMENT(null),
    OTHER(null);

    private BigDecimal total;

    Category(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String s = super.toString();

        StringBuilder builder = new StringBuilder();
        builder.append(s, 0, 1);
        builder.append(s.substring(1).toLowerCase());

        return builder.toString();
    }
}
