/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas.entidades;

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
public class PacienteNGTest {
    
    public PacienteNGTest() {
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
     * Test of create method, of class Paciente.
     */
   

    /**
     * Test of getNum_sus method, of class Paciente.
     */
    @Test
    public void testGetNum_sus() {
        System.out.println("getNum_sus");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getNum_sus();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNum_sus method, of class Paciente.
     */
    @Test
    public void testSetNum_sus() {
        System.out.println("setNum_sus");
        String num_sus = "";
        Paciente instance = new Paciente();
        instance.setNum_sus(num_sus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
