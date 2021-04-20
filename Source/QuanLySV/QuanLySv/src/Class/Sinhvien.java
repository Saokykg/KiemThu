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
public class Sinhvien {
    
    private int id; 
    private String mssv;
    private String ho;
    private String ten;
    private String ngaysinh;
    private String quequan;
    private int id_acc;
    
    public Sinhvien(int id, String ms, String ho, String ten,
                    String ngaysinh, String quequan,int idacc){
        this.id = id;
        this.mssv = ms;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
        this.id_acc = idacc;
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
     * @return the mssv
     */
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
     * @return the ho
     */
    public String getHo() {
        return ho;
    }

    /**
     * @param ho the ho to set
     */
    public void setHo(String ho) {
        this.ho = ho;
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
     * @return the ngaysinh
     */
    public String getNgaysinh() {
        return ngaysinh;
    }

    /**
     * @param ngaysinh the ngaysinh to set
     */
    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    /**
     * @return the quequan
     */
    public String getQuequan() {
        return quequan;
    }

    /**
     * @param quequan the quequan to set
     */
    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    /**
     * @return the id_acc
     */
    public int getId_acc() {
        return id_acc;
    }

    /**
     * @param id_acc the id_acc to set
     */
    public void setId_acc(int id_acc) {
        this.id_acc = id_acc;
    }
    
    
    
    
    
}
