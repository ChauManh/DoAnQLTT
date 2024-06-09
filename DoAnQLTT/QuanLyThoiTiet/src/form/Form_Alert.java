package form;

import dao.CityDAO;
import dao.UserAlertDAO;
import dao.UserAlertTypeDAO;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import models.NguoiDung;
import models.UserAlert;
import swing.ScrollBar;

public class Form_Alert extends javax.swing.JPanel {

    private Form_AddAlert fAddAlert;
    private NguoiDung user;
   
    public Form_Alert(NguoiDung user) {
        initComponents();
        this.user = user;
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        setUpTable();
    }

    public void setUpTable() {
        String alert_description;
        String location_name;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (UserAlert u : UserAlertDAO.getInstance().selectAll()) {
            alert_description = UserAlertTypeDAO.getInstance().selectByIdR(u.getUserAlertId());
            location_name = CityDAO.getInstance().selectByIdR(u.getCityId()).getCity_name();
            model.addRow(new Object[]{
                alert_description,
                location_name,
                u.getConditionType(),
                u.getAlertValue(),
                u.getComment()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spTable = new javax.swing.JScrollPane();
        table = new swing.Table();
        jLabel1 = new javax.swing.JLabel();
        btnAddAlert = new swing.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alert Type", "Location", "Comparison", "Value", "Alert Content"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("SETTING ALERT BY YOURSELF");

        btnAddAlert.setText("Add Alert");
        btnAddAlert.setColorClick(new java.awt.Color(153, 204, 255));
        btnAddAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAlertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btnAddAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAlertActionPerformed
        fAddAlert = new Form_AddAlert(user, Form_Alert.this);
    }//GEN-LAST:event_btnAddAlertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnAddAlert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane spTable;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables
}
