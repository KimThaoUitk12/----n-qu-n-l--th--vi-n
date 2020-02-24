/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.DangNhapDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sam
 */
public class ThuThuDangNhapDAL {
    public DangNhapDTO DangNhap(String tendn,String matkhau)
    {
        PreparedStatement pst;
        DangNhapDTO account= null;
        try {
           // String sql="select * from TAIKHOAN, DOCGIA where TAIKHOAN.TENTK=DOCGIA.MADOCGIA and TENTK=? and MATKHAU=?";
            String sql="select * from TAIKHOAN WHERE LOAITK='thu thu' and TENTK=? and MATKHAU=?";
           pst= conectionJDBC().prepareStatement(sql);
            pst.setString(1, tendn);
            pst.setString(2, matkhau);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                account=new DangNhapDTO();
                account.setTENDN(rs.getString(1));
                account.setMATKHAU(rs.getString(2));
                account.setLoaiTK(rs.getString("LOAITK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return account;       

    }
}
