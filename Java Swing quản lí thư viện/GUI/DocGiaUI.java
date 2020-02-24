/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAL.SachDAL;
import DTO.DocGiaDTO;
import DTO.NXBDTO;
import DTO.QTMuonDTO;
import java.util.ArrayList;
import DTO.SachDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sam
 */
public class DocGiaUI extends javax.swing.JFrame  implements ActionListener{
        DefaultTableModel model=new DefaultTableModel();
        String[] title={"Mã sách","Tên sách","Tác giả","Ngôn ngữ","Thể loại","Nhà xuất bản","Trạng thái","Năm XB","Tái bản"};
        private void addControls(){
            model.setColumnIdentifiers(title);
            bangsach.setModel(model);
        }
    public void HienThiDanhSachSach() {
        try {
            SachDAL sach = new SachDAL();
            dsSach = sach.layToanBoDanhSach();
            model.setRowCount(0);
            for (SachDTO sa : dsSach) {
                Vector<Object> vec = new Vector<Object>();
                vec.add(sa.getMaSach());
                vec.add(sa.getTenSach());
                vec.add(sa.getTacGia());
                vec.add(sa.getNgonNgu());
                vec.add(sa.getTheLoai());
                vec.add(sa.getTenNXB());
                vec.add(sa.getTrangThai());
                vec.add(sa.getNamXB());
                vec.add(sa.getTaiBan());
                model.addRow(vec);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    
    protected void xuLyTimKiemTheoTen() {
	
       SachDAL sach=new SachDAL();    
        dsSach=sach.TimKiemSachTheoTen(txtTenSach.getText());
        model.setRowCount(0);
    for(SachDTO sa:dsSach)			
    {
            Vector<Object>vec=new Vector<Object>();
             vec.add(sa.getMaSach());
             vec.add(sa.getTenSach());
             vec.add(sa.getTacGia());                                              
             vec.add(sa.getNgonNgu());
             vec.add(sa.getTheLoai());
             vec.add(sa.getTenNXB());                                                 
             vec.add(sa.getTrangThai());
             vec.add(sa.getNamXB());
             vec.add(sa.getTaiBan());
             model.addRow(vec);
    }
    
}
    
    
    
    protected void xuLyTimKiemTheoNXB() {
	
       SachDAL sach=new SachDAL();
        dsSach=sach.TimKiemNangCao(cBoNhaXB.getSelectedItem().toString(),txtTacGia.getText());
        model.setRowCount(0);
        for(SachDTO sa:dsSach)			
         {
            Vector<Object>vec=new Vector<Object>();
             vec.add(sa.getMaSach());
             vec.add(sa.getTenSach());
             vec.add(sa.getTacGia());                                              
             vec.add(sa.getNgonNgu());
             vec.add(sa.getTheLoai());
             vec.add(sa.getTenNXB());                                                 
             vec.add(sa.getTrangThai());
              vec.add(sa.getNamXB());
             vec.add(sa.getTaiBan());
             model.addRow(vec);
    }
        
    }
    
    
    
    /*==========================================THAYDOIMATKHAU==================================================*/
   
         public void DoiMatKhau()
      {
              try {
               SachDAL doiMK= new SachDAL();
               doiMK.doiMatKhau(txtTenTK.getText(),txtMatKhauCu.getText(),txtMatKhauMoi.getText(),txtMatKhauNhapLai.getText());
                JOptionPane.showMessageDialog(null," Đổi thành công!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "không thành công");
                e.printStackTrace();
            }
         
      }

    protected void HienThiDanhSachNhaXB() {
        SachDAL sach = new SachDAL();
        dsNhaXB = sach.DanhSachNhaXuatBan();
        // cBoNhaXB.removeAllItems();
        for (NXBDTO NXB : dsNhaXB) {
            cBoNhaXB.addItem(NXB + "");
        }

    }
    
    
    /*======================================HIENTHITHONGTINDOCGIA========================================*/
     
 public void HienThiThongTinDG(){
    try{
                  SachDAL docgia= new SachDAL();
                  dg=docgia.TimKiemDocGiaTheoMaDG(txtMaDocGia.getText());
                  model.setRowCount(0);
                    for(DocGiaDTO sa:dg)			
			{
                            
                             txtMaDocGia.setText(sa.getMaDG());
                             txtTen.setText(sa.getTenDG());
                             txtNgaySinh.setText(sa.getNgaySinhDG());                                              
                             txtGioiTinh.setText(sa.getGioiTinh());
                             txtSDT.setText(sa.getSDT());
                             txtDoiTuong.setText(sa.getDoiTuong());                                                 
                             txtEmail.setText(sa.getEmail());
                             txtDiaChi.setText(sa.getDiaChi());
                             txtLop.setText(sa.getLop());
			    
			}
                                  
            }catch(Exception ex)
		{
                  System.out.println(ex);                  
		}
     }

    ArrayList<SachDTO> dsSach;
    // ArrayList<TheLoaiDTO>dsTheLoai;
    ArrayList<QTMuonDTO> dsMuonTra;
    SachDAL docgia;
    ArrayList<DocGiaDTO> dg;
    DefaultTableModel model2;
    ArrayList<NXBDTO> dsNhaXB;
    
    
    
    
    
    
    
    

    /**
     * Creates new form DocGiaUI
     */
    public DocGiaUI() {
        initComponents();
        addControls();
        this.BThoat.addActionListener(this);
        this.BThoat1.addActionListener(this);
        this.setLocationRelativeTo(null);
        HienThiDanhSachSach();
        HienThiDanhSachNhaXB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        btnTraCuu = new javax.swing.JButton();
        btnXemTT = new javax.swing.JButton();
        btnDoiMK = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        MainPn = new javax.swing.JPanel();
        PnTraCuu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangsach = new javax.swing.JTable();
        tbnHuy = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cBoNhaXB = new javax.swing.JComboBox<>();
        txtTacGia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnTimKiemNC = new javax.swing.JButton();
        ckNXBi = new java.awt.Checkbox();
        ckTacGia = new java.awt.Checkbox();
        jLabel11 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        PnXemTT = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Bang_DocGia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtMaDocGia = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtLop = new javax.swing.JTextField();
        txtDoiTuong = new javax.swing.JTextField();
        ntbHuy = new javax.swing.JButton();
        btnDangXuat2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        PnDoiMatKhau = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtTenTK = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnDoiTK = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtMatKhauNhapLai = new javax.swing.JPasswordField();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        txtMatKhauCu = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        BThoat = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        PnGioiThieu = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        panelNoiQuy = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        panelLich = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        BThoat1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THƯ VIỆN TRƯỜNG THPT DƯỠNG ĐIỀM");

        Menu.setBackground(new java.awt.Color(0, 102, 102));

        btnTraCuu.setBackground(new java.awt.Color(0, 102, 102));
        btnTraCuu.setText("Tra cứu sách");
        btnTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuActionPerformed(evt);
            }
        });

        btnXemTT.setBackground(new java.awt.Color(0, 102, 102));
        btnXemTT.setText("Xem thông tin");
        btnXemTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTTActionPerformed(evt);
            }
        });

        btnDoiMK.setBackground(new java.awt.Color(0, 102, 102));
        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Giới thiệu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXemTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTraCuu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXemTT, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPn.setLayout(new java.awt.CardLayout());

        PnTraCuu.setLayout(null);

        jPanel2.setLayout(null);

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/tìm kiếm.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel2.add(btnTimKiem);
        btnTimKiem.setBounds(203, 189, 120, 34);

        bangsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(bangsach);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(364, 109, 594, 300);

        tbnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        tbnHuy.setText("Huỷ");
        tbnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnHuyActionPerformed(evt);
            }
        });
        jPanel2.add(tbnHuy);
        tbnHuy.setBounds(154, 448, 82, 35);

        jLabel12.setText("Tên sách");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(54, 149, 70, 15);

        txtTenSach.setMinimumSize(new java.awt.Dimension(3, 20));
        jPanel2.add(txtTenSach);
        txtTenSach.setBounds(124, 139, 180, 30);

        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm sách cơ bản\n"));
        jPanel2.add(jLabel14);
        jLabel14.setBounds(44, 109, 290, 130);

        cBoNhaXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cBoNhaXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoNhaXBActionPerformed(evt);
            }
        });
        jPanel2.add(cBoNhaXB);
        cBoNhaXB.setBounds(134, 298, 180, 30);

        txtTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTacGiaActionPerformed(evt);
            }
        });
        jPanel2.add(txtTacGia);
        txtTacGia.setBounds(134, 338, 180, 30);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("TÌM KIẾM SÁCH");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(440, 18, 210, 30);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel17.setText("Kết quả tìm kiếm");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(364, 79, 120, 20);

        btnTimKiemNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/tìm kiếm.png"))); // NOI18N
        btnTimKiemNC.setText("Tìm kiếm");
        btnTimKiemNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNCActionPerformed(evt);
            }
        });
        jPanel2.add(btnTimKiemNC);
        btnTimKiemNC.setBounds(206, 378, 110, 34);

        ckNXBi.setLabel("NhaXB\n");
        ckNXBi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckNXBiItemStateChanged(evt);
            }
        });
        jPanel2.add(ckNXBi);
        ckNXBi.setBounds(54, 298, 70, 20);

        ckTacGia.setLabel("Tác giả\n");
        ckTacGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckTacGiaItemStateChanged(evt);
            }
        });
        jPanel2.add(ckTacGia);
        ckTacGia.setBounds(54, 348, 60, 20);

        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm sách nâng cao"));
        jPanel2.add(jLabel11);
        jLabel11.setBounds(44, 268, 290, 150);

        btnReset.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\reset.png")); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset);
        btnReset.setBounds(900, 70, 59, 30);

        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel2.add(jLabel22);
        jLabel22.setBounds(30, 50, 960, 440);

        jLabel27.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\2397.jpg_wh1200.jpg")); // NOI18N
        jLabel27.setText("jLabel27");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(30, 0, 980, 600);

        PnTraCuu.add(jPanel2);
        jPanel2.setBounds(-26, -2, 1020, 540);

        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/shutdown.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        PnTraCuu.add(btnDangXuat);
        btnDangXuat.setBounds(800, 540, 120, 35);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\back.png")); // NOI18N
        jButton2.setText("Quay lại");
        PnTraCuu.add(jButton2);
        jButton2.setBounds(70, 550, 110, 34);

        MainPn.add(PnTraCuu, "card2");

        PnXemTT.setLayout(null);

        jPanel4.setLayout(null);

        Bang_DocGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        Bang_DocGia.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Nhập mã độc giả:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Học và tên");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Giới tính");

        txtMaDocGia.setForeground(new java.awt.Color(153, 153, 153));
        txtMaDocGia.setText("ENTER\n");
        txtMaDocGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaDocGiaFocusGained(evt);
            }
        });
        txtMaDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDocGiaActionPerformed(evt);
            }
        });
        txtMaDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaDocGiaKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Số điện thoại");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Địa chỉ");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Lớp");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Đối tượng");

        ntbHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        ntbHuy.setText("Huỷ");
        ntbHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntbHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Bang_DocGiaLayout = new javax.swing.GroupLayout(Bang_DocGia);
        Bang_DocGia.setLayout(Bang_DocGiaLayout);
        Bang_DocGiaLayout.setHorizontalGroup(
            Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Bang_DocGiaLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addComponent(txtTen)
                        .addComponent(txtGioiTinh))
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(202, 202, 202)
                .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDoiTuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Bang_DocGiaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ntbHuy)
                .addGap(371, 371, 371))
        );
        Bang_DocGiaLayout.setVerticalGroup(
            Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Bang_DocGiaLayout.createSequentialGroup()
                .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Bang_DocGiaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(12, 12, 12)
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Bang_DocGiaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)))
                .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Bang_DocGiaLayout.createSequentialGroup()
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addComponent(ntbHuy)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Bang_DocGiaLayout.createSequentialGroup()
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(Bang_DocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))))
        );

        jPanel4.add(Bang_DocGia);
        Bang_DocGia.setBounds(80, 120, 860, 300);

        btnDangXuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/shutdown.png"))); // NOI18N
        btnDangXuat2.setText("Đăng xuất");
        btnDangXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuat2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnDangXuat2);
        btnDangXuat2.setBounds(780, 460, 120, 35);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("XEM THÔNG TIN ĐỘC GIẢ");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(400, 40, 250, 40);

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\back.png")); // NOI18N
        jButton6.setText("Quay lại");
        jPanel4.add(jButton6);
        jButton6.setBounds(100, 460, 110, 34);

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\2397.jpg_wh1200.jpg")); // NOI18N
        jPanel4.add(jLabel24);
        jLabel24.setBounds(-10, 30, 1010, 580);

        PnXemTT.add(jPanel4);
        jPanel4.setBounds(12, -1, 997, 610);

        MainPn.add(PnXemTT, "card3");

        jPanel3.setPreferredSize(new java.awt.Dimension(1210, 400));
        jPanel3.setLayout(null);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Tên tài khoản");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(330, 150, 76, 31);

        txtTenTK.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel3.add(txtTenTK);
        txtTenTK.setBounds(450, 150, 184, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Mật khẩu cũ ");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(330, 210, 71, 22);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Mật khẩu mới");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(330, 260, 73, 25);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Nhập lại mật khẩu");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(330, 300, 97, 26);

        btnDoiTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/thay đổi.png"))); // NOI18N
        btnDoiTK.setText("Thay đổi");
        btnDoiTK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        btnDoiTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTKActionPerformed(evt);
            }
        });
        jPanel3.add(btnDoiTK);
        btnDoiTK.setBounds(409, 360, 100, 30);

        btnHuy.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\reset.png")); // NOI18N
        btnHuy.setText("Huỷ");
        btnHuy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel3.add(btnHuy);
        btnHuy.setBounds(637, 356, 90, 30);

        txtMatKhauNhapLai.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel3.add(txtMatKhauNhapLai);
        txtMatKhauNhapLai.setBounds(450, 300, 184, 30);

        txtMatKhauMoi.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel3.add(txtMatKhauMoi);
        txtMatKhauMoi.setBounds(450, 250, 184, 30);

        txtMatKhauCu.setMinimumSize(new java.awt.Dimension(5, 20));
        txtMatKhauCu.setPreferredSize(new java.awt.Dimension(5, 20));
        jPanel3.add(txtMatKhauCu);
        txtMatKhauCu.setBounds(450, 200, 184, 30);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("ĐỔI MẬT KHẨU TÀI KHOẢN");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(390, 70, 257, 42);

        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        jPanel3.add(jLabel15);
        jLabel15.setBounds(120, 120, 770, 310);

        BThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/shutdown.png"))); // NOI18N
        BThoat.setText("Đăng xuất");
        BThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BThoatActionPerformed(evt);
            }
        });
        jPanel3.add(BThoat);
        BThoat.setBounds(790, 480, 120, 35);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\back.png")); // NOI18N
        jButton4.setText("Quay lại");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(190, 500, 110, 34);

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\2397.jpg_wh1200.jpg")); // NOI18N
        jPanel3.add(jLabel23);
        jLabel23.setBounds(-10, 0, 1020, 580);

        javax.swing.GroupLayout PnDoiMatKhauLayout = new javax.swing.GroupLayout(PnDoiMatKhau);
        PnDoiMatKhau.setLayout(PnDoiMatKhauLayout);
        PnDoiMatKhauLayout.setHorizontalGroup(
            PnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnDoiMatKhauLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PnDoiMatKhauLayout.setVerticalGroup(
            PnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        MainPn.add(PnDoiMatKhau, "card4");

        panelNoiQuy.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("NỘI QUY THƯ VIỆN\n\n​Nhằm xây dựng môi trường học tập, nghiên cứu thân thiện, tiện lợi và văn minh, mỗi người khi vào Thư viện cần thực hiện các nội quy sau: \n\n     1.  Xuất trình thẻ cán bộ / thẻ sinh viên / thẻ học viên / thẻ thư viện để thực hiện các thủ tục cần thiết. Tuyệt đối không dùng thẻ của người khác, không cho người khác mượn thẻ.\n \n     2. Gửi túi xách, vật dụng cá nhân theo đúng nơi quy định. Bạn đọc tự bảo quản những tư trang cá nhân có giá trị, Thư viện không chịu trách nhiệm bảo quản tài sản cá nhân, tư trangcủa bạn đọc.\n \n     3. Không ồn ào, mất trật tự trong phạm vi Thư viện.\n \n     4. Giữ gìn vệ sinh chung. Không mang thức ăn, nước uống vào Thư viện.\n \n     5. Thực hiện và nhắc nhở người khác trong việc giữ gìn tài liệu, trang thiết bị của Thư viện.\n \n     6. Không được tráo đổi, tự ý di chuyển trang thiết bị của Thư viện khi chưa được cho phép.\n \n     7. Không được mang ra khỏi Thư viện các tài liệu: sách, giáo trình, báo, tạp chí, băng đĩa, luận văn, luận án,…nếu chưa thông qua thủ tục mượn.\n \n     8. Tuân thủ luật bản quyền khi sử dụng các tài liệu của Thư viện.\n \n     9. Tuân thủ các quy định, hướng dẫn khác của Thư viện và nội quy cơ quan Trường ĐH CNTT.\n \n     10. Cán bộ, nhân viên Thư viện phải có thái độ hòa nhã, tác phong làm việc khoa học, tận tình phục vụ và giúp đỡ bạn đọc khi cần thiết.");
        jScrollPane2.setViewportView(jTextArea1);

        panelNoiQuy.add(jScrollPane2);
        jScrollPane2.setBounds(12, 12, 975, 420);

        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\2397.jpg_wh1200.jpg")); // NOI18N
        panelNoiQuy.add(jLabel26);
        jLabel26.setBounds(0, 0, 1040, 550);

        jTabbedPane3.addTab("Nội quy thư viện", panelNoiQuy);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("LỊCH PHỤC VỤ\n\n\n\nThư viện đi vào hoạt động từ ngày 18/09/2012 và phục vụ từ thứ Hai đến thứ Bảy. \n \n\nThứ Hai đến thứ Sáu: \n\n+  Thời gian mở cửa phục vụ:  7 giờ 30\n\n+  Thời gian hết giờ phục vụ:  16 giờ 30 \n \n\nThứ Bảy:\n\n+  Thời gian mở cửa phục vụ:  8 giờ 00\n\n+  Thời gian hết giờ phục vụ:  16 giờ 00\n \n\n- Thư viện phục vụ luôn buổi trưa.\n- Thư viện không phục vụ vào ngày lễ, tết theo quy định và các ngày nghỉ đột xuất khác (có thông báo).");
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout panelLichLayout = new javax.swing.GroupLayout(panelLich);
        panelLich.setLayout(panelLichLayout);
        panelLichLayout.setHorizontalGroup(
            panelLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        panelLichLayout.setVerticalGroup(
            panelLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLichLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Lịch phục vụ", panelLich);

        BThoat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/shutdown.png"))); // NOI18N
        BThoat1.setText("Đăng xuất");
        BThoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BThoat1ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\thuvienduongdiem_12_6_2019\\database\\src\\Icon\\back.png")); // NOI18N
        jButton5.setText("Quay lại");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnGioiThieuLayout = new javax.swing.GroupLayout(PnGioiThieu);
        PnGioiThieu.setLayout(PnGioiThieuLayout);
        PnGioiThieuLayout.setHorizontalGroup(
            PnGioiThieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnGioiThieuLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BThoat1)
                .addGap(68, 68, 68))
            .addGroup(PnGioiThieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnGioiThieuLayout.setVerticalGroup(
            PnGioiThieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnGioiThieuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane3)
                .addGap(18, 18, 18)
                .addGroup(PnGioiThieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BThoat1)
                    .addComponent(jButton5))
                .addGap(34, 34, 34))
        );

        MainPn.add(PnGioiThieu, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(136, Short.MAX_VALUE)
                    .addComponent(MainPn, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(MainPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuActionPerformed
        // TODO add your handling code here:
        MainPn.removeAll();
        MainPn.repaint();
        MainPn.revalidate();
        MainPn.add(PnTraCuu);
        MainPn.repaint();
    }//GEN-LAST:event_btnTraCuuActionPerformed

    private void btnXemTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTTActionPerformed
        // TODO add your handling code here:
        MainPn.removeAll();
        MainPn.repaint();
        MainPn.revalidate();
        MainPn.add(PnXemTT);
        MainPn.repaint();
    }//GEN-LAST:event_btnXemTTActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        // TODO add your handling code here:
        MainPn.removeAll();
        MainPn.repaint();
        MainPn.revalidate();
        MainPn.add(PnDoiMatKhau);
        MainPn.repaint();
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MainPn.removeAll();
        MainPn.repaint();
        MainPn.revalidate();
        MainPn.add(PnGioiThieu);
        MainPn.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

        xuLyTimKiemTheoTen();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void tbnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnHuyActionPerformed
        // TODO add your handling code here:y
        // HienThiDanhSachSach();
        txtTenSach.setText("");
        txtTacGia.setText("");
        //CBoTheLoai.setSelectedItem(1);
        txtTenSach.requestFocus();
    }//GEN-LAST:event_tbnHuyActionPerformed

    private void cBoNhaXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoNhaXBActionPerformed

        if (cBoNhaXB.getSelectedIndex() == -1) {
            return;
        }
        //         if(CBoTheLoai.getSelectedIndex()==1){
        //       HienThiDanhSachSach();
        //      }

        xuLyTimKiemTheoNXB();
    }//GEN-LAST:event_cBoNhaXBActionPerformed

    private void txtTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTacGiaActionPerformed

    private void btnTimKiemNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNCActionPerformed
        // TODO add your handling code here:
        xuLyTimKiemTheoNXB();
        //xuLyTimKiemTheoTacGia();
    }//GEN-LAST:event_btnTimKiemNCActionPerformed

    private void ckNXBiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckNXBiItemStateChanged
        // TODO add your handling code here:
        if (evt.getItemSelectable() == ckNXBi);
        xuLyTimKiemTheoNXB();
    }//GEN-LAST:event_ckNXBiItemStateChanged

    private void ckTacGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckTacGiaItemStateChanged

        if (evt.getItemSelectable() == ckTacGia);
        // xuLyTimKiemTheoTacGia();
    }//GEN-LAST:event_ckTacGiaItemStateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        HienThiDanhSachSach();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtMaDocGiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaDocGiaFocusGained
        // TODO add your handling code here:
        txtMaDocGia.getText().equals("ENTER");
        txtMaDocGia.setText("");
    }//GEN-LAST:event_txtMaDocGiaFocusGained

    private void txtMaDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDocGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDocGiaActionPerformed

    private void txtMaDocGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaDocGiaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            HienThiThongTinDG();
        }
    }//GEN-LAST:event_txtMaDocGiaKeyPressed

    private void ntbHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntbHuyActionPerformed
        // TODO add your handling code here:
        txtMaDocGia.setText("");
        txtTen.setText("");
        txtNgaySinh.setText("");
        txtGioiTinh.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtDoiTuong.setText("");
        txtEmail.setText("");
        txtLop.setText("");
        txtMaDocGia.requestFocus();
    }//GEN-LAST:event_ntbHuyActionPerformed

    private void btnDangXuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuat2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnDangXuat2ActionPerformed

    private void btnDoiTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTKActionPerformed
        // TODO add your handling code here:
        DoiMatKhau();
    }//GEN-LAST:event_btnDoiTKActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        // System.exit(0);
        txtTenTK.setText("");
        txtMatKhauCu.setText("");
        txtMatKhauMoi.setText("");
        txtMatKhauNhapLai.setText("");
        txtTenTK.requestFocus();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new MenuDocGia().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BThoatActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         new MenuDocGia().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BThoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BThoat1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BThoat1ActionPerformed
