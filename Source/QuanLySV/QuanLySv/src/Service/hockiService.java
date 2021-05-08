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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import quanly.Class.Hocki;

/**
 *
 * @author jacky
 */
public class hockiService {
    public static int getIdhkNow() throws SQLException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        int m = now.getMonthValue();
        int y = now.getYear();
        if (m>=9 && m<1)
            m = 1;
            else if(m>=1 && m<5)
                    m = 2;
                    else m =3;
        String sql = "select id_hoc_ki from hocki where hoc_ki = ? and nam = ?";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, m);
        stm.setInt(2, y);
        ResultSet rs = stm.executeQuery();
        int id;
        if (!rs.next())
            return -1;
        else
            id = rs.getInt(1);
        return id + 1;
    }
    
    public static int getIdhk(int m, int y) throws SQLException{
        String sql = "select id_hoc_ki from hocki where hoc_ki = ? and nam = ?";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, m);
        stm.setInt(2, y);
        ResultSet rs = stm.executeQuery();
        int id;
        if (!rs.next())
            return -1;
        else
            id = rs.getInt(1);
        return id;
    }
    public static List<Hocki> getHK() throws SQLException{
        String sql = "SELECT * FROM hocki " +
                    "order by 3 asc, 2 asc";
        Connection conn = jdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Hocki> hk = new ArrayList<>();
        while (rs.next()){
            Hocki h = new Hocki(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            hk.add(h);
        }
        return hk;
    }
    public static int getHK(int n, int k) throws SQLException{
        String sql ="select id_hoc_ki from hocki where nam = ? and hoc_ki = ? ";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, n);
        if (k!=0)
            stm.setInt(2, k);
        else
            stm.setInt(2, 1);
        ResultSet rs = stm.executeQuery();
        if (rs.next())
            return rs.getInt(1);
        else
            return -1;
    }
    
    public static List<Integer> countNam() throws SQLException {
        String sql ="select nam from hocki group by nam";
        Connection conn = jdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Integer> l = new ArrayList<>();
        while (rs.next()){
            l.add(rs.getInt(1));
        }
        return l;
    }
    
    public static List<Integer> countHk(int nam) throws SQLException {
        String sql ="select hoc_ki from hocki where nam = "+ nam;
        Connection conn = jdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Integer> l = new ArrayList<>();
        while (rs.next()){
            l.add(rs.getInt(1));
        }
        return l;
    }
    
    
}
