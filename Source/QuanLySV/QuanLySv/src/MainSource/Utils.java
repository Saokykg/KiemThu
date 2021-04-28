/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import quanly.Class.Hocki;
import quanly.Class.Monhoc;
import quanly.Class.Sinhvien;

/**
 *
 * @author jacky
 */
public class Utils {
    
    
    public static List<Sinhvien> getSinhVien(String key) throws SQLException{
        String sql = "Select * from SinhVien";
        if (!key.isEmpty())
            sql+=" Where (ho like ?) or (ten like ?)";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        if (!key.isEmpty()){
            stm.setString(1, String.format("%%%s%%", key));
            stm.setString(2, String.format("%%%s%%", key));
        }
        ResultSet rs = stm.executeQuery();
        List<Sinhvien> sinhvien = new ArrayList<>();
        while (rs.next()){
            Sinhvien s = new Sinhvien(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            sinhvien.add(s);
        }
        return sinhvien;
    }
    
    public static void resetcounter(String name) throws SQLException{
        String sql = "ALTER TABLE " + name + " AUTO_INCREMENT = 1";
        Connection conn = jdbcUtils.getConn();
        Statement stm = conn.createStatement();
        stm.execute(sql);
    }
    
    public static void delSinhVien(Sinhvien sv) throws SQLException {
        Connection conn = jdbcUtils.getConn();
        String sql = "Delete from SinhVien where id_sinh_vien = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, sv.getId());
        stm.executeUpdate();
        
        String sql2 = "Delete from account where id_account = ?";
        PreparedStatement stm2 = conn.prepareStatement(sql2);
        stm2.setInt(1, sv.getId_acc());
        stm2.executeUpdate();
        
        resetcounter("sinhvien");
        resetcounter("account");
    }
    
    public static void updateSV(Sinhvien sv) throws SQLException{
        String sql1 = "update sinhvien " +
                    " set mssv = ?, ho = ?, ten =?, ngay_sinh=?, que_quan=? " +
                    " where id_sinh_vien=? ";
        String sql2 = "update account " +
                    " set tai_khoan= ? " +
                    " where id_account = ?"; 
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm1 = conn.prepareStatement(sql1);
        stm1.setString(1, sv.getMssv());
        stm1.setString(2, sv.getHo());
        stm1.setString(3, sv.getTen());
        stm1.setString(4, sv.getNgaysinh());
        stm1.setString(5, sv.getQuequan());
        stm1.setInt(6, sv.getId());
        stm1.executeUpdate();
        
        PreparedStatement stm2 = conn.prepareStatement(sql2);
        stm2.setString(1, sv.getMssv()+sv.getTen());
        stm2.setInt(2, sv.getId_acc());
        stm2.executeUpdate();
        
    }
    
    public static void themSV(String a, String b, String c, String d, String e) throws SQLException{
        String sql1 = "INSERT INTO account(tai_khoan, mat_khau, loai_tai_khoan) "+
                      " values(?,?,?)";
        String sql2 =  "INSERT INTO sinhvien (mssv, ho, ten, ngay_sinh, que_quan, id_account) " +
                      "VALUES(?,?,?,?,?,?)";
        Connection conn = jdbcUtils.getConn();
        
        PreparedStatement stm1 = conn.prepareStatement(sql1);
        stm1.setString(1, a+c);
        stm1.setString(2, a);
        stm1.setString(3, "USER");
        stm1.executeUpdate();
        
        PreparedStatement stm = conn.prepareStatement("select id_account from account where tai_khoan = ?");
        stm.setString(1, a+c);
        ResultSet rs = stm.executeQuery();
        rs.next();
        
        PreparedStatement stm2 = conn.prepareStatement(sql2);
        stm2.setString(1, a);
        stm2.setString(2, b);
        stm2.setString(3, c);
        stm2.setString(4, d);
        stm2.setString(5, e);
        stm2.setString(6, rs.getString("id_account"));
        stm2.executeUpdate();
        
    }
    
    
    // TRA CUU
    
    public static List<Hocki> getHK() throws SQLException{
        String sql = "SELECT * FROM hocki " +
                    "order by 3 desc, 2 asc";
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

    static List<Monhoc> getMH(int idhk) throws SQLException {
        String sql = "select m.* " +
                    "from monhoc m, lophoc l " +
                    "where m.id_mon_hoc = l.id_mon_hoc and l.hoc_ki = " + idhk;
        Connection conn = jdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        System.out.println(sql.toString());
        List<Monhoc> mh = new ArrayList<>();
        while (rs.next()){
            Monhoc m = new Monhoc(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5));
            mh.add(m);
        }
        return mh;
    }
    
    
}
