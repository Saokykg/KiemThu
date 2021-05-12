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
import quanly.Class.tbHocBong;

/**
 *
 * @author jacky
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class hocbongServiceTest {
    
    public hocbongServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test hocbong service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test hocbong service");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createHocBong method, of class hocbongService.
     */
    
    @Test
    public void test001GetHocBong() throws Exception{
        System.out.println("================= get Hoc Bong =================");
        int expResult = 2;
        int result = hocbongService.getHocBong(6);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test002CreateHocBongSvNhan() throws Exception {
        System.out.println("================= createHocBong =================");
        boolean c1 = true;
        boolean c2 = false;
        boolean c3 = true;
        int a = 1;
        int b = 1;
        int c = 4;
        float t1 = 100000;
        float t2 = t1*2;
        float t3 = t1*3;
        int hk = 4;
        List<tbHocBong> expResult = new ArrayList<>();
        expResult.add(new tbHocBong(1, "Đào Văn Nguyên","Xuat sac",t1));
        expResult.add(new tbHocBong(2, "Nguyễn Minh Trí","Kha",t3));
        List<tbHocBong> result = hocbongService.createHocBongSvNhan(c1, c2, c3, a, b, c, t1, t2, t3, hk);
        for (int i=0; i< result.size(); i++){
            assertEquals(expResult.get(i).getTen(),result.get(i).getTen());
            assertEquals(expResult.get(i).getStt(),result.get(i).getStt());
            assertEquals(expResult.get(i).getMucdo(),result.get(i).getMucdo());
            assertEquals(expResult.get(i).getTien(),result.get(i).getTien());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkHk method, of class hocbongService.
     */
    @Test
    public void test003CheckHk() throws Exception {
        System.out.println("================= kiem tra trong ki da co hoc bong hay chua =================");
        int hk = 3;
        boolean expResult = false;
        boolean result = hocbongService.checkHk(hk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of insertHocBong method, of class hocbongService.
     */
    @Test
    public void test004InsertHocBong() throws Exception {
        System.out.println("================= insertHocBong =================");
        boolean c1 = true;
        boolean c2 = false;
        boolean c3 = true;
        int a = 1;
        int b = 1;
        int c = 4;
        float t1 = 100000;
        float t2 = t1*2;
        float t3 = t1*3;
        int hk = 4;
        List<tbHocBong> expResult = new ArrayList<>();
        expResult.add(new tbHocBong(1, "Đào Văn Nguyên","Xuat sac",t1));
        expResult.add(new tbHocBong(2, "Nguyễn Minh Trí","Kha",t3));
        hocbongService.insertHocBong(c1, c2, c3, a, b, c, t1, t2, t3, hk);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
