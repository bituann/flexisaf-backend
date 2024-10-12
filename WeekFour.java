package com.flexisaf.weekfour;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class WeekFour {

    public static void main (String[] args) {
        lengthOfEachMonth(2019);
        System.out.println("\n");

        listMondayInMonth("september");
        System.out.println("\n");
        
        System.out.println(confirmFridayThe13th(LocalDate.of(2024, 9, 13)));
    }

    public static void lengthOfEachMonth (int year) {
        for (int i = 1; i < 13; i++) {
            System.out.printf("%s: %d days \n", YearMonth.of(year, i), YearMonth.of(year, i).lengthOfMonth());
        }
    }

    public static void listMondayInMonth (String month) {
        Month usefulMonth = Month.valueOf(month.toUpperCase());
        LocalDate date1 = LocalDate.of(LocalDate.now().getYear(), usefulMonth, 1);

        TemporalAdjuster monday = TemporalAdjusters.next(DayOfWeek.MONDAY);
        for (LocalDate nextMon = date1.with(monday); nextMon.getMonth().equals(usefulMonth);) {
            System.out.printf("%s \n", nextMon);
            nextMon = nextMon.plusDays(7);
        }

    }

    public static boolean confirmFridayThe13th (LocalDate date) {
        return (date.getDayOfMonth() == 13) && (date.getDayOfWeek() == DayOfWeek.FRIDAY);
    }
}
