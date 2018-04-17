/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.gui;

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
public class ConfirmarDataDaConsultaNGTest {
    
    public ConfirmarDataDaConsultaNGTest() {
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
     * Test of main method, of class ConfirmarDataDaConsulta.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ConfirmarDataDaConsulta.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diaSemana method, of class ConfirmarDataDaConsulta.
     */
    @Test
    public void testDiaSemana() {
        System.out.println("diaSemana");
        int n = 0;
        ConfirmarDataDaConsulta instance = new ConfirmarDataDaConsulta();
        String expResult = "";
        String result = instance.diaSemana(n);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
