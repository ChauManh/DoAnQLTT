package form;

import dao.CityDAO;
import dao.CurrentWeatherDAO;
import dao.HourlyForecastDAO;
import dao.WeatherConditionDAO;
import event.EventClick;
import event.NavigationListener;
import form.Form_TheoGio;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.City;
import models.CurrentWeather;
import models.HourlyForecast;
import org.json.simple.JSONObject;
import service.ServiceConvertIcon;
import service.UnixConvertTime;
import service.WeatherAPI;

public class Form_Weather extends javax.swing.JPanel {

    private Form_WeatherSummary fWeatherSummary;
    private Form_HomNay fHomNay;
    private List<HourlyForecast> arrayHourlyForecast;
    private List<Form_TheoGio> arrayFormTheoGio;
    private boolean check;
    private int currentIndex = 0;

    public Form_Weather() {
        initComponents();
        setVisible(true);

        fWeatherSummary = new Form_WeatherSummary();
        fHomNay = new Form_HomNay();

        setForm(panelWeatherSummary, fWeatherSummary);
        searchBar.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city_name = searchBar.txtSearch.getText();
                if (city_name.equals("")) {
                } else {
                    boolean check = false;
                    City city = CityDAO.getInstance().selectById(city_name);
                    showFormHomNay(city);
                    arrayHourlyForecast = WeatherAPI.getHourlyForecast(city.getLatitude(), city.getLongitude(), city.getCity_id());
                    InsertDataHourlyWeather();
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
            for (CurrentWeather cW : CurrentWeatherDAO.getInstance().selectAll()) {
                if (cW.getCityId() == city.getCity_id()) {
                    check = true;
                    break;
                }
            }
            if (check) {
                fHomNay.setInfo(city.getCity_name(), ServiceConvertIcon.toIcon(currentWeather.getIcon()), currentWeather.getTemperature(), WeatherConditionDAO.getDescription(currentWeather.getWeatherCondition()), currentWeather.getVisibility(), currentWeather.getWindSpeed(), currentWeather.getFeels_like(), currentWeather.getPressure(), currentWeather.getHumidity(), currentWeather.getClouds(), currentWeather.getUv());
                setForm(mainPanel, fHomNay);
            } else {
                fHomNay.setInfo(city.getCity_name(), ServiceConvertIcon.toIcon(currentWeather.getIcon()), currentWeather.getTemperature(), WeatherConditionDAO.getDescription(currentWeather.getWeatherCondition()), currentWeather.getVisibility(), currentWeather.getWindSpeed(), currentWeather.getFeels_like(), currentWeather.getPressure(), currentWeather.getHumidity(), currentWeather.getClouds(), currentWeather.getUv());
                setForm(mainPanel, fHomNay);
                CurrentWeatherDAO.getInstance().insert(currentWeather);
            }
        }
    }

    private void InsertDataHourlyWeather() {
        if (!check) {
            for (int i = 1; i < gioConLai(); i++) {
                HourlyForecast hF = arrayHourlyForecast.get(i);
                HourlyForecastDAO.getInstance().insert(hF);
            }
        }
    }

    private void setUpFormTheoGio() {
        arrayFormTheoGio = new ArrayList<>();
        int size = gioConLai();

        for (int i = 0; i < size; i += 3) {
            // Tạo một sublist với tối đa 3 phần tử từ hourlyForecastList
            List<HourlyForecast> subList = arrayHourlyForecast.subList(i, Math.min(i + 4, size));
            // Tạo một đối tượng Form_TheoGio mới với subList
            Form_TheoGio formTheoGio = new Form_TheoGio(subList, new NavigationListener() {
                @Override
                public void onNext() {
                    nextFormTheoGio();
                }

                @Override
                public void onPrevious() {
                    previousFormTheoGio();
                }
            });
            // Thêm formTheoGio vào arrayFormTheoGio
            arrayFormTheoGio.add(formTheoGio);
        }

    }

    private int gioConLai() {
        return 24 - UnixConvertTime.toHour(arrayHourlyForecast.get(0).getHf_timestamp());
    }

    private void nextFormTheoGio() {
        if (currentIndex < arrayFormTheoGio.size() - 1) {
            currentIndex++;
            setForm(mainPanel, arrayFormTheoGio.get(currentIndex));
        }
    }

    private void previousFormTheoGio() {
        if (currentIndex > 0) {
            currentIndex--;
            setForm(mainPanel, arrayFormTheoGio.get(currentIndex));
        }
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
        btnHangNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangNgayActionPerformed(evt);
            }
        });

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
        setUpFormTheoGio();
        if (!arrayFormTheoGio.isEmpty()) {
            currentIndex = 0; // Reset chỉ số hiện tại
            setForm(mainPanel, arrayFormTheoGio.get(currentIndex));
        }
    }//GEN-LAST:event_btnTheoGioActionPerformed

    private void btnHangNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangNgayActionPerformed

    }//GEN-LAST:event_btnHangNgayActionPerformed


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
