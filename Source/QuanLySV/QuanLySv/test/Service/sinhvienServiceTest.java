/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import quanly.Class.Sinhvien;

/**
 *
 * @author jacky
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class sinhvienServiceTest {
    
    
    Sinhvien sv = new Sinhvien(99,"n20210999","Ho Test","TenTest","09/09/1999","queTest",99);
    
    public sinhvienServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test sinhvien service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test sinhvien service");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of todatetime method, of class sinhvienService.
     */
    @Test
    public void test001Todatetime() throws Exception {
        System.out.println("============== String to Date ===============");
        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        String expResult = "01/01/1992";
        Date result = sinhvienService.todatetime(expResult);
        assertEquals(expResult, format1.format(result));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getthu method, of class sinhvienService.
     */
    @Test
    public void test002Getthu() {
        System.out.println("============== lay thu cua ngay ==============");
        Date date = new Date();
        String expResult = "Sunday";
        String result = sinhvienService.getthu(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSinhVien method, of class sinhvienService.
     */
    @Test
    public void test003GetSinhVien_String() throws Exception {
        System.out.println("==============  getSinhVien ============== ");
        String key = "test";
        List<Sinhvien> expResult = new ArrayList<>();
        expResult.add(new Sinhvien(1, "n20200001", "test1", "admin", "01/01/2000", "quequan1", 1));
        expResult.add(new Sinhvien(2, "n20210001", "test2", "user", "02/02/1999", "quequan2", 2));
        List<Sinhvien> result = sinhvienService.getSinhVien(key);
        Field[] fields = Sinhvien.class.getDeclaredFields();
        for (int k=0; k < expResult.size(); k++){
            for (int i = 0; i < fields.length; i++) {
                assertEquals(expResult.get(k).get(i), result.get(k).get(i));
            }
        }
    }

    /**
     * Test of delSinhVien method, of class sinhvienService.
     */
    @Test
    public void test007DelSinhVien() throws Exception {
        System.out.println("============= delSinhVien =============");
        Sinhvien s = sinhvienService.getSinhVien(3);
        sinhvienService.delSinhVien(s.getId(), s.getId_acc());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updateSV method, of class sinhvienService.
     */
    @Test
    public void test006UpdateSV() throws Exception {
        System.out.println("============= updateSV =============");
        Sinhvien sv = sinhvienService.getSinhVien(3);
        sv.setTen("updateTest");
        sinhvienService.updateSV(sv);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getsttSVnam method, of class sinhvienService.
     */
    @Test
    public void test008GetsttSVnam() throws Exception {
        System.out.println("=============== getsttSVnam ===============");
        int now = 2021;
        int expResult = 2;
        int result = sinhvienService.getsttSVnam(now);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of themSV method, of class sinhvienService.
     */
    @Test
    public void test005ThemSV() throws Exception {
        System.out.println("============== themSV ==============");
        String b = sv.getHo();
        String c = sv.getTen();
        String d = sv.getNgaysinh();
        String e = sv.getQuequan();
        sinhvienService.themSV(b, c, d, e);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSinhVien method, of class sinhvienService.
     */
    @Test
    public void test004GetSinhVien_int() throws Exception {
        System.out.println("============= getSinhVien ============");
        int id = 1;
        Sinhvien expResult = new Sinhvien(1, "n20200001", "test1", "admin", "01/01/2000", "quequan1", 1);
        Sinhvien result = sinhvienService.getSinhVien(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getMssv(), result.getMssv());
        assertEquals(expResult.getHo(), result.getHo());
        assertEquals(expResult.getTen(), result.getTen());
        assertEquals(expResult.getNgaysinh(), result.getNgaysinh());
        assertEquals(expResult.getQuequan(), result.getQuequan());
        assertEquals(expResult.getId_acc(), result.getId_acc());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSinhVienByAcc method, of class sinhvienService.
     */
    @Test
    public void test009GetSinhVienByAcc() throws Exception {
        System.out.println("============= getSinhVienByAcc ===============");
        int idacc = 1;
        Sinhvien expResult = new Sinhvien(1, "n20200001", "test1", "admin", "01/01/2000", "quequan1", 1);
        Sinhvien result = sinhvienService.getSinhVienByAcc(idacc);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getMssv(), result.getMssv());
        assertEquals(expResult.getHo(), result.getHo());
        assertEquals(expResult.getTen(), result.getTen());
        assertEquals(expResult.getNgaysinh(), result.getNgaysinh());
        assertEquals(expResult.getQuequan(), result.getQuequan());
        assertEquals(expResult.getId_acc(), result.getId_acc());
    }
    
}
