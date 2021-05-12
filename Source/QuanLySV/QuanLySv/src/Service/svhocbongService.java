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
import java.util.ArrayList;
import java.util.List;
import quanly.Class.tbHocBong;

/**
 *
 * @author jacky
 */
public class svhocbongService {
    public static List<tbHocBong> getHocBong(int id) throws SQLException{
        String sql = "select mucdo, hk.hoc_ki, nam, tien_thuong " +
                "from hocki hk, sinhvien_nhan_hocbong s, hocbong hb " +
                "where hk.id_hoc_ki = hb.hoc_ki and s.id_hoc_bong = hb.id_hoc_bong and id_sinh_vien = ? ";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        List<tbHocBong> hb = new ArrayList<>();
        while (rs.next()){
            tbHocBong h = new tbHocBong(rs.getString(1), "ki " + rs.getString(2) +" nam "+ rs.getString(3), rs.getFloat(4));
            hb.add(h);
        }
        return hb;
    }
    public static void themSVnhanHB(List<tbHocBong> tb){
        
    }
}
