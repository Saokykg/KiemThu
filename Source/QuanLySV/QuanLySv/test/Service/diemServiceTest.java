/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import quanly.Class.tbDiem;
import quanly.Class.tbLopHoc;

/**
 *
 * @author jacky
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class diemServiceTest {
    
    public diemServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test diem service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test diem service");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDiem method, of class diemService.
     */
    @Test
    public void test001GetDiem() throws Exception {
        System.out.println("================ get bang diem lop ================");
        int idsv = 3;
        List<tbDiem> expResult = new ArrayList<>();
        expResult.add(new tbDiem("n20200001", "test1 admin", "Ly", 10, 10, 0.5F));
        expResult.add(new tbDiem("n20210001", "test2 user", "Ly", 6, 7, 0.5F));

        List<tbDiem> result = diemService.getDiem(idsv,"ADMIN");
        for (int i=0; i<result.size(); i++){
            assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
            assertEquals(expResult.get(i).getMssv(), result.get(i).getMssv());
            assertEquals(expResult.get(i).getMon(), result.get(i).getMon());
            assertEquals(expResult.get(i).getDiem_ck(), result.get(i).getDiem_ck(),0.01F);
            assertEquals(expResult.get(i).getDiem_gk(), result.get(i).getDiem_gk(),0.01F);
            assertEquals(expResult.get(i).getTile(), result.get(i).getTile(),0.01F);
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of dangky method, of class diemService.
     */
    @Test
    public void test002Dangky() throws Exception {
        System.out.println("================ dangky ================");
        List<tbLopHoc> lopdk = new ArrayList<>();
        lopdk.add(new tbLopHoc(4,"Toan"));
        lopdk.add(new tbLopHoc(5,"Ly"));
        int idsv = 2;
        String mssv = "n20210001";
        diemService.dangky(lopdk, idsv);
        List<tbDiem> result = diemService.getDiem(idsv, "USER");
        for (int i=0; i<result.size(); i++){
            assertEquals(lopdk.get(i).getMon(), result.get(i).getMon());
            assertEquals(mssv, result.get(i).getMssv());
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
