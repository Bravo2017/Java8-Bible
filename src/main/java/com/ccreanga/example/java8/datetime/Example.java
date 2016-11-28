package com.ccreanga.example.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Set;

public class Example {

    public static void main(String[] args) {

        // the current date
        LocalDate currentDate = LocalDate.now();
        // 2015-02-10
        LocalDate tenthFeb2015 = LocalDate.of(2015, Month.FEBRUARY, 10);
        LocalDate sixtyFifthDayOf2015 = LocalDate.ofYearDay(2015, 65);


        LocalTime currentTime = LocalTime.now(); // current time
        LocalTime midday = LocalTime.of(12, 0); // 12:00

        // dates with times
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime christmas2015 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);

        //operation
        // before 5 houres and 30 minutes
        LocalDateTime dateTime = LocalDateTime.now().minusHours(5).minusMinutes(30).plusDays(1);


        ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
        ZoneId berlin = ZoneId.of("Europe/Berlin");

        dateTime = LocalDateTime.now();

        ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);
        ZonedDateTime losAngelesDateTime = berlinDateTime.withZoneSameInstant(losAngeles);
        System.out.println(berlinDateTime);
        System.out.println(losAngelesDateTime);

        // periods

        LocalDate firstDate = LocalDate.of(2010, 5, 17);
        LocalDate secondDate = LocalDate.now();
        Period period = Period.between(firstDate, secondDate);

        int days = period.getDays();
        int months = period.getMonths();
        int years = period.getYears();
        boolean isNegative = period.isNegative();
        System.out.printf("days %s months %s years %s isNegative %s",days,months,years,isNegative);


        Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
        LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);

        // add two months and five days to 2014-01-06, result is 2014-03-11
        LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);


        // durations

        Instant firstInstant = Instant.ofEpochSecond(1294881180); // 2011-01-13 01:13
        Instant secondInstant = Instant.ofEpochSecond(1294708260); // 2011-01-11 01:11

        Duration between = Duration.between(firstInstant, secondInstant);

        // negative because firstInstant is after secondInstant (-172920)
        long seconds = between.getSeconds();

        // get absolute result in minutes (2882)
        long absoluteResult = between.abs().toMinutes();

        // two hours in seconds (7200)
        long twoHoursInSeconds = Duration.ofHours(2).getSeconds();


        // 2014-04-01 10:45
        LocalDateTime dateTime2 = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);

        // format as basic ISO date format (20140220)
        String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);

        // format as ISO week date (2014-W08-4)
        String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);

        // format ISO date time (2014-02-20T20:04:05.867)
        String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);

        // using a custom pattern (01/04/2014)
        String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // french date formatting (1. avril 2014)
        String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr")));

        // using short german date/time formatting (01.04.14 10:45)
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(new Locale("de"));
        String germanDateTime = dateTime.format(formatter);

        // parsing date strings
        LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
        LocalDate fromIsoWeekDate = LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
        LocalDate fromCustomPattern = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

}
