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
import quanly.Class.tbDiem;
import quanly.Class.tbLopHoc;
import quanly.Class.twoInt;

/**
 *
 * @author jacky
 */
public class diemService {
    
    public static List<tbDiem> getDiem(int id,int idacc) throws SQLException{
        String sql = "select mssv,CONCAT_WS(\" \", `ho`, `ten`), ten_mon_hoc , diem_giua_ki, diem_cuoi_ki, phantram " +
                    "from sinhvien sv, diem d, monhoc m, lophoc l " +
                    "where sv.id_sinh_vien = d.id_sinh_vien and m.id_mon_hoc = l.id_mon_hoc and " +
                    "l.id_lop_hoc = d.id_lop_hoc and d.id_lop_hoc = ? ";
        if (accountService.getAccount(idacc).getLoaitk().equals("USER")){
            sql+= " and sv.id_account = ?";
        }
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        if (accountService.getAccount(idacc).getLoaitk().equals("USER")){
            stm.setInt(2, idacc);
        }
        ResultSet rs = stm.executeQuery();
        List<tbDiem> lophoc = new ArrayList<>();
        while(rs.next()){
            tbDiem lop = new tbDiem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), 
                                rs.getFloat(5), rs.getFloat(6));
            lophoc.add(lop);
        }
        return lophoc;
    }
    public static void dangky(List<tbLopHoc> lopdk, int idsv) throws SQLException{
        String sql= "insert into diem(id_lop_hoc, id_sinh_vien) values(?,?)";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        for (tbLopHoc lop : lopdk){
            stm.setInt(1, lop.getId());
            stm.setInt(2, idsv);
            stm.executeUpdate();
        }
    }

}
