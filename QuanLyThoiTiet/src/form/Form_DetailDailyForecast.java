package form;

import dao.WeatherConditionDAO;
import java.awt.Color;
import models.DailyForecast;
import service.ServiceConvertIcon;
import service.UnixConvertDate;
import service.UnixConvertTime;

public class Form_DetailDailyForecast extends javax.swing.JFrame {

    DailyForecast dF;

    public Form_DetailDailyForecast(DailyForecast dF) {
        initComponents();
        this.dF = dF;
        Float tempDay = Math.round(dF.getTemperature_day() * 100.0f) / 100.0f;
        Float tempMax = Math.round(dF.getTemperature_max() * 100.0f) / 100.0f;
        Float tempMin = Math.round(dF.getTemperature_min() * 100.0f) / 100.0f;
        Float tempFeelLikeDay = Math.round(dF.getFeels_like_day() * 100.0f) / 100.0f;
        textDay.setText(UnixConvertDate.toDayofWeek(dF.getDf_date()) + "");
        textDate.setText(UnixConvertDate.toFullDate(dF.getDf_date()) + "");
        icon.setIcon(ServiceConvertIcon.toIcon(dF.getIcon()));
        textTemp.setText(tempDay + "");
        textTempMax.setText(tempMax + "");
        textTempMin.setText(tempMin + "");
        textFeelLike.setText(tempFeelLikeDay + "");
        textPressure.setText(dF.getPressure() + "");
        textHumidity.setText(dF.getHumidity() + "");
        textCloud.setText(dF.getClouds() + "");
        textPoP.setText(dF.getPop() + "");
        textWind.setText(dF.getWind_speed() + "");
        textUV.setText(dF.getUv() + "");
        textDescription.setText(WeatherConditionDAO.getDescription(dF.getWeather_condition_id()));

        moonset.setVisible(false);
        textMoonset.setVisible(false);
        btnMorning.setColor(new Color(255, 222, 51));
        btnEvening.setColor(Color.WHITE);
        btnNight.setColor(Color.WHITE);
        MEN.setText("Sunrise");
        String sunrise = UnixConvertDate.toFullDate(dF.getSunrise()) + " " + UnixConvertTime.toHourMinuteString(dF.getSunrise());
        textMEN.setText(sunrise);
        Float temp = Math.round(dF.getTemperature_morn() * 100.0f) / 100.0f;
        textTempMEN.setText(temp + "");
        textFeelLikeMEN.setText(Math.round(dF.getFeels_like_morn() * 100.0f) / 100.0f + "");
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        btnDay = new swing.MyButton();
        btnMorning = new swing.MyButton();
        btnEvening = new swing.MyButton();
        btnNight = new swing.MyButton();
        jLabel6 = new javax.swing.JLabel();
        textFeelLike = new javax.swing.JLabel();
        textHumidity = new javax.swing.JLabel();
        textCloud2 = new javax.swing.JLabel();
        textCloud3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textCloud = new javax.swing.JLabel();
        textCloud4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textPoP = new javax.swing.JLabel();
        textCloud5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textUV = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textWind = new javax.swing.JLabel();
        textCloud7 = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        textTemp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textDescription = new javax.swing.JLabel();
        textPressure = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textDay = new javax.swing.JLabel();
        textDate = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textTempMax = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textTempMin = new javax.swing.JLabel();
        btnClose = new swing.MyButton();
        jLabel3 = new javax.swing.JLabel();
        MEN = new javax.swing.JLabel();
        textTempMEN = new javax.swing.JLabel();
        textFeelLikeMEN = new javax.swing.JLabel();
        textMEN = new javax.swing.JLabel();
        moonset = new javax.swing.JLabel();
        textMoonset = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelBorder1.setBackground(new java.awt.Color(153, 204, 255));
        panelBorder1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        btnDay.setForeground(new java.awt.Color(0, 0, 0));
        btnDay.setText("Day");
        btnDay.setColor(new java.awt.Color(255, 222, 51));
        btnDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDayActionPerformed(evt);
            }
        });

        btnMorning.setForeground(new java.awt.Color(0, 0, 0));
        btnMorning.setText("Morning");
        btnMorning.setColor(new java.awt.Color(255, 222, 51));
        btnMorning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMorningActionPerformed(evt);
            }
        });

        btnEvening.setForeground(new java.awt.Color(0, 0, 0));
        btnEvening.setText("Evening");
        btnEvening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEveningActionPerformed(evt);
            }
        });

        btnNight.setForeground(new java.awt.Color(0, 0, 0));
        btnNight.setText("Night");
        btnNight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNightActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Humidity");

        textFeelLike.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFeelLike.setForeground(new java.awt.Color(255, 255, 255));
        textFeelLike.setText("33.33");

        textHumidity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textHumidity.setForeground(new java.awt.Color(255, 255, 255));
        textHumidity.setText("37,45");

        textCloud2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud2.setForeground(new java.awt.Color(255, 255, 255));
        textCloud2.setText("g/m³");

        textCloud3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud3.setForeground(new java.awt.Color(255, 255, 255));
        textCloud3.setText("hPA");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Clouds");

        textCloud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud.setForeground(new java.awt.Color(255, 255, 255));
        textCloud.setText("37,45");

        textCloud4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud4.setForeground(new java.awt.Color(255, 255, 255));
        textCloud4.setText("%");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PoP");

        textPoP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPoP.setForeground(new java.awt.Color(255, 255, 255));
        textPoP.setText("10");

        textCloud5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud5.setForeground(new java.awt.Color(255, 255, 255));
        textCloud5.setText("%");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("UV");

        textUV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textUV.setForeground(new java.awt.Color(255, 255, 255));
        textUV.setText("3");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Wind");

        textWind.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textWind.setForeground(new java.awt.Color(255, 255, 255));
        textWind.setText("2.27");

        textCloud7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud7.setForeground(new java.awt.Color(255, 255, 255));
        textCloud7.setText("m/s");

        icon.setBackground(new java.awt.Color(255, 255, 255));
        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/04n.png"))); // NOI18N

        textTemp.setBackground(new java.awt.Color(255, 255, 255));
        textTemp.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        textTemp.setForeground(new java.awt.Color(255, 255, 255));
        textTemp.setText("33,4");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("O");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pressure");

        textDescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textDescription.setForeground(new java.awt.Color(255, 255, 255));
        textDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textDescription.setText("Mưa to sấm chớp");

        textPressure.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPressure.setForeground(new java.awt.Color(255, 255, 255));
        textPressure.setText("1000");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("FeelLike");

        textDay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDay.setForeground(new java.awt.Color(255, 255, 255));
        textDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textDay.setText("Wednesday");

        textDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDate.setForeground(new java.awt.Color(255, 255, 255));
        textDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textDate.setText("31/05/2004");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Temperature");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Temperature max");

        textTempMax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTempMax.setForeground(new java.awt.Color(255, 255, 255));
        textTempMax.setText("37,45");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Temperature min");

        textTempMin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTempMin.setForeground(new java.awt.Color(255, 255, 255));
        textTempMin.setText("37,45");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/error.png"))); // NOI18N
        btnClose.setBorderColor(new java.awt.Color(255, 51, 51));
        btnClose.setColor(new java.awt.Color(255, 51, 51));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("FeelLike");

        MEN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MEN.setForeground(new java.awt.Color(255, 255, 255));
        MEN.setText("Sunrise");

        textTempMEN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTempMEN.setForeground(new java.awt.Color(255, 255, 255));
        textTempMEN.setText("37,45");

        textFeelLikeMEN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFeelLikeMEN.setForeground(new java.awt.Color(255, 255, 255));
        textFeelLikeMEN.setText("37,45");

        textMEN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textMEN.setForeground(new java.awt.Color(255, 255, 255));
        textMEN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textMEN.setText("31/05/2004");

        moonset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        moonset.setForeground(new java.awt.Color(255, 255, 255));
        moonset.setText("Moonset");

        textMoonset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textMoonset.setForeground(new java.awt.Color(255, 255, 255));
        textMoonset.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textMoonset.setText("31/05/2004");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textTemp)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)
                                .addGap(61, 61, 61)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(textFeelLike)))
                            .addComponent(textDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(78, 78, 78)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(textHumidity)
                                        .addGap(3, 3, 3)
                                        .addComponent(textCloud2))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(textPressure)
                                        .addGap(3, 3, 3)
                                        .addComponent(textCloud3)))
                                .addGap(31, 31, 31)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addGap(10, 10, 10)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textUV)
                                                    .addComponent(textWind))
                                                .addGap(3, 3, 3)
                                                .addComponent(textCloud7))
                                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addComponent(textPoP)
                                                .addGap(3, 3, 3)
                                                .addComponent(textCloud5))))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(10, 10, 10)
                                        .addComponent(textTempMin)))))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(textDay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(btnMorning, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEvening, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(btnNight, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(btnDay, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(moonset)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(10, 10, 10)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(textCloud)
                                        .addGap(3, 3, 3)
                                        .addComponent(textCloud4))
                                    .addComponent(textTempMax))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(MEN))
                        .addGap(49, 49, 49)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFeelLikeMEN)
                            .addComponent(textTempMEN)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textMoonset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textMEN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDay)
                    .addComponent(textDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel1))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(textFeelLike)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textPressure)
                            .addComponent(textCloud3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textHumidity)
                            .addComponent(textCloud2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textCloud)
                            .addComponent(textCloud4)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textPoP)
                                .addComponent(textCloud5)))
                        .addGap(12, 12, 12)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textWind)
                            .addComponent(textCloud7))
                        .addGap(12, 12, 12)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textUV))))
                .addGap(12, 12, 12)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textTempMax)
                    .addComponent(textTempMin)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEvening, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMorning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MEN)
                    .addComponent(textMEN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textTempMEN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFeelLikeMEN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moonset)
                    .addComponent(textMoonset))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDayActionPerformed

    }//GEN-LAST:event_btnDayActionPerformed

    private void btnMorningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMorningActionPerformed
        moonset.setVisible(false);
        textMoonset.setVisible(false);
        btnMorning.setColor(new Color(255, 222, 51));
        btnEvening.setColor(Color.WHITE);
        btnNight.setColor(Color.WHITE);
        MEN.setText("Sunrise");
        String sunrise = UnixConvertDate.toFullDate(dF.getSunrise()) + " " + UnixConvertTime.toHourMinuteString(dF.getSunrise());
        textMEN.setText(sunrise);
        Float temp = Math.round(dF.getTemperature_morn() * 100.0f) / 100.0f;
        textTempMEN.setText(temp + "");
        textFeelLikeMEN.setText(Math.round(dF.getFeels_like_morn() * 100.0f) / 100.0f + "");
    }//GEN-LAST:event_btnMorningActionPerformed

    private void btnEveningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEveningActionPerformed
        moonset.setVisible(false);
        textMoonset.setVisible(false);
        btnMorning.setColor(Color.WHITE);
        btnEvening.setColor(new Color(255, 222, 51));
        btnNight.setColor(Color.WHITE);
        MEN.setText("Sunset");
        String sunset = UnixConvertDate.toFullDate(dF.getSunset()) + " " + UnixConvertTime.toHourMinuteString(dF.getSunset());
        textMEN.setText(sunset);
        Float temp = Math.round(dF.getTemperature_eve() * 100.0f) / 100.0f;
        textTempMEN.setText(temp + "");
        textFeelLikeMEN.setText(Math.round(dF.getFeels_like_eve() * 100.0f) / 100.0f + "");
    }//GEN-LAST:event_btnEveningActionPerformed

    private void btnNightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNightActionPerformed
        String moonset = "";
        if (dF.getMoonset() == 0) {
            moonset = "Moonset in tomorrow";
        } else {
            moonset = UnixConvertDate.toFullDate(dF.getMoonset()) + " " + UnixConvertTime.toHourMinuteString(dF.getMoonset());
        }
        textMoonset.setText(moonset);
        this.moonset.setVisible(true);
        textMoonset.setVisible(true);
        btnMorning.setColor(Color.WHITE);
        btnEvening.setColor(Color.WHITE);
        btnNight.setColor(new Color(255, 222, 51));
        MEN.setText("Moonrise");
        String moonrise = UnixConvertDate.toFullDate(dF.getMoonrise()) + " " + UnixConvertTime.toHourMinuteString(dF.getMoonrise());
        textMEN.setText(moonrise);
        Float temp = Math.round(dF.getTemperature_night() * 100.0f) / 100.0f;
        textTempMEN.setText(temp + "");
        textFeelLikeMEN.setText(Math.round(dF.getFeels_like_night() * 100.0f) / 100.0f + "");
    }//GEN-LAST:event_btnNightActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MEN;
    private swing.MyButton btnClose;
    private swing.MyButton btnDay;
    private swing.MyButton btnEvening;
    private swing.MyButton btnMorning;
    private swing.MyButton btnNight;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel moonset;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JLabel textCloud;
    private javax.swing.JLabel textCloud2;
    private javax.swing.JLabel textCloud3;
    private javax.swing.JLabel textCloud4;
    private javax.swing.JLabel textCloud5;
    private javax.swing.JLabel textCloud7;
    private javax.swing.JLabel textDate;
    private javax.swing.JLabel textDay;
    private javax.swing.JLabel textDescription;
    private javax.swing.JLabel textFeelLike;
    private javax.swing.JLabel textFeelLikeMEN;
    private javax.swing.JLabel textHumidity;
    private javax.swing.JLabel textMEN;
    private javax.swing.JLabel textMoonset;
    private javax.swing.JLabel textPoP;
    private javax.swing.JLabel textPressure;
    private javax.swing.JLabel textTemp;
    private javax.swing.JLabel textTempMEN;
    private javax.swing.JLabel textTempMax;
    private javax.swing.JLabel textTempMin;
    private javax.swing.JLabel textUV;
    private javax.swing.JLabel textWind;
    // End of variables declaration//GEN-END:variables
}
