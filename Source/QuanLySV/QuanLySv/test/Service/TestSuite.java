/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import static Service.Utils.resetcounter;
import java.sql.SQLException;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 *
 * @author jacky
 */
public class TestSuite {
    
//    public static void resetDB() throws SQLException{
//        resetcounter("sinhvien");
//        resetcounter("lophoc");
//        resetcounter("monhoc");
//        resetcounter("diem");
//        resetcounter("hocbong");
//        resetcounter("account");
//        resetcounter("hocki");
//        resetcounter("sinhvien_nhan_hocbong");
//    }
    @RunWith(Suite.class)
    @SuiteClasses({accountServiceTest.class, diemServiceTest.class, sinhvienServiceTest.class, hocbongServiceTest.class, lophocServiceTest.class, 
            hockiServiceTest.class ,svhocbongServiceTest.class,tableServiceTest.class,monhocServiceTest.class})
    public class MyTestSuite {
        
    }
}
