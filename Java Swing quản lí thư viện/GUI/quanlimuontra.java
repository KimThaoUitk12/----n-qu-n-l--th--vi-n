/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.PhieuMuonBLL;
import BLL.TraBLL;
import static DAL.Database.CapNhatTrangThaiMuon;
import DAL.TraDAL;
import DTO.BangTamDTO;
import DTO.PhieuMuonDTO;
import DTO.TraDTO;
//import static QLTV.Cquanlimuontra.CheckDanhSachTam;
//import static QLTV.Cquanlimuontra.ChoMuonSach;
//import static QLTV.Cquanlimuontra.KiemTraMaSach;
//import static QLTV.Cquanlimuontra.LoadDG;
import static DAL.Database.TaoMa;
import static DAL.Database.checkDG;
import static DAL.Database.conectionJDBC;
import static DAL.Database.getData;
//import database.Mquanlimuontra;
//import static database.Mquanlimuontra.CapNhatTrangThaiMuon;
//import static database.Mquanlimuontra.LayTenDocGia;
//import static database.Mquanlimuontra.LoadDanhSachTra;
//import static database.Mquanlimuontra.ThemVaoQTMuon;
//import static database.Mquanlimuontra.TinhTienPhat;
//import static database.Mquanlimuontra.TraSach;
//import static database.Mquanlimuontra.TraTien;
//import static database.Mquanlimuontra.checkDG;
//import static database.Mquanlimuontra.getSoSachDangMuon;
//import static database.Mquanlimuontra.getSoSachQuaHan;
//import static database.Mquanlimuontra.setDefaultMuon;
//import static database.Mquanlimuontra.setDefaultTra;
//import static database.Mquanlimuontra.setDefaultMuon;
//import static database.Mquanlimuontra.setDefaultTra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ADMIN
 */
public class quanlimuontra extends javax.swing.JFrame implements ActionListener, DocumentListener {

