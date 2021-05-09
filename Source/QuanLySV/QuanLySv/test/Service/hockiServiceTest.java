/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import quanly.Class.Hocki;

/**
 *
 * @author jacky
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class hockiServiceTest {
    
    public hockiServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test hocki service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test hocki service");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdhkNow method, of class hockiService.
     */
    @Test
    public void test006GetIdhkNow() throws Exception {
        System.out.println("============ getIdhk ke tiep ============");
        int expResult = hockiService.getIdhk(3, 2021) + 1;
        int result = hockiService.getIdhkNow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdhk method, of class hockiService.
     */
    @Test
    public void test005GetIdhk() throws Exception {
        System.out.println("============ getIdhk ============");
        int m = 1;
        int y = 2021;
        int expResult = 4;
        int result = hockiService.getIdhk(m, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getHK method, of class hockiService.
     */
    @Test
    public void test001GetHK_0args() throws Exception {
        System.out.println("============ getHK ============");
        int expId = 1;
        int exphk = 1;
        int expyear = 2020;
        
        List<Hocki> result = hockiService.getHK();
        for (Hocki hk : result){
            assertEquals(expId, hk.getId());
            assertEquals(exphk, hk.getHoc_ki());
            assertEquals(expyear, hk.getNam());
            expId++;
            if (exphk<3) 
                exphk++;
            else{
                exphk=1;
                expyear++;
            }
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getHK method, of class hockiService.
     */
    @Test
    public void test002GetHK_int_int() throws Exception {
        System.out.println("============ getHK ============");
        int n = 2020;
        int k = 1;
        int expResult = 1;
        int result = hockiService.getHK(n, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of countNam method, of class hockiService.
     */
    @Test
    public void test003CountNam() throws Exception {
        System.out.println("============ countNam ============");
        List<Integer> expResult = new ArrayList<>();
        expResult.add(2020);
        expResult.add(2021);
        expResult.add(2022);
        List<Integer> result = hockiService.countNam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of countHk method, of class hockiService.
     */
    @Test
    public void test004CountHk() throws Exception {
        System.out.println("============ countHk ============");
        int nam = 2021;
        List<Integer> expResult = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> result = hockiService.countHk(nam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
