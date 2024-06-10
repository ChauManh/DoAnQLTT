package form;

import java.util.List;
import models.UserAlert;

public class Form_AlertHistory extends javax.swing.JPanel {


    public Form_AlertHistory(List<UserAlert> arrayUserAlert) {
        initComponents();
        int startIndex = Math.max(arrayUserAlert.size() - 5, 0); // lấy 5 phần tử cuối, hoặc tất cả nếu mảng có ít hơn 5 phần tử
        for (int i = arrayUserAlert.size() - 1; i >= startIndex; i--) {
            UserAlert ua = arrayUserAlert.get(i);
            add(new Form_SingleAlert(ua));
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
        setLayout(new java.awt.GridLayout(5, 1, 0, 5));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
