package main;

import dao.CityDAO;
import dao.CurrentWeatherDAO;
import dao.UserAlertDAO;
import event.EventMenuSelected;
import form.Form_Admin;
import form.Form_Alert;
import form.Form_Weather;
import models.NguoiDung;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JComponent;
import model.ModelMenu;
import models.City;
import models.CurrentWeather;
import models.UserAlert;
import service.WeatherAPI;

class CheckTime implements Runnable {

    private LocalTime lastCheckedTime;
    private final NguoiDung user;
    private ArrayList<UserAlert> arrayUserAlert;
    private ArrayList<CurrentWeather> arrayCurrentWeather;
    private ArrayList<Integer> idCity;
    private Form_Weather fWeather;
    private Form_Alert fAlert;

    public CheckTime(NguoiDung user, Form_Weather fWeather, Form_Alert fAlert) {
        this.user = user;
        this.fAlert = fAlert;
        this.fWeather = fWeather;
        this.lastCheckedTime = LocalTime.now().withSecond(0).withNano(0); // Khởi tạo thời gian kiểm tra cuối cùng
        this.arrayUserAlert = new ArrayList<>();
        this.arrayCurrentWeather = new ArrayList<>();
        this.idCity = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            LocalTime currentTime = LocalTime.now();
            LocalTime nextCheckTime = lastCheckedTime.plusMinutes(1).withSecond(0).withNano(0);

            // Kiểm tra xem đã qua 5 phút chưa
            if (!currentTime.isBefore(nextCheckTime)) {
                if (arrayCurrentWeather.size() > 0) {
                    arrayCurrentWeather.clear();
                }
                if (arrayUserAlert.size() > 0) {
                    arrayUserAlert.clear();
                }
                if (idCity.size() > 0) {
                    idCity.clear();
                }
                arrayUserAlert = UserAlertDAO.getInstance().selectAllById(user);
                arrayCurrentWeather = CurrentWeatherDAO.getInstance().selectAll();
                for (UserAlert userAlert : arrayUserAlert) {
                    boolean check = false;
                    for (CurrentWeather currentWeather : arrayCurrentWeather) {
                        if (currentWeather.getCityId() == userAlert.getCityId()) {
                            check = true;
                            break;
                        }
                    }
                    if (check == false) {
                        idCity.add(userAlert.getCityId());
                    }
                }

                for (int i = 0; i < idCity.size(); i++) {
                    City city = CityDAO.getInstance().selectByIdR(idCity.get(i));
                    CurrentWeather cw = WeatherAPI.getCurrentWeather(city.getLatitude(), city.getLongitude(), city.getCity_id());
                    CurrentWeatherDAO.getInstance().insert(cw);
                }

                for (UserAlert x : arrayUserAlert) {
                    CurrentWeather cw1 = CurrentWeatherDAO.getInstance().selectByIdR(x.getCityId());
                    int i = UserAlertDAO.getInstance().checkUserAlerts(cw1);
                    if (i > 0) {
                        UserAlert ua = UserAlertDAO.getInstance().selectById(Integer.toString(i));
                        System.out.println(ua.toString());
                    }
                }

                System.out.println("Đã qua 1p: " + currentTime.format(DateTimeFormatter.ofPattern("HH:mm")));
                lastCheckedTime = currentTime.withSecond(0).withNano(0); // Cập nhật thời gian kiểm tra cuối cùng
                this.fWeather.setAlertHistory();
                this.fAlert.setUpTable();
            }

            // Ngủ một khoảng thời gian ngắn để tránh kiểm tra liên tục
            try {
                Thread.sleep(1000); // Kiểm tra mỗi giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MainSystem extends javax.swing.JFrame {

    private Form_Weather fWeather;
    private Form_Alert fAlert;
    private final NguoiDung user;
    private Form_Admin fAdmin;

    public MainSystem(NguoiDung user) {
        initComponents();
        this.user = user;
        if (user.getUsername().equals("admin")) {
            menu.listMenu1.addItem(new ModelMenu("", " ", ModelMenu.MenuType.EMPTY));
            menu.listMenu1.addItem(new ModelMenu("admin", "Admin", ModelMenu.MenuType.MENU));
            fAdmin = new Form_Admin();
        }
        fWeather = new Form_Weather(user);
        fAlert = new Form_Alert(user, fWeather);
        Thread timeCheckerThread = new Thread(new CheckTime(user, fWeather, fAlert));
        timeCheckerThread.setDaemon(true); // Đặt luồng là daemon để nó tự động kết thúc khi chương trình chính kết thúc
        timeCheckerThread.start();

        menu.initMoving(MainSystem.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(fWeather);
                } else if (index == 2) {
                    setForm(fAlert);
                } else if (index == 4) {
                    System.out.println("Form Setting");
                } else if (index == 6) {
                    setForm(fAdmin);
                }
            }
        });
        setForm(fWeather);
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu = new component.Menu();
        jPanel2 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        mainPanel.setBackground(new java.awt.Color(153, 204, 255));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    /**
     * @param args the command line arguments
     */
    public static void main(NguoiDung user) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSystem(user).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    private component.Menu menu;
    private swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
