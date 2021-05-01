/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly.Class;

import MainSource.Utils;
import java.text.ParseException;

/**
 *
 * @author jacky
 */
public class tbLopHoc {
    
    private int id;
    private String mon;
    private String bd;
    private String kt;
    private String thu;
    private int ca;
    private int tinchi;
    private float hocphi;
    /**
     * @return the mon
     */
    public tbLopHoc(int id, String mon, String bd, String kt, int ca) throws ParseException{
        this.id = id;
        this.mon= mon;
        this.bd = bd;
        this.kt = kt;
        this.ca = ca;
        this.thu = Utils.getthu(Utils.todatetime(bd));
    }
    public tbLopHoc(int id, String mon, int tc, float hocphi) throws ParseException{
        this.id = id;
        this.mon= mon;
        this.tinchi = tc;
        this.hocphi = hocphi;
    }

    @Override
    public String toString() {
        return this.mon; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getMon() {
        return mon;
    }

    /**
     * @param mon the mon to set
     */
    public void setMon(String mon) {
        this.mon = mon;
    }

    /**
     * @return the bd
     */
    public String getBd() {
        return bd;
    }

    /**
     * @param bd the bd to set
     */
    public void setBd(String bd) {
        this.bd = bd;
    }

    /**
     * @return the kt
     */
    public String getKt() {
        return kt;
    }

    /**
     * @param kt the kt to set
     */
    public void setKt(String kt) {
        this.kt = kt;
    }

    /**
     * @return the thu
     */
    public String getThu() {
        return thu;
    }

    /**
     * @param thu the thu to set
     */
    public void setThu(String thu) {
        this.thu = thu;
    }

    /**
     * @return the ca
     */
    public int getCa() {
        return ca;
    }

    /**
     * @param ca the ca to set
     */
    public void setCa(int ca) {
        this.ca = ca;
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

    
}
           