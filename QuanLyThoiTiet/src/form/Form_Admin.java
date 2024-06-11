package form;

import dao.CityDAO;
import dao.NguoiDungDAO;
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

public class Form_Admin extends javax.swing.JPanel {

    private NguoiDung user;

    public Form_Admin() {
        initComponents();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                JOptionPane.showMessageDialog(
                        null,
                        "Nothing new!",
                        "ALERT",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            @Override
            public void onDelete(int row) {
                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure want to delete this user?",
                        "Warning!!!",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (response == JOptionPane.OK_OPTION) {
                    NguoiDung user = NguoiDungDAO.getInstance().selectAll().get(row);
                    if (user.getUsername().equals("admin")) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Cannot delete the admin account!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        if (table.isEditing()) {
                            table.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(row);
                        NguoiDungDAO.getInstance().delete(user);
                    }
                }
            }

            @Override
            public void onSetActive(int row) {
                JOptionPane.showMessageDialog(
                        null,
                        "CANNOT SET ACTIVE FOR USER!",
                        "ALERT",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        };

        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        setUpTable();

    }

    public void setUpTable() {
        String location_name;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (NguoiDung user : NguoiDungDAO.getInstance().selectAll()) {
            if (user.getCurrent_city_fk() == 0) {
                location_name = "";
            } else {
                location_name = CityDAO.getInstance().selectByIdR(user.getCurrent_city_fk()).getCity_name();
            }
            model.addRow(new Object[]{
                user.getUsername(),
                user.getEmail(),
                location_name,
                user.getNd_language(),
                user.getMeasurement_type(),
                user.getStatus()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spTable = new javax.swing.JScrollPane();
        table = new swing.Table();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Email", "Current City", "Language", "Measurement Type", "Status", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Application by MLL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(358, 358, 358))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane spTable;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables
}
