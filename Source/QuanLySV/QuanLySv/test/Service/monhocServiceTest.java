/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quanly.Class.twoInt;

/**
 *
 * @author jacky
 */
public class monhocServiceTest {
    
    public monhocServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test monhoc service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test monhoc service");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of monTinchi method, of class monhocService.
     */
    @Test
    public void testMonTinchiDiemTB() throws Exception {
        System.out.println("==================== monTinchi ====================");
        int id = 1;
//        twoInt expResult = new twoInt(17,62,5.71F);
        twoInt expResult = new twoInt(19,71,6.11F); id = 2;
        twoInt result = monhocService.testMonTinchiDiemTB(id);
        assertEquals(expResult.getA(), result.getA());
        assertEquals(expResult.getB(), result.getB());
        assertEquals(expResult.getC(), result.getC(), 0.01F);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
