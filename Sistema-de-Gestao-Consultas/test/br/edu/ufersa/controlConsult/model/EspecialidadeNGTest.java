/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ufersa.controlConsult.model;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author juan
 */
public class EspecialidadeNGTest {

    public EspecialidadeNGTest() {
    }

    /**
     * Test of findAll method, of class Especialidade.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List expResult = null;
        List result = Especialidade.findAll();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Especialidade.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Especialidade instance = new Especialidade();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Especialidade.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Especialidade instance = new Especialidade();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Especialidade.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Especialidade instance = new Especialidade();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Especialidade.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Especialidade instance = new Especialidade();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedicoList method, of class Especialidade.
     */
    @Test
    public void testGetMedicoList() {
        System.out.println("getMedicoList");
        Especialidade instance = new Especialidade();
        List expResult = null;
        List result = instance.getMedicoList();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedicoList method, of class Especialidade.
     */
    @Test
    public void testSetMedicoList() {
        System.out.println("setMedicoList");
        List<Medico> medicoList = null;
        Especialidade instance = new Especialidade();
        instance.setMedicoList(medicoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Especialidade.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Especialidade instance = new Especialidade();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Especialidade.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Especialidade instance = new Especialidade();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Especialidade.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Especialidade instance = new Especialidade();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class Especialidade.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "";
        List expResult = null;
        List result = Especialidade.findByName(name);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByNome method, of class Especialidade.
     */
    @Test
    public void testFindByNome() {
        System.out.println("findByNome");
        String nome = "";
        List expResult = null;
        List result = Especialidade.findByNome(nome);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}