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
public class TheThuVienDTO {
    private String MaThe;
    private String NgayBD;
    private String NgayHetHan;
    private String GhiChu;

    public String getMaThe() {
        return MaThe;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setMaThe(String MaThe) {
        this.MaThe = MaThe;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public void setNgayHetHan(String NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public TheThuVienDTO(String MaThe, String NgayBD, String NgayHetHan, String GhiChu) {
        this.MaThe = MaThe;
        this.NgayBD = NgayBD;
        this.NgayHetHan = NgayHetHan;
        this.GhiChu = GhiChu;
    }

    public TheThuVienDTO() {
        
    }
    
}
