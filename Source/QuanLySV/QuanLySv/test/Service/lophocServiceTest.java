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
import quanly.Class.tbLopHoc;

/**
 *
 * @author jacky
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class lophocServiceTest {
    
    public lophocServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test lophoc service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test lophoc service");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLH method, of class lophocService.
     */
    @Test
    public void test001GetLH_int() throws Exception {
        System.out.println("================= getLH theo hk =================");
        int idhk = 1;
        int expResult = 1;
        List<tbLopHoc> result = lophocService.getLH(idhk);
        for (tbLopHoc r : result){
            assertEquals(expResult, r.getIdhk());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLH method, of class lophocService.
     */
    @Test
    public void test002GetLH_int_int() throws Exception {
        System.out.println("================= getLH theo sinh vien dk va hk =================");
        int idhk = 1;
        int idacc = 2;
        int idsv = sinhvienService.getSinhVienByAcc(idacc).getId();
        List<tbLopHoc> expResult = new ArrayList<>();
        expResult.add(new tbLopHoc(1, "Hoa", 4, 1000000.0F));
        expResult.add(new tbLopHoc(3, "Ly", 4, 3000000.0F));
        List<tbLopHoc> result = lophocService.getLH(idhk, idacc);
        for (int i =0; i<result.size(); i++){
            assertEquals(expResult.get(i).getId(),result.get(i).getId());
            assertEquals(expResult.get(i).getMon(),result.get(i).getMon());
            assertEquals(expResult.get(i).getTinchi(),result.get(i).getTinchi(),0.01F);
            assertEquals(expResult.get(i).getHocphi(),result.get(i).getHocphi(),0.01F);
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLH method, of class lophocService.
     */
    @Test
    public void test003GetLH_String_int() throws Exception {
        System.out.println("================== getLH theo ten mon va hk  ==================");
        String name = "oa";
        int idhk = 1;
        List<tbLopHoc> expResult = new ArrayList<>();
        expResult.add(new tbLopHoc(1, "Hoa", 4, 1000000.0F));
        expResult.add(new tbLopHoc(2, "Toan", 4, 2000000.0F));
        expResult.add(new tbLopHoc(4, "Toan", 4, 2000000.0F));
        List<tbLopHoc> result = lophocService.getLH(name, idhk);
        for (int i =0; i<result.size(); i++){
            assertEquals(expResult.get(i).getId(),result.get(i).getId());
            assertEquals(expResult.get(i).getMon(),result.get(i).getMon());
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
