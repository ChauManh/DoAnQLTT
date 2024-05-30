package form;

import service.ServiceGetCurrentTime;

public class Form_HomNay extends javax.swing.JPanel {

    public Form_HomNay() {
        initComponents();
        setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textTime = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textPressure = new javax.swing.JLabel();
        textVisibility8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setOpaque(false);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/01d.png"))); // NOI18N

        textCity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textCity.setForeground(new java.awt.Color(255, 255, 255));
        textCity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textCity.setText("Ho Chi Minh City");

        textDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDate.setForeground(new java.awt.Color(255, 255, 255));
        textDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textDate.setText("Monday 05/13/2024");

        textTemp.setFont(new java.awt.Font("Segoe UI", 1, 52)); // NOI18N
        textTemp.setForeground(new java.awt.Color(255, 255, 255));
        textTemp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textTemp.setText("34,45");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/C.png"))); // NOI18N

        textDescription.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textDescription.setForeground(new java.awt.Color(255, 255, 255));
        textDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textDescription.setText("Really hot");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/visibility.png"))); // NOI18N
        jLabel5.setText("Visibility");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/wind.png"))); // NOI18N
        jLabel6.setText("Wind");

        textVisibility.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textVisibility.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility.setText("10");

        textWind.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textWind.setForeground(new java.awt.Color(255, 255, 255));
        textWind.setText("1,25");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/feellike.png"))); // NOI18N
        jLabel11.setText("Feel Like");

        textFeelLike.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFeelLike.setForeground(new java.awt.Color(255, 255, 255));
        textFeelLike.setText("10,25");

        jlHumidity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlHumidity.setForeground(new java.awt.Color(255, 255, 255));
        jlHumidity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/humidity.png"))); // NOI18N
        jlHumidity.setText("Humidity");

        textHumidity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textHumidity.setForeground(new java.awt.Color(255, 255, 255));
        textHumidity.setText("10");

        jlCloud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlCloud.setForeground(new java.awt.Color(255, 255, 255));
        jlCloud.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlCloud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cloud.png"))); // NOI18N
        jlCloud.setText("Cloud");

        textClound.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textClound.setForeground(new java.awt.Color(255, 255, 255));
        textClound.setText("19,25");

        textHumidity1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textHumidity1.setForeground(new java.awt.Color(255, 255, 255));
        textHumidity1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/uv.png"))); // NOI18N
        textHumidity1.setText("UV");

        textUV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textUV.setForeground(new java.awt.Color(255, 255, 255));
        textUV.setText("10,25");

        textVisibility1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        textVisibility1.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility1.setText("km");

        textVisibility3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        textVisibility3.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility3.setText("m/s");

        textVisibility4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        textVisibility4.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility4.setText("%");

        textVisibility5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        textVisibility5.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility5.setText("°C ");

        textVisibility6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        textVisibility6.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility6.setText("g/m³");

        textVisibility7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVisibility7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Current Weather");

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        textTime.setBackground(new java.awt.Color(255, 255, 255));
        textTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textTime.setForeground(new java.awt.Color(255, 255, 255));
        textTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textTime.setText("5:41");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pressure.png"))); // NOI18N
        jLabel12.setText("Pressure");

        textPressure.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPressure.setForeground(new java.awt.Color(255, 255, 255));
        textPressure.setText("10,25");

        textVisibility8.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        textVisibility8.setForeground(new java.awt.Color(255, 255, 255));
        textVisibility8.setText("hPa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(textVisibility7)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textTime)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDescription)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDate)
                                    .addComponent(textCity)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(textFeelLike, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textVisibility5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(textPressure, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlHumidity)
                                            .addComponent(jlCloud))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textClound)
                                            .addComponent(textHumidity)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(textHumidity1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textUV)
                                            .addComponent(textVisibility)
                                            .addComponent(textWind))))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textVisibility3)
                                    .addComponent(textVisibility6)
                                    .addComponent(textVisibility8)
                                    .addComponent(textVisibility4)
                                    .addComponent(textVisibility1))))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCity)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDate)
                            .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textTemp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDescription)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textFeelLike)
                    .addComponent(textVisibility5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textPressure)
                    .addComponent(textVisibility8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHumidity)
                    .addComponent(textHumidity)
                    .addComponent(textVisibility6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCloud)
                            .addComponent(textClound)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(textVisibility4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textVisibility)
                    .addComponent(textVisibility1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textWind)
                    .addComponent(textVisibility3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHumidity1)
                    .addComponent(textUV))
                .addGap(23, 23, 23)
                .addComponent(textVisibility7)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setInfo(String city, float temp, String description ,int visibility, float wind, float feelLike, int Humidity, int Clound, float UV){
        Float temperature = Math.round(temp * 100.0f) / 100.0f;
        Float tempFeelLike = Math.round(feelLike * 100.0f) / 100.0f;
        textCity.setText(city);
        textTemp.setText(temperature+"");
        textDescription.setText(description);
        textVisibility.setText(visibility+"");
        textWind.setText(wind+"");
        textFeelLike.setText(tempFeelLike+"");
        textHumidity.setText(Humidity+"");
        textClound.setText(Clound+"");
        textUV.setText(UV+"");
        textDate.setText(ServiceGetCurrentTime.getDate());
        textTime.setText(ServiceGetCurrentTime.getTime());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel textPressure;
    private javax.swing.JLabel textTemp;
    private javax.swing.JLabel textTime;
    private javax.swing.JLabel textUV;
    private javax.swing.JLabel textVisibility;
    private javax.swing.JLabel textVisibility1;
    private javax.swing.JLabel textVisibility3;
    private javax.swing.JLabel textVisibility4;
    private javax.swing.JLabel textVisibility5;
    private javax.swing.JLabel textVisibility6;
    private javax.swing.JLabel textVisibility7;
    private javax.swing.JLabel textVisibility8;
    private javax.swing.JLabel textWind;
    // End of variables declaration//GEN-END:variables
}
