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
public class Diem {
    
    private int id_sv;
    private int id_lop;
    private float diem_gk;
    private float diem_ck;
    private float tile;
    
    public Diem(int sv, int lop, float diem1, float diem2, float tile){
        this.id_lop = lop;
        this.id_sv = sv;
        this.diem_gk = diem1;
        this.diem_ck = diem2;
        this.tile = tile;
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
     * @return the id_lop
     */
    public int getId_lop() {
        return id_lop;
    }

    /**
     * @param id_lop the id_lop to set
     */
    public void setId_lop(int id_lop) {
        this.id_lop = id_lop;
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
