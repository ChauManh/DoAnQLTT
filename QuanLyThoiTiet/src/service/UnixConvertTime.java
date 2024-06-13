package service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class UnixConvertTime {

    public static int toHour(long unixTime) {
        ZonedDateTime dateTime = Instant.ofEpochSecond(unixTime).atZone(ZoneId.systemDefault());
        return dateTime.getHour();
    }

    public static String toHourMinuteString(long unixTime) {
        ZonedDateTime dateTime = Instant.ofEpochSecond(unixTime).atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return dateTime.format(formatter);
    }

}
