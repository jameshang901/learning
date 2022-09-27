package com.jh.dp;

public class ExcitingWeekendPlanFactory implements WeekendPlanFactory {

    @Override
    public WeekendPlan create() {
        return new ExcitingWeekendPlan("Chatterley", "Flower", "Champagne", "RoomKey");
    }

}
