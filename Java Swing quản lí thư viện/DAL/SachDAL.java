/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import static DAL.Database.getData;
import DTO.DocGiaDTO;
import DTO.NXBDTO;
import DTO.SachDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sam
 */
public class SachDAL {

    public ArrayList<SachDTO> layToanBoDanhSach() {
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<SachDTO> ds = new ArrayList<SachDTO>();
        try {
            String sql = " SELECT MASACH,TENSACH,TACGIA,NGONNGU,THELOAI,TENNXB,TRANGTHAI,NAMXB,TAIBAN FROM SACH,NHAXUATBAN"
                    + " WHERE  SACH.MANXB=NHAXUATBAN.MANXB";
//                 pst= conectionJDBC().prepareStatement(sql);
//		  ResultSet rs=pst.executeQuery();    
            rs = getData(conectionJDBC(), sql);
            while (rs.next()) {
                SachDTO sc = new SachDTO();
                sc.setMaSach(rs.getString(1));
                sc.setTenSach(rs.getString(2));
                sc.setTacGia(rs.getString(3));
                sc.setNgonNgu(rs.getString(4));
                sc.setTheLoai(rs.getString(5));
                sc.setTenNXB(rs.getString(6));
                sc.setTrangThai(rs.getString(7));
                sc.setNamXB(rs.getString(8));
                sc.setTaiBan(rs.getString(9));
                ds.add(sc);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ds;
    }

    public ArrayList<SachDTO> TimKiemSachTheoTen(String tensach) {
        ArrayList<SachDTO> dsSach = new ArrayList<SachDTO>();
        try {
            PreparedStatement pst;
            String sql = " SELECT MASACH,TENSACH,TACGIA,NGONNGU,THELOAI,TENNXB,TRANGTHAI,NAMXB,TAIBAN FROM SACH,NHAXUATBAN"
                    + " WHERE  SACH.MANXB=NHAXUATBAN.MANXB AND  TENSACH like ?  ";
            pst = conectionJDBC().prepareStatement(sql);
            pst.setString(1, "%" + tensach + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SachDTO s = new SachDTO();
                s.setMaSach(rs.getString(1));
                s.setTenSach(rs.getString(2));
                s.setNgonNgu(rs.getString(4));
                s.setTacGia(rs.getString(3));
                s.setTheLoai(rs.getString(5));
                s.setTenNXB(rs.getString(6));
                s.setTrangThai(rs.getString(7));
                s.setNamXB(rs.getString(8));
                s.setTaiBan(rs.getString(9));
                dsSach.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsSach;
    }

    /*COMBOBOX NHAXUATBAN*/
    public ArrayList<NXBDTO> DanhSachNhaXuatBan() {
        ArrayList<NXBDTO> dsNXB = new ArrayList<NXBDTO>();
        PreparedStatement pst;
        try {

            String sql = " SELECT * FROM NHAXUATBAN ";
            pst = conectionJDBC().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
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

    /*TIM KIEM SACH NANG CAO*/
    public ArrayList<SachDTO> TimKiemNangCao(String nxb, String tacgia) {
        PreparedStatement pst;
        ArrayList<SachDTO> dsnxb = new ArrayList<SachDTO>();
        try {

            String sql = " SELECT MASACH,TENSACH,TACGIA,NGONNGU,THELOAI,TENNXB,TRANGTHAI,TAIBAN,NAMXB FROM SACH,NHAXUATBAN"
                    + " WHERE  SACH.MANXB=NHAXUATBAN.MANXB AND TENNXB=?  AND TACGIA like ?  ";
            pst = conectionJDBC().prepareStatement(sql);
            pst.setString(1, nxb);
            pst.setString(2, "%" + tacgia + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SachDTO s = new SachDTO();
                s.setMaSach(rs.getString(1));
                s.setTenSach(rs.getString(2));
                s.setTacGia(rs.getString(3));
                s.setNgonNgu(rs.getString(4));
                s.setTheLoai(rs.getString(5));
                s.setTenNXB(rs.getString(6));
                s.setTrangThai(rs.getString(7));
                s.setTaiBan(rs.getString(8));
                s.setNamXB(rs.getString(9));
                dsnxb.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsnxb;
    }

    /*THAY DOI MAT KHAU*/
    public void doiMatKhau(String tentk, String matkhaucu, String matkhaumoi, String nhaplai) {
        PreparedStatement pst;
        try {

            String sql = "update TAIKHOAN set MATKHAU=? WHERE TENTK=?";
            pst = conectionJDBC().prepareStatement(sql);
            pst.setString(1, matkhaumoi);
            pst.setString(2, tentk);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*HIEN THI THONG TIN TIM KIEM DOC GIA THEO MADG*/
    public ArrayList<DocGiaDTO> TimKiemDocGiaTheoMaDG(String madg) {
        ArrayList<DocGiaDTO> dsDocGia = new ArrayList<DocGiaDTO>();
        PreparedStatement pst;
        try {

            String sql = " SELECT MADOCGIA ,TEN,NGAYSINH,GIOITINH,SDT,DOITUONG,EMAIL,DIACHI,LOP FROM DOCGIA" + " WHERE MADOCGIA =?  ";
            pst = conectionJDBC().prepareStatement(sql);
            pst.setString(1, madg);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DocGiaDTO sc = new DocGiaDTO();
                sc.setMaDG(rs.getString(1));
                sc.setTenDG(rs.getString(2));
                sc.setNgaySinhDG(rs.getString(3));
                sc.setGioiTinh(rs.getString(4));
                sc.setSDT(rs.getString(5));
                sc.setDoiTuong(rs.getString(6));
                sc.setDiaChi(rs.getString(8));

                sc.setEmail(rs.getString(7));
                sc.setLop(rs.getString(9));
                dsDocGia.add(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDocGia;
    }

}
