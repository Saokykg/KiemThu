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
public class Hocbong {
    private int id;
    private String ten;
    private int hocki;
    
    public Hocbong(int id, String ten, int hocki){
        this.id = id;
        this.ten = ten;
        this.hocki = hocki;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
    public int getHocki() {
        return hocki;
    }

    /**
     * @param hocki the hocki to set
     */
    public void setHocki(int hocki) {
        this.hocki = hocki;
    }
}
