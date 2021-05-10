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
import quanly.Class.tbbchocphi;
import quanly.Class.tbxeploai;

/**
 *
 * @author jacky
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class tableServiceTest {
    
    public tableServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test table service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test table service");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getbaocaohocphi method, of class tableService.
     */
    @Test
    public void test002Getbaocaohocphi() throws Exception {
        System.out.println("================ getbaocaohocphi n = nam k = ki ================");
        int n = 2020;
        int k = 0;
        List<tbbchocphi> expResult = new ArrayList<>();
        expResult.add(new tbbchocphi(1,"Hoa",1,1000000.0F*1));
        expResult.add(new tbbchocphi(3,"Ly",2,3000000.0F*2));
        List<tbbchocphi> result = tableService.getbaocaohocphi(n, k);
        for (int i =0; i<result.size(); i++){
            assertEquals(expResult.get(i).getMalop(), result.get(i).getMalop());
            assertEquals(expResult.get(i).getSoluongdk(), result.get(i).getSoluongdk());
            assertEquals(expResult.get(i).getTenmon(), result.get(i).getTenmon());
            assertEquals(expResult.get(i).getTongtien(), result.get(i).getTongtien(),0.01F);
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of diemtoxeploai method, of class tableService.
     */
    @Test
    public void test001Diemtoxeploai() {
        System.out.println("================ diemtoxeploai ================");
        float d = 5.0F;
        String expResult = "Gioi";
//        Yếu           <5
//        Trung bình    <7
//        Khá           <8
//        Giỏi          >=8
        if (d<5)
            expResult = "Yếu";
        else if (d<7) expResult = "Trung bình";
        else if (d<8) expResult = "Khá";
        else expResult = "Giỏi";
        String result = tableService.diemtoxeploai(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getbaocaoxeploai method, of class tableService.
     */
    @Test
    public void test003Getbaocaoxeploai() throws Exception {
        System.out.println("================ getbaocaoxeploai n = nam k = ki ================");
        int n = 2020;
        int k = 0;
        List<tbxeploai> expResult = new ArrayList<>();
        expResult.add(new tbxeploai("n20200001", "test1 admin", String.format("%.2f",10.0F), "Giỏi"));
        expResult.add(new tbxeploai("n20210001", "test2 user", String.format("%.2f",5.75F), "Trung bình"));
        List<tbxeploai> result = tableService.getbaocaoxeploai(n, k);
        for (int i =0; i<result.size(); i++){
            assertEquals(expResult.get(i).getMssv(), result.get(i).getMssv());
            assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
            assertEquals(expResult.get(i).getDiem(), result.get(i).getDiem());
            assertEquals(expResult.get(i).getXeploai(), result.get(i).getXeploai());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDsHocBong method, of class tableService.
     */
    @Test
    public void testGetDsHocBong() throws Exception {
        System.out.println("================ getDsHocBong theo hk ================");
        int hocki = 1;
        List<tbHocBong> expResult = new ArrayList<>();
        expResult.add(new tbHocBong(1,"test1 admin", "Xuat sac", 300000.0F));
        expResult.add(new tbHocBong(2,"test2 user", "Gioi", 200000.0F));
        List<tbHocBong> result = tableService.getDsHocBong(hocki);
        for (int i =0; i<result.size(); i++){
            assertEquals(expResult.get(i).getStt(), result.get(i).getStt());
            assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
            assertEquals(expResult.get(i).getMucdo(), result.get(i).getMucdo());
            assertEquals(expResult.get(i).getTien(), result.get(i).getTien());
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
