/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly.Class;

/**
 *
 * @author Hoa
 */
public class tbbchocphi {
    
    private int malop;
    private String tenmon;
    private int soluongdk;
    private float tongtien;
    
    public tbbchocphi(int a, String b, int c, float d){
        this.malop = a;
        this.tenmon = b;
        this.soluongdk = c;
        this.tongtien = d;
    }

    @Override
    public String toString() {
        return this.getMalop() + " " + this.getTenmon();
    }

    /**
     * @return the malop
     */
    public int getMalop() {
        return malop;
    }

    /**
     * @param malop the malop to set
     */
    public void setMalop(int malop) {
        this.malop = malop;
    }

    /**
     * @return the tenmon
     */
    public String getTenmon() {
        return tenmon;
    }

    /**
     * @param tenmon the tenmon to set
     */
    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    /**
     * @return the soluongdk
     */
    public int getSoluongdk() {
        return soluongdk;
    }

    /**
     * @param soluongdk the soluongdk to set
     */
    public void setSoluongdk(int soluongdk) {
        this.soluongdk = soluongdk;
    }

    /**
     * @return the tongtien
     */
    public float getTongtien() {
        return tongtien;
    }

    /**
     * @param tongtien the tongtien to set
     */
    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
    
    
    
}
