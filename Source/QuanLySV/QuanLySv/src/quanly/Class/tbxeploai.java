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
public class tbxeploai {
    
    private int mssv;
    private String ten;
    private String diem;
    private String xeploai;
    
    public tbxeploai(int a, String b, String c, String d){
        this.mssv =a;
        this.ten = b;
        this.diem = c;
        this.xeploai = d;
    }

    @Override
    public String toString() {
        return this.getTen() + " " + this.getXeploai();
    }

    /**
     * @return the mssv
     */
    public int getMssv() {
        return mssv;
    }

    /**
     * @param mssv the mssv to set
     */
    public void setMssv(int mssv) {
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
     * @return the diem
     */
    public String getDiem() {
        return diem;
    }

    /**
     * @param diem the diem to set
     */
    public void setDiem(String diem) {
        this.diem = diem;
    }

    /**
     * @return the xeploai
     */
    public String getXeploai() {
        return xeploai;
    }

    /**
     * @param xeploai the xeploai to set
     */
    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }
    
    
}
