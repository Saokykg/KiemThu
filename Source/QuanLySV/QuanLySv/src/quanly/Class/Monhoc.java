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
public class Monhoc {
    private int id;
    private String ten;
    private int tinchi;
    private float hocphi;
    private int soluong;
    
    public Monhoc(int id, String ten, int tinchi, float hp, int sl){
        this.id = id;
        this.ten = ten;
        this.tinchi = tinchi;
        this.hocphi = hp;
        this.soluong = sl;
    }

    @Override
    public String toString() {
        return this.ten; //To change body of generated methods, choose Tools | Templates.
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
     * @return the tinchi
     */
    public int getTinchi() {
        return tinchi;
    }

    /**
     * @param tinchi the tinchi to set
     */
    public void setTinchi(int tinchi) {
        this.tinchi = tinchi;
    }

    /**
     * @return the hocphi
     */
    public float getHocphi() {
        return hocphi;
    }

    /**
     * @param hocphi the hocphi to set
     */
    public void setHocphi(float hocphi) {
        this.hocphi = hocphi;
    }

    /**
     * @return the soluong
     */
    public int getSoluong() {
        return soluong;
    }

    /**
     * @param soluong the soluong to set
     */
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
