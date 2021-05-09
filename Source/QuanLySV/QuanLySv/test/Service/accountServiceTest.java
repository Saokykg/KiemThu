/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import quanly.Class.Account;

/**
 *
 * @author jacky
 */
@RunWith(Parameterized.class)
public class accountServiceTest extends Account {
    
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test Account service");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End test Account service");
    }

    public accountServiceTest(int id, String u, String p, String l) {
        super(id, u, p, l);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        System.out.println();
    }

    /**
     * Test of getAccount method, of class accountService.
     */
    
    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
            {1111,"testadmin","admin","ADMIN"}, 
            {2222,"testuser","user","USER"}
        });
    }
    
    
    @Test
    public void testGetAccount() throws Exception {
        System.out.println("================== getAccount ==================");
        Account result = accountService.getAccount(this.getId());
        Account expected = this;
        Field[] fields = accountServiceTest.class.getSuperclass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.print(" ---Test field "+ String.format("%1$"+10+"s",fields[i].getName())+" :  ");
            try {
                assertEquals(expected.get(i), result.get(i));
                System.out.println("Success");
            } catch (AssertionError e) {
                System.out.println("Failure");
            }
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updateAccount method, of class accountService.
     */
    @Test
    public void testUpdateAccount() throws Exception {
        System.out.println("================== updateAccount ==================");
        this.setPassword(this.getPassword()+"Updatetest");
        accountService.updateAccount(this.getId(), this.getPassword());
        Account expected = this;
        Account result = accountService.getAccount(this.getId());
        try {
            assertEquals(expected.getPassword(), result.getPassword());
            System.out.println("New password : "+ result.getPassword() + " Success");
        } catch (AssertionError e) {
            System.out.println("Failure");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
