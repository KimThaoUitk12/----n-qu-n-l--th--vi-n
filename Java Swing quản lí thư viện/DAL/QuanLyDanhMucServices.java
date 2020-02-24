/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.NXBDTO;
import DTO.SachDTO;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static DAL.Database.getData;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuanLyDanhMucServices {

    PreparedStatement pst;
    ResultSet rs;
    CallableStatement call;


    /*DANH SÁCH BẢNG SÁCH*/
    public ArrayList<SachDTO> layToanBoSach() {
        ArrayList<SachDTO> ds = new ArrayList<SachDTO>();
        try {

            String sql = " SELECT MASACH,THELOAI,MANHAP,MANXB,TENSACH,TACGIA,NAMXB,TRANGTHAI,NGONNGU,TAIBAN FROM SACH";

            pst = conectionJDBC().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
               SachDTO sc=new SachDTO();
			     sc.setMaSach(rs.getString(1));
                               sc.setTheLoai(rs.getString(2));
                                sc.setMaNhap(rs.getString(3)); 
                                  sc.setMaNXB(rs.getString(4)); 
                             sc.setTenSach(rs.getString(5));
                             sc.setTacGia(rs.getString(6));   
                           sc.setNamXB(rs.getString(7));
                               sc.setTrangThai(rs.getString(8));
                             sc.setNgonNgu(rs.getString(9));
                            sc.setTaiBan(rs.getString(10));

                ds.add(sc);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ds;

    }

    /*TÌM KIẾM SÁCH */
    public ArrayList<SachDTO> TimKiemSachTheoTen(String tensach, String tacgia, String theloai, String manxb,
            String manhap, String trangthai,String namxb,  String ngongu,String taiban     ) 
    {
        ArrayList<SachDTO> dsSach = new ArrayList<SachDTO>();
        try {

            String sql = " SELECT MASACH,THELOAI,MANHAP,MANXB,TENSACH,TACGIA,NAMXB,TRANGTHAI,NGONNGU,TAIBAN FROM SACH"
                    + " WHERE TENSACH like ? and THELOAI like ? and MANHAP like ?"
                    + "and MANXB like ? and TACGIA like ? and NAMXB like ?"
                    + "and TRANGTHAI like ? and NGONNGU like ? and TAIBAN like ? ";
            pst = conectionJDBC().prepareStatement(sql);
            pst.setString(1, "%" + tensach + "%");
            pst.setString(2, "%" + theloai + "%");
            pst.setString(3, "%" + manhap + "%");
            pst.setString(4, "%" + manxb + "%");
            pst.setString(5, "%" + tacgia + "%");
            pst.setString(6, "%" + namxb + "%");
            pst.setString(7, "%" + trangthai + "%");
            pst.setString(8, "%" + ngongu + "%");
            pst.setString(9, "%" + taiban + "%");

            rs = pst.executeQuery();
            while (rs.next()) {
                SachDTO sc = new SachDTO();
                      sc.setMaSach(rs.getString(1));
                      sc.setTheLoai(rs.getString(2));
                      sc.setMaNhap(rs.getString(3)); 
                      sc.setMaNXB(rs.getString(4)); 
                      sc.setTenSach(rs.getString(5));
                      sc.setTacGia(rs.getString(6));   
                      sc.setNamXB(rs.getString(7));
                      sc.setTrangThai(rs.getString(8));
                      sc.setNgonNgu(rs.getString(9));
                      sc.setTaiBan(rs.getString(10));
                dsSach.add(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsSach;
    }

    /*XOÁ SÁCH*/
    public void xoaSach(String ma) {
        try {
//            String sql = "delete from SACH where MASACH=?";
//            pst = conectionJDBC().prepareStatement(sql);
//            pst.setString(1, ma);
//            pst.execute();
            String sql="{call SP_XOASACH(?)}";
            CallableStatement st=conectionJDBC().prepareCall(sql);
            st.setString(1, ma);
            st.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*THÊM SÁCH*/
         public void themSach( String theloai, String manhap,String manxb,String tensach,
                              String tentg, String namxb,String trangthai, String ngonngu, String taiban)
         {
        try {
            String sql="INSERT INTO SACH(THELOAI,MANHAP,MANXB,TENSACH,TACGIA,NAMXB,TRANGTHAI,NGONNGU,TAIBAN)VALUES(?,?,?,?,?,?,?,?,?) ";
            //call=conn.prepareCall("{call THUVIEN.SP_THEMNXB(?,?,?,?) }");
             pst=conectionJDBC().prepareStatement(sql); 
                           // pst.setString(1,ma);
                            pst.setString(1,theloai);
                            pst.setString(2,manhap);
                            pst.setString(3,manxb);                         
                            pst.setString(4,tensach);
                            pst.setString(5,tentg);
                            pst.setString(6,namxb);
                            //callStatement.setInt(2, Integer.parseInt(txtNamXuatBan.getText()));
                            pst.setString(7,trangthai);   
                            pst.setString(8,ngonngu); 
                            pst.setString(9,taiban); 
                rs=pst.executeQuery();

        } catch (SQLException ex) {
           ex.printStackTrace();
        }
			
         }

    /*CẠP NHẬT SÁCH*/
    public void suaSach(String ma, String theloai, String manhap, String manxb, String tensach,
            String tentg, String namxb, String trangthai, String ngonngu, String taiban) {
        try {

            String sql = "update SACH set THELOAI=?,MANHAP=?,MANXB=?,TENSACH=?,TACGIA=?,NAMXB=?,TRANGTHAI=?, NGONNGU=?, TAIBAN=? WHERE MASACH=?  ";
            pst = conectionJDBC().prepareStatement(sql);
            pst.setString(10, ma);
            pst.setString(1, theloai);
            pst.setString(2, manhap);
            pst.setString(3, manxb);
            pst.setString(4, tensach);
            pst.setString(5, tentg);
            pst.setString(6, namxb);
            pst.setString(7, trangthai);
            pst.setString(8, ngonngu);
            pst.setString(9, taiban);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*BANG DANH SÁCH NXB*/
    public ArrayList<NXBDTO> LayToanBoctNhaXB() {
        ArrayList<NXBDTO> dsNXB = new ArrayList<NXBDTO>();
        try {

            String sql = " SELECT * FROM NHAXUATBAN ";
            pst = conectionJDBC().prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                NXBDTO tl = new NXBDTO();
                tl.setMaNXB(rs.getString(1));
                tl.setTenNXB(rs.getString(2));
                tl.setDiaChi(rs.getString(3));
                tl.setSDT(rs.getString(4));
                dsNXB.add(tl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsNXB;
    }

    /*DANHSACH COMBOBOX NHÀ XUẤT BẢN*/
    public ArrayList<NXBDTO> DanhSachNhaXuatBan() {
        ArrayList<NXBDTO> dsNXB = new ArrayList<NXBDTO>();
        try {

            String sql = " SELECT * FROM NHAXUATBAN ";
            pst = conectionJDBC().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NXBDTO tl = new NXBDTO();
                tl.setTenNXB(rs.getString(2));
                dsNXB.add(tl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsNXB;
    }

    /*TÌM KIẾM THEO MAX NXB*/
    public ArrayList<NXBDTO> TimKiemNXBTheoTen(String ten) {
        ArrayList<NXBDTO> ds= new ArrayList<NXBDTO>();
        try {

            String sql = " SELECT * FROM NHAXUATBAN " + "WHERE TENNXB like ?";
            pst = conectionJDBC().prepareStatement(sql);
            pst.setString(1, "%"+ten+"%");
            rs = pst.executeQuery();
            while (rs.next()) {
                NXBDTO tl = new NXBDTO();
                tl.setMaNXB(rs.getString(1));
                tl.setTenNXB(rs.getString(2));
                tl.setDiaChi(rs.getString(3));
                tl.setSDT(rs.getString(4));
                ds.add(tl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    /*THÊM NHÀ XU?T B?N*/
  public void themNXB( String tennxb, String diachi,String sdt)
         {
        try {
            String sql="INSERT INTO NHAXUATBAN(TENNXB, DIACHI,SDT)VALUES(?,?,?) ";
            //call=conn.prepareCall("{call THUVIEN.SP_THEMNXB(?,?,?,?) }");
             pst=conectionJDBC().prepareStatement(sql); 
                            
                            //pst.setString(1,manxb);
                            pst.setString(1,tennxb);
                            pst.setString(2,diachi);
                            pst.setString(3,sdt);          
                   rs=pst.executeQuery();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
			
 }

    /*XOÁ NHÀ XUẤT BẢN*/
    public void xoaNXB(String ma) {
        String getmasach = "select masach from sach where manxb='" + ma + "'";
        ArrayList<String> ar = new ArrayList<>();
        ResultSet rs = getData(conectionJDBC(), getmasach);
        try {
            while (rs.next()) {
                ar.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyDanhMucServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<ar.size();i++){
            String sqltemp="delete from phieumuon where masach='"+ar.get(i)+"'";
            try {
                pst=conectionJDBC().prepareStatement(sqltemp);
                pst.execute();
                sqltemp="delete from phieuphat where masach='"+ar.get(i)+"'";
                pst=conectionJDBC().prepareStatement(sqltemp);
                pst.execute();
                sqltemp="delete from qtmuon where masach='"+ar.get(i)+"'";
                pst=conectionJDBC().prepareStatement(sqltemp);
                pst.execute();
                sqltemp="delete from sach where masach='"+ar.get(i)+"'";
                pst=conectionJDBC().prepareStatement(sqltemp);
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyDanhMucServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            String sqlnxb = "delete from NHAXUATBAN where MANXB=?";
            pst = conectionJDBC().prepareStatement(sqlnxb);
            pst.setString(1, ma);
            pst.execute();
            sqlnxb = "delete from phieunhapsach where MANXB=?";
            pst = conectionJDBC().prepareStatement(sqlnxb);
            pst.setString(1, ma);
            pst.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*CẬP NHẬT NHÀ XUẤT BẢN*/
    public void suaNXB(String manxb, String tennxb, String diachi, String sdt) {
        try {

            String sql = "update NHAXUATBAN set TENNXB=?,DIACHI=?,SDT=? WHERE MANXB=?  ";
            pst = conectionJDBC().prepareStatement(sql);

            pst.setString(1, tennxb);
            pst.setString(2, diachi);
            pst.setString(3, sdt);
            pst.setString(4, manxb);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
