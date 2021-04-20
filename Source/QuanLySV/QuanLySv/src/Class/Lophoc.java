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
public class Lophoc {
    private int id;
    private int id_mon;
    private String ngay_bd;
    private String ngay_kt;
    private int id_hk;
    private int sl_dk;
    private int ca;
    
    public Lophoc(int id, int idm, String bd, String kt,
                int idhk, int sldk, int ca){
        this.setId(id);
        this.setId_mon(idm);
        this.setNgay_bd(bd);
        this.setNgay_kt(kt);
        this.setId_hk(idhk);
        this.setSl_dk(sldk);
        this.setCa(ca);
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
     * @return the id_mon
     */
    public int getId_mon() {
        return id_mon;
    }

    /**
     * @param id_mon the id_mon to set
     */
    public void setId_mon(int id_mon) {
        this.id_mon = id_mon;
    }

    /**
     * @return the ngay_bd
     */
    public String getNgay_bd() {
        return ngay_bd;
    }

    /**
     * @param ngay_bd the ngay_bd to set
     */
    public void setNgay_bd(String ngay_bd) {
        this.ngay_bd = ngay_bd;
    }

    /**
     * @return the ngay_kt
     */
    public String getNgay_kt() {
        return ngay_kt;
    }

    /**
     * @param ngay_kt the ngay_kt to set
     */
    public void setNgay_kt(String ngay_kt) {
        this.ngay_kt = ngay_kt;
    }

    /**
     * @return the id_hk
     */
    public int getId_hk() {
        return id_hk;
    }

    /**
     * @param id_hk the id_hk to set
     */
    public void setId_hk(int id_hk) {
        this.id_hk = id_hk;
    }

    /**
     * @return the sl_dk
     */
    public int getSl_dk() {
        return sl_dk;
    }

    /**
     * @param sl_dk the sl_dk to set
     */
    public void setSl_dk(int sl_dk) {
        this.sl_dk = sl_dk;
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
}
