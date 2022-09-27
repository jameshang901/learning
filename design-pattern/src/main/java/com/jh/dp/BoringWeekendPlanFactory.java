package com.jh.dp;

public class BoringWeekendPlanFactory implements WeekendPlanFactory {

    @Override
    public WeekendPlan create() {
        return new BoringWeekendPlan("Tomboy", "Ben", "Bob", "Nancy");
    }
}
