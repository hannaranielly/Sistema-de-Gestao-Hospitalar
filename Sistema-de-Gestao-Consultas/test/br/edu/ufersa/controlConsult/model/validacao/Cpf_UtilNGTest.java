/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.validacao;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author juan
 */
public class Cpf_UtilNGTest {
    
    public Cpf_UtilNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of isCPF method, of class Cpf_Util.
     */
    @Test
    public void testIsCPF() {
        System.out.println("isCPF");
        String CPF = "";
        boolean expResult = false;
        boolean result = Cpf_Util.isCPF(CPF);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeCPF method, of class Cpf_Util.
     */
    @Test
    public void testImprimeCPF() {
        System.out.println("imprimeCPF");
        String CPF = "";
        String expResult = "";
        String result = Cpf_Util.imprimeCPF(CPF);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
