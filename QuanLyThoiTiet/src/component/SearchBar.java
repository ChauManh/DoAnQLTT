package component;

import event.EventClick;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import swing.DataSearch;
import swing.PanelSearch;

public class SearchBar extends javax.swing.JPanel {

    private JPopupMenu menu;
    private PanelSearch search;
    
    public SearchBar() {
        initComponents();
        setOpaque(false);
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                txtSearch.setText(data.getText());   
            }
        });  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new swing.SearchText();
        btnSearch = new swing.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/location.png"))); // NOI18N

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSearch.setColorClick(new java.awt.Color(153, 204, 255));
        btnSearch.setColorOver(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String text = txtSearch.getText().trim().toLowerCase();
        search.setData(search(text));
        if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
            menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
        } else {
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private List<DataSearch> search(String search){
        int limitData = 7;
        List<DataSearch> list = new ArrayList<>();
        String dataCity[] = {
        "Yen Bai", "Xuan Trung", "Vung Tau", "Vinh Yen", "Vinh Long", "Vinh Chau", "Vinh", 
        "Viet Tri", "Vi Thanh", "Tuyen Quang", "Tuy Hoa", "Trang Bang", "Tra Vinh", 
        "Thuan Tien", "Thuan An", "Thu Duc", "Thu Dau Mot", "Thi Tran Ngai Giao", 
        "Thi Tran Mau A", "Thi Tran Dong Dang", "Thanh Xuan", "Thanh Phu", "Thanh Pho Uong Bi", 
        "Thanh Hoa", "Thai Nguyen", "Thai Binh", "Tay Ninh", "Tan Van", "Tan Uyen", "Tan Son", 
        "Tan Phuoc Khanh", "Tan Phu", "Tan Phong", "Tan Chau", "Tan An", "Tan An", "Tam Ky", 
        "Tam Hiep", "Tam Diep", "Song Doc", "Song Cau", "Son Tay", "Son La", "Soc Trang", 
        "Sam Son", "Sa Pa", "Sa Dec", "Rach Gia", "Quy Nhon", "Quang Yen", "Quang Tri", 
        "Quang Ngai", "Quang Ha", "Pleiku", "Phuoc Long", "Phuc Yen", "Phu Yen", "Phu Tu Son", 
        "Phu Tho", "Phu Quoc", "Phu My", "Phu Ly", "Phan Thiet", "Phan Ri Cua", 
        "Phan Rang-Thap Cham", "Ninh Hoa", "Ninh Binh", "Nhan Trach", "Nha Trang", "Ngoc Son", 
        "Nghia Lo", "Nghi Son", "Nga Bay", "Nam Dinh", "My Tho", "My Luong", "My Hoa", 
        "Muong Theng", "Muong Lay", "Mong Duong", "Mong Cai", "Mang La", "Luan Chau", 
        "Long Xuyen", "Long Thanh", "Long My", "Long Khanh", "Long Binh", "Lao Cai", 
        "Lang Son", "Lai Chau", "La Gi", "Ky Anh", "Kon Tum", "Kinh Mon", "Kien Luong", 
        "Kien Giang", "Khe Sanh", "Huong Tra", "Huong Thuy", "Huong Canh", "Hung Yen", "Hue", 
        "Hong Ngu", "Hoi An", "Hoa Thuong", "Hoa Thanh", "Hoa Binh", "Ho Nai", 
        "Ho Chi Minh City", "Hiep Hoa", "Ha noi", "Hang Tram", "Hai phong", "Hai Duong", 
        "Ha Tinh", "Ha Tien", "Ha Long", "Ha Giang", "Go Cong", "Gia Rai", "Gia Nghia", 
        "Duyen Hai", "Duc Pho", "Dong Xoai", "Dong Hoi", "Dong Hoa", "Dong Ha", 
        "Dien Bien Phu", "Di Linh", "Di An", "Da Nang", "Da Lat", "Cua Lo", "Con Dao", 
        "Chon Thanh", "Cho Phuoc Hai", "Cho Moi", "Cho Lach", "Chi Linh", "Chau Doc", 
        "Cao Lanh", "Cao Bang", "Can Tho", "Cam Ranh", "Cam Ranh", "Cam Pha", "Cai Lay", 
        "Ca Mau", "Buu Long", "Buon Trap", "Buon Ma Thuot", "Buon Ho", "Bo", "Binh Minh", 
        "Binh Long", "Binh Hoa", "Binh Hoa", "Bim Son", "Bien Hoa", "Ben Tre", "Bao Loc", 
        "Bai Chay", "Bac Ninh", "Bac Lieu", "Bac Kan", "Bac Giang", "Ba Ria", "Ba Don", 
        "Ba Chuc", "Ap Tan Ngai", "Ap Phu My", "Ap Phu Hai", "Ap Khanh Hung", "Ap Khanh Hoa", 
        "Ap Da Loi", "Ap Binh Thanh", "An Thanh B", "An Phu", "An Nhon", "An Khe", "An Chau", 
        "A Yun Pa"
    };
        for (String c : dataCity) {
            if (c.toLowerCase().contains(search)) {
                    list.add(new DataSearch(c, false));
                }
                if (list.size() == limitData) {
                    break;
                }
        }
        return list;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public swing.MyButton btnSearch;
    private javax.swing.JLabel jLabel1;
    public swing.SearchText txtSearch;
    // End of variables declaration//GEN-END:variables
}
