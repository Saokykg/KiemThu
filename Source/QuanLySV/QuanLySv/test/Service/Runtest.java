/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author jacky
 */
public class Runtest {
    public static void main(String[] args){
        int  a =2021;
        System.out.println(a%100);
        Result rs = JUnitCore.runClasses(TestSuite.class);
        
        for (Failure fl : rs.getFailures()){
            System.out.println(fl.toString());
        }
        
        System.out.println("All test are : "+ rs.wasSuccessful());
    }
}
