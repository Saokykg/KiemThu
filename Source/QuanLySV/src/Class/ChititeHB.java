/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author jacky
 */
public class ChititeHB {
    
    private int id;
    private int id_hb;
    private String ten;
    private int soluong;
    private float tienthuong;
    
    public ChititeHB(int id, int idhb, String ten, int sl, float tien){
        this.id = id;
        this.id_hb = idhb;
        this.ten = ten;
        this.soluong = sl;
        this.tienthuong = tien;
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
     * @return the id_hb
     */
    public int getId_hb() {
        return id_hb;
    }

    /**
     * @param id_hb the id_hb to set
     */
    public void setId_hb(int id_hb) {
        this.id_hb = id_hb;
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

    /**
     * @return the tienthuong
     */
    public float getTienthuong() {
        return tienthuong;
    }

    /**
     * @param tienthuong the tienthuong to set
     */
    public void setTienthuong(float tienthuong) {
        this.tienthuong = tienthuong;
    }
    
}
