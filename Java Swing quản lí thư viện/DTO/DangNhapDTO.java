/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class DangNhapDTO implements Serializable{
    private String TENDN;
    private String MATKHAU;
    private String LoaiTK;

    public String getLoaiTK() {
        return LoaiTK;
    }

    public void setLoaiTK(String LoaiTK) {
        this.LoaiTK = LoaiTK;
    }

    public DangNhapDTO(String TENDN, String MATKHAU, String LoaiTK) {
        this.TENDN = TENDN;
        this.MATKHAU = MATKHAU;
        this.LoaiTK = LoaiTK;
    }

    public DangNhapDTO() {
    }
    

    /**
     * @return the TENDN
     */
    public String getTENDN() {
        return TENDN;
    }

    /**
     * @param TENDN the TENDN to set
     */
    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    /**
     * @return the MATKHAU
     */
    public String getMATKHAU() {
        return MATKHAU;
    }

    /**
     * @param MATKHAU the MATKHAU to set
     */
    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    /**
     * @return the tenDN
     */
}