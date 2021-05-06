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
    private int stt;
    private String ten;
    private String mucdo;
    private String hocki;
    private float tien;

    
    public tbHocBong(String ten, String hk, float tien){
        this.ten = ten;
        this.hocki = hk;
        this.tien = tien;
    }
    public tbHocBong(int stt, String ten, String mucdo, float tien){
        this.stt = stt;
        this.ten = ten;
        this.mucdo = mucdo;
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

    /**
     * @return the stt
     */
    public int getStt() {
        return stt;
    }

    /**
     * @param stt the stt to set
     */
    public void setStt(int stt) {
        this.stt = stt;
    }

    /**
     * @return the mucdo
     */
    public String getMucdo() {
        return mucdo;
    }

    /**
     * @param mucdo the mucdo to set
     */
    public void setMucdo(String mucdo) {
        this.mucdo = mucdo;
    }
    
    
    
}
