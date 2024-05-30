package form;

import java.util.List;
import models.HourlyForecast;

public class Form_TheoGio extends javax.swing.JPanel {

    private Form_HourlyWeather fHourlyWeather;
    List<HourlyForecast> hourlyForecasts;
    public Form_TheoGio() {
        initComponents();
//        fHourlyWeather = new Form_HourlyWeather();
//        gridLayoutPanel.add(fHourlyWeather);
//        gridLayoutPanel.add(fHourlyWeather);
//        gridLayoutPanel.add(fHourlyWeather);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLeft = new swing.MyButton();
        btnRight = new swing.MyButton();
        gridLayoutPanel = new javax.swing.JPanel();
        form_HourlyWeather1 = new form.Form_HourlyWeather();
        form_HourlyWeather2 = new form.Form_HourlyWeather();
        form_HourlyWeather3 = new form.Form_HourlyWeather();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        btnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrowLeft.png"))); // NOI18N
        btnLeft.setColorClick(new java.awt.Color(204, 255, 255));
        btnLeft.setColorOver(new java.awt.Color(0, 204, 255));
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrowRight.png"))); // NOI18N
        btnRight.setColorClick(new java.awt.Color(204, 255, 255));
        btnRight.setColorOver(new java.awt.Color(0, 204, 255));
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        gridLayoutPanel.setOpaque(false);
        gridLayoutPanel.setLayout(new java.awt.GridLayout(3, 1, 10, 10));
        gridLayoutPanel.add(form_HourlyWeather1);
        gridLayoutPanel.add(form_HourlyWeather2);
        gridLayoutPanel.add(form_HourlyWeather3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridLayoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(216, 216, 216))
            .addComponent(gridLayoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRightActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLeftActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnLeft;
    private swing.MyButton btnRight;
    private form.Form_HourlyWeather form_HourlyWeather1;
    private form.Form_HourlyWeather form_HourlyWeather2;
    private form.Form_HourlyWeather form_HourlyWeather3;
    private javax.swing.JPanel gridLayoutPanel;
    // End of variables declaration//GEN-END:variables
}
