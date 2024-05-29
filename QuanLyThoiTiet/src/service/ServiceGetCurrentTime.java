package service;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class ServiceGetCurrentTime {
    
    public static String getDate() {
        // Lấy thời gian hiện tại theo múi giờ cụ thể (Ví dụ: Asia/Ho_Chi_Minh)
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        
        // Lấy thứ trong tuần
        String dayOfWeek = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        // Định dạng ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = now.format(formatter);
        
        // Hiển thị thời gian theo định dạng mong muốn
        String result = dayOfWeek + " " + formattedDate;
        return result;
    }
    
    public static String getTime() {
        // Lấy thời gian hiện tại
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        
        // Định dạng giờ phút
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = now.format(timeFormatter);
        
        // Hiển thị thời gian
        return formattedTime;
    }
}
