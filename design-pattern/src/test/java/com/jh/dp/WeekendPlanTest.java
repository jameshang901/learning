package com.jh.dp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeekendPlanTest {

    public void boringWeekendPlan() {
        WeekendPlanFactory weekendPlanFactory = new BoringWeekendPlanFactory();
        WeekendPlan weekendPlan = weekendPlanFactory.create();

        weekendPlan.beforeDinner();

        WeekendDinnerOrder weekendDinnerOrder = WeekendDinnerOrder.create();
        WeekendDinner weekendDinner = weekendDinnerOrder.appetizer("cabbage").appetizer("cucumber").dinner("pork").dinner("chicken").dessert("candy").order();

        weekendPlan.duringDinner(weekendDinner);

        weekendPlan.afterDinner();
    }

    public void excitingWeekendPlan() {
        WeekendPlanFactory weekendPlanFactory = new ExcitingWeekendPlanFactory();
        WeekendPlan weekendPlan = weekendPlanFactory.create();

        weekendPlan.beforeDinner();

        WeekendDinnerOrder weekendDinnerOrder = WeekendDinnerOrder.create();
        WeekendDinner weekendDinner = weekendDinnerOrder.appetizer("caviar").appetizer("mushroom").dinner("steak").dinner("wine").dessert("tiramisu").dessert("pudding").order();

        weekendPlan.duringDinner(weekendDinner);

        weekendPlan.afterDinner();
    }

}
