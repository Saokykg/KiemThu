/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import static Service.Utils.resetcounter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import quanly.Class.Sinhvien;

/**
 *
 * @author jacky
 */
public class sinhvienService {
    public static Date todatetime(String date) throws ParseException{
        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        Date dt1=format1.parse(date);
        return dt1;
        
    }
    public static String getthu(Date date){
        DateFormat format2=new SimpleDateFormat("EEEE"); 
        String finalDay=format2.format(date);
        return finalDay.toString();
    }
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
    public static void delSinhVien(int id, int id_acc) throws SQLException {
        Connection conn = jdbcUtils.getConn();
        String sql = "Delete from SinhVien where id_sinh_vien = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();
        
        String sql2 = "Delete from account where id_account = ?";
        PreparedStatement stm2 = conn.prepareStatement(sql2);
        stm2.setInt(1, id_acc);
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
    public static int getsttSVnam(int now) throws SQLException{
        String sql = "select count(*) from sinhvien where mssv like \"n" + now +"%\"";
        Connection conn = jdbcUtils.getConn();
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
            return rs.getInt(1)+1;
        else
            return 1;
    }
    public static void themSV(String b, String c, String d, String e) throws SQLException{
        NumberFormat nf = new DecimalFormat("0000");
        LocalDateTime now = LocalDateTime.now();
        int res = getsttSVnam(now.getYear());
        String a = String.format("n%s%s",now.getYear(),nf.format(res));
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
    public static Sinhvien getSinhVien(int id) throws SQLException{
        
        String sql = "select * from sinhvien where id_sinh_vien = ?";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        rs.next();
        Sinhvien sv = new Sinhvien(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
        return sv;
    }
    public static Sinhvien getSinhVienByAcc(int id) throws SQLException{
        
        String sql = "select * from sinhvien where id_account = ?";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        rs.next();
        Sinhvien sv = new Sinhvien(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
        return sv;
    }
    
}
