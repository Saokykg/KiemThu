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
import java.util.ArrayList;
import java.util.List;
import quanly.Class.tbHocBong;

/**
 *
 * @author jacky
 */
public class hocbongService {
    public static List<tbHocBong> createHocBongSvNhan(boolean c1, boolean c2, boolean c3, int a, int b, int c, float t1, float t2, float t3, int hk) throws SQLException{
        int count =0;
        if (c1) count +=a;
        if (c2) count +=b;
        if (c3) count +=c;
        String sql = "select ho, ten, avg(diem_giua_ki*m.phantram + diem_cuoi_ki*(1-m.phantram)) " +
                    "from sinhvien s, diem d, lophoc l, monhoc m " +
                    "where s.id_sinh_vien = d.id_sinh_vien and l.id_lop_hoc = d.id_lop_hoc and l.id_mon_hoc = m.id_mon_hoc and l.hoc_ki = ? " +
                    "group by s.id_sinh_vien " +
                    "order by 3 desc " +
                    "limit ?";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, hk);
        stm.setInt(2, count);
        ResultSet rs = stm.executeQuery();
        List<tbHocBong> tb = new ArrayList<>();
        while(rs.next()){
            tbHocBong hb = null;
            if (rs.getFloat(3) < 6)
                break;
            if (c1 && a>0){
                hb = new tbHocBong(tb.size()+1, rs.getString(1)+" "+rs.getString(2),"Xuat sac",t1);
                a--;
            }else if (c2 && b>0){
                hb = new tbHocBong(tb.size()+1, rs.getString(1)+" "+rs.getString(2),"Gioi",t2);
                b--;
            }else if (c3 && c>0){
                hb = new tbHocBong(tb.size()+1, rs.getString(1)+" "+rs.getString(2),"Kha",t3);
                c--;
            }
            tb.add(hb);
        }
        return tb;
    }
    public static boolean checkHk(int hk) throws SQLException {
        Connection conn = jdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * from hocbong where hoc_ki = " + hk);
        if(rs.next())
            return true;
        else
            return false;
    }
    public static void insertHocBong(boolean kt1, boolean kt2, boolean kt3, int a, int b, int c, float t1, float t2, float t3, int hk) throws SQLException {
        String sql= "INSERT INTO `hocbong` (`Mucdo`, `so_luong`, `tien_thuong`, `hoc_ki`) VALUES (?,?,?,?)";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        if (kt1){
            stm.setString(1, "Xuat sac");
            stm.setInt(2, a);
            stm.setFloat(3, t1);
            stm.setInt(4, hk);
            stm.executeUpdate();
        }
        if (kt2){
            stm.setString(1, "Gioi");
            stm.setInt(2, b);
            stm.setFloat(3, t2);
            stm.setInt(4, hk);
            stm.executeUpdate();
        }
        if (kt3){
            stm.setString(1, "Kha");
            stm.setInt(2, c);
            stm.setFloat(3, t3);
            stm.setInt(4, hk);
            stm.executeUpdate();
        }
        int count =0;
        if (kt1) count +=a;
        if (kt2) count +=b;
        if (kt3) count +=c;
        String sql2 = "select s.id_sinh_vien, avg(diem_giua_ki*m.phantram + diem_cuoi_ki*(1-m.phantram)) " +
                    "from sinhvien s, diem d, lophoc l, monhoc m " +
                    "where s.id_sinh_vien = d.id_sinh_vien and l.id_lop_hoc = d.id_lop_hoc and l.id_mon_hoc = m.id_mon_hoc and l.hoc_ki = ? " +
                    "group by s.id_sinh_vien " +
                    "order by 2 desc " +
                    "limit ?";
        Statement st = conn.createStatement();
        ResultSet stt = st.executeQuery("select count(*) from hocbong");
        stt.next();
        int tmp = stt.getInt(1)-2;
        PreparedStatement stm2 = conn.prepareStatement(sql2);
        stm2.setInt(1, hk);
        stm2.setInt(2, count);
        ResultSet rs = stm2.executeQuery();
        PreparedStatement stmhb = conn.prepareStatement("INSERT INTO `sinhvien_nhan_hocbong` (`id_sinh_vien`, `id_hoc_bong`) VALUES (?, ?)");
        List<tbHocBong> tb = new ArrayList<>();
        while(rs.next()){
            tbHocBong hb = null;
            if (rs.getFloat(2) < 6)
                break;
            if (kt1 && a>0){
                stmhb.setInt(1, rs.getInt(1));
                stmhb.setInt(2, tmp);
                stmhb.executeUpdate();
            }else if (kt2 && b>0){
                stmhb.setInt(1, rs.getInt(1));
                stmhb.setInt(2, tmp+1);
                stmhb.executeUpdate();
            }else if (kt3 && c>0){
                stmhb.setInt(1, rs.getInt(1));
                stmhb.setInt(2, tmp+2);
                stmhb.executeUpdate();
            }
        }
    }
    public static int getHocBong(int hk) throws SQLException{
        String sql= "Select count(*) from hocbong where hoc_ki = ?";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, hk);
        ResultSet rs = stm.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    
}
