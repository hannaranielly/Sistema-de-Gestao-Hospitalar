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

    /**
     * Test of hashCode method, of class Paciente.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Paciente instance = new Paciente();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Paciente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Paciente instance = new Paciente();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Paciente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Paciente.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Paciente instance = new Paciente();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class Paciente.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Paciente instance = new Paciente();
        instance.read();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Paciente.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Paciente instance = new Paciente();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Paciente.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Paciente instance = new Paciente();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Paciente.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Paciente instance = new Paciente();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Paciente.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Paciente instance = new Paciente();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPessoa method, of class Paciente.
     */
    @Test
    public void testGetPessoa() {
        System.out.println("getPessoa");
        Paciente instance = new Paciente();
        Pessoa expResult = null;
        Pessoa result = instance.getPessoa();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPessoa method, of class Paciente.
     */
    @Test
    public void testSetPessoa() {
        System.out.println("setPessoa");
        Pessoa pessoa = null;
        Paciente instance = new Paciente();
        instance.setPessoa(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
