/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.util.Pair;
import quanly.Class.Account;
import quanly.Class.Hocki;
import quanly.Class.Monhoc;
import quanly.Class.Sinhvien;
import quanly.Class.tbDiem;
import quanly.Class.tbHocBong;
import quanly.Class.tbLopHoc;
import quanly.Class.tbbchocphi;
import quanly.Class.tbxeploai;
import quanly.Class.twoInt;

/**
 *
 * @author jacky
 */
public class Utils {
    
    
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
    public static void resetcounter(String name) throws SQLException{
        String sql = "ALTER TABLE " + name + " AUTO_INCREMENT = 1";
        Connection conn = jdbcUtils.getConn();
        Statement stm = conn.createStatement();
        stm.execute(sql);
    }
    public static void resetDB() throws SQLException{
        resetcounter("sinhvien");
        resetcounter("lophoc");
        resetcounter("monhoc");
        resetcounter("diem");
        resetcounter("hocbong");
        resetcounter("account");
        resetcounter("hocki");
        resetcounter("sinhvien_nhan_hocbong");
    }
    
}
