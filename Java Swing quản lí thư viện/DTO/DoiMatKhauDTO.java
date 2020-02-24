/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author sam
 */
public class DoiMatKhauDTO {
     private String TenTK;
    private String MatKhau;
    private String MatKhauMoi;
    private String NhapLaiMatKhauMoi;

    public String getTenTK() {
        return TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getMatKhauMoi() {
        return MatKhauMoi;
    }

    public String getNhapLaiMatKhauMoi() {
        return NhapLaiMatKhauMoi;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setMatKhauMoi(String MatKhauMoi) {
        this.MatKhauMoi = MatKhauMoi;
    }

    public void setNhapLaiMatKhauMoi(String NhapLaiMatKhauMoi) {
        this.NhapLaiMatKhauMoi = NhapLaiMatKhauMoi;
    }

    public DoiMatKhauDTO(String TenTK, String MatKhau, String MatKhauMoi, String NhapLaiMatKhauMoi) {
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.MatKhauMoi = MatKhauMoi;
        this.NhapLaiMatKhauMoi = NhapLaiMatKhauMoi;
    }

    public DoiMatKhauDTO() {
    }
}
