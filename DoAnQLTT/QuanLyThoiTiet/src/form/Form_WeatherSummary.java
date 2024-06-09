package form;

import dao.CityDAO;
import dao.WeatherConditionDAO;
import models.City;
import models.CurrentWeather;
import models.NguoiDung;
import service.ServiceGetCurrentTime;

public class Form_WeatherSummary extends javax.swing.JPanel {

    public Form_WeatherSummary(CurrentWeather cw_user, City city_user) {
        initComponents();
        setVisible(true);
        setInfo(cw_user, city_user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        textCity = new javax.swing.JLabel();
        textDate = new javax.swing.JLabel();
        textTemp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textDescription = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textVisibility = new javax.swing.JLabel();
        textWind = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textFeelLike = new javax.swing.JLabel();
        jlHumidity = new javax.swing.JLabel();
        textHumidity = new javax.swing.JLabel();
        jlCloud = new javax.swing.JLabel();
        textClound = new javax.swing.JLabel();
        textHumidity1 = new javax.swing.JLabel();
        textUV = new javax.swing.JLabel();
        textVisibility1 = new javax.swing.JLabel();
        textVisibility3 = new javax.swing.JLabel();
        textVisibility4 = new javax.swing.JLabel();
        textVisibility5 = new javax.swing.JLabel();
        textVisibility6 = new javax.swing.JLabel();
        textVisibility7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setOpaque(false);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/01d.png"))); // NOI18N

        textCity.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        textCity.setForeground(new java.awt.Color(255, 255, 255));
        textCity.setText("Ho Chi Minh City");

        textDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDate.setForeground(new java.awt.Color(255, 255, 255));
        textDate.setText("Monday 05/13/2024");

        textTemp.setFont(new java.awt.Font("Segoe UI", 1, 52)); // NOI18N
        textTemp.setForeground(new java.awt.Color(255, 255, 255));
        textTemp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTemp.setText("34,45");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/C.png"))); // NOI18N

        textDescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textDescription.setForeground(new java.awt.Color(255, 255, 255));
        textDescription.setText("Really hot");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/visibility.png"))); // NOI18N
        jLabel5.setText("Visibility");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/wind.png"))); // NOI18N
        jLabel6.setText("Wind");

        textVisibility.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVisibility.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility.setText("10");

        textWind.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textWind.setForeground(new java.awt.Color(255, 255, 255));
        textWind.setText("1,25");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/feellike.png"))); // NOI18N
        jLabel11.setText("Feel Like");

        textFeelLike.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFeelLike.setForeground(new java.awt.Color(255, 255, 255));
        textFeelLike.setText("10,25");

        jlHumidity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlHumidity.setForeground(new java.awt.Color(255, 255, 255));
        jlHumidity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/humidity.png"))); // NOI18N
        jlHumidity.setText("Humidity");

        textHumidity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHumidity.setForeground(new java.awt.Color(255, 255, 255));
        textHumidity.setText("10");

        jlCloud.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlCloud.setForeground(new java.awt.Color(255, 255, 255));
        jlCloud.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlCloud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cloud.png"))); // NOI18N
        jlCloud.setText("Cloud");

        textClound.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textClound.setForeground(new java.awt.Color(255, 255, 255));
        textClound.setText("19,25");

        textHumidity1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHumidity1.setForeground(new java.awt.Color(255, 255, 255));
        textHumidity1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/uv.png"))); // NOI18N
        textHumidity1.setText("UV");

        textUV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUV.setForeground(new java.awt.Color(255, 255, 255));
        textUV.setText("10,25");

        textVisibility1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVisibility1.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility1.setText("km");

        textVisibility3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVisibility3.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility3.setText("m/s");

        textVisibility4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVisibility4.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility4.setText("%");

        textVisibility5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVisibility5.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility5.setText("oC");

        textVisibility6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVisibility6.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility6.setText("g/m³");

        textVisibility7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVisibility7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlCloud)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textClound))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textWind)
                                        .addGap(8, 8, 8)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textVisibility4)
                                        .addGap(16, 16, 16))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(textVisibility3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(textUV, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jlHumidity)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textVisibility)
                                .addGap(18, 18, 18)
                                .addComponent(textVisibility1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textVisibility7)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textFeelLike, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textVisibility5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textHumidity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textVisibility6)))
                                .addContainerGap(12, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textHumidity1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDescription)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)))
                                .addGap(20, 20, 20)))
                        .addGap(59, 59, 59))))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDate)
                    .addComponent(textCity))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textCity)
                        .addGap(0, 0, 0)
                        .addComponent(textDate))
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTemp)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDescription)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textFeelLike)
                    .addComponent(textVisibility5)
                    .addComponent(textHumidity1)
                    .addComponent(textUV))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textWind)
                    .addComponent(jlHumidity)
                    .addComponent(textHumidity)
                    .addComponent(textVisibility3)
                    .addComponent(textVisibility6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCloud)
                    .addComponent(textClound)
                    .addComponent(textVisibility4)
                    .addComponent(textVisibility7)
                    .addComponent(textVisibility)
                    .addComponent(jLabel5)
                    .addComponent(textVisibility1))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setInfo(CurrentWeather cw_user, City city_user){
        Float temperature = Math.round(cw_user.getTemperature() * 100.0f) / 100.0f;
        Float tempFeelLike = Math.round(cw_user.getFeels_like() * 100.0f) / 100.0f;
        String description = WeatherConditionDAO.getDescription(cw_user.getWeatherCondition());
        textCity.setText(city_user.getCity_name());
        textTemp.setText(temperature+"");
        textDescription.setText(description);
        textVisibility.setText(cw_user.getVisibility()+"");
        textWind.setText(cw_user.getWindSpeed()+"");
        textFeelLike.setText(tempFeelLike+"");
        textHumidity.setText(cw_user.getHumidity()+"");
        textClound.setText(cw_user.getClouds()+"");
        textUV.setText(cw_user.getUv()+"");
        textDate.setText(ServiceGetCurrentTime.getDate());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jlCloud;
    private javax.swing.JLabel jlHumidity;
    private javax.swing.JLabel textCity;
    private javax.swing.JLabel textClound;
    private javax.swing.JLabel textDate;
    private javax.swing.JLabel textDescription;
    private javax.swing.JLabel textFeelLike;
    private javax.swing.JLabel textHumidity;
    private javax.swing.JLabel textHumidity1;
    private javax.swing.JLabel textTemp;
    private javax.swing.JLabel textUV;
    private javax.swing.JLabel textVisibility;
    private javax.swing.JLabel textVisibility1;
    private javax.swing.JLabel textVisibility3;
    private javax.swing.JLabel textVisibility4;
    private javax.swing.JLabel textVisibility5;
    private javax.swing.JLabel textVisibility6;
    private javax.swing.JLabel textVisibility7;
    private javax.swing.JLabel textWind;
    // End of variables declaration//GEN-END:variables
}
