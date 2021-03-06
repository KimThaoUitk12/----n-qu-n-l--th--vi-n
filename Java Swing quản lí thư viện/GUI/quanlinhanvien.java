/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import BLL.QuanLiNhanVienBLL;
import DTO.NhanVienDTO;
//import QLTV.Cquanlinhanvien;
//import static QLTV.Cquanlinhanvien.CThemnv;
//import static QLTV.Cquanlinhanvien.DoiPassNV;
//import static QLTV.Cquanlinhanvien.XuLiGioiTinh;
import DAL.Database;
import static DAL.Database.conectionJDBC;
import static DAL.Database.TaoMa;
//import static DAL.Database.ConvertUtilDateToSqlDate;
import static DAL.Database.StringToInt;
import static DAL.Database.StringToUttilDate;
import static DAL.Database.getData;
//import DAL.Mquanlinhanvien;
//import static DAL.Mquanlinhanvien.MTimNV;
//import static database.Mquanlinhanvien.MXoaNV;
//import static database.Mquanlinhanvien.TaoDefaultNV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.*;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class quanlinhanvien extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

    /**
     * Creates new form quanlinhanvien
     */
    public quanlinhanvien() {
        initComponents();
        this.setDefaultNhanVien();
        this.setLocationRelativeTo(null);
        this.BThemNV.addActionListener(this);
//        this.BHuy.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.BSuaNV.setEnabled(false);
        this.BXoaNV.setEnabled(false);
        this.BSuaNV.addActionListener(this);
        this.BTimNV.addActionListener(this);
        this.BXoaNV.addActionListener(this);
//        this.BDoiPass.addActionListener(this);
        this.BXemNV.addActionListener(this);
        this.TableNV.getSelectionModel().addListSelectionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNV = new javax.swing.JTable();
        TextTenNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        RadioNam = new javax.swing.JRadioButton();
        RadioNu = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextDiaChiNV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TextTenTaiKhoan = new javax.swing.JTextField();
        BThemNV = new javax.swing.JButton();
        BXoaNV = new javax.swing.JButton();
        BSuaNV = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        DateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        TextSDT = new javax.swing.JTextField();
        TextTim = new javax.swing.JTextField();
        BTimNV = new javax.swing.JButton();
        Lableemail = new javax.swing.JLabel();
        TextEmail = new javax.swing.JTextField();
        BXemNV = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÍ NHÂN VIÊN | Trường THPT DƯỠNG ĐIỀM");

        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Họ và tên");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(140, 110, 60, 15);

        TableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaNV", "TenNV", "Giới tính", "Địa chỉ", "Ngày sinh", "SDT", "Tên tài khoản", "Chức vụ", "Email"
            }
        ));
        jScrollPane1.setViewportView(TableNV);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(171, 330, 890, 190);

        TextTenNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.add(TextTenNV);
        TextTenNV.setBounds(230, 100, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Giới tính");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(140, 150, 56, 24);

        RadioNam.setText("Nam");
        jPanel2.add(RadioNam);
        RadioNam.setBounds(230, 150, 60, 23);

        RadioNu.setText("Nữ");
        jPanel2.add(RadioNu);
        RadioNu.setBounds(320, 150, 39, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Địa chỉ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(440, 150, 47, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Ngày sinh");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(140, 190, 59, 23);

        TextDiaChiNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        TextDiaChiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDiaChiNVActionPerformed(evt);
            }
        });
        jPanel2.add(TextDiaChiNV);
        TextDiaChiNV.setBounds(530, 150, 194, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tên tài khoản");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(430, 100, 84, 25);

        TextTenTaiKhoan.setEditable(false);
        TextTenTaiKhoan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.add(TextTenTaiKhoan);
        TextTenTaiKhoan.setBounds(530, 100, 145, 30);

        BThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/thêm nhân viên.png"))); // NOI18N
        BThemNV.setText("Thêm");
        BThemNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel2.add(BThemNV);
        BThemNV.setBounds(480, 600, 95, 40);

        BXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        BXoaNV.setText("Xóa");
        BXoaNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        BXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BXoaNVActionPerformed(evt);
            }
        });
        jPanel2.add(BXoaNV);
        BXoaNV.setBounds(760, 600, 95, 40);

        BSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sửa nhân viên.png"))); // NOI18N
        BSuaNV.setText("Sửa");
        BSuaNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel2.add(BSuaNV);
        BSuaNV.setBounds(620, 600, 95, 40);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        jButton5.setText("Quay lại");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(130, 640, 96, 33);

        DateNgaySinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.add(DateNgaySinh);
        DateNgaySinh.setBounds(230, 190, 155, 33);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("SDT");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(780, 210, 24, 15);

        TextSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.add(TextSDT);
        TextSDT.setBounds(835, 200, 170, 30);

        TextTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.add(TextTim);
        TextTim.setBounds(410, 260, 230, 30);

        BTimNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/tìm kiếm.png"))); // NOI18N
        BTimNV.setText("Tìm kiếm");
        BTimNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel2.add(BTimNV);
        BTimNV.setBounds(660, 260, 90, 30);

        Lableemail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Lableemail.setText("Email");
        jPanel2.add(Lableemail);
        Lableemail.setBounds(440, 200, 31, 15);

        TextEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.add(TextEmail);
        TextEmail.setBounds(530, 200, 190, 30);

        BXemNV.setText("Xem thông tin");
        BXemNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel2.add(BXemNV);
        BXemNV.setBounds(350, 600, 90, 40);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("THÔNG TIN THỦ THƯ");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(410, 30, 300, 29);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Nhập thông tin:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(290, 270, 90, 16);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Bảng chi tiết");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(150, 300, 130, 16);

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel2.add(jLabel9);
        jLabel9.setBounds(150, 320, 930, 210);

        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel2.add(jLabel11);
        jLabel11.setBounds(320, 580, 550, 80);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Chức năng");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(300, 560, 70, 16);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\shutdown.png")); // NOI18N
        jButton1.setText("Đăng xuất");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(963, 640, 120, 31);

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\2397.jpg_wh1200.jpg")); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 5));
        jPanel2.add(jLabel12);
        jLabel12.setBounds(0, 0, 1160, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new DangNhapUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TextDiaChiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDiaChiNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDiaChiNVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BXoaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BXoaNVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(quanlinhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlinhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlinhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlinhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanlinhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSuaNV;
    private javax.swing.JButton BThemNV;
    private javax.swing.JButton BTimNV;
    private javax.swing.JButton BXemNV;
    private javax.swing.JButton BXoaNV;
    private com.toedter.calendar.JDateChooser DateNgaySinh;
    private javax.swing.JLabel Lableemail;
    private javax.swing.JRadioButton RadioNam;
    private javax.swing.JRadioButton RadioNu;
    private javax.swing.JTable TableNV;
    private javax.swing.JTextField TextDiaChiNV;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextSDT;
    private javax.swing.JTextField TextTenNV;
    private javax.swing.JTextField TextTenTaiKhoan;
    private javax.swing.JTextField TextTim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource().equals(BDoiPass)) {
//            DoiPassNV(this.TextTenTK.getText(), this.PassMKCu.getText(), this.PassMKMoi.getText(), this.PassNhapLaiMK.getText());
////            int temp = 0;
////            String sql = "select * from TAIKHOAN where TENTK='" + this.TextTenTK.getText() + "' and MATKHAU='" + this.PassMKCu.getText() + "'";
////            ResultSet rs = getData(conectionJDBC(), sql);
////            try {
////                while (rs.next()) {
////                    temp++;
////                }
////            } catch (SQLException ex) {
////                Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
////            }
////            if (temp <= 0) {
////                JOptionPane.showMessageDialog(null, "tên tài khoản hoặc mật khẩu sai");
////                return;
////            }
////            if (this.PassNhapLaiMK.getText().equals(this.PassMKMoi.getText()) == false) {
////                System.out.println(this.PassNhapLaiMK.getText() + " " + this.PassMKMoi.getText());
////                JOptionPane.showMessageDialog(null, "nhập lại mật khẩu sai");
////            }
////            if (temp > 0 && (this.PassNhapLaiMK.getText().equals(this.PassMKMoi.getText()))) {
////                String sqlmk = "update TAIKHOAN set MATKHAU='" + this.PassMKMoi.getText() + "' where TENTK='" + this.TextTenTK.getText() + "'";
////                try {
////                    PreparedStatement prst = conectionJDBC().prepareStatement(sqlmk);
////                    prst.execute();
////                    JOptionPane.showMessageDialog(null, "cập nhật thành công");
////                } catch (SQLException ex) {
////                    Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }
//        }
        if (ae.getSource().equals(BTimNV)) {
//            String sqltim = "select * from NHANVIEN JOIN TAIKHOAN ON NHANVIEN.MANHANVIEN=TAIKHOAN.TENTK WHERE HOTEN LIKE '%" + this.TextTim.getText() + "%' OR TENTK LIKE '%" + this.TextTim.getText() + "%'";
//            ResultSet rs = getData(conectionJDBC(), sqltim);
//            String[] dataNV = new String[9];
//            DefaultTableModel model = new DefaultTableModel();
//            String[] title = {"Mã NV", "Tên NV", "Giới tính", "Địa chỉ", "Ngày sinh", "SDT", "Tài khoản", "Chức vụ", "Email"};
//            model.setColumnIdentifiers(title);
//            try {
//                while (rs.next()) {
//                    dataNV[0] = rs.getNString("MANHANVIEN");
//                    dataNV[1] = rs.getNString("HOTEN");
//                    dataNV[2] = rs.getNString("GIOITINH");
//                    dataNV[3] = rs.getNString("DIACHI");
//                    dataNV[4] = rs.getNString("NGAYSINH");
//                    dataNV[5] = rs.getNString("SDT");
//                    dataNV[6] = rs.getNString("TENTK");
//                    dataNV[7] = rs.getNString("CHUCVU");
//                    dataNV[8] = rs.getNString("EMAIL");
//                    model.addRow(dataNV);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            this.TableNV.setModel((DefaultTableModel) MTimNV(this.TextTim.getText()));
            ArrayList<NhanVienDTO> ar=new QuanLiNhanVienBLL().getNhanVien(this.TextTim.getText());
            DefaultTableModel model=new DefaultTableModel();
            String[]title={"Mã nhân viên","Tên nhân viên","giới tính","Địa chỉ","Ngày sinh","SDT","Tên tài khoản","chức vụ","Email"};
            model.setColumnIdentifiers(title);
            for(int i=0;i<ar.size();i++){
                NhanVienDTO nv=ar.get(i);
                String ma=nv.getMaNV();
                String ten=nv.getTenNV();
                String gioitinh=nv.getGioiTinh();
                String diachi=nv.getDiaChi();
                String ngaysinh=nv.getNgaySinh();
                String sdt=nv.getSDT();
                String tentk=nv.getTentk();
                String chucvu=nv.getChucVu();
                String email=nv.getEmail();
                Object[] temp={ma,ten,gioitinh,diachi,ngaysinh,sdt,tentk,chucvu,email};
                model.addRow(temp);
            }
            this.TableNV.setModel(model);
        }
//        if (ae.getSource().equals(BHuy)) {
//            this.TableNV.getSelectionModel().clearSelection();
//            this.setDefaultNhanVien();
//        }
        if (ae.getSource().equals(BSuaNV)) {
           // this.TableNV.getSelectionModel().clearSelection();
            QuanLiNhanVienBLL ql=new QuanLiNhanVienBLL();
            String gt="";
                switch(ChonKieuDuyet(this.RadioNam.isSelected(), this.RadioNu.isSelected())){
                    case 1:{
                        gt="nam";
                        break;
                    }
                    case 2:{
                        gt="nu";
                        break;
                    }
                }
                int index=this.TableNV.getSelectedRow();
                this.TableNV.getSelectionModel().clearSelection();
                String strDate = new SimpleDateFormat("dd-MM-yyyy").format(new java.sql.Date(this.DateNgaySinh.getDate().getTime()));
            ql.CapNhatNV(new NhanVienDTO("", this.TextTenNV.getText(), strDate, this.TextSDT.getText(), this.TextEmail.getText(), gt, "thu thu", this.TextDiaChiNV.getText(), "", ""), (String)this.TableNV.getValueAt(index, 0));
//            String sqltk = "update taikhoan set loaitk='" + (String) this.CBBoxChucVu.getSelectedItem() + "' where tentk='" + this.TextTenTK.getText() + "'";
//            PreparedStatement st;
//            try {
//                st = conectionJDBC().prepareStatement(sqltk);
//                st.executeUpdate();
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            String sql = "UPDATE NHANVIEN SET HOTEN=?, GIOITINH=?, DIACHI=?, NGAYSINH=TO_DATE(?,'dd-MM-yyyy'), SDT=?, EMAIL=? WHERE MANHANVIEN=?";
//            String strDate = new SimpleDateFormat("dd-MM-yyyy").format(new java.sql.Date((this.DateNgaySinh.getDate()).getTime()));
//            PreparedStatement st;
//            try {
//                st = conectionJDBC().prepareStatement(sql);
//                st.setString(1, this.TextTenNV.getText());
//                st.setString(7, this.TextTenTaiKhoan.getText());
//                st.setString(3, this.TextDiaChiNV.getText());
//                st.setString(5, this.TextSDT.getText());
//                st.setString(4, strDate);
//                st.setString(6, this.TextEmail.getText());
////                String gt;
////                if (this.RadioNam.isSelected() && this.RadioNu.isSelected()) {
////                    JOptionPane.showMessageDialog(null, "chỉ được chọn nam hoặc nữ");
////                }
////                if (this.RadioNam.isSelected() == false && this.RadioNu.isSelected() == false) {
////                    JOptionPane.showMessageDialog(null, "hãy chọn giới tính");
////                }
////                if (this.RadioNam.isSelected()) {
////                    gt = "nam";
////                } else {
////                    gt = "nu";
////                }
//                st.setString(2, XuLiGioiTinh(this.RadioNam.isSelected(),this.RadioNu.isSelected()));
//                st.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Sửa thông tin thành công");
//                System.out.println("thành công");
//                this.setDefaultNhanVien();
//                this.BSuaNV.setEnabled(false);
//                this.BXoaNV.setEnabled(false);
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
//            }
        //Mquanlinhanvien.MSuaNV(this.TextTenNV.getText(),XuLiGioiTinh(this.RadioNam.isSelected(), this.RadioNu.isSelected()), this.TextDiaChiNV.getText(),this.DateNgaySinh.getDate(),this.TextSDT.getText(), this.TextEmail.getText(),this.TextTenTK.getText());
                this.setDefaultNhanVien();
                this.BSuaNV.setEnabled(false);
                this.BXoaNV.setEnabled(false);
        }
        if (ae.getSource().equals(BXemNV)) {
            this.BSuaNV.setEnabled(true);
            this.BXoaNV.setEnabled(true);
            int index = this.TableNV.getSelectedRow();
            if(index<0){
                JOptionPane.showMessageDialog(null, "Hãy chọn nhân viên");
                return;
            }
            this.TextTenNV.setText((String) this.TableNV.getValueAt(index, 1));
            this.TextDiaChiNV.setText((String) this.TableNV.getValueAt(index, 3));
//            this.TextTenTK.setText((String) this.TableNV.getValueAt(index, 6));
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            // set formatter to use UTC (instead of JVM default timezone)
//            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//            try {
//                // parse it as midnight (no shift to 01:00)
//                java.util.Date date = sdf.parse((String) this.TableNV.getValueAt(index, 4));
//                java.util.Date dateutil = new java.util.Date(date.getTime());
//                this.DateNgaySinh.setDate(dateutil);
//            } catch (ParseException ex) {
//                Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
//            }
             this.DateNgaySinh.setDate(StringToUttilDate((String) this.TableNV.getValueAt(index, 4)));
            this.TextTenTaiKhoan.setText((String) this.TableNV.getValueAt(index, 6));
//            for (int i = 0; i < this.CBBoxChucVu.getItemCount(); i++) {
//                if (this.CBBoxChucVu.getItemAt(i).equals((String) this.TableNV.getValueAt(index, 7))) {
//                    this.CBBoxChucVu.setSelectedIndex(i);
//                }
//            }
            if (((String) this.TableNV.getValueAt(index, 2)).equals("nam")) {
                this.RadioNam.setSelected(true);
                this.RadioNu.setSelected(false);
            } else {
                this.RadioNam.setSelected(false);
                this.RadioNu.setSelected(true);
            }
            this.TextSDT.setText((String) this.TableNV.getValueAt(index, 5));
            this.TextEmail.setText((String) this.TableNV.getValueAt(index, 8));
        }
        if (ae.getSource().equals(BXoaNV)) {
            int index = this.TableNV.getSelectedRow();
//            String sqlxoa = "{ call XOA_NHANVIEN(?) }";
//            try {
//                CallableStatement st = conectionJDBC().prepareCall(sqlxoa);
//                st.setString(1, (String) this.TableNV.getValueAt(index, 0));
//                st.execute();
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
//            }
            QuanLiNhanVienBLL ql=new QuanLiNhanVienBLL();
            ql.XoaNV((String) this.TableNV.getValueAt(index, 0));
//            MXoaNV((String) this.TableNV.getValueAt(index, 0));
            DefaultTableModel model = (DefaultTableModel) this.TableNV.getModel();
            model.removeRow(index);
            this.TableNV.setModel(model);
            this.BSuaNV.setEnabled(false);
            this.BXoaNV.setEnabled(false);
        }
        if(ae.getSource().equals(BThemNV)){
//            String sql="{call ADD_NHANVIEN(?,?,?,?,?,?,?,?,?,?,?)}";
//            String strDate = new SimpleDateFormat("dd-MM-yyyy").format(new java.sql.Date((this.DateNgaySinh.getDate()).getTime()));
//            try {
//                String User=TaoMaNV();
//                CallableStatement call=conectionJDBC ().prepareCall(sql);
//                call.setString(1, User);
//                call.setString(2, User);
//                call.setString(3, "thu thu");
//                call.setString(4, User);
//                call.setString(5, this.TextTenNV.getText());
//                call.setString(6, strDate);
//                call.setString(7, this.TextSDT.getText());
//                call.setString(8, this.TextEmail.getText());
//                 if (this.RadioNam.isSelected() && this.RadioNu.isSelected()) {
//                    JOptionPane.showMessageDialog(null, "chỉ được chọn nam hoặc nữ");
//                }
//                if (this.RadioNam.isSelected() == false && this.RadioNu.isSelected() == false) {
//                    JOptionPane.showMessageDialog(null, "hãy chọn giới tính");
//                }
//                if (this.RadioNam.isSelected()) {
//                    call.setString(9, "nam");
//                } else {
//                    call.setString(9, "nu");
//                }
//                call.setString(10, "thu thu");
//                call.setString(11, this.TextDiaChiNV.getText());
//                call.execute();
//                this.setDefaultNhanVien();
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                String temp=Database.TaoMa("nhanvien");
//                CThemnv(temp,temp,temp,this.TextTenNV.getText(),this.DateNgaySinh.getDate(),this.TextSDT.getText(),this.TextEmail.getText(),Cquanlinhanvien.XuLiGioiTinh(this.RadioNam.isSelected(),this.RadioNu.isSelected()),this.TextDiaChiNV.getText());
                QuanLiNhanVienBLL ql=new QuanLiNhanVienBLL();
                String ma=DAL.Database.TaoMa("nhanvien");
                String gt="";
                switch(ChonKieuDuyet(this.RadioNam.isSelected(), this.RadioNu.isSelected())){
                    case 1:{
                        gt="nam";
                        break;
                    }
                    case 2:{
                        gt="nu";
                        break;
                    }
                    default:{
                        return;
                    }
                }
                String strDate = new SimpleDateFormat("dd-MM-yyyy").format(new java.sql.Date(this.DateNgaySinh.getDate().getTime()));
                ql.ThemNV(new NhanVienDTO(ma, this.TextTenNV.getText(), strDate, this.TextSDT.getText(), this.TextEmail.getText(), gt, "", this.TextDiaChiNV.getText(), ma, "thu thu"));
                this.setDefaultNhanVien();
        }
    }

   

    @Override
    public void valueChanged(ListSelectionEvent lse) {
//        this.BSuaNV.setEnabled(true);
//        this.BXoaNV.setEnabled(true);
//        int index=this.TableNV.getSelectedRow();
//        this.TextTenNV.setText((String) this.TableNV.getValueAt(index, 1));
//        this.TextDiaChiNV.setText((String) this.TableNV.getValueAt(index, 3));
//        this.TextTenTK.setText((String) this.TableNV.getValueAt(index, 6));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    // set formatter to use UTC (instead of JVM default timezone)
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//        try {
//            // parse it as midnight (no shift to 01:00)
//            java.util.Date date =  sdf.parse((String)this.TableNV.getValueAt(index, 4));
//            java.util.Date dateutil=new java.util.Date(date.getTime());
//            this.DateNgaySinh.setDate(dateutil);
//        } catch (ParseException ex) {
//            Logger.getLogger(quanlinhanvien.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        this.TextTenTaiKhoan.setText((String) this.TableNV.getValueAt(index, 6));
//        this.TextChucVu.setText((String) this.TableNV.getValueAt(index, 7));
//        if(((String)this.TableNV.getValueAt(index, 2)).equals("nam")){
//            this.RadioNam.setSelected(true);
//            this.RadioNu.setSelected(false);
//        }else{
//            this.RadioNam.setSelected(false);
//            this.RadioNu.setSelected(true);
//        }
//        this.TextSDT.setText((String)this.TableNV.getValueAt(index, 5));
//        this.TextEmail.setText((String)this.TableNV.getValueAt(index, 8));
    }
     public void setDefaultNhanVien() {
//        this.CBBoxChucVu.removeAllItems();
//        String[] cbb = {"admin", "thu thu"};
//        this.CBBoxChucVu.setModel((new DefaultComboBoxModel(cbb)));
//        String sql = "select * from TAIKHOAN JOIN NHANVIEN ON TAIKHOAN.TENTK=NHANVIEN.MANHANVIEN";
//        ResultSet rs = getData(conectionJDBC(), sql);
//        DefaultTableModel model = new DefaultTableModel();
//        String[] title = {"Mã NV", "Tên NV", "Giới tính", "Địa chỉ", "Ngày sinh", "SDT", "Tài khoản", "Chức vụ", "Email"};
//        model.setColumnIdentifiers(title);
//        String[] dataNV = new String[9];
//        try {
//            while (rs.next()) {
//                dataNV[0] = rs.getNString("MANHANVIEN");
//                dataNV[1] = rs.getNString("HOTEN");
//                dataNV[2] = rs.getNString("GIOITINH");
//                dataNV[3] = rs.getNString("DIACHI");
//                dataNV[4] = rs.getNString("NGAYSINH");
//                dataNV[5] = rs.getNString("SDT");
//                dataNV[6] = rs.getNString("TENTK");
//                dataNV[7] = rs.getNString("CHUCVU");
//                dataNV[8] = rs.getNString("EMAIL");
//                model.addRow(dataNV);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        this.TableNV.setModel(TaoDefaultNV());
           QuanLiNhanVienBLL ql=new QuanLiNhanVienBLL();
                   DefaultTableModel model = new DefaultTableModel();
        String[] title = {"Mã NV", "Tên NV", "Giới tính", "Địa chỉ", "Ngày sinh", "SDT", "Tài khoản", "Chức vụ", "Email"};
        model.setColumnIdentifiers(title);
           ArrayList<NhanVienDTO> ar=ql.getAllNhanVien();
           for(int i=0;i<ar.size();i++){
               NhanVienDTO nv=ar.get(i);
               String manv=nv.getMaNV();
               String ten=nv.getTenNV();
               String gt=nv.getGioiTinh();
               String dc=nv.getDiaChi();
               String ngaysinh=nv.getNgaySinh();
               String sdt=nv.getSDT();
               String tentk=nv.getTentk();
               String chucvu=nv.getChucVu();
               String email=nv.getEmail();
               Object[]temp={manv,ten,gt,dc,ngaysinh,sdt,tentk,chucvu,email};
               model.addRow(temp);
           }
           this.TableNV.setModel(model);
    }
//    public static String TaoMaNV(){
//        int dem = 1;
//        Vector<String> v = new Vector<String>();
//        String sql = "select MANHANVIEN FROM NHANVIEN", temp = "";
//        ResultSet rs = getData(conectionJDBC(), sql);
//        try {
//            while (rs.next()) {
//                v.add(rs.getString("MANHANVIEN"));
//            }
//            Collections.sort(v);
//            for (int i = 0; i < v.size(); i++) {
//                System.out.print(v.get(i) + " ");
//            }
//            if (dem >= v.size()) {
//                temp += String.valueOf(StringToInt(v.get(v.size() - 1)) + 1);
//            } else {
//                for (int i = 0; i < v.size() - 1; i++) {
//                    if (StringToInt(v.get(i + 1)) - StringToInt(v.get(i)) > 1) {
//                        //System.out.println(StringToInt(v.get(i)) + 1);
//                        temp += String.valueOf(StringToInt(v.get(i)) + 1);
//                        break;
//                    } else {
//                        dem++;
//                    }
//                }
//                System.out.println("dem:" + dem);
//            }
//            if (dem >= v.size()) {
////                temp += String.valueOf(StringToInt(v.get(v.size() - 1)) + 1);
//                temp += String.valueOf(dem + 1);
//            }
//            //System.out.println(StringToInt(v.get(v.size()-1)) + 1);
//            System.out.println("temp:" + temp);
//            if (Integer.parseInt(temp) < 10) {
//                temp = "TT00" + temp;
//            } else if (Integer.parseInt(temp) >= 10 && Integer.parseInt(temp) < 100) {
//                temp = "TT0" + temp;
//            } else if (Integer.parseInt(temp) >= 100) {
//                temp = "TT" + temp;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(quanlidocgia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return temp;
//    }
public static int ChonKieuDuyet(boolean bl1, boolean bl2) {
        if (bl1 && bl2) {
            JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 giới tính");
            return 0;
        } else {
            if (!bl1 && !bl2) {
                JOptionPane.showMessageDialog(null, "Phải chọn 1 giới tính");
                return 0;
            } else {
                if (bl1 && !bl2) {
                    return 1;
                } else {
                    return 2;
                }
            }

        }

    }
}
