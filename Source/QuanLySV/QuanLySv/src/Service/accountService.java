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
import quanly.Class.Account;

/**
 *
 * @author jacky
 */
public class accountService {
    public static Account getAccount(int id) throws SQLException {
        String sql = "select * from account where id_account = ?";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        rs.next();
        return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
    }

    public static void updateAccount(int id, String pass) throws SQLException {
        String sql = "update account set mat_khau = ? where id_account = ? ";
        Connection conn = jdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, pass);
        stm.setInt(2, id);
        stm.executeUpdate();
        
    }

}
