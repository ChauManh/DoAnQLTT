package form;

import dao.CityDAO;
import dao.CurrentWeatherDAO;
import dao.DailyForecastDAO;
import dao.HourlyForecastDAO;
import dao.NguoiDungDAO;
import dao.UserAlertDAO;
import dao.UserAlertHistoryDAO;
import dao.WeatherConditionDAO;
import event.EventClick;
import event.NavigationListener;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.City;
import models.CurrentWeather;
import models.DailyForecast;
import models.HourlyForecast;
import models.NguoiDung;
import models.UserAlert;
import models.UserAlertHistory;
import org.json.simple.JSONObject;
import service.ServiceConvertIcon;
import service.UnixConvertTime;
import service.WeatherAPI;

public class Form_Weather extends javax.swing.JPanel {

    private Form_WeatherSummary fWeatherSummary;
    private Form_HomNay fHomNay;
    private List<HourlyForecast> arrayHourlyForecast;
    private List<Form_TheoGio> arrayFormTheoGio;
    private List<DailyForecast> arrayDailyForecast;
    private List<Form_TheoNgay> arrayFormTheoNgay;
    private List<UserAlertHistory> arrayUserAlertHistory;
    private boolean check;
    private int currentHfIndex = 0;
    private int currentDfIndex = 0;
    private Form_SetLocation fSetLocation;
    private final NguoiDung user;
    private Form_AlertHistory fAlertHistory;

