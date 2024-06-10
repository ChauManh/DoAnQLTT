package form;

import dao.CityDAO;
import dao.UserAlertDAO;
import dao.UserAlertTypeDAO;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TableActionEvent;
import models.NguoiDung;
import models.UserAlert;
import swing.ScrollBar;
import swing.TableActionCellEditor;
import swing.TableActionCellRender;

public class Form_Alert extends javax.swing.JPanel {

    private Form_AddAlert fAddAlert;
    private NguoiDung user;
    private Form_Weather fWeather;
    private Form_UpdateAlert fUpdateAlert;
    
    public Form_Alert(NguoiDung user, Form_Weather fWeather) {
        initComponents();
        this.user = user;
        this.fWeather = fWeather;
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                UserAlert ua = UserAlertDAO.getInstance().selectAllById(user).get(row);
                fUpdateAlert = new Form_UpdateAlert(user, Form_Alert.this, fWeather, ua);
            }

            @Override
            public void onDelete(int row) {
                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure want to delete this row?",
                        "Warning!!!",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (response == JOptionPane.OK_OPTION) {
                    UserAlert ua = UserAlertDAO.getInstance().selectAllById(user).get(row);
                    if (table.isEditing()) {
                        table.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);
                    UserAlertDAO.getInstance().delete(ua);
                }
            }

            @Override
            public void onSetActive(int row) {
                System.out.println("Set active???");
            }
        };
        
        table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        setUpTable();

    }

    public void setUpTable() {
        String alert_description;
        String location_name;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (UserAlert u : UserAlertDAO.getInstance().selectAllById(user)) {
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
                "Alert Type", "Location", "Comparison", "Value", "Alert Content", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(btnAddAlert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnAddAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAlertActionPerformed
        fAddAlert = new Form_AddAlert(user, Form_Alert.this, fWeather);
    }//GEN-LAST:event_btnAddAlertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnAddAlert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane spTable;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables
}
