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
public class SvHocbong {
    private int id_sv;
    private int id_hb;
    
    public SvHocbong(int sv, int hb){
        this.id_sv = sv;
        this.id_hb = hb;
    }

    /**
     * @return the id_sv
     */
    public int getId_sv() {
        return id_sv;
    }

    /**
     * @param id_sv the id_sv to set
     */
    public void setId_sv(int id_sv) {
        this.id_sv = id_sv;
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
}
