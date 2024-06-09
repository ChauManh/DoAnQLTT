package service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CheckTime {
    public static void main(String[] args) {
        // Khởi tạo và bắt đầu luồng kiểm tra thời gian
        Thread timeCheckerThread = new Thread(new TimeCheckerRunnable());
        timeCheckerThread.setDaemon(true); // Đặt luồng là daemon để nó tự động kết thúc khi chương trình chính kết thúc
        timeCheckerThread.start();

        // Tiến trình chính có thể tiếp tục thực hiện các công việc khác
        // Ví dụ: giả lập công việc chính bằng cách ngủ trong một thời gian
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Chương trình chính đang chạy...");
                Thread.sleep(10000); // Ngủ 10 giây
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TimeCheckerRunnable implements Runnable {
    private LocalTime lastCheckedHour;

    public TimeCheckerRunnable() {
        this.lastCheckedHour = LocalTime.now().withMinute(0).withSecond(0).withNano(0); // Khởi tạo giờ kiểm tra cuối cùng
    }

    @Override
    public void run() {
        while (true) {
            LocalTime currentTime = LocalTime.now();
            LocalTime currentHour = currentTime.withMinute(0).withSecond(0).withNano(0);

            // Kiểm tra xem đã qua giờ mới chưa
            if (!currentHour.equals(lastCheckedHour)) {
                System.out.println("Đã qua giờ mới: " + currentHour.format(DateTimeFormatter.ofPattern("HH:mm")));
                lastCheckedHour = currentHour; // Cập nhật giờ kiểm tra cuối cùng
            }

            // Ngủ một khoảng thời gian ngắn để tránh kiểm tra liên tục
            try {
                Thread.sleep(1000); // Kiểm tra mỗi giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
