package chapter11;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TimeFormatClass {

    public static void main(String[] args) {
        var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //MM e mm
        //HH 24 e hh 12

        var dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy 'at' HH:mm:ss");

    var ldt = java.time.LocalDateTime.now();
    System.out.println(dtf.format(ldt));
    System.out.println(dtf2.format(ldt));
    System.out.println(ldt.format(dtf));
    System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));


    var dateF = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
            .format(java.time.LocalDate.now());
        System.out.println(dateF);
    var dateTimeF = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
                .format(java.time.LocalTime.now());
        System.out.println(dateTimeF);
    }
}

