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
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import quanly.Class.Sinhvien;
import quanly.Class.tbLopHoc;

/**
 *
 * @author jacky
 */
public class lophocService {
    public static List<tbLopHoc> getLH(int idhk) throws SQLException, ParseException {
        String sql = "select id_lop_hoc, ten_mon_hoc, ngay_bd, ngay_bd, ca_hoc, l.hoc_ki " +
                    "from monhoc m, lophoc l " +
                    "where m.id_mon_hoc = l.id_mon_hoc and l.hoc_ki = " + idhk ;
        Connection conn = jdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<tbLopHoc> mh = new ArrayList<>();
        while (rs.next()){
            tbLopHoc m = new tbLopHoc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), idhk);
            mh.add(m);
        }
        return mh;
    }
    public static List<tbLopHoc> getLH(int idhk, int idacc) throws SQLException, ParseException {
        String sql = "select l.id_lop_hoc, ten_mon_hoc, so_tin_chi, hoc_phi " +
                        "from monhoc m, lophoc l, diem d " +
                        "where m.id_mon_hoc = l.id_mon_hoc  and l.id_lop_hoc = d.id_lop_hoc "+
                        "and l.hoc_ki = ? and d.id_sinh_vien = ? ";
        Sinhvien sv = sinhvienService.getSinhVienByAcc(idacc);
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, idhk);
        stm.setInt(2, sv.getId());
        ResultSet rs = stm.executeQuery();
        List<tbLopHoc> mh = new ArrayList<>();
        while (rs.next()){
            tbLopHoc m = new tbLopHoc(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
            mh.add(m);
        }
        return mh;
    }
    public static List<tbLopHoc> getLH(String name, int idhk) throws SQLException, ParseException {
        String sql = "select id_lop_hoc, ten_mon_hoc, ngay_bd, ngay_bd, hoc_ki " +
                    "from monhoc m, lophoc l " +
                    "where m.id_mon_hoc = l.id_mon_hoc and l.hoc_ki = ? ";
        if (!name.isEmpty())
            sql +=  "and ten_mon_hoc like ? " ;
        sql+=" order by id_lop_hoc";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, idhk);
        if (!name.isEmpty())
            stm.setString(2, String.format("%%%s%%", name));
        ResultSet rs = stm.executeQuery();
        List<tbLopHoc> mh = new ArrayList<>();
        while (rs.next()){
            tbLopHoc m = new tbLopHoc(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), idhk);
            mh.add(m);
        }
        return mh;
    }
    
}
