/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly.Class;

/**
 *
 * @author jacky
 */
public class tbHocBong {
    private String ten;
    private String hocki;
    private float tien;

    
    public tbHocBong(String ten, String hk, float tien){
        this.ten = ten;
        this.hocki = hk;
        this.tien = tien;
    }
    @Override
    public String toString() {
        return this.getTen().toString(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the hocki
     */
    public String getHocki() {
        return hocki;
    }

    /**
     * @param hocki the hocki to set
     */
    public void setHocki(String hocki) {
        this.hocki = hocki;
    }

    /**
     * @return the tien
     */
    public Float getTien() {
        return tien;
    }

    /**
     * @param tien the tien to set
     */
    public void setTien(Float tien) {
        this.tien = tien;
    }
    
    
    
}