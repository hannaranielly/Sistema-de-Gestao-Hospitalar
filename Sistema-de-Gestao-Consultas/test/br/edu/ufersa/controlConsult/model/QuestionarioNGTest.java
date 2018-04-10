/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

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
public class QuestionarioNGTest {
    
    public QuestionarioNGTest() {
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
     * Test of getId method, of class Questionario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Questionario instance = new Questionario();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Questionario.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Questionario instance = new Questionario();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedico method, of class Questionario.
     */
    @Test
    public void testGetMedico() {
        System.out.println("getMedico");
        Questionario instance = new Questionario();
        Medico expResult = null;
        Medico result = instance.getMedico();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedico method, of class Questionario.
     */
    @Test
    public void testSetMedico() {
        System.out.println("setMedico");
        Medico medico = null;
        Questionario instance = new Questionario();
        instance.setMedico(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQ1 method, of class Questionario.
     */
    @Test
    public void testGetQ1() {
        System.out.println("getQ1");
        Questionario instance = new Questionario();
        int expResult = 0;
        int result = instance.getQ1();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQ1 method, of class Questionario.
     */
    @Test
    public void testSetQ1() {
        System.out.println("setQ1");
        int q1 = 0;
        Questionario instance = new Questionario();
        instance.setQ1(q1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQ2 method, of class Questionario.
     */
    @Test
    public void testGetQ2() {
        System.out.println("getQ2");
        Questionario instance = new Questionario();
        int expResult = 0;
        int result = instance.getQ2();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQ2 method, of class Questionario.
     */
    @Test
    public void testSetQ2() {
        System.out.println("setQ2");
        int q2 = 0;
        Questionario instance = new Questionario();
        instance.setQ2(q2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQ3 method, of class Questionario.
     */
    @Test
    public void testGetQ3() {
        System.out.println("getQ3");
        Questionario instance = new Questionario();
        int expResult = 0;
        int result = instance.getQ3();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQ3 method, of class Questionario.
     */
    @Test
    public void testSetQ3() {
        System.out.println("setQ3");
        int q3 = 0;
        Questionario instance = new Questionario();
        instance.setQ3(q3);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mediaQ method, of class Questionario.
     */
    @Test
    public void testMediaQ() {
        System.out.println("mediaQ");
        Medico m = null;
        String num = "";
        double expResult = 0.0;
        double result = Questionario.mediaQ(m, num);
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Questionario.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Questionario instance = new Questionario();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class Questionario.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Questionario instance = new Questionario();
        instance.read();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Questionario.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Questionario instance = new Questionario();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Questionario.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Questionario instance = new Questionario();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
