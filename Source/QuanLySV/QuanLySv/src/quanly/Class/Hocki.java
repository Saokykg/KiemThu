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
public class Hocki {
    private int id;
    private int hoc_ki;
    private int nam;
    
    public Hocki(int id,int hk, int nam){
        this.id = id;
        this.hoc_ki = hk;
        this.nam = nam;
    }
    
    @Override
    public String toString() {
        return "Học kì " + String.valueOf(hoc_ki) + ", năm học " +String.valueOf(nam);
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
     * @return the hoc_ki
     */
    public int getHoc_ki() {
        return hoc_ki;
    }

    /**
     * @param hoc_ki the hoc_ki to set
     */
    public void setHoc_ki(int hoc_ki) {
        this.hoc_ki = hoc_ki;
    }

    /**
     * @return the nam
     */
    public int getNam() {
        return nam;
    }

    /**
     * @param nam the nam to set
     */
    public void setNam(int nam) {
        this.nam = nam;
    }
}
