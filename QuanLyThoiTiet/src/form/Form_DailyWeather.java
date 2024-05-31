package form;

import dao.WeatherConditionDAO;
import models.DailyForecast;
import service.ServiceConvertIcon;
import service.ServiceGetCurrentTime;
import service.UnixConvertDate;
import service.UnixConvertTime;

public class Form_DailyWeather extends javax.swing.JPanel {
    
    
    public Form_DailyWeather(DailyForecast dF) {
        initComponents();
        setVisible(true);
        setInfo(dF);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton1 = new swing.MyButton();
        icon = new javax.swing.JLabel();
        textTemp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textPressure = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textHumidity = new javax.swing.JLabel();
        textCloud2 = new javax.swing.JLabel();
        textCloud3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        textDay = new javax.swing.JLabel();
        textDate = new javax.swing.JLabel();
        textDescription = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFeelLike = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setEnabled(false);
        setOpaque(false);

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detailWeather_1.png"))); // NOI18N
        myButton1.setColorClick(new java.awt.Color(204, 255, 255));
        myButton1.setColorOver(new java.awt.Color(0, 204, 255));

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

        textPressure.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPressure.setForeground(new java.awt.Color(255, 255, 255));
        textPressure.setText("1000");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Humidity");

        textHumidity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textHumidity.setForeground(new java.awt.Color(255, 255, 255));
        textHumidity.setText("37,45");

        textCloud2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud2.setForeground(new java.awt.Color(255, 255, 255));
        textCloud2.setText("g/m³");

        textCloud3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud3.setForeground(new java.awt.Color(255, 255, 255));
        textCloud3.setText("hPA");

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

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

        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel1.setOpaque(false);

        textDay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDay.setForeground(new java.awt.Color(255, 255, 255));
        textDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textDay.setText("Wednesday");

        textDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDate.setForeground(new java.awt.Color(255, 255, 255));
        textDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textDate.setText("31/05/2004");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDay)
                    .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(textDay)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textDate))
        );

        textDescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textDescription.setForeground(new java.awt.Color(255, 255, 255));
        textDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textDescription.setText("Mưa to sấm chớp");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("FeelLike");

        textFeelLike.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFeelLike.setForeground(new java.awt.Color(255, 255, 255));
        textFeelLike.setText("33.33");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTemp)
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(textFeelLike)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(textPressure)
                                .addGap(3, 3, 3)
                                .addComponent(textCloud3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textHumidity)
                                .addGap(3, 3, 3)
                                .addComponent(textCloud2)))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textCloud)
                                .addGap(3, 3, 3)
                                .addComponent(textCloud4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textPoP)
                                .addGap(3, 3, 3)
                                .addComponent(textCloud5)))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textUV)
                            .addComponent(textWind))))
                .addGap(3, 3, 3)
                .addComponent(textCloud7)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(textDescription))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(textFeelLike)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textPressure)
                                            .addComponent(textCloud3)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(textHumidity)
                                        .addComponent(textCloud2)))
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(textCloud)
                                    .addComponent(textCloud4))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(textPoP)
                                    .addComponent(textCloud5))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(textWind)
                                .addComponent(textCloud7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(textUV))))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setInfo(DailyForecast dF){
        Float tempDay = Math.round(dF.getTemperature_day() * 100.0f) / 100.0f;
        Float tempFeelLikeDay = Math.round(dF.getFeels_like_day() * 100.0f) / 100.0f;
        textDay.setText(UnixConvertDate.toDayofWeek(dF.getDf_date())+"");
        textDate.setText(UnixConvertDate.toFullDate(dF.getDf_date())+"");
        icon.setIcon(ServiceConvertIcon.toIcon(dF.getIcon()));
        textTemp.setText(tempDay+"");
        textFeelLike.setText(tempFeelLikeDay+"");
        textPressure.setText(dF.getPressure()+"");
        textHumidity.setText(dF.getHumidity()+"");
        textCloud.setText(dF.getClouds()+"");
        textPoP.setText(dF.getPop()+"");
        textWind.setText(dF.getWind_speed()+"");
        textUV.setText(dF.getUv()+"");
        textDescription.setText(WeatherConditionDAO.getDescription(dF.getWeather_condition_id()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private swing.MyButton myButton1;
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
    private javax.swing.JLabel textHumidity;
    private javax.swing.JLabel textPoP;
    private javax.swing.JLabel textPressure;
    private javax.swing.JLabel textTemp;
    private javax.swing.JLabel textUV;
    private javax.swing.JLabel textWind;
    // End of variables declaration//GEN-END:variables
}
