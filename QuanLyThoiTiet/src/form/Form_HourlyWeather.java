package form;

import models.HourlyForecast;
import service.ServiceConvertIcon;
import service.ServiceGetCurrentTime;
import service.UnixConvertTime;

public class Form_HourlyWeather extends javax.swing.JPanel {
    
    
    public Form_HourlyWeather(HourlyForecast hF) {
        initComponents();
        setVisible(true);
        setInfo(hF);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton1 = new swing.MyButton();
        icon = new javax.swing.JLabel();
        textTemp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFeelLike = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textGio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        textVisibility = new javax.swing.JLabel();
        textCloud5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textUV = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textWind = new javax.swing.JLabel();
        textCloud7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

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
        textTemp.setText("35,55");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("O");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("FeelLike");

        textFeelLike.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFeelLike.setForeground(new java.awt.Color(255, 255, 255));
        textFeelLike.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textFeelLike.setText("37,5");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("O");

        textGio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textGio.setForeground(new java.awt.Color(255, 255, 255));
        textGio.setText("15");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("H");

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
        jLabel10.setText("Visibility");

        textVisibility.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textVisibility.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility.setText("10");

        textCloud5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textCloud5.setForeground(new java.awt.Color(255, 255, 255));
        textCloud5.setText("km");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(textVisibility)
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
                            .addComponent(textWind))
                        .addGap(3, 3, 3)
                        .addComponent(textCloud7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textGio)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(textFeelLike)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textTemp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(165, 165, 165)))
                        .addComponent(jLabel4)
                        .addGap(46, 46, 46)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textGio)
                                    .addComponent(jLabel3)))
                            .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textFeelLike)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
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
                                    .addComponent(textVisibility)
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
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setInfo(HourlyForecast hF){
        Float temp= Math.round(hF.getTemperature() * 100.0f) / 100.0f;
        Float tempFeelLike = Math.round(hF.getFeels_like() * 100.0f) / 100.0f;
        textGio.setText(UnixConvertTime.toHour(hF.getHf_timestamp())+"");
        icon.setIcon(ServiceConvertIcon.toIcon(hF.getIcon()));
        textTemp.setText(temp+"");
        textFeelLike.setText(tempFeelLike+"");
        textPressure.setText(hF.getPressure()+"");
        textHumidity.setText(hF.getHumidity()+"");
        textCloud.setText(hF.getClouds()+"");
        textVisibility.setText(hF.getVisibility()+"");
        textWind.setText(hF.getWind_speed()+"");
        textUV.setText(hF.getUv()+"");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private swing.MyButton myButton1;
    private javax.swing.JLabel textCloud;
    private javax.swing.JLabel textCloud2;
    private javax.swing.JLabel textCloud3;
    private javax.swing.JLabel textCloud4;
    private javax.swing.JLabel textCloud5;
    private javax.swing.JLabel textCloud7;
    private javax.swing.JLabel textFeelLike;
    private javax.swing.JLabel textGio;
    private javax.swing.JLabel textHumidity;
    private javax.swing.JLabel textPressure;
    private javax.swing.JLabel textTemp;
    private javax.swing.JLabel textUV;
    private javax.swing.JLabel textVisibility;
    private javax.swing.JLabel textWind;
    // End of variables declaration//GEN-END:variables
}
