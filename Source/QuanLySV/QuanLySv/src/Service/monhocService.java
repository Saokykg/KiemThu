/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quanly.Class.twoInt;

/**
 *
 * @author jacky
 */
public class monhocService {
    public static twoInt testMonTinchiDiemTB(int id) throws SQLException{
        int mon=0,tinchi=0;
        float tong=0;
        String sql ="select l.id_mon_hoc, m.ten_mon_hoc, max(d.diem_giua_ki*m.phantram + d.diem_cuoi_ki*(1-m.phantram)) , m.so_tin_chi " +
                    "from  monhoc m, diem d, lophoc l  " +
                    "where d.id_lop_hoc = l.id_lop_hoc and l.id_mon_hoc = m.id_mon_hoc and d.id_sinh_vien = ? " +
                    "group by m.id_mon_hoc";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        while (rs.next()){
            mon++;
            tinchi+=rs.getInt(4);
            tong+=rs.getFloat(3);
        }
        tong =(tong/(float)mon);
        twoInt ans = new twoInt(mon, tinchi, tong);
        return ans;
    }
}
