/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import quanly.Class.Sinhvien;
/**
 *
 * @author jacky
 */
public class jdbcUtils {
    private static Connection conn;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien",
                        "root", "A!23456a");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcUtils.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
                Logger.getLogger(jdbcUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConn(){
        return conn;
    }
}
