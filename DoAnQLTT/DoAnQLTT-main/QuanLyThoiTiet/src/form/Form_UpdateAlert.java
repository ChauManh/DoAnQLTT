package form;

import dao.CityDAO;
import dao.NguoiDungDAO;
import dao.UserAlertDAO;
import dao.UserAlertTypeDAO;
import javax.swing.JOptionPane;
import models.City;
import models.NguoiDung;
import models.UserAlert;

public class Form_UpdateAlert extends javax.swing.JFrame {

    private Form_Alert fAlert;
    private final NguoiDung user;
    private UserAlert alert;
    private Form_Weather fWeather;
    
    public Form_UpdateAlert(NguoiDung user, Form_Alert fAlert, Form_Weather fWeather, UserAlert alert) {
        initComponents();
        this.fAlert = fAlert;
        this.user = user;
        this.fWeather = fWeather;
        this.alert = alert;
        setUpForm(alert);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        btnFinish = new swing.MyButton();
        btnCancel = new swing.MyButton();
        jLabel1 = new javax.swing.JLabel();
        comboBoxType = new swing.ComboBoxSuggestion();
        comboBoxComparison = new swing.ComboBoxSuggestion();
        comboBoxLocation = new swing.ComboBoxSuggestion();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textValue = new javax.swing.JTextField();
        textAlertContent = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelBorder1.setBackground(new java.awt.Color(153, 204, 255));
        panelBorder1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        panelBorder1.setOpaque(true);

        btnFinish.setText("Finish");
        btnFinish.setColor(new java.awt.Color(51, 255, 0));
        btnFinish.setColorClick(new java.awt.Color(255, 255, 0));
        btnFinish.setColorOver(new java.awt.Color(204, 255, 204));
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setColor(new java.awt.Color(255, 0, 51));
        btnCancel.setColorClick(new java.awt.Color(255, 255, 0));
        btnCancel.setColorOver(new java.awt.Color(255, 204, 204));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Setting Alert by your way");

        comboBoxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Air quality index", "Clouds", "Feels like", "Humidity", "Temperature", "UV\t", "Visibility" }));

        comboBoxComparison.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ">", "<", "=" }));

        comboBoxLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A Yun Pa", "An Chau", "An Khe", "An Nhon", "An Phu", "An Thanh B", "Ap Binh Thanh", "Ap Da Loi", "Ap Khanh Hoa", "Ap Khanh Hung", "Ap Phu Hai", "Ap Phu My", "Ap Tan Ngai", "Ba Chuc", "Ba Don", "Ba Ria", "Bac Giang", "Bac Kan", "Bac Lieu", "Bac Ninh", "Bai Chay", "Bao Loc", "Ben Tre", "Bien Hoa", "Bim Son", "Binh Hoa", "Binh Hoa", "Binh Long", "Binh Minh", "Bo", "Buon Ho", "Buon Ma Thuot", "Buon Trap", "Buu Long", "Ca Mau", "Cai Lay", "Cam Pha", "Cam Ranh", "Cam Ranh", "Can Tho", "Cao Bang", "Cao Lanh", "Chau Doc", "Chi Linh", "Cho Lach", "Cho Moi", "Cho Phuoc Hai", "Chon Thanh", "Con Dao", "Cua Lo", "Da Lat", "Da Nang", "Di An", "Di Linh", "Dien Bien Phu", "Dong Ha", "Dong Hoa", "Dong Hoi", "Dong Xoai", "Duc Pho", "Duyen Hai", "Gia Nghia", "Gia Rai", "Go Cong", "Ha Giang", "Ha Long", "Ha Tien", "Ha Tinh", "Hai Duong", "Hai Phong", "Hang Tram", "Ha Noi", "Hiep Hoa", "Ho Chi Minh City", "Ho Nai", "Hoa Binh", "Hoa Thanh", "Hoa Thuong", "Hoi An", "Hong Ngu", "Hue", "Hung Yen", "Huong Canh", "Huong Thuy", "Huong Tra", "Khe Sanh", "Kien Giang", "Kien Luong", "Kinh Mon", "Kon Tum", "Ky Anh", "La Gi", "Lai Chau", "Lang Son", "Lao Cai", "Long Binh", "Long Khanh", "Long My", "Long Thanh", "Long Xuyen", "Luan Chau", "Mang La", "Mong Cai", "Mong Duong", "Muong Lay", "Muong Theng", "My Hoa", "My Luong", "My Tho", "Nam Dinh", "Nga Bay", "Nghi Son", "Nghia Lo", "Ngoc Son", "Nha Trang", "Nhan Trach", "Ninh Binh", "Ninh Hoa", "Phan Rang-Thap Cham", "Phan Ri Cua", "Phan Thiet", "Phu Ly", "Phu My", "Phu Quoc", "Phu Tho", "Phu Tu Son", "Phu Yen", "Phuc Yen", "Phuoc Long", "Pleiku", "Quang Ha", "Quang Ngai", "Quang Tri", "Quang Yen", "Quy Nhon", "Rach Gia", "Sa Dec", "Sa Pa", "Sam Son", "Soc Trang", "Son La", "Son Tay", "Song Cau", "Song Doc", "Tam Diep", "Tam Hiep", "Tam Ky", "Tan An", "Tan An", "Tan Chau", "Tan Phong", "Tan Phu", "Tan Phuoc Khanh", "Tan Son", "Tan Uyen", "Tan Van", "Tay Ninh", "Thai Binh", "Thai Nguyen", "Thanh Hoa", "Thanh Pho Uong Bi", "Thanh Phu", "Thanh Xuan", "Thi Tran Dong Dang", "Thi Tran Mau A", "Thi Tran Ngai Giao", "Thu Dau Mot", "Thu Duc", "Thuan An", "Thuan Tien", "Tra Vinh", "Trang Bang", "Tuy Hoa", "Tuyen Quang", "Vi Thanh", "Viet Tri", "Vinh", "Vinh Chau", "Vinh Long", "Vinh Yen", "Vung Tau", "Xuan Trung", "Yen Bai" }));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alert type");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Location");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Comparison");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Value");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alert Content");

        textValue.setText("0");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textValue, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBoxComparison, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboBoxLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textAlertContent)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(111, 111, 111))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxComparison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAlertContent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setUpForm(UserAlert alert) {
        textValue.setText(alert.getAlertValue()+"");
        textAlertContent.setText(alert.getComment());
    }
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        int response = JOptionPane.showConfirmDialog(
                null,
                "Are you sure to change this Alert?",
                "Notification",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (response == JOptionPane.OK_OPTION) {           
            alert.setNdId(user.getUserID());
            String alert_Description = (String) comboBoxType.getSelectedItem();
            alert.setAlertTypeId(UserAlertTypeDAO.getInstance().selectById(alert_Description).getAlert_type_id());
            String locationSelected = (String) comboBoxLocation.getSelectedItem();           
            alert.setCityId(CityDAO.getInstance().selectById(locationSelected).getCity_id());
            String comparisonSelected = (String) comboBoxComparison.getSelectedItem();
            char conditionType = comparisonSelected.charAt(0);
            alert.setConditionType(conditionType);
            alert.setAlertValue(Float.parseFloat(textValue.getText()));
            alert.setComment(textAlertContent.getText());
            
            UserAlertDAO.getInstance().update(alert);
            fAlert.setUpTable();
            fWeather.setAlertHistory();
            dispose();
        }
    }//GEN-LAST:event_btnFinishActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnCancel;
    private swing.MyButton btnFinish;
    private swing.ComboBoxSuggestion comboBoxComparison;
    private swing.ComboBoxSuggestion comboBoxLocation;
    private swing.ComboBoxSuggestion comboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JTextField textAlertContent;
    private javax.swing.JTextField textValue;
    // End of variables declaration//GEN-END:variables
}
