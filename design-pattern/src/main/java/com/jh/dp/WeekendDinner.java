package com.jh.dp;

import java.util.ArrayList;
import java.util.List;

public class WeekendDinner {

    private final List<String> appetizerList = new ArrayList<>();
    private final List<String> dinnerList = new ArrayList<>();
    private final List<String> dessertList = new ArrayList<>();
    private final List<String> flavorList = new ArrayList<>();

    public void appetizer(String appetizer) {
        appetizerList.add(appetizer);
    }

    public void dinner(String dinner) {
        dinnerList.add(dinner);
    }

    public void dessert(String dessert) {
        dessertList.add(dessert);
    }

    public void flavor(String flavor) {
        flavorList.add(flavor);
    }

}
