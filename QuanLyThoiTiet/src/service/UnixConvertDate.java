package service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UnixConvertDate {

    public static int toDay(long unixTime) {
        ZonedDateTime dateTime = Instant.ofEpochSecond(unixTime).atZone(ZoneId.systemDefault());
        return dateTime.getDayOfMonth();
    }

    public static int toMonth(long unixTime) {
        ZonedDateTime dateTime = Instant.ofEpochSecond(unixTime).atZone(ZoneId.systemDefault());
        return dateTime.getMonthValue();
    }

    public static int toYear(long unixTime) {
        ZonedDateTime dateTime = Instant.ofEpochSecond(unixTime).atZone(ZoneId.systemDefault());
        return dateTime.getYear();
    }
    
    public static String toFullDate(long unixTime) {
        ZonedDateTime dateTime = Instant.ofEpochSecond(unixTime).atZone(ZoneId.systemDefault());
        return String.format("%02d/%02d/%04d", dateTime.getDayOfMonth(), dateTime.getMonthValue(), dateTime.getYear());
    }

}