    /**
     * Creates new form quanlimuontra
     */  Connection conn;
    public quanlimuontra() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.BChoMuon.setEnabled(false);
        this.setDefaultMuon();
        this.setdefaultTra();
//        this.TableTra.setModel(setDefaultTra());
//        this.TableMuon.setModel(setDefaultMuon());
        this.BKiemTraDocGiaTra.addActionListener(this);
        // this.BTraTien.addActionListener(this);
        this.BTraSach.setEnabled(false);
        this.BTraSach.addActionListener(this);
        this.BLoadTra.addActionListener(this);
        this.BChoMuon.addActionListener(this);
        this.TableMuonTam.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = TableMuonTam.rowAtPoint(evt.getPoint());
                DefaultTableModel model = (DefaultTableModel) TableMuonTam.getModel();
                model.removeRow(row);
                TableMuonTam.setModel(model);
                int count = TableMuonTam.getRowCount();
                LBSoSach.setText(String.valueOf(count));
//        int col = jTable1.columnAtPoint(evt.getPoint());
            }
        }
        );
        this.TableTra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTraSach.setEnabled(true);
            }
        });
        this.TextMaDocGia.setEditable(false);
        this.BThemPhieuMuon.setEnabled(false);
        this.BThemPhieuMuon.addActionListener(this);
        this.TextTrangThaiSach.getDocument().addDocumentListener(this);
        this.TextMaDocGia.getDocument().addDocumentListener(this);
        this.TextMaDocGiaTra.getDocument().addDocumentListener(this);
        this.LBTrangThaiDocGia.setVisible(false);
        this.LBState.setVisible(false);
        this.BLoadTra.addActionListener(this);
        this.LBTinhTrangSach.setVisible(false);
        this.BKiemTraMaSach.addActionListener(this);
        this.BKiemTraDocGia.addActionListener(this);
        this.BLoadDanhSach.addActionListener(this);
        CapNhatTrangThaiMuon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMuon = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TextMaDocGia = new javax.swing.JTextField();
        LBSoSach = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableMuonTam = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        BLoadDanhSach = new javax.swing.JButton();
        BChoMuon = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        BKiemTraDocGia = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        TextMadocGia = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        TextTenDocGia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TextSoSachDangMuon = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TextSoSachQuaHan = new javax.swing.JTextField();
        LBState = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TextMaSach = new javax.swing.JTextField();
        BKiemTraMaSach = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TextTrangThaiSach = new javax.swing.JTextField();
        LBTinhTrangSach = new javax.swing.JLabel();
        BThemPhieuMuon = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableTra = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TextMaDocGiaTra = new javax.swing.JTextField();
        BLoadTra = new javax.swing.JButton();
        BTraSach = new javax.swing.JButton();
        BKiemTraDocGiaTra = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        TextTienPhat = new javax.swing.JTextField();
        LBTrangThaiDocGia = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THƯ VIỆN TRƯỜNG THPT DƯỠNG ĐIỀM");
        setMinimumSize(new java.awt.Dimension(1140, 750));
        setPreferredSize(new java.awt.Dimension(1143, 750));

        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.setLayout(null);

        TableMuon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        TableMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu mượn", "Mã sách", "Mã độc giả", "Ngày mượn", "Ngày hết hạn"
            }
        ));
        jScrollPane2.setViewportView(TableMuon);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(520, 140, 546, 180);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Mã độc giả");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Số lượng sách mượn:");

        TextMaDocGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        LBSoSach.setText("0");

        TableMuonTam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách"
            }
        ));
        jScrollPane4.setViewportView(TableMuonTam);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBSoSach)
                    .addComponent(TextMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBSoSach)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(80, 470, 610, 170);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        BLoadDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/load DS.png"))); // NOI18N
        BLoadDanhSach.setText("Load danh sách");
        BLoadDanhSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        BChoMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cho mượn.png"))); // NOI18N
        BChoMuon.setText("Cho mượn");
        BChoMuon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        BChoMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BChoMuonActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/shutdown.png"))); // NOI18N
        jButton11.setText("Đăng xuất");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        jButton1.setText("Quay lại");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("IN Phiếu Mượn");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BLoadDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(BChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BLoadDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BChoMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(740, 480, 380, 130);

        BKiemTraDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/kiểm tra.png"))); // NOI18N
        BKiemTraDocGia.setText("Kiểm tra");
        BKiemTraDocGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        BKiemTraDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BKiemTraDocGiaActionPerformed(evt);
            }
        });
        jPanel1.add(BKiemTraDocGia);
        BKiemTraDocGia.setBounds(319, 87, 87, 31);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Mã độc giả");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(42, 89, 75, 27);

        TextMadocGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel1.add(TextMadocGia);
        TextMadocGia.setBounds(129, 88, 172, 29);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tên độc giả");

        TextTenDocGia.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Số lượng sách đang mượn");

        TextSoSachDangMuon.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Số lượng sách quá hạn");

        TextSoSachQuaHan.setEditable(false);

        LBState.setText("Không tồn tại độc giả này");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LBState)
                                .addGap(135, 135, 135))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextSoSachDangMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TextSoSachQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LBState)
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextSoSachDangMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextSoSachQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(80, 140, 350, 193);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Mã sách");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(40, 360, 76, 25);

        TextMaSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel1.add(TextMaSach);
        TextMaSach.setBounds(120, 360, 164, 30);

        BKiemTraMaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/kiểm tra.png"))); // NOI18N
        BKiemTraMaSach.setText("Kiểm tra");
        BKiemTraMaSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(BKiemTraMaSach);
        BKiemTraMaSach.setBounds(300, 360, 99, 31);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Trạng thái");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(36, 423, 58, 25);

        TextTrangThaiSach.setEditable(false);
        TextTrangThaiSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel1.add(TextTrangThaiSach);
        TextTrangThaiSach.setBounds(125, 420, 165, 30);

        LBTinhTrangSach.setText("Sách không tồn tại hoặc đã được mượn");
        jPanel1.add(LBTinhTrangSach);
        LBTinhTrangSach.setBounds(113, 398, 187, 14);

        BThemPhieuMuon.setText("Thêm vào phiếu mượn");
        jPanel1.add(BThemPhieuMuon);
        BThemPhieuMuon.setBounds(308, 419, 139, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Bảng thông tin mượn sách");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(510, 100, 151, 16);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("QUẢN LÝ MƯỢN SÁCH");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(385, 23, 242, 29);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Xử lý thông tin");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(740, 440, 81, 25);

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(510, 130, 570, 200);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, 0, 1140, 720);

        jTabbedPane1.addTab("Mượn sách", jPanel1);

        jPanel3.setLayout(null);

        TableTra.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        TableTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã độc giả", "Mã sách", "Ngày mượn", "Ngày hết hạn", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(TableTra);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(440, 210, 638, 210);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã độc giả");

        TextMaDocGiaTra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        BLoadTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/load DS.png"))); // NOI18N
        BLoadTra.setText("Load danh sách");
        BLoadTra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        BLoadTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLoadTraActionPerformed(evt);
            }
        });

        BTraSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cho mượn.png"))); // NOI18N
        BTraSach.setText("Trả sách");
        BTraSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        BTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTraSachActionPerformed(evt);
            }
        });

        BKiemTraDocGiaTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/kiểm tra.png"))); // NOI18N
        BKiemTraDocGiaTra.setText("Kiểm tra");
        BKiemTraDocGiaTra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Tiền phạt");

        TextTienPhat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        LBTrangThaiDocGia.setText("Không tìm thấy độc giả");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextTienPhat))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LBTrangThaiDocGia)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextMaDocGiaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(BLoadTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BKiemTraDocGiaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextMaDocGiaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LBTrangThaiDocGia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BKiemTraDocGiaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BLoadTra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(BTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(50, 130, 295, 327);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("QUẢN LÝ TRẢ SÁCH");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(380, 30, 218, 29);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Bảng chi tiết");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(420, 180, 70, 16);

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel3.add(jLabel9);
        jLabel9.setBounds(420, 200, 670, 240);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/shutdown.png"))); // NOI18N
        jButton3.setText("Đăng xuất");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(960, 600, 120, 40);

        jButton2.setText("Quay lại");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(270, 600, 100, 40);

        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 5));
        jPanel3.add(jLabel10);
        jLabel10.setBounds(0, 0, 1140, 720);

        jTabbedPane1.addTab("Trả sách", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BKiemTraDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BKiemTraDocGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BKiemTraDocGiaActionPerformed

    private void BLoadTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLoadTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BLoadTraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new MenuThuThu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BChoMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BChoMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BChoMuonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          new MenuThuThu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
         // TODO add your handling code here:
      try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String strConn="jdbc:oracle:thin:@localhost:1521/orcl11g";
           conn=DriverManager.getConnection(strConn,"TRA","123456");
            if(conn!=null)
			{
				System.out.println("Kết nối tới Oracle thành công");
			}
			else
			{
				System.out.println("Kết nối tới Oracle thất bại");
			}
           String reportPath="C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Report\\PhieuMuonSach.jrxml";
          HashMap pm= new HashMap();
          pm.put("MAPHIEUMUON",(String) this.TableMuon.getValueAt(this.TableMuon.getSelectedRow(), 0));
           JasperReport jr= JasperCompileManager.compileReport(reportPath);
           JasperPrint jp=JasperFillManager.fillReport(jr,pm,conn);
           JasperViewer.viewReport(jp,false);
           conn.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void BTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTraSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTraSachActionPerformed

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
            java.util.logging.Logger.getLogger(quanlimuontra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlimuontra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlimuontra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlimuontra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanlimuontra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BChoMuon;
    private javax.swing.JButton BKiemTraDocGia;
    private javax.swing.JButton BKiemTraDocGiaTra;
    private javax.swing.JButton BKiemTraMaSach;
    private javax.swing.JButton BLoadDanhSach;
    private javax.swing.JButton BLoadTra;
    private javax.swing.JButton BThemPhieuMuon;
    private javax.swing.JButton BTraSach;
    private javax.swing.JLabel LBSoSach;
    private javax.swing.JLabel LBState;
    private javax.swing.JLabel LBTinhTrangSach;
    private javax.swing.JLabel LBTrangThaiDocGia;
    private javax.swing.JTable TableMuon;
    private javax.swing.JTable TableMuonTam;
    private javax.swing.JTable TableTra;
    private javax.swing.JTextField TextMaDocGia;
    private javax.swing.JTextField TextMaDocGiaTra;
    private javax.swing.JTextField TextMaSach;
    private javax.swing.JTextField TextMadocGia;
    private javax.swing.JTextField TextSoSachDangMuon;
    private javax.swing.JTextField TextSoSachQuaHan;
    private javax.swing.JTextField TextTenDocGia;
    private javax.swing.JTextField TextTienPhat;
    private javax.swing.JTextField TextTrangThaiSach;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    private String State;

    public String toString() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(BKiemTraDocGia)) {
            //int temp = 0;
            //String ten = "";
            int dangmuon = 0, han = 0;
            if ((DAL.Database.checkDG(this.TextMadocGia.getText()))) {
                this.LBState.setVisible(false);
                dangmuon = new TraDAL().getSoSachMuon(this.TextMadocGia.getText());
                han = new TraDAL().getSoSachQuaHan(this.TextMadocGia.getText());
                this.TextTenDocGia.setText(new TraDAL().LayTenDocGia(this.TextMadocGia.getText()));
                this.TextSoSachDangMuon.setText(String.valueOf(dangmuon));
                this.TextSoSachQuaHan.setText(String.valueOf(han));
                this.TextMaDocGia.setText(this.TextMadocGia.getText());
            } else {
                this.LBState.setVisible(true);
                this.TextTenDocGia.setText("");
                this.TextSoSachDangMuon.setText("");
                this.TextSoSachQuaHan.setText("");
            }
//            String sql = "select * from DOCGIA WHERE MADOCGIA='" + this.TextMadocGia.getText() + "'";
//            ResultSet rs = getData(conectionJDBC(), sql);
//            try {
//                while (rs.next()) {
//                    temp++;
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (temp >= 1) {
//                this.TextMaDocGia.setText(this.TextMadocGia.getText());
//                this.LBState.setVisible(false);
//                this.TextMaDocGia.setText(this.TextMadocGia.getText());
//                String duyet = "select DOCGIA.TEN FROM DOCGIA WHERE MADOCGIA='" + this.TextMadocGia.getText() + "'";
//                rs = getData(conectionJDBC(), duyet);
//                try {
//                    while (rs.next()) {
//                        ten = rs.getString(1);
//                    }
//                    String strmuon = "select COUNT(MASACH) FROM QTMUON WHERE NGAYTRA IS NULL AND MADOCGIA='" + this.TextMadocGia.getText() + "' GROUP BY MADOCGIA";
//                    rs = getData(conectionJDBC(), strmuon);
//                    while (rs.next()) {
//                        dangmuon = rs.getString(1);
//                    }
//                    String strhan = "select COUNT(MASACH) FROM QTMUON WHERE NGAYTRA IS NULL AND NGAYHETHAN < SYSDATE AND MADOCGIA='" + this.TextMadocGia.getText() + "' GROUP BY MADOCGIA";
//                    rs = getData(conectionJDBC(), strhan);
//                    while (rs.next()) {
//                        han = rs.getString(1);
//                    }
//                    rs.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//                }
            //  this.TextTenDocGia.setText(ten);
//                this.TextSoSachDangMuon.setText(dangmuon);
//                this.TextSoSachQuaHan.setText(han);
//            } else {
//                this.LBState.setVisible(true);
//                this.TextTenDocGia.setText("");
//                this.TextSoSachDangMuon.setText("");
//                this.TextSoSachQuaHan.setText("");
//            }
        }
        if (ae.getSource().equals(BKiemTraMaSach)) {
             if(new TraDAL().CheckMaSach(this.TextMaSach.getText())){
                 this.LBTinhTrangSach.setVisible(false);
           this.TextTrangThaiSach.setText(new TraDAL().LayTrangThaiSach(this.TextMaSach.getText()));
        }else{
                 this.LBTinhTrangSach.setVisible(true);
            this.TextTrangThaiSach.setText("");
        }
//            if (KiemTraMaSach(this.TextMaSach.getText()).equals("")) {
//                this.LBTinhTrangSach.setVisible(true);
//                this.TextTrangThaiSach.setText("");
//            } else {
//                this.LBTinhTrangSach.setVisible(false);
//                this.TextTrangThaiSach.setText(KiemTraMaSach(this.TextMaSach.getText()));
//            }
//            String sqlmasach = "select TRANGTHAI FROM SACH WHERE MASACH='" + this.TextMaSach.getText() + "'";
//            ResultSet rs = getData(conectionJDBC(), sqlmasach);
//            try {
//                int temp = 0;
//                while (rs.next()) {
//                    this.TextTrangThaiSach.setText(rs.getNString(1));
//                    this.LBTinhTrangSach.setVisible(false);
//                    temp = 1;
//                }
//                if (temp <= 0) {
//                    this.LBTinhTrangSach.setVisible(true);
//                    this.TextTrangThaiSach.setText("");
//                }
//                rs.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        if (ae.getSource().equals(BLoadTra)) {
            if (DAL.Database.checkDG(this.TextMaDocGiaTra.getText())) {
                ArrayList<TraDTO> ar = new TraBLL().getTra(this.TextMaDocGiaTra.getText());
                //this.TableTra.setModel(LoadDanhSachTra(this.TextMaDocGiaTra.getText()));
                DefaultTableModel model = new DefaultTableModel();
                String[] title = {"Mã độc giả", "Mã sách", "Ngày mượn", "Ngày hết hạn", "Trạng thái"};
                model.setColumnIdentifiers(title);
                for (int i = 0; i < ar.size(); i++) {
                    TraDTO tra = ar.get(i);
                    String madg = tra.getMaDG();
                    String masach = tra.getMaSach();
                    String ngaymuon = tra.getNgayMuon();
                    String ngayhethan = tra.getNgayHetHan();
                    String trangthai = tra.getTrangThai();
                    Object[] temp = {madg, masach, ngaymuon, ngayhethan, trangthai};
                    model.addRow(temp);
                }
                this.TableTra.setModel(model);
                this.LBTrangThaiDocGia.setVisible(false);
            } else {
                this.LBTrangThaiDocGia.setVisible(true);
            }
//            String load = "SELECT * FROM DOCGIA WHERE MADOCGIA='" + this.TextMaDocGiaTra.getText() + "'";
//            int temp = 0;
//            ResultSet rs = getData(conectionJDBC(), load);
//            try {
//                while (rs.next()) {
//                    temp = 1;
//                }
//                rs.close();
//                if (temp == 0) {
//                    this.LBTrangThaiDocGia.setVisible(true);
//                } else {
//                    DefaultTableModel model = new DefaultTableModel();
//                    String[] ar = {"Mã độc giả", "Mã sách", "Ngày mượn", "Ngày hết hạn"};
//                    model.setColumnIdentifiers(ar);
//                    load = "SELECT * FROM QTMUON WHERE MADOCGIA='" + this.TextMaDocGiaTra.getText() + "' AND NGAYTRA IS NULL";
//                    rs = getData(conectionJDBC(), load);
//                    String[] arr = new String[4];
//                    while (rs.next()) {
//                        arr[0] = rs.getString("MADOCGIA");
//                        arr[1] = rs.getString("MASACH");
//                        arr[2] = rs.getString("NGAYMUON");
//                        arr[3] = rs.getString("NGAYHETHAN");
//                        model.addRow(arr);
//                    }
//                    this.TableTra.setModel(model);
//                   this.LBTrangThaiDocGia.setVisible(false);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        if (ae.getSource().equals(BThemPhieuMuon)) {
            int count = this.TableMuonTam.getRowCount();
//            for (int i = 0; i < count; i++) {
//                if (this.TableMuonTam.getValueAt(i, 0).equals(this.TextMaSach.getText())) {
//                    this.BThemPhieuMuon.setEnabled(false);
//                    JOptionPane.showMessageDialog(null, "Đã chọn sách này");
//                    return;
//                }
//            }
            BangTamDTO bt=new TraDAL().LaySachDeChoVaoBangTam(this.TextMaSach.getText());
            
            if (CheckDanhSachTam(this.TableMuonTam, count, bt)) {
                //this.TableMuonTam.setModel(Mquanlimuontra.ThemSachVaoBangTam((DefaultTableModel) this.TableMuonTam.getModel(), this.TextMaSach.getText()));
                DefaultTableModel model=(DefaultTableModel) this.TableMuonTam.getModel();
                Object[]temp={bt.getMaSach(),bt.getTenSach()};
                model.addRow(temp);
                this.TableMuonTam.setModel(model);
            }
//            DefaultTableModel model = (DefaultTableModel) this.TableMuonTam.getModel();
//            String[] temp = new String[2];
//            String sql = "SELECT * FROM SACH WHERE MASACH='" + this.TextMaSach.getText() + "'";
//            ResultSet rs = getData(conectionJDBC(), sql);
//            try {
//                while (rs.next()) {
//                    temp[0] = rs.getString("MASACH");
//                    temp[1] = rs.getString("TENSACH");
//                    model.addRow(temp);
//                }
//                this.TableMuonTam.setModel(model);
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
            count = this.TableMuonTam.getRowCount();
            this.LBSoSach.setText(String.valueOf(count));
            this.BThemPhieuMuon.setEnabled(false);
        }
        if (ae.getSource().equals(BChoMuon)) {
            if (Integer.parseInt(this.TextSoSachQuaHan.getText()) >= 1) {
                JOptionPane.showMessageDialog(null, "Đang giữ sách quá hạn, không thể mượn mới");
                return;
            }
            String mamuon=TaoMa("phieumuon");
            //ChoMuonSach(this.TableMuonTam, this.TableMuonTam.getRowCount(), this.TextMaDocGia.getText(), this.TextMaPhieuMuon.getText());
            for(int i=0;i<this.TableMuonTam.getRowCount();i++){
                BangTamDTO bt=new BangTamDTO((String)this.TableMuonTam.getValueAt(i, 0), (String)this.TableMuonTam.getValueAt(i, 1));
                new TraDAL().choMuon(bt, this.TextMaDocGia.getText(), mamuon);
            }
            DefaultTableModel model=new DefaultTableModel();
            String[]title={"Mã sách","Tên sách"};
            model.setColumnIdentifiers(title);
            this.TableMuonTam.setModel(model);
//            PreparedStatement st;
//            try {
//                for (int i = 0; i < this.TableMuonTam.getRowCount(); i++) {
//                    String sqlqt = "insert into QTMUON VALUES('" + (String) this.TableMuonTam.getValueAt(i, 0) + "',SYSDATE,'" + this.TextMaDocGia.getText() + "',ADD_MONTHS(SYSDATE,3),null,null)";
//                    st = conectionJDBC().prepareCall(sqlqt);
//                    st.executeUpdate();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                for (int i = 0; i < this.TableMuonTam.getRowCount(); i++) {
//                    String sqlpm = "insert into PHIEUMUON VALUES('" + this.TextMaPhieuMuon.getText() + "','" + (String) this.TableMuonTam.getValueAt(i, 0) + "','" + this.TextMaDocGia.getText() + "',SYSDATE, ADD_MONTHS(SYSDATE,3))";
//                    st = conectionJDBC().prepareCall(sqlpm);
//                    st.executeUpdate();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            for (int i = 0; i < this.TableMuonTam.getRowCount(); i++) {
//                String sqlupdate = "UPDATE SACH SET TRANGTHAI='Da muon' WHERE MASACH='" + (String) this.TableMuonTam.getValueAt(i, 0) + "'";
//                try {
//                    st = conectionJDBC().prepareCall(sqlupdate);
//                    st.executeUpdate();
//                } catch (SQLException ex) {
//                    Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
            JOptionPane.showMessageDialog(null, "Mượn sách thành công");
            this.setDefaultMuon();
            this.setdefaultTra();
//            this.TableTra.setModel(setDefaultTra());
//            this.TableMuon.setModel(setDefaultMuon());
        }
//        if(ae.getSource().equals(BKiemTraDocGiaTra)){
//             int temp = 0;
//            String sql = "select * from DOCGIA WHERE MADOCGIA='" + this.TextMaDocGiaTra.getText() + "'";
//            ResultSet rs = getData(conectionJDBC(), sql);
//            try {
//                while (rs.next()) {
//                    temp++;
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (temp >= 1) {
//                this.LBTrangThaiDocGia.setVisible(false);
//            } else {
//                this.LBState.setVisible(true);
//            }
//        }
        if (ae.getSource().equals(BTraSach)) {
            int index = this.TableTra.getSelectedRow();
            if (index < 0) {
                JOptionPane.showMessageDialog(null, "Không có sách được chọn");
                //return null;
                return;
            }
//            if(Integer.parseInt(this.TextTienPhat.getText())>1000){
//                String ma=TaoMa("phieuphat");
//                String muon="INSERT INTO PHIEUPHAT VALUES(?,?,?,?,?,to_date(?, 'DD-MM-YY'),to_date(?, 'DD-MM-YY'))";
//                try {
//                    PreparedStatement st=conectionJDBC().prepareCall(ma);
//                    st.setString(1, ma);
//                    st.setString(2, (String) this.TableTra.getValueAt(index, 0));
//                    st.setString(3, this.toString());
//                    st.setString(4, (String) this.TableTra.getValueAt(index, 1));
//                    st.setInt(5, Integer.parseInt(this.TextTienPhat.getText()));
//                    st.setString(6, "SYSDATE");
//                    st.setString(7, (String) this.TableTra.getValueAt(index, 3));
//                    st.execute();
//                } catch (SQLException ex) {
//                    Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
            TraDTO tra = new TraDTO((String) this.TableTra.getValueAt(index, 0), (String) this.TableTra.getValueAt(index, 1), (String) this.TableTra.getValueAt(index, 2), (String) this.TableTra.getValueAt(index, 3), (String) this.TableTra.getValueAt(index, 4));
            new TraBLL().TraSach(tra, index,this.toString());
            //TraSach(this.TableTra, this.TableTra.getSelectedRow());
//            int index=this.TableTra.getSelectedRow();
//            System.out.println(index);
//            if(index<0){
//                JOptionPane.showMessageDialog(null, "Không có sách được chọn");
//                return;
//            }
//            String tra="UPDATE QTMUON SET NGAYTRA=SYSDATE,TRANGTHAI=null WHERE MASACH='"+this.TableTra.getValueAt(index, 1)+"' AND MADOCGIA='"+this.TableTra.getValueAt(index, 0)+"' AND NGAYTRA IS NULL";
//            try {
//                PreparedStatement st=conectionJDBC().prepareCall(tra);
//                st.executeUpdate();
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            String update="UPDATE SACH SET TRANGTHAI='Chua muon' WHERE MASACH='"+this.TableTra.getValueAt(index, 1)+"'";
//            try {
//                PreparedStatement st=conectionJDBC().prepareCall(update);
//                st.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Đã thanh toán tiền phạt");
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            JOptionPane.showMessageDialog(null, "Đã trả sách");
            this.setdefaultTra();
//            this.TableTra.setModel(setDefaultTra());
        }
        if (ae.getSource().equals(BLoadDanhSach)) {
            this.setDefaultMuon();
            //this.TableTra.setModel(setDefaultTra());
        }
        if (ae.getSource().equals(BKiemTraDocGiaTra)) {
            if (checkDG(this.TextMaDocGiaTra.getText())) {
                int fee = new TraBLL().TinhTienPhat(this.TextMaDocGiaTra.getText());
                this.TextTienPhat.setText(String.valueOf(fee));
                this.LBTrangThaiDocGia.setVisible(false);
            } else {
                this.LBState.setVisible(true);
            }
//            String sql="{?=call TINH_Phat(?,?)}";
//            int index=this.TableTra.getSelectedRow();
//            try {
//                CallableStatement st=conectionJDBC().prepareCall(sql);
//                //st.setString(2, (String) this.TableTra.getValueAt(index, 0));
//                st.setString(2, (String) this.TextMaDocGiaTra.getText());
//                st.setInt(3, 2000);
//                st.registerOutParameter(1, Types.INTEGER);
//                st.execute();
//                int output = st.getInt(1);
//                this.TextTienPhat.setText(String.valueOf(output));
//            } catch (SQLException ex) {
//                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//            }
            //this.TextTienPhat.setText(String.valueOf(TinhTienPhat(this.TextMaDocGiaTra.getText())));
        }
//        if(ae.getSource().equals(BTraTien)){
////            String tra="UPDATE QTMUON SET NGAYTRA=SYS WHERE TRANGTHAI='phat' AND WHERE MADOCGIA='"+this.TextMaDocGiaTra.getText()+"'";
////            String update="UPDATE QTMUON SET TRANGTHAI=null WHERE TRANGTHAI='phat' AND WHERE MADOCGIA='"+this.TextMaDocGiaTra.getText()+"'";
////            try {
////                PreparedStatement st=conectionJDBC().prepareCall(tra);
////                st.executeUpdate();
////                 st=conectionJDBC().prepareCall(update);
////                st.executeUpdate();
////            } catch (SQLException ex) {
////                Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
////            }
//            TraTien(this.TextMaDocGiaTra.getText());
//        }
    }

//    public static String TaoMaPhieuMuon() {
//        int dem = 1;
//        Vector<String> v = new Vector<String>();
//        String sql = "select MAPHIEUMUON FROM PHIEUMUON", temp = "";
//        ResultSet rs = getData(conectionJDBC(), sql);
//        try {
//            while (rs.next()) {
//                v.add(rs.getString("MAPHIEUMUON"));
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
//                        if (StringToInt(v.get(i + 1)) - StringToInt(v.get(i)) > 0) {
//                            dem++;
//                        }
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
//                temp = "PM00" + temp;
//            } else if (Integer.parseInt(temp) >= 10 && Integer.parseInt(temp) < 100) {
//                temp = "PM0" + temp;
//            } else if (Integer.parseInt(temp) >= 100) {
//                temp = "PM" + temp;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(quanlidocgia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return temp;
//    }
    public void setDefaultMuon() {
        ArrayList<PhieuMuonDTO> ar = new PhieuMuonBLL().getAllPhieuMuon();
        DefaultTableModel model = new DefaultTableModel();
        String[] title = {"Mã phiếu mượn", "Mã sách", "Mã độc giả", "Ngày mượn", "Ngày hết hạn"};
        model.setColumnIdentifiers(title);
        for (int i = 0; i < ar.size(); i++) {
            PhieuMuonDTO pm = ar.get(i);
            String maphieu = pm.getMaPhieu();
            String madg = pm.getMADG();
            String masach = pm.getMaSach();
            String ngaymuon = pm.getNgayMuon();
            String ngayhethan = pm.getNgayHetHan();
            Object[] temp = {maphieu, madg, masach, ngaymuon, ngayhethan};
            model.addRow(temp);
        }
        this.TableMuon.setModel(model);
//        String sql = "SELECT * FROM PHIEUMUON";
//        ResultSet rs = getData(conectionJDBC(), sql);
//        DefaultTableModel model = new DefaultTableModel();
//        String[] title = {"Mã phiếu mượn", "Mã sách", "Mã độc giả", "Ngày mượn", "Ngày hết hạn","Trạng thái"};
//        String[] ar = new String[6];
//        model.setColumnIdentifiers(title);
//        try {
//            while (rs.next()) {
//                ar[0] = rs.getString("MAPHIEUMUON");
//                ar[1] = rs.getString("MASACH");
//                ar[2] = rs.getString("MADOCGIA");
//                ar[3] = rs.getString("NGAYMUON");
//                ar[4] = rs.getString("NGAYHETHAN");
//                ar[5]=rs.getString("TRANGTHAI");
//                model.addRow(ar);
//            }
//            this.TableMuon.setModel(model);
//        } catch (SQLException ex) {
//            Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public void setdefaultTra() {
        ArrayList<TraDTO> ar = new TraBLL().getAllTra();
        DefaultTableModel model = new DefaultTableModel();
        String[] title = {"Mã độc giả", "Mã sách", "Ngày mượn", "Ngày hết hạn", "Trạng thái"};
        model.setColumnIdentifiers(title);
        for (int i = 0; i < ar.size(); i++) {
            TraDTO tra = ar.get(i);
            String madg = tra.getMaDG();
            String masach = tra.getMaSach();
            String ngaymuon = tra.getNgayMuon();
            String ngayhethan = tra.getNgayHetHan();
            String trangthai = tra.getTrangThai();
            Object[] temp = {madg, masach, ngaymuon, ngayhethan, trangthai};
            model.addRow(temp);
        }
        this.TableTra.setModel(model);
//        String sql="SELECT * FROM QTMUON WHERE NGAYTRA IS NULL";
//        ResultSet rs=getData(conectionJDBC(), sql);
//        DefaultTableModel model=new DefaultTableModel();
//        String[] title={"Mã độc giả","Mã sách","Ngày mượn","Ngày hết hạn","Trạng thái"};
//        model.setColumnIdentifiers(title);
//                String[] ar=new String[5];
//        try {
//            while(rs.next()){
//                ar[0]=rs.getString("MADOCGIA");
//                ar[1]=rs.getString("MASACH");
//                ar[2]=rs.getString("NGAYMUON");
//                ar[3]=rs.getString("NGAYHETHAN");
//                ar[4]=rs.getString("TRANGTHAI");
//                model.addRow(ar);
//            }
//            this.TableTra.setModel(model);
//        } catch (SQLException ex) {
//            Logger.getLogger(quanlimuontra.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
     public static boolean CheckDanhSachTam(JTable table,int temp,BangTamDTO bt){
         for (int i = 0; i < temp; i++) {
                if (table.getValueAt(i, 0).equals(bt.getMaSach())) {
                    //this.BThemPhieuMuon.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Đã chọn sách này");
                    return false;
                }
            }
         return true;
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        this.Run();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        this.Run();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        this.Run();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Run() {
        if (this.TextMaDocGiaTra.getText().equals("")) {
//            this.setdefaultTra();
            //this.TableTra.setModel(setDefaultTra());
            this.setdefaultTra();
//            this.TableMuon.setModel(setDefaultMuon());
        }
        if (this.TextMaDocGia.getText().equals("")) {
            this.BChoMuon.setEnabled(false);
        } else {
            this.BChoMuon.setEnabled(true);
        }
        if (this.TextTrangThaiSach.getText().equals("Chua muon")) {
            this.BThemPhieuMuon.setEnabled(true);
        } else {
            this.BThemPhieuMuon.setEnabled(false);
        }
        if (this.TextTrangThaiSach.getText().equals("")) {
            this.BThemPhieuMuon.setEnabled(false);
        }
    }
    
}
