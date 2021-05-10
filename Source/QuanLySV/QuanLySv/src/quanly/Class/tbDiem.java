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
public class tbDiem {

    private String mssv;
    private String ten;
    private String mon;
    private float diem_gk;
    private float diem_ck;
    private float tile;
    /**
     * @return the mssv
     */
    public tbDiem(String mssv, String ten, String mon, float gk, float ck, float tile){
        this.mssv = mssv;
        this.ten = ten;
        this.mon = mon;
        this.diem_ck = ck;
        this.diem_gk = gk;
        this.tile = tile;
    }
    
    public String getMssv() {
        return mssv;
    }

    /**
     * @param mssv the mssv to set
     */
    public void setMssv(String mssv) {
        this.mssv = mssv;
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
     * @return the Mon
     */
    public String getMon() {
        return mon;
    }

    /**
     * @param Mon the Mon to set
     */
    public void setMon(String Mon) {
        this.mon = Mon;
    }

    /**
     * @return the diem_gk
     */
    public float getDiem_gk() {
        return diem_gk;
    }

    /**
     * @param diem_gk the diem_gk to set
     */
    public void setDiem_gk(float diem_gk) {
        this.diem_gk = diem_gk;
    }

    /**
     * @return the diem_ck
     */
    public float getDiem_ck() {
        return diem_ck;
    }

    /**
     * @param diem_ck the diem_ck to set
     */
    public void setDiem_ck(float diem_ck) {
        this.diem_ck = diem_ck;
    }

    /**
     * @return the tile
     */
    public float getTile() {
        return tile;
    }

    /**
     * @param tile the tile to set
     */
    public void setTile(float tile) {
        this.tile = tile;
    }
    
    
}
