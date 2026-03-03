package chapter04;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTime {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        //in United States, the time zone is typically represented as
        // "America/New_York" or "America/Los_Angeles",
        // while in Europe, it might be "Europe/London" or "Europe/Paris".
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));
        System.out.println(ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/London")));
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));
    }
}

class LocalDateTimeZoneOf {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2024, 6, 1);
        System.out.println(ld);

        var zone = ZoneId.of("US/Eastern");

        ZonedDateTime zdt = ZonedDateTime.of(ld, LocalTime.of(12, 0), zone);
        System.out.println(zdt);
    }
}

class ManipulatingDateTime {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2024, 6, 1);
        System.out.println(ld);
        System.out.println(ld.plusDays(10));
        //System.out.println(ld.plusMonths(2));
        // System.out.println(ld.plusYears(1));
        // System.out.println(ld.minusDays(10));
        // System.out.println(ld.minusMonths(2));
        System.out.println(ld.minusYears(1));


        LocalTime lt = LocalTime.of(12, 0);
        lt.plusHours(10);
        lt.plusMinutes(60);

        var date = LocalDate.of(2024, 6, 1);
        var otherDate = date.withMonth(10);
        System.out.println(otherDate);
    }
}

class Periods {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2024, 6, 1);
        LocalDate ld2 = LocalDate.of(2025, 8, 15);
        Period period = Period.between(ld, ld2);
        System.out.println(period);


        Period period1 = Period.ofMonths(1);
        var everyYearAndAWeek =
                Period.of(1, 0, 7);
        // every year plus 1 week
        System.out.println(period1);
        performAnimalEnrichment(ld, ld2, period1);
    }

    private static void performAnimalEnrichment(LocalDate start,
                                                LocalDate end,
                                                Period period) {             // uses the generic period
        var upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo =
                    upTo.plus(period); // adds the period
        }
    }
}

class Durations {
    public static void main(String[] args) {
        LocalTime lt = LocalTime.of(12, 0);
        LocalTime lt2 = LocalTime.of(14, 30);
        Duration duration = Duration.between(lt, lt2);
        System.out.println(duration);

        Duration duration1 = Duration.ofHours(1);
        var everyTwoHours = Duration.of(2, ChronoUnit.HOURS);
        System.out.println(duration1);
    }
}
class ChronoUnitClass {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2024, 6, 1);
        LocalDate ld2 = LocalDate.of(2025, 8, 15);
        long monthsBetween = ChronoUnit.MONTHS.between(ld, ld2);
        System.out.println(monthsBetween);

        long daysBetween = ChronoUnit.DAYS.between(ld, ld2);
        System.out.println(daysBetween);
        LocalTime lt = LocalTime.of(12, 0,35);
        System.out.println(lt.truncatedTo(ChronoUnit.MINUTES));
    }
}
class InstantClass {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant instant2 = Instant.ofEpochSecond(0);
        System.out.println(instant2);

       // se voce tem um zonedDateTime e quer converter para um Instant,
        // voce pode usar o methodo toInstant()
        var date = LocalDate.of(2025, 5, 25);
        var time = LocalTime.of(11, 55, 00);
        var zone = ZoneId.of("US/Eastern");
        var zonedDateTime = ZonedDateTime.of(date, time, zone);
        var instant3 = zonedDateTime.toInstant();

    }
}