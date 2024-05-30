package form;

import dao.CityDAO;
import dao.CurrentWeatherDAO;
import dao.WeatherConditionDAO;
import event.EventClick;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.City;
import models.CurrentWeather;
import models.HourlyForecast;
import org.json.simple.JSONObject;
import service.WeatherAPI;

public class Form_Weather extends javax.swing.JPanel {

    private Form_WeatherSummary fWeatherSummary;
    private Form_HomNay fHomNay;
    private Form_TheoGio fTheoGio;

    public Form_Weather() {
        initComponents();
        setVisible(true);

        fWeatherSummary = new Form_WeatherSummary();
        fHomNay = new Form_HomNay();
        fTheoGio = new Form_TheoGio();
        
        setForm(panelWeatherSummary, fWeatherSummary);
        setForm(mainPanel, new Form_HomNay());
        searchBar.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city_name = searchBar.txtSearch.getText();
                if (city_name.equals("")) {
                } else {
                    City city = CityDAO.getInstance().selectById(city_name);
                    showFormHomNay(city);
                    showFormTheoGio(city);
                }
            }
        });
    }

    public void setForm(JPanel panel, JComponent com) {
        panel.removeAll();
        panel.add(com);
        panel.repaint();
        panel.revalidate();
    }

    public void showFormHomNay(City city) {
        CurrentWeather currentWeather = WeatherAPI.getCurrentWeather(city.getLatitude(), city.getLongitude(), city.getCity_id());
        if (currentWeather != null) {
            boolean check = false;
            for (CurrentWeather cW : CurrentWeatherDAO.getInstance().selectAll()) {
                if (cW.getCityId() == city.getCity_id()) {
                    check = true;
                    break;
                }
            }
            if (check) {
                fHomNay.setInfo(city.getCity_name(), currentWeather.getTemperature(), WeatherConditionDAO.getDescription(currentWeather.getWeatherCondition()), currentWeather.getVisibility(), currentWeather.getWindSpeed(), currentWeather.getFeels_like(), currentWeather.getHumidity(), currentWeather.getClouds(), currentWeather.getUv());
                setForm(mainPanel, fHomNay);
            } else {
                fHomNay.setInfo(city.getCity_name(), currentWeather.getTemperature(), "Very Hot", currentWeather.getVisibility(), currentWeather.getWindSpeed(), currentWeather.getFeels_like(), currentWeather.getHumidity(), currentWeather.getClouds(), currentWeather.getUv());
                setForm(mainPanel, fHomNay);
                CurrentWeatherDAO.getInstance().insert(currentWeather);
            }
        }
    }

    public void showFormTheoGio(City city) {
        List<HourlyForecast> hourlyForecasts = WeatherAPI.getHourlyForecast(city.getLatitude(), city.getLongitude(), city.getCity_id());
        fTheoGio = new Form_TheoGio();
//        for (HourlyForecast forecast : hourlyForecasts) {
//            System.out.println("Timestamp: " + forecast.getHf_timestamp());
//            System.out.println("Temperature: " + forecast.getTemperature());
//            System.out.println("Feels Like: " + forecast.getFeels_like());
//            System.out.println("Weather: " + forecast.getWeather_condition_id());
//            System.out.println("Icon: " + forecast.getIcon());
//            System.out.println("Pressure: " + forecast.getPressure());
//            System.out.println("Humidity: " + forecast.getHumidity());
//            System.out.println("Clouds: " + forecast.getClouds());
//            System.out.println("Uv: " + forecast.getUv());
//            System.out.println("Visibility: " + forecast.getVisibility());
//            System.out.println("Wind Speed: " + forecast.getWind_speed());
//            System.out.println("Pop: " + forecast.getPop());
//            System.out.println("Aqi: " + forecast.getAqi());
//            System.out.println("----------------------");
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWeatherDetail = new swing.PanelBorder();
        btnHienTai = new swing.MyButton();
        btnTheoGio = new swing.MyButton();
        btnHangNgay = new swing.MyButton();
        mainPanel = new javax.swing.JPanel();
        panelWeatherSummary = new swing.PanelBorder();
        panelAlert = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchBar = new component.SearchBar();

        setOpaque(false);

        panelWeatherDetail.setBackground(new java.awt.Color(153, 204, 255));

        btnHienTai.setText("HIỆN TẠI");
        btnHienTai.setColorClick(new java.awt.Color(204, 255, 255));
        btnHienTai.setColorOver(new java.awt.Color(0, 204, 255));
        btnHienTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienTaiActionPerformed(evt);
            }
        });

        btnTheoGio.setText("THEO GIỜ");
        btnTheoGio.setColorClick(new java.awt.Color(204, 255, 255));
        btnTheoGio.setColorOver(new java.awt.Color(0, 204, 255));
        btnTheoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheoGioActionPerformed(evt);
            }
        });

        btnHangNgay.setText("HÀNG NGÀY");
        btnHangNgay.setColorClick(new java.awt.Color(204, 255, 255));
        btnHangNgay.setColorOver(new java.awt.Color(0, 204, 255));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelWeatherDetailLayout = new javax.swing.GroupLayout(panelWeatherDetail);
        panelWeatherDetail.setLayout(panelWeatherDetailLayout);
        panelWeatherDetailLayout.setHorizontalGroup(
            panelWeatherDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWeatherDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWeatherDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelWeatherDetailLayout.createSequentialGroup()
                        .addComponent(btnHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnTheoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHangNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelWeatherDetailLayout.setVerticalGroup(
            panelWeatherDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWeatherDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWeatherDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTheoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHangNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelWeatherSummary.setBackground(new java.awt.Color(153, 204, 255));
        panelWeatherSummary.setLayout(new java.awt.BorderLayout());

        panelAlert.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alert History");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("------------------------------------------------------");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelAlertLayout = new javax.swing.GroupLayout(panelAlert);
        panelAlert.setLayout(panelAlertLayout);
        panelAlertLayout.setHorizontalGroup(
            panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        panelAlertLayout.setVerticalGroup(
            panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlertLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 181, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelWeatherDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelWeatherSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelWeatherDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelWeatherSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHienTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienTaiActionPerformed
        setForm(mainPanel, fHomNay);
    }//GEN-LAST:event_btnHienTaiActionPerformed

    private void btnTheoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheoGioActionPerformed
        setForm(mainPanel, fTheoGio);
    }//GEN-LAST:event_btnTheoGioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnHangNgay;
    private swing.MyButton btnHienTai;
    private swing.MyButton btnTheoGio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel mainPanel;
    private swing.PanelBorder panelAlert;
    private swing.PanelBorder panelWeatherDetail;
    public swing.PanelBorder panelWeatherSummary;
    private component.SearchBar searchBar;
    // End of variables declaration//GEN-END:variables
}
