/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.DoiMatKhauDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
public class DoiMatKhauDAL {
   public boolean DoiMatKhau(DoiMatKhauDTO doi){
       String sql="SELECT * FROM TAIKHOAN WHERE TENTK='"+doi.getTenTK()+"' AND MATKHAU='"+doi.getMatKhau()+"'";
       ResultSet rs=Database.getData(conectionJDBC(), sql);
       int temp=0;
       try {
           while(rs.next()){
               temp=1;
           }
       } catch (SQLException ex) {
           Logger.getLogger(DoiMatKhauDAL.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(temp==0){
           JOptionPane.showMessageDialog(null, "Tên hoặc mật khẩu sai");
       }else{
           if(doi.getMatKhauMoi().equals(doi.getNhapLaiMatKhauMoi())){
               String sqldoi="UPDATE TAIKHOAN SET MATKHAU='"+doi.getNhapLaiMatKhauMoi()+"' WHERE TENTK='"+doi.getTenTK()+"' AND MATKHAU='"+doi.getMatKhau()+"'";
               try {
                   PreparedStatement st=conectionJDBC().prepareStatement(sqldoi);
                   JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
                   return st.execute();
               } catch (SQLException ex) {
                   Logger.getLogger(DoiMatKhauDAL.class.getName()).log(Level.SEVERE, null, ex);
               }
           }else{
               JOptionPane.showMessageDialog(null, "Mật khẩu mới với nhập lại mật khẩu không giống nhau");
               return false;
           }
       }
       return false;
   }
    
}