    public Form_Weather(NguoiDung user) {
        initComponents();
        this.user = user;
        setVisible(true);
        setDefaultMyWeather();
        setAlertHistory();
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
                    arrayDailyForecast = WeatherAPI.getDailyForecast(city.getLatitude(), city.getLongitude(), city.getCity_id());
                    InsertDataDailyWeather();
                    btnHienTai.setColor(new Color(255, 255, 51));
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

    private void setDefaultMyWeather() {
        if (user.getCurrent_city_fk() != 0) {
            City city_user = CityDAO.getInstance().selectByIdR(user.getCurrent_city_fk());
            CurrentWeather cw = WeatherAPI.getCurrentWeather(city_user.getLatitude(), city_user.getLongitude(), city_user.getCity_id());
            fWeatherSummary = new Form_WeatherSummary(cw, city_user);
            setForm(myLocationPanel, fWeatherSummary);
        }
    }

    public void setMyWeatherWhenChanged(int currentCityChanged) {
        if (user.getCurrent_city_fk() != 0) {
            City city_user = CityDAO.getInstance().selectByIdR(currentCityChanged);
            CurrentWeather cw = WeatherAPI.getCurrentWeather(city_user.getLatitude(), city_user.getLongitude(), city_user.getCity_id());
            fWeatherSummary = new Form_WeatherSummary(cw, city_user);
            setForm(myLocationPanel, fWeatherSummary);
        }
    }

    public void setAlertHistory() {
        arrayUserAlertHistory = UserAlertHistoryDAO.getInstance().selectAllById(user);
        if (arrayUserAlertHistory.size() != 0) {
            fAlertHistory = new Form_AlertHistory(arrayUserAlertHistory);
            setForm(mainPanelAlert, fAlertHistory);
        }
    }

    public void showFormHomNay(City city) {
        fHomNay = new Form_HomNay();
        CurrentWeather currentWeather = WeatherAPI.getCurrentWeather(city.getLatitude(), city.getLongitude(), city.getCity_id());
        fHomNay.setInfo(city.getCity_name(), ServiceConvertIcon.toIcon(currentWeather.getIcon()), currentWeather.getTemperature(), WeatherConditionDAO.getDescription(currentWeather.getWeatherCondition()), currentWeather.getVisibility(), currentWeather.getWindSpeed(), currentWeather.getFeels_like(), currentWeather.getPressure(), currentWeather.getHumidity(), currentWeather.getClouds(), currentWeather.getUv());
        setForm(mainPanel, fHomNay);
        if (currentWeather != null) {
            CurrentWeatherDAO.getInstance().insert(currentWeather);
        }
    }

    private void InsertDataHourlyWeather() {
        for (int i = 1; i < gioConLai(); i++) {
            HourlyForecast hF = arrayHourlyForecast.get(i);
            HourlyForecastDAO.getInstance().insert(hF);
        }
    }

    private void InsertDataDailyWeather() {
        for (int i = 1; i < 7; i++) {
            DailyForecast dF = arrayDailyForecast.get(i);
            DailyForecastDAO.getInstance().insert(dF);
        }
    }

    private void setUpFormTheoGio() {
        if (arrayHourlyForecast == null) {
        } else {
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
    }

    private void setUpFormTheoNgay() {
        if (arrayDailyForecast == null) {
        } else {
            arrayFormTheoNgay = new ArrayList<>();

            for (int i = 0; i < 6; i += 3) {
                List<DailyForecast> subList = arrayDailyForecast.subList(i, Math.min(i + 4, 7));
                Form_TheoNgay formTheoNgay = new Form_TheoNgay(subList, new NavigationListener() {
                    @Override
                    public void onNext() {
                        nextFormTheoNgay();
                    }

                    @Override
                    public void onPrevious() {
                        previousFormTheoNgay();
                    }
                });
                arrayFormTheoNgay.add(formTheoNgay);
            }
        }
    }

    private int gioConLai() {
        return 24 - UnixConvertTime.toHour(arrayHourlyForecast.get(0).getHf_timestamp());
    }

    private void nextFormTheoGio() {
        if (currentHfIndex < arrayFormTheoGio.size() - 1) {
            currentHfIndex++;
            setForm(mainPanel, arrayFormTheoGio.get(currentHfIndex));
        }
    }

    private void previousFormTheoGio() {
        if (currentHfIndex > 0) {
            currentHfIndex--;
            setForm(mainPanel, arrayFormTheoGio.get(currentHfIndex));
        }
    }

    private void nextFormTheoNgay() {
        if (currentDfIndex < arrayFormTheoNgay.size() - 1) {
            currentDfIndex++;
            setForm(mainPanel, arrayFormTheoNgay.get(currentDfIndex));
        }
    }

    private void previousFormTheoNgay() {
        if (currentDfIndex > 0) {
            currentDfIndex--;
            setForm(mainPanel, arrayFormTheoNgay.get(currentDfIndex));
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
        myLocationPanel = new swing.PanelBorder();
        btnSetLocation = new swing.MyButton();
        jLabel2 = new javax.swing.JLabel();
        panelAlert = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        mainPanelAlert = new javax.swing.JPanel();
        searchBar = new component.SearchBar();

        setBackground(new java.awt.Color(153, 204, 255));
        setOpaque(false);

        panelWeatherDetail.setBackground(new java.awt.Color(153, 204, 255));
        panelWeatherDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnHienTai.setText("CURRENT");
        btnHienTai.setColorClick(new java.awt.Color(153, 204, 255));
        btnHienTai.setColorOver(new java.awt.Color(255, 255, 51));
        btnHienTai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHienTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienTaiActionPerformed(evt);
            }
        });

        btnTheoGio.setText("HOURLY");
        btnTheoGio.setColorClick(new java.awt.Color(153, 204, 255));
        btnTheoGio.setColorOver(new java.awt.Color(255, 255, 51));
        btnTheoGio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTheoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheoGioActionPerformed(evt);
            }
        });

        btnHangNgay.setText("DAILY");
        btnHangNgay.setColorClick(new java.awt.Color(153, 204, 255));
        btnHangNgay.setColorOver(new java.awt.Color(255, 255, 51));
        btnHangNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
                        .addComponent(btnHangNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        panelWeatherSummary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        myLocationPanel.setBackground(new java.awt.Color(153, 204, 255));
        myLocationPanel.setLayout(new java.awt.BorderLayout());

        btnSetLocation.setBackground(new java.awt.Color(153, 204, 255));
        btnSetLocation.setBorder(null);
        btnSetLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/myLocation.png"))); // NOI18N
        btnSetLocation.setColor(new java.awt.Color(153, 204, 255));
        btnSetLocation.setColorClick(new java.awt.Color(153, 204, 255));
        btnSetLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetLocationActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SET YOUR LOCATION");

        javax.swing.GroupLayout panelWeatherSummaryLayout = new javax.swing.GroupLayout(panelWeatherSummary);
        panelWeatherSummary.setLayout(panelWeatherSummaryLayout);
        panelWeatherSummaryLayout.setHorizontalGroup(
            panelWeatherSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myLocationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWeatherSummaryLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSetLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelWeatherSummaryLayout.setVerticalGroup(
            panelWeatherSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWeatherSummaryLayout.createSequentialGroup()
                .addGroup(panelWeatherSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSetLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addGroup(panelWeatherSummaryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addComponent(myLocationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelAlert.setBackground(new java.awt.Color(153, 204, 255));
        panelAlert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panelAlert.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ALERT HISTORY");

        mainPanelAlert.setBackground(new java.awt.Color(0, 0, 0));
        mainPanelAlert.setOpaque(false);
        mainPanelAlert.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelAlertLayout = new javax.swing.GroupLayout(panelAlert);
        panelAlert.setLayout(panelAlertLayout);
        panelAlertLayout.setHorizontalGroup(
            panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
            .addComponent(mainPanelAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelAlertLayout.setVerticalGroup(
            panelAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlertLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanelAlert, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelWeatherDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
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
                        .addComponent(panelWeatherSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panelAlert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHienTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienTaiActionPerformed
        btnHienTai.setColor(new Color(255, 255, 51));
        btnHangNgay.setColor(Color.WHITE);
        btnTheoGio.setColor(Color.WHITE);
        if (fHomNay != null)
            setForm(mainPanel, fHomNay);
    }//GEN-LAST:event_btnHienTaiActionPerformed

    private void btnTheoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheoGioActionPerformed
        btnTheoGio.setColor(new Color(255, 255, 51));
        btnHienTai.setColor(Color.WHITE);
        btnHangNgay.setColor(Color.WHITE);
        setUpFormTheoGio();
        if (arrayFormTheoGio == null) {
        } else {
            currentHfIndex = 0; // Reset chỉ số hiện tại
            setForm(mainPanel, arrayFormTheoGio.get(currentHfIndex));
        }
    }//GEN-LAST:event_btnTheoGioActionPerformed

    private void btnHangNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangNgayActionPerformed
        btnHangNgay.setColor(new Color(255, 255, 51));
        btnHienTai.setColor(Color.WHITE);
        btnTheoGio.setColor(Color.WHITE);
        setUpFormTheoNgay();
        if (arrayFormTheoNgay == null) {
        } else {
            currentDfIndex = 0; // Reset chỉ số hiện tại
            setForm(mainPanel, arrayFormTheoNgay.get(currentDfIndex));
        }
    }//GEN-LAST:event_btnHangNgayActionPerformed

    private void btnSetLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetLocationActionPerformed
        fSetLocation = new Form_SetLocation(user, Form_Weather.this);
    }//GEN-LAST:event_btnSetLocationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnHangNgay;
    private swing.MyButton btnHienTai;
    private swing.MyButton btnSetLocation;
    private swing.MyButton btnTheoGio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainPanelAlert;
    private swing.PanelBorder myLocationPanel;
    private swing.PanelBorder panelAlert;
    private swing.PanelBorder panelWeatherDetail;
    public swing.PanelBorder panelWeatherSummary;
    private component.SearchBar searchBar;
    // End of variables declaration//GEN-END:variables
}
