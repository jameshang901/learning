package com.jh.dp;

public class WeekendDinnerOrder {

    public static WeekendDinnerOrder create() {
        return new WeekendDinnerOrder();
    }

    public WeekendDinnerOrder appetizer(String appetizer) {
        return this;
    }

    public WeekendDinnerOrder dinner(String dinner) {
        return this;
    }

    public WeekendDinnerOrder dessert(String dessert) {
        return this;
    }

    public WeekendDinner order() {
        return new WeekendDinner();
    }

}
