package service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class UnixConvertTime {
         public static int toHour(long unixTime) {
        ZonedDateTime dateTime = Instant.ofEpochSecond(unixTime).atZone(ZoneId.systemDefault());
        return dateTime.getHour();
    }
    
}
