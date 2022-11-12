package com.bvega.petapigraphql.util;

import java.time.DayOfWeek;

public class Util {

    public static DayOfWeek convertDay(String day){
        return switch (day.toUpperCase()) {
            case "MONDAY" -> DayOfWeek.MONDAY;
            case "TUESDAY" -> DayOfWeek.TUESDAY;
            case "WEDNESDAY" -> DayOfWeek.WEDNESDAY;
            case "THURSDAY" -> DayOfWeek.THURSDAY;
            case "FRIDAY" -> DayOfWeek.FRIDAY;
            case "SATURDAY" -> DayOfWeek.SATURDAY;
            case "SUNDAY" -> DayOfWeek.SUNDAY;
            default -> null;
        };
    }
}
