/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import static Service.Utils.resetcounter;
import java.sql.SQLException;

/**
 *
 * @author jacky
 */
public class testclass {
    
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
