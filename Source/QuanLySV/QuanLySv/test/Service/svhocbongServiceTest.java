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
public class svhocbongServiceTest {
    
    public svhocbongServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test sv hocbong service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test sv hocbong service");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHocBong method, of class svhocbongService.
     */
    @Test
    public void test001GetHocBong() throws Exception {
        System.out.println("=============== getHocBong ==================");
        int idsv = 2;
        List<tbHocBong> expResult = new ArrayList<>();
        expResult.add(new tbHocBong("Gioi", "ki 1 nam 2020", 200000.0F));
        
        List<tbHocBong> result = svhocbongService.getHocBong(idsv);
        assertEquals(expResult.size(), result.size());
        for (int i =0; i<result.size(); i++){
            assertEquals(expResult.get(i).getMucdo(), result.get(i).getMucdo());
            assertEquals(expResult.get(i).getHocki(), result.get(i).getHocki());
            assertEquals(expResult.get(i).getTien(), result.get(i).getTien(),0.01F);
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
