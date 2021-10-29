package br.ucsal.ucsalnews.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final String DATE_FORMAT = "dd/MM/yyyy HH:mm";

    private DateUtil() {
    }

    public static LocalDateTime changeStringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDateTime.parse(date, formatter);
    }

}
