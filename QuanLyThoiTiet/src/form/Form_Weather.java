package form;

import dao.CityDAO;
import dao.CurrentWeatherDAO;
import event.EventClick;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.City;
import models.CurrentWeather;
import org.json.simple.JSONObject;
import service.WeatherAPI;

public class Form_Weather extends javax.swing.JPanel {

    private Form_WeatherSummary fWeatherSummary;
    private Form_HomNay fHomNay;

    public Form_Weather() {
        initComponents();
        setVisible(true);

        fWeatherSummary = new Form_WeatherSummary();
        fHomNay = new Form_HomNay();

        setForm(panelWeatherSummary, fWeatherSummary);
        setForm(mainPanel, new Form_HomNay());
        searchBar.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city_name = searchBar.txtSearch.getText();
                if (city_name.equals("")) {
                } else {
                    City city = CityDAO.getInstance().selectById(city_name);
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
                            fHomNay.setInfo(city.getCity_name(), currentWeather.getTemperature(), "Very Hot", currentWeather.getVisibility(), currentWeather.getWindSpeed(), currentWeather.getFeels_like(), currentWeather.getHumidity(), currentWeather.getClouds(), currentWeather.getUv());
                            setForm(mainPanel, fHomNay);
                        } else {
                            fHomNay.setInfo(city.getCity_name(), currentWeather.getTemperature(), "Very Hot", currentWeather.getVisibility(), currentWeather.getWindSpeed(), currentWeather.getFeels_like(), currentWeather.getHumidity(), currentWeather.getClouds(), currentWeather.getUv());
                            setForm(mainPanel, fHomNay);
                            CurrentWeatherDAO.getInstance().insert(currentWeather);
                        }
                    }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWeatherDetail = new swing.PanelBorder();
        btnHomNay = new swing.MyButton();
        myButton2 = new swing.MyButton();
        myButton3 = new swing.MyButton();
        mainPanel = new javax.swing.JPanel();
        panelWeatherSummary = new swing.PanelBorder();
        panelAlert = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchBar = new component.SearchBar();

        setOpaque(false);

        panelWeatherDetail.setBackground(new Color(0, 194, 255, 120));

        btnHomNay.setText("HÔM NAY");
        btnHomNay.setColorClick(new java.awt.Color(204, 255, 255));
        btnHomNay.setColorOver(new java.awt.Color(51, 204, 255));
        btnHomNay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomNayActionPerformed(evt);
            }
        });

        myButton2.setText("THEO GIỜ");
        myButton2.setColorClick(new java.awt.Color(204, 255, 255));
        myButton2.setColorOver(new java.awt.Color(51, 204, 255));

        myButton3.setText("HÀNG NGÀY");
        myButton3.setColorClick(new java.awt.Color(204, 255, 255));
        myButton3.setColorOver(new java.awt.Color(51, 204, 255));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout panelWeatherDetailLayout = new javax.swing.GroupLayout(panelWeatherDetail);
        panelWeatherDetail.setLayout(panelWeatherDetailLayout);
        panelWeatherDetailLayout.setHorizontalGroup(
            panelWeatherDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWeatherDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWeatherDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelWeatherDetailLayout.createSequentialGroup()
                        .addComponent(btnHomNay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelWeatherDetailLayout.setVerticalGroup(
            panelWeatherDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWeatherDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWeatherDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHomNay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelWeatherSummary.setBackground(new Color(0, 194, 255, 120));
        panelWeatherSummary.setLayout(new java.awt.BorderLayout());

        panelAlert.setBackground(new Color(0, 194, 255, 120));

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

    private void btnHomNayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomNayActionPerformed

        setForm(mainPanel, fHomNay);
    }//GEN-LAST:event_btnHomNayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnHomNay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel mainPanel;
    private swing.MyButton myButton2;
    private swing.MyButton myButton3;
    private swing.PanelBorder panelAlert;
    private swing.PanelBorder panelWeatherDetail;
    public swing.PanelBorder panelWeatherSummary;
    private component.SearchBar searchBar;
    // End of variables declaration//GEN-END:variables
}
