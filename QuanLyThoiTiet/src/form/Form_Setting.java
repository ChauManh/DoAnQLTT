package form;

import dao.CityDAO;
import dao.CurrentWeatherDAO;
import dao.DailyForecastDAO;
import dao.HourlyForecastDAO;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import models.City;
import models.CurrentWeather;
import models.DailyForecast;
import models.HourlyForecast;
import models.NguoiDung;
import service.UnixConvertTime;
import service.WeatherAPI;

public class Form_Setting extends javax.swing.JPanel {

    private NguoiDung user;
    private List<HourlyForecast> arrayHw;

    public Form_Setting(NguoiDung user) {
        this.user = user;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataSearch1 = new swing.DataSearch();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPrintCurrent = new swing.MyButton();
        btnPrintHourly = new swing.MyButton();
        btnPrintDaily = new swing.MyButton();
        jLabel3 = new javax.swing.JLabel();
        comboBoxCity = new swing.ComboBoxSuggestion();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Application by MLL");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Support print current, hourly, daily weather of 1 city to file csv");

        btnPrintCurrent.setText("Print current wethear");
        btnPrintCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintCurrentActionPerformed(evt);
            }
        });

        btnPrintHourly.setText("Print hourly wethear");
        btnPrintHourly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintHourlyActionPerformed(evt);
            }
        });

        btnPrintDaily.setText("Print daily wethear");
        btnPrintDaily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintDailyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select the city name");

        comboBoxCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A Yun Pa", "An Chau", "An Khe", "An Nhon", "An Phu", "An Thanh B", "Ap Binh Thanh", "Ap Da Loi", "Ap Khanh Hoa", "Ap Khanh Hung", "Ap Phu Hai", "Ap Phu My", "Ap Tan Ngai", "Ba Chuc", "Ba Don", "Ba Ria", "Bac Giang", "Bac Kan", "Bac Lieu", "Bac Ninh", "Bai Chay", "Bao Loc", "Ben Tre", "Bien Hoa", "Bim Son", "Binh Hoa", "Binh Hoa", "Binh Long", "Binh Minh", "Bo", "Buon Ho", "Buon Ma Thuot", "Buon Trap", "Buu Long", "Ca Mau", "Cai Lay", "Cam Pha", "Cam Ranh", "Cam Ranh", "Can Tho", "Cao Bang", "Cao Lanh", "Chau Doc", "Chi Linh", "Cho Lach", "Cho Moi", "Cho Phuoc Hai", "Chon Thanh", "Con Dao", "Cua Lo", "Da Lat", "Da Nang", "Di An", "Di Linh", "Dien Bien Phu", "Dong Ha", "Dong Hoa", "Dong Hoi", "Dong Xoai", "Duc Pho", "Duyen Hai", "Gia Nghia", "Gia Rai", "Go Cong", "Ha Giang", "Ha Long", "Ha Tien", "Ha Tinh", "Hai Duong", "Hai Phong", "Hang Tram", "Ha Noi", "Hiep Hoa", "Ho Chi Minh City", "Ho Nai", "Hoa Binh", "Hoa Thanh", "Hoa Thuong", "Hoi An", "Hong Ngu", "Hue", "Hung Yen", "Huong Canh", "Huong Thuy", "Huong Tra", "Khe Sanh", "Kien Giang", "Kien Luong", "Kinh Mon", "Kon Tum", "Ky Anh", "La Gi", "Lai Chau", "Lang Son", "Lao Cai", "Long Binh", "Long Khanh", "Long My", "Long Thanh", "Long Xuyen", "Luan Chau", "Mang La", "Mong Cai", "Mong Duong", "Muong Lay", "Muong Theng", "My Hoa", "My Luong", "My Tho", "Nam Dinh", "Nga Bay", "Nghi Son", "Nghia Lo", "Ngoc Son", "Nha Trang", "Nhan Trach", "Ninh Binh", "Ninh Hoa", "Phan Rang-Thap Cham", "Phan Ri Cua", "Phan Thiet", "Phu Ly", "Phu My", "Phu Quoc", "Phu Tho", "Phu Tu Son", "Phu Yen", "Phuc Yen", "Phuoc Long", "Pleiku", "Quang Ha", "Quang Ngai", "Quang Tri", "Quang Yen", "Quy Nhon", "Rach Gia", "Sa Dec", "Sa Pa", "Sam Son", "Soc Trang", "Son La", "Son Tay", "Song Cau", "Song Doc", "Tam Diep", "Tam Hiep", "Tam Ky", "Tan An", "Tan An", "Tan Chau", "Tan Phong", "Tan Phu", "Tan Phuoc Khanh", "Tan Son", "Tan Uyen", "Tan Van", "Tay Ninh", "Thai Binh", "Thai Nguyen", "Thanh Hoa", "Thanh Pho Uong Bi", "Thanh Phu", "Thanh Xuan", "Thi Tran Dong Dang", "Thi Tran Mau A", "Thi Tran Ngai Giao", "Thu Dau Mot", "Thu Duc", "Thuan An", "Thuan Tien", "Tra Vinh", "Trang Bang", "Tuy Hoa", "Tuyen Quang", "Vi Thanh", "Viet Tri", "Vinh", "Vinh Chau", "Vinh Long", "Vinh Yen", "Vung Tau", "Xuan Trung", "Yen Bai" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(358, 358, 358))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrintCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222)
                        .addComponent(btnPrintHourly, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintDaily, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrintCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrintHourly, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrintDaily, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkAvailable(City city) {
        if (CurrentWeatherDAO.getInstance().selectByIdR(city.getCity_id()) == null) {
            return false;
        } else {
            return true;
        }
    }

    private void printCurrentWeatherCSV(City city) {
        JFileChooser chooser = new JFileChooser(); // Tạo một đối tượng JFileChooser
        chooser.setDialogTitle("Choose Directory"); // Đặt tiêu đề cho hộp thoại
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Chỉ cho phép chọn thư mục
        int option = chooser.showOpenDialog(this); // Mở hộp thoại và đợi người dùng chọn thư mục

        if (option == JFileChooser.APPROVE_OPTION) { // Nếu người dùng chọn một thư mục
            File selectedDirectory = chooser.getSelectedFile(); // Lấy thư mục được chọn
            String directoryPath = selectedDirectory.getAbsolutePath(); // Lấy đường dẫn tuyệt đối của thư mục

            // Tạo tên file CSV dựa trên ngày/giờ hiện tại
            String timeStamp = new SimpleDateFormat("ddMMYYYY_HHmmss").format(new Date());
            String fileName = "CurrentWeather_" + city.getCity_name() + "_" + timeStamp + ".csv";

            // Tạo đường dẫn tuyệt đối cho file CSV
            String filePath = directoryPath + File.separator + fileName;
            if (checkAvailable(city) == true) {
                // Xuất dữ liệu thời tiết hiện tại vào file CSV tại đường dẫn đã chọn
                CurrentWeatherDAO.getInstance().CSVexport(city, filePath);
            } else {
                insertData(city);
                // Xuất dữ liệu thời tiết hiện tại vào file CSV tại đường dẫn đã chọn
                CurrentWeatherDAO.getInstance().CSVexport(city, filePath);
            }
            JOptionPane.showMessageDialog(null, "PRINT FILE CURRENT WEATHER CSV SUCCESS!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void printHourlyForecastCSV(City city) {
        JFileChooser chooser = new JFileChooser(); // Tạo một đối tượng JFileChooser
        chooser.setDialogTitle("Choose Directory"); // Đặt tiêu đề cho hộp thoại
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Chỉ cho phép chọn thư mục
        int option = chooser.showOpenDialog(this); // Mở hộp thoại và đợi người dùng chọn thư mục

        if (option == JFileChooser.APPROVE_OPTION) { // Nếu người dùng chọn một thư mục
            File selectedDirectory = chooser.getSelectedFile(); // Lấy thư mục được chọn
            String directoryPath = selectedDirectory.getAbsolutePath(); // Lấy đường dẫn tuyệt đối của thư mục

            // Tạo tên file CSV dựa trên ngày/giờ hiện tại
            String timeStamp = new SimpleDateFormat("ddMMYYYY_HHmmss").format(new Date());
            String fileName = "HourlyForecast_" + city.getCity_name() + "_" + timeStamp + ".csv";

            // Tạo đường dẫn tuyệt đối cho file CSV
            String filePath = directoryPath + File.separator + fileName;

            if (checkAvailable(city) == true) {
                // Xuất dữ liệu thời tiết hiện tại vào file CSV tại đường dẫn đã chọn
                HourlyForecastDAO.getInstance().CSVexport(city, filePath);
            } else {
                insertData(city);
                HourlyForecastDAO.getInstance().CSVexport(city, filePath);
            }
            JOptionPane.showMessageDialog(null, "PRINT FILE HOURLY FORECAST CSV SUCCESS!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private void printDailyForecastCSV(City city) {
        JFileChooser chooser = new JFileChooser(); // Tạo một đối tượng JFileChooser
        chooser.setDialogTitle("Choose Directory"); // Đặt tiêu đề cho hộp thoại
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Chỉ cho phép chọn thư mục
        int option = chooser.showOpenDialog(this); // Mở hộp thoại và đợi người dùng chọn thư mục
        if (option == JFileChooser.APPROVE_OPTION) { // Nếu người dùng chọn một thư mục
            File selectedDirectory = chooser.getSelectedFile(); // Lấy thư mục được chọn
            String directoryPath = selectedDirectory.getAbsolutePath(); // Lấy đường dẫn tuyệt đối của thư mục

            // Tạo tên file CSV dựa trên ngày/giờ hiện tại
            String timeStamp = new SimpleDateFormat("ddMMYYYY_HHmmss").format(new Date());
            String fileName = "DailyForecast_" + city.getCity_name()+ "_" + timeStamp + ".csv";

            // Tạo đường dẫn tuyệt đối cho file CSV
            String filePath = directoryPath + File.separator + fileName;

            if (checkAvailable(city) == true) {
                // Xuất dữ liệu thời tiết hiện tại vào file CSV tại đường dẫn đã chọn
                DailyForecastDAO.getInstance().CSVexport(city, filePath);
            } else {
                insertData(city);
                DailyForecastDAO.getInstance().CSVexport(city, filePath);
            }
            JOptionPane.showMessageDialog(null, "PRINT FILE DAILY FORECAST CSV SUCCESS!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void insertData(City city) {
        CurrentWeather cw = WeatherAPI.getCurrentWeather(city.getLatitude(), city.getLongitude(), city.getCity_id());
        CurrentWeatherDAO.getInstance().insert(cw);
        arrayHw = WeatherAPI.getHourlyForecast(city.getLatitude(), city.getLongitude(), city.getCity_id());
        for (int i = 1; i < gioConLai(); i++) {
            HourlyForecast hF = arrayHw.get(i);
            HourlyForecastDAO.getInstance().insert(hF);
        }
        List<DailyForecast> arrayDw = WeatherAPI.getDailyForecast(city.getLatitude(), city.getLongitude(), city.getCity_id());
        for (int i = 1; i < 7; i++) {
            DailyForecast dF = arrayDw.get(i);
            DailyForecastDAO.getInstance().insert(dF);
        }
    }

    private void btnPrintCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintCurrentActionPerformed
        String cityName = (String) comboBoxCity.getSelectedItem();
        City city = CityDAO.getInstance().selectById(cityName);
        printCurrentWeatherCSV(city);
    }//GEN-LAST:event_btnPrintCurrentActionPerformed

    private void btnPrintHourlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintHourlyActionPerformed
        String cityName = (String) comboBoxCity.getSelectedItem();
        City city = CityDAO.getInstance().selectById(cityName);
        printHourlyForecastCSV(city);
    }//GEN-LAST:event_btnPrintHourlyActionPerformed

    private void btnPrintDailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintDailyActionPerformed
        String cityName = (String) comboBoxCity.getSelectedItem();
        City city = CityDAO.getInstance().selectById(cityName);
        printDailyForecastCSV(city);
    }//GEN-LAST:event_btnPrintDailyActionPerformed

    private int gioConLai() {
        return 24 - UnixConvertTime.toHour(arrayHw.get(0).getHf_timestamp());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnPrintCurrent;
    private swing.MyButton btnPrintDaily;
    private swing.MyButton btnPrintHourly;
    private swing.ComboBoxSuggestion comboBoxCity;
    private swing.DataSearch dataSearch1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