//    public void HienThiDanhSachSach() {
//        try {
//           SachDAL sach = new SachDAL();
//            dsSach = sach.layToanBoDanhSach();
//            model.setRowCount(0);
//            for (SachDTO sa : dsSach) {
//                Vector<Object> vec = new Vector<Object>();
//                vec.add(sa.getMaSach());
//                vec.add(sa.getTenSach());
//                vec.add(sa.getTacGia());
//                vec.add(sa.getNgonNgu());
//                vec.add(sa.getTheLoai());
//                vec.add(sa.getTenNXB());
//                vec.add(sa.getTrangThai());
//                vec.add(sa.getNamXB());
//                vec.add(sa.getTaiBan());
//                model.addRow(vec);
//            }
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//    }
//
//    ...
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
            java.util.logging.Logger.getLogger(DocGiaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocGiaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocGiaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocGiaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocGiaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BThoat;
    private javax.swing.JButton BThoat1;
    private javax.swing.JPanel Bang_DocGia;
    private javax.swing.JPanel MainPn;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel PnDoiMatKhau;
    private javax.swing.JPanel PnGioiThieu;
    private javax.swing.JPanel PnTraCuu;
    private javax.swing.JPanel PnXemTT;
    private javax.swing.JTable bangsach;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDangXuat2;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnDoiTK;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiemNC;
    private javax.swing.JButton btnTraCuu;
    private javax.swing.JButton btnXemTT;
    private javax.swing.JComboBox<String> cBoNhaXB;
    private java.awt.Checkbox ckNXBi;
    private java.awt.Checkbox ckTacGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton ntbHuy;
    private javax.swing.JPanel panelLich;
    private javax.swing.JPanel panelNoiQuy;
    private javax.swing.JButton tbnHuy;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDoiTuong;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMaDocGia;
    private javax.swing.JPasswordField txtMatKhauCu;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private javax.swing.JPasswordField txtMatKhauNhapLai;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenTK;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(BThoat1)){
            System.exit(0);
        }
        if(ae.getSource().equals(BThoat)){
            System.exit(0);
        }
        if(ae.getSource().equals(btnDangXuat2)){
            System.exit(0);
        }
        if(ae.getSource().equals(btnDangXuat)){
            System.exit(0);
        }
        
    }
}
